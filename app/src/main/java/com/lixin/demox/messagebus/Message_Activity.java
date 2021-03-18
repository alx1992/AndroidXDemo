package com.lixin.demox.messagebus;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.lixin.demox.R;

import org.greenrobot.eventbus.EventBus;

public class Message_Activity extends AppCompatActivity {
    private static final String TAG = "Message_Activity";
    Button mButton ;
    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        mButton = findViewById(R.id.send);
        mTextView = findViewById(R.id.showText);


        LiveDataBus
                .get()
                .getChannel("test_key",String.class)
                .observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mButton.setText(s);
                Log.d(TAG, "onChanged: " + s);
            }
        });

        LiveDataBus
                .get()
                .getChannel("test",String.class)
                .observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mTextView.setText(s);
                Log.d(TAG, "onChanged: " + s);
            }
        });


        mButton.setOnClickListener(v->{
            startActivity(new Intent(this,Message1_Activity.class));
        });
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().register(this);
    }
}
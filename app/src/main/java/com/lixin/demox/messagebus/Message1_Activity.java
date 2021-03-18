package com.lixin.demox.messagebus;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.lixin.demox.R;

public class Message1_Activity extends AppCompatActivity {

    Button mButton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message1_);
        mButton = findViewById(R.id.send);
        mButton.setOnClickListener(v->{
            LiveDataBus.get().getChannel("test_key").setValue("行不行？");
            LiveDataBus.get().getChannel("test").setValue("啥情况？");
            finish();
        });
    }
}
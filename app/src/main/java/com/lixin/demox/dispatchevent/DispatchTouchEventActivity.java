package com.lixin.demox.dispatchevent;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.lixin.demox.R;

/**
 * @author LiXin
 * @date 2018/9/20 22:12
 * MyActivity
 */
public class DispatchTouchEventActivity extends Activity {

    private static final String TAG = "MyActivity======";

    private MyView myView;

    private MyLayout myLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        myView = findViewById(R.id.myview);
        myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "myView onClick");
            }
        });

        myLayout = findViewById(R.id.mylayout);


    }

    /**
     * 覆写Activity的dispatchTouchEvent方法
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent==="+ev.getAction());
//        super.dispatchTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
//        return false;
    }

    /**
     * 覆写Activity的onTouchEvent方法
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent==="+event.getAction());
//         super.onTouchEvent(event);
        return super.onTouchEvent(event);
//        return false;
    }
}

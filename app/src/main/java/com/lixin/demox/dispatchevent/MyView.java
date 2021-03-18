package com.lixin.demox.dispatchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

import org.jetbrains.annotations.Nullable;


/**
 * @author LiXin
 * @date 2018/9/20 17:24
 * MyView
 */
public class MyView extends Button {

    private static final String TAG = "MyView======";

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                Log.d(TAG,"onTouchEvent===ACTION_DOWN");
//                return true;
//            case MotionEvent.ACTION_MOVE:
//                Log.d(TAG,"onTouchEvent===ACTION_MOVE");
//                return false;
//            case MotionEvent.ACTION_UP:
//                Log.d(TAG,"onTouchEvent===ACTION_UP");
//
//        }
//        Log.d(TAG,"onTouchEvent==="+event.getAction());
        Log.d(TAG,"onTouchEvent==="+event.getAction());
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(TAG, "dispatchTouchEvent===="+event.getAction());
        return super.dispatchTouchEvent(event);
    }


}

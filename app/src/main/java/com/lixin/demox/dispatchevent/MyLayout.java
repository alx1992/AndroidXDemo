package com.lixin.demox.dispatchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * @author LiXin
 * @date 2018/9/20 22:11
 * MyLayout
 */
public class MyLayout extends LinearLayout {

    private static final String TAG = "MyLayout======";

    public MyLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        Log.d(TAG,"dispatchTouchEvent==="+ev.getAction());
//        switch (ev.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                Log.d(TAG,"MotionEvent.ACTION_DOWN");
//                return true;
//
//
//            case MotionEvent.ACTION_MOVE:
//                Log.d(TAG,"MotionEvent.ACTION_MOVE");
//
//
//            case MotionEvent.ACTION_UP:
//                Log.d(TAG,"MotionEvent.ACTION_UP");
//
//        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onInterceptTouchEvent==="+ev.getAction());

        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent==="+event.getAction());
        return super.onTouchEvent(event);
    }
}

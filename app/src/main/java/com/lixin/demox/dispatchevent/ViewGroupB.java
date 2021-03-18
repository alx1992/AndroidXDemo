package com.lixin.demox.dispatchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * @author LiXin
 * @date 2018/9/28 10:40
 * ViewGroupB
 */
public class ViewGroupB extends LinearLayout {

    private final static String TAG = "ViewGroupB======";

    public ViewGroupB(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent->"+ev.getAction());
//        Log.d(TAG, "dispatchTouchEvent return->"+String.valueOf(super.dispatchTouchEvent(ev)));
//        switch (ev.getAction()){
//            case MotionEvent.ACTION_DOWN:{
//                Log.d(TAG, "dispatchTouchEvent->ACTION_DOWN");
//                return true;
//            }
//            case MotionEvent.ACTION_UP:{
//                Log.d(TAG, "dispatchTouchEvent->ACTION_UP");
//                return true;
//            }
//            case MotionEvent.ACTION_MOVE:{
//                Log.d(TAG, "dispatchTouchEvent->ACTION_MOVE");
//            }
//            case MotionEvent.ACTION_CANCEL:{
//                Log.d(TAG, "dispatchTouchEvent->ACTION_CANCEL");
//            }
//            default:{
//                Log.d(TAG, "dispatchTouchEvent->default");
//            }
//        }
//        return true;
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onInterceptTouchEvent->"+ev.getAction());
//        Log.d(TAG, "onInterceptTouchEvent return->"+String.valueOf(super.onInterceptTouchEvent(ev)));
//        switch (ev.getAction()){
//            case MotionEvent.ACTION_DOWN:{
//                Log.d(TAG, "onInterceptTouchEvent->ACTION_DOWN");
//                return true;
//            }
//            case MotionEvent.ACTION_UP:{
//                Log.d(TAG, "onInterceptTouchEvent->ACTION_UP");
//
//            }
//            case MotionEvent.ACTION_MOVE:{
//                Log.d(TAG, "onInterceptTouchEvent->ACTION_MOVE");
//            }
//            case MotionEvent.ACTION_CANCEL:{
//                Log.d(TAG, "onInterceptTouchEvent->ACTION_CANCEL");
//            }
//            default:{
//                Log.d(TAG, "onInterceptTouchEvent->default");
//            }
//        }
//        return true;
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onTouchEvent->"+ev.getAction());
//        Log.d(TAG, "onTouchEvent return->"+String.valueOf(super.onTouchEvent(ev)));
//        switch (ev.getAction()){
//            case MotionEvent.ACTION_DOWN:{
//                Log.d(TAG, "onTouchEvent->ACTION_DOWN");
//                return true;
//            }
//            case MotionEvent.ACTION_UP:{
//                Log.d(TAG, "onTouchEvent->ACTION_UP");
//            }
//            case MotionEvent.ACTION_MOVE:{
//                Log.d(TAG, "onTouchEvent->ACTION_MOVE");
//            }
//            case MotionEvent.ACTION_CANCEL:{
//                Log.d(TAG, "onTouchEvent->ACTION_CANCEL");
//            }
//            default:{
//                Log.d(TAG, "onTouchEvent->default");
//            }
//        }
//        return true;
        return super.onTouchEvent(ev);
    }
}

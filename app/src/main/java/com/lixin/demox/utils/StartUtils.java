package com.lixin.demox.utils;

import android.content.ComponentName;
import android.content.Intent;

import com.blankj.utilcode.util.LogUtils;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

/**
 * 启动工具类
 */
public class StartUtils {
    private static final String TAG = "StartUtils";
    public static void startSpecificActivity(String pkg,String cls){
        try {
            Intent intent = new Intent();
            //第一种方式
            ComponentName cn = new ComponentName(pkg, cls);
            intent.setComponent(cn);
            //第二种方式
            //intent.setClassName(pkg, cls);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (Exception e) {
            LogUtils.eTag(TAG,"启动指定的Activity异常，" + e.getMessage());
        }
    }
}

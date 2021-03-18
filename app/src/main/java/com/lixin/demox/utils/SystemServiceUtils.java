package com.lixin.demox.utils;

import android.app.Service;
import android.content.Context;
import android.media.AudioManager;
import android.telephony.TelephonyManager;
import android.view.WindowManager;

import androidx.annotation.NonNull;

public class SystemServiceUtils {
    /**
     * 获取音频管理器
     * @param context
     * @return 音频管理器
     */
    public static AudioManager getAudioManager(@NonNull Context context) {
        return (AudioManager) context.getSystemService(Service.AUDIO_SERVICE);
    }

    /**
     * 获取电话管理器
     * @param context
     * @return 电话管理器
     */
    public static TelephonyManager getTelephonyManager(@NonNull Context context) {
        return (TelephonyManager) context.getSystemService(Service.TELEPHONY_SERVICE);
    }

    /**
     * 获取窗口管理器
     * @param context
     * @return 窗口管理器
     */
    public static WindowManager getWindowManager(@NonNull Context context) {
        return (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    }
}

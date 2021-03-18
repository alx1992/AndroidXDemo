package com.lixin.demox.remoteview;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.LogUtils;
import com.lixin.demox.R;

import org.greenrobot.eventbus.EventBus;


/**
 * @author Huanglinqing
 */
public class RemoteViewActivity extends AppCompatActivity {
    private static final String TAG = "RemoteView";
    private Chronometer chronometer;
    private boolean hasBind = false;
    private long rangeTime;
    private ServiceConnection mVideoServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // 获取服务的操作对象
            FloatWinfowServices.MyBinder binder = (FloatWinfowServices.MyBinder) service;
            binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote);
        //
        EventBus.getDefault().postSticky(new Event(1));
    }

    /**
     * 缩小
     * @param v
     */
    public void zoom(View v) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                Toast.makeText(this, "当前无权限，请授权", Toast.LENGTH_SHORT);
                new GlobalDialogSingle(this, "", "当前未获取悬浮窗权限",
                        "去开启", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                                Uri.parse("package:" + getPackageName()));
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivityForResult(intent, 0);
                    }
                }).show();
            } else {
                bindFloatWindowService();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!Settings.canDrawOverlays(this)) {
                    Toast.makeText(this, "授权失败", Toast.LENGTH_SHORT).show();
                } else {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            bindFloatWindowService();
                        }
                    }, 1000);
                }
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.eTag("RemoteView", "RemoteView重新显示了");
        bindFloatWindowService();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.eTag("RemoteView", "RemoteView重新显示了");
        unBindFloatWindowService();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.eTag("RemoteView", "RemoteView被销毁");
        unBindFloatWindowService();
    }
    /**
     * 绑定 悬浮窗 服务
     */
    private void bindFloatWindowService() {
        Intent intent = new Intent(RemoteViewActivity.this, FloatWinfowServices.class);
        intent.putExtra("rangeTime", rangeTime);
        hasBind = bindService(intent, mVideoServiceConnection, Context.BIND_AUTO_CREATE);
        moveTaskToBack(true);
    }
    /**
     * 解绑 service
     */
    private void unBindFloatWindowService() {
        //不显示悬浮框
        if (hasBind){
            unbindService(mVideoServiceConnection);
            hasBind = false;
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogUtils.eTag("RemoteView", "重新显示了onNewIntent");
    }


}

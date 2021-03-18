package com.lixin.demox.utils;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

import com.blankj.utilcode.util.LogUtils;

public class IOSAlertDialogUtils {
    private static final String TAG = "IOSAlertDialogUtils";

    /**
     * iosDialog实例
     */
    private static IOSAlertDialog iosOnlyBtnDialog = null;
    private static IOSAlertDialog iosDoubleBtnDialog = null;
    private static IOSAlertDialog iosXmlDialog = null;

    /**
     * 移除dialog
     */
    private static void removeIosOnlyBtnDialog() {
        if (iosOnlyBtnDialog != null && iosOnlyBtnDialog.isShowing()) {
            iosOnlyBtnDialog.dismiss();
        }
        iosOnlyBtnDialog = null;
    }

    private static void removeIosDoubleBtnDialog() {
        if (iosDoubleBtnDialog != null && iosDoubleBtnDialog.isShowing()) {
            iosDoubleBtnDialog.dismiss();
        }
        iosDoubleBtnDialog = null;
    }

    /**
     * 移除xmldialog
     */
    private static void removeIOSXmlDialog() {
        if (iosXmlDialog != null && iosXmlDialog.isShowing()) {
            iosXmlDialog.dismiss();
        }
        iosXmlDialog = null;
    }

    /**
     * 移除所有iosDialog
     */
    public static void removeAllDialog() {
        removeIOSXmlDialog();
        removeIosOnlyBtnDialog();
        removeIosDoubleBtnDialog();
        LogUtils.dTag(TAG, "移除所有dialog");
    }

    private static void removeOtherDialog(IOSAlertDialog dialog) {
        if (dialog == iosOnlyBtnDialog) {
            removeIosDoubleBtnDialog();
            removeIOSXmlDialog();
        } else if (dialog == iosDoubleBtnDialog) {
            removeIOSXmlDialog();
            removeIosOnlyBtnDialog();
        } else if (dialog == iosXmlDialog) {
            removeIosOnlyBtnDialog();
            removeIosDoubleBtnDialog();
        }
    }

    /**
     * 确认取消对自定义按钮(双)文字话框
     *
     * @param activity             所在页面
     * @param title                标题
     * @param message              内容
     * @param firstBtnText 第一个按钮的文字
     * @param secondBtnText   第二个按钮的文字
     * @param callBack             确认、取消按钮回调
     */
    public static void dialogBuilder(Activity activity, String title, String message, String firstBtnText,
            String secondBtnText, final DialogCallBackDouble callBack) {

        if (!activity.isFinishing()) {
            if (iosDoubleBtnDialog == null) {
                iosDoubleBtnDialog = new IOSAlertDialog(activity).builder().setCancelable(false).setMessage(message)
                        .setTitle(title).setFirstButton(firstBtnText, new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                if (callBack != null) {
                                    callBack.onFirstBtnClick();
                                }

                            }
                        }).setSecondButton(secondBtnText, new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                if (callBack != null) {
                                    callBack.onSecondBtnClick();
                                }
                            }
                        });
                iosDoubleBtnDialog.show();
            } else {
                notifyDoubleButtonDialog(iosDoubleBtnDialog, title, message, firstBtnText, secondBtnText, callBack);
            }
        }
    }

    private static void notifyDoubleButtonDialog(IOSAlertDialog dialog, String title, String msg, String firstBtnText,
            String secondBtnText, final DialogCallBackDouble callBackDouble) {
        removeOtherDialog(dialog);
        dialog.setMessage(msg).setTitle(title).setFirstButton(firstBtnText, new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBackDouble != null) {
                    callBackDouble.onFirstBtnClick();
                }
            }
        }).setSecondButton(secondBtnText, new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBackDouble != null) {
                    callBackDouble.onSecondBtnClick();
                }
            }
        });
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }

    /**
     * 确认取消对自定义按钮(单)文字话框
     *
     * @param activity 所在页面
     * @param title    标题
     * @param message  内容
     * @param callBack 确认、取消按钮回调
     */
    public static void dialogBuilder(Activity activity, String title, String message, String buttonText,
            final DialogCallBackOnly callBack) {

        if (!activity.isFinishing()) {
            if (iosOnlyBtnDialog == null) {
                iosOnlyBtnDialog = new IOSAlertDialog(activity).builder().setCancelable(false).setMessage(message)
                        .setTitle(title).setFirstButton(buttonText, new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                if (callBack != null) {
                                    callBack.onClick();
                                }
                            }
                        });
                iosOnlyBtnDialog.show();
            } else {
                notifyOnlyButtonDialog(iosOnlyBtnDialog, title, message, buttonText, callBack);
            }
        }
    }

    /**
     * 更新单个按钮的dialog
     * @param dialog
     * @param title
     * @param msg
     * @param btnText
     * @param callBackOnly
     */
    private static void notifyOnlyButtonDialog(IOSAlertDialog dialog, String title, String msg, String btnText,
            final DialogCallBackOnly callBackOnly) {
        removeOtherDialog(dialog);
        dialog.setMessage(msg).setTitle(title).setFirstButton(btnText, new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBackOnly != null) {
                    callBackOnly.onClick();
                }
            }
        });
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }

    /**
     * 断线重连xml 显示progressbar
     *
     * @param activity 所在页面
     * @param title    标题
     * @param message  内容
     * @param callBack 确认、取消按钮回调
     */
    public static void dialogXmlBuilder(Activity activity, String title, String message, String btnText,
            final DialogCallBackOnly callBack) {

        if (!activity.isFinishing()) {
            if (iosXmlDialog == null) {
                iosXmlDialog = new IOSAlertDialog(activity).builder().setCancelable(false).setMessage(message)
                        .setTitle(title).setProgressBarVisible(true).setFirstButton(btnText, new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                if (callBack != null) {
                                    callBack.onClick();
                                }
                            }
                        });
                iosXmlDialog.show();
            } else {
                notifyOnlyButtonXmlDialog(iosXmlDialog, title, message, btnText, callBack);
            }
        }
    }

    /**
     * 更新单个按钮的dialog
     * @param dialog
     * @param title
     * @param msg
     * @param btnText
     * @param callBackOnly
     */
    private static void notifyOnlyButtonXmlDialog(IOSAlertDialog dialog, String title, String msg, String btnText,
            final DialogCallBackOnly callBackOnly) {
        removeOtherDialog(dialog);
        dialog.setMessage(msg).setTitle(title).setFirstButton(btnText, new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBackOnly != null) {
                    callBackOnly.onClick();
                }
            }
        });
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }

    /**
     * 对话框回调(双)
     *
     * @author JYcainiao
     */
    public interface DialogCallBackDouble {
        /**
         * 确认
         */
        void onFirstBtnClick();

        /**
         * 取消
         */
        void onSecondBtnClick();
    }

    /**
     * 对话框回调(单)
     *
     * @author JYcainiao
     */
    public interface DialogCallBackOnly {
        /**
         * 确认
         */
        void onClick();
    }
}

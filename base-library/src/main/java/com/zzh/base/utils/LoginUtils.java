package com.zzh.base.utils;

import android.app.Activity;

import com.blankj.utilcode.util.LogUtils;

/**
 * 车主邦
 * ---------------------------
 * <p>
 * Created by zhaozh on 2020/8/11.
 */
public class LoginUtils {

    public static void toLoginAct(Activity activity) {
        if (activity == null) {
            LogUtils.e("activity must not be null");
            return;
        }
    }
}

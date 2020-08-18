package com.zzh.base.route;

import android.text.TextUtils;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.HashMap;

/**
 * 车主邦
 * ---------------------------
 * <p>
 * Created by zhaozh on 2020/8/11.
 * 路由的跳转工具类
 */
public class RouterJumpUtils {

    public static void navigation(String path) {
        navigation(path, null);
    }

    public static void navigation(String path, HashMap<String, String> params) {
        Postcard build = ARouter
                .getInstance()
                .build(path);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(params.get(key))) {
                    build.withString(key, params.get(key));
                }
            }
        }
        build.navigation();
    }
}

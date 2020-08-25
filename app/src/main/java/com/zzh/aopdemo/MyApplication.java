package com.zzh.aopdemo;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;

/**
 * 车主邦
 * ---------------------------
 * <p>
 * Created by zhaozh on 2020/8/11.
 */
public class MyApplication extends Application {
    public static boolean isDebug = true;
    public static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        if (isDebug) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(instance); // 尽可能早，推荐在Application中初始化

        LogUtils.getConfig().setGlobalTag("Alog");
    }
}

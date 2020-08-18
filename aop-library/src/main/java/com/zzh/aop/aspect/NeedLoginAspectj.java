package com.zzh.aop.aspect;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.zzh.base._Login;
import com.zzh.base.route.ConstantRouter;
import com.zzh.base.route.RouterJumpUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 车主邦
 * ---------------------------
 * <p>
 * Created by zhaozh on 2020/8/11.
 * 需要登录的切面
 */
@Aspect
public class NeedLoginAspectj {

//    @Pointcut("@annotion(com.zzh.aop.aspectannotation.NeedLogin)")
    @Pointcut("execution(@com.zzh.aop.aspectannotation.NeedLogin * *(..))")
    public void needLoginPoint() {
    }

    @Around("needLoginPoint()")
    public void needLoginWave(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        if (_Login.isLogin) {
            LogUtils.e("处于登录状态,继续执行");
            proceedingJoinPoint.proceed();
        } else {
            ToastUtils.showShort("您尚未登录,请登录后再进入");
            RouterJumpUtils.navigation(ConstantRouter.LOGIN.LOGIN_HOME);
        }
    }
}

package com.zzh.aop.aspect;

import com.blankj.utilcode.util.LogUtils;
import com.zzh.aop.aspectannotation.SingleClick;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Random;

/**
 * 车主邦
 * ---------------------------
 * <p>
 * Created by zhaozh on 2020/8/25.
 */
@Aspect
public class SingleClickAspect {
    private Random random = new Random();

    @Pointcut("execution(@com.zzh.aop.aspectannotation.SingleClick * *(..))")
    public void onSingleClick() {
    }

    @Around("onSingleClick()")
    public void aroundSingClick(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        if (signature instanceof MethodSignature) {
            MethodSignature methodSignature = (MethodSignature) signature;
            SingleClick singleClick = methodSignature.getMethod().getAnnotation(SingleClick.class);
            long intervalTime = singleClick.clickIntervalTime();
            int useTime = random.nextInt(5000);
            LogUtils.e("useTime = " + useTime + " and intervalTime = " + intervalTime);
            if (useTime >= intervalTime) {
                LogUtils.e("useTime >= intervalTime 继续执行");
                joinPoint.proceed();
            } else {
                LogUtils.e("useTime < intervalTime 无法执行");
            }
        }
    }

}

package com.zzh.aop.aspect;

import com.blankj.utilcode.util.LogUtils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 车主邦
 * ---------------------------
 * <p>
 * Created by zhaozh on 2020/8/25.
 */
@Aspect
public class AutoLogAspect {

    @Pointcut("execution(@com.zzh.aop.aspectannotation.AutoLog * *(..))")
    public void needAutoLog() {
    }


    @Before("needAutoLog()")
    public void beforeAutoLog(JoinPoint joinPoint) throws Throwable {
        LogUtils.e("方法内部之前自动添加log");
    }

}

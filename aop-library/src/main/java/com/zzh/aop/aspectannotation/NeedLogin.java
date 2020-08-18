package com.zzh.aop.aspectannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 车主邦
 * ---------------------------
 * <p>
 * Created by zhaozh on 2020/8/11.
 *
 * 接口,只能作用在方法上, 如果未登录直接跳转登录界面
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NeedLogin {
}

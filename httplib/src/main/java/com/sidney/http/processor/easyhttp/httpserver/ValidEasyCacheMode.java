package com.sidney.http.processor.easyhttp.httpserver;

import com.sidney.http.processor.easyhttp.httpserver.EasyCacheMode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 描 述：默认的缓存方式 注解约束
 * 作 者：hxl 2022/1/19 17:03
 * 修改描述： XXX
 * 修 改 人： XXX  2022/1/19 17:03
 * 修改版本： XXX
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEasyCacheMode {

    //校验的属性的类型
    EasyCacheMode value() default EasyCacheMode.DEFAULT;
}

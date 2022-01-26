package com.sidney.http.processor.easyhttp.httpserver;

import com.sidney.http.processor.easyhttp.httpserver.EasyBodyType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 描 述：参数提交方式 注解约束
 * 作 者：hxl 2022/1/19 16:40
 * 修改描述： XXX
 * 修 改 人： XXX  2022/1/19 16:40
 * 修改版本： XXX
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEasyBodyType {

    //校验的属性的类型
    EasyBodyType value() default EasyBodyType.FORM;
}

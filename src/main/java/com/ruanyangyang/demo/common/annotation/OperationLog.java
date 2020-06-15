package com.ruanyangyang.demo.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OperationLog {
    /**
     * 方法名
     *
     * @return
     */
    String method();

    /**
     * 功能模块
     *
     * @return
     */
    String module();
}

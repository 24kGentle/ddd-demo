package com.wy.ddd.infrastructure.annotation;

import java.lang.annotation.*;

/**
 * @author wangyang
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogId {
    String value() default "";
}
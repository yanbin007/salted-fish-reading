package com.saltedfish.reading.framework.annotation;

import java.lang.annotation.*;

/**
 * Created by yanbin on 2019/8/10.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TokenValidate {
}

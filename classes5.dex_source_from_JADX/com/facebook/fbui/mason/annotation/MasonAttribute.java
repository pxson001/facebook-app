package com.facebook.fbui.mason.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* compiled from: required */
public @interface MasonAttribute {
    Class parameterType() default Object.class;

    Class type();
}

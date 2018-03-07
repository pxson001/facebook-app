package com.facebook.mixin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* compiled from: text_slot */
public @interface Mixin {
    Class<?> inModule();

    String package_name() default "";
}

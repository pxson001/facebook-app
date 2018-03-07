package com.facebook.components.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* compiled from: setInterceptWords */
public @interface LayoutSpec {
    String value() default "";
}

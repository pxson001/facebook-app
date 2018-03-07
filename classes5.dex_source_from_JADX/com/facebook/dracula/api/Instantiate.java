package com.facebook.dracula.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
/* compiled from: satellite */
public @interface Instantiate {
    Class<?> implementation() default UninitializedDefaultSentinel.class;

    Class<?> wrapper() default UninitializedDefaultSentinel.class;
}

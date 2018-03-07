package com.facebook.dracula.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
/* compiled from: savedTitle */
public @interface FlatInterface {
    Class<?> implementation() default UninitializedDefaultSentinel.class;

    Class<?> wrapper() default UninitializedDefaultSentinel.class;
}

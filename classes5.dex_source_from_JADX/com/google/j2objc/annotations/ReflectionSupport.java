package com.google.j2objc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.PACKAGE})
@Retention(RetentionPolicy.SOURCE)
/* compiled from: bucket */
public @interface ReflectionSupport {

    /* compiled from: bucket */
    public enum Level {
        NATIVE_ONLY,
        FULL
    }

    Level value();
}

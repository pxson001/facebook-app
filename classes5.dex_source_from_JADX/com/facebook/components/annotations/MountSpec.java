package com.facebook.components.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* compiled from: setHasFaceboxes */
public @interface MountSpec {
    String value() default "";
}

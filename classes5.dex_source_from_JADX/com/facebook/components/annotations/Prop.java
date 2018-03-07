package com.facebook.components.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* compiled from: services */
public @interface Prop {
    String docString() default "";

    ResType resType() default ResType.NONE;
}

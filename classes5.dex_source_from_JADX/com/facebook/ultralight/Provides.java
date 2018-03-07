package com.facebook.ultralight;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* compiled from: comment_draft_posted */
public @interface Provides {

    /* compiled from: comment_draft_posted */
    public enum Type {
        SET,
        SET_VALUES,
        UNIQUE
    }

    Type value() default Type.UNIQUE;
}

package com.facebook.abtest.qe.bootstrap.autoqe;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* compiled from: translated_message_for_viewer */
public @interface AutoQEBuiltInParam {
    String paramName();
}

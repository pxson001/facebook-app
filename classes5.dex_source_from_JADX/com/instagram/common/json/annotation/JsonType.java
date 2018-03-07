package com.instagram.common.json.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* compiled from: browse_feedback */
public @interface JsonType {

    /* compiled from: browse_feedback */
    public enum TriState {
        DEFAULT,
        YES,
        NO
    }

    TriState generateSerializer() default TriState.DEFAULT;

    String valueExtractFormatter() default "${subobject_helper_class}.parseFromJson(${parser_object})";
}

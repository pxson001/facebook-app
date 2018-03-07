package com.instagram.common.json.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
/* compiled from: browse_feedback_combined_dialog */
public @interface JsonField {

    /* compiled from: browse_feedback_combined_dialog */
    public enum TypeMapping {
        EXACT,
        COERCED
    }

    String fieldAssignmentFormatter() default "";

    String fieldName();

    TypeMapping mapping() default TypeMapping.COERCED;

    String serializeCodeFormatter() default "";

    String valueExtractFormatter() default "";
}

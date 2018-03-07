package com.google.inject.name;

import com.google.inject.BindingAnnotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@BindingAnnotation
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: bugReportUpload */
public @interface Named {
    String value();
}

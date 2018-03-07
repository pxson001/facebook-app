package com.fasterxml.jackson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: columnNr */
public @interface JsonSubTypes {

    /* compiled from: columnNr */
    public @interface Type {
        String name() default "";

        Class<?> value();
    }

    Type[] m10736a();
}

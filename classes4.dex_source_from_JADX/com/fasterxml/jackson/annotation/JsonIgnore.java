package com.fasterxml.jackson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: video_error_sampling */
public @interface JsonIgnore {
    boolean m381a() default true;
}

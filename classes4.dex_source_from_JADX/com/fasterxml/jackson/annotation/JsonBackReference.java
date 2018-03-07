package com.fasterxml.jackson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD})
@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: video_channel_curator_profile */
public @interface JsonBackReference {
    String value() default "defaultReference";
}

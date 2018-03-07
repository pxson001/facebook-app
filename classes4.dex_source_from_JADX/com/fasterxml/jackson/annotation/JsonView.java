package com.fasterxml.jackson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: video_home_max_badge_count */
public @interface JsonView {
    Class<?>[] m375a() default {};
}

package com.fasterxml.jackson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: video_broadcast_is_live_scribe_tool_tip_shown */
public @interface JsonAnyGetter {
}

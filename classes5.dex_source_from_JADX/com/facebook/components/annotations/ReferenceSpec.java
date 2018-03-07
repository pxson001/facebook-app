package com.facebook.components.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* compiled from: service_connection_start_time_millis */
public @interface ReferenceSpec {
    String value() default "";
}

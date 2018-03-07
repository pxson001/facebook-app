package com.facebook.components.fallback.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* compiled from: creativecam_capture_photo_confirmed */
public @interface FallbackSpec {
    Class mountType();

    String value() default "";
}

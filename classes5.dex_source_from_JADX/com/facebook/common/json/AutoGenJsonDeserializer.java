package com.facebook.common.json;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* compiled from: socialWifiItems */
public @interface AutoGenJsonDeserializer {
    String baseDeserializer() default "";
}
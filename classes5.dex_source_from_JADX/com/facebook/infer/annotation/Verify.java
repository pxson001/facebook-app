package com.facebook.infer.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PACKAGE, ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* compiled from: device_radio_power */
public @interface Verify {
}

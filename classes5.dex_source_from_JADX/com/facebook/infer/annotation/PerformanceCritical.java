package com.facebook.infer.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* compiled from: dialtone?ref={%s}&action={%s}&follow_up_intent={%s} */
public @interface PerformanceCritical {
}

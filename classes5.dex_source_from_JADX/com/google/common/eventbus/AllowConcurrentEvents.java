package com.google.common.eventbus;

import com.google.common.annotations.Beta;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Beta
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: bug_report_failed_exceeded_retries */
public @interface AllowConcurrentEvents {
}
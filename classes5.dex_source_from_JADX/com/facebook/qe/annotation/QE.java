package com.facebook.qe.annotation;

import com.facebook.inject.Module;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
/* compiled from: dashboard_header */
public @interface QE {
    Class<? extends Module> inModule();

    String name();
}

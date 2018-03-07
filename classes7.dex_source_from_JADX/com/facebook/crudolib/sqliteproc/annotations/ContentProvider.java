package com.facebook.crudolib.sqliteproc.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* compiled from: carrier_manager?ref=internal_settings */
public @interface ContentProvider {
    String authority();
}

package com.facebook.crudolib.sqliteproc.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* compiled from: captionKey */
public @interface Join {
    String onRaw() default "";

    JoinType type();

    Class<?> with();
}

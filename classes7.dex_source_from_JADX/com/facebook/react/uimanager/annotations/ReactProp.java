package com.facebook.react.uimanager.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.annotation.Nullable;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: formatted_price */
public @interface ReactProp {
    double m14123a() default 0.0d;

    float m14124b() default 0.0f;

    int m14125c() default 0;

    @Nullable
    String customType() default "__default_type__";

    boolean m14126d() default false;

    String name();
}

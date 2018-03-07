package com.facebook.react.uimanager.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.annotation.Nullable;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: formatted_preview */
public @interface ReactPropGroup {
    String[] m14127a();

    float m14128b() default 0.0f;

    double m14129c() default 0.0d;

    @Nullable
    String customType() default "__default_type__";

    int m14130d() default 0;
}

package com.facebook.crudolib.urimap;

import com.facebook.common.componentmap.ComponentMapType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
/* compiled from: open_profile */
public @interface UriPattern {
    ComponentMapType componentType() default ComponentMapType.NONE;

    String pattern();

    UriScheme scheme() default UriScheme.NONE;

    String template() default "";
}

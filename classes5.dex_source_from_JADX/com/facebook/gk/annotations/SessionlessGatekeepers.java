package com.facebook.gk.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
/* compiled from: removeView(View) is not supported in AdapterView */
public @interface SessionlessGatekeepers {
}

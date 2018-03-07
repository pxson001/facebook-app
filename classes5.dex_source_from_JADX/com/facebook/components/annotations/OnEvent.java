package com.facebook.components.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* compiled from: setExclusiveCheckable */
public @interface OnEvent {
    Class<?> value();
}

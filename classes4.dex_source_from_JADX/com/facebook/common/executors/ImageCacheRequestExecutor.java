package com.facebook.common.executors;

import com.facebook.inject.TargetType;
import com.google.inject.BindingAnnotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@TargetType
@BindingAnnotation
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: endpoint_capabilities */
public @interface ImageCacheRequestExecutor {
}

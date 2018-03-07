package com.facebook.announceable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* compiled from: template_images */
public @interface ThreadAssert {

    /* compiled from: template_images */
    public enum RequiredThread {
        ANY,
        UI_THREAD
    }

    RequiredThread requiredThread() default RequiredThread.ANY;
}

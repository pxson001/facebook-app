package com.facebook.common.appstate.dispatcher;

import com.facebook.metagen.CodeGeneratorMetadataAnnotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@CodeGeneratorMetadataAnnotation(generator = "com.facebook.metagen.generator.mustache.MustacheCodeGenerator")
@Retention(RetentionPolicy.SOURCE)
/* compiled from: story_save_type */
public @interface AppStateChangeListener {

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: story_save_type */
    public @interface OnUserEnteredApp {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: story_save_type */
    public @interface OnUserLeftApp {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: story_save_type */
    public @interface OnUserMaybeBecameActiveOrInactiveInApp {
    }
}

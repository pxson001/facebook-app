package com.facebook.katana.app.module.common;

import com.facebook.common.build.BuildConstants;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: serialized_optimistic_model */
public class String_AppNameInUserAgentMethodAutoProvider extends AbstractProvider<String> {
    public static String m9472a(InjectorLike injectorLike) {
        return BuildConstants.h;
    }

    public Object get() {
        return BuildConstants.h;
    }
}

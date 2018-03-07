package com.facebook.auth.module;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: tuzi_www_post_intercept */
public class String_LoggedInUserIdMethodAutoProvider extends AbstractProvider<String> {
    public static String m4329b(InjectorLike injectorLike) {
        return LoggedInUserModule.m2894a(ViewerContextManagerProvider.m2496b(injectorLike));
    }

    public Object get() {
        return LoggedInUserModule.m2894a(ViewerContextManagerProvider.m2496b(this));
    }

    public static String m4328a(InjectorLike injectorLike) {
        return m4329b(injectorLike);
    }
}

package com.facebook.auth.module;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: thread_users */
public class String_ViewerContextUserIdMethodAutoProvider extends AbstractProvider<String> {
    public static String m5004b(InjectorLike injectorLike) {
        return LoggedInUserModule.m2893a(ViewerContextMethodAutoProvider.m5006b(injectorLike));
    }

    public Object get() {
        return LoggedInUserModule.m2893a(ViewerContextMethodAutoProvider.m5006b(this));
    }

    public static String m5003a(InjectorLike injectorLike) {
        return m5004b(injectorLike);
    }
}

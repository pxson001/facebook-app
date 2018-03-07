package com.facebook.auth.module;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: thread_tracking */
public class ViewerContextMethodAutoProvider extends AbstractProvider<ViewerContext> {
    public static ViewerContext m5006b(InjectorLike injectorLike) {
        return LoggedInUserModule.m2895b(ViewerContextManagerProvider.m2496b(injectorLike));
    }

    public Object get() {
        return LoggedInUserModule.m2895b(ViewerContextManagerProvider.m2496b(this));
    }

    public static ViewerContext m5005a(InjectorLike injectorLike) {
        return m5006b(injectorLike);
    }
}

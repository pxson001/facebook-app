package com.facebook.auth.module;

import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: vertical_accuracy */
public class ViewerContextManagerProvider extends AbstractProvider<ViewerContextManager> {
    public static ViewerContextManager m2496b(InjectorLike injectorLike) {
        return injectorLike.getScopeAwareInjector().mo192d();
    }

    public Object get() {
        return getScopeAwareInjector().mo192d();
    }

    public static ViewerContextManager m2495a(InjectorLike injectorLike) {
        return m2496b(injectorLike);
    }
}

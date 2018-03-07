package com.facebook.auth.module;

import android.content.Context;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

/* compiled from: submit_suggestifier_answer */
public class C0221xc6799c06 extends AbstractProvider<ViewerContextManager> {
    private static ViewerContextManager f3941a;
    private static final Object f3942b = new Object();

    private static ViewerContextManager m6538b(InjectorLike injectorLike) {
        return LoggedInUserModule.m2896b(LoggedInUserSessionManager.m2511a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return LoggedInUserModule.m2896b(LoggedInUserSessionManager.m2511a((InjectorLike) this), (Context) getInstance(Context.class));
    }

    public static ViewerContextManager m6537a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ViewerContextManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f3942b) {
                ViewerContextManager viewerContextManager;
                if (a2 != null) {
                    viewerContextManager = (ViewerContextManager) a2.mo818a(f3942b);
                } else {
                    viewerContextManager = f3941a;
                }
                if (viewerContextManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = C0221xc6799c06.m6538b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f3942b, b3);
                        } else {
                            f3941a = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = viewerContextManager;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}

package com.facebook.video.channelfeed;

import android.content.Context;
import com.facebook.common.activitylistener.ActivityListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

@ContextScoped
/* compiled from: text/* */
public class ActivityListenerDispatcher {
    private static ActivityListenerDispatcher f2081b;
    private static final Object f2082c = new Object();
    private final List<WeakReference<ActivityListener>> f2083a = new LinkedList();

    private static ActivityListenerDispatcher m2095a() {
        return new ActivityListenerDispatcher();
    }

    public static ActivityListenerDispatcher m2096a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ActivityListenerDispatcher a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f2082c) {
                ActivityListenerDispatcher activityListenerDispatcher;
                if (a3 != null) {
                    activityListenerDispatcher = (ActivityListenerDispatcher) a3.a(f2082c);
                } else {
                    activityListenerDispatcher = f2081b;
                }
                if (activityListenerDispatcher == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m2095a();
                        if (a3 != null) {
                            a3.a(f2082c, a2);
                        } else {
                            f2081b = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = activityListenerDispatcher;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}

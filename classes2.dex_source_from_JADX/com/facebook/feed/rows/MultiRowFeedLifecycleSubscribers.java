package com.facebook.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.ui.FeedLifecycleSubscribers;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: popup/ */
public class MultiRowFeedLifecycleSubscribers implements FeedLifecycleSubscribers {
    private static MultiRowFeedLifecycleSubscribers f9466b;
    private static final Object f9467c = new Object();
    private final Lazy<LikeProcessor> f9468a;

    private static MultiRowFeedLifecycleSubscribers m14464b(InjectorLike injectorLike) {
        return new MultiRowFeedLifecycleSubscribers(IdBasedSingletonScopeProvider.m1810b(injectorLike, 1477));
    }

    @Inject
    public MultiRowFeedLifecycleSubscribers(Lazy<LikeProcessor> lazy) {
        this.f9468a = lazy;
    }

    public final void mo1939a() {
        ((LikeProcessor) this.f9468a.get()).m20257a();
    }

    public static MultiRowFeedLifecycleSubscribers m14463a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MultiRowFeedLifecycleSubscribers b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f9467c) {
                MultiRowFeedLifecycleSubscribers multiRowFeedLifecycleSubscribers;
                if (a2 != null) {
                    multiRowFeedLifecycleSubscribers = (MultiRowFeedLifecycleSubscribers) a2.mo818a(f9467c);
                } else {
                    multiRowFeedLifecycleSubscribers = f9466b;
                }
                if (multiRowFeedLifecycleSubscribers == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m14464b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f9467c, b3);
                        } else {
                            f9466b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = multiRowFeedLifecycleSubscribers;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}

package com.facebook.timeline.header;

import android.content.Context;
import com.facebook.common.locale.Locales;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.timeline.publisher.utils.OpenPublisherListenerHelper;
import com.facebook.user.model.User;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: friends_center_requests_tab_impression */
public class TimelineHeaderComposerBinder {
    private static TimelineHeaderComposerBinder f11355d;
    private static final Object f11356e = new Object();
    public final Provider<User> f11357a;
    public final Locales f11358b;
    public final OpenPublisherListenerHelper f11359c;

    private static TimelineHeaderComposerBinder m11426b(InjectorLike injectorLike) {
        return new TimelineHeaderComposerBinder(IdBasedProvider.a(injectorLike, 3595), Locales.a(injectorLike), OpenPublisherListenerHelper.m12486a(injectorLike));
    }

    @Inject
    public TimelineHeaderComposerBinder(Provider<User> provider, Locales locales, OpenPublisherListenerHelper openPublisherListenerHelper) {
        this.f11357a = provider;
        this.f11358b = locales;
        this.f11359c = openPublisherListenerHelper;
    }

    public static TimelineHeaderComposerBinder m11425a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineHeaderComposerBinder b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11356e) {
                TimelineHeaderComposerBinder timelineHeaderComposerBinder;
                if (a2 != null) {
                    timelineHeaderComposerBinder = (TimelineHeaderComposerBinder) a2.a(f11356e);
                } else {
                    timelineHeaderComposerBinder = f11355d;
                }
                if (timelineHeaderComposerBinder == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11426b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11356e, b3);
                        } else {
                            f11355d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineHeaderComposerBinder;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

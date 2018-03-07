package com.facebook.timeline.viewfeaturedcontainers.data;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLInterfaces.FeaturedContainerEdge;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;

@ContextScoped
/* compiled from: extra_events_discovery_fragment_subtitle */
public class FeaturedContainersHeaderData {
    private static FeaturedContainersHeaderData f12833d;
    private static final Object f12834e = new Object();
    @LoadingState
    public int f12835a = 0;
    public ImmutableList<? extends FeaturedContainerEdge> f12836b = RegularImmutableList.a;
    public int f12837c = 1;

    /* compiled from: extra_events_discovery_fragment_subtitle */
    public @interface LoadingState {
    }

    private static FeaturedContainersHeaderData m12780f() {
        return new FeaturedContainersHeaderData();
    }

    public final boolean m12781a() {
        return this.f12835a == 3;
    }

    public static FeaturedContainersHeaderData m12779a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeaturedContainersHeaderData f;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12834e) {
                FeaturedContainersHeaderData featuredContainersHeaderData;
                if (a2 != null) {
                    featuredContainersHeaderData = (FeaturedContainersHeaderData) a2.a(f12834e);
                } else {
                    featuredContainersHeaderData = f12833d;
                }
                if (featuredContainersHeaderData == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        f = m12780f();
                        if (a2 != null) {
                            a2.a(f12834e, f);
                        } else {
                            f12833d = f;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    f = featuredContainersHeaderData;
                }
            }
            return f;
        } finally {
            a.c(b);
        }
    }
}

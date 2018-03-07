package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools$SynchronizedPool;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;

@ContextScoped
/* compiled from: http/ */
public class HeaderWithSeeFirstComponent<E extends HasFeedListType & HasInvalidate & HasMenuButtonProvider & HasPersistentState & HasPrefetcher & HasRowKey & HasContext> extends ComponentLifecycle {
    private static HeaderWithSeeFirstComponent f20767d;
    private static final Object f20768e = new Object();
    private final HeaderWithSeeFirstComponentSpec f20769b;
    public final Pools$SynchronizedPool<Builder> f20770c = new Pools$SynchronizedPool(2);

    private static HeaderWithSeeFirstComponent m28484b(InjectorLike injectorLike) {
        return new HeaderWithSeeFirstComponent(HeaderWithSeeFirstComponentSpec.m28488a(injectorLike));
    }

    @Inject
    public HeaderWithSeeFirstComponent(HeaderWithSeeFirstComponentSpec headerWithSeeFirstComponentSpec) {
        this.f20769b = headerWithSeeFirstComponentSpec;
    }

    public static HeaderWithSeeFirstComponent m28483a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeaderWithSeeFirstComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20768e) {
                HeaderWithSeeFirstComponent headerWithSeeFirstComponent;
                if (a2 != null) {
                    headerWithSeeFirstComponent = (HeaderWithSeeFirstComponent) a2.mo818a(f20768e);
                } else {
                    headerWithSeeFirstComponent = f20767d;
                }
                if (headerWithSeeFirstComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28484b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20768e, b3);
                        } else {
                            f20767d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = headerWithSeeFirstComponent;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    protected final InternalNode mo3135b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f20769b.m28490a(componentContext, state.a, state.b);
    }

    public final void mo3134a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.f20393a, new 1(this, eventHandler, obj), 2075373678);
        }
    }
}

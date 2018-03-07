package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;

@ContextScoped
/* compiled from: video_channel_unsubscribe_data */
public class FeedTextHeaderComponent<E extends HasInvalidate & HasMenuButtonProvider & HasPersistentState & HasContext> extends ComponentLifecycle {
    private static FeedTextHeaderComponent f0d;
    private static final Object f1e = new Object();
    private final FeedTextHeaderComponentSpec f2b;
    public final SynchronizedPool<Builder> f3c = new SynchronizedPool(2);

    private static FeedTextHeaderComponent m1b(InjectorLike injectorLike) {
        return new FeedTextHeaderComponent(FeedTextHeaderComponentSpec.m4a(injectorLike));
    }

    @Inject
    public FeedTextHeaderComponent(FeedTextHeaderComponentSpec feedTextHeaderComponentSpec) {
        this.f2b = feedTextHeaderComponentSpec;
    }

    public static FeedTextHeaderComponent m0a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedTextHeaderComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1e) {
                FeedTextHeaderComponent feedTextHeaderComponent;
                if (a2 != null) {
                    feedTextHeaderComponent = (FeedTextHeaderComponent) a2.a(f1e);
                } else {
                    feedTextHeaderComponent = f0d;
                }
                if (feedTextHeaderComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1e, b3);
                        } else {
                            f0d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = feedTextHeaderComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final InternalNode m3b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f2b.m6a(componentContext, state.a, state.b);
    }

    public final void m2a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new 1(this, eventHandler, obj), -174396941);
        }
    }
}

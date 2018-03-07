package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools$SynchronizedPool;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ClickEvent;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.feed.environment.CanFollowUser;
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
/* compiled from: ignore_old_datasource @ onProgress */
public class FollowButtonComponent<E extends CanFollowUser & HasPersistentState> extends ComponentLifecycle {
    private static FollowButtonComponent f20557d;
    private static final Object f20558e = new Object();
    private final FollowButtonComponentSpec f20559b;
    public final Pools$SynchronizedPool<Builder> f20560c = new Pools$SynchronizedPool(2);

    private static FollowButtonComponent m28296b(InjectorLike injectorLike) {
        return new FollowButtonComponent(FollowButtonComponentSpec.m28299a(injectorLike));
    }

    public static FollowButtonComponent m28294a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FollowButtonComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20558e) {
                FollowButtonComponent followButtonComponent;
                if (a2 != null) {
                    followButtonComponent = (FollowButtonComponent) a2.mo818a(f20558e);
                } else {
                    followButtonComponent = f20557d;
                }
                if (followButtonComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28296b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20558e, b3);
                        } else {
                            f20557d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = followButtonComponent;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public FollowButtonComponent(FollowButtonComponentSpec followButtonComponentSpec) {
        this.f20559b = followButtonComponentSpec;
    }

    protected final InternalNode mo3135b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f20559b.m28302a(componentContext, state.a, state.b, state.c, state.d, state.e, state.f);
    }

    private void m28295a(View view, Component component) {
        State state = (State) component;
        FollowButtonComponentSpec.m28300a(view, state.b, state.c, state.g, state.h, state.d);
    }

    public final void mo3134a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.f20393a, new 1(this, eventHandler, obj), -1340710513);
            return;
        }
        switch (eventHandler.f22608b) {
            case 1523724257:
                m28295a(((ClickEvent) obj).a, eventHandler.f22607a);
                return;
            default:
                return;
        }
    }
}

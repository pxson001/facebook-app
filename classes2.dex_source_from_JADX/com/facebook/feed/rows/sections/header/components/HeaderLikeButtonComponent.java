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
import com.facebook.feed.environment.CanLikePage;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.LikePageButtonPartDefinition.PageLikeListener;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;

@ContextScoped
/* compiled from: freshfeed_network_fetcher */
public class HeaderLikeButtonComponent<E extends CanLikePage & HasPersistentState> extends ComponentLifecycle {
    private static HeaderLikeButtonComponent f23197d;
    private static final Object f23198e = new Object();
    private final HeaderLikeButtonComponentSpec f23199b;
    public final Pools$SynchronizedPool<Builder> f23200c = new Pools$SynchronizedPool(2);

    private static HeaderLikeButtonComponent m31309b(InjectorLike injectorLike) {
        return new HeaderLikeButtonComponent(HeaderLikeButtonComponentSpec.m31312a(injectorLike));
    }

    @Inject
    public HeaderLikeButtonComponent(HeaderLikeButtonComponentSpec headerLikeButtonComponentSpec) {
        this.f23199b = headerLikeButtonComponentSpec;
    }

    public static HeaderLikeButtonComponent m31307a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeaderLikeButtonComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23198e) {
                HeaderLikeButtonComponent headerLikeButtonComponent;
                if (a2 != null) {
                    headerLikeButtonComponent = (HeaderLikeButtonComponent) a2.mo818a(f23198e);
                } else {
                    headerLikeButtonComponent = f23197d;
                }
                if (headerLikeButtonComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m31309b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23198e, b3);
                        } else {
                            f23197d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = headerLikeButtonComponent;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    protected final InternalNode mo3135b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f23199b.m31314a(componentContext, state.a, state.b);
    }

    private void m31308a(View view, Component component) {
        State state = (State) component;
        HeaderLikeButtonComponentSpec headerLikeButtonComponentSpec = this.f23199b;
        FeedProps feedProps = state.a;
        new PageLikeListener(feedProps, headerLikeButtonComponentSpec.f23207e.m28027a(feedProps).ab(), headerLikeButtonComponentSpec.f23206d, state.b).onClick(view);
    }

    public final void mo3134a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.f20393a, new 1(this, eventHandler, obj), -197827922);
            return;
        }
        switch (eventHandler.f22608b) {
            case 839108621:
                m31308a(((ClickEvent) obj).a, eventHandler.f22607a);
                return;
            default:
                return;
        }
    }
}

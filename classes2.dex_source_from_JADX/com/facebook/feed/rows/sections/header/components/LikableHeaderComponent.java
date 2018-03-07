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
import com.facebook.feed.environment.CanLikePage;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.fig.header.FigHeaderComponent;
import com.facebook.fig.header.FigHeaderComponent.Builder;
import com.facebook.fig.header.FigHeaderComponent.State;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friend_accept */
public class LikableHeaderComponent<E extends CanLikePage & HasFeedListType & HasInvalidate & HasPersistentState & HasPrefetcher & HasRowKey & HasContext> extends ComponentLifecycle {
    private static LikableHeaderComponent f23188d;
    private static final Object f23189e = new Object();
    private final LikableHeaderComponentSpec f23190b;
    public final Pools$SynchronizedPool<Builder> f23191c = new Pools$SynchronizedPool(2);

    private static LikableHeaderComponent m31302b(InjectorLike injectorLike) {
        return new LikableHeaderComponent(LikableHeaderComponentSpec.m31305a(injectorLike));
    }

    @Inject
    public LikableHeaderComponent(LikableHeaderComponentSpec likableHeaderComponentSpec) {
        this.f23190b = likableHeaderComponentSpec;
    }

    public static LikableHeaderComponent m31301a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LikableHeaderComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23189e) {
                LikableHeaderComponent likableHeaderComponent;
                if (a2 != null) {
                    likableHeaderComponent = (LikableHeaderComponent) a2.mo818a(f23189e);
                } else {
                    likableHeaderComponent = f23188d;
                }
                if (likableHeaderComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m31302b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23189e, b3);
                        } else {
                            f23188d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = likableHeaderComponent;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    protected final InternalNode mo3135b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        LikableHeaderComponentSpec likableHeaderComponentSpec = this.f23190b;
        FeedProps feedProps = state.a;
        CanLikePage canLikePage = state.b;
        State state2 = new State();
        Builder builder = (Builder) FigHeaderComponent.c.mo740a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.a(builder, componentContext, 0, state2);
        Builder builder2 = builder;
        builder2.a.a = likableHeaderComponentSpec.f23194a.m28154a(componentContext).m30952a(feedProps).m30951a((HasFeedListType) canLikePage).mo3296d();
        builder2 = builder2;
        builder2.a.b = likableHeaderComponentSpec.f23195b.m28244a(componentContext).m31003a(feedProps).m31002a((HasContext) canLikePage).mo3296d();
        builder2.d.set(0);
        Builder builder3 = builder2;
        HeaderLikeButtonComponent headerLikeButtonComponent = likableHeaderComponentSpec.f23196c;
        HeaderLikeButtonComponent.State state3 = new HeaderLikeButtonComponent.State(headerLikeButtonComponent);
        HeaderLikeButtonComponent.Builder builder4 = (HeaderLikeButtonComponent.Builder) headerLikeButtonComponent.f23200c.mo740a();
        if (builder4 == null) {
            builder4 = new HeaderLikeButtonComponent.Builder(headerLikeButtonComponent);
        }
        HeaderLikeButtonComponent.Builder.a(builder4, componentContext, 0, state3);
        HeaderLikeButtonComponent.Builder builder5 = builder4;
        builder5.a.a = feedProps;
        builder5.e.set(0);
        builder5 = builder5;
        builder5.a.b = canLikePage;
        builder5.e.set(1);
        builder3.a.c = builder5.mo3296d();
        return builder3.m30662b();
    }

    public final void mo3134a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.f20393a, new 1(this, eventHandler, obj), 1750936060);
        }
    }
}

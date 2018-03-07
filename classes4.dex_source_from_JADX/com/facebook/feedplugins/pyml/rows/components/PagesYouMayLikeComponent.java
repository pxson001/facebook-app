package com.facebook.feedplugins.pyml.rows.components;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.feed.FeedPager;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.sections.hscrollrecyclerview.FeedUnitAndChangePageListener;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;

@ContextScoped
/* compiled from: old_databases_cleaner */
public class PagesYouMayLikeComponent<E extends HasFeedListType & HasPositionInformation & HasPersistentState & HasMenuButtonProvider & HasPrefetcher & HasRowKey & HasContext & HasIsAsync> extends ComponentLifecycle {
    private static PagesYouMayLikeComponent f6274d;
    private static final Object f6275e = new Object();
    private final PagesYouMayLikeComponentSpec f6276b;
    public final SynchronizedPool<Builder> f6277c = new SynchronizedPool(2);

    private static PagesYouMayLikeComponent m6729b(InjectorLike injectorLike) {
        return new PagesYouMayLikeComponent(PagesYouMayLikeComponentSpec.m6733a(injectorLike));
    }

    @Inject
    public PagesYouMayLikeComponent(PagesYouMayLikeComponentSpec pagesYouMayLikeComponentSpec) {
        this.f6276b = pagesYouMayLikeComponentSpec;
    }

    public static PagesYouMayLikeComponent m6728a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesYouMayLikeComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6275e) {
                PagesYouMayLikeComponent pagesYouMayLikeComponent;
                if (a2 != null) {
                    pagesYouMayLikeComponent = (PagesYouMayLikeComponent) a2.a(f6275e);
                } else {
                    pagesYouMayLikeComponent = f6274d;
                }
                if (pagesYouMayLikeComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6729b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6275e, b3);
                        } else {
                            f6274d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagesYouMayLikeComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Builder m6730a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) this.f6277c.a();
        if (builder == null) {
            builder = new Builder(this);
        }
        Builder.a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode m6732b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        PagesYouMayLikeComponentSpec pagesYouMayLikeComponentSpec = this.f6276b;
        HasFeedListType hasFeedListType = state.a;
        FeedUnitAndChangePageListener feedUnitAndChangePageListener = state.b;
        boolean z = state.c;
        return FeedPager.a(componentContext).a(pagesYouMayLikeComponentSpec.f6280a.m6735a(componentContext, ((GraphQLPYMLWithLargeImageFeedUnit) feedUnitAndChangePageListener.f6289a.a).ac_(), 1.0f, feedUnitAndChangePageListener, hasFeedListType, z)).c().h(4, 2).j();
    }

    public final void m6731a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new 1(this, eventHandler, obj), -1502207559);
        }
    }
}

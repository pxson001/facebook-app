package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools$SynchronizedPool;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout$Builder;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.feed.environment.CanFollowUser;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.components.FollowButtonComponent.Builder;
import com.facebook.feed.rows.sections.header.components.FollowButtonComponent.State;
import com.facebook.graphql.calls.ActorSubscribeInputData.SubscribeLocation;
import com.facebook.graphql.calls.ActorUnsubscribeInputData;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryActionLinkHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;

@ContextScoped
/* compiled from: image_scale */
public class FollowableHeaderComponent<E extends CanFollowUser & HasContext & HasFeedListType & HasInvalidate & HasPersistentState & HasPrefetcher & HasRowKey> extends ComponentLifecycle {
    private static FollowableHeaderComponent f20389d;
    private static final Object f20390e = new Object();
    private final FollowableHeaderComponentSpec f20391b;
    public final Pools$SynchronizedPool<Builder> f20392c = new Pools$SynchronizedPool(2);

    private static FollowableHeaderComponent m28108b(InjectorLike injectorLike) {
        return new FollowableHeaderComponent(FollowableHeaderComponentSpec.m28146a(injectorLike));
    }

    @Inject
    public FollowableHeaderComponent(FollowableHeaderComponentSpec followableHeaderComponentSpec) {
        this.f20391b = followableHeaderComponentSpec;
    }

    public static FollowableHeaderComponent m28107a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FollowableHeaderComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20390e) {
                FollowableHeaderComponent followableHeaderComponent;
                if (a2 != null) {
                    followableHeaderComponent = (FollowableHeaderComponent) a2.mo818a(f20390e);
                } else {
                    followableHeaderComponent = f20389d;
                }
                if (followableHeaderComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28108b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20390e, b3);
                        } else {
                            f20389d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = followableHeaderComponent;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    protected final InternalNode mo3135b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        FollowableHeaderComponentSpec followableHeaderComponentSpec = this.f20391b;
        FeedProps feedProps = state.a;
        CanFollowUser canFollowUser = state.b;
        ComponentLayout$Builder a = followableHeaderComponentSpec.f20400a.m28150a(componentContext, feedProps, (HasFeedListType) canFollowUser);
        GraphQLProfile ah = StoryActionLinkHelper.m28072a((GraphQLStory) feedProps.f13444a, -2052107768).ah();
        FollowButtonComponent followButtonComponent = followableHeaderComponentSpec.f20401b;
        State state2 = new State(followButtonComponent);
        Builder builder = (Builder) followButtonComponent.f20560c.mo740a();
        if (builder == null) {
            builder = new Builder(followButtonComponent);
        }
        Builder.a(builder, componentContext, 0, state2);
        Builder builder2 = builder;
        builder2.a.d = canFollowUser;
        builder2.e.set(3);
        builder2 = builder2;
        builder2.a.a = feedProps;
        builder2.e.set(0);
        builder2 = builder2;
        builder2.a.b = ah.m22999b();
        builder2.e.set(1);
        builder2 = builder2;
        builder2.a.c = ah.ar();
        builder2.e.set(2);
        Builder builder3 = builder2;
        builder3.a.g = SubscribeLocation.FEED_UNCONNECTED_STORY;
        builder3.e.set(4);
        builder3 = builder3;
        builder3.a.h = ActorUnsubscribeInputData.SubscribeLocation.FEED_UNCONNECTED_STORY;
        builder3.e.set(5);
        a.mo3316a(builder3.m30663c().mo3338h(8, 2).mo3330d(1, 2));
        return a.mo3343j();
    }

    public final void mo3134a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.f20393a, new 1(this, eventHandler, obj), 1114801141);
        }
    }
}

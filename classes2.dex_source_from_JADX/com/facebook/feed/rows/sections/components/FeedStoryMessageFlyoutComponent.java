package com.facebook.feed.rows.sections.components;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools$SynchronizedPool;
import android.view.View;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ClickEvent;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout$Builder;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.Layout;
import com.facebook.feed.analytics.StoryRenderContext;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.FlyoutLauncher.FlyoutContext;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: id_backed_privacy_checkup/checkup_id=<p$1> */
public class FeedStoryMessageFlyoutComponent extends ComponentLifecycle {
    public static final Pools$SynchronizedPool<Builder> f20604b = new Pools$SynchronizedPool(2);
    private static FeedStoryMessageFlyoutComponent f20605d;
    private static final Object f20606e = new Object();
    private final FeedStoryMessageFlyoutComponentSpec f20607c;

    /* compiled from: id_backed_privacy_checkup/checkup_id=<p$1> */
    public class State extends Component<FeedStoryMessageFlyoutComponent> implements Cloneable {
        Component<?> f22719a;
        FeedProps<GraphQLStory> f22720b;
        StoryRenderContext f22721c;
        GraphQLComment f22722d;
        final /* synthetic */ FeedStoryMessageFlyoutComponent f22723e;

        public State(FeedStoryMessageFlyoutComponent feedStoryMessageFlyoutComponent) {
            this.f22723e = feedStoryMessageFlyoutComponent;
            super(feedStoryMessageFlyoutComponent);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            State state = (State) obj;
            if (this.f22588b == state.f22588b) {
                return true;
            }
            if (this.f22719a == null ? state.f22719a != null : !this.f22719a.equals(state.f22719a)) {
                return false;
            }
            if (this.f22720b == null ? state.f22720b != null : !this.f22720b.equals(state.f22720b)) {
                return false;
            }
            if (this.f22721c == null ? state.f22721c != null : !this.f22721c.equals(state.f22721c)) {
                return false;
            }
            if (this.f22722d != null) {
                if (this.f22722d.equals(state.f22722d)) {
                    return true;
                }
            } else if (state.f22722d == null) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: id_backed_privacy_checkup/checkup_id=<p$1> */
    public class Builder extends com.facebook.components.Component.Builder<FeedStoryMessageFlyoutComponent> {
        State f22724a;
        private String[] f22725b = new String[]{"delegate", "storyProps", "storyRenderContext"};
        private int f22726c = 3;
        private BitSet f22727d = new BitSet(this.f22726c);

        public static void m30687a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.m30661a(componentContext, i, state);
            builder.f22724a = state;
            builder.f22727d.clear();
        }

        public final Builder m30688a(Component<?> component) {
            this.f22724a.f22719a = component;
            this.f22727d.set(0);
            return this;
        }

        public final Builder m30690a(FeedProps<GraphQLStory> feedProps) {
            this.f22724a.f22720b = feedProps;
            this.f22727d.set(1);
            return this;
        }

        public final Builder m30689a(StoryRenderContext storyRenderContext) {
            this.f22724a.f22721c = storyRenderContext;
            this.f22727d.set(2);
            return this;
        }

        public final Component<FeedStoryMessageFlyoutComponent> mo3296d() {
            int i = 0;
            if (this.f22727d == null || this.f22727d.nextClearBit(0) >= this.f22726c) {
                Component component = this.f22724a;
                mo3295a();
                return component;
            }
            List arrayList = new ArrayList();
            while (i < this.f22726c) {
                if (!this.f22727d.get(i)) {
                    arrayList.add(this.f22725b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void mo3295a() {
            super.mo3295a();
            this.f22724a = null;
            FeedStoryMessageFlyoutComponent.f20604b.mo741a(this);
        }
    }

    private static FeedStoryMessageFlyoutComponent m28351b(InjectorLike injectorLike) {
        return new FeedStoryMessageFlyoutComponent(FeedStoryMessageFlyoutComponentSpec.m28355a(injectorLike));
    }

    @Inject
    public FeedStoryMessageFlyoutComponent(FeedStoryMessageFlyoutComponentSpec feedStoryMessageFlyoutComponentSpec) {
        this.f20607c = feedStoryMessageFlyoutComponentSpec;
    }

    public static FeedStoryMessageFlyoutComponent m28349a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedStoryMessageFlyoutComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20606e) {
                FeedStoryMessageFlyoutComponent feedStoryMessageFlyoutComponent;
                if (a2 != null) {
                    feedStoryMessageFlyoutComponent = (FeedStoryMessageFlyoutComponent) a2.mo818a(f20606e);
                } else {
                    feedStoryMessageFlyoutComponent = f20605d;
                }
                if (feedStoryMessageFlyoutComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28351b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20606e, b3);
                        } else {
                            f20605d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedStoryMessageFlyoutComponent;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final Builder m28352a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) f20604b.mo740a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m30687a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode mo3135b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        FeedStoryMessageFlyoutComponentSpec feedStoryMessageFlyoutComponentSpec = this.f20607c;
        ComponentLayout$Builder a = Layout.m30714a(componentContext, state.f22719a);
        if (((Boolean) feedStoryMessageFlyoutComponentSpec.f20610a.get()).booleanValue()) {
            a.mo3311a(ComponentLifecycle.m28112a(componentContext, 1525898222, null));
        }
        return a.mo3343j();
    }

    private void m28350a(View view, Component component) {
        State state = (State) component;
        FeedStoryMessageFlyoutComponentSpec feedStoryMessageFlyoutComponentSpec = this.f20607c;
        FeedProps feedProps = state.f22720b;
        StoryRenderContext storyRenderContext = state.f22721c;
        GraphQLComment graphQLComment = state.f22722d;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        if (graphQLStory.mo2890l() == null) {
            return;
        }
        if (graphQLStory.mo2507g() != null || graphQLStory.m22350c() != null) {
            TrackingNodes.m27141a(view, TrackingNode.FEED_STORY_MESSAGE_FLYOUT);
            feedStoryMessageFlyoutComponentSpec.f20611b.m28365a(feedProps, graphQLComment, view, FlyoutContext.MESSAGE, storyRenderContext);
        }
    }

    public final void mo3134a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.f20393a, new 1(this, eventHandler, obj), 1510172098);
            return;
        }
        switch (eventHandler.f22608b) {
            case 1525898222:
                m28350a(((ClickEvent) obj).a, eventHandler.f22607a);
                return;
            default:
                return;
        }
    }
}

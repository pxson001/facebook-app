package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.support.v4.util.Pools$SynchronizedPool;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.TriState;
import com.facebook.components.ClickEvent;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.Container;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.ResourceResolver;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.graphqlstory.header.DefaultHeaderPartConverter;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLActorUtil;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.story.util.StoryParentContext;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: image_low_width */
public class HeaderActorComponent<E extends HasFeedListType & HasPersistentState & HasPrefetcher & HasRowKey> extends ComponentLifecycle {
    private static HeaderActorComponent f20404d;
    private static final Object f20405e = new Object();
    private final HeaderActorComponentSpec f20406b;
    public final Pools$SynchronizedPool<Builder> f20407c = new Pools$SynchronizedPool(2);

    /* compiled from: image_low_width */
    public class State extends Component<HeaderActorComponent> implements Cloneable {
        FeedProps<GraphQLStory> f22832a;
        E f22833b;
        final /* synthetic */ HeaderActorComponent f22834c;

        public State(HeaderActorComponent headerActorComponent) {
            this.f22834c = headerActorComponent;
            super(headerActorComponent);
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
            if (this.f22832a == null ? state.f22832a != null : !this.f22832a.equals(state.f22832a)) {
                return false;
            }
            if (this.f22833b != null) {
                if (this.f22833b.equals(state.f22833b)) {
                    return true;
                }
            } else if (state.f22833b == null) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: image_low_width */
    public class Builder extends com.facebook.components.Component.Builder<HeaderActorComponent> {
        State f22835a;
        final /* synthetic */ HeaderActorComponent f22836b;
        private String[] f22837c = new String[]{"storyProps", "environment"};
        private int f22838d = 2;
        private BitSet f22839e = new BitSet(this.f22838d);

        public Builder(HeaderActorComponent headerActorComponent) {
            this.f22836b = headerActorComponent;
        }

        public static void m30950a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.m30661a(componentContext, i, state);
            builder.f22835a = state;
            builder.f22839e.clear();
        }

        public final Builder m30952a(FeedProps<GraphQLStory> feedProps) {
            this.f22835a.f22832a = feedProps;
            this.f22839e.set(0);
            return this;
        }

        public final Builder m30951a(E e) {
            this.f22835a.f22833b = e;
            this.f22839e.set(1);
            return this;
        }

        public final Component<HeaderActorComponent> mo3296d() {
            int i = 0;
            if (this.f22839e == null || this.f22839e.nextClearBit(0) >= this.f22838d) {
                Component component = this.f22835a;
                mo3295a();
                return component;
            }
            List arrayList = new ArrayList();
            while (i < this.f22838d) {
                if (!this.f22839e.get(i)) {
                    arrayList.add(this.f22837c[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void mo3295a() {
            super.mo3295a();
            this.f22835a = null;
            this.f22836b.f20407c.mo741a(this);
        }
    }

    private static HeaderActorComponent m28153b(InjectorLike injectorLike) {
        return new HeaderActorComponent(HeaderActorComponentSpec.m28157a(injectorLike));
    }

    @Inject
    public HeaderActorComponent(HeaderActorComponentSpec headerActorComponentSpec) {
        this.f20406b = headerActorComponentSpec;
    }

    public static HeaderActorComponent m28151a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeaderActorComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20405e) {
                HeaderActorComponent headerActorComponent;
                if (a2 != null) {
                    headerActorComponent = (HeaderActorComponent) a2.mo818a(f20405e);
                } else {
                    headerActorComponent = f20404d;
                }
                if (headerActorComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28153b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20405e, b3);
                        } else {
                            f20404d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = headerActorComponent;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final Builder m28154a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) this.f20407c.mo740a();
        if (builder == null) {
            builder = new Builder(this);
        }
        Builder.m30950a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode mo3135b(ComponentContext componentContext, Component component) {
        String d;
        com.facebook.components.Component.Builder builder;
        State state = (State) component;
        HeaderActorComponentSpec headerActorComponentSpec = this.f20406b;
        FeedProps feedProps = state.f22832a;
        HasFeedListType hasFeedListType = state.f22833b;
        EventHandler eventHandler = null;
        GraphQLActor b = StoryActorHelper.m27492b((GraphQLStory) feedProps.f13444a);
        boolean z = false;
        if (headerActorComponentSpec.f20415f == TriState.UNSET) {
            headerActorComponentSpec.f20415f = TriState.valueOf(headerActorComponentSpec.f20413d.mo596a(ExperimentsForTimelineAbTestModule.aM, false));
        }
        if (headerActorComponentSpec.f20415f.asBoolean(false) && headerActorComponentSpec.f20414e.m26871a()) {
            z = true;
        }
        if (z) {
            d = GraphQLActorUtil.m29710d(b);
        } else {
            d = null;
        }
        if (Strings.isNullOrEmpty(d)) {
            Uri parse = (b == null || Strings.isNullOrEmpty(GraphQLActorUtil.m29709c(b))) ? null : Uri.parse(GraphQLActorUtil.m29709c(b));
            ResourceResolver a = headerActorComponentSpec.f20412c.m28161a(componentContext).m30957a(HeaderActorComponentSpec.f20408a).m30959a(feedProps).m30956a(parse).m30960a(true).m30958a(hasFeedListType);
            a.f22852a.f22845f = a.m30679g(2130841701);
            a = a;
        } else {
            com.facebook.feed.rows.sections.header.components.ActorProfileVideoComponent.State state2 = new com.facebook.feed.rows.sections.header.components.ActorProfileVideoComponent.State();
            com.facebook.feed.rows.sections.header.components.ActorProfileVideoComponent.Builder builder2 = (com.facebook.feed.rows.sections.header.components.ActorProfileVideoComponent.Builder) ActorProfileVideoComponent.c.mo740a();
            if (builder2 == null) {
                builder2 = new com.facebook.feed.rows.sections.header.components.ActorProfileVideoComponent.Builder();
            }
            com.facebook.feed.rows.sections.header.components.ActorProfileVideoComponent.Builder.a(builder2, componentContext, 0, state2);
            com.facebook.feed.rows.sections.header.components.ActorProfileVideoComponent.Builder builder3 = builder2;
            builder3.a.a = b;
            builder3.d.set(0);
            builder = builder3;
        }
        if (b != null) {
            eventHandler = ComponentLifecycle.m28112a(componentContext, 1948510433, null);
        }
        return Container.m30723a(componentContext).mo3316a(builder.m30663c().mo3327c(2).mo3357s(2130840232).mo3311a(eventHandler)).mo3343j();
    }

    private void m28152a(View view, Component component) {
        State state = (State) component;
        HeaderActorComponentSpec headerActorComponentSpec = this.f20406b;
        FeedProps feedProps = state.f22832a;
        headerActorComponentSpec.f20411b.m28182a(view, DefaultHeaderPartConverter.a((GraphQLStory) feedProps.f13444a), StoryParentContext.a(feedProps));
    }

    public final void mo3134a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.f20393a, new 1(this, eventHandler, obj), 2003349344);
            return;
        }
        switch (eventHandler.f22608b) {
            case 1948510433:
                m28152a(((ClickEvent) obj).a, eventHandler.f22607a);
                return;
            default:
                return;
        }
    }
}

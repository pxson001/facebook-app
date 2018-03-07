package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout.ContainerBuilder;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.feed.environment.CanFriendPerson;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.friends.ui.FriendingButtonModel;
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
/* compiled from: Unknown array type  */
public class FriendableHeaderComponent<E extends CanFriendPerson & HasFeedListType & HasInvalidate & HasPersistentState & HasPrefetcher & HasRowKey & HasContext> extends ComponentLifecycle {
    private static FriendableHeaderComponent f21277d;
    private static final Object f21278e = new Object();
    private final FriendableHeaderComponentSpec f21279b;
    public final SynchronizedPool<Builder> f21280c = new SynchronizedPool(2);

    /* compiled from: Unknown array type  */
    public class Builder extends com.facebook.components.Component.Builder<FriendableHeaderComponent> {
        public State f21269a;
        final /* synthetic */ FriendableHeaderComponent f21270b;
        private String[] f21271c = new String[]{"storyProps", "environment"};
        private int f21272d = 2;
        public BitSet f21273e = new BitSet(this.f21272d);

        public Builder(FriendableHeaderComponent friendableHeaderComponent) {
            this.f21270b = friendableHeaderComponent;
        }

        public static void m24050a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f21269a = state;
            builder.f21273e.clear();
        }

        public final Component<FriendableHeaderComponent> m24052d() {
            int i = 0;
            if (this.f21273e == null || this.f21273e.nextClearBit(0) >= this.f21272d) {
                State state = this.f21269a;
                m24051a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f21272d) {
                if (!this.f21273e.get(i)) {
                    arrayList.add(this.f21271c[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m24051a() {
            super.a();
            this.f21269a = null;
            this.f21270b.f21280c.a(this);
        }
    }

    /* compiled from: Unknown array type  */
    public class State extends Component<FriendableHeaderComponent> implements Cloneable {
        public FeedProps<GraphQLStory> f21274a;
        public E f21275b;
        final /* synthetic */ FriendableHeaderComponent f21276c;

        public State(FriendableHeaderComponent friendableHeaderComponent) {
            this.f21276c = friendableHeaderComponent;
            super(friendableHeaderComponent);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            State state = (State) obj;
            if (this.b == state.b) {
                return true;
            }
            if (this.f21274a == null ? state.f21274a != null : !this.f21274a.equals(state.f21274a)) {
                return false;
            }
            if (this.f21275b != null) {
                if (this.f21275b.equals(state.f21275b)) {
                    return true;
                }
            } else if (state.f21275b == null) {
                return true;
            }
            return false;
        }
    }

    private static FriendableHeaderComponent m24054b(InjectorLike injectorLike) {
        return new FriendableHeaderComponent(FriendableHeaderComponentSpec.m24065a(injectorLike));
    }

    @Inject
    public FriendableHeaderComponent(FriendableHeaderComponentSpec friendableHeaderComponentSpec) {
        this.f21279b = friendableHeaderComponentSpec;
    }

    public static FriendableHeaderComponent m24053a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendableHeaderComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21278e) {
                FriendableHeaderComponent friendableHeaderComponent;
                if (a2 != null) {
                    friendableHeaderComponent = (FriendableHeaderComponent) a2.a(f21278e);
                } else {
                    friendableHeaderComponent = f21277d;
                }
                if (friendableHeaderComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24054b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21278e, b3);
                        } else {
                            f21277d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendableHeaderComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final InternalNode m24056b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        FriendableHeaderComponentSpec friendableHeaderComponentSpec = this.f21279b;
        FeedProps feedProps = state.f21274a;
        CanFriendPerson canFriendPerson = state.f21275b;
        FriendingButtonModel a = FriendableHeaderComponentSpec.m24066a(feedProps, canFriendPerson);
        ContainerBuilder a2 = friendableHeaderComponentSpec.f21290a.a(componentContext, feedProps, (HasFeedListType) canFriendPerson);
        if (a.c()) {
            FriendingButtonComponent friendingButtonComponent = friendableHeaderComponentSpec.f21291b;
            com.facebook.feed.rows.sections.header.components.FriendingButtonComponent.State state2 = new com.facebook.feed.rows.sections.header.components.FriendingButtonComponent.State(friendingButtonComponent);
            com.facebook.feed.rows.sections.header.components.FriendingButtonComponent.Builder builder = (com.facebook.feed.rows.sections.header.components.FriendingButtonComponent.Builder) friendingButtonComponent.f21307c.a();
            if (builder == null) {
                builder = new com.facebook.feed.rows.sections.header.components.FriendingButtonComponent.Builder(friendingButtonComponent);
            }
            com.facebook.feed.rows.sections.header.components.FriendingButtonComponent.Builder.m24068a(builder, componentContext, 0, state2);
            com.facebook.feed.rows.sections.header.components.FriendingButtonComponent.Builder builder2 = builder;
            builder2.f21295a.f21300a = a;
            builder2.f21299e.set(0);
            com.facebook.feed.rows.sections.header.components.FriendingButtonComponent.Builder builder3 = builder2;
            builder3.f21295a.f21301b = feedProps;
            builder3.f21299e.set(1);
            builder3 = builder3;
            builder3.f21295a.f21302c = canFriendPerson;
            builder3.f21299e.set(2);
            a2.a(builder3.c().h(1, 4).g(5, 2131427612).j());
        }
        return a2.j();
    }

    public final void m24055a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ FriendableHeaderComponent f21268c;

                public void run() {
                    this.f21268c.a(eventHandler, obj);
                }
            }, 1912654559);
        }
    }
}

package com.facebook.feedplugins.goodwill.components;

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
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.props.FeedProps;
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
/* compiled from: giphy.com */
public class ThrowbackPromotedStoryHeaderComponent<E extends HasContext & HasFeedListType & HasInvalidate & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> extends ComponentLifecycle {
    private static ThrowbackPromotedStoryHeaderComponent f12662d;
    private static final Object f12663e = new Object();
    private final ThrowbackPromotedStoryHeaderComponentSpec f12664b;
    public final SynchronizedPool<Builder> f12665c = new SynchronizedPool(2);

    /* compiled from: giphy.com */
    public class Builder extends com.facebook.components.Component.Builder<ThrowbackPromotedStoryHeaderComponent> {
        public State f12654a;
        final /* synthetic */ ThrowbackPromotedStoryHeaderComponent f12655b;
        private String[] f12656c = new String[]{"storyProps", "environment"};
        private int f12657d = 2;
        public BitSet f12658e = new BitSet(this.f12657d);

        public Builder(ThrowbackPromotedStoryHeaderComponent throwbackPromotedStoryHeaderComponent) {
            this.f12655b = throwbackPromotedStoryHeaderComponent;
        }

        public static void m14477a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f12654a = state;
            builder.f12658e.clear();
        }

        public final Component<ThrowbackPromotedStoryHeaderComponent> m14479d() {
            int i = 0;
            if (this.f12658e == null || this.f12658e.nextClearBit(0) >= this.f12657d) {
                State state = this.f12654a;
                m14478a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f12657d) {
                if (!this.f12658e.get(i)) {
                    arrayList.add(this.f12656c[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m14478a() {
            super.a();
            this.f12654a = null;
            this.f12655b.f12665c.a(this);
        }
    }

    /* compiled from: giphy.com */
    public class State extends Component<ThrowbackPromotedStoryHeaderComponent> implements Cloneable {
        public FeedProps<GraphQLStory> f12659a;
        public E f12660b;
        final /* synthetic */ ThrowbackPromotedStoryHeaderComponent f12661c;

        public State(ThrowbackPromotedStoryHeaderComponent throwbackPromotedStoryHeaderComponent) {
            this.f12661c = throwbackPromotedStoryHeaderComponent;
            super(throwbackPromotedStoryHeaderComponent);
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
            if (this.f12659a == null ? state.f12659a != null : !this.f12659a.equals(state.f12659a)) {
                return false;
            }
            if (this.f12660b != null) {
                if (this.f12660b.equals(state.f12660b)) {
                    return true;
                }
            } else if (state.f12660b == null) {
                return true;
            }
            return false;
        }
    }

    private static ThrowbackPromotedStoryHeaderComponent m14481b(InjectorLike injectorLike) {
        return new ThrowbackPromotedStoryHeaderComponent(ThrowbackPromotedStoryHeaderComponentSpec.m14492a(injectorLike));
    }

    @Inject
    public ThrowbackPromotedStoryHeaderComponent(ThrowbackPromotedStoryHeaderComponentSpec throwbackPromotedStoryHeaderComponentSpec) {
        this.f12664b = throwbackPromotedStoryHeaderComponentSpec;
    }

    public static ThrowbackPromotedStoryHeaderComponent m14480a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackPromotedStoryHeaderComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12663e) {
                ThrowbackPromotedStoryHeaderComponent throwbackPromotedStoryHeaderComponent;
                if (a2 != null) {
                    throwbackPromotedStoryHeaderComponent = (ThrowbackPromotedStoryHeaderComponent) a2.a(f12663e);
                } else {
                    throwbackPromotedStoryHeaderComponent = f12662d;
                }
                if (throwbackPromotedStoryHeaderComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14481b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12663e, b3);
                        } else {
                            f12662d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackPromotedStoryHeaderComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final InternalNode m14483b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f12664b.m14494a(componentContext, state.f12659a, state.f12660b);
    }

    public final void m14482a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ThrowbackPromotedStoryHeaderComponent f12653c;

                public void run() {
                    this.f12653c.a(eventHandler, obj);
                }
            }, 285315659);
        }
    }
}

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
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
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
/* compiled from: Unexpected exception loading stream */
public class PinnedPostHeaderComponent<E extends HasContext & HasFeedListType & HasInvalidate & HasMenuButtonProvider & HasPersistentState & HasPrefetcher & HasRowKey> extends ComponentLifecycle {
    private static PinnedPostHeaderComponent f21378d;
    private static final Object f21379e = new Object();
    private final PinnedPostHeaderComponentSpec f21380b;
    public final SynchronizedPool<Builder> f21381c = new SynchronizedPool(2);

    /* compiled from: Unexpected exception loading stream */
    public class Builder extends com.facebook.components.Component.Builder<PinnedPostHeaderComponent> {
        public State f21370a;
        final /* synthetic */ PinnedPostHeaderComponent f21371b;
        private String[] f21372c = new String[]{"storyProps", "environment"};
        private int f21373d = 2;
        public BitSet f21374e = new BitSet(this.f21373d);

        public Builder(PinnedPostHeaderComponent pinnedPostHeaderComponent) {
            this.f21371b = pinnedPostHeaderComponent;
        }

        public static void m24095a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f21370a = state;
            builder.f21374e.clear();
        }

        public final Component<PinnedPostHeaderComponent> m24097d() {
            int i = 0;
            if (this.f21374e == null || this.f21374e.nextClearBit(0) >= this.f21373d) {
                State state = this.f21370a;
                m24096a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f21373d) {
                if (!this.f21374e.get(i)) {
                    arrayList.add(this.f21372c[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m24096a() {
            super.a();
            this.f21370a = null;
            this.f21371b.f21381c.a(this);
        }
    }

    /* compiled from: Unexpected exception loading stream */
    public class State extends Component<PinnedPostHeaderComponent> implements Cloneable {
        public FeedProps<GraphQLStory> f21375a;
        public E f21376b;
        final /* synthetic */ PinnedPostHeaderComponent f21377c;

        public State(PinnedPostHeaderComponent pinnedPostHeaderComponent) {
            this.f21377c = pinnedPostHeaderComponent;
            super(pinnedPostHeaderComponent);
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
            if (this.f21375a == null ? state.f21375a != null : !this.f21375a.equals(state.f21375a)) {
                return false;
            }
            if (this.f21376b != null) {
                if (this.f21376b.equals(state.f21376b)) {
                    return true;
                }
            } else if (state.f21376b == null) {
                return true;
            }
            return false;
        }
    }

    private static PinnedPostHeaderComponent m24099b(InjectorLike injectorLike) {
        return new PinnedPostHeaderComponent(PinnedPostHeaderComponentSpec.m24111a(injectorLike));
    }

    @Inject
    public PinnedPostHeaderComponent(PinnedPostHeaderComponentSpec pinnedPostHeaderComponentSpec) {
        this.f21380b = pinnedPostHeaderComponentSpec;
    }

    public static PinnedPostHeaderComponent m24098a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PinnedPostHeaderComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21379e) {
                PinnedPostHeaderComponent pinnedPostHeaderComponent;
                if (a2 != null) {
                    pinnedPostHeaderComponent = (PinnedPostHeaderComponent) a2.a(f21379e);
                } else {
                    pinnedPostHeaderComponent = f21378d;
                }
                if (pinnedPostHeaderComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24099b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21379e, b3);
                        } else {
                            f21378d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pinnedPostHeaderComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final InternalNode m24101b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f21380b.m24113a(componentContext, state.f21375a, state.f21376b);
    }

    public final void m24100a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ PinnedPostHeaderComponent f21369c;

                public void run() {
                    this.f21369c.a(eventHandler, obj);
                }
            }, -2079614338);
        }
    }
}

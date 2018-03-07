package com.facebook.feedplugins.storyset.rows.components;

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
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feedplugins.storyset.rows.StorySetPageProps;
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
/* compiled from: at */
public class StorySetPageHeaderComponent<E extends HasFeedListType & HasInvalidate & HasPersistentState & HasPrefetcher & HasRowKey & HasContext> extends ComponentLifecycle {
    private static StorySetPageHeaderComponent f9831d;
    private static final Object f9832e = new Object();
    private final StorySetPageHeaderComponentSpec f9833b;
    public final SynchronizedPool<Builder> f9834c = new SynchronizedPool(2);

    /* compiled from: at */
    public class Builder extends com.facebook.components.Component.Builder<StorySetPageHeaderComponent> {
        public State f9823a;
        final /* synthetic */ StorySetPageHeaderComponent f9824b;
        private String[] f9825c = new String[]{"pageProps", "environment"};
        private int f9826d = 2;
        public BitSet f9827e = new BitSet(this.f9826d);

        public Builder(StorySetPageHeaderComponent storySetPageHeaderComponent) {
            this.f9824b = storySetPageHeaderComponent;
        }

        public static void m10234a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f9823a = state;
            builder.f9827e.clear();
        }

        public final Component<StorySetPageHeaderComponent> m10236d() {
            int i = 0;
            if (this.f9827e == null || this.f9827e.nextClearBit(0) >= this.f9826d) {
                State state = this.f9823a;
                m10235a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f9826d) {
                if (!this.f9827e.get(i)) {
                    arrayList.add(this.f9825c[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m10235a() {
            super.a();
            this.f9823a = null;
            this.f9824b.f9834c.a(this);
        }
    }

    /* compiled from: at */
    public class State extends Component<StorySetPageHeaderComponent> implements Cloneable {
        public StorySetPageProps f9828a;
        public E f9829b;
        final /* synthetic */ StorySetPageHeaderComponent f9830c;

        public State(StorySetPageHeaderComponent storySetPageHeaderComponent) {
            this.f9830c = storySetPageHeaderComponent;
            super(storySetPageHeaderComponent);
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
            if (this.f9828a == null ? state.f9828a != null : !this.f9828a.equals(state.f9828a)) {
                return false;
            }
            if (this.f9829b != null) {
                if (this.f9829b.equals(state.f9829b)) {
                    return true;
                }
            } else if (state.f9829b == null) {
                return true;
            }
            return false;
        }
    }

    private static StorySetPageHeaderComponent m10238b(InjectorLike injectorLike) {
        return new StorySetPageHeaderComponent(StorySetPageHeaderComponentSpec.m10246a(injectorLike));
    }

    @Inject
    public StorySetPageHeaderComponent(StorySetPageHeaderComponentSpec storySetPageHeaderComponentSpec) {
        this.f9833b = storySetPageHeaderComponentSpec;
    }

    public static StorySetPageHeaderComponent m10237a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetPageHeaderComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9832e) {
                StorySetPageHeaderComponent storySetPageHeaderComponent;
                if (a2 != null) {
                    storySetPageHeaderComponent = (StorySetPageHeaderComponent) a2.a(f9832e);
                } else {
                    storySetPageHeaderComponent = f9831d;
                }
                if (storySetPageHeaderComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10238b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9832e, b3);
                        } else {
                            f9831d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetPageHeaderComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final InternalNode m10240b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        StorySetPageHeaderComponentSpec storySetPageHeaderComponentSpec = this.f9833b;
        StorySetPageProps storySetPageProps = state.f9828a;
        ContainerBuilder a = storySetPageHeaderComponentSpec.f9840a.a(componentContext, storySetPageProps.f9733b, state.f9829b);
        a.j(1, 2131427379);
        return a.j();
    }

    public final void m10239a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ StorySetPageHeaderComponent f9822c;

                public void run() {
                    this.f9822c.a(eventHandler, obj);
                }
            }, 690421567);
        }
    }
}

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
/* compiled from: hr/r */
public class DefaultHeaderComponent<E extends HasFeedListType & HasInvalidate & HasMenuButtonProvider & HasPersistentState & HasPrefetcher & HasRowKey & HasContext> extends ComponentLifecycle {
    private static DefaultHeaderComponent f20820d;
    private static final Object f20821e = new Object();
    private final DefaultHeaderComponentSpec f20822b;
    public final Pools$SynchronizedPool<Builder> f20823c = new Pools$SynchronizedPool(2);

    /* compiled from: hr/r */
    public class State extends Component<DefaultHeaderComponent> implements Cloneable {
        FeedProps<GraphQLStory> f22693a;
        E f22694b;
        public boolean f22695c;
        final /* synthetic */ DefaultHeaderComponent f22696d;

        public State(DefaultHeaderComponent defaultHeaderComponent) {
            this.f22696d = defaultHeaderComponent;
            super(defaultHeaderComponent);
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
            if (this.f22693a == null ? state.f22693a != null : !this.f22693a.equals(state.f22693a)) {
                return false;
            }
            if (this.f22694b == null ? state.f22694b != null : !this.f22694b.equals(state.f22694b)) {
                return false;
            }
            if (this.f22695c != state.f22695c) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: hr/r */
    public class Builder extends com.facebook.components.Component.Builder<DefaultHeaderComponent> {
        public State f22697a;
        final /* synthetic */ DefaultHeaderComponent f22698b;
        private String[] f22699c = new String[]{"storyProps", "environment"};
        private int f22700d = 2;
        private BitSet f22701e = new BitSet(this.f22700d);

        public Builder(DefaultHeaderComponent defaultHeaderComponent) {
            this.f22698b = defaultHeaderComponent;
        }

        public static void m30655a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.m30661a(componentContext, i, state);
            builder.f22697a = state;
            builder.f22701e.clear();
        }

        public final Builder m30657a(FeedProps<GraphQLStory> feedProps) {
            this.f22697a.f22693a = feedProps;
            this.f22701e.set(0);
            return this;
        }

        public final Builder m30656a(E e) {
            this.f22697a.f22694b = e;
            this.f22701e.set(1);
            return this;
        }

        public final Component<DefaultHeaderComponent> mo3296d() {
            int i = 0;
            if (this.f22701e == null || this.f22701e.nextClearBit(0) >= this.f22700d) {
                Component component = this.f22697a;
                mo3295a();
                return component;
            }
            List arrayList = new ArrayList();
            while (i < this.f22700d) {
                if (!this.f22701e.get(i)) {
                    arrayList.add(this.f22699c[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void mo3295a() {
            super.mo3295a();
            this.f22697a = null;
            this.f22698b.f20823c.mo741a(this);
        }
    }

    private static DefaultHeaderComponent m28548b(InjectorLike injectorLike) {
        return new DefaultHeaderComponent(DefaultHeaderComponentSpec.m28552a(injectorLike));
    }

    @Inject
    public DefaultHeaderComponent(DefaultHeaderComponentSpec defaultHeaderComponentSpec) {
        this.f20822b = defaultHeaderComponentSpec;
    }

    public static DefaultHeaderComponent m28547a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultHeaderComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20821e) {
                DefaultHeaderComponent defaultHeaderComponent;
                if (a2 != null) {
                    defaultHeaderComponent = (DefaultHeaderComponent) a2.mo818a(f20821e);
                } else {
                    defaultHeaderComponent = f20820d;
                }
                if (defaultHeaderComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28548b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20821e, b3);
                        } else {
                            f20820d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultHeaderComponent;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final Builder m28549a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) this.f20823c.mo740a();
        if (builder == null) {
            builder = new Builder(this);
        }
        Builder.m30655a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode mo3135b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f20822b.m28554a(componentContext, state.f22693a, state.f22694b, state.f22695c);
    }

    public final void mo3134a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.f20393a, new 1(this, eventHandler, obj), 1102641393);
        }
    }
}

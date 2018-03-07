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
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
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
/* compiled from: image/jpeg */
public class HeaderTitleComponent<E extends HasPersistentState & HasInvalidate & HasContext> extends ComponentLifecycle {
    private static HeaderTitleComponent f20509d;
    private static final Object f20510e = new Object();
    private final HeaderTitleComponentSpec f20511b;
    public final Pools$SynchronizedPool<Builder> f20512c = new Pools$SynchronizedPool(2);

    /* compiled from: image/jpeg */
    public class State extends Component<HeaderTitleComponent> implements Cloneable {
        FeedProps<GraphQLStory> f22890a;
        E f22891b;
        final /* synthetic */ HeaderTitleComponent f22892c;

        public State(HeaderTitleComponent headerTitleComponent) {
            this.f22892c = headerTitleComponent;
            super(headerTitleComponent);
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
            if (this.f22890a == null ? state.f22890a != null : !this.f22890a.equals(state.f22890a)) {
                return false;
            }
            if (this.f22891b != null) {
                if (this.f22891b.equals(state.f22891b)) {
                    return true;
                }
            } else if (state.f22891b == null) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: image/jpeg */
    public class Builder extends com.facebook.components.Component.Builder<HeaderTitleComponent> {
        State f22893a;
        final /* synthetic */ HeaderTitleComponent f22894b;
        private String[] f22895c = new String[]{"props", "environment"};
        private int f22896d = 2;
        private BitSet f22897e = new BitSet(this.f22896d);

        public Builder(HeaderTitleComponent headerTitleComponent) {
            this.f22894b = headerTitleComponent;
        }

        public static void m31006a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.m30661a(componentContext, i, state);
            builder.f22893a = state;
            builder.f22897e.clear();
        }

        public final Builder m31008a(FeedProps<GraphQLStory> feedProps) {
            this.f22893a.f22890a = feedProps;
            this.f22897e.set(0);
            return this;
        }

        public final Builder m31007a(E e) {
            this.f22893a.f22891b = e;
            this.f22897e.set(1);
            return this;
        }

        public final Component<HeaderTitleComponent> mo3296d() {
            int i = 0;
            if (this.f22897e == null || this.f22897e.nextClearBit(0) >= this.f22896d) {
                Component component = this.f22893a;
                mo3295a();
                return component;
            }
            List arrayList = new ArrayList();
            while (i < this.f22896d) {
                if (!this.f22897e.get(i)) {
                    arrayList.add(this.f22895c[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void mo3295a() {
            super.mo3295a();
            this.f22893a = null;
            this.f22894b.f20512c.mo741a(this);
        }
    }

    private static HeaderTitleComponent m28251b(InjectorLike injectorLike) {
        return new HeaderTitleComponent(HeaderTitleComponentSpec.m28255a(injectorLike));
    }

    @Inject
    public HeaderTitleComponent(HeaderTitleComponentSpec headerTitleComponentSpec) {
        this.f20511b = headerTitleComponentSpec;
    }

    public static HeaderTitleComponent m28250a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeaderTitleComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20510e) {
                HeaderTitleComponent headerTitleComponent;
                if (a2 != null) {
                    headerTitleComponent = (HeaderTitleComponent) a2.mo818a(f20510e);
                } else {
                    headerTitleComponent = f20509d;
                }
                if (headerTitleComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28251b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20510e, b3);
                        } else {
                            f20509d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = headerTitleComponent;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final Builder m28252a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) this.f20512c.mo740a();
        if (builder == null) {
            builder = new Builder(this);
        }
        Builder.m31006a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode mo3135b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f20511b.m28257a(componentContext, state.f22890a, state.f22891b);
    }

    public final void mo3134a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.f20393a, new 1(this, eventHandler, obj), 1714287744);
        }
    }
}

package com.facebook.feedplugins.greetingcard;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLGreetingCardPromotionFeedUnit;
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
/* compiled from: default_price */
public class GreetingCardPromoHeaderComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f7716b = new SynchronizedPool(2);
    private static GreetingCardPromoHeaderComponent f7717d;
    private static final Object f7718e = new Object();
    private final GreetingCardPromoHeaderComponentSpec f7719c;

    /* compiled from: default_price */
    public class Builder extends com.facebook.components.Component.Builder<GreetingCardPromoHeaderComponent> {
        public State f7709a;
        private String[] f7710b = new String[]{"props", "feedMenuHelper"};
        private int f7711c = 2;
        public BitSet f7712d = new BitSet(this.f7711c);

        public static void m8894a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f7709a = state;
            builder.f7712d.clear();
        }

        public final Component<GreetingCardPromoHeaderComponent> m8896d() {
            int i = 0;
            if (this.f7712d == null || this.f7712d.nextClearBit(0) >= this.f7711c) {
                State state = this.f7709a;
                m8895a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f7711c) {
                if (!this.f7712d.get(i)) {
                    arrayList.add(this.f7710b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m8895a() {
            super.a();
            this.f7709a = null;
            GreetingCardPromoHeaderComponent.f7716b.a(this);
        }
    }

    /* compiled from: default_price */
    public class State extends Component<GreetingCardPromoHeaderComponent> implements Cloneable {
        public FeedProps<GraphQLGreetingCardPromotionFeedUnit> f7713a;
        public BaseFeedStoryMenuHelper f7714b;
        final /* synthetic */ GreetingCardPromoHeaderComponent f7715c;

        public State(GreetingCardPromoHeaderComponent greetingCardPromoHeaderComponent) {
            this.f7715c = greetingCardPromoHeaderComponent;
            super(greetingCardPromoHeaderComponent);
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
            if (this.f7713a == null ? state.f7713a != null : !this.f7713a.equals(state.f7713a)) {
                return false;
            }
            if (this.f7714b != null) {
                if (this.f7714b.equals(state.f7714b)) {
                    return true;
                }
            } else if (state.f7714b == null) {
                return true;
            }
            return false;
        }
    }

    private static GreetingCardPromoHeaderComponent m8898b(InjectorLike injectorLike) {
        return new GreetingCardPromoHeaderComponent(GreetingCardPromoHeaderComponentSpec.m8909a(injectorLike));
    }

    @Inject
    public GreetingCardPromoHeaderComponent(GreetingCardPromoHeaderComponentSpec greetingCardPromoHeaderComponentSpec) {
        this.f7719c = greetingCardPromoHeaderComponentSpec;
    }

    public static GreetingCardPromoHeaderComponent m8897a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GreetingCardPromoHeaderComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7718e) {
                GreetingCardPromoHeaderComponent greetingCardPromoHeaderComponent;
                if (a2 != null) {
                    greetingCardPromoHeaderComponent = (GreetingCardPromoHeaderComponent) a2.a(f7718e);
                } else {
                    greetingCardPromoHeaderComponent = f7717d;
                }
                if (greetingCardPromoHeaderComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8898b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7718e, b3);
                        } else {
                            f7717d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = greetingCardPromoHeaderComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final InternalNode m8900b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f7719c.m8911a(componentContext, state.f7713a, state.f7714b);
    }

    public final void m8899a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ GreetingCardPromoHeaderComponent f7708c;

                public void run() {
                    this.f7708c.a(eventHandler, obj);
                }
            }, -1157666271);
        }
    }
}

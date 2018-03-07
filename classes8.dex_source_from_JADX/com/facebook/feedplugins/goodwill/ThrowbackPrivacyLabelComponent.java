package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.widget.Text;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
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
/* compiled from: goodwill_campaign_final_step_composer */
public class ThrowbackPrivacyLabelComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f12470b = new SynchronizedPool(2);
    private static ThrowbackPrivacyLabelComponent f12471d;
    private static final Object f12472e = new Object();
    private final ThrowbackPrivacyLabelComponentSpec f12473c;

    /* compiled from: goodwill_campaign_final_step_composer */
    public class Builder extends com.facebook.components.Component.Builder<ThrowbackPrivacyLabelComponent> {
        public State f12464a;
        private String[] f12465b = new String[]{"props"};
        private int f12466c = 1;
        public BitSet f12467d = new BitSet(this.f12466c);

        public static void m14354a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f12464a = state;
            builder.f12467d.clear();
        }

        public final Component<ThrowbackPrivacyLabelComponent> m14356d() {
            int i = 0;
            if (this.f12467d == null || this.f12467d.nextClearBit(0) >= this.f12466c) {
                State state = this.f12464a;
                m14355a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f12466c) {
                if (!this.f12467d.get(i)) {
                    arrayList.add(this.f12465b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m14355a() {
            super.a();
            this.f12464a = null;
            ThrowbackPrivacyLabelComponent.f12470b.a(this);
        }
    }

    /* compiled from: goodwill_campaign_final_step_composer */
    public class State extends Component<ThrowbackPrivacyLabelComponent> implements Cloneable {
        public FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit> f12468a;
        final /* synthetic */ ThrowbackPrivacyLabelComponent f12469b;

        public State(ThrowbackPrivacyLabelComponent throwbackPrivacyLabelComponent) {
            this.f12469b = throwbackPrivacyLabelComponent;
            super(throwbackPrivacyLabelComponent);
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
            if (this.f12468a != null) {
                if (this.f12468a.equals(state.f12468a)) {
                    return true;
                }
            } else if (state.f12468a == null) {
                return true;
            }
            return false;
        }
    }

    private static ThrowbackPrivacyLabelComponent m14358b(InjectorLike injectorLike) {
        return new ThrowbackPrivacyLabelComponent(ThrowbackPrivacyLabelComponentSpec.m14368a(injectorLike));
    }

    @Inject
    public ThrowbackPrivacyLabelComponent(ThrowbackPrivacyLabelComponentSpec throwbackPrivacyLabelComponentSpec) {
        this.f12473c = throwbackPrivacyLabelComponentSpec;
    }

    public static ThrowbackPrivacyLabelComponent m14357a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackPrivacyLabelComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12472e) {
                ThrowbackPrivacyLabelComponent throwbackPrivacyLabelComponent;
                if (a2 != null) {
                    throwbackPrivacyLabelComponent = (ThrowbackPrivacyLabelComponent) a2.a(f12472e);
                } else {
                    throwbackPrivacyLabelComponent = f12471d;
                }
                if (throwbackPrivacyLabelComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14358b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12472e, b3);
                        } else {
                            f12471d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackPrivacyLabelComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final InternalNode m14360b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        ThrowbackPrivacyLabelComponentSpec throwbackPrivacyLabelComponentSpec = this.f12473c;
        return Text.a(componentContext).a(ThrowbackPrivacyLabelPartDefinition.m14371a((GraphQLGoodwillThrowbackPromotionFeedUnit) state.f12468a.a, throwbackPrivacyLabelComponentSpec.f12481a, throwbackPrivacyLabelComponentSpec.f12482b)).o(2131427400).l(2131362053).a(false).b();
    }

    public final void m14359a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ThrowbackPrivacyLabelComponent f12463c;

                public void run() {
                    this.f12463c.a(eventHandler, obj);
                }
            }, 180070568);
        }
    }
}

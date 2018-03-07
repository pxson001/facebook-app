package com.facebook.feedplugins.quickpromotion;

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
import com.facebook.graphql.model.GraphQLQuickPromotionCreative;
import com.facebook.graphql.model.GraphQLQuickPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.QuickPromotionFeedUnitHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: category_preset */
public class QuickPromotionSocialContextComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f8953b = new SynchronizedPool(2);
    private static QuickPromotionSocialContextComponent f8954d;
    private static final Object f8955e = new Object();
    private final QuickPromotionSocialContextComponentSpec f8956c;

    /* compiled from: category_preset */
    public class Builder extends com.facebook.components.Component.Builder<QuickPromotionSocialContextComponent> {
        public State f8947a;
        private String[] f8948b = new String[]{"props"};
        private int f8949c = 1;
        public BitSet f8950d = new BitSet(this.f8949c);

        public static void m9668a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f8947a = state;
            builder.f8950d.clear();
        }

        public final Component<QuickPromotionSocialContextComponent> m9670d() {
            int i = 0;
            if (this.f8950d == null || this.f8950d.nextClearBit(0) >= this.f8949c) {
                State state = this.f8947a;
                m9669a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f8949c) {
                if (!this.f8950d.get(i)) {
                    arrayList.add(this.f8948b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m9669a() {
            super.a();
            this.f8947a = null;
            QuickPromotionSocialContextComponent.f8953b.a(this);
        }
    }

    /* compiled from: category_preset */
    public class State extends Component<QuickPromotionSocialContextComponent> implements Cloneable {
        public FeedProps<GraphQLQuickPromotionFeedUnit> f8951a;
        final /* synthetic */ QuickPromotionSocialContextComponent f8952b;

        public State(QuickPromotionSocialContextComponent quickPromotionSocialContextComponent) {
            this.f8952b = quickPromotionSocialContextComponent;
            super(quickPromotionSocialContextComponent);
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
            if (this.f8951a != null) {
                if (this.f8951a.equals(state.f8951a)) {
                    return true;
                }
            } else if (state.f8951a == null) {
                return true;
            }
            return false;
        }
    }

    private static QuickPromotionSocialContextComponent m9672b(InjectorLike injectorLike) {
        return new QuickPromotionSocialContextComponent(QuickPromotionSocialContextComponentSpec.m9683a(injectorLike));
    }

    @Inject
    public QuickPromotionSocialContextComponent(QuickPromotionSocialContextComponentSpec quickPromotionSocialContextComponentSpec) {
        this.f8956c = quickPromotionSocialContextComponentSpec;
    }

    public static QuickPromotionSocialContextComponent m9671a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuickPromotionSocialContextComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8955e) {
                QuickPromotionSocialContextComponent quickPromotionSocialContextComponent;
                if (a2 != null) {
                    quickPromotionSocialContextComponent = (QuickPromotionSocialContextComponent) a2.a(f8955e);
                } else {
                    quickPromotionSocialContextComponent = f8954d;
                }
                if (quickPromotionSocialContextComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9672b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8955e, b3);
                        } else {
                            f8954d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = quickPromotionSocialContextComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final InternalNode m9674b(ComponentContext componentContext, Component component) {
        return Text.a(componentContext, 2131626698).a(((GraphQLTextWithEntities) Preconditions.checkNotNull(((GraphQLQuickPromotionCreative) Preconditions.checkNotNull(QuickPromotionFeedUnitHelper.c((GraphQLQuickPromotionFeedUnit) ((State) component).f8951a.a))).r())).a()).q(2131430350).a(false).d(true).c(true).b();
    }

    public final void m9673a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ QuickPromotionSocialContextComponent f8946c;

                public void run() {
                    this.f8946c.a(eventHandler, obj);
                }
            }, 2121688291);
        }
    }
}

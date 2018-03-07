package com.facebook.feedplugins.base.footer.components;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ClickEvent;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.widget.DownstateType;
import com.facebook.feedplugins.base.footer.ui.Footer.FooterButtonId;
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
/* compiled from: TAP_HEADER */
public class BasicFooterButtonComponent<E extends HasFeedListType & HasPersistentState> extends ComponentLifecycle {
    private static BasicFooterButtonComponent f22951d;
    private static final Object f22952e = new Object();
    private final BasicFooterButtonComponentSpec f22953b;
    public final SynchronizedPool<Builder> f22954c = new SynchronizedPool(2);

    /* compiled from: TAP_HEADER */
    public class Builder extends com.facebook.components.Component.Builder<BasicFooterButtonComponent> {
        State f22939a;
        final /* synthetic */ BasicFooterButtonComponent f22940b;
        private String[] f22941c = new String[]{"storyProps", "footerButtonId", "downstateType", "showIcon", "environment"};
        private int f22942d = 5;
        private BitSet f22943e = new BitSet(this.f22942d);

        public Builder(BasicFooterButtonComponent basicFooterButtonComponent) {
            this.f22940b = basicFooterButtonComponent;
        }

        public static void m25448a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f22939a = state;
            builder.f22943e.clear();
        }

        public final Builder m25450a(FeedProps<GraphQLStory> feedProps) {
            this.f22939a.f22944a = feedProps;
            this.f22943e.set(0);
            return this;
        }

        public final Builder m25452a(FooterButtonId footerButtonId) {
            this.f22939a.f22945b = footerButtonId;
            this.f22943e.set(1);
            return this;
        }

        public final Builder m25451a(DownstateType downstateType) {
            this.f22939a.f22946c = downstateType;
            this.f22943e.set(2);
            return this;
        }

        public final Builder m25453a(boolean z) {
            this.f22939a.f22947d = z;
            this.f22943e.set(3);
            return this;
        }

        public final Builder m25449a(E e) {
            this.f22939a.f22948e = e;
            this.f22943e.set(4);
            return this;
        }

        public final Component<BasicFooterButtonComponent> m25455d() {
            int i = 0;
            if (this.f22943e == null || this.f22943e.nextClearBit(0) >= this.f22942d) {
                State state = this.f22939a;
                m25454a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f22942d) {
                if (!this.f22943e.get(i)) {
                    arrayList.add(this.f22941c[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m25454a() {
            super.a();
            this.f22939a = null;
            this.f22940b.f22954c.a(this);
        }
    }

    /* compiled from: TAP_HEADER */
    public class State extends Component<BasicFooterButtonComponent> implements Cloneable {
        FeedProps<GraphQLStory> f22944a;
        FooterButtonId f22945b;
        DownstateType f22946c;
        boolean f22947d;
        E f22948e;
        boolean f22949f = true;
        final /* synthetic */ BasicFooterButtonComponent f22950g;

        public State(BasicFooterButtonComponent basicFooterButtonComponent) {
            this.f22950g = basicFooterButtonComponent;
            super(basicFooterButtonComponent);
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
            if (this.f22944a == null ? state.f22944a != null : !this.f22944a.equals(state.f22944a)) {
                return false;
            }
            if (this.f22945b == null ? state.f22945b != null : !this.f22945b.equals(state.f22945b)) {
                return false;
            }
            if (this.f22946c == null ? state.f22946c != null : !this.f22946c.equals(state.f22946c)) {
                return false;
            }
            if (this.f22947d != state.f22947d) {
                return false;
            }
            if (this.f22948e == null ? state.f22948e != null : !this.f22948e.equals(state.f22948e)) {
                return false;
            }
            if (this.f22949f != state.f22949f) {
                return false;
            }
            return true;
        }
    }

    private static BasicFooterButtonComponent m25459b(InjectorLike injectorLike) {
        return new BasicFooterButtonComponent(BasicFooterButtonComponentSpec.m25463a(injectorLike));
    }

    @Inject
    public BasicFooterButtonComponent(BasicFooterButtonComponentSpec basicFooterButtonComponentSpec) {
        this.f22953b = basicFooterButtonComponentSpec;
    }

    public static BasicFooterButtonComponent m25456a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BasicFooterButtonComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22952e) {
                BasicFooterButtonComponent basicFooterButtonComponent;
                if (a2 != null) {
                    basicFooterButtonComponent = (BasicFooterButtonComponent) a2.a(f22952e);
                } else {
                    basicFooterButtonComponent = f22951d;
                }
                if (basicFooterButtonComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25459b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22952e, b3);
                        } else {
                            f22951d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = basicFooterButtonComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Builder m25460a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) this.f22954c.a();
        if (builder == null) {
            builder = new Builder(this);
        }
        Builder.m25448a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode m25462b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f22953b.m25465a(componentContext, state.f22944a, state.f22945b, state.f22946c, state.f22947d, state.f22948e);
    }

    private void m25457a(View view, Component component) {
        State state = (State) component;
        this.f22953b.m25466a(view, state.f22944a, state.f22945b, state.f22948e, state.f22949f);
    }

    public static EventHandler m25458b(ComponentContext componentContext) {
        return ComponentLifecycle.a(componentContext, 2039709932, null);
    }

    public final void m25461a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ BasicFooterButtonComponent f22938c;

                public void run() {
                    this.f22938c.a(eventHandler, obj);
                }
            }, -855156980);
            return;
        }
        switch (eventHandler.b) {
            case 2039709932:
                m25457a(((ClickEvent) obj).a, eventHandler.a);
                return;
            default:
                return;
        }
    }
}

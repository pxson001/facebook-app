package com.facebook.feed.rows.sections.components;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools$SynchronizedPool;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler$Position;
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
/* compiled from: identifiers/ */
public class FeedBackgroundStylerComponent extends ComponentLifecycle {
    public static final Pools$SynchronizedPool<Builder> f20595b = new Pools$SynchronizedPool(2);
    private static FeedBackgroundStylerComponent f20596d;
    private static final Object f20597e = new Object();
    private final FeedBackgroundStylerComponentSpec f20598c;

    /* compiled from: identifiers/ */
    public class State extends Component<FeedBackgroundStylerComponent> implements Cloneable {
        Component<?> f22709a;
        BackgroundStyler$Position f22710b;
        int f22711c;
        StylingData f22712d;
        public boolean f22713e;
        final /* synthetic */ FeedBackgroundStylerComponent f22714f;

        public State(FeedBackgroundStylerComponent feedBackgroundStylerComponent) {
            this.f22714f = feedBackgroundStylerComponent;
            super(feedBackgroundStylerComponent);
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
            if (this.f22709a == null ? state.f22709a != null : !this.f22709a.equals(state.f22709a)) {
                return false;
            }
            if (this.f22710b == null ? state.f22710b != null : !this.f22710b.equals(state.f22710b)) {
                return false;
            }
            if (this.f22711c != state.f22711c) {
                return false;
            }
            if (this.f22712d == null ? state.f22712d != null : !this.f22712d.equals(state.f22712d)) {
                return false;
            }
            if (this.f22713e != state.f22713e) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: identifiers/ */
    public class Builder extends com.facebook.components.Component.Builder<FeedBackgroundStylerComponent> {
        public State f22715a;
        private String[] f22716b = new String[]{"delegate", "position", "renderingDepth", "stylingData"};
        private int f22717c = 4;
        private BitSet f22718d = new BitSet(this.f22717c);

        public static void m30680a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.m30661a(componentContext, i, state);
            builder.f22715a = state;
            builder.f22718d.clear();
        }

        public final Builder m30681a(Component<?> component) {
            this.f22715a.f22709a = component;
            this.f22718d.set(0);
            return this;
        }

        public final Builder m30683a(BackgroundStyler$Position backgroundStyler$Position) {
            this.f22715a.f22710b = backgroundStyler$Position;
            this.f22718d.set(1);
            return this;
        }

        public final Builder m30686h(int i) {
            this.f22715a.f22711c = i;
            this.f22718d.set(2);
            return this;
        }

        public final Builder m30682a(StylingData stylingData) {
            this.f22715a.f22712d = stylingData;
            this.f22718d.set(3);
            return this;
        }

        public final Component<FeedBackgroundStylerComponent> mo3296d() {
            int i = 0;
            if (this.f22718d == null || this.f22718d.nextClearBit(0) >= this.f22717c) {
                Component component = this.f22715a;
                mo3295a();
                return component;
            }
            List arrayList = new ArrayList();
            while (i < this.f22717c) {
                if (!this.f22718d.get(i)) {
                    arrayList.add(this.f22716b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void mo3295a() {
            super.mo3295a();
            this.f22715a = null;
            FeedBackgroundStylerComponent.f20595b.mo741a(this);
        }
    }

    private static FeedBackgroundStylerComponent m28342b(InjectorLike injectorLike) {
        return new FeedBackgroundStylerComponent(FeedBackgroundStylerComponentSpec.m28346a(injectorLike));
    }

    @Inject
    public FeedBackgroundStylerComponent(FeedBackgroundStylerComponentSpec feedBackgroundStylerComponentSpec) {
        this.f20598c = feedBackgroundStylerComponentSpec;
    }

    public static FeedBackgroundStylerComponent m28341a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedBackgroundStylerComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20597e) {
                FeedBackgroundStylerComponent feedBackgroundStylerComponent;
                if (a2 != null) {
                    feedBackgroundStylerComponent = (FeedBackgroundStylerComponent) a2.mo818a(f20597e);
                } else {
                    feedBackgroundStylerComponent = f20596d;
                }
                if (feedBackgroundStylerComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28342b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20597e, b3);
                        } else {
                            f20596d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedBackgroundStylerComponent;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final Builder m28343a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) f20595b.mo740a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m30680a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode mo3135b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f20598c.m28348a(componentContext, state.f22709a, state.f22710b, state.f22711c, state.f22712d, state.f22713e);
    }

    public final void mo3134a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.f20393a, new 1(this, eventHandler, obj), -476166705);
        }
    }
}

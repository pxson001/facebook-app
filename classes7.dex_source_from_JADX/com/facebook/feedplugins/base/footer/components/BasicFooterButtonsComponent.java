package com.facebook.feedplugins.base.footer.components;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.widget.DownstateType;
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
/* compiled from: TAG_PLACE_AFTER_PHOTO */
public class BasicFooterButtonsComponent<E extends HasFeedListType & HasPersistentState> extends ComponentLifecycle {
    private static BasicFooterButtonsComponent f22976d;
    private static final Object f22977e = new Object();
    private final BasicFooterButtonsComponentSpec f22978b;
    public final SynchronizedPool<Builder> f22979c = new SynchronizedPool(2);

    /* compiled from: TAG_PLACE_AFTER_PHOTO */
    public class Builder extends com.facebook.components.Component.Builder<BasicFooterButtonsComponent> {
        public State f22963a;
        final /* synthetic */ BasicFooterButtonsComponent f22964b;
        private String[] f22965c = new String[]{"storyProps", "canLike", "canComment", "canShare", "downstateType", "ufiWidthPx", "environment"};
        private int f22966d = 7;
        public BitSet f22967e = new BitSet(this.f22966d);

        public Builder(BasicFooterButtonsComponent basicFooterButtonsComponent) {
            this.f22964b = basicFooterButtonsComponent;
        }

        public static void m25467a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f22963a = state;
            builder.f22967e.clear();
        }

        public final Component<BasicFooterButtonsComponent> m25469d() {
            int i = 0;
            if (this.f22967e == null || this.f22967e.nextClearBit(0) >= this.f22966d) {
                State state = this.f22963a;
                m25468a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f22966d) {
                if (!this.f22967e.get(i)) {
                    arrayList.add(this.f22965c[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m25468a() {
            super.a();
            this.f22963a = null;
            this.f22964b.f22979c.a(this);
        }
    }

    /* compiled from: TAG_PLACE_AFTER_PHOTO */
    public class State extends Component<BasicFooterButtonsComponent> implements Cloneable {
        public FeedProps<GraphQLStory> f22968a;
        public boolean f22969b;
        public boolean f22970c;
        public boolean f22971d;
        public DownstateType f22972e;
        public int f22973f;
        public E f22974g;
        final /* synthetic */ BasicFooterButtonsComponent f22975h;

        public State(BasicFooterButtonsComponent basicFooterButtonsComponent) {
            this.f22975h = basicFooterButtonsComponent;
            super(basicFooterButtonsComponent);
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
            if (this.f22968a == null ? state.f22968a != null : !this.f22968a.equals(state.f22968a)) {
                return false;
            }
            if (this.f22969b != state.f22969b) {
                return false;
            }
            if (this.f22970c != state.f22970c) {
                return false;
            }
            if (this.f22971d != state.f22971d) {
                return false;
            }
            if (this.f22972e == null ? state.f22972e != null : !this.f22972e.equals(state.f22972e)) {
                return false;
            }
            if (this.f22973f != state.f22973f) {
                return false;
            }
            if (this.f22974g != null) {
                if (this.f22974g.equals(state.f22974g)) {
                    return true;
                }
            } else if (state.f22974g == null) {
                return true;
            }
            return false;
        }
    }

    private static BasicFooterButtonsComponent m25471b(InjectorLike injectorLike) {
        return new BasicFooterButtonsComponent(BasicFooterButtonsComponentSpec.m25475a(injectorLike));
    }

    @Inject
    public BasicFooterButtonsComponent(BasicFooterButtonsComponentSpec basicFooterButtonsComponentSpec) {
        this.f22978b = basicFooterButtonsComponentSpec;
    }

    public static BasicFooterButtonsComponent m25470a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BasicFooterButtonsComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22977e) {
                BasicFooterButtonsComponent basicFooterButtonsComponent;
                if (a2 != null) {
                    basicFooterButtonsComponent = (BasicFooterButtonsComponent) a2.a(f22977e);
                } else {
                    basicFooterButtonsComponent = f22976d;
                }
                if (basicFooterButtonsComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25471b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22977e, b3);
                        } else {
                            f22976d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = basicFooterButtonsComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Builder m25472a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) this.f22979c.a();
        if (builder == null) {
            builder = new Builder(this);
        }
        Builder.m25467a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode m25474b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f22978b.m25477a(componentContext, state.f22968a, state.f22969b, state.f22970c, state.f22971d, state.f22972e, state.f22973f, state.f22974g);
    }

    public final void m25473a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ BasicFooterButtonsComponent f22962c;

                public void run() {
                    this.f22962c.a(eventHandler, obj);
                }
            }, -1711984425);
        }
    }
}

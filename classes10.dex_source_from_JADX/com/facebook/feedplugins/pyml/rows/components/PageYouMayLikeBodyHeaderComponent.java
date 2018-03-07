package com.facebook.feedplugins.pyml.rows.components;

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
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feedplugins.pyml.rows.PageYouMayLikePartDefinition.Props;
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
/* compiled from: android_dialog_configs */
public class PageYouMayLikeBodyHeaderComponent<E extends HasContext & HasFeedListType & HasIsAsync & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> extends ComponentLifecycle {
    private static PageYouMayLikeBodyHeaderComponent f19722d;
    private static final Object f19723e = new Object();
    private final PageYouMayLikeBodyHeaderComponentSpec f19724b;
    public final SynchronizedPool<Builder> f19725c = new SynchronizedPool(2);

    /* compiled from: android_dialog_configs */
    public class Builder extends com.facebook.components.Component.Builder<PageYouMayLikeBodyHeaderComponent> {
        State f19714a;
        final /* synthetic */ PageYouMayLikeBodyHeaderComponent f19715b;
        private String[] f19716c = new String[]{"environment", "bodyProps"};
        private int f19717d = 2;
        private BitSet f19718e = new BitSet(this.f19717d);

        public Builder(PageYouMayLikeBodyHeaderComponent pageYouMayLikeBodyHeaderComponent) {
            this.f19715b = pageYouMayLikeBodyHeaderComponent;
        }

        public static void m19987a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f19714a = state;
            builder.f19718e.clear();
        }

        public final Builder m19988a(E e) {
            this.f19714a.f19719a = e;
            this.f19718e.set(0);
            return this;
        }

        public final Builder m19989a(Props props) {
            this.f19714a.f19720b = props;
            this.f19718e.set(1);
            return this;
        }

        public final Component<PageYouMayLikeBodyHeaderComponent> m19991d() {
            int i = 0;
            if (this.f19718e == null || this.f19718e.nextClearBit(0) >= this.f19717d) {
                State state = this.f19714a;
                m19990a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f19717d) {
                if (!this.f19718e.get(i)) {
                    arrayList.add(this.f19716c[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m19990a() {
            super.a();
            this.f19714a = null;
            this.f19715b.f19725c.a(this);
        }
    }

    /* compiled from: android_dialog_configs */
    public class State extends Component<PageYouMayLikeBodyHeaderComponent> implements Cloneable {
        E f19719a;
        Props f19720b;
        final /* synthetic */ PageYouMayLikeBodyHeaderComponent f19721c;

        public State(PageYouMayLikeBodyHeaderComponent pageYouMayLikeBodyHeaderComponent) {
            this.f19721c = pageYouMayLikeBodyHeaderComponent;
            super(pageYouMayLikeBodyHeaderComponent);
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
            if (this.f19719a == null ? state.f19719a != null : !this.f19719a.equals(state.f19719a)) {
                return false;
            }
            if (this.f19720b != null) {
                if (this.f19720b.equals(state.f19720b)) {
                    return true;
                }
            } else if (state.f19720b == null) {
                return true;
            }
            return false;
        }
    }

    private static PageYouMayLikeBodyHeaderComponent m19993b(InjectorLike injectorLike) {
        return new PageYouMayLikeBodyHeaderComponent(PageYouMayLikeBodyHeaderComponentSpec.m19999a(injectorLike));
    }

    @Inject
    public PageYouMayLikeBodyHeaderComponent(PageYouMayLikeBodyHeaderComponentSpec pageYouMayLikeBodyHeaderComponentSpec) {
        this.f19724b = pageYouMayLikeBodyHeaderComponentSpec;
    }

    public static PageYouMayLikeBodyHeaderComponent m19992a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageYouMayLikeBodyHeaderComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19723e) {
                PageYouMayLikeBodyHeaderComponent pageYouMayLikeBodyHeaderComponent;
                if (a2 != null) {
                    pageYouMayLikeBodyHeaderComponent = (PageYouMayLikeBodyHeaderComponent) a2.a(f19723e);
                } else {
                    pageYouMayLikeBodyHeaderComponent = f19722d;
                }
                if (pageYouMayLikeBodyHeaderComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m19993b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19723e, b3);
                        } else {
                            f19722d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageYouMayLikeBodyHeaderComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Builder m19994a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) this.f19725c.a();
        if (builder == null) {
            builder = new Builder(this);
        }
        Builder.m19987a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode m19996b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f19724b.m20001a(componentContext, state.f19719a, state.f19720b);
    }

    public final void m19995a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ PageYouMayLikeBodyHeaderComponent f19713c;

                public void run() {
                    this.f19713c.a(eventHandler, obj);
                }
            }, -2039268741);
        }
    }
}

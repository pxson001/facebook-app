package com.facebook.feedplugins.pyml.rows.components;

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
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feedplugins.pyml.rows.PageYouMayLikePartDefinition;
import com.facebook.feedplugins.pyml.rows.PymlPagePartDefinition;
import com.facebook.feedplugins.pyml.rows.PymlPagePartDefinition.Props;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
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
/* compiled from: android.webkit.WebViewClassic */
public class PageYouMayLikeComponent<E extends HasFeedListType & HasPositionInformation & HasPersistentState & HasMenuButtonProvider & HasPrefetcher & HasRowKey & HasContext & HasIsAsync> extends ComponentLifecycle {
    private static PageYouMayLikeComponent f19764d;
    private static final Object f19765e = new Object();
    private final PageYouMayLikeComponentSpec f19766b;
    public final SynchronizedPool<Builder> f19767c = new SynchronizedPool(2);

    /* compiled from: android.webkit.WebViewClassic */
    public class Builder extends com.facebook.components.Component.Builder<PageYouMayLikeComponent> {
        State f19756a;
        final /* synthetic */ PageYouMayLikeComponent f19757b;
        private String[] f19758c = new String[]{"environment", "pageProps"};
        private int f19759d = 2;
        private BitSet f19760e = new BitSet(this.f19759d);

        public Builder(PageYouMayLikeComponent pageYouMayLikeComponent) {
            this.f19757b = pageYouMayLikeComponent;
        }

        public static void m20016a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f19756a = state;
            builder.f19760e.clear();
        }

        public final Builder m20017a(E e) {
            this.f19756a.f19761a = e;
            this.f19760e.set(0);
            return this;
        }

        public final Builder m20018a(Props props) {
            this.f19756a.f19762b = props;
            this.f19760e.set(1);
            return this;
        }

        public final Component<PageYouMayLikeComponent> m20020d() {
            int i = 0;
            if (this.f19760e == null || this.f19760e.nextClearBit(0) >= this.f19759d) {
                State state = this.f19756a;
                m20019a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f19759d) {
                if (!this.f19760e.get(i)) {
                    arrayList.add(this.f19758c[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m20019a() {
            super.a();
            this.f19756a = null;
            this.f19757b.f19767c.a(this);
        }
    }

    /* compiled from: android.webkit.WebViewClassic */
    public class State extends Component<PageYouMayLikeComponent> implements Cloneable {
        E f19761a;
        Props f19762b;
        final /* synthetic */ PageYouMayLikeComponent f19763c;

        public State(PageYouMayLikeComponent pageYouMayLikeComponent) {
            this.f19763c = pageYouMayLikeComponent;
            super(pageYouMayLikeComponent);
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
            if (this.f19761a == null ? state.f19761a != null : !this.f19761a.equals(state.f19761a)) {
                return false;
            }
            if (this.f19762b != null) {
                if (this.f19762b.equals(state.f19762b)) {
                    return true;
                }
            } else if (state.f19762b == null) {
                return true;
            }
            return false;
        }
    }

    private static PageYouMayLikeComponent m20024b(InjectorLike injectorLike) {
        return new PageYouMayLikeComponent(PageYouMayLikeComponentSpec.m20030a(injectorLike));
    }

    @Inject
    public PageYouMayLikeComponent(PageYouMayLikeComponentSpec pageYouMayLikeComponentSpec) {
        this.f19766b = pageYouMayLikeComponentSpec;
    }

    public static PageYouMayLikeComponent m20021a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageYouMayLikeComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19765e) {
                PageYouMayLikeComponent pageYouMayLikeComponent;
                if (a2 != null) {
                    pageYouMayLikeComponent = (PageYouMayLikeComponent) a2.a(f19765e);
                } else {
                    pageYouMayLikeComponent = f19764d;
                }
                if (pageYouMayLikeComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m20024b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19765e, b3);
                        } else {
                            f19764d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageYouMayLikeComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final InternalNode m20026b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f19766b.m20033a(componentContext, state.f19761a, state.f19762b);
    }

    private void m20022a(View view, Component component) {
        State state = (State) component;
        PageYouMayLikeComponentSpec pageYouMayLikeComponentSpec = this.f19766b;
        Props props = state.f19762b;
        view.setTag(2131558518, PageYouMayLikePartDefinition.a(pageYouMayLikeComponentSpec.f19778i, (ScrollableItemListFeedUnit) props.b.a, props.a));
        PageYouMayLikePartDefinition.a(view, PymlPagePartDefinition.a(pageYouMayLikeComponentSpec.f19774e, (ScrollableItemListFeedUnit) props.b.a), props.a, pageYouMayLikeComponentSpec.f19776g, pageYouMayLikeComponentSpec.f19777h);
    }

    public static EventHandler m20023b(ComponentContext componentContext) {
        return ComponentLifecycle.a(componentContext, 339714823, null);
    }

    public final void m20025a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ PageYouMayLikeComponent f19755c;

                public void run() {
                    this.f19755c.a(eventHandler, obj);
                }
            }, 963947856);
            return;
        }
        switch (eventHandler.b) {
            case 339714823:
                m20022a(((ClickEvent) obj).a, eventHandler.a);
                return;
            default:
                return;
        }
    }
}

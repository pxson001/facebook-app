package com.facebook.feedplugins.pyml.rows.components;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ClickEvent;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.Container;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.widget.SolidColor;
import com.facebook.components.widget.Text;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feedplugins.pyml.rows.PymlHeaderPartDefinition.Props;
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
/* compiled from: android.webkit.WebSettingsClassic */
public class PageYouMayLikeHeaderComponent<E extends HasContext & HasIsAsync & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> extends ComponentLifecycle {
    private static PageYouMayLikeHeaderComponent f19790d;
    private static final Object f19791e = new Object();
    private final PageYouMayLikeHeaderComponentSpec f19792b;
    public final SynchronizedPool<Builder> f19793c = new SynchronizedPool(2);

    /* compiled from: android.webkit.WebSettingsClassic */
    public class Builder extends com.facebook.components.Component.Builder<PageYouMayLikeHeaderComponent> {
        public State f19782a;
        final /* synthetic */ PageYouMayLikeHeaderComponent f19783b;
        private String[] f19784c = new String[]{"environment", "headerProps"};
        private int f19785d = 2;
        public BitSet f19786e = new BitSet(this.f19785d);

        public Builder(PageYouMayLikeHeaderComponent pageYouMayLikeHeaderComponent) {
            this.f19783b = pageYouMayLikeHeaderComponent;
        }

        public static void m20034a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f19782a = state;
            builder.f19786e.clear();
        }

        public final Component<PageYouMayLikeHeaderComponent> m20036d() {
            int i = 0;
            if (this.f19786e == null || this.f19786e.nextClearBit(0) >= this.f19785d) {
                State state = this.f19782a;
                m20035a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f19785d) {
                if (!this.f19786e.get(i)) {
                    arrayList.add(this.f19784c[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m20035a() {
            super.a();
            this.f19782a = null;
            this.f19783b.f19793c.a(this);
        }
    }

    /* compiled from: android.webkit.WebSettingsClassic */
    public class State extends Component<PageYouMayLikeHeaderComponent> implements Cloneable {
        public E f19787a;
        public Props f19788b;
        final /* synthetic */ PageYouMayLikeHeaderComponent f19789c;

        public State(PageYouMayLikeHeaderComponent pageYouMayLikeHeaderComponent) {
            this.f19789c = pageYouMayLikeHeaderComponent;
            super(pageYouMayLikeHeaderComponent);
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
            if (this.f19787a == null ? state.f19787a != null : !this.f19787a.equals(state.f19787a)) {
                return false;
            }
            if (this.f19788b != null) {
                if (this.f19788b.equals(state.f19788b)) {
                    return true;
                }
            } else if (state.f19788b == null) {
                return true;
            }
            return false;
        }
    }

    private static PageYouMayLikeHeaderComponent m20039b(InjectorLike injectorLike) {
        return new PageYouMayLikeHeaderComponent(PageYouMayLikeHeaderComponentSpec.m20043a(injectorLike));
    }

    @Inject
    public PageYouMayLikeHeaderComponent(PageYouMayLikeHeaderComponentSpec pageYouMayLikeHeaderComponentSpec) {
        this.f19792b = pageYouMayLikeHeaderComponentSpec;
    }

    public static PageYouMayLikeHeaderComponent m20037a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageYouMayLikeHeaderComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19791e) {
                PageYouMayLikeHeaderComponent pageYouMayLikeHeaderComponent;
                if (a2 != null) {
                    pageYouMayLikeHeaderComponent = (PageYouMayLikeHeaderComponent) a2.a(f19791e);
                } else {
                    pageYouMayLikeHeaderComponent = f19790d;
                }
                if (pageYouMayLikeHeaderComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m20039b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19791e, b3);
                        } else {
                            f19790d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageYouMayLikeHeaderComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final InternalNode m20041b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        PageYouMayLikeHeaderComponentSpec pageYouMayLikeHeaderComponentSpec = this.f19792b;
        HasContext hasContext = state.f19787a;
        Props props = state.f19788b;
        return Container.a(componentContext).C(0).a(Container.a(componentContext).C(2).D(2).a(Text.a(componentContext).a(pageYouMayLikeHeaderComponentSpec.f19796a.a((ScrollableItemListFeedUnit) props.b.a, props.a)).b(true).a(TruncateAt.END).o(2131427402).c().a(1.0f).c(0, 2131428854).c(2, 2131428854).c(6, 2131428854).c(7, 2131428854).h(1, 6).h(3, 6)).a(PageYouMayLikeHeaderComponentSpec.m20042a(componentContext))).a(SolidColor.a(componentContext).h(2131362789).c().p(2131427379).c(0, 2131428854).c(2, 2131428854).c(6, 2131428854).c(7, 2131428854)).j();
    }

    private void m20038a(View view, Component component) {
        State state = (State) component;
        PageYouMayLikeHeaderComponentSpec.m20044a(view, state.f19787a, state.f19788b);
    }

    public final void m20040a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ PageYouMayLikeHeaderComponent f19781c;

                public void run() {
                    this.f19781c.a(eventHandler, obj);
                }
            }, -1973785989);
            return;
        }
        switch (eventHandler.b) {
            case 1125565395:
                m20038a(((ClickEvent) obj).a, eventHandler.a);
                return;
            default:
                return;
        }
    }
}

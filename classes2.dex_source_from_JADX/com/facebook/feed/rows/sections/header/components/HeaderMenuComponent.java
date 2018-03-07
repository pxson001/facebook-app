package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools$SynchronizedPool;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ClickEvent;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.graphql.model.FeedUnit;
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
/* compiled from: http.proxy_host */
public class HeaderMenuComponent extends ComponentLifecycle {
    public static final Pools$SynchronizedPool<Builder> f20778b = new Pools$SynchronizedPool(2);
    private static HeaderMenuComponent f20779d;
    private static final Object f20780e = new Object();
    private final HeaderMenuComponentSpec f20781c;

    /* compiled from: http.proxy_host */
    public class State extends Component<HeaderMenuComponent> implements Cloneable {
        public MenuConfig f22956a;
        public FeedProps<? extends FeedUnit> f22957b;
        public BaseFeedStoryMenuHelper f22958c;
        final /* synthetic */ HeaderMenuComponent f22959d;

        public State(HeaderMenuComponent headerMenuComponent) {
            this.f22959d = headerMenuComponent;
            super(headerMenuComponent);
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
            if (this.f22956a == null ? state.f22956a != null : !this.f22956a.equals(state.f22956a)) {
                return false;
            }
            if (this.f22957b == null ? state.f22957b != null : !this.f22957b.equals(state.f22957b)) {
                return false;
            }
            if (this.f22958c != null) {
                if (this.f22958c.equals(state.f22958c)) {
                    return true;
                }
            } else if (state.f22958c == null) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: http.proxy_host */
    public class Builder extends com.facebook.components.Component.Builder<HeaderMenuComponent> {
        public State f22960a;
        private String[] f22961b = new String[]{"menuConfig", "feedProps", "menuHelper"};
        private int f22962c = 3;
        public BitSet f22963d = new BitSet(this.f22962c);

        public static void m31066a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.m30661a(componentContext, i, state);
            builder.f22960a = state;
            builder.f22963d.clear();
        }

        public final Component<HeaderMenuComponent> mo3296d() {
            int i = 0;
            if (this.f22963d == null || this.f22963d.nextClearBit(0) >= this.f22962c) {
                Component component = this.f22960a;
                mo3295a();
                return component;
            }
            List arrayList = new ArrayList();
            while (i < this.f22962c) {
                if (!this.f22963d.get(i)) {
                    arrayList.add(this.f22961b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void mo3295a() {
            super.mo3295a();
            this.f22960a = null;
            HeaderMenuComponent.f20778b.mo741a(this);
        }
    }

    private static HeaderMenuComponent m28496b(InjectorLike injectorLike) {
        return new HeaderMenuComponent(HeaderMenuComponentSpec.m28501a(injectorLike));
    }

    @Inject
    public HeaderMenuComponent(HeaderMenuComponentSpec headerMenuComponentSpec) {
        this.f20781c = headerMenuComponentSpec;
    }

    public static HeaderMenuComponent m28494a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeaderMenuComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20780e) {
                HeaderMenuComponent headerMenuComponent;
                if (a2 != null) {
                    headerMenuComponent = (HeaderMenuComponent) a2.mo818a(f20780e);
                } else {
                    headerMenuComponent = f20779d;
                }
                if (headerMenuComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28496b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20780e, b3);
                        } else {
                            f20779d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = headerMenuComponent;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    protected final InternalNode mo3135b(ComponentContext componentContext, Component component) {
        return HeaderMenuComponentSpec.m28499a(componentContext, ((State) component).f22956a);
    }

    private void m28495a(View view, Component component) {
        State state = (State) component;
        state.f22958c.mo2468a(state.f22957b, (View) view.getParent());
    }

    public final void mo3134a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.f20393a, new 1(this, eventHandler, obj), 1391676056);
            return;
        }
        switch (eventHandler.f22608b) {
            case 2045072523:
                m28495a(((ClickEvent) obj).a, eventHandler.f22607a);
                return;
            default:
                return;
        }
    }
}

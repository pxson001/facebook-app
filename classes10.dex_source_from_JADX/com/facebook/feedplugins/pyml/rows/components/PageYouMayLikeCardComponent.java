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
import com.facebook.feedplugins.pyml.rows.PageYouMayLikePartDefinition;
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
/* compiled from: android_background_location_config */
public class PageYouMayLikeCardComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f19741b = new SynchronizedPool(2);
    private static PageYouMayLikeCardComponent f19742d;
    private static final Object f19743e = new Object();
    private final PageYouMayLikeCardComponentSpec f19744c;

    /* compiled from: android_background_location_config */
    public class Builder extends com.facebook.components.Component.Builder<PageYouMayLikeCardComponent> {
        public State f19735a;
        private String[] f19736b = new String[]{"cardProps"};
        private int f19737c = 1;
        public BitSet f19738d = new BitSet(this.f19737c);

        public static void m20002a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f19735a = state;
            builder.f19738d.clear();
        }

        public final Component<PageYouMayLikeCardComponent> m20004d() {
            int i = 0;
            if (this.f19738d == null || this.f19738d.nextClearBit(0) >= this.f19737c) {
                State state = this.f19735a;
                m20003a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f19737c) {
                if (!this.f19738d.get(i)) {
                    arrayList.add(this.f19736b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m20003a() {
            super.a();
            this.f19735a = null;
            PageYouMayLikeCardComponent.f19741b.a(this);
        }
    }

    /* compiled from: android_background_location_config */
    public class State extends Component<PageYouMayLikeCardComponent> implements Cloneable {
        public Props f19739a;
        final /* synthetic */ PageYouMayLikeCardComponent f19740b;

        public State(PageYouMayLikeCardComponent pageYouMayLikeCardComponent) {
            this.f19740b = pageYouMayLikeCardComponent;
            super(pageYouMayLikeCardComponent);
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
            if (this.f19739a != null) {
                if (this.f19739a.equals(state.f19739a)) {
                    return true;
                }
            } else if (state.f19739a == null) {
                return true;
            }
            return false;
        }
    }

    private static PageYouMayLikeCardComponent m20007b(InjectorLike injectorLike) {
        return new PageYouMayLikeCardComponent(PageYouMayLikeCardComponentSpec.m20012a(injectorLike));
    }

    @Inject
    public PageYouMayLikeCardComponent(PageYouMayLikeCardComponentSpec pageYouMayLikeCardComponentSpec) {
        this.f19744c = pageYouMayLikeCardComponentSpec;
    }

    public static PageYouMayLikeCardComponent m20005a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageYouMayLikeCardComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19743e) {
                PageYouMayLikeCardComponent pageYouMayLikeCardComponent;
                if (a2 != null) {
                    pageYouMayLikeCardComponent = (PageYouMayLikeCardComponent) a2.a(f19743e);
                } else {
                    pageYouMayLikeCardComponent = f19742d;
                }
                if (pageYouMayLikeCardComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m20007b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19743e, b3);
                        } else {
                            f19742d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageYouMayLikeCardComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final InternalNode m20009b(ComponentContext componentContext, Component component) {
        return this.f19744c.m20015a(componentContext, ((State) component).f19739a);
    }

    private void m20006a(View view, Component component) {
        State state = (State) component;
        PageYouMayLikeCardComponentSpec pageYouMayLikeCardComponentSpec = this.f19744c;
        Props props = state.f19739a;
        PageYouMayLikePartDefinition.a(pageYouMayLikeCardComponentSpec.f19752f, pageYouMayLikeCardComponentSpec.f19750d, pageYouMayLikeCardComponentSpec.f19751e, props.a, (ScrollableItemListFeedUnit) props.b.a, props.f);
    }

    public final void m20008a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ PageYouMayLikeCardComponent f19734c;

                public void run() {
                    this.f19734c.a(eventHandler, obj);
                }
            }, 325485145);
            return;
        }
        switch (eventHandler.b) {
            case 761706327:
                m20006a(((ClickEvent) obj).a, eventHandler.a);
                return;
            default:
                return;
        }
    }
}

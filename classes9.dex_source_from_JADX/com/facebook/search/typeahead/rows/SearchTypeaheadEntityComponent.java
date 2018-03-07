package com.facebook.search.typeahead.rows;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import android.text.TextUtils.TruncateAt;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout.ContainerBuilder;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.Container;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.fb.fresco.FbFrescoComponent;
import com.facebook.components.widget.Text;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: via_mqtt */
public class SearchTypeaheadEntityComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f492b = new SynchronizedPool(2);
    private static SearchTypeaheadEntityComponent f493d;
    private static final Object f494e = new Object();
    private final SearchTypeaheadEntityComponentSpec f495c;

    /* compiled from: via_mqtt */
    public class Builder extends com.facebook.components.Component.Builder<SearchTypeaheadEntityComponent> {
        public State f486a;
        private String[] f487b = new String[]{"typeaheadUnit"};
        private int f488c = 1;
        public BitSet f489d = new BitSet(this.f488c);

        public static void m594a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f486a = state;
            builder.f489d.clear();
        }

        public final Component<SearchTypeaheadEntityComponent> m596d() {
            int i = 0;
            if (this.f489d == null || this.f489d.nextClearBit(0) >= this.f488c) {
                State state = this.f486a;
                m595a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f488c) {
                if (!this.f489d.get(i)) {
                    arrayList.add(this.f487b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m595a() {
            super.a();
            this.f486a = null;
            SearchTypeaheadEntityComponent.f492b.a(this);
        }
    }

    /* compiled from: via_mqtt */
    public class State extends Component<SearchTypeaheadEntityComponent> implements Cloneable {
        public EntityTypeaheadUnit f490a;
        final /* synthetic */ SearchTypeaheadEntityComponent f491b;

        public State(SearchTypeaheadEntityComponent searchTypeaheadEntityComponent) {
            this.f491b = searchTypeaheadEntityComponent;
            super(searchTypeaheadEntityComponent);
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
            if (this.f490a != null) {
                if (this.f490a.equals(state.f490a)) {
                    return true;
                }
            } else if (state.f490a == null) {
                return true;
            }
            return false;
        }
    }

    private static SearchTypeaheadEntityComponent m598b(InjectorLike injectorLike) {
        return new SearchTypeaheadEntityComponent(SearchTypeaheadEntityComponentSpec.m608a(injectorLike));
    }

    @Inject
    public SearchTypeaheadEntityComponent(SearchTypeaheadEntityComponentSpec searchTypeaheadEntityComponentSpec) {
        this.f495c = searchTypeaheadEntityComponentSpec;
    }

    public static SearchTypeaheadEntityComponent m597a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadEntityComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f494e) {
                SearchTypeaheadEntityComponent searchTypeaheadEntityComponent;
                if (a2 != null) {
                    searchTypeaheadEntityComponent = (SearchTypeaheadEntityComponent) a2.a(f494e);
                } else {
                    searchTypeaheadEntityComponent = f493d;
                }
                if (searchTypeaheadEntityComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m598b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f494e, b3);
                        } else {
                            f493d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchTypeaheadEntityComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final InternalNode m600b(ComponentContext componentContext, Component component) {
        com.facebook.components.ComponentLayout.Builder builder;
        State state = (State) component;
        SearchTypeaheadEntityComponentSpec searchTypeaheadEntityComponentSpec = this.f495c;
        EntityTypeaheadUnit entityTypeaheadUnit = state.f490a;
        CharSequence a = SearchTypeaheadEntityPartDefinition.m611a(searchTypeaheadEntityComponentSpec.f502b, entityTypeaheadUnit, searchTypeaheadEntityComponentSpec.f504d);
        CharSequence c = SearchTypeaheadEntityPartDefinition.m613c(entityTypeaheadUnit);
        ContainerBuilder n = Container.a(componentContext).C(2).E(1).n(5, 2131427450).n(4, 2131431730);
        if (entityTypeaheadUnit.d == null) {
            builder = null;
        } else {
            builder = FbFrescoComponent.a(componentContext).a(searchTypeaheadEntityComponentSpec.f503c.b(entityTypeaheadUnit.d).a(SearchTypeaheadEntityComponentSpec.f499a).s()).c().a(2).k(2130772414).o(2130772414).c(7, 2131431729);
        }
        return n.a(builder).a(Container.a(componentContext).b(1.0f).C(0).E(1).a(Text.a(componentContext, 2131625904).a(a)).a(Text.a(componentContext, 2131625912).a(c).j(1).a(TruncateAt.END))).j();
    }

    public final void m599a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ SearchTypeaheadEntityComponent f485c;

                public void run() {
                    this.f485c.a(eventHandler, obj);
                }
            }, -707770646);
        }
    }
}

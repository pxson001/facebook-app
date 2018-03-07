package com.facebook.search.results.rows.sections.header;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import android.text.TextUtils.TruncateAt;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.Container;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.widget.Text;
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
/* compiled from: Primary Action Clicks */
public class SearchResultsHeaderComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f24381b = new SynchronizedPool(2);
    private static SearchResultsHeaderComponent f24382d;
    private static final Object f24383e = new Object();
    private final SearchResultsHeaderComponentSpec f24384c;

    /* compiled from: Primary Action Clicks */
    public class Builder extends com.facebook.components.Component.Builder<SearchResultsHeaderComponent> {
        public State f24374a;
        private String[] f24375b = new String[]{"title"};
        private int f24376c = 1;
        public BitSet f24377d = new BitSet(this.f24376c);

        public static void m27863a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f24374a = state;
            builder.f24377d.clear();
        }

        public final Component<SearchResultsHeaderComponent> m27865d() {
            int i = 0;
            if (this.f24377d == null || this.f24377d.nextClearBit(0) >= this.f24376c) {
                State state = this.f24374a;
                m27864a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f24376c) {
                if (!this.f24377d.get(i)) {
                    arrayList.add(this.f24375b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m27864a() {
            super.a();
            this.f24374a = null;
            SearchResultsHeaderComponent.f24381b.a(this);
        }
    }

    /* compiled from: Primary Action Clicks */
    public class State extends Component<SearchResultsHeaderComponent> implements Cloneable {
        public String f24378a;
        public String f24379b;
        final /* synthetic */ SearchResultsHeaderComponent f24380c;

        public State(SearchResultsHeaderComponent searchResultsHeaderComponent) {
            this.f24380c = searchResultsHeaderComponent;
            super(searchResultsHeaderComponent);
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
            if (this.f24378a == null ? state.f24378a != null : !this.f24378a.equals(state.f24378a)) {
                return false;
            }
            if (this.f24379b != null) {
                if (this.f24379b.equals(state.f24379b)) {
                    return true;
                }
            } else if (state.f24379b == null) {
                return true;
            }
            return false;
        }
    }

    private static SearchResultsHeaderComponent m27867b(InjectorLike injectorLike) {
        return new SearchResultsHeaderComponent(SearchResultsHeaderComponentSpec.m27878a(injectorLike));
    }

    @Inject
    public SearchResultsHeaderComponent(SearchResultsHeaderComponentSpec searchResultsHeaderComponentSpec) {
        this.f24384c = searchResultsHeaderComponentSpec;
    }

    public static SearchResultsHeaderComponent m27866a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsHeaderComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24383e) {
                SearchResultsHeaderComponent searchResultsHeaderComponent;
                if (a2 != null) {
                    searchResultsHeaderComponent = (SearchResultsHeaderComponent) a2.a(f24383e);
                } else {
                    searchResultsHeaderComponent = f24382d;
                }
                if (searchResultsHeaderComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27867b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24383e, b3);
                        } else {
                            f24382d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsHeaderComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final InternalNode m27869b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        CharSequence charSequence = state.f24378a;
        CharSequence charSequence2 = state.f24379b;
        return Container.a(componentContext).C(2).E(2).a(Text.a(componentContext, 2131626167).a(charSequence).c().a(1.0f).a(1)).a(charSequence2 == null ? null : Text.a(componentContext).a(charSequence2).m(2130773627).o(2131427402).a(TruncateAt.END).b(true).c().a(3)).j();
    }

    public final void m27868a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ SearchResultsHeaderComponent f24373c;

                public void run() {
                    this.f24373c.a(eventHandler, obj);
                }
            }, 1614967296);
        }
    }
}

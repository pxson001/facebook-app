package com.facebook.search.typeahead.rows;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import android.text.Layout.Alignment;
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
/* compiled from: verificationUrl */
public class SearchTypeaheadNUXComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f570b = new SynchronizedPool(2);
    private static SearchTypeaheadNUXComponent f571d;
    private static final Object f572e = new Object();
    private final SearchTypeaheadNUXComponentSpec f573c;

    /* compiled from: verificationUrl */
    public class Builder extends com.facebook.components.Component.Builder<SearchTypeaheadNUXComponent> {
        public State f563a;
        private String[] f564b = new String[]{"title", "message"};
        private int f565c = 2;
        public BitSet f566d = new BitSet(this.f565c);

        public static void m654a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f563a = state;
            builder.f566d.clear();
        }

        public final Component<SearchTypeaheadNUXComponent> m656d() {
            int i = 0;
            if (this.f566d == null || this.f566d.nextClearBit(0) >= this.f565c) {
                State state = this.f563a;
                m655a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f565c) {
                if (!this.f566d.get(i)) {
                    arrayList.add(this.f564b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m655a() {
            super.a();
            this.f563a = null;
            SearchTypeaheadNUXComponent.f570b.a(this);
        }
    }

    /* compiled from: verificationUrl */
    public class State extends Component<SearchTypeaheadNUXComponent> implements Cloneable {
        public String f567a;
        public String f568b;
        final /* synthetic */ SearchTypeaheadNUXComponent f569c;

        public State(SearchTypeaheadNUXComponent searchTypeaheadNUXComponent) {
            this.f569c = searchTypeaheadNUXComponent;
            super(searchTypeaheadNUXComponent);
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
            if (this.f567a == null ? state.f567a != null : !this.f567a.equals(state.f567a)) {
                return false;
            }
            if (this.f568b != null) {
                if (this.f568b.equals(state.f568b)) {
                    return true;
                }
            } else if (state.f568b == null) {
                return true;
            }
            return false;
        }
    }

    private static SearchTypeaheadNUXComponent m658b(InjectorLike injectorLike) {
        return new SearchTypeaheadNUXComponent(SearchTypeaheadNUXComponentSpec.m662a(injectorLike));
    }

    @Inject
    public SearchTypeaheadNUXComponent(SearchTypeaheadNUXComponentSpec searchTypeaheadNUXComponentSpec) {
        this.f573c = searchTypeaheadNUXComponentSpec;
    }

    public static SearchTypeaheadNUXComponent m657a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadNUXComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f572e) {
                SearchTypeaheadNUXComponent searchTypeaheadNUXComponent;
                if (a2 != null) {
                    searchTypeaheadNUXComponent = (SearchTypeaheadNUXComponent) a2.a(f572e);
                } else {
                    searchTypeaheadNUXComponent = f571d;
                }
                if (searchTypeaheadNUXComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m658b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f572e, b3);
                        } else {
                            f571d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchTypeaheadNUXComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final InternalNode m660b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return Container.a(componentContext).C(0).o(4, 8).o(5, 48).a(Text.a(componentContext).a(state.f567a).l(2131362127).o(2131427409).a(Alignment.ALIGN_CENTER).c().h(4, 8)).a(Text.a(componentContext).a(state.f568b).m(2130773627).o(2131427404).a(Alignment.ALIGN_CENTER).d(1.1f)).j();
    }

    public final void m659a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ SearchTypeaheadNUXComponent f562c;

                public void run() {
                    this.f562c.a(eventHandler, obj);
                }
            }, 648922043);
        }
    }
}

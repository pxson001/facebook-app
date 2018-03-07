package com.facebook.search.results.rows.sections.header;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
import com.facebook.components.reference.Reference;
import com.facebook.components.widget.Image;
import com.facebook.components.widget.Text;
import com.facebook.components.widget.VerticalGravity;
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
/* compiled from: ProfilePictureOverlayCamera */
public class SearchResultsCommerceHeaderComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f24356b = new SynchronizedPool(2);
    private static SearchResultsCommerceHeaderComponent f24357d;
    private static final Object f24358e = new Object();
    private final SearchResultsCommerceHeaderComponentSpec f24359c;

    /* compiled from: ProfilePictureOverlayCamera */
    public class Builder extends com.facebook.components.Component.Builder<SearchResultsCommerceHeaderComponent> {
        public State f24348a;
        private String[] f24349b = new String[]{"title"};
        private int f24350c = 1;
        public BitSet f24351d = new BitSet(this.f24350c);

        public static void m27847a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f24348a = state;
            builder.f24351d.clear();
        }

        public final Component<SearchResultsCommerceHeaderComponent> m27849d() {
            int i = 0;
            if (this.f24351d == null || this.f24351d.nextClearBit(0) >= this.f24350c) {
                State state = this.f24348a;
                m27848a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f24350c) {
                if (!this.f24351d.get(i)) {
                    arrayList.add(this.f24349b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m27848a() {
            super.a();
            this.f24348a = null;
            SearchResultsCommerceHeaderComponent.f24356b.a(this);
        }
    }

    /* compiled from: ProfilePictureOverlayCamera */
    public class State extends Component<SearchResultsCommerceHeaderComponent> implements Cloneable {
        public String f24352a;
        public String f24353b;
        public Reference<Drawable> f24354c;
        final /* synthetic */ SearchResultsCommerceHeaderComponent f24355d;

        public State(SearchResultsCommerceHeaderComponent searchResultsCommerceHeaderComponent) {
            this.f24355d = searchResultsCommerceHeaderComponent;
            super(searchResultsCommerceHeaderComponent);
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
            if (this.f24352a == null ? state.f24352a != null : !this.f24352a.equals(state.f24352a)) {
                return false;
            }
            if (this.f24353b == null ? state.f24353b != null : !this.f24353b.equals(state.f24353b)) {
                return false;
            }
            if (this.f24354c != null) {
                if (this.f24354c.equals(state.f24354c)) {
                    return true;
                }
            } else if (state.f24354c == null) {
                return true;
            }
            return false;
        }
    }

    private static SearchResultsCommerceHeaderComponent m27851b(InjectorLike injectorLike) {
        return new SearchResultsCommerceHeaderComponent(SearchResultsCommerceHeaderComponentSpec.m27862a(injectorLike));
    }

    @Inject
    public SearchResultsCommerceHeaderComponent(SearchResultsCommerceHeaderComponentSpec searchResultsCommerceHeaderComponentSpec) {
        this.f24359c = searchResultsCommerceHeaderComponentSpec;
    }

    public static SearchResultsCommerceHeaderComponent m27850a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsCommerceHeaderComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24358e) {
                SearchResultsCommerceHeaderComponent searchResultsCommerceHeaderComponent;
                if (a2 != null) {
                    searchResultsCommerceHeaderComponent = (SearchResultsCommerceHeaderComponent) a2.a(f24358e);
                } else {
                    searchResultsCommerceHeaderComponent = f24357d;
                }
                if (searchResultsCommerceHeaderComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27851b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24358e, b3);
                        } else {
                            f24357d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsCommerceHeaderComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final InternalNode m27853b(ComponentContext componentContext, Component component) {
        com.facebook.components.ComponentLayout.Builder builder;
        State state = (State) component;
        CharSequence charSequence = state.f24352a;
        CharSequence charSequence2 = state.f24353b;
        Reference reference = state.f24354c;
        int i = 6;
        ContainerBuilder a = Container.a(componentContext).C(2).E(2).o(4, 3).a(reference == null ? null : Image.a(componentContext).a(reference).c().a(2).h(1, 4)).a(Text.a(componentContext).a(charSequence).a(TruncateAt.END).b(true).m(2130773626).r(0).o(2131427404).a(VerticalGravity.CENTER).c().a(1.0f).a(reference != null ? 2 : 1).h(5, reference != null ? 6 : 4).h(1, 5));
        if (charSequence2 == null) {
            builder = null;
        } else {
            builder = Text.a(componentContext).a(charSequence2).m(2130773627).o(2131427402).a(TruncateAt.END).b(true).c().a(2);
            if (reference == null) {
                i = 4;
            }
            builder = builder.h(5, i).h(1, 5);
        }
        return a.a(builder).j();
    }

    public final void m27852a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ SearchResultsCommerceHeaderComponent f24347c;

                public void run() {
                    this.f24347c.a(eventHandler, obj);
                }
            }, -2143223054);
        }
    }
}

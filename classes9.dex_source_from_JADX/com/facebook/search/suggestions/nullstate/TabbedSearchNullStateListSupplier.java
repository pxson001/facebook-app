package com.facebook.search.suggestions.nullstate;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.NullStateStatus;
import com.facebook.search.model.SuggestionGroup.Type;
import com.facebook.search.suggestions.nullstate.NullStateSupplier.NullStateStatusListener;
import com.facebook.search.suggestions.nullstate.NullStateSupplier.RefreshPolicy;
import com.facebook.ui.typeahead.OnFetchStateChangedListener;
import com.facebook.ultralight.Inject;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: watch_browse */
public class TabbedSearchNullStateListSupplier extends NullStateSupplier {
    public final ImmutableList<NullStateSupplier> f224a;
    private final NullStateStatusListener f225b = new C00281(this);
    public NullStateStatusListener f226c;

    /* compiled from: watch_browse */
    class C00281 implements NullStateStatusListener {
        final /* synthetic */ TabbedSearchNullStateListSupplier f223a;

        C00281(TabbedSearchNullStateListSupplier tabbedSearchNullStateListSupplier) {
            this.f223a = tabbedSearchNullStateListSupplier;
        }

        public final void m345a(NullStateStatus nullStateStatus) {
            if (this.f223a.f226c != null) {
                NullStateStatus nullStateStatus2 = NullStateStatus.READY;
                for (int i = 0; i < this.f223a.f224a.size(); i++) {
                    if (NullStateStatus.NOT_READY.equals(((NullStateSupplier) this.f223a.f224a.get(i)).c())) {
                        nullStateStatus2 = NullStateStatus.PARTIAL;
                    }
                }
                this.f223a.f226c.a(nullStateStatus2);
            }
        }
    }

    @Inject
    public TabbedSearchNullStateListSupplier(Provider<SearchNullStateListSupplier> provider) {
        Builder builder = ImmutableList.builder();
        SearchNullStateListSupplier searchNullStateListSupplier = (SearchNullStateListSupplier) provider.get();
        if (searchNullStateListSupplier.a()) {
            builder.c(searchNullStateListSupplier);
        }
        this.f224a = builder.b();
    }

    public final NullStateStatus m352c() {
        int size = this.f224a.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            NullStateSupplier nullStateSupplier = (NullStateSupplier) this.f224a.get(i);
            if (obj == null && NullStateStatus.READY.equals(nullStateSupplier.c()) && nullStateSupplier.a()) {
                obj2 = 1;
            } else if (obj != null && !NullStateStatus.READY.equals(nullStateSupplier.c()) && nullStateSupplier.a()) {
                return NullStateStatus.PARTIAL;
            } else {
                obj2 = obj;
            }
            i++;
            obj = obj2;
        }
        return obj != null ? NullStateStatus.READY : NullStateStatus.NOT_READY;
    }

    public final boolean m350a() {
        return true;
    }

    public final void m351b() {
        int size = this.f224a.size();
        for (int i = 0; i < size; i++) {
            ((NullStateSupplier) this.f224a.get(i)).b();
        }
    }

    public final void m346a(@Nullable CallerContext callerContext, RefreshPolicy refreshPolicy) {
        int size = this.f224a.size();
        for (int i = 0; i < size; i++) {
            NullStateSupplier nullStateSupplier = (NullStateSupplier) this.f224a.get(i);
            if (nullStateSupplier.a() && !(refreshPolicy == RefreshPolicy.MEMORY && NullStateStatus.READY.equals(nullStateSupplier.c()))) {
                nullStateSupplier.a(callerContext, refreshPolicy);
            }
        }
    }

    public Object get() {
        Builder builder = new Builder();
        int size = this.f224a.size();
        for (int i = 0; i < size; i++) {
            NullStateSupplier nullStateSupplier = (NullStateSupplier) this.f224a.get(i);
            if (nullStateSupplier.a() && !NullStateStatus.NOT_READY.equals(nullStateSupplier.c())) {
                ImmutableList immutableList = (ImmutableList) nullStateSupplier.get();
                if (!immutableList.isEmpty()) {
                    builder.b(immutableList);
                }
            }
        }
        return builder.b();
    }

    public final void m349a(NullStateStatusListener nullStateStatusListener, OnFetchStateChangedListener onFetchStateChangedListener) {
        this.f226c = nullStateStatusListener;
        int size = this.f224a.size();
        for (int i = 0; i < size; i++) {
            ((NullStateSupplier) this.f224a.get(i)).a(nullStateStatusListener != null ? this.f225b : null, onFetchStateChangedListener);
        }
    }

    public final void m347a(GraphSearchQuery graphSearchQuery) {
        int size = this.f224a.size();
        for (int i = 0; i < size; i++) {
            ((NullStateSupplier) this.f224a.get(i)).a(graphSearchQuery);
        }
    }

    public final void m348a(Type type) {
        int size = this.f224a.size();
        for (int i = 0; i < size; i++) {
            ((NullStateSupplier) this.f224a.get(i)).a(type);
        }
    }
}

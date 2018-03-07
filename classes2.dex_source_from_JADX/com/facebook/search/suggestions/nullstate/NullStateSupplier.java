package com.facebook.search.suggestions.nullstate;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.NullStateStatus;
import com.facebook.search.logging.perf.NullStatePerformanceLogger;
import com.facebook.search.model.CachedSuggestionList;
import com.facebook.search.model.SearchBoxQueryState;
import com.facebook.search.model.SuggestionGroup.Type;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.ui.typeahead.OnFetchStateChangedListener;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: invalid */
public abstract class NullStateSupplier implements Supplier<ImmutableList<? extends TypeaheadUnit>> {
    private static final Class f19630a = NullStateSupplier.class;
    @Nullable
    private final NullStatePerformanceLogger f19631b;

    public abstract void mo3112b();

    public abstract NullStateStatus mo3113c();

    NullStateSupplier() {
        this(null);
        getClass().getCanonicalName();
    }

    NullStateSupplier(NullStatePerformanceLogger nullStatePerformanceLogger) {
        this.f19631b = nullStatePerformanceLogger;
    }

    public boolean mo3111a() {
        return true;
    }

    public void mo3109a(@Nullable CallerContext callerContext, RefreshPolicy refreshPolicy) {
    }

    public void mo3110a(NullStateStatusListener nullStateStatusListener, OnFetchStateChangedListener onFetchStateChangedListener) {
    }

    public void m27348a(Type type) {
    }

    public void m27346a(GraphSearchQuery graphSearchQuery) {
    }

    public SearchBoxQueryState m27353f() {
        return SearchBoxQueryState.NULL_STATE;
    }

    protected String m27354g() {
        return "";
    }

    protected final void m27355h() {
        if (this.f19631b != null) {
            this.f19631b.a(m27354g());
        }
    }

    protected final void m27347a(CachedSuggestionList cachedSuggestionList) {
        if (this.f19631b != null) {
            this.f19631b.a(cachedSuggestionList, m27354g());
        }
    }

    protected final void m27356i() {
        if (this.f19631b != null) {
            this.f19631b.b(m27354g());
        }
    }

    protected final void m27357j() {
        if (this.f19631b != null) {
            this.f19631b.c(m27354g());
        }
    }
}

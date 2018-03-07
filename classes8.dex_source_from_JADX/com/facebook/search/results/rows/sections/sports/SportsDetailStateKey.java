package com.facebook.search.results.rows.sections.sports;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.search.results.model.unit.SearchResultsSportsUnit;

/* compiled from: PREFETCH_ALL_ASSETS */
public class SportsDetailStateKey implements ContextStateKey<String, SportsDetailState> {
    private String f25047a;

    public SportsDetailStateKey(SearchResultsSportsUnit searchResultsSportsUnit) {
        this.f25047a = searchResultsSportsUnit.f23530b;
    }

    public final Object m28370a() {
        return new SportsDetailState();
    }

    public final Object m28371b() {
        return this.f25047a;
    }
}

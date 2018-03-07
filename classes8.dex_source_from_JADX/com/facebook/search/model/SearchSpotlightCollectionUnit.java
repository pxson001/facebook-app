package com.facebook.search.model;

import com.facebook.search.model.SuggestionGroup.Type;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: TIMELINE_SURFING_RECOMMENDATIONS */
public class SearchSpotlightCollectionUnit extends TypeaheadCollectionUnit {
    private final ImmutableList<TypeaheadUnit> f22262a;

    public SearchSpotlightCollectionUnit(ImmutableList<TypeaheadUnit> immutableList) {
        this.f22262a = immutableList;
    }

    public final <T> T m25728a(TypeaheadSuggestionVisitorWithReturn<T> typeaheadSuggestionVisitorWithReturn) {
        return null;
    }

    public final void m25729a(TypeaheadSuggestionVisitor typeaheadSuggestionVisitor) {
    }

    public final Type m25731k() {
        return Type.NS_SEARCH_SPOTLIGHT;
    }

    public final boolean m25732l() {
        return false;
    }

    public final ImmutableList<? extends TypeaheadUnit> mo1222f() {
        return this.f22262a;
    }

    public String toString() {
        return "SearchSpotlightCollectionUnit[" + this.f22262a.toString() + "]";
    }
}

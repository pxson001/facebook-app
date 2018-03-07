package com.facebook.search.model;

import com.facebook.search.model.SuggestionGroup.Type;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: TIME_OF_DAY_AFTER */
public class SearchSpotlightCardUnit extends TypeaheadUnit {
    public final String f22260a;
    public final int f22261b;

    /* compiled from: TIME_OF_DAY_AFTER */
    public class Builder {
        public String f22258a;
        public int f22259b;
    }

    public SearchSpotlightCardUnit(Builder builder) {
        this.f22260a = (String) Preconditions.checkNotNull(builder.f22258a);
        this.f22261b = ((Integer) Preconditions.checkNotNull(Integer.valueOf(builder.f22259b))).intValue();
    }

    public final <T> T m25724a(TypeaheadSuggestionVisitorWithReturn<T> typeaheadSuggestionVisitorWithReturn) {
        return null;
    }

    public final void m25725a(TypeaheadSuggestionVisitor typeaheadSuggestionVisitor) {
    }

    public final Type m25726k() {
        return Type.NS_SEARCH_SPOTLIGHT;
    }

    public final boolean m25727l() {
        return true;
    }

    public String toString() {
        return "SearchSpotlightCardUnit[body: " + this.f22260a + "]";
    }
}

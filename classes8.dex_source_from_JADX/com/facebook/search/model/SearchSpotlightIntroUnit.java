package com.facebook.search.model;

import com.facebook.search.model.SuggestionGroup.Type;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: TIMELINE_PENDING_REQUESTS_PROMPT */
public class SearchSpotlightIntroUnit extends TypeaheadUnit {
    public final String f22264a;

    /* compiled from: TIMELINE_PENDING_REQUESTS_PROMPT */
    public class Builder {
        public String f22263a;

        public final SearchSpotlightIntroUnit m25733a() {
            return new SearchSpotlightIntroUnit(this);
        }
    }

    public SearchSpotlightIntroUnit(Builder builder) {
        this.f22264a = (String) Preconditions.checkNotNull(builder.f22263a);
    }

    public final <T> T m25734a(TypeaheadSuggestionVisitorWithReturn<T> typeaheadSuggestionVisitorWithReturn) {
        return null;
    }

    public final void m25735a(TypeaheadSuggestionVisitor typeaheadSuggestionVisitor) {
    }

    public final Type m25736k() {
        return Type.NS_SEARCH_SPOTLIGHT;
    }

    public final boolean m25737l() {
        return true;
    }

    public String toString() {
        return "SearchSpotlightIntroUnit[body: " + this.f22264a + "]";
    }
}

package com.facebook.search.suggestions.model;

import com.facebook.search.model.SuggestionGroup;
import com.facebook.search.model.SuggestionGroup.Type;
import com.facebook.search.model.TypeaheadSuggestionVisitor;
import com.facebook.search.model.TypeaheadSuggestionVisitorWithReturn;
import com.facebook.search.model.TypeaheadUnit;

/* compiled from: xmat_ttl */
public class HeaderRowTypeaheadUnit extends TypeaheadUnit {
    public final SuggestionGroup f171a;

    public HeaderRowTypeaheadUnit(SuggestionGroup suggestionGroup) {
        this.f171a = suggestionGroup;
    }

    public final <T> T m303a(TypeaheadSuggestionVisitorWithReturn<T> typeaheadSuggestionVisitorWithReturn) {
        return null;
    }

    public final void m304a(TypeaheadSuggestionVisitor typeaheadSuggestionVisitor) {
    }

    public final Type m305k() {
        return this.f171a.a;
    }

    public final boolean m306l() {
        return false;
    }
}

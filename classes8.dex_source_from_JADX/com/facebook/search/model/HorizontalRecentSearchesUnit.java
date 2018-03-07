package com.facebook.search.model;

import com.facebook.search.model.SuggestionGroup.Type;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: TRY_ANOTHER_CAPTCHA_CLICKED */
public class HorizontalRecentSearchesUnit extends TypeaheadCollectionUnit {
    private final ImmutableList<TypeaheadUnit> f22083a;

    public HorizontalRecentSearchesUnit(ImmutableList<TypeaheadUnit> immutableList) {
        this.f22083a = immutableList;
    }

    public final ImmutableList<TypeaheadUnit> mo1222f() {
        return this.f22083a;
    }

    public final <T> T m25642a(TypeaheadSuggestionVisitorWithReturn<T> typeaheadSuggestionVisitorWithReturn) {
        return null;
    }

    public final void m25643a(TypeaheadSuggestionVisitor typeaheadSuggestionVisitor) {
    }

    public final Type m25645k() {
        return Type.RECENT;
    }

    public final boolean m25646l() {
        return false;
    }
}

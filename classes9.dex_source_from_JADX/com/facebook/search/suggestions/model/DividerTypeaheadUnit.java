package com.facebook.search.suggestions.model;

import com.facebook.search.model.SuggestionGroup.Type;
import com.facebook.search.model.TypeaheadSuggestionVisitor;
import com.facebook.search.model.TypeaheadSuggestionVisitorWithReturn;
import com.facebook.search.model.TypeaheadUnit;

/* compiled from: xoutBlocksTab */
public class DividerTypeaheadUnit extends TypeaheadUnit {
    public static final DividerTypeaheadUnit f170a = new DividerTypeaheadUnit();

    private DividerTypeaheadUnit() {
    }

    public static final DividerTypeaheadUnit m298f() {
        return f170a;
    }

    public final <T> T m299a(TypeaheadSuggestionVisitorWithReturn<T> typeaheadSuggestionVisitorWithReturn) {
        return null;
    }

    public final void m300a(TypeaheadSuggestionVisitor typeaheadSuggestionVisitor) {
    }

    public final Type m301k() {
        return Type.NO_GROUP;
    }

    public final boolean m302l() {
        return false;
    }
}

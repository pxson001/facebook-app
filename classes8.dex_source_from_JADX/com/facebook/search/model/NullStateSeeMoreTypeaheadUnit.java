package com.facebook.search.model;

import com.facebook.search.model.SuggestionGroup.Type;

/* compiled from: TOPIC_TAP */
public class NullStateSeeMoreTypeaheadUnit extends TypeaheadUnit {
    private final Type f22222a;

    public NullStateSeeMoreTypeaheadUnit(Type type) {
        this.f22222a = type;
    }

    public final <T> T m25701a(TypeaheadSuggestionVisitorWithReturn<T> typeaheadSuggestionVisitorWithReturn) {
        return typeaheadSuggestionVisitorWithReturn.mo1228a(this);
    }

    public final void m25702a(TypeaheadSuggestionVisitor typeaheadSuggestionVisitor) {
        typeaheadSuggestionVisitor.m25774a(this);
    }

    public final Type m25703k() {
        return this.f22222a;
    }

    public final boolean m25704l() {
        return false;
    }

    public String toString() {
        return "NullStateSeeMoreTypeaheadUnit{mGroupType=" + this.f22222a + '}';
    }
}

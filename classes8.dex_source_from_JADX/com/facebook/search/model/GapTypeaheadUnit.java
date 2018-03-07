package com.facebook.search.model;

import com.facebook.search.model.SuggestionGroup.Type;

/* compiled from: TYPEAHEAD_CLEARED */
public class GapTypeaheadUnit extends TypeaheadUnit {
    public final BackgroundType f22060a;

    /* compiled from: TYPEAHEAD_CLEARED */
    public enum BackgroundType {
        DEFAULT,
        GRAY
    }

    public GapTypeaheadUnit() {
        this(BackgroundType.DEFAULT);
    }

    public GapTypeaheadUnit(BackgroundType backgroundType) {
        this.f22060a = backgroundType;
    }

    public final <T> T m25616a(TypeaheadSuggestionVisitorWithReturn<T> typeaheadSuggestionVisitorWithReturn) {
        return null;
    }

    public final void m25617a(TypeaheadSuggestionVisitor typeaheadSuggestionVisitor) {
    }

    public final Type m25618k() {
        return Type.NO_GROUP;
    }

    public final boolean m25619l() {
        return false;
    }
}

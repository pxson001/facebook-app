package com.facebook.search.model;

import com.facebook.search.model.SuggestionGroup.Type;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: TIMELINE_FRIENDS_NAVTILE */
public class SeeMoreTypeaheadUnit extends TypeaheadUnit {
    public final String f22266a;

    public SeeMoreTypeaheadUnit(String str) {
        this.f22266a = str;
    }

    public final <T> T m25744a(TypeaheadSuggestionVisitorWithReturn<T> typeaheadSuggestionVisitorWithReturn) {
        return typeaheadSuggestionVisitorWithReturn.mo1232a(this);
    }

    public final void m25745a(TypeaheadSuggestionVisitor typeaheadSuggestionVisitor) {
        typeaheadSuggestionVisitor.m25778a(this);
    }

    public final Type m25746k() {
        return Type.ENTITY;
    }

    public final boolean m25747l() {
        return false;
    }
}

package com.facebook.search.model;

import com.facebook.placetips.bootstrap.PresenceDescription;
import com.facebook.search.model.SuggestionGroup.Type;

/* compiled from: TOO_MANY_PLACE */
public class PlaceTipsTypeaheadUnit extends TypeaheadUnit {
    public final PresenceDescription f22245a;

    public final String m25720f() {
        return this.f22245a == null ? "" : this.f22245a.m3695i();
    }

    public final <T> T m25718a(TypeaheadSuggestionVisitorWithReturn<T> typeaheadSuggestionVisitorWithReturn) {
        return typeaheadSuggestionVisitorWithReturn.mo1230a(this);
    }

    public final void m25719a(TypeaheadSuggestionVisitor typeaheadSuggestionVisitor) {
        typeaheadSuggestionVisitor.m25776a(this);
    }

    public final Type m25721k() {
        return Type.PLACE_TIP;
    }

    public final boolean m25722l() {
        return true;
    }
}

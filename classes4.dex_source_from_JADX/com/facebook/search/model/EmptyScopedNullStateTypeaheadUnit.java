package com.facebook.search.model;

import com.facebook.search.api.GraphSearchQuery$ScopedEntityType;
import com.facebook.search.model.SuggestionGroup.Type;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: linear_acceleration */
public class EmptyScopedNullStateTypeaheadUnit extends TypeaheadUnit {
    public final GraphSearchQuery$ScopedEntityType f9326a;

    public EmptyScopedNullStateTypeaheadUnit(GraphSearchQuery$ScopedEntityType graphSearchQuery$ScopedEntityType) {
        this.f9326a = graphSearchQuery$ScopedEntityType;
    }

    public final <T> T mo750a(TypeaheadSuggestionVisitorWithReturn<T> typeaheadSuggestionVisitorWithReturn) {
        return null;
    }

    public final void mo751a(TypeaheadSuggestionVisitor typeaheadSuggestionVisitor) {
    }

    public final Type mo752k() {
        return Type.NO_GROUP;
    }

    public final boolean mo753l() {
        return false;
    }
}

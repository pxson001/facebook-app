package com.facebook.search.model;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.search.model.SuggestionGroup.Type;

/* compiled from: lineNumber */
public abstract class TypeaheadUnit extends SearchResultsBaseFeedUnit {
    public abstract <T> T mo750a(TypeaheadSuggestionVisitorWithReturn<T> typeaheadSuggestionVisitorWithReturn);

    public abstract void mo751a(TypeaheadSuggestionVisitor typeaheadSuggestionVisitor);

    public abstract Type mo752k();

    public abstract boolean mo753l();

    public <T extends TypeaheadUnit> boolean m9716a(T t, T t2) {
        return false;
    }

    public boolean m9720y() {
        return false;
    }

    public boolean m9719x() {
        return false;
    }

    public boolean jG_() {
        return false;
    }

    public void m9714a(HoneyClientEvent honeyClientEvent) {
    }
}

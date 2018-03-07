package com.facebook.search.suggestions.systems;

import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.model.SearchBoxQueryState;
import com.facebook.search.typeahead.TypeaheadUnitCollection;

/* compiled from: visible_count */
public abstract class BaseSearchTypeaheadSystem implements SearchTypeaheadSystem {
    public void mo40a() {
    }

    public boolean mo41a(GraphSearchQuery graphSearchQuery, TypeaheadUnitCollection typeaheadUnitCollection) {
        return false;
    }

    public SearchBoxQueryState mo42b() {
        return SearchBoxQueryState.TYPED;
    }
}

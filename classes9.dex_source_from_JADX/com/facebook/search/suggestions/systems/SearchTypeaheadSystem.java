package com.facebook.search.suggestions.systems;

import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.model.SearchBoxQueryState;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.typeahead.TypeaheadUnitCollection;
import com.facebook.ui.typeahead.FetchState;
import com.facebook.ui.typeahead.SearchResponse;
import com.google.common.collect.ImmutableList;

/* compiled from: visible_in_group */
public interface SearchTypeaheadSystem {
    TypeaheadUnit mo43a(GraphSearchQuery graphSearchQuery);

    ImmutableList<TypeaheadUnit> mo44a(GraphSearchQuery graphSearchQuery, SearchResponse<TypeaheadUnit> searchResponse, TypeaheadUnit typeaheadUnit, FetchState fetchState);

    void mo40a();

    boolean mo41a(GraphSearchQuery graphSearchQuery, TypeaheadUnitCollection typeaheadUnitCollection);

    SearchBoxQueryState mo42b();
}

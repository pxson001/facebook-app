package com.facebook.search.results.filters.controller;

import com.facebook.search.results.protocol.filters.FilterValue;
import com.facebook.ui.typeahead.FetchSource;
import com.facebook.ui.typeahead.TypeaheadSuggestionDeduper;

/* compiled from: SOFT_CLIFF */
public class FilterValueSuggestionDeduper implements TypeaheadSuggestionDeduper<FilterValue> {
    public final Object m26422a(Object obj, Object obj2, FetchSource fetchSource) {
        return (FilterValue) obj2;
    }
}

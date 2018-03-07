package com.facebook.ui.typeahead;

import com.google.common.collect.ImmutableMap;

/* compiled from: creative_editing */
public interface TypeaheadFetcher<T> {
    void mo1391a(OnFetchStateChangedListener onFetchStateChangedListener);

    void mo1392a(OnSuggestionsFetchedListener<T> onSuggestionsFetchedListener);

    void mo1393a(ImmutableMap<String, String> immutableMap);

    void mo1394b(TypeaheadRequest typeaheadRequest);

    boolean mo1395d();
}

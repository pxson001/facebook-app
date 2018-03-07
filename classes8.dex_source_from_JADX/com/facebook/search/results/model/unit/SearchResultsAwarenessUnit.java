package com.facebook.search.results.model.unit;

import com.facebook.search.model.SearchResultsBaseFeedUnit;
import com.facebook.search.protocol.awareness.SearchAwarenessInterfaces.SearchAwarenessSuggestionFieldsFragment;

/* compiled from: ResetPasswordFragment */
public class SearchResultsAwarenessUnit extends SearchResultsBaseFeedUnit {
    public final String f23452a;
    public final String f23453b;

    public SearchResultsAwarenessUnit(SearchAwarenessSuggestionFieldsFragment searchAwarenessSuggestionFieldsFragment) {
        this.f23452a = searchAwarenessSuggestionFieldsFragment.mo560g();
        this.f23453b = searchAwarenessSuggestionFieldsFragment.mo559d();
    }
}

package com.facebook.search.suggestions.environment;

import android.content.Context;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.suggestions.SuggestionsFragment.DispatchTypeaheadSuggestionClickVisitor;
import com.facebook.search.typeahead.TypeaheadUnitCollection;

/* compiled from: {link} */
public class SearchSuggestionsEnvironmentProvider extends AbstractAssistedProvider<SearchSuggestionsEnvironment> {
    public final SearchSuggestionsEnvironment m209a(Context context, FeedListType feedListType, Runnable runnable, DispatchTypeaheadSuggestionClickVisitor dispatchTypeaheadSuggestionClickVisitor, TypeaheadUnitCollection typeaheadUnitCollection) {
        return new SearchSuggestionsEnvironment(context, feedListType, runnable, dispatchTypeaheadSuggestionClickVisitor, typeaheadUnitCollection, (QeAccessor) QeInternalImplMethodAutoProvider.a(this), IdBasedSingletonScopeProvider.b(this, 3388));
    }
}

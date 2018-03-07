package com.facebook.search.suggestions;

import android.content.Context;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.logging.perf.SearchWaterfallLogger;
import com.facebook.search.module.BaseSuggestionsTypeaheadControllerMethodAutoProvider;
import com.facebook.search.suggestions.environment.SearchSuggestionsEnvironmentProvider;
import com.facebook.search.suggestions.nullstate.NullStateViewControllerProvider;
import com.facebook.search.suggestions.nullstate.mutator.NullStateSupplierFactory;
import com.facebook.search.typeahead.TypeaheadUnitCollection;

/* compiled from: 😁 */
public class SingleSearchSuggestionListControllerProvider extends AbstractAssistedProvider<SingleSearchSuggestionListController> {
    public final SingleSearchSuggestionListController m114a(Context context, GraphSearchQuery graphSearchQuery) {
        return new SingleSearchSuggestionListController(context, graphSearchQuery, IdBasedLazy.a(this, 10880), BaseSuggestionsTypeaheadControllerMethodAutoProvider.b(this), TypeaheadUnitCollection.m526a((InjectorLike) this), (SearchSuggestionsEnvironmentProvider) getOnDemandAssistedProviderForStaticDi(SearchSuggestionsEnvironmentProvider.class), NullStateSupplierFactory.m357a((InjectorLike) this), IdBasedLazy.a(this, 10920), MultiRowAdapterBuilder.b(this), SearchWaterfallLogger.a(this), MultipleRowsStoriesRecycleCallback.a(this), (NullStateViewControllerProvider) getOnDemandAssistedProviderForStaticDi(NullStateViewControllerProvider.class), TypeaheadListItemComparator.m202a(this));
    }
}

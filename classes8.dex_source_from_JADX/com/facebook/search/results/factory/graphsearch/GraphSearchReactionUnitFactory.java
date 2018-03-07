package com.facebook.search.results.factory.graphsearch;

import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLInterfaces.KeywordSearchModuleFragment;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchModuleFragmentModel;
import com.facebook.search.results.factory.SearchResultsFeedUnitFactory;
import com.facebook.search.results.model.unit.SearchResultsReactionUnit;
import com.google.common.collect.ImmutableList;

/* compiled from: START_PAGE_LOOKUP */
public class GraphSearchReactionUnitFactory implements SearchResultsFeedUnitFactory<KeywordSearchModuleFragment, SearchResultsReactionUnit> {
    public final ImmutableList mo1260a(Object obj) {
        return ImmutableList.of(new SearchResultsReactionUnit(((KeywordSearchModuleFragmentModel) obj).jz_()));
    }
}

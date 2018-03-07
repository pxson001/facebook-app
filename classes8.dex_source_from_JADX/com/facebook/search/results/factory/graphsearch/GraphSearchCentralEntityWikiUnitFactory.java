package com.facebook.search.results.factory.graphsearch;

import com.facebook.graphql.model.FeedUnit;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchModuleFragmentModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchModuleFragmentModel.ResultsModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.ModuleResultEdgeModel;
import com.facebook.search.results.model.unit.SearchResultsCentralWikiUnit;
import javax.annotation.Nullable;

/* compiled from: SUBTITLE */
public class GraphSearchCentralEntityWikiUnitFactory extends GraphSearchSingleFeedUnitFactory<SearchResultsCentralWikiUnit> {
    @Nullable
    protected final FeedUnit mo1261a(KeywordSearchModuleFragmentModel keywordSearchModuleFragmentModel) {
        ResultsModel g = keywordSearchModuleFragmentModel.m8541g();
        if (g == null || g.m8515a().isEmpty()) {
            return null;
        }
        ModuleResultEdgeModel moduleResultEdgeModel = (ModuleResultEdgeModel) g.m8515a().get(0);
        if (moduleResultEdgeModel.m8668b() == null) {
            return null;
        }
        return new SearchResultsCentralWikiUnit(moduleResultEdgeModel.m8668b(), moduleResultEdgeModel.m8667a() != null ? moduleResultEdgeModel.m8667a().m8659a() : null, keywordSearchModuleFragmentModel.m8539c());
    }
}

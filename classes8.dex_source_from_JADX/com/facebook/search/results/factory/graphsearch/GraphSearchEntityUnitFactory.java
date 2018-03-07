package com.facebook.search.results.factory.graphsearch;

import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchModuleFragmentModel;
import com.facebook.search.results.model.unit.SearchResultsEntityUnit;
import javax.annotation.Nullable;

/* compiled from: STRUCTURED_MENU */
public class GraphSearchEntityUnitFactory extends GraphSearchSingleFeedUnitFactory<SearchResultsEntityUnit> {
    @Nullable
    protected final FeedUnit mo1261a(KeywordSearchModuleFragmentModel keywordSearchModuleFragmentModel) {
        GraphQLNode b = GraphSearchModulesUtil.m26328b(keywordSearchModuleFragmentModel);
        if (b == null) {
            return null;
        }
        return new SearchResultsEntityUnit(b, keywordSearchModuleFragmentModel.m8539c());
    }
}

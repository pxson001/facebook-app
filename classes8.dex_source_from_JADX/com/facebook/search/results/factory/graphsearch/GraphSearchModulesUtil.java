package com.facebook.search.results.factory.graphsearch;

import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchModuleFragmentModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchModuleFragmentModel.ResultsModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.ModuleResultEdgeModel;
import javax.annotation.Nullable;

/* compiled from: STORY_TAP */
public class GraphSearchModulesUtil {
    @Nullable
    public static GraphQLGraphSearchResultsDisplayStyle m26327a(KeywordSearchModuleFragmentModel keywordSearchModuleFragmentModel) {
        return (keywordSearchModuleFragmentModel.m8536a() == null || keywordSearchModuleFragmentModel.m8536a().isEmpty()) ? null : (GraphQLGraphSearchResultsDisplayStyle) keywordSearchModuleFragmentModel.m8536a().get(0);
    }

    @Nullable
    public static GraphQLNode m26328b(KeywordSearchModuleFragmentModel keywordSearchModuleFragmentModel) {
        ResultsModel g = keywordSearchModuleFragmentModel.m8541g();
        return (g == null || g.m8515a().isEmpty() || g.m8515a().get(0) == null) ? null : ((ModuleResultEdgeModel) g.m8515a().get(0)).m8668b();
    }
}

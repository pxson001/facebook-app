package com.facebook.search.results.factory.graphsearch;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLInterfaces.KeywordSearchModuleFragment;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLInterfaces.ModuleResultEdge;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchModuleFragmentModel.ResultsModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.ModuleResultEdgeModel;
import com.facebook.search.results.factory.SearchResultsFeedUnitFactory;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: STRONG */
public abstract class GraphSearchFeedUnitFactory<F extends FeedUnit> implements SearchResultsFeedUnitFactory<KeywordSearchModuleFragment, F> {
    @Nullable
    public abstract F mo1265a(ModuleResultEdge moduleResultEdge, GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, String str);

    public ImmutableList<F> mo1268a(KeywordSearchModuleFragment keywordSearchModuleFragment) {
        ResultsModel g = keywordSearchModuleFragment.m8541g();
        if (g == null) {
            return RegularImmutableList.a;
        }
        ImmutableList a = g.m8515a();
        GraphQLGraphSearchResultRole jx_ = keywordSearchModuleFragment.jx_();
        String c = keywordSearchModuleFragment.m8539c();
        Builder builder = new Builder();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            FeedUnit a2 = mo1265a((ModuleResultEdgeModel) a.get(i), jx_, c);
            if (a2 != null) {
                builder.c(a2);
            }
        }
        return builder.b();
    }
}

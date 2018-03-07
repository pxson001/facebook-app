package com.facebook.search.results.model;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.search.results.protocol.SearchResultsEdgeInterfaces.SearchResultsEdge;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeUtil;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: SCOPED */
public class SearchResultUnit {
    public final SearchResultsEdgeModel f23325a;
    public final GraphQLGraphSearchResultRole f23326b;

    public SearchResultUnit(SearchResultsEdgeModel searchResultsEdgeModel) {
        this.f23325a = searchResultsEdgeModel;
        this.f23326b = SearchResultsEdgeUtil.m9799a(searchResultsEdgeModel);
        Preconditions.checkArgument(this.f23326b != GraphQLGraphSearchResultRole.UNSET_OR_UNRECOGNIZED_ENUM_VALUE, "Unknown result type.");
    }

    public static ImmutableList<SearchResultUnit> m27023a(ImmutableList<SearchResultsEdge> immutableList) {
        Builder builder = new Builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            builder.c(new SearchResultUnit((SearchResultsEdgeModel) immutableList.get(i)));
        }
        return builder.b();
    }
}

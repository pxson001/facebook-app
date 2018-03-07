package com.facebook.search.suggestions.nullstate;

import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.search.model.CachedSuggestionList;
import com.facebook.search.protocol.FetchTypeaheadPYMKGraphQLModels.FBTypeaheadPYMKQueryModel;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;

/* compiled from: webrtc/ */
class PYMKLoader$1 implements Function<GraphQLResult<FBTypeaheadPYMKQueryModel>, CachedSuggestionList> {
    final /* synthetic */ PYMKLoader f200a;

    PYMKLoader$1(PYMKLoader pYMKLoader) {
        this.f200a = pYMKLoader;
    }

    public Object apply(Object obj) {
        ImmutableList immutableList;
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult == null || graphQLResult.e == null || ((FBTypeaheadPYMKQueryModel) graphQLResult.e).a() == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = this.f200a.d.a(((FBTypeaheadPYMKQueryModel) graphQLResult.e).a().a());
        }
        return new CachedSuggestionList(immutableList, graphQLResult.clientTimeMs, graphQLResult.freshness);
    }
}

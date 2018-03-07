package com.facebook.richdocument.fetcher;

import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;

/* compiled from: preset_search_location */
class BaseRequestMergingFetcher$DiskOnlyDelegatingFetchParams implements RichDocumentFetchParams<GraphQLRequest<T>> {
    final /* synthetic */ BaseRequestMergingFetcher f5203a;
    private final RichDocumentFetchParams<GraphQLRequest<T>> f5204b;

    public BaseRequestMergingFetcher$DiskOnlyDelegatingFetchParams(BaseRequestMergingFetcher baseRequestMergingFetcher, RichDocumentFetchParams<GraphQLRequest<T>> richDocumentFetchParams) {
        this.f5203a = baseRequestMergingFetcher;
        this.f5204b = richDocumentFetchParams;
    }

    public final Object mo21a() {
        GraphQLRequest graphQLRequest = (GraphQLRequest) this.f5204b.mo21a();
        graphQLRequest.a(GraphQLCachePolicy.b);
        return graphQLRequest;
    }
}

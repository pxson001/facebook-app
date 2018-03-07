package com.facebook.pages.common.surface.protocol.headerfetcher;

import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.FetchPageHeaderQueryModel;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

/* compiled from: result_category */
public class PageHeaderEarlyFetchFuturesHolder {
    @Nullable
    public final ListenableFuture<GraphQLResult<FetchPageHeaderQueryModel>> f2476a;
    @Nullable
    public final ListenableFuture<GraphQLResult<FetchPageHeaderQueryModel>> f2477b;
    @Nullable
    public final String f2478c;
    @Nullable
    public final String f2479d;

    public PageHeaderEarlyFetchFuturesHolder(ListenableFuture<GraphQLResult<FetchPageHeaderQueryModel>> listenableFuture, ListenableFuture<GraphQLResult<FetchPageHeaderQueryModel>> listenableFuture2, String str, String str2) {
        this.f2476a = listenableFuture;
        this.f2477b = listenableFuture2;
        this.f2478c = str;
        this.f2479d = str2;
    }
}

package com.facebook.feedplugins.pyml.fetcher;

import com.facebook.feedplugins.hscroll.ExperimentsForHScrollModule;
import com.facebook.feedplugins.pyml.protocol.FetchPaginatedPYMLWithLargeImageItemsGraphQL.FetchPaginatedPYMLWithLargeImageItemsQueryString;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnit;
import com.facebook.graphql.model.GraphQLStatelessLargeImagePLAsConnection;
import com.facebook.graphql.query.GraphQlQueryString;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: android_messenger_cpe_delta_first */
public class PaginatedPYMLWithLargeImageFeedUnitFetcher$1 implements Callable<ListenableFuture<GraphQLStatelessLargeImagePLAsConnection>> {
    final /* synthetic */ GraphQLPYMLWithLargeImageFeedUnit f19697a;
    final /* synthetic */ PaginatedPYMLWithLargeImageFeedUnitFetcher f19698b;

    public PaginatedPYMLWithLargeImageFeedUnitFetcher$1(PaginatedPYMLWithLargeImageFeedUnitFetcher paginatedPYMLWithLargeImageFeedUnitFetcher, GraphQLPYMLWithLargeImageFeedUnit graphQLPYMLWithLargeImageFeedUnit) {
        this.f19698b = paginatedPYMLWithLargeImageFeedUnitFetcher;
        this.f19697a = graphQLPYMLWithLargeImageFeedUnit;
    }

    public Object call() {
        PaginatedPYMLWithLargeImageFeedUnitFetcher paginatedPYMLWithLargeImageFeedUnitFetcher = this.f19698b;
        int size = this.f19697a.x().size();
        String A = this.f19697a.A();
        String num = Integer.toString(this.f19697a.ac_());
        int min = Math.min(paginatedPYMLWithLargeImageFeedUnitFetcher.m.a(ExperimentsForHScrollModule.c, 8), paginatedPYMLWithLargeImageFeedUnitFetcher.m.a(ExperimentsForHScrollModule.a, 25) - size);
        GraphQlQueryString fetchPaginatedPYMLWithLargeImageItemsQueryString = new FetchPaginatedPYMLWithLargeImageItemsQueryString();
        fetchPaginatedPYMLWithLargeImageItemsQueryString.a("offsetCount", Integer.toString(size)).a("paginationId", A).a("count", Integer.toString(min)).a("afterCursor", num);
        GraphQLRequest a = GraphQLRequest.a(fetchPaginatedPYMLWithLargeImageItemsQueryString);
        if (paginatedPYMLWithLargeImageFeedUnitFetcher.m.a(ExperimentsForHScrollModule.d, false)) {
            a = a.a(GraphQLCachePolicy.a).a((long) paginatedPYMLWithLargeImageFeedUnitFetcher.m.a(ExperimentsForHScrollModule.b, 300));
        }
        return Futures.a(paginatedPYMLWithLargeImageFeedUnitFetcher.d.a(a), new PaginatedPYMLWithLargeImageFeedUnitFetcher$3(paginatedPYMLWithLargeImageFeedUnitFetcher, size), paginatedPYMLWithLargeImageFeedUnitFetcher.e);
    }
}

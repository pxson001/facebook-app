package com.facebook.feedplugins.pyml.fetcher;

import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feedplugins.hscroll.ExperimentsForHScrollModule;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnit;
import com.facebook.graphql.model.GraphQLStatelessLargeImagePLAsConnection;
import com.facebook.graphql.model.GraphQLViewer;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: android_messenger_cpe_delta_first */
public class PaginatedPYMLWithLargeImageFeedUnitFetcher$3 implements Function<GraphQLResult<GraphQLViewer>, GraphQLStatelessLargeImagePLAsConnection> {
    final /* synthetic */ int f19701a;
    final /* synthetic */ PaginatedPYMLWithLargeImageFeedUnitFetcher f19702b;

    public PaginatedPYMLWithLargeImageFeedUnitFetcher$3(PaginatedPYMLWithLargeImageFeedUnitFetcher paginatedPYMLWithLargeImageFeedUnitFetcher, int i) {
        this.f19702b = paginatedPYMLWithLargeImageFeedUnitFetcher;
        this.f19701a = i;
    }

    public Object apply(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        GraphQLStatelessLargeImagePLAsConnection y = ((GraphQLViewer) graphQLResult.e).y();
        if (this.f19702b.m.a(ExperimentsForHScrollModule.d, false)) {
            this.f19702b.f.a(NewsFeedAnalyticsEventBuilder.a(this.f19701a, GraphQLPYMLWithLargeImageFeedUnit.class.toString(), graphQLResult.freshness));
        }
        return y;
    }
}

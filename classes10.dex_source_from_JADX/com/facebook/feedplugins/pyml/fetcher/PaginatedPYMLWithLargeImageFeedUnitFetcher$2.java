package com.facebook.feedplugins.pyml.fetcher;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.feed.util.event.StoryEvents.FeedUnitSubscribeEvent;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnit;
import com.facebook.graphql.model.GraphQLStatelessLargeImagePLAsConnection;
import com.facebook.graphql.model.VisibleItemHelper;
import com.fasterxml.jackson.databind.node.ArrayNode;

/* compiled from: android_messenger_cpe_delta_first */
public class PaginatedPYMLWithLargeImageFeedUnitFetcher$2 extends AbstractDisposableFutureCallback<GraphQLStatelessLargeImagePLAsConnection> {
    final /* synthetic */ GraphQLPYMLWithLargeImageFeedUnit f19699a;
    final /* synthetic */ PaginatedPYMLWithLargeImageFeedUnitFetcher f19700b;

    public PaginatedPYMLWithLargeImageFeedUnitFetcher$2(PaginatedPYMLWithLargeImageFeedUnitFetcher paginatedPYMLWithLargeImageFeedUnitFetcher, GraphQLPYMLWithLargeImageFeedUnit graphQLPYMLWithLargeImageFeedUnit) {
        this.f19700b = paginatedPYMLWithLargeImageFeedUnitFetcher;
        this.f19699a = graphQLPYMLWithLargeImageFeedUnit;
    }

    protected final void m19978a(Object obj) {
        GraphQLStatelessLargeImagePLAsConnection graphQLStatelessLargeImagePLAsConnection = (GraphQLStatelessLargeImagePLAsConnection) obj;
        this.f19700b.a.remove(this.f19699a.g());
        if (graphQLStatelessLargeImagePLAsConnection.a() == null || graphQLStatelessLargeImagePLAsConnection.a().isEmpty()) {
            this.f19700b.c.add(this.f19699a.g());
            return;
        }
        if (graphQLStatelessLargeImagePLAsConnection.j() != null) {
            this.f19700b.k.a(graphQLStatelessLargeImagePLAsConnection.j().a());
        }
        GraphQLPYMLWithLargeImageFeedUnit a = this.f19700b.i.a(graphQLStatelessLargeImagePLAsConnection, this.f19699a);
        int i = 0;
        if (graphQLStatelessLargeImagePLAsConnection.a() != null) {
            i = graphQLStatelessLargeImagePLAsConnection.a().size();
        }
        int size = a.x().size();
        ArrayNode c = VisibleItemHelper.c(this.f19699a);
        HoneyClientEvent a2 = new HoneyClientEvent("pyml_items_fetch").a("tracking", c).a("inf_hscroll_user_pos", this.f19699a.ac_()).a("inf_hscroll_fetch_size", i).a("inf_hscroll_final_size", size);
        a2.c = "native_newsfeed";
        this.f19700b.f.a(a2);
        this.f19700b.h.a(new FeedUnitMutatedEvent(a));
        this.f19700b.h.a(new FeedUnitSubscribeEvent(a));
    }

    protected final void m19979a(Throwable th) {
        this.f19700b.a.remove(this.f19699a.g());
    }
}

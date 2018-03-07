package com.facebook.feed.sponsored;

import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.Sponsorable;

/* compiled from: Typing_Indicator_Cell_Shown */
public class SponsoredFeedUnitCache$FeedEdgeCacheEntry {
    final /* synthetic */ SponsoredFeedUnitCache f21678a;
    public final GraphQLFeedUnitEdge f21679b;
    public final int f21680c;
    public final long f21681d;

    public SponsoredFeedUnitCache$FeedEdgeCacheEntry(SponsoredFeedUnitCache sponsoredFeedUnitCache, GraphQLFeedUnitEdge graphQLFeedUnitEdge, int i, long j) {
        this.f21678a = sponsoredFeedUnitCache;
        this.f21679b = graphQLFeedUnitEdge;
        this.f21680c = i;
        this.f21681d = j;
    }

    public final Sponsorable m24256d() {
        return (Sponsorable) this.f21679b.c();
    }
}

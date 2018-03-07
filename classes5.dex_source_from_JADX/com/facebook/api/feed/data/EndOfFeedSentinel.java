package com.facebook.api.feed.data;

import com.facebook.graphql.model.DedupableUtil.SentinelEdge;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;

/* compiled from: associated_application */
public class EndOfFeedSentinel extends GraphQLFeedUnitEdge implements SentinelEdge {
    private static final EndOfFeedSentinelFeedUnit f8774l = new EndOfFeedSentinelFeedUnit();

    public String toString() {
        return "FeedUnitCollection.END_OF_FEED_SENTINEL";
    }

    public final FeedUnit m14674c() {
        return f8774l;
    }

    public final String m14673a() {
        return "END_OF_FEED_DEDUP_KEY";
    }
}

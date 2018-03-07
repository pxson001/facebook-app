package com.facebook.api.feed.data;

import com.facebook.graphql.model.DedupableUtil.SentinelEdge;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;

/* compiled from: associatedPlacesInfo */
public class LoadingMoreSentinel extends GraphQLFeedUnitEdge implements SentinelEdge {
    private static final LoadingMoreSentinelFeedUnit f8775l = new LoadingMoreSentinelFeedUnit();

    public String toString() {
        return "FeedUnitCollection.LOADING_MORE_SENTINEL";
    }

    public final FeedUnit m14676c() {
        return f8775l;
    }

    public final String m14675a() {
        return "LOADING_MORE_DEDUP_KEY";
    }
}

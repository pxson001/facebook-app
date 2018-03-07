package com.facebook.api.feedcache.db;

import com.facebook.api.feed.util.FeedEdgeComparator;
import com.facebook.feed.model.ClientFeedUnitEdge;
import java.util.Comparator;

/* compiled from: gn */
public class SortKeyCursorInfoComparator implements Comparator<ClientFeedUnitEdge> {
    public static final Comparator f22212a = new SortKeyCursorInfoComparator();

    public int compare(Object obj, Object obj2) {
        return FeedEdgeComparator.m9708a(((ClientFeedUnitEdge) obj).m19084d(), ((ClientFeedUnitEdge) obj2).m19084d());
    }
}

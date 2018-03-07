package com.facebook.api.feedcache.db;

import com.facebook.api.feed.util.FeedEdgeComparator;
import com.facebook.feed.model.ClientFeedUnitEdge;
import java.util.Comparator;

/* compiled from: apps_tcp_bytes_recvd */
public class SeenStateSortKeyComparator implements Comparator<ClientFeedUnitEdge> {
    public static final Comparator f8807a = new SeenStateSortKeyComparator();

    public int compare(Object obj, Object obj2) {
        ClientFeedUnitEdge clientFeedUnitEdge = (ClientFeedUnitEdge) obj;
        ClientFeedUnitEdge clientFeedUnitEdge2 = (ClientFeedUnitEdge) obj2;
        if (clientFeedUnitEdge.z() != clientFeedUnitEdge2.z()) {
            return clientFeedUnitEdge.E() ? 1 : -1;
        } else {
            return FeedEdgeComparator.a(clientFeedUnitEdge.d(), clientFeedUnitEdge2.d());
        }
    }
}

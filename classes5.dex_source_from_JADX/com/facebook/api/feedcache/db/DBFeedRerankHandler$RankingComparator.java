package com.facebook.api.feedcache.db;

import com.facebook.feed.model.ClientFeedUnitEdge;
import java.util.Comparator;

/* compiled from: article_author_name */
public class DBFeedRerankHandler$RankingComparator implements Comparator<ClientFeedUnitEdge> {
    public static final Comparator f8790a = new DBFeedRerankHandler$RankingComparator();

    public int compare(Object obj, Object obj2) {
        ClientFeedUnitEdge clientFeedUnitEdge = (ClientFeedUnitEdge) obj;
        ClientFeedUnitEdge clientFeedUnitEdge2 = (ClientFeedUnitEdge) obj2;
        if (clientFeedUnitEdge.z() != clientFeedUnitEdge2.z()) {
            return clientFeedUnitEdge.E() ? 1 : -1;
        } else {
            return Double.compare(clientFeedUnitEdge.X_(), clientFeedUnitEdge2.X_()) * -1;
        }
    }
}

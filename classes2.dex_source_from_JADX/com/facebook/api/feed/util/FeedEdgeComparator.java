package com.facebook.api.feed.util;

import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import java.util.Comparator;

/* compiled from: send_error_message */
public class FeedEdgeComparator implements Comparator<FeedEdge> {
    public static final Comparator<FeedEdge> f5641a = new FeedEdgeComparator();
    public static final String f5642b = Character.toString('ѣ');
    public static final String f5643c = Character.toString('\u0000');

    public int compare(Object obj, Object obj2) {
        return m9708a(((GraphQLFeedUnitEdge) obj).V_(), ((GraphQLFeedUnitEdge) obj2).V_());
    }

    private FeedEdgeComparator() {
    }

    public static int m9708a(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                return str2.compareTo(str);
            }
            return 1;
        } else if (str2 == null) {
            return 0;
        } else {
            return -1;
        }
    }
}

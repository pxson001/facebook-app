package com.facebook.api.feedcache.omnistore.util;

import com.facebook.androidcompat.AndroidCompat;
import com.facebook.api.feed.util.FeedEdgeComparator;
import com.facebook.api.feedcache.omnistore.OmnistoreUpdateSubscriber;
import com.facebook.feed.model.ClientFeedUnitEdge;
import com.facebook.omnistore.Collection.SortDirection;
import com.facebook.omnistore.Cursor;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: app_ver */
public class OmnistoreUpdateUtil {
    public static void m14738a(ImmutableList<ClientFeedUnitEdge> immutableList, Builder<ClientFeedUnitEdge> builder, Builder<String> builder2, OmnistoreUpdateSubscriber omnistoreUpdateSubscriber) {
        Throwable th;
        int size = immutableList.size();
        int i = 0;
        Cursor query = omnistoreUpdateSubscriber.b().query(FeedEdgeComparator.b, -1, SortDirection.DESCENDING);
        Throwable th2 = null;
        try {
            int compareTo;
            boolean step = query.step();
            while (i < size && step) {
                compareTo = ((ClientFeedUnitEdge) immutableList.get(i)).d().compareTo(query.getSortKey());
                if (compareTo == 0) {
                    i++;
                    step = query.step();
                } else if (compareTo > 0) {
                    builder.c(immutableList.get(i));
                    i++;
                } else {
                    builder2.c(query.getPrimaryKey());
                    step = query.step();
                }
            }
            for (compareTo = i; compareTo < size; compareTo++) {
                builder.c(immutableList.get(compareTo));
            }
            for (boolean z = step; z; z = query.step()) {
                builder2.c(query.getPrimaryKey());
            }
            if (query != null) {
                query.close();
                return;
            }
            return;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        if (query != null) {
            if (th22 != null) {
                try {
                    query.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                query.close();
            }
        }
        throw th;
        throw th;
    }
}

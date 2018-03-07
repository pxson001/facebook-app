package com.facebook.feed.data.freshfeed;

import com.facebook.api.feed.util.FeedEdgeComparator;
import com.facebook.common.collect.MapWithSecondaryOrdering;
import com.facebook.common.internal.Preconditions;
import com.facebook.feed.model.ClientFeedUnitEdge;
import java.util.Comparator;
import javax.annotation.Nullable;

/* compiled from: search_thread_name_and_participants */
public class FreshFeedStoryOrderCollection implements FreshFeedSponsoredEdgesCollection {
    private static final String f5867a = FreshFeedStoryOrderCollection.class.getSimpleName();
    public final MapWithSecondaryOrdering<String, ClientFeedUnitEdge> f5868b = new MapWithSecondaryOrdering(new ClientFeedEdgeComparator(this));
    private int f5869c = 0;

    /* compiled from: search_thread_name_and_participants */
    class ClientFeedEdgeComparator implements Comparator<ClientFeedUnitEdge> {
        final /* synthetic */ FreshFeedStoryOrderCollection f5870a;

        public int compare(Object obj, Object obj2) {
            return FeedEdgeComparator.m9708a(((ClientFeedUnitEdge) obj).m19084d(), ((ClientFeedUnitEdge) obj2).m19084d());
        }

        public ClientFeedEdgeComparator(FreshFeedStoryOrderCollection freshFeedStoryOrderCollection) {
            this.f5870a = freshFeedStoryOrderCollection;
        }
    }

    public final void mo1418a(ClientFeedUnitEdge clientFeedUnitEdge) {
        Object obj = null;
        if (this.f5868b.containsKey(clientFeedUnitEdge.m19080b())) {
            this.f5868b.remove(clientFeedUnitEdge.m19080b());
            obj = 1;
        }
        this.f5868b.put(clientFeedUnitEdge.m19080b(), clientFeedUnitEdge);
        if (obj == null && m10021b(clientFeedUnitEdge)) {
            this.f5869c++;
        }
    }

    @Nullable
    public final ClientFeedUnitEdge mo1417a(int i) {
        boolean z = false;
        Preconditions.a(i >= 0);
        if (i < this.f5868b.size()) {
            z = m10021b((ClientFeedUnitEdge) this.f5868b.f5654e.get(i));
        }
        if (z) {
            return (ClientFeedUnitEdge) this.f5868b.f5654e.get(i);
        }
        return null;
    }

    @Nullable
    public final ClientFeedUnitEdge mo1419b(int i) {
        return mo1417a(i);
    }

    public final int mo1416a() {
        return this.f5869c;
    }

    public static boolean m10021b(ClientFeedUnitEdge clientFeedUnitEdge) {
        return "Ad".equals(clientFeedUnitEdge.f14834z);
    }
}

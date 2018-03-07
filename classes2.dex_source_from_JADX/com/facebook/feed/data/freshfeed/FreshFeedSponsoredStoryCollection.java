package com.facebook.feed.data.freshfeed;

import com.facebook.api.feed.xconfig.FreshFeedConfig;
import com.facebook.api.feed.xconfig.FreshFeedConfigReader;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.time.Clock;
import com.facebook.feed.freshfeed.FreshFeedRanker;
import com.facebook.feed.freshfeed.FreshFeedRankerProvider;
import com.facebook.feed.model.ClientFeedUnitEdge;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: goodwill_throwback_feed_type */
public class FreshFeedSponsoredStoryCollection implements FreshFeedSponsoredEdgesCollection {
    @VisibleForTesting
    protected static final String[] f22123a = new String[]{"O", "A", "O", "O", "O", "O", "O", "O", "O", "O", "A", "O", "O", "O", "O", "O", "O", "O"};
    public final ArrayList<ClientFeedUnitEdge> f22124b = new ArrayList();
    public final FreshFeedRanker f22125c;
    private final Clock f22126d;
    public final FreshFeedConfigReader f22127e;
    public final Set<String> f22128f = new HashSet();

    public FreshFeedSponsoredStoryCollection(FreshFeedRankerProvider freshFeedRankerProvider, Clock clock, FreshFeedConfigReader freshFeedConfigReader) {
        this.f22125c = freshFeedRankerProvider.m10013a(1);
        this.f22126d = clock;
        this.f22127e = freshFeedConfigReader;
    }

    public final void mo1418a(ClientFeedUnitEdge clientFeedUnitEdge) {
        if ("Ad".equals(clientFeedUnitEdge.f14834z) && this.f22126d.mo211a() - clientFeedUnitEdge.f14828t < 60000 * ((long) this.f22127e.m9087a(FreshFeedConfig.f5203e, 1, 9)) && !this.f22128f.contains(clientFeedUnitEdge.m19080b())) {
            this.f22124b.add(clientFeedUnitEdge);
            this.f22128f.add(clientFeedUnitEdge.m19080b());
        }
    }

    @Nullable
    public final ClientFeedUnitEdge mo1417a(int i) {
        int i2 = 0;
        Preconditions.a(i >= 0);
        if ("A".equals(m30003c()[m30002c(i)])) {
            while (i2 < 10) {
                ClientFeedUnitEdge clientFeedUnitEdge = null;
                if (!this.f22124b.isEmpty()) {
                    this.f22125c.mo1415a(this.f22124b);
                    ClientFeedUnitEdge clientFeedUnitEdge2 = (ClientFeedUnitEdge) this.f22124b.remove(0);
                    this.f22128f.remove(clientFeedUnitEdge2.m19080b());
                    clientFeedUnitEdge = clientFeedUnitEdge2;
                }
                ClientFeedUnitEdge clientFeedUnitEdge3 = clientFeedUnitEdge;
                if (clientFeedUnitEdge3 == null) {
                    return clientFeedUnitEdge3;
                }
                if (clientFeedUnitEdge3 != null && clientFeedUnitEdge3.mo2540c() != null) {
                    return clientFeedUnitEdge3;
                }
                i2++;
            }
        }
        return null;
    }

    @Nullable
    public final ClientFeedUnitEdge mo1419b(int i) {
        Preconditions.a(i >= 0);
        int c = m30002c(i);
        if (this.f22124b.isEmpty()) {
            return null;
        }
        if ("A".equals(m30003c()[c])) {
            return (ClientFeedUnitEdge) this.f22124b.get(0);
        }
        return null;
    }

    public final int mo1416a() {
        return this.f22124b.size();
    }

    @VisibleForTesting
    private String[] m30003c() {
        return this.f22127e.m9090a(FreshFeedConfig.f5219u, 0, f22123a);
    }

    private int m30002c(int i) {
        return i % m30003c().length;
    }
}

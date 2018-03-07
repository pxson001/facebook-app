package com.facebook.feed.data.freshfeed;

import com.facebook.api.feed.xconfig.FreshFeedConfig;
import com.facebook.api.feed.xconfig.FreshFeedConfigReader;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.data.freshfeed.ranking.ClientRankingSignalStore;
import com.facebook.feed.freshfeed.FreshFeedRanker;
import com.facebook.feed.freshfeed.FreshFeedRankerProvider;
import com.facebook.feed.freshfeed.FreshFeedStoryCollectionStatus;
import com.facebook.feed.model.ClientFeedUnitEdge;
import com.facebook.graphql.enums.GraphQLBumpReason;
import com.facebook.graphql.model.FeedUnitMediaLoadedInfo;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.MediaLoadedInfo;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: search_ufi */
public class FreshFeedStoryCollection {
    private static final String f5840b = FreshFeedStoryCollection.class.getSimpleName();
    @VisibleForTesting
    protected final ArrayList<ClientFeedUnitEdge> f5841a = new ArrayList();
    public final Clock f5842c;
    public final ArrayList<ClientFeedUnitEdge> f5843d = new ArrayList(200);
    private final FreshFeedRanker f5844e;
    private final FreshFeedStoryCollectionStatus f5845f;
    private final Set<String> f5846g;
    public final QeAccessor f5847h;
    private final ClientRankingSignalStore f5848i;
    public final FreshFeedConfigReader f5849j;
    public final FreshFeedSponsoredEdgesCollection f5850k;
    public int f5851l = 0;
    private String f5852m = null;

    public static FreshFeedStoryCollection m9994b(InjectorLike injectorLike) {
        Clock a = SystemClockMethodAutoProvider.m1498a(injectorLike);
        FreshFeedRankerProvider freshFeedRankerProvider = new FreshFeedRankerProvider();
        Provider a2 = IdBasedSingletonScopeProvider.m1809a(injectorLike, 1376);
        Provider a3 = IdBasedSingletonScopeProvider.m1809a(injectorLike, 1377);
        freshFeedRankerProvider.f5853a = a2;
        freshFeedRankerProvider.f5854b = a3;
        return new FreshFeedStoryCollection(a, freshFeedRankerProvider, QeInternalImplMethodAutoProvider.m3744a(injectorLike), ClientRankingSignalStore.m9365a(injectorLike), FreshFeedConfigReader.m9080a(injectorLike));
    }

    @Inject
    public FreshFeedStoryCollection(Clock clock, FreshFeedRankerProvider freshFeedRankerProvider, QeAccessor qeAccessor, ClientRankingSignalStore clientRankingSignalStore, FreshFeedConfigReader freshFeedConfigReader) {
        FreshFeedStoryOrderCollection freshFeedStoryOrderCollection;
        this.f5842c = clock;
        this.f5848i = clientRankingSignalStore;
        this.f5844e = freshFeedRankerProvider.m10013a(0);
        this.f5845f = FreshFeedStoryCollectionStatus.f5862a;
        this.f5846g = new HashSet();
        this.f5847h = qeAccessor;
        this.f5849j = freshFeedConfigReader;
        if (this.f5847h.mo596a(ExperimentsForNewsFeedAbTestModule.f5085L, false)) {
            freshFeedStoryOrderCollection = new FreshFeedStoryOrderCollection();
        } else {
            freshFeedStoryOrderCollection = new FreshFeedSponsoredStoryCollection(freshFeedRankerProvider, this.f5842c, this.f5849j);
        }
        this.f5850k = freshFeedStoryOrderCollection;
    }

    public final int m10003a() {
        switch (this.f5849j.m9087a(FreshFeedConfig.f5215q, 12, 1)) {
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return m9996i();
            case 3:
                return m9998k();
            default:
                return m9995h();
        }
    }

    private int m9995h() {
        TracerDetour.a("FreshFeedStoryCollection.getFreshStoryCount", 861258495);
        int i;
        try {
            int size = this.f5843d.size();
            int i2 = 0;
            i = 0;
            while (i2 < size) {
                int i3;
                ClientFeedUnitEdge clientFeedUnitEdge = (ClientFeedUnitEdge) this.f5843d.get(i2);
                if (this.f5842c.mo211a() - clientFeedUnitEdge.m21238w() >= m9999l() || clientFeedUnitEdge.m21241z() != 0) {
                    i3 = i;
                } else {
                    i3 = i + 1;
                }
                i2++;
                i = i3;
            }
            return i;
        } finally {
            i = 151787129;
            TracerDetour.a(151787129);
        }
    }

    private int m9996i() {
        TracerDetour.a("FreshFeedStoryCollection.getTopSnapshotStoryCount", -1997306718);
        int i;
        try {
            long j = m9997j();
            int size = this.f5843d.size();
            int i2 = 0;
            i = 0;
            while (i2 < size) {
                int i3;
                if (((ClientFeedUnitEdge) this.f5843d.get(i2)).m21226D() == j) {
                    i3 = i + 1;
                } else {
                    i3 = i;
                }
                i2++;
                i = i3;
            }
            return i;
        } finally {
            i = 604734316;
            TracerDetour.a(604734316);
        }
    }

    private long m9997j() {
        long j = 0;
        int size = this.f5843d.size();
        int i = 0;
        while (i < size) {
            long j2;
            ClientFeedUnitEdge clientFeedUnitEdge = (ClientFeedUnitEdge) this.f5843d.get(i);
            if (j < clientFeedUnitEdge.f14819C) {
                j2 = clientFeedUnitEdge.f14819C;
            } else {
                j2 = j;
            }
            i++;
            j = j2;
        }
        return j;
    }

    private int m9998k() {
        TracerDetour.a("FreshFeedStoryCollection.getTopSnapshotStoryCountNetworkStoriesOnly", 788378921);
        int i;
        try {
            long j = m9997j();
            int size = this.f5843d.size();
            int i2 = 0;
            i = 0;
            while (i2 < size) {
                int i3;
                ClientFeedUnitEdge clientFeedUnitEdge = (ClientFeedUnitEdge) this.f5843d.get(i2);
                if (clientFeedUnitEdge.m21226D() != j || clientFeedUnitEdge.m21228F()) {
                    i3 = i;
                } else {
                    i3 = i + 1;
                }
                i2++;
                i = i3;
            }
            return i;
        } finally {
            i = -274128224;
            TracerDetour.a(-274128224);
        }
    }

    @VisibleForTesting
    private long m9999l() {
        return 60000 * ((long) this.f5849j.m9087a(FreshFeedConfig.f5202d, 0, 9));
    }

    public final boolean m10006a(ImmutableList<ClientFeedUnitEdge> immutableList, int i) {
        TracerDetour.a("FreshFeedStoryCollection.addCachedStoriesToCollection", 1198772594);
        try {
            boolean z;
            int size = immutableList.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                ClientFeedUnitEdge clientFeedUnitEdge = (ClientFeedUnitEdge) immutableList.get(i3);
                if (!"Ad".equals(clientFeedUnitEdge.m21223A())) {
                    m9992a(clientFeedUnitEdge, i);
                    i2++;
                }
                this.f5850k.mo1418a(clientFeedUnitEdge);
            }
            m10002o();
            if (i2 <= 0 || i != 3) {
                z = false;
            } else {
                z = true;
            }
            TracerDetour.a(660390595);
            return z;
        } catch (Throwable th) {
            TracerDetour.a(-1035874380);
        }
    }

    private void m9992a(ClientFeedUnitEdge clientFeedUnitEdge, int i) {
        if ((i != 4 && i != 3) || !this.f5846g.contains(clientFeedUnitEdge.m19080b())) {
            if (this.f5846g.contains(clientFeedUnitEdge.m19080b())) {
                GraphQLFeedUnitEdge graphQLFeedUnitEdge;
                String b = clientFeedUnitEdge.m19080b();
                Iterator it = this.f5843d.iterator();
                while (it.hasNext()) {
                    graphQLFeedUnitEdge = (ClientFeedUnitEdge) it.next();
                    if (b.equals(graphQLFeedUnitEdge.m19080b())) {
                        it.remove();
                        break;
                    }
                }
                graphQLFeedUnitEdge = null;
                GraphQLFeedUnitEdge graphQLFeedUnitEdge2 = graphQLFeedUnitEdge;
                if (graphQLFeedUnitEdge2 != null && clientFeedUnitEdge.m19090m() == GraphQLBumpReason.BUMP_UNREAD) {
                    PropertyHelper.m21297c((GraphQLFeedUnitEdge) clientFeedUnitEdge, String.valueOf(graphQLFeedUnitEdge2.m21241z()));
                }
            }
            this.f5843d.add(clientFeedUnitEdge);
            this.f5846g.add(clientFeedUnitEdge.m19080b());
            this.f5848i.m9367a(clientFeedUnitEdge);
        }
    }

    public final boolean m10008b(ImmutableList<ClientFeedUnitEdge> immutableList, int i) {
        TracerDetour.a("FreshFeedStoryCollection.addFreshStoriesToCollection", -1043631331);
        try {
            boolean z;
            int size = immutableList.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                ClientFeedUnitEdge clientFeedUnitEdge = (ClientFeedUnitEdge) immutableList.get(i3);
                if (!"Ad".equals(clientFeedUnitEdge.m21223A())) {
                    m9992a(clientFeedUnitEdge, i);
                    i2++;
                }
                this.f5850k.mo1418a(clientFeedUnitEdge);
                this.f5852m = clientFeedUnitEdge.m19086g();
            }
            m10002o();
            if (i2 > 0 || m9993a(i2, i)) {
                z = true;
            } else {
                z = false;
            }
            TracerDetour.a(-1780579601);
            return z;
        } catch (Throwable th) {
            TracerDetour.a(-1254167695);
        }
    }

    public final void m10004a(ImmutableList<ClientFeedUnitEdge> immutableList) {
        TracerDetour.a("FreshFeedStoryCollection.addStagedStoriesToCollection", -1623805524);
        try {
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                this.f5841a.add((ClientFeedUnitEdge) immutableList.get(i));
            }
        } finally {
            TracerDetour.a(-1189581745);
        }
    }

    public final void m10007b() {
        TracerDetour.a("FreshFeedStoryCollection.unStageStoriesToCollection", 242766258);
        try {
            m10008b(ImmutableList.copyOf(this.f5841a), 0);
            this.f5841a.clear();
        } finally {
            TracerDetour.a(2052032182);
        }
    }

    private boolean m9993a(int i, int i2) {
        return i == 0 && i2 == 0 && this.f5847h.mo596a(ExperimentsForNewsFeedAbTestModule.f5082I, false);
    }

    @Nullable
    public final ClientFeedUnitEdge m10009c() {
        TracerDetour.a("FreshFeedStoryCollection.getNextBest", -461707489);
        try {
            ClientFeedUnitEdge a = this.f5850k.mo1417a(this.f5851l);
            if (a == null || a.mo2540c() == null) {
                a = m10000m();
            }
            if (a == null || a.mo2540c() == null) {
                TracerDetour.a(-752678293);
                return null;
            }
            this.f5851l++;
            m10002o();
            TracerDetour.a(1587225870);
            return a;
        } catch (Throwable th) {
            TracerDetour.a(1875310471);
        }
    }

    public final String m10010d() {
        return this.f5852m;
    }

    public final boolean m10011e() {
        return this.f5843d.isEmpty();
    }

    public final void m10012f() {
        this.f5851l = 0;
    }

    public final void m10005a(String str, String str2, int i) {
        if (str != null) {
            GraphQLFeedUnitEdge graphQLFeedUnitEdge = null;
            int size = this.f5843d.size();
            for (int i2 = 0; i2 < size; i2++) {
                GraphQLFeedUnitEdge graphQLFeedUnitEdge2 = (ClientFeedUnitEdge) this.f5843d.get(i2);
                if (str.equals(graphQLFeedUnitEdge2.f14818B)) {
                    graphQLFeedUnitEdge = graphQLFeedUnitEdge2;
                    break;
                }
            }
            if (graphQLFeedUnitEdge != null) {
                Object obj;
                FeedUnitMediaLoadedInfo d = PropertyHelper.m21298d(graphQLFeedUnitEdge);
                if (d == null) {
                    d = new FeedUnitMediaLoadedInfo();
                    PropertyHelper.m21271a(graphQLFeedUnitEdge, d);
                }
                for (MediaLoadedInfo mediaLoadedInfo : d.f14911a) {
                    if (mediaLoadedInfo.f15045b.equals(str2)) {
                        mediaLoadedInfo.f15044a = i;
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    d.f14911a.add(new MediaLoadedInfo(str2, i));
                }
                this.f5848i.m9372b(str, graphQLFeedUnitEdge.m21224B());
            }
        }
    }

    private ClientFeedUnitEdge m10000m() {
        TracerDetour.a("FreshFeedStoryCollection.getNextBestStory", -1729481218);
        ClientFeedUnitEdge clientFeedUnitEdge = null;
        try {
            if (!this.f5843d.isEmpty()) {
                this.f5844e.mo1415a(this.f5843d);
                clientFeedUnitEdge = m10001n();
            }
            TracerDetour.a(1497404141);
            return clientFeedUnitEdge;
        } catch (Throwable th) {
            TracerDetour.a(431018949);
        }
    }

    private ClientFeedUnitEdge m10001n() {
        ClientFeedUnitEdge clientFeedUnitEdge = (ClientFeedUnitEdge) this.f5843d.remove(0);
        this.f5846g.remove(clientFeedUnitEdge.m19080b());
        return clientFeedUnitEdge;
    }

    private void m10002o() {
        TracerDetour.a("FreshFeedStoryCollection.updateDebugStats", 1556529921);
        try {
            if (this.f5845f.m10020e()) {
                this.f5845f.m10019a(this.f5843d.size(), m10003a(), this.f5850k.mo1416a());
            }
            TracerDetour.a(1772564448);
        } catch (Throwable th) {
            TracerDetour.a(-1023386285);
        }
    }
}

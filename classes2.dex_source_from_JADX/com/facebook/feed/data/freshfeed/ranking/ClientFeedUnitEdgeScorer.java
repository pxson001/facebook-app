package com.facebook.feed.data.freshfeed.ranking;

import android.support.v4.util.LruCache;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.time.Clock;
import com.facebook.feed.model.ClientFeedUnitEdge;
import com.facebook.inject.Assisted;
import com.facebook.multifeed.ranking.core.value_model.ClientValueModelHolder;
import com.facebook.multifeed.ranking.core.value_model.ClientValueModelHolderProvider;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;

/* compiled from: goodFriends */
public class ClientFeedUnitEdgeScorer implements Comparator<ClientFeedUnitEdge> {
    private static final String f22200a = ClientFeedUnitEdgeScorer.class.getSimpleName();
    private static final String[] f22201b = new String[2];
    private static final String[] f22202c = new String[14];
    private final ClientValueModelHolder f22203d;
    private final Clock f22204e;
    private final ClientRankingSignalStore f22205f;
    private final LruCache<String, Double> f22206g;
    private final HashMap<ClientFeedUnitEdge, Double> f22207h;
    public final GlobalClientRankingSignal f22208i;
    public final HashMap<String, String> f22209j;
    public boolean f22210k = false;

    public int compare(Object obj, Object obj2) {
        ClientFeedUnitEdge clientFeedUnitEdge = (ClientFeedUnitEdge) obj;
        ClientFeedUnitEdge clientFeedUnitEdge2 = (ClientFeedUnitEdge) obj2;
        Double d = (Double) this.f22207h.get(clientFeedUnitEdge);
        Double d2 = (Double) this.f22207h.get(clientFeedUnitEdge2);
        if (d == null) {
            throw new IllegalStateException("Memoized Ranking score was null for edge: " + clientFeedUnitEdge);
        } else if (d2 == null) {
            throw new IllegalStateException("Memoized Ranking score was null for edge: " + clientFeedUnitEdge2);
        } else if (d.equals(d2)) {
            return 0;
        } else {
            return d.doubleValue() < d2.doubleValue() ? 1 : -1;
        }
    }

    @Inject
    public ClientFeedUnitEdgeScorer(@Assisted String str, Clock clock, ClientRankingSignalStore clientRankingSignalStore, ClientValueModelHolderProvider clientValueModelHolderProvider) {
        this.f22203d = new ClientValueModelHolder(str, "default");
        this.f22204e = clock;
        this.f22205f = clientRankingSignalStore;
        this.f22208i = clientRankingSignalStore.m9369a();
        f22201b[0] = "weight_final";
        f22202c[0] = "client_has_seen";
        f22202c[2] = "cur_client_story_age_ms";
        f22202c[4] = "image_cache_state";
        f22202c[6] = "live_video_ended";
        f22202c[8] = "connection_quality";
        f22202c[10] = "is_offline";
        f22202c[12] = "photo_taken_in_last_n_minutes";
        this.f22206g = new LruCache(250);
        this.f22207h = new HashMap(250);
        this.f22209j = new HashMap(3);
    }

    public final synchronized void m30093a(List<ClientFeedUnitEdge> list) {
        m30092b(list);
        Collections.sort(list, this);
        this.f22207h.clear();
    }

    @VisibleForTesting
    private void m30092b(List<ClientFeedUnitEdge> list) {
        boolean z = false;
        GlobalClientRankingSignal globalClientRankingSignal = this.f22208i;
        boolean a = globalClientRankingSignal.f5483e.m9377a(GlobalClientRankingSignal.f5478a);
        if (globalClientRankingSignal.mIsPhotoTakenInLastNMinutes != a) {
            globalClientRankingSignal.f5485g = true;
            globalClientRankingSignal.mIsPhotoTakenInLastNMinutes = a;
        }
        if (this.f22210k || this.f22208i.f5485g) {
            Object obj;
            this.f22209j.put("connection_quality", String.valueOf(this.f22208i.mConnectionQuality.ordinal()));
            HashMap hashMap = this.f22209j;
            String str = "is_offline";
            if (this.f22208i.mIsConnected) {
                obj = "0";
            } else {
                obj = "1";
            }
            hashMap.put(str, obj);
            hashMap = this.f22209j;
            str = "photo_taken_in_last_n_minutes";
            if (this.f22208i.mIsPhotoTakenInLastNMinutes) {
                obj = "1";
            } else {
                obj = "0";
            }
            hashMap.put(str, obj);
            this.f22208i.f5485g = false;
            this.f22210k = false;
            z = true;
        }
        boolean z2 = z;
        for (ClientFeedUnitEdge clientFeedUnitEdge : list) {
            this.f22207h.put(clientFeedUnitEdge, Double.valueOf(m30091a(clientFeedUnitEdge, z2)));
        }
    }

    private double m30091a(ClientFeedUnitEdge clientFeedUnitEdge, boolean z) {
        String b = clientFeedUnitEdge.m19080b();
        ClientRankingSignal b2 = this.f22205f.m9371b(b);
        if (b2 == null) {
            b2 = this.f22205f.m9367a(clientFeedUnitEdge);
            if (b2 == null) {
                throw new IllegalArgumentException("Can't create ClientRankingSignal for edge: " + clientFeedUnitEdge);
            }
        }
        ClientRankingSignal clientRankingSignal = b2;
        long a = this.f22204e.mo211a() - clientRankingSignal.mFetchedAt;
        Object obj = b + (a / 60000);
        Double d = (Double) this.f22206g.m4432a(obj);
        if (clientRankingSignal.f22199a || d == null || z) {
            String str;
            f22201b[1] = String.valueOf(clientRankingSignal.mRankingWeight);
            String[] strArr = f22202c;
            if (clientRankingSignal.mSeenState == 0) {
                str = "0";
            } else {
                str = "1";
            }
            strArr[1] = str;
            f22202c[3] = String.valueOf(a);
            f22202c[5] = String.valueOf(clientRankingSignal.mImageCacheState);
            strArr = f22202c;
            if (clientRankingSignal.mLiveVideoState == 2) {
                str = "1";
            } else {
                str = "0";
            }
            strArr[7] = str;
            f22202c[9] = (String) this.f22209j.get("connection_quality");
            f22202c[11] = (String) this.f22209j.get("is_offline");
            f22202c[13] = (String) this.f22209j.get("photo_taken_in_last_n_minutes");
            ClientValueModelHolder clientValueModelHolder = this.f22203d;
            String[] strArr2 = f22201b;
            String[] strArr3 = f22202c;
            if (clientRankingSignal.mFeaturesMeta == null) {
                str = "";
            } else {
                str = clientRankingSignal.mFeaturesMeta;
            }
            d = Double.valueOf(clientValueModelHolder.score(strArr2, strArr3, str));
            clientRankingSignal.mClientWeight = d.doubleValue();
            clientRankingSignal.f22199a = false;
            this.f22206g.m4433a(obj, (Object) d);
        }
        return d.doubleValue();
    }

    public final void m30094a(boolean z) {
        this.f22210k = z;
    }
}

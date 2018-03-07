package com.facebook.feed.logging;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.graphql.model.FeedUnit;
import java.util.Arrays;
import java.util.Map;
import java.util.WeakHashMap;
import javax.inject.Inject;

/* compiled from: messenger_wear_enable */
public class FeedUnitHeightTrackerStore {
    private final FeedUnitImpressionLoggerController f13660a;
    public final Map<FeedUnit, FeedUnitData> f13661b = new WeakHashMap();

    /* compiled from: messenger_wear_enable */
    public class FeedUnitData {
        final /* synthetic */ FeedUnitHeightTrackerStore f19609a;
        public final int[] f19610b;
        public final int f19611c;
        public int f19612d;
        public int f19613e;

        public FeedUnitData(FeedUnitHeightTrackerStore feedUnitHeightTrackerStore, int i) {
            this.f19609a = feedUnitHeightTrackerStore;
            this.f19610b = new int[i];
            Arrays.fill(this.f19610b, -1);
            this.f19611c = i;
        }

        public final int m27329a(int i) {
            int i2 = 0;
            if (!m27327c(this)) {
                return -1;
            }
            int i3 = 0;
            while (i3 < i) {
                int c = m27326c(i3) + i2;
                i3++;
                i2 = c;
            }
            return i2;
        }

        public final int m27328a() {
            return m27327c(this) ? this.f19612d : -1;
        }

        public static boolean m27327c(FeedUnitData feedUnitData) {
            return feedUnitData.f19613e == feedUnitData.f19611c;
        }

        public final boolean m27330b(int i) {
            return m27326c(i) != -1;
        }

        private int m27326c(int i) {
            return this.f19610b[i];
        }
    }

    @Inject
    public FeedUnitHeightTrackerStore(FeedUnitImpressionLoggerController feedUnitImpressionLoggerController) {
        this.f13660a = feedUnitImpressionLoggerController;
    }

    public final void m20074a(FeedUnit feedUnit, int i, int i2, int i3) {
        FeedUnitData feedUnitData = (FeedUnitData) this.f13661b.get(feedUnit);
        boolean a = m20071a(feedUnit, feedUnitData, i3);
        if (feedUnitData == null || a) {
            FeedUnitData feedUnitData2 = new FeedUnitData(this, i3);
            this.f13661b.put(feedUnit, feedUnitData2);
            feedUnitData = feedUnitData2;
        }
        if (!feedUnitData.m27330b(i)) {
            feedUnitData.f19612d += i2;
            feedUnitData.f19610b[i] = i2;
            feedUnitData.f19613e++;
        }
        if (FeedUnitData.m27327c(feedUnitData)) {
            this.f13660a.m14198a(feedUnit, feedUnitData.m27328a());
        }
    }

    public final int m20073a(FeedUnit feedUnit, int i, int i2) {
        FeedUnitData feedUnitData = (FeedUnitData) this.f13661b.get(feedUnit);
        return (feedUnitData == null || m20071a(feedUnit, feedUnitData, i2)) ? -1 : feedUnitData.m27329a(i);
    }

    @VisibleForTesting
    public final int m20072a(FeedUnit feedUnit, int i) {
        FeedUnitData feedUnitData = (FeedUnitData) this.f13661b.get(feedUnit);
        return (feedUnitData == null || m20071a(feedUnit, feedUnitData, i)) ? -1 : feedUnitData.m27328a();
    }

    public final boolean m20075b(FeedUnit feedUnit, int i, int i2) {
        FeedUnitData feedUnitData = (FeedUnitData) this.f13661b.get(feedUnit);
        return (feedUnitData == null || m20071a(feedUnit, feedUnitData, i2) || !feedUnitData.m27330b(i)) ? false : true;
    }

    private boolean m20071a(FeedUnit feedUnit, FeedUnitData feedUnitData, int i) {
        if (feedUnitData == null || feedUnitData.f19611c == i) {
            return false;
        }
        this.f13661b.remove(feedUnit);
        return true;
    }
}

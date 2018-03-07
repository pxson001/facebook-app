package com.facebook.feed.workingrange.rows;

import com.facebook.common.util.TriState;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.qe.api.QeAccessor;

/* compiled from: method/mobile.zeroInterstitialEligibility */
public class FeedRangesExperiments {
    private static TriState f13574a = TriState.UNSET;
    private static TriState f13575b = TriState.UNSET;

    public static boolean m19960a(QeAccessor qeAccessor) {
        if (!f13574a.isSet()) {
            f13574a = TriState.valueOf(qeAccessor.mo596a(ExperimentsForNewsFeedAbTestModule.f5112m, false));
        }
        return f13574a.asBoolean(false);
    }

    public static boolean m19961b(QeAccessor qeAccessor) {
        if (!f13575b.isSet()) {
            f13575b = TriState.valueOf(qeAccessor.mo596a(ExperimentsForNewsFeedAbTestModule.f5111l, false));
        }
        return f13575b.asBoolean(false);
    }
}

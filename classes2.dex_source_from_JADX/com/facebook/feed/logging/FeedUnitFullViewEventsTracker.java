package com.facebook.feed.logging;

import android.view.View;
import com.facebook.api.feed.data.FeedUnitDataController;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.sponsored.SponsoredUtils;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.Sponsorable;
import com.facebook.widget.listview.ScrollingViewProxy;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: prefetch_cache_efficiency */
public class FeedUnitFullViewEventsTracker {
    public FeedUnitDataController f9243a;
    public FeedUnitImpressionLoggerController f9244b;
    public final Boolean f9245c;
    public final Boolean f9246d;

    @Inject
    public FeedUnitFullViewEventsTracker(FeedUnitDataController feedUnitDataController, FeedUnitImpressionLoggerController feedUnitImpressionLoggerController, Provider<Boolean> provider, Provider<Boolean> provider2) {
        this.f9243a = feedUnitDataController;
        this.f9244b = feedUnitImpressionLoggerController;
        this.f9245c = (Boolean) provider.get();
        this.f9246d = (Boolean) provider2.get();
    }

    public final void m14180a(FeedUnit feedUnit, int i) {
        if (i >= 0 && SponsoredUtils.m21145a(feedUnit) && ((Sponsorable) feedUnit).ab_().f21626y) {
            int i2 = this.f9243a.m14177a(feedUnit).f19509p;
            if (this.f9246d.booleanValue()) {
                int i3 = 1;
                if (((1 << i) & i2) == 0) {
                    i3 = 0;
                }
                if (i3 != 0) {
                    return;
                }
            }
            this.f9244b.m14204b(feedUnit);
            this.f9243a.m14177a(feedUnit).f19509p = i2 | (1 << i);
        }
    }

    public final void m14181b(ScrollingViewProxy scrollingViewProxy, View view, FeedUnit feedUnit) {
        HasMultiRow b = FeedLoggingUtil.m14271b(scrollingViewProxy);
        if (b != null && !this.f9243a.m14177a(feedUnit).f19504k) {
            int q = scrollingViewProxy.mo2402q();
            int r = scrollingViewProxy.mo2403r();
            int c = scrollingViewProxy.mo2371c(view);
            if (scrollingViewProxy.mo2343C()) {
                c = b.s_(c);
                if (c != Integer.MIN_VALUE) {
                    int t_ = b.t_(c);
                    if (t_ >= q && t_ <= r) {
                        if (FeedLoggingUtil.m14272b(scrollingViewProxy.mo2386f(Math.max(t_, q) - q), scrollingViewProxy.mo2381e())) {
                            this.f9243a.m14177a(feedUnit).f19504k = true;
                            if (this.f9245c.booleanValue()) {
                                this.f9244b.m14199a(feedUnit, PartialFullViewType.TOP_SEEN);
                                this.f9243a.m14177a(feedUnit).f19505l = true;
                            }
                        }
                    }
                }
            }
        }
    }
}

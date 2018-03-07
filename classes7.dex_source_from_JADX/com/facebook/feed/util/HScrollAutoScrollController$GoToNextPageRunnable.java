package com.facebook.feed.util;

import com.facebook.feed.hscroll.ExperimentsForFeedHScrollModule;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.Sponsorable;
import com.facebook.graphql.model.SponsoredImpression;
import com.facebook.graphql.model.VisibleItemHelper;
import java.util.List;

/* compiled from: Tab layout should implement TabProgressListenerView if the updateTabProgress attr is true. */
public class HScrollAutoScrollController$GoToNextPageRunnable implements Runnable {
    final /* synthetic */ HScrollAutoScrollController f22333a;
    private ScrollableItemListFeedUnit f22334b;

    public HScrollAutoScrollController$GoToNextPageRunnable(HScrollAutoScrollController hScrollAutoScrollController, ScrollableItemListFeedUnit scrollableItemListFeedUnit) {
        this.f22333a = hScrollAutoScrollController;
        this.f22334b = scrollableItemListFeedUnit;
    }

    public void run() {
        int ac_ = this.f22334b.ac_() + 1;
        List v = this.f22334b.v();
        VisibleItemHelper.a(this.f22334b, v, ac_);
        if (v.size() > ac_) {
            SponsoredImpression ab_ = ((Sponsorable) this.f22334b).ab_();
            if (ab_ != null && this.f22333a.i.a(ExperimentsForFeedHScrollModule.b, false)) {
                ab_.s = true;
            }
        }
    }
}

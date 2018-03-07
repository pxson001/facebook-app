package com.facebook.feed.util;

import com.facebook.feed.rows.core.events.GoToNextPageHScrollEvent;
import com.facebook.graphql.model.FeedUnit;

/* compiled from: Tab layout should implement TabProgressListenerView if the updateTabProgress attr is true. */
class HScrollAutoScrollController$2 implements Runnable {
    final /* synthetic */ FeedUnit f22331a;
    final /* synthetic */ HScrollAutoScrollController f22332b;

    HScrollAutoScrollController$2(HScrollAutoScrollController hScrollAutoScrollController, FeedUnit feedUnit) {
        this.f22332b = hScrollAutoScrollController;
        this.f22331a = feedUnit;
    }

    public void run() {
        this.f22332b.a.a(new GoToNextPageHScrollEvent(this.f22331a.g()));
    }
}

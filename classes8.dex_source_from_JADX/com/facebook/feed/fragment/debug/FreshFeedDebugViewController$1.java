package com.facebook.feed.fragment.debug;

import java.util.TimerTask;

/* compiled from: group_remove_admin */
public class FreshFeedDebugViewController$1 extends TimerTask {
    final /* synthetic */ FreshFeedDebugViewController f11883a;

    public FreshFeedDebugViewController$1(FreshFeedDebugViewController freshFeedDebugViewController) {
        this.f11883a = freshFeedDebugViewController;
    }

    public void run() {
        if (this.f11883a.g != null) {
            FreshFeedDebugViewController.a(this.f11883a, this.f11883a.b.c, this.f11883a.b.b, this.f11883a.b.d, this.f11883a.g.s_(Math.max(this.f11883a.g.b(), Math.min(this.f11883a.f == null ? 0 : this.f11883a.f.r(), this.f11883a.g.d()))), this.f11883a.g.e());
        }
    }
}

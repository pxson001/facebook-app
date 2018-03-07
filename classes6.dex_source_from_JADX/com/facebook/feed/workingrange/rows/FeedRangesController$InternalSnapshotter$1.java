package com.facebook.feed.workingrange.rows;

import com.facebook.feed.workingrange.rows.FeedRangesController.InternalSnapshotter;
import com.facebook.widget.listview.WorkingRangeScrollableImpl;

/* compiled from: members */
class FeedRangesController$InternalSnapshotter$1 implements Runnable {
    final /* synthetic */ WorkingRangeScrollableImpl f10438a;
    final /* synthetic */ InternalSnapshotter f10439b;

    FeedRangesController$InternalSnapshotter$1(InternalSnapshotter internalSnapshotter, WorkingRangeScrollableImpl workingRangeScrollableImpl) {
        this.f10439b = internalSnapshotter;
        this.f10438a = workingRangeScrollableImpl;
    }

    public void run() {
        this.f10439b.a.h.m28825c();
        this.f10439b.a.d.b(this.f10439b.a.h);
        if (FeedRangesExperiments.b(this.f10439b.a.c)) {
            this.f10439b.a.g.m16623a(this.f10438a.m8670a(), this.f10438a.m8671b(), this.f10439b.a.k);
            this.f10439b.a.e.b(this.f10439b.a.g);
        }
    }
}

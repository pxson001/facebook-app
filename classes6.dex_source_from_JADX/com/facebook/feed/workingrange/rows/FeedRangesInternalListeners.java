package com.facebook.feed.workingrange.rows;

import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import com.facebook.feed.rows.adapter.api.MultiRowRecyclerViewAdapter;
import com.facebook.feed.workingrange.rows.FeedRangesController.InternalSnapshotter;
import com.facebook.inject.Assisted;
import com.facebook.ultralight.Inject;
import com.facebook.widget.listview.WorkingRangeScrollableImpl;
import com.facebook.widget.recyclerview.NotifyOnceAdapterObserver;

/* compiled from: member_section */
public class FeedRangesInternalListeners {
    public final WorkingRangeScrollableImpl f10443a;
    public final MultiRowRecyclerViewAdapter f10444b;
    public final boolean f10445c;
    public final InternalSnapshotter f10446d;
    public final InternalScrollListener f10447e = new InternalScrollListener(this);
    public final InternalDataObserver f10448f = new InternalDataObserver(this);
    public final InternalNotifyOnceObserver f10449g = new InternalNotifyOnceObserver(this);

    /* compiled from: member_section */
    class InternalDataObserver extends AdapterDataObserver {
        final /* synthetic */ FeedRangesInternalListeners f10440a;

        public InternalDataObserver(FeedRangesInternalListeners feedRangesInternalListeners) {
            this.f10440a = feedRangesInternalListeners;
        }

        public final void bb_() {
            this.f10440a.f10446d.a(this.f10440a.f10443a);
        }
    }

    /* compiled from: member_section */
    class InternalNotifyOnceObserver implements NotifyOnceAdapterObserver {
        final /* synthetic */ FeedRangesInternalListeners f10441a;

        public InternalNotifyOnceObserver(FeedRangesInternalListeners feedRangesInternalListeners) {
            this.f10441a = feedRangesInternalListeners;
        }

        public final void m16610a() {
            this.f10441a.f10446d.a(this.f10441a.f10443a);
        }
    }

    /* compiled from: member_section */
    public class InternalScrollListener {
        public final /* synthetic */ FeedRangesInternalListeners f10442a;

        public InternalScrollListener(FeedRangesInternalListeners feedRangesInternalListeners) {
            this.f10442a = feedRangesInternalListeners;
        }
    }

    @Inject
    public FeedRangesInternalListeners(@Assisted WorkingRangeScrollableImpl workingRangeScrollableImpl, @Assisted MultiRowRecyclerViewAdapter multiRowRecyclerViewAdapter, @Assisted boolean z, @Assisted InternalSnapshotter internalSnapshotter) {
        this.f10443a = workingRangeScrollableImpl;
        this.f10444b = multiRowRecyclerViewAdapter;
        this.f10445c = z;
        this.f10446d = internalSnapshotter;
    }
}

package com.facebook.widget.listview;

import android.support.v4.util.SimpleArrayMap;
import com.facebook.feed.workingrange.rows.FeedRangesController.InternalSnapshotter;
import com.facebook.feed.workingrange.rows.FeedRangesExperiments;
import com.facebook.feed.workingrange.rows.FeedRangesInternalListeners.InternalScrollListener;
import com.facebook.widget.listview.WorkingRangeScrollable.OnScrollListener;
import com.google.common.base.Preconditions;

/* compiled from: redspace_home_view */
public class WorkingRangeScrollableImpl {
    public final ScrollingViewProxy f6098a;
    public final SimpleArrayMap<OnScrollListener, Boolean> f6099b = new SimpleArrayMap();
    public final ScrollingViewProxy.OnScrollListener f6100c = new InternalOnScrollListener(this);

    /* compiled from: redspace_home_view */
    class InternalOnScrollListener implements ScrollingViewProxy.OnScrollListener {
        final /* synthetic */ WorkingRangeScrollableImpl f6097a;

        public InternalOnScrollListener(WorkingRangeScrollableImpl workingRangeScrollableImpl) {
            this.f6097a = workingRangeScrollableImpl;
        }

        public final void m8668a(ScrollingViewProxy scrollingViewProxy, int i) {
            this.f6097a.f6099b.size();
        }

        public final void m8669a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            int size = this.f6097a.f6099b.size();
            for (int i4 = 0; i4 < size; i4++) {
                InternalScrollListener internalScrollListener = (InternalScrollListener) this.f6097a.f6099b.b(i4);
                WorkingRangeScrollableImpl workingRangeScrollableImpl = this.f6097a;
                InternalSnapshotter internalSnapshotter = internalScrollListener.f10442a.f10446d;
                Preconditions.checkState(internalSnapshotter.a.i, "Listeners must be registered before calling onScroll");
                internalSnapshotter.a.h.m28823a(i, i2);
                internalSnapshotter.a.d.a(internalSnapshotter.a.h);
                if (FeedRangesExperiments.b(internalSnapshotter.a.c)) {
                    internalSnapshotter.a.g.m16625b(i, i2, internalSnapshotter.a.k);
                    internalSnapshotter.a.e.a(internalSnapshotter.a.g);
                }
            }
        }
    }

    public WorkingRangeScrollableImpl(ScrollingViewProxy scrollingViewProxy) {
        this.f6098a = scrollingViewProxy;
    }

    public final int m8670a() {
        return this.f6098a.q();
    }

    public final int m8671b() {
        return this.f6098a.r();
    }
}

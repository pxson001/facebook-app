package com.facebook.feed.workingrange.rows;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.feed.rows.adapter.api.MultiRowRecyclerViewAdapter;
import com.facebook.feed.workingrange.AdapterPrefixCounter;
import com.facebook.feed.workingrange.FeedVisibleRange;
import com.facebook.feed.workingrange.NoPrefixCounter;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ultralight.Inject;
import com.facebook.widget.listview.WorkingRangeScrollableImpl;
import com.facebook.workingrange.core.SnapshotWithVisiblity;
import com.facebook.workingrange.core.WorkingRangeHolder;
import com.facebook.workingrange.scrollingview.ScrollingViewPassthrough;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

/* compiled from: onMarkerStart */
public class FeedRangesController {
    @VisibleForTesting
    final InternalSnapshotter f11121a = new InternalSnapshotter(this);
    @Inject
    public DefaultAndroidThreadUtil f11122b;
    @Inject
    public QeAccessor f11123c;
    public final WorkingRangeHolder<FeedEdge, SnapshotWithVisiblity<FeedEdge>> f11124d = new WorkingRangeHolder(new FeedVisibleRange());
    public final WorkingRangeHolder<FeedEdge, MultiRowStorySnapshot<MultiRowRecyclerViewAdapter>> f11125e = new WorkingRangeHolder(new FeedVisibleRange());
    private final FeedRangesInternalListenersProvider f11126f;
    public MultiRowStorySnapshot<MultiRowRecyclerViewAdapter> f11127g;
    public ScrollingViewPassthrough<FeedEdge> f11128h;
    public boolean f11129i = false;
    public FeedRangesInternalListeners f11130j;
    public AdapterPrefixCounter f11131k = new NoPrefixCounter();

    /* compiled from: onMarkerStart */
    public class InternalSnapshotter {
        public final /* synthetic */ FeedRangesController f11132a;

        public InternalSnapshotter(FeedRangesController feedRangesController) {
            this.f11132a = feedRangesController;
        }

        public final void m16454a(WorkingRangeScrollableImpl workingRangeScrollableImpl) {
            Preconditions.checkState(this.f11132a.f11129i, "Listeners must be registered before calling onChanged");
            this.f11132a.f11122b.m1656b(new 1(this, workingRangeScrollableImpl));
        }
    }

    public static FeedRangesController m16452b(InjectorLike injectorLike) {
        FeedRangesController feedRangesController = new FeedRangesController((FeedRangesInternalListenersProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedRangesInternalListenersProvider.class));
        QeAccessor a = QeInternalImplMethodAutoProvider.m3744a(injectorLike);
        feedRangesController.f11122b = DefaultAndroidThreadUtil.m1646b(injectorLike);
        feedRangesController.f11123c = a;
        return feedRangesController;
    }

    @Inject
    private FeedRangesController(FeedRangesInternalListenersProvider feedRangesInternalListenersProvider) {
        this.f11126f = feedRangesInternalListenersProvider;
    }

    public static FeedRangesController m16451a(InjectorLike injectorLike) {
        return m16452b(injectorLike);
    }

    public final void m16453a(WorkingRangeScrollableImpl workingRangeScrollableImpl, MultiRowRecyclerViewAdapter multiRowRecyclerViewAdapter, boolean z) {
        this.f11127g = new MultiRowStorySnapshot(multiRowRecyclerViewAdapter);
        this.f11128h = new ScrollingViewPassthrough(workingRangeScrollableImpl, new FeedTypeTranslator(this));
        this.f11130j = new FeedRangesInternalListeners(workingRangeScrollableImpl, multiRowRecyclerViewAdapter, z, this.f11121a);
        FeedRangesInternalListeners feedRangesInternalListeners = this.f11130j;
        WorkingRangeScrollableImpl workingRangeScrollableImpl2 = feedRangesInternalListeners.a;
        workingRangeScrollableImpl2.b.put(feedRangesInternalListeners.e, Boolean.TRUE);
        if (feedRangesInternalListeners.c) {
            feedRangesInternalListeners.b.mo2640a(feedRangesInternalListeners.g);
        } else {
            feedRangesInternalListeners.b.mo2223a(feedRangesInternalListeners.f);
        }
        this.f11129i = true;
    }
}

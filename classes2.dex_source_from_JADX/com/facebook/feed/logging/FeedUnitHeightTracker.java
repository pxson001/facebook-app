package com.facebook.feed.logging;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import android.widget.HeaderViewListAdapter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.idleexecutor.IdleExecutor_ForUiThreadMethodAutoProvider;
import com.facebook.common.internal.Preconditions;
import com.facebook.feed.logging.RowHeightMeasuringJob.RowData;
import com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener;
import com.facebook.feed.rows.adapter.api.NewsFeedMultiAdapter;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.ui.NewsFeedRecyclerViewAdapterWrapper;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.HasFeedUnit;
import com.facebook.inject.Assisted;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: method */
public class FeedUnitHeightTracker {
    private final FeedLoggingViewportEventListener f13651a;
    private final NewsFeedRecyclerViewAdapterWrapper f13652b;
    private final FeedUnitHeightTrackerStore f13653c;
    private final FeedUnitHeightTrackerStore f13654d;
    private final RowHeightMeasurer f13655e;
    private final RowHeightMeasuringJob f13656f;
    private int f13657g;
    private FeedUnitHeightTrackerStore f13658h;
    private ScrollingViewProxy f13659i;

    @Inject
    public FeedUnitHeightTracker(@Assisted ScrollingViewProxy scrollingViewProxy, @Assisted NewsFeedMultiAdapter newsFeedMultiAdapter, FeedLoggingViewportEventListener feedLoggingViewportEventListener, Resources resources, RowHeightMeasurerProvider rowHeightMeasurerProvider, RowHeightMeasuringJobProvider rowHeightMeasuringJobProvider, Provider<FeedUnitHeightTrackerStore> provider) {
        this.f13651a = feedLoggingViewportEventListener;
        this.f13652b = newsFeedMultiAdapter;
        this.f13659i = scrollingViewProxy;
        this.f13653c = (FeedUnitHeightTrackerStore) provider.get();
        this.f13654d = (FeedUnitHeightTrackerStore) provider.get();
        this.f13657g = resources.getConfiguration().orientation;
        this.f13655e = new RowHeightMeasurer(scrollingViewProxy, newsFeedMultiAdapter, MultipleRowsStoriesRecycleCallback.m10040a((InjectorLike) rowHeightMeasurerProvider), FbErrorReporterImpl.m2317a((InjectorLike) rowHeightMeasurerProvider));
        m20064b();
        this.f13656f = new RowHeightMeasuringJob(this.f13655e, IdleExecutor_ForUiThreadMethodAutoProvider.m10033b(rowHeightMeasuringJobProvider));
    }

    public final int m20066a(FeedUnit feedUnit, int i) {
        int b = m20063b(i);
        if (feedUnit == null) {
            return 0;
        }
        int d = this.f13652b.mo2511d(b);
        int a = this.f13658h.m20072a(feedUnit, d);
        if (a != -1) {
            return a;
        }
        m20065c(feedUnit, b);
        a = this.f13658h.m20072a(feedUnit, d);
        if (a != -1) {
            return a;
        }
        return 0;
    }

    @VisibleForTesting
    private void m20065c(FeedUnit feedUnit, int i) {
        int d = this.f13652b.mo2511d(i);
        for (int i2 = 0; i2 < d; i2++) {
            this.f13655e.m20081a(feedUnit, d, i + i2, i2);
        }
    }

    public final int m20070b(FeedUnit feedUnit, int i) {
        if (feedUnit == null) {
            return 0;
        }
        int b = m20063b(i);
        b = this.f13658h.m20073a(feedUnit, this.f13652b.mo2515h(b), this.f13652b.mo2511d(b));
        if (b != -1) {
            return b;
        }
        return 0;
    }

    public final void m20069a(@Nullable View view, int i) {
        if (view != null) {
            FeedUnit a = m20062a(i);
            if (a != null && i >= this.f13652b.m20017b() && i <= this.f13652b.m20022d()) {
                int d = this.f13652b.mo2511d(i);
                int h = this.f13652b.mo2515h(i);
                if (!this.f13658h.m20075b(a, h, d)) {
                    this.f13658h.m20074a(a, h, view.getMeasuredHeight(), d);
                }
            }
        }
    }

    public final void m20067a() {
        this.f13656f.m20084d();
        int b = this.f13652b.m20017b();
        int d = this.f13652b.m20022d();
        int i = b;
        while (i <= d) {
            FeedUnit a = m20062a(i);
            if (a == null) {
                b = 1;
            } else {
                b = this.f13652b.mo2511d(i);
                if (this.f13651a.m15115a(a)) {
                    for (int i2 = 0; i2 < b; i2++) {
                        if (!this.f13658h.m20075b(a, i2, b)) {
                            Runnable runnable = this.f13656f;
                            runnable.f13670b.add(new RowData(runnable, a, b, i + i2, i2));
                            if (runnable.f13670b.size() == 1) {
                                ExecutorDetour.a(runnable.f13671c, runnable, 1205056726);
                            }
                        }
                    }
                }
            }
            i = b + i;
        }
    }

    public final void m20068a(Configuration configuration) {
        int i = configuration.orientation;
        if (this.f13657g != i) {
            this.f13657g = i;
            this.f13656f.m20084d();
            m20064b();
            m20067a();
        }
    }

    @Nullable
    private FeedUnit m20062a(int i) {
        try {
            Object item = this.f13652b.getItem(i);
            if (item instanceof HasFeedUnit) {
                return ((HasFeedUnit) item).mo2540c();
            }
            return null;
        } catch (Throwable e) {
            throw new RuntimeException("first stories position: " + this.f13652b.m20017b() + " last stories position: " + this.f13652b.m20022d() + " " + e.getMessage(), e);
        }
    }

    private void m20064b() {
        this.f13658h = this.f13657g == 2 ? this.f13653c : this.f13654d;
        this.f13655e.f13668g = this.f13658h;
    }

    private int m20063b(int i) {
        int u = this.f13659i.mo2400o() instanceof HeaderViewListAdapter ? i - this.f13659i.mo2406u() : i;
        Preconditions.a(this.f13652b.getItem(u) == this.f13659i.mo2389g(i));
        return u;
    }
}

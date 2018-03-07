package com.facebook.timeline.delegate;

import android.database.DataSetObserver;
import android.view.View;
import com.facebook.common.viewport.ViewportEventListener;
import com.facebook.common.viewport.ViewportMonitor;
import com.facebook.debug.fps.FrameRateLogger;
import com.facebook.debug.fps.FrameRateLoggerProvider;
import com.facebook.device.ScreenUtil;
import com.facebook.feed.logging.FeedLoggingUtil;
import com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener;
import com.facebook.inject.Assisted;
import com.facebook.profile.api.RelationshipType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.redspace.abtest.ExperimentsForRedSpaceExperimentsModule;
import com.facebook.redspace.badge.RedSpaceOptimisticBadgeViewportEventListener;
import com.facebook.timeline.data.TimelineHeaderRenderState;
import com.facebook.timeline.header.TimelineHeaderDataLogger;
import com.facebook.timeline.header.TimelineHeaderFullHeaderAdapter;
import com.facebook.timeline.header.TimelineHeaderTopAdapter.Part;
import com.facebook.timeline.header.TimelineIntroCardAdapter;
import com.facebook.timeline.header.TimelineIntroCardView;
import com.facebook.timeline.header.TimelineLoggingViewportListener;
import com.facebook.timeline.header.UserTimelineHeaderView;
import com.facebook.timeline.header.profilevideo.TimelineProfileVideoViewportListener;
import com.facebook.timeline.header.ui.CaspianTimelineStandardHeader;
import com.facebook.timeline.listview.TimelineAdapter;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;
import com.facebook.timeline.logging.TimelinePerformanceLogger;
import com.facebook.timeline.prefs.TimelineConfig;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.google.common.base.Optional;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableMap;
import javax.inject.Provider;

/* compiled from: gpc */
public class TimelineFragmentScrollDelegate implements OnScrollListener {
    private static final String f10749d = TimelineFragmentScrollDelegate.class.getSimpleName();
    @Inject
    public volatile Provider<FeedLoggingViewportEventListener> f10750a = UltralightRuntime.a();
    @Inject
    volatile Provider<ScreenUtil> f10751b = UltralightRuntime.a();
    @Inject
    volatile Provider<TimelineAnalyticsLogger> f10752c = UltralightRuntime.a();
    private final TimelineAdapter f10753e;
    private final TimelinePerformanceLogger f10754f;
    public final Supplier<FrameRateLogger> f10755g;
    public final Supplier<ViewportMonitor> f10756h;
    public final TimelineHeaderDataLogger f10757i;
    private final long f10758j;
    private final TimelineConfig f10759k;
    private final TimelineHeaderRenderState f10760l;
    private int f10761m = 0;
    public boolean f10762n = false;
    private boolean f10763o = true;
    private RelationshipType f10764p = RelationshipType.UNKNOWN_RELATIONSHIP;

    final void m10785a(Provider<FeedLoggingViewportEventListener> provider, Provider<ScreenUtil> provider2, Provider<TimelineAnalyticsLogger> provider3) {
        this.f10750a = provider;
        this.f10751b = provider2;
        this.f10752c = provider3;
    }

    @Inject
    public TimelineFragmentScrollDelegate(@Assisted long j, @Assisted final ScrollingViewProxy scrollingViewProxy, @Assisted TimelineAdapter timelineAdapter, @Assisted TimelineConfig timelineConfig, @Assisted TimelinePerformanceLogger timelinePerformanceLogger, @Assisted Supplier<TimelineLoggingViewportListener> supplier, @Assisted TimelineHeaderDataLogger timelineHeaderDataLogger, @Assisted String str, TimelineHeaderRenderState timelineHeaderRenderState, Provider<FeedLoggingViewportEventListener> provider, Provider<TimelineProfileVideoViewportListener> provider2, Provider<RedSpaceOptimisticBadgeViewportEventListener> provider3, FrameRateLoggerProvider frameRateLoggerProvider, Provider<ViewportMonitor> provider4, QeAccessor qeAccessor) {
        this.f10758j = j;
        this.f10753e = timelineAdapter;
        this.f10759k = timelineConfig;
        this.f10754f = timelinePerformanceLogger;
        this.f10757i = timelineHeaderDataLogger;
        this.f10760l = timelineHeaderRenderState;
        final Provider<ViewportMonitor> provider5 = provider4;
        final Provider<FeedLoggingViewportEventListener> provider6 = provider;
        final Supplier<TimelineLoggingViewportListener> supplier2 = supplier;
        final Provider<TimelineProfileVideoViewportListener> provider7 = provider2;
        final QeAccessor qeAccessor2 = qeAccessor;
        final Provider<RedSpaceOptimisticBadgeViewportEventListener> provider8 = provider3;
        this.f10756h = Suppliers.memoize(new Supplier<ViewportMonitor>(this) {
            final /* synthetic */ TimelineFragmentScrollDelegate f10739g;

            public Object get() {
                ViewportMonitor viewportMonitor = (ViewportMonitor) provider5.get();
                viewportMonitor.a((ViewportEventListener) provider6.get());
                viewportMonitor.a((ViewportEventListener) supplier2.get());
                viewportMonitor.a((ViewportEventListener) provider7.get());
                if (qeAccessor2.a(ExperimentsForRedSpaceExperimentsModule.h, false) && qeAccessor2.a(ExperimentsForRedSpaceExperimentsModule.c, true)) {
                    viewportMonitor.a((ViewportEventListener) provider8.get());
                }
                return viewportMonitor;
            }
        });
        final FrameRateLoggerProvider frameRateLoggerProvider2 = frameRateLoggerProvider;
        final String str2 = str;
        this.f10755g = Suppliers.memoize(new Supplier<FrameRateLogger>(this) {
            final /* synthetic */ TimelineFragmentScrollDelegate f10742c;

            public Object get() {
                return frameRateLoggerProvider2.a(Boolean.valueOf(false), "timeline_scroll_animation", Optional.of(str2));
            }
        });
        this.f10753e.registerDataSetObserver(new DataSetObserver(this) {
            final /* synthetic */ TimelineFragmentScrollDelegate f10744b;

            public void onChanged() {
                ((ViewportMonitor) this.f10744b.f10756h.get()).a(scrollingViewProxy);
            }
        });
        this.f10762n = this.f10759k.a();
    }

    public final void m10783a(ScrollingViewProxy scrollingViewProxy, int i) {
        if (i == 0) {
            ((ViewportMonitor) this.f10756h.get()).b(scrollingViewProxy);
        }
        if (this.f10761m == 0) {
            if (this.f10762n) {
                ((FrameRateLogger) this.f10755g.get()).a();
            }
        } else if (i == 0 && this.f10762n) {
            ((FrameRateLogger) this.f10755g.get()).b();
        }
        if (this.f10763o && i == 1) {
            ((TimelineAnalyticsLogger) this.f10752c.get()).c(this.f10758j, "0", this.f10764p);
            this.f10763o = false;
        }
        this.f10761m = i;
    }

    public final void m10784a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
        ((ViewportMonitor) this.f10756h.get()).a(scrollingViewProxy, i, i2, i3);
        if (i2 > 0 && i != -1) {
            double d = ((double) (-scrollingViewProxy.f(0).getTop())) / ((double) ((ScreenUtil) this.f10751b.get()).d());
            int i4 = d > 0.2d ? 1 : 0;
            int i5;
            if (d <= 0.0d || i + i2 != i3) {
                i5 = 0;
            } else {
                i5 = 1;
            }
            if (!(i4 == 0 && r0 == 0)) {
                this.f10754f.u();
            }
        }
        m10779a(i, i2, scrollingViewProxy);
    }

    public final void m10781a() {
        FeedLoggingViewportEventListener feedLoggingViewportEventListener = (FeedLoggingViewportEventListener) this.f10750a.get();
        feedLoggingViewportEventListener.a("native_timeline");
        m10780a(feedLoggingViewportEventListener);
    }

    private void m10779a(int i, int i2, ScrollingViewProxy scrollingViewProxy) {
        int min = Math.min(i + i2, scrollingViewProxy.s());
        while (i < min) {
            Enum g = scrollingViewProxy.g(i);
            View c = scrollingViewProxy.c(i);
            if (g == Part.COVER_PHOTO && (c instanceof CaspianTimelineStandardHeader)) {
                boolean z;
                int e = scrollingViewProxy.e();
                int a = FeedLoggingUtil.a(c, e);
                int i3 = e / 2;
                if (Math.abs(c.getTop()) < e / 20 || a >= i3) {
                    z = true;
                } else {
                    z = false;
                }
                this.f10757i.m11442a(z);
            } else if (g == TimelineHeaderFullHeaderAdapter.Part.FULL_HEADER && (c instanceof UserTimelineHeaderView)) {
                final UserTimelineHeaderView userTimelineHeaderView = (UserTimelineHeaderView) c;
                userTimelineHeaderView.post(new Runnable(this) {
                    final /* synthetic */ TimelineFragmentScrollDelegate f10746b;

                    public void run() {
                        this.f10746b.f10757i.m11441a(userTimelineHeaderView);
                    }
                });
            } else if (g == TimelineIntroCardAdapter.Part.INTRO_CARD && (c instanceof TimelineIntroCardView)) {
                final TimelineIntroCardView timelineIntroCardView = (TimelineIntroCardView) c;
                timelineIntroCardView.post(new Runnable(this) {
                    final /* synthetic */ TimelineFragmentScrollDelegate f10748b;

                    public void run() {
                        this.f10748b.f10757i.m11440a(timelineIntroCardView);
                    }
                });
            }
            i++;
        }
    }

    public final void m10782a(RelationshipType relationshipType) {
        this.f10764p = relationshipType;
        m10780a((FeedLoggingViewportEventListener) this.f10750a.get());
    }

    private void m10780a(FeedLoggingViewportEventListener feedLoggingViewportEventListener) {
        Object obj;
        if (this.f10760l.c) {
            obj = "1";
        } else {
            obj = "0";
        }
        feedLoggingViewportEventListener.a(ImmutableMap.of("vpv_profile_id", Long.toString(this.f10758j), "profile_relationship_type", Integer.toString(this.f10764p.getValue()), "is_profile_cached", obj));
    }
}

package com.facebook.feed.logging;

import android.os.Handler;
import android.support.v4.util.SimpleArrayMap;
import android.view.View;
import com.facebook.common.executors.ForNonUiThread;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.viewport.qe.ExperimentsForViewportTestModule;
import com.facebook.feed.logging.FeedUnitFullViewEventsTracker.PartialFullViewType;
import com.facebook.feed.logging.viewport.FeedLoggingHandler;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.sponsored.SponsoredUtils;
import com.facebook.feed.util.unit.FeedUnitHelper;
import com.facebook.graphql.model.BaseImpression;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLHoldoutAdFeedUnit;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnit;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.Sponsorable;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: prefetch_source */
public class ViewBasedLoggingHandler implements FeedLoggingHandler {
    private static volatile ViewBasedLoggingHandler f9215t;
    private final Clock f9216a;
    private final Lazy<FeedUnitImpressionLoggerController> f9217b;
    private final ViewportLoggingHelper f9218c;
    private final Provider<Boolean> f9219d;
    private final Provider<Boolean> f9220e;
    private final Provider<Boolean> f9221f;
    private final Provider<Boolean> f9222g;
    private final Provider<Boolean> f9223h;
    private final Provider<Boolean> f9224i;
    private boolean f9225j;
    private boolean f9226k;
    private boolean f9227l;
    private boolean f9228m;
    private boolean f9229n;
    private boolean f9230o;
    @ForNonUiThread
    private final Handler f9231p;
    public final Map<String, Runnable> f9232q = new HashMap();
    private final FeedUnitFullViewEventsTracker f9233r;
    private final QeAccessor f9234s;

    public static com.facebook.feed.logging.ViewBasedLoggingHandler m14137a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f9215t;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.logging.ViewBasedLoggingHandler.class;
        monitor-enter(r1);
        r0 = f9215t;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m14143b(r0);	 Catch:{ all -> 0x0035 }
        f9215t = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9215t;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.logging.ViewBasedLoggingHandler.a(com.facebook.inject.InjectorLike):com.facebook.feed.logging.ViewBasedLoggingHandler");
    }

    private static ViewBasedLoggingHandler m14143b(InjectorLike injectorLike) {
        return new ViewBasedLoggingHandler(SystemClockMethodAutoProvider.m1498a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1429), ViewportLoggingHelper.m14168a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3997), IdBasedProvider.m1811a(injectorLike, 4001), IdBasedProvider.m1811a(injectorLike, 3999), IdBasedProvider.m1811a(injectorLike, 4000), IdBasedProvider.m1811a(injectorLike, 4002), IdBasedProvider.m1811a(injectorLike, 3996), Handler_ForNonUiThreadMethodAutoProvider.m5523b(injectorLike), IdBasedProvider.m1811a(injectorLike, 1427), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public ViewBasedLoggingHandler(Clock clock, Lazy<FeedUnitImpressionLoggerController> lazy, ViewportLoggingHelper viewportLoggingHelper, Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, Provider<Boolean> provider5, Provider<Boolean> provider6, Handler handler, Provider<FeedUnitFullViewEventsTracker> provider7, QeAccessor qeAccessor) {
        this.f9216a = clock;
        this.f9217b = lazy;
        this.f9218c = viewportLoggingHelper;
        this.f9219d = provider;
        this.f9220e = provider2;
        this.f9221f = provider3;
        this.f9222g = provider4;
        this.f9223h = provider5;
        this.f9224i = provider6;
        this.f9231p = handler;
        this.f9233r = (FeedUnitFullViewEventsTracker) provider7.get();
        m14145a();
        this.f9234s = qeAccessor;
    }

    public final void m14145a() {
        this.f9226k = ((Boolean) this.f9220e.get()).booleanValue();
        boolean z = ((Boolean) this.f9219d.get()).booleanValue() || !this.f9226k;
        this.f9225j = z;
        this.f9227l = ((Boolean) this.f9221f.get()).booleanValue();
        this.f9228m = ((Boolean) this.f9222g.get()).booleanValue();
        this.f9229n = ((Boolean) this.f9223h.get()).booleanValue();
        this.f9230o = ((Boolean) this.f9224i.get()).booleanValue();
    }

    public final boolean mo1919a(Object obj) {
        return (this.f9226k || this.f9229n) && FeedLoggingUtil.m14269a(obj);
    }

    public final void mo1921b(Object obj) {
        m14139a(SponsoredUtils.m21144a(obj));
    }

    public final void mo1922c(Object obj) {
        m14144b(SponsoredUtils.m21144a(obj));
    }

    public final boolean mo1923d(Object obj) {
        return FeedLoggingUtil.m14269a(obj);
    }

    private boolean m14142a(FeedUnit feedUnit) {
        ViewportLoggingHelper viewportLoggingHelper = this.f9218c;
        Preconditions.checkNotNull(feedUnit);
        long j = viewportLoggingHelper.f9236a.m14177a(feedUnit).f19496c;
        long a = this.f9216a.mo211a();
        if (a - j < 100) {
            return true;
        }
        viewportLoggingHelper = this.f9218c;
        Preconditions.checkNotNull(feedUnit);
        viewportLoggingHelper.f9236a.m14177a(feedUnit).f19496c = a;
        return false;
    }

    private void m14140a(ScrollingViewProxy scrollingViewProxy, FeedUnit feedUnit, View view) {
        if (this.f9233r != null || feedUnit != null) {
            FeedUnitFullViewEventsTracker feedUnitFullViewEventsTracker = this.f9233r;
            HasMultiRow b = FeedLoggingUtil.m14271b(scrollingViewProxy);
            if (!(b == null || feedUnitFullViewEventsTracker.f9243a.m14177a(feedUnit).f19506m)) {
                int q = scrollingViewProxy.mo2402q();
                int r = scrollingViewProxy.mo2403r();
                int c = scrollingViewProxy.mo2371c(view);
                if (scrollingViewProxy.mo2343C()) {
                    c = b.s_(c);
                    if (c != Integer.MIN_VALUE) {
                        int g = b.mo2514g(c);
                        if (g >= q && g <= r) {
                            if (FeedLoggingUtil.m14272b(scrollingViewProxy.mo2386f(Math.min(g, r) - q), scrollingViewProxy.mo2381e())) {
                                feedUnitFullViewEventsTracker.f9243a.m14177a(feedUnit).f19506m = true;
                                if (feedUnitFullViewEventsTracker.f9245c.booleanValue()) {
                                    feedUnitFullViewEventsTracker.f9244b.m14199a(feedUnit, PartialFullViewType.BOTTOM_SEEN);
                                    feedUnitFullViewEventsTracker.f9243a.m14177a(feedUnit).f19507n = true;
                                }
                            }
                        }
                    }
                }
            }
            this.f9233r.m14181b(scrollingViewProxy, view, feedUnit);
            feedUnitFullViewEventsTracker = this.f9233r;
            if (((Sponsorable) feedUnit).ab_().f21626y) {
                boolean z;
                if (feedUnitFullViewEventsTracker.f9243a.m14177a(feedUnit).f19506m && feedUnitFullViewEventsTracker.f9243a.m14177a(feedUnit).f19504k) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    return;
                }
                if (feedUnit instanceof GraphQLStorySet) {
                    feedUnitFullViewEventsTracker.m14180a(feedUnit, ((GraphQLStorySet) feedUnit).ac_());
                } else if (feedUnit instanceof GraphQLPYMLWithLargeImageFeedUnit) {
                    feedUnitFullViewEventsTracker.m14180a(feedUnit, ((GraphQLPYMLWithLargeImageFeedUnit) feedUnit).ac_());
                } else if (!feedUnitFullViewEventsTracker.f9246d.booleanValue() || !feedUnitFullViewEventsTracker.f9243a.m14177a(feedUnit).f19508o) {
                    feedUnitFullViewEventsTracker.f9244b.m14204b(feedUnit);
                    feedUnitFullViewEventsTracker.f9243a.m14177a(feedUnit).f19508o = true;
                }
            }
        }
    }

    public final void mo1916a(ScrollingViewProxy scrollingViewProxy, Object obj, int i) {
        FeedUnit a = FeedUnitHelper.m21141a(obj);
        View f = scrollingViewProxy.mo2386f(i);
        if (this.f9230o) {
            m14140a(scrollingViewProxy, a, f);
        }
        if ((this.f9229n || this.f9226k) && !m14142a(a)) {
            FeedUnitHeightTracker a2 = FeedLoggingUtil.m14267a(scrollingViewProxy);
            int top = f.getTop();
            if (a2 != null && i == 0) {
                top -= a2.m20070b(a, scrollingViewProxy.mo2402q() + i);
            }
            int i2 = top;
            int a3 = m14136a(scrollingViewProxy, a, scrollingViewProxy.mo2381e(), f, i, a2);
            if (a3 > 0) {
                a3 = 100 - ((((Math.min(i2, 0) * -1) + Math.max((i2 + a3) - scrollingViewProxy.mo2381e(), 0)) * 100) / a3);
                if (a3 >= 0) {
                    m14141a(obj, a3);
                }
            }
        }
    }

    public final void mo1913a(SimpleArrayMap<Object, Object> simpleArrayMap) {
    }

    public final void mo1918a(String str) {
    }

    public final void mo1917a(ImmutableMap<String, String> immutableMap) {
    }

    public final void mo1914a(ScrollableItemListFeedUnit scrollableItemListFeedUnit, int i) {
        Sponsorable a = SponsoredUtils.m21144a((Object) scrollableItemListFeedUnit);
        m14141a((Object) scrollableItemListFeedUnit, 0);
        if (this.f9230o) {
            this.f9233r.m14180a(scrollableItemListFeedUnit, i - 1);
        }
        m14144b(a);
    }

    public final void mo1920b(ScrollableItemListFeedUnit scrollableItemListFeedUnit, int i) {
        m14139a(SponsoredUtils.m21144a((Object) scrollableItemListFeedUnit));
        if (this.f9230o) {
            this.f9233r.m14180a(scrollableItemListFeedUnit, i);
        }
        m14141a((Object) scrollableItemListFeedUnit, 100);
    }

    @VisibleForTesting
    private void m14141a(Object obj, int i) {
        Sponsorable a = SponsoredUtils.m21144a(obj);
        if (a != null) {
            BaseImpression a2 = SponsoredUtils.m21143a(a);
            if (a2 != null && a2.mo3121k()) {
                if (this.f9228m && a2.m27478a(i)) {
                    ((FeedUnitImpressionLoggerController) this.f9217b.get()).m14202a(a, a2.m27480b(this.f9216a.mo211a()));
                }
                if (this.f9226k && a2.m27479a(i, this.f9216a.mo211a(), false)) {
                    ((FeedUnitImpressionLoggerController) this.f9217b.get()).m14206c(a);
                }
                if (this.f9229n) {
                    BaseImpression ab_ = a.ab_();
                    ab_.f19786i += (this.f9216a.mo211a() + ":" + i + ";");
                }
            }
        }
    }

    private void m14139a(Sponsorable sponsorable) {
        if (sponsorable != null) {
            BaseImpression a = SponsoredUtils.m21143a(sponsorable);
            if (a != null && a.mo3121k()) {
                long a2 = this.f9216a.mo211a();
                if (!a.f19782e) {
                    a.f19781d = false;
                }
                a.f19782e = false;
                a.f19785h = a2;
                a.f19786i = "";
                if (this.f9225j) {
                    if (!this.f9234s.mo596a(ExperimentsForViewportTestModule.a, false)) {
                        m14138a(this, sponsorable, a);
                    } else if (((Runnable) this.f9232q.get(sponsorable.mo2507g())) == null) {
                        DelayedImpressionLogger delayedImpressionLogger = new DelayedImpressionLogger(this, sponsorable, a);
                        HandlerDetour.b(this.f9231p, delayedImpressionLogger, this.f9234s.mo575a(ExperimentsForViewportTestModule.b, 0), -378437325);
                        this.f9232q.put(sponsorable.mo2507g(), delayedImpressionLogger);
                    }
                }
                if (this.f9226k) {
                    a.m27479a(0, this.f9216a.mo211a(), false);
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m14138a(com.facebook.feed.logging.ViewBasedLoggingHandler r12, com.facebook.graphql.model.Sponsorable r13, com.facebook.graphql.model.BaseImpression r14) {
        /*
        r0 = com.facebook.graphql.model.ImpressionUtil.m29326c(r13);
        if (r0 != 0) goto L_0x0027;
    L_0x0006:
        r0 = 1;
    L_0x0007:
        r1 = r12.f9216a;
        r2 = r1.mo211a();
        r10 = 0;
        r4 = 0;
        r5 = r14.mo3121k();
        if (r5 != 0) goto L_0x0035;
    L_0x0016:
        r1 = r4;
        if (r1 == 0) goto L_0x0026;
    L_0x0019:
        if (r0 == 0) goto L_0x0029;
    L_0x001b:
        r0 = r12.f9217b;
        r0 = r0.get();
        r0 = (com.facebook.feed.logging.FeedUnitImpressionLoggerController) r0;
        r0.m14201a(r13);
    L_0x0026:
        return;
    L_0x0027:
        r0 = 0;
        goto L_0x0007;
    L_0x0029:
        r0 = r12.f9217b;
        r0 = r0.get();
        r0 = (com.facebook.feed.logging.FeedUnitImpressionLoggerController) r0;
        r0.m14205b(r13);
        goto L_0x0026;
    L_0x0035:
        if (r0 == 0) goto L_0x007d;
    L_0x0037:
        r5 = r14.mo3118a();
        if (r5 == 0) goto L_0x0016;
    L_0x003d:
        r5 = r14.f19778a;
        r6 = com.facebook.graphql.model.Impression$LoggingStatus.PENDING;
        if (r5 == r6) goto L_0x0016;
    L_0x0043:
        r5 = r14.f19778a;
        r6 = com.facebook.graphql.model.Impression$LoggingStatus.LOGGING;
        if (r5 == r6) goto L_0x0016;
    L_0x0049:
        r5 = r14.f19778a;
        r6 = com.facebook.graphql.model.Impression$LoggingStatus.LOGGED;
        if (r5 == r6) goto L_0x0016;
    L_0x004f:
        r5 = r14.f19789l;
        r6 = r14.mo3170g();
        if (r5 >= r6) goto L_0x0016;
    L_0x0057:
        r6 = r14.f19790m;
        r5 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r5 <= 0) goto L_0x0069;
    L_0x005d:
        r6 = r14.f19790m;
        r6 = r2 - r6;
        r8 = r14.mo3169f();
        r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r5 < 0) goto L_0x0016;
    L_0x0069:
        r6 = r14.f19783f;
        r5 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r5 <= 0) goto L_0x007b;
    L_0x006f:
        r6 = r14.f19783f;
        r6 = r2 - r6;
        r8 = r14.mo3168d();
        r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r5 < 0) goto L_0x0016;
    L_0x007b:
        r4 = 1;
        goto L_0x0016;
    L_0x007d:
        r5 = r14.mo3119b();
        if (r5 == 0) goto L_0x0016;
    L_0x0083:
        r5 = r14.f19778a;
        r6 = com.facebook.graphql.model.Impression$LoggingStatus.PENDING;
        if (r5 == r6) goto L_0x0016;
    L_0x0089:
        r5 = r14.f19778a;
        r6 = com.facebook.graphql.model.Impression$LoggingStatus.LOGGING;
        if (r5 == r6) goto L_0x0016;
    L_0x008f:
        r5 = r14.f19779b;
        r6 = com.facebook.graphql.model.Impression$LoggingStatus.PENDING;
        if (r5 == r6) goto L_0x0016;
    L_0x0095:
        r5 = r14.f19779b;
        r6 = com.facebook.graphql.model.Impression$LoggingStatus.LOGGING;
        if (r5 != r6) goto L_0x004f;
    L_0x009b:
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.logging.ViewBasedLoggingHandler.a(com.facebook.feed.logging.ViewBasedLoggingHandler, com.facebook.graphql.model.Sponsorable, com.facebook.graphql.model.BaseImpression):void");
    }

    private void m14144b(Sponsorable sponsorable) {
        if (sponsorable != null) {
            BaseImpression a = SponsoredUtils.m21143a(sponsorable);
            if (a != null && a.mo3121k()) {
                if (this.f9234s.mo596a(ExperimentsForViewportTestModule.a, false)) {
                    Runnable runnable = (Runnable) this.f9232q.remove(sponsorable.mo2507g());
                    if (runnable != null) {
                        HandlerDetour.a(this.f9231p, runnable);
                    }
                }
                if (this.f9229n) {
                    ((FeedUnitImpressionLoggerController) this.f9217b.get()).m14208e(sponsorable);
                }
                if (this.f9228m && a.m27478a(0)) {
                    ((FeedUnitImpressionLoggerController) this.f9217b.get()).m14202a(sponsorable, a.m27480b(this.f9216a.mo211a()));
                }
                if (this.f9226k && a.m27479a(0, this.f9216a.mo211a(), true)) {
                    ((FeedUnitImpressionLoggerController) this.f9217b.get()).m14206c(sponsorable);
                }
                if (this.f9227l) {
                    Object obj = null;
                    if (a.mo3121k() && a.mo3120c() && !a.f19781d) {
                        obj = 1;
                    }
                    if (obj != null) {
                        ((FeedUnitImpressionLoggerController) this.f9217b.get()).m14207d(sponsorable);
                    }
                }
            }
        }
    }

    public final void mo1915a(ScrollingViewProxy scrollingViewProxy, int i, int i2) {
        FeedUnitHeightTracker a = FeedLoggingUtil.m14267a(scrollingViewProxy);
        if (a != null) {
            a.m20069a(scrollingViewProxy.mo2386f(i2), i + i2);
        }
    }

    private static int m14136a(ScrollingViewProxy scrollingViewProxy, FeedUnit feedUnit, int i, View view, int i2, @Nullable FeedUnitHeightTracker feedUnitHeightTracker) {
        if (feedUnit instanceof GraphQLHoldoutAdFeedUnit) {
            return i;
        }
        if (feedUnitHeightTracker != null) {
            return feedUnitHeightTracker.m20066a(feedUnit, scrollingViewProxy.mo2402q() + i2);
        }
        return view.getHeight();
    }
}

package com.facebook.widget.listview.throttling;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.fps.FrameCounter;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.widget.listview.ScrollListenerWithThrottlingSupport;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: poor */
public class ThrottledOnScrollListenerFactory {
    public static final String f9484a = ThrottledOnScrollListenerFactory.class.getSimpleName();
    private static volatile ThrottledOnScrollListenerFactory f9485f;
    private final MonotonicClock f9486b;
    public final AbstractFbErrorReporter f9487c;
    public final FrameCounter f9488d;
    public boolean f9489e;

    public static com.facebook.widget.listview.throttling.ThrottledOnScrollListenerFactory m14478a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9485f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.widget.listview.throttling.ThrottledOnScrollListenerFactory.class;
        monitor-enter(r1);
        r0 = f9485f;	 Catch:{ all -> 0x003a }
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
        r0 = m14479b(r0);	 Catch:{ all -> 0x0035 }
        f9485f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9485f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.widget.listview.throttling.ThrottledOnScrollListenerFactory.a(com.facebook.inject.InjectorLike):com.facebook.widget.listview.throttling.ThrottledOnScrollListenerFactory");
    }

    private static ThrottledOnScrollListenerFactory m14479b(InjectorLike injectorLike) {
        return new ThrottledOnScrollListenerFactory(AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), FrameCounter.m14482a(injectorLike));
    }

    @Inject
    public ThrottledOnScrollListenerFactory(MonotonicClock monotonicClock, AbstractFbErrorReporter abstractFbErrorReporter, FrameCounter frameCounter) {
        this.f9486b = monotonicClock;
        this.f9487c = abstractFbErrorReporter;
        this.f9488d = frameCounter;
    }

    public final C04251 m14481b(final OnScrollListener onScrollListener) {
        final ThrottlingPolicy c = m14480c(onScrollListener);
        final boolean z = c instanceof FrameBasedThrottler;
        return new OnScrollListener(this) {
            public final /* synthetic */ ThrottledOnScrollListenerFactory f10078d;

            public final void mo1262a(ScrollingViewProxy scrollingViewProxy, int i) {
                if (z) {
                    ThrottledOnScrollListenerFactory throttledOnScrollListenerFactory = this.f10078d;
                    FrameCounter frameCounter;
                    switch (i) {
                        case 0:
                            frameCounter = throttledOnScrollListenerFactory.f9488d;
                            if (frameCounter.f9494d) {
                                frameCounter.f9491a.mo1638b(frameCounter.f9492b);
                            }
                            frameCounter.f9494d = false;
                            break;
                        case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                            frameCounter = throttledOnScrollListenerFactory.f9488d;
                            if (!frameCounter.f9494d) {
                                frameCounter.f9491a.mo1636a(frameCounter.f9492b);
                            }
                            frameCounter.f9494d = true;
                            break;
                    }
                }
                if (i == 0) {
                    int q = scrollingViewProxy.mo2402q();
                    int r = (scrollingViewProxy.mo2403r() - q) + 1;
                    int s = scrollingViewProxy.mo2404s();
                    if (q != -1 || this.f10078d.f9489e) {
                        onScrollListener.mo1263a(scrollingViewProxy, q, r, s);
                    } else {
                        this.f10078d.f9487c.m2340a(ThrottledOnScrollListenerFactory.f9484a, "t9619287: callFinalOnScroll with NO_POSITION firstItemIndex");
                        this.f10078d.f9489e = true;
                    }
                }
                onScrollListener.mo1262a(scrollingViewProxy, i);
            }

            public final void mo1263a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
                if (!c.mo1975a()) {
                    onScrollListener.mo1263a(scrollingViewProxy, i, i2, i3);
                }
            }
        };
    }

    private ThrottlingPolicy m14480c(OnScrollListener onScrollListener) {
        if (!(onScrollListener instanceof ScrollListenerWithThrottlingSupport)) {
            return NoOpThrottlingPolicy.f10071a;
        }
        int a = ((ScrollListenerWithThrottlingSupport) onScrollListener).mo1974a();
        if (a == 0) {
            return NoOpThrottlingPolicy.f10071a;
        }
        if (a == -1) {
            return new TimeBasedThrottler(100, this.f9486b);
        }
        return new FrameBasedThrottler(a, this.f9488d);
    }
}

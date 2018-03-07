package com.facebook.ufiperf.perf;

import com.facebook.inject.InjectorLike;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QPLVisitorForNetworkInfo;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.google.common.collect.ImmutableBiMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: is_transient */
public class UfiPerfUtil {
    private static volatile UfiPerfUtil f18821g;
    public final PerformanceLogger f18822a;
    public final QuickPerformanceLogger f18823b;
    public boolean f18824c;
    public boolean f18825d;
    public boolean f18826e = false;
    public boolean f18827f = false;

    public static com.facebook.ufiperf.perf.UfiPerfUtil m26467a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18821g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ufiperf.perf.UfiPerfUtil.class;
        monitor-enter(r1);
        r0 = f18821g;	 Catch:{ all -> 0x003a }
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
        r0 = m26468b(r0);	 Catch:{ all -> 0x0035 }
        f18821g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18821g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ufiperf.perf.UfiPerfUtil.a(com.facebook.inject.InjectorLike):com.facebook.ufiperf.perf.UfiPerfUtil");
    }

    private static UfiPerfUtil m26468b(InjectorLike injectorLike) {
        return new UfiPerfUtil(DelegatingPerformanceLogger.m2803a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike), QPLVisitorForNetworkInfo.m3222a(injectorLike));
    }

    @Inject
    public UfiPerfUtil(PerformanceLogger performanceLogger, QuickPerformanceLogger quickPerformanceLogger, QPLVisitorForNetworkInfo qPLVisitorForNetworkInfo) {
        this.f18822a = performanceLogger;
        this.f18823b = quickPerformanceLogger;
        qPLVisitorForNetworkInfo.m3225a(3735560);
        qPLVisitorForNetworkInfo.m3225a(3735583);
        qPLVisitorForNetworkInfo.m3225a(3735577);
    }

    public final void m26477a() {
        this.f18822a.mo392d(3735563, "Photos_FlyoutLoadCached");
        this.f18822a.mo392d(3735564, "Photos_FlyoutLoadNetwork");
    }

    public final void m26479b() {
        this.f18822a.mo392d(3735567, "Flyout_NetworkTimeFeedbackId");
        this.f18822a.mo392d(3735568, "Flyout_NetworkTimeExecutorFeedbackId");
    }

    public final void m26480c() {
        this.f18822a.mo374a(3735567, "Flyout_NetworkTimeFeedbackId");
    }

    public final void m26481e() {
        this.f18822a.mo389c(3735553, "NNF_FlyoutLoadDBCache");
        this.f18822a.mo389c(3735563, "Photos_FlyoutLoadCached");
        this.f18822a.mo389c(3735565, "Dash_FlyoutLoadCached");
        this.f18822a.mo389c(3735559, "NNF_FlyoutLoadCompleteFlow");
        this.f18824c = true;
        this.f18822a.mo389c(3735579, "NNF_FlyoutLoadResumeToAnimationWaitTime");
        this.f18822a.mo389c(3735580, "NNF_FlyoutLoadAnimationToDataFetchTime");
        this.f18822a.mo389c(3735575, "NNF_FlyoutLoadAnimationWaitTime");
        m26465V();
    }

    public final void m26482f() {
        this.f18822a.mo374a(3735553, "NNF_FlyoutLoadDBCache");
        this.f18822a.mo374a(3735554, "NNF_FlyoutLoadDBCacheAndRender");
        this.f18822a.mo374a(3735563, "Photos_FlyoutLoadCached");
        this.f18822a.mo374a(3735565, "Dash_FlyoutLoadCached");
    }

    public final void m26483g() {
        this.f18822a.mo374a(3735557, "NNF_FlyoutLoadNetworkNoCache");
        this.f18822a.mo374a(3735558, "NNF_FlyoutLoadNetworkNoCacheAndRender");
    }

    private void m26463O() {
        this.f18823b.mo468b(3735560, (short) 2);
        this.f18825d = true;
    }

    public final void m26484h() {
        this.f18822a.mo389c(3735555, "NNF_FlyoutLoadNetwork");
        this.f18822a.mo389c(3735564, "Photos_FlyoutLoadNetwork");
        this.f18822a.mo389c(3735566, "Dash_FlyoutLoadNetwork");
        this.f18822a.mo389c(3735567, "Flyout_NetworkTimeFeedbackId");
        this.f18822a.mo389c(3735568, "Flyout_NetworkTimeExecutorFeedbackId");
        this.f18822a.mo389c(3735569, "Flyout_NetworkTimePhotoId");
        this.f18822a.mo389c(3735557, "NNF_FlyoutLoadNetworkNoCache");
        this.f18822a.mo389c(3735559, "NNF_FlyoutLoadCompleteFlow");
        this.f18824c = true;
        this.f18822a.mo389c(3735579, "NNF_FlyoutLoadResumeToAnimationWaitTime");
        this.f18822a.mo389c(3735580, "NNF_FlyoutLoadAnimationToDataFetchTime");
        this.f18822a.mo389c(3735575, "NNF_FlyoutLoadAnimationWaitTime");
        m26465V();
    }

    public final void m26478a(Throwable th) {
        Map b = ImmutableBiMap.m978b("exception_name", th.toString());
        this.f18822a.mo393d(new MarkerConfig(3735555, "NNF_FlyoutLoadNetwork").m3387a(b));
        this.f18822a.mo393d(new MarkerConfig(3735557, "NNF_FlyoutLoadNetworkNoCache").m3387a(b));
        this.f18822a.mo393d(new MarkerConfig(3735559, "NNF_FlyoutLoadCompleteFlow").m3387a(b));
        this.f18823b.mo467b(3735560, "exception_name", th.toString());
        this.f18823b.mo468b(3735560, (short) 3);
        if (this.f18826e) {
            this.f18823b.mo467b(3735583, "exception_name", th.toString());
            this.f18823b.mo468b(3735583, (short) 3);
        }
        this.f18822a.mo393d(new MarkerConfig(3735564, "Photos_FlyoutLoadNetwork").m3387a(b));
        this.f18822a.mo393d(new MarkerConfig(3735566, "Dash_FlyoutLoadNetwork").m3387a(b));
        this.f18822a.mo393d(new MarkerConfig(3735567, "Flyout_NetworkTimeFeedbackId").m3387a(b));
        this.f18822a.mo393d(new MarkerConfig(3735568, "Flyout_NetworkTimeExecutorFeedbackId").m3387a(b));
        this.f18822a.mo393d(new MarkerConfig(3735569, "Flyout_NetworkTimePhotoId").m3387a(b));
    }

    public final void m26485i() {
        this.f18822a.mo389c(3735561, "NNF_FlyoutLoadOnCreateTime");
    }

    public final void m26486j() {
        this.f18822a.mo392d(3735570, "NNF_FlyoutLoadOnCreateViewTime");
    }

    public final void m26487k() {
        this.f18822a.mo389c(3735570, "NNF_FlyoutLoadOnCreateViewTime");
    }

    public final void m26488l() {
        this.f18822a.mo392d(3735571, "NNF_FlyoutLoadOnViewCreatedTime");
    }

    public final void m26489m() {
        this.f18822a.mo389c(3735571, "NNF_FlyoutLoadOnViewCreatedTime");
    }

    public final void m26490n() {
        this.f18822a.mo392d(3735572, "NNF_FlyoutLoadOnActivityCreatedTime");
    }

    public final void m26491o() {
        this.f18822a.mo389c(3735572, "NNF_FlyoutLoadOnActivityCreatedTime");
    }

    public final void m26492p() {
        this.f18822a.mo392d(3735573, "NNF_FlyoutLoadOnResumeTime");
    }

    public final void m26493q() {
        this.f18822a.mo389c(3735573, "NNF_FlyoutLoadOnResumeTime");
    }

    public final void m26494r() {
        this.f18822a.mo389c(3735562, "NNF_FlyoutLoadFragmentCreateTime");
    }

    public final void m26495s() {
        this.f18822a.mo392d(3735584, "NNF_FlyoutBgInflatableFeedbackTotalTime");
    }

    public final void m26496w() {
        this.f18822a.mo392d(3735574, "NNF_FlyoutLoadResumeToRenderTime");
    }

    private void m26464S() {
        this.f18822a.mo389c(3735574, "NNF_FlyoutLoadResumeToRenderTime");
    }

    public final void m26497x() {
        if (this.f18825d) {
            this.f18822a.mo392d(3735575, "NNF_FlyoutLoadAnimationWaitTime");
            this.f18822a.mo375a(3735575, "NNF_FlyoutLoadAnimationWaitTime", 0.0d);
            this.f18822a.mo389c(3735575, "NNF_FlyoutLoadAnimationWaitTime");
            return;
        }
        this.f18822a.mo392d(3735575, "NNF_FlyoutLoadAnimationWaitTime");
    }

    public final void m26498y() {
        this.f18822a.mo389c(3735575, "NNF_FlyoutLoadAnimationWaitTime");
    }

    public final void m26499z() {
        this.f18822a.mo392d(3735579, "NNF_FlyoutLoadResumeToAnimationWaitTime");
    }

    public final void m26469A() {
        this.f18822a.mo389c(3735579, "NNF_FlyoutLoadResumeToAnimationWaitTime");
    }

    public final void m26470B() {
        if (this.f18824c) {
            this.f18822a.mo392d(3735580, "NNF_FlyoutLoadAnimationToDataFetchTime");
            this.f18822a.mo375a(3735580, "NNF_FlyoutLoadAnimationToDataFetchTime", 0.0d);
            this.f18822a.mo389c(3735580, "NNF_FlyoutLoadAnimationToDataFetchTime");
            return;
        }
        this.f18822a.mo392d(3735580, "NNF_FlyoutLoadAnimationToDataFetchTime");
    }

    private void m26465V() {
        this.f18822a.mo392d(3735576, "NNF_FlyoutLoadCompleteFlowToRender");
    }

    private void m26466W() {
        this.f18822a.mo389c(3735576, "NNF_FlyoutLoadCompleteFlowToRender");
    }

    public final void m26471C() {
        m26482f();
        this.f18822a.mo374a(3735555, "NNF_FlyoutLoadNetwork");
        this.f18822a.mo374a(3735556, "NNF_FlyoutLoadNetworkAndRender");
        this.f18822a.mo374a(3735564, "Photos_FlyoutLoadNetwork");
        this.f18822a.mo374a(3735566, "Dash_FlyoutLoadNetwork");
        this.f18822a.mo374a(3735567, "Flyout_NetworkTimeFeedbackId");
        this.f18822a.mo374a(3735568, "Flyout_NetworkTimeExecutorFeedbackId");
        this.f18822a.mo374a(3735569, "Flyout_NetworkTimePhotoId");
        this.f18822a.mo374a(3735557, "NNF_FlyoutLoadNetworkNoCache");
        this.f18822a.mo374a(3735558, "NNF_FlyoutLoadNetworkNoCacheAndRender");
        this.f18822a.mo374a(3735559, "NNF_FlyoutLoadCompleteFlow");
        if (this.f18825d) {
            this.f18823b.mo476d(3735560);
        } else {
            this.f18823b.mo468b(3735560, (short) 4);
        }
        this.f18822a.mo374a(3735576, "NNF_FlyoutLoadCompleteFlowToRender");
        this.f18822a.mo374a(3735561, "NNF_FlyoutLoadOnCreateTime");
        this.f18822a.mo374a(3735570, "NNF_FlyoutLoadOnCreateViewTime");
        this.f18822a.mo374a(3735572, "NNF_FlyoutLoadOnActivityCreatedTime");
        this.f18822a.mo374a(3735573, "NNF_FlyoutLoadOnResumeTime");
        this.f18822a.mo374a(3735562, "NNF_FlyoutLoadFragmentCreateTime");
        this.f18822a.mo374a(3735574, "NNF_FlyoutLoadResumeToRenderTime");
        this.f18822a.mo385b(3735584, "NNF_FlyoutBgInflatableFeedbackTotalTime");
        this.f18822a.mo385b(3735585, "NNF_FlyoutBgInflationTime");
        this.f18822a.mo374a(3735575, "NNF_FlyoutLoadAnimationWaitTime");
        if (!this.f18826e) {
            return;
        }
        if (this.f18827f) {
            this.f18823b.mo476d(3735583);
        } else {
            this.f18823b.mo468b(3735583, (short) 4);
        }
    }

    public final void m26472E() {
        this.f18822a.mo389c(3735577, "UfiLoadMoreComments");
    }

    public final void m26473F() {
        this.f18826e = true;
        this.f18822a.mo389c(3735554, "NNF_FlyoutLoadDBCacheAndRender");
        m26463O();
        m26466W();
        m26464S();
        this.f18823b.mo471c(3735583);
    }

    public final void m26474G() {
        this.f18827f = true;
        this.f18822a.mo389c(3735556, "NNF_FlyoutLoadNetworkAndRender");
        this.f18822a.mo389c(3735558, "NNF_FlyoutLoadNetworkNoCacheAndRender");
        m26463O();
        m26466W();
        m26464S();
        if (this.f18826e) {
            this.f18823b.mo468b(3735583, (short) 2);
        }
    }

    public final void m26475H() {
        this.f18823b.mo448a(3735560, "comment");
        m26463O();
        this.f18822a.mo392d(3735582, "NNF_OptimisticComentPostTime");
    }

    public final void m26476I() {
        this.f18822a.mo389c(3735582, "NNF_OptimisticComentPostTime");
    }
}

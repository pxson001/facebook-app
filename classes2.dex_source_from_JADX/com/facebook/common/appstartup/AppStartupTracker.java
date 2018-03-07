package com.facebook.common.appstartup;

import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feedtype.FeedType;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.feed.perf.FeedPerfLogger;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: set_timestamp */
public class AppStartupTracker {
    private static volatile AppStartupTracker f5185d;
    public final FeedPerfLogger f5186a;
    public final Lazy<AppStateManager> f5187b;
    public volatile boolean f5188c;

    public static com.facebook.common.appstartup.AppStartupTracker m9073a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5185d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.appstartup.AppStartupTracker.class;
        monitor-enter(r1);
        r0 = f5185d;	 Catch:{ all -> 0x003a }
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
        r0 = m9074b(r0);	 Catch:{ all -> 0x0035 }
        f5185d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5185d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.appstartup.AppStartupTracker.a(com.facebook.inject.InjectorLike):com.facebook.common.appstartup.AppStartupTracker");
    }

    private static AppStartupTracker m9074b(InjectorLike injectorLike) {
        return new AppStartupTracker(FeedPerfLogger.m3326a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 476));
    }

    @Inject
    public AppStartupTracker(FeedPerfLogger feedPerfLogger, Lazy<AppStateManager> lazy) {
        this.f5186a = feedPerfLogger;
        this.f5187b = lazy;
    }

    public final void m9079i() {
        this.f5186a.m3369i();
    }

    public final void m9077a(boolean z) {
        this.f5186a.f1662B = z;
    }

    public final void m9075a(FetchFeedResult fetchFeedResult, boolean z) {
        this.f5186a.m3349a(fetchFeedResult, z);
    }

    public final void m9078c(boolean z) {
        this.f5188c = false;
        this.f5186a.m3358b(z);
    }

    public final void m9076a(String str, boolean z, FeedType feedType) {
        this.f5188c = false;
        this.f5186a.m3352a(str, z, feedType);
    }
}

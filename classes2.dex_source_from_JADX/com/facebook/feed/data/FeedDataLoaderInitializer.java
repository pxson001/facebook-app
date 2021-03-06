package com.facebook.feed.data;

import com.facebook.feed.loader.IFeedDataLoader;
import com.facebook.feed.perf.FeedPerfLogger;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: snaptu_timeline */
public class FeedDataLoaderInitializer {
    private static volatile FeedDataLoaderInitializer f4472d;
    private final Provider<FeedDataLoaderFactory> f4473a;
    private final FeedPerfLogger f4474b;
    private final CrashLoopCounter f4475c;

    public static com.facebook.feed.data.FeedDataLoaderInitializer m8175a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4472d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.data.FeedDataLoaderInitializer.class;
        monitor-enter(r1);
        r0 = f4472d;	 Catch:{ all -> 0x003a }
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
        r0 = m8176b(r0);	 Catch:{ all -> 0x0035 }
        f4472d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4472d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.data.FeedDataLoaderInitializer.a(com.facebook.inject.InjectorLike):com.facebook.feed.data.FeedDataLoaderInitializer");
    }

    private static FeedDataLoaderInitializer m8176b(InjectorLike injectorLike) {
        return new FeedDataLoaderInitializer(IdBasedProvider.m1811a(injectorLike, 1306), FeedPerfLogger.m3326a(injectorLike), CrashLoopCounter.m8180a(injectorLike));
    }

    @Inject
    public FeedDataLoaderInitializer(Provider<FeedDataLoaderFactory> provider, FeedPerfLogger feedPerfLogger, CrashLoopCounter crashLoopCounter) {
        this.f4473a = provider;
        this.f4474b = feedPerfLogger;
        this.f4475c = crashLoopCounter;
    }

    public final void m8178a() {
        TracerDetour.a("FeedDataLoaderInitializer.onLoginToFeed", -1057851022);
        try {
            m8177c();
            this.f4474b.m3361d(((FeedDataLoaderFactory) this.f4473a.get()).m8948a().mo1305o());
        } finally {
            TracerDetour.a(-1529957426);
        }
    }

    public final void m8179b() {
        m8177c();
    }

    private void m8177c() {
        this.f4475c.m8184a();
        IFeedDataLoader a = ((FeedDataLoaderFactory) this.f4473a.get()).m8948a();
        if (!a.mo1320n()) {
            a.mo1301g();
        }
    }
}

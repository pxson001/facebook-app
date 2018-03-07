package com.facebook.api.feed.xconfig;

import com.facebook.inject.InjectorLike;
import com.facebook.xconfig.core.XConfigReader;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: responseLatency */
public class FeedOffScreenAdsFetchXConfigReader {
    private static volatile FeedOffScreenAdsFetchXConfigReader f7014i;
    public final XConfigReader f7015a;
    public boolean f7016b = false;
    public boolean f7017c = false;
    private volatile int f7018d = -1;
    public volatile boolean f7019e = false;
    public volatile int f7020f = -1;
    public volatile boolean f7021g = false;
    public volatile int f7022h = -1;

    public static com.facebook.api.feed.xconfig.FeedOffScreenAdsFetchXConfigReader m11575a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7014i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.api.feed.xconfig.FeedOffScreenAdsFetchXConfigReader.class;
        monitor-enter(r1);
        r0 = f7014i;	 Catch:{ all -> 0x003a }
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
        r0 = m11576b(r0);	 Catch:{ all -> 0x0035 }
        f7014i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7014i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feed.xconfig.FeedOffScreenAdsFetchXConfigReader.a(com.facebook.inject.InjectorLike):com.facebook.api.feed.xconfig.FeedOffScreenAdsFetchXConfigReader");
    }

    private static FeedOffScreenAdsFetchXConfigReader m11576b(InjectorLike injectorLike) {
        return new FeedOffScreenAdsFetchXConfigReader(XConfigReader.m2681a(injectorLike));
    }

    @Inject
    public FeedOffScreenAdsFetchXConfigReader(XConfigReader xConfigReader) {
        this.f7015a = xConfigReader;
    }

    public final int m11577a() {
        if (this.f7018d == -1) {
            this.f7018d = this.f7015a.m2683a(FeedOffScreenAdsFetchXConfig.f7024d, 8);
        }
        return this.f7018d;
    }
}

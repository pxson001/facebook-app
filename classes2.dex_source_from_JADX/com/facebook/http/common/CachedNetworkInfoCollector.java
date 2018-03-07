package com.facebook.http.common;

import com.facebook.gk.sessionless.GatekeeperStoreImpl_SessionlessMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.observer.NetworkInfo;
import com.facebook.http.observer.NetworkInfoCollector;
import com.facebook.http.observer.TimeInfo;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: upload_video_interstitial */
public class CachedNetworkInfoCollector implements NetworkInfoCollector {
    private static volatile CachedNetworkInfoCollector f1608j;
    private final boolean f1609a;
    private final int f1610b = 2;
    private final int f1611c = 5;
    private final int f1612d = 5;
    private NetworkInfoCollector f1613e;
    private NetworkInfo f1614f;
    private TimeInfo f1615g;
    private long f1616h;
    private long f1617i;

    public static com.facebook.http.common.CachedNetworkInfoCollector m3227a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1608j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.common.CachedNetworkInfoCollector.class;
        monitor-enter(r1);
        r0 = f1608j;	 Catch:{ all -> 0x003a }
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
        r0 = m3228b(r0);	 Catch:{ all -> 0x0035 }
        f1608j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1608j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.CachedNetworkInfoCollector.a(com.facebook.inject.InjectorLike):com.facebook.http.common.CachedNetworkInfoCollector");
    }

    private static CachedNetworkInfoCollector m3228b(InjectorLike injectorLike) {
        return new CachedNetworkInfoCollector(GatekeeperStoreImpl_SessionlessMethodAutoProvider.m2714a(injectorLike));
    }

    @Inject
    public CachedNetworkInfoCollector(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f1609a = gatekeeperStoreImpl.m2189a(30, true);
    }

    public final void mo496a(NetworkInfoCollector networkInfoCollector) {
        this.f1613e = networkInfoCollector;
    }

    public final int mo498c() {
        return 5;
    }

    public final int mo499d() {
        return 2;
    }

    public final int mo500e() {
        return 5;
    }

    public final boolean mo501f() {
        return this.f1609a;
    }

    public final synchronized NetworkInfo mo495a() {
        NetworkInfo networkInfo;
        if (this.f1613e == null) {
            networkInfo = null;
        } else {
            long nanoTime = (System.nanoTime() - this.f1616h) / 1000000000;
            if (this.f1614f == null || nanoTime >= 2) {
                this.f1614f = this.f1613e.mo495a();
                this.f1616h = System.nanoTime();
            }
            networkInfo = this.f1614f;
        }
        return networkInfo;
    }

    public final synchronized TimeInfo mo497b() {
        TimeInfo timeInfo;
        if (this.f1613e == null) {
            timeInfo = null;
        } else {
            long nanoTime = (System.nanoTime() - this.f1617i) / 1000000000;
            if (this.f1615g == null || nanoTime >= 2) {
                this.f1615g = this.f1613e.mo497b();
                this.f1617i = System.nanoTime();
            }
            timeInfo = this.f1615g;
        }
        return timeInfo;
    }
}

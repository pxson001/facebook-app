package com.facebook.prefs.counters;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: offers/detail/?offer_claim_id=%s */
public class PullToRefreshCounter {
    private static volatile PullToRefreshCounter f11606d;
    public final List<Long> f11607a = Lists.m1296a();
    private final Clock f11608b;
    private final DefaultAndroidThreadUtil f11609c;

    public static com.facebook.prefs.counters.PullToRefreshCounter m16910a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11606d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.prefs.counters.PullToRefreshCounter.class;
        monitor-enter(r1);
        r0 = f11606d;	 Catch:{ all -> 0x003a }
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
        r0 = m16911b(r0);	 Catch:{ all -> 0x0035 }
        f11606d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11606d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.prefs.counters.PullToRefreshCounter.a(com.facebook.inject.InjectorLike):com.facebook.prefs.counters.PullToRefreshCounter");
    }

    private static PullToRefreshCounter m16911b(InjectorLike injectorLike) {
        return new PullToRefreshCounter(SystemClockMethodAutoProvider.m1498a(injectorLike), DefaultAndroidThreadUtil.m1646b(injectorLike));
    }

    @Inject
    public PullToRefreshCounter(Clock clock, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f11608b = clock;
        this.f11609c = defaultAndroidThreadUtil;
    }

    public final void m16913a() {
        this.f11609c.m1649a();
        this.f11607a.subList(0, this.f11607a.size() - m16912a(3600)).clear();
        this.f11607a.add(Long.valueOf(this.f11608b.mo211a()));
    }

    public final int m16912a(long j) {
        this.f11609c.m1649a();
        long j2 = j * 1000;
        long a = this.f11608b.mo211a();
        int size = this.f11607a.size();
        for (int i = 0; i < size; i++) {
            if (a - ((Long) this.f11607a.get(i)).longValue() <= j2) {
                return size - i;
            }
        }
        return 0;
    }
}

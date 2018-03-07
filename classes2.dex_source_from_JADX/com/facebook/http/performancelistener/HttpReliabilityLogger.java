package com.facebook.http.performancelistener;

import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.facebook.localstats.LocalStatsListener;
import com.facebook.localstats.LocalStatsLoggerImpl;
import com.facebook.localstats.LocalStatsLoggerMethodAutoProvider;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: notification_position */
public class HttpReliabilityLogger implements LocalStatsListener {
    private static volatile HttpReliabilityLogger f12131g;
    private final LocalStatsLoggerImpl f12132a;
    private final MonotonicClock f12133b;
    @GuardedBy("this")
    private boolean f12134c = false;
    @GuardedBy("this")
    private int f12135d;
    @GuardedBy("this")
    private long f12136e;
    @GuardedBy("this")
    private long f12137f;

    public static com.facebook.http.performancelistener.HttpReliabilityLogger m17843a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12131g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.performancelistener.HttpReliabilityLogger.class;
        monitor-enter(r1);
        r0 = f12131g;	 Catch:{ all -> 0x003a }
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
        r0 = m17844b(r0);	 Catch:{ all -> 0x0035 }
        f12131g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12131g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.performancelistener.HttpReliabilityLogger.a(com.facebook.inject.InjectorLike):com.facebook.http.performancelistener.HttpReliabilityLogger");
    }

    private static HttpReliabilityLogger m17844b(InjectorLike injectorLike) {
        return new HttpReliabilityLogger(AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), LocalStatsLoggerMethodAutoProvider.m13608a(injectorLike));
    }

    @Inject
    public HttpReliabilityLogger(MonotonicClock monotonicClock, LocalStatsLoggerImpl localStatsLoggerImpl) {
        this.f12133b = monotonicClock;
        this.f12132a = localStatsLoggerImpl;
        this.f12132a.m13621a((LocalStatsListener) this);
    }

    public final synchronized void m17847b() {
        this.f12132a.m13619a(4849675, (short) 2);
        if (this.f12134c) {
            m17845d();
            this.f12134c = false;
            this.f12135d = 0;
        }
    }

    public final synchronized void m17848c() {
        this.f12132a.m13619a(4849675, (short) 3);
        this.f12135d++;
        this.f12137f = this.f12133b.now();
        if (!this.f12134c) {
            this.f12134c = true;
            this.f12136e = this.f12137f;
        }
    }

    public final synchronized void mo1834a() {
        if (this.f12134c) {
            m17845d();
            this.f12136e = this.f12133b.now();
            this.f12135d = 0;
        }
    }

    private synchronized void m17845d() {
        if (this.f12135d > 0) {
            this.f12132a.m13617a(4849674, this.f12137f - this.f12136e);
            this.f12132a.m13617a(4849673, (long) this.f12135d);
        }
    }
}

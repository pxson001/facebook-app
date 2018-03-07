package com.facebook.performancelogger;

import com.facebook.inject.InjectorLike;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.ctscan.QPLVisitorForCTScan;
import com.facebook.quicklog.module.QPLVisitorForCTScanMethodAutoProvider;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: user_action */
public class DelegatingPerformanceLogger implements PerformanceLogger {
    private static volatile DelegatingPerformanceLogger f1468d;
    @Nullable
    private final QPLVisitorForCTScan f1469b;
    public final QuickPerformanceLogger f1470c;

    public static com.facebook.performancelogger.DelegatingPerformanceLogger m2803a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1468d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.performancelogger.DelegatingPerformanceLogger.class;
        monitor-enter(r1);
        r0 = f1468d;	 Catch:{ all -> 0x003a }
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
        r0 = m2804b(r0);	 Catch:{ all -> 0x0035 }
        f1468d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1468d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.performancelogger.DelegatingPerformanceLogger.a(com.facebook.inject.InjectorLike):com.facebook.performancelogger.DelegatingPerformanceLogger");
    }

    private static DelegatingPerformanceLogger m2804b(InjectorLike injectorLike) {
        return new DelegatingPerformanceLogger(QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike), QPLVisitorForCTScanMethodAutoProvider.m3192a(injectorLike));
    }

    @Inject
    public DelegatingPerformanceLogger(QuickPerformanceLogger quickPerformanceLogger, @Nullable QPLVisitorForCTScan qPLVisitorForCTScan) {
        this.f1470c = quickPerformanceLogger;
        this.f1469b = qPLVisitorForCTScan;
    }

    public final void mo383a(String str) {
        this.f1470c.mo457a((Object) str);
    }

    public final void mo374a(int i, String str) {
        this.f1470c.markerCancel(i, str.hashCode());
    }

    public final void mo385b(int i, String str) {
        this.f1470c.markerCancel(i, str.hashCode());
    }

    public final void mo375a(int i, String str, double d) {
        this.f1470c.mo455a(i, (short) 2, str, (int) d);
    }

    public final void mo377a(int i, String str, @Nullable String str2, long j) {
        this.f1470c.markerEnd(i, m2802a(str, str2), (short) 2, j);
    }

    public final void mo378a(int i, String str, String str2, String str3, String str4) {
        int a = m2802a(str, str2);
        this.f1470c.mo465b(i, a, "tag_name", str3);
        this.f1470c.mo465b(i, a, "tag_value", str4);
        this.f1470c.mo466b(i, a, (short) 2);
    }

    public final void mo376a(int i, String str, @Nullable String str2) {
        this.f1470c.mo466b(i, m2802a(str, str2), (short) 2);
    }

    public final void mo389c(int i, String str) {
        this.f1470c.mo466b(i, str.hashCode(), (short) 2);
    }

    public final void mo391c(MarkerConfig markerConfig) {
        mo382a(markerConfig, true);
    }

    public final void mo386b(int i, String str, @Nullable String str2) {
        this.f1470c.mo441a(i, m2802a(str, str2), str);
    }

    public final void mo392d(int i, String str) {
        this.f1470c.mo441a(i, str.hashCode(), str);
    }

    public final void mo382a(MarkerConfig markerConfig, boolean z) {
        int a = m2802a(markerConfig.f1695d, markerConfig.m3394d());
        if (z || !this.f1470c.mo484j(markerConfig.m3402m(), a)) {
            this.f1470c.mo438a(markerConfig.m3402m(), markerConfig.m3403n(), a, markerConfig.m3393c(), markerConfig.m3396f(), markerConfig.m3397h(), markerConfig.m3395e(), markerConfig.m3399j(), markerConfig.m3404o());
        }
        if (this.f1470c.mo484j(markerConfig.m3402m(), a)) {
            if (markerConfig.m3389a() != null) {
                this.f1470c.mo443a(markerConfig.m3402m(), a, markerConfig.m3389a());
            }
            if (markerConfig.m3398i() != null) {
                this.f1470c.mo444a(markerConfig.m3402m(), a, markerConfig.m3398i());
            }
            if (markerConfig.m3400k() != null) {
                this.f1470c.mo465b(markerConfig.m3402m(), a, "tag_name", markerConfig.m3400k());
            }
            if (markerConfig.m3401l() != null) {
                this.f1470c.mo465b(markerConfig.m3402m(), a, "tag_value", markerConfig.m3401l());
            }
        }
    }

    public final void mo387b(MarkerConfig markerConfig) {
        int a = m2802a(markerConfig.f1695d, markerConfig.f1696e);
        if (this.f1470c.mo484j(markerConfig.f1692a, a)) {
            if (markerConfig.f1703l != null) {
                this.f1470c.mo444a(markerConfig.f1692a, a, markerConfig.f1703l);
            }
            if (markerConfig.f1706o != null) {
                this.f1470c.mo465b(markerConfig.f1692a, a, "tag_name", markerConfig.f1706o);
            }
            if (markerConfig.f1707p != null) {
                this.f1470c.mo465b(markerConfig.f1692a, a, "tag_value", markerConfig.f1707p);
            }
        }
        this.f1470c.mo446a(markerConfig.f1692a, a, (short) 2, markerConfig.f1699h, markerConfig.f1712u);
    }

    public final void mo393d(MarkerConfig markerConfig) {
        this.f1470c.markerEnd(markerConfig.f1692a, m2802a(markerConfig.f1695d, markerConfig.f1696e), (short) 3, markerConfig.f1699h);
    }

    public final boolean mo396e(MarkerConfig markerConfig) {
        return this.f1470c.mo484j(markerConfig.f1692a, m2802a(markerConfig.f1695d, markerConfig.f1696e));
    }

    public final void mo398f(MarkerConfig markerConfig) {
        this.f1470c.markerCancel(markerConfig.f1692a, m2802a(markerConfig.f1695d, markerConfig.f1696e));
    }

    public final void mo395e(int i, String str) {
        int a = m2802a(str, null);
        if (!this.f1470c.mo484j(i, a)) {
            this.f1470c.mo441a(i, a, str);
        }
    }

    public final void mo390c(int i, String str, @Nullable String str2) {
        this.f1470c.mo466b(i, m2802a(str, str2), (short) 3);
    }

    public final void mo397f(int i, String str) {
        this.f1470c.mo466b(i, str.hashCode(), (short) 3);
    }

    public final boolean mo384a() {
        return this.f1470c.mo470b();
    }

    public final boolean mo399g(int i, String str) {
        return this.f1470c.mo484j(i, str.hashCode());
    }

    public final boolean mo394d(int i, String str, String str2) {
        return this.f1470c.mo484j(i, m2802a(str, str2));
    }

    public final boolean mo400h(int i, String str) {
        return this.f1470c.mo473c(i, str.hashCode());
    }

    public final void mo381a(MarkerConfig markerConfig, double d) {
        this.f1470c.mo455a(markerConfig.f1692a, (short) 2, markerConfig.f1695d, (int) d);
    }

    public final void mo379a(int i, String str, String str2, String str3, boolean z) {
        int hashCode = str.hashCode();
        if (z || !this.f1470c.mo482h(i, hashCode)) {
            this.f1470c.mo465b(i, hashCode, "tag_name", str2);
            this.f1470c.mo465b(i, hashCode, "tag_value", str3);
        }
    }

    public final boolean mo388b() {
        return this.f1470c.mo472c();
    }

    public static int m2802a(String str, @Nullable String str2) {
        return str2 == null ? str.hashCode() : str.hashCode() ^ str2.hashCode();
    }

    public final void mo380a(MarkerConfig markerConfig) {
        this.f1470c.markerCancel(markerConfig.f1692a, m2802a(markerConfig.f1695d, markerConfig.f1696e));
    }
}

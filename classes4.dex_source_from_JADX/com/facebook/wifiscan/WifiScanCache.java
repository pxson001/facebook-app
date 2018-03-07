package com.facebook.wifiscan;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.facebook.common.android.WifiManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: huge_img_size */
public class WifiScanCache {
    private static final String f10581a = WifiScanCache.class.getSimpleName();
    private static volatile WifiScanCache f10582f;
    private final AbstractFbErrorReporter f10583b;
    private final WifiScanEligibilityUtil f10584c;
    private final WifiManager f10585d;
    private final MonotonicClock f10586e;

    public static com.facebook.wifiscan.WifiScanCache m11118a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10582f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.wifiscan.WifiScanCache.class;
        monitor-enter(r1);
        r0 = f10582f;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m11119b(r0);	 Catch:{ all -> 0x0035 }
        f10582f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10582f;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.wifiscan.WifiScanCache.a(com.facebook.inject.InjectorLike):com.facebook.wifiscan.WifiScanCache");
    }

    private static WifiScanCache m11119b(InjectorLike injectorLike) {
        return new WifiScanCache((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), WifiScanEligibilityUtil.a(injectorLike), WifiManagerMethodAutoProvider.b(injectorLike), (MonotonicClock) RealtimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public WifiScanCache(AbstractFbErrorReporter abstractFbErrorReporter, WifiScanEligibilityUtil wifiScanEligibilityUtil, WifiManager wifiManager, MonotonicClock monotonicClock) {
        this.f10583b = abstractFbErrorReporter;
        this.f10584c = wifiScanEligibilityUtil;
        this.f10585d = wifiManager;
        this.f10586e = monotonicClock;
    }

    @Nullable
    public final List<ScanResult> m11120a(long j) {
        if (!WifiScanEligibilityUtil.b()) {
            return null;
        }
        try {
            List<ScanResult> a = ScanResultAgeUtil.a(this.f10585d.getScanResults(), j, this.f10586e.now());
            if (a == null || a.isEmpty()) {
                return null;
            }
            return a;
        } catch (Throwable e) {
            this.f10583b.a(f10581a, "No permission to access wifi scan results", e);
            return null;
        }
    }
}

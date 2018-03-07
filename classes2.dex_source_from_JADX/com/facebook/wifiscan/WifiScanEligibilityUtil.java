package com.facebook.wifiscan;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.TriState;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: manual_refresh */
public class WifiScanEligibilityUtil {
    private static final String f15214a = WifiScanEligibilityUtil.class.getSimpleName();
    private static volatile WifiScanEligibilityUtil f15215d;
    public final Context f15216b;
    private final AbstractFbErrorReporter f15217c;

    public static com.facebook.wifiscan.WifiScanEligibilityUtil m21744a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15215d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.wifiscan.WifiScanEligibilityUtil.class;
        monitor-enter(r1);
        r0 = f15215d;	 Catch:{ all -> 0x003a }
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
        r0 = m21746b(r0);	 Catch:{ all -> 0x0035 }
        f15215d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15215d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.wifiscan.WifiScanEligibilityUtil.a(com.facebook.inject.InjectorLike):com.facebook.wifiscan.WifiScanEligibilityUtil");
    }

    private static WifiScanEligibilityUtil m21746b(InjectorLike injectorLike) {
        return new WifiScanEligibilityUtil((Context) injectorLike.getInstance(Context.class), FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public WifiScanEligibilityUtil(Context context, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f15216b = context;
        this.f15217c = abstractFbErrorReporter;
    }

    public final boolean m21750a() {
        try {
            return this.f15216b.getPackageManager().hasSystemFeature("android.hardware.wifi");
        } catch (Throwable e) {
            this.f15217c.m2346a(f15214a, e);
            return false;
        }
    }

    public static boolean m21747b() {
        return VERSION.SDK_INT >= 17;
    }

    private boolean m21748f() {
        return m21745a("android.permission.ACCESS_WIFI_STATE") && m21749g();
    }

    public final boolean m21751c() {
        return m21748f() && m21745a("android.permission.CHANGE_WIFI_STATE");
    }

    public final boolean m21752d() {
        return ((WifiManager) this.f15216b.getSystemService("wifi")).isWifiEnabled();
    }

    public final TriState m21753e() {
        if (VERSION.SDK_INT < 18) {
            return TriState.UNSET;
        }
        return TriState.valueOf(((WifiManager) this.f15216b.getSystemService("wifi")).isScanAlwaysAvailable());
    }

    private boolean m21749g() {
        return m21745a("android.permission.ACCESS_COARSE_LOCATION") || m21745a("android.permission.ACCESS_FINE_LOCATION");
    }

    private boolean m21745a(String str) {
        return this.f15216b.checkCallingOrSelfPermission(str) == 0;
    }
}

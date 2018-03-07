package com.facebook.rtc.fbwebrtc;

import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.os.PowerManager;
import com.facebook.common.android.PowerManagerMethodAutoProvider;
import com.facebook.common.android.WifiManagerMethodAutoProvider;
import com.facebook.common.wakelock.FbWakeLockManager;
import com.facebook.common.wakelock.FbWakeLockManager.WakeLock;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: audio/mp4 */
public class IncallWakeLocks {
    private static volatile IncallWakeLocks f19357i;
    private final boolean f19358a;
    public final PowerManager f19359b;
    private final FbWakeLockManager f19360c;
    private final WifiManager f19361d;
    private final DeviceConditionHelper f19362e;
    private WakeLock f19363f;
    private WakeLock f19364g;
    private WifiLock f19365h;

    public static com.facebook.rtc.fbwebrtc.IncallWakeLocks m19349a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f19357i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.rtc.fbwebrtc.IncallWakeLocks.class;
        monitor-enter(r1);
        r0 = f19357i;	 Catch:{ all -> 0x003a }
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
        r0 = m19351b(r0);	 Catch:{ all -> 0x0035 }
        f19357i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19357i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtc.fbwebrtc.IncallWakeLocks.a(com.facebook.inject.InjectorLike):com.facebook.rtc.fbwebrtc.IncallWakeLocks");
    }

    private static IncallWakeLocks m19351b(InjectorLike injectorLike) {
        return new IncallWakeLocks(PowerManagerMethodAutoProvider.b(injectorLike), FbWakeLockManager.a(injectorLike), WifiManagerMethodAutoProvider.b(injectorLike), DeviceConditionHelper.a(injectorLike));
    }

    @Inject
    public IncallWakeLocks(PowerManager powerManager, FbWakeLockManager fbWakeLockManager, WifiManager wifiManager, DeviceConditionHelper deviceConditionHelper) {
        this.f19359b = powerManager;
        this.f19360c = fbWakeLockManager;
        this.f19361d = wifiManager;
        this.f19362e = deviceConditionHelper;
        this.f19358a = m19350a(powerManager);
    }

    private static boolean m19350a(PowerManager powerManager) {
        try {
            return powerManager.newWakeLock(32, "IncallWakeLocks") != null;
        } catch (Exception e) {
            return false;
        }
    }

    public final synchronized void m19352a() {
        if (this.f19358a) {
            if (this.f19363f == null) {
                this.f19363f = this.f19360c.a(32, "IncallWakeLocks");
                this.f19363f.a(false);
            }
            if (!this.f19363f.e()) {
                this.f19363f.c();
            }
        }
    }

    public final synchronized void m19353b() {
        if (this.f19363f != null && this.f19363f.e()) {
            this.f19363f.d();
        }
        this.f19363f = null;
    }

    public final synchronized void m19354c() {
        if (this.f19364g == null) {
            this.f19364g = this.f19360c.a(1, "IncallWakeLocks");
            this.f19364g.a(false);
        }
        if (!this.f19364g.e()) {
            this.f19364g.c();
        }
    }

    public final synchronized void m19355d() {
        if (this.f19364g != null && this.f19364g.e()) {
            this.f19364g.d();
        }
        this.f19364g = null;
    }

    public final synchronized void m19356e() {
        if (this.f19362e.a(true)) {
            if (this.f19365h == null) {
                this.f19365h = this.f19361d.createWifiLock(3, "IncallWakeLocks");
                this.f19365h.setReferenceCounted(false);
            }
            if (!this.f19365h.isHeld()) {
                this.f19365h.acquire();
            }
        }
    }

    public final synchronized void m19357f() {
        if (this.f19365h != null && this.f19365h.isHeld()) {
            this.f19365h.release();
        }
        this.f19365h = null;
    }
}

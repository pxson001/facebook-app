package com.facebook.messaging.connectivity;

import android.net.NetworkInfo;
import android.text.format.Time;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.SystemClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import java.util.LinkedList;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: is_native_intent */
public class ConnectivityBannerDisplayTracker {
    private static volatile ConnectivityBannerDisplayTracker f12023d;
    @GuardedBy("this")
    private final LinkedList<String> f12024a = new LinkedList();
    @GuardedBy("this")
    private final LinkedList<String> f12025b = new LinkedList();
    private final SystemClock f12026c;

    /* compiled from: is_native_intent */
    public enum DisplayStatus {
        HIDDEN,
        NO_INTERNET,
        CONNECTED,
        WAITING_TO_CONNECT,
        CONNECTING,
        AIRPLANE_MODE,
        CAPTIVE_PORTAL
    }

    public static com.facebook.messaging.connectivity.ConnectivityBannerDisplayTracker m18932a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12023d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.connectivity.ConnectivityBannerDisplayTracker.class;
        monitor-enter(r1);
        r0 = f12023d;	 Catch:{ all -> 0x003a }
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
        r0 = m18935b(r0);	 Catch:{ all -> 0x0035 }
        f12023d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12023d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.connectivity.ConnectivityBannerDisplayTracker.a(com.facebook.inject.InjectorLike):com.facebook.messaging.connectivity.ConnectivityBannerDisplayTracker");
    }

    private static ConnectivityBannerDisplayTracker m18935b(InjectorLike injectorLike) {
        return new ConnectivityBannerDisplayTracker(SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ConnectivityBannerDisplayTracker(SystemClock systemClock) {
        this.f12026c = systemClock;
    }

    public final synchronized void m18936a(ConnectionStatusSurface connectionStatusSurface, DisplayStatus displayStatus) {
        if (this.f12024a.size() >= 10) {
            this.f12024a.removeFirst();
        }
        this.f12024a.addLast(StringFormatUtil.formatStrLocaleSafe("%s: %s %s", m18933a(), connectionStatusSurface, displayStatus));
    }

    public final synchronized void m18937a(String str, String str2) {
        if (this.f12025b.size() >= 10) {
            this.f12025b.removeFirst();
        }
        this.f12025b.addLast(StringFormatUtil.formatStrLocaleSafe("%s: %s %s", m18933a(), str, str2));
    }

    public static StringBuilder m18934a(StringBuilder stringBuilder, NetworkInfo networkInfo) {
        stringBuilder.append("NetworkInfo: ");
        if (networkInfo == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append("type: ").append(networkInfo.getTypeName()).append("[").append(networkInfo.getSubtypeName()).append("], state: ").append(networkInfo.getState()).append("/").append(networkInfo.getDetailedState()).append(", isAvailable: ").append(networkInfo.isAvailable()).append(", isConnected: ").append(networkInfo.isConnected()).append(", isConnectedOrConnecting: ").append(networkInfo.isConnectedOrConnecting());
        }
        return stringBuilder;
    }

    private String m18933a() {
        Time time = new Time();
        time.set(this.f12026c.a());
        return time.format3339(false);
    }
}

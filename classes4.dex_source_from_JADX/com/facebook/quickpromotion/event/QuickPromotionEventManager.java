package com.facebook.quickpromotion.event;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.android.ConnectivityManagerMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: lockscreen_light_up_screen */
public class QuickPromotionEventManager implements INeedInit {
    private static volatile QuickPromotionEventManager f9086h;
    private final BaseFbBroadcastManager f9087a;
    public final FbNetworkManager f9088b;
    private final ConnectivityManager f9089c;
    public final Clock f9090d;
    private SelfRegistrableReceiverImpl f9091e;
    public MeteredConnectionStatus f9092f = MeteredConnectionStatus.UNKNOWN;
    public long f9093g = 0;

    /* compiled from: lockscreen_light_up_screen */
    enum MeteredConnectionStatus {
        UNKNOWN,
        METERED,
        UNMETERED
    }

    /* compiled from: lockscreen_light_up_screen */
    class C05461 implements ActionReceiver {
        final /* synthetic */ QuickPromotionEventManager f11279a;

        C05461(QuickPromotionEventManager quickPromotionEventManager) {
            this.f11279a = quickPromotionEventManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -594636931);
            if (this.f11279a.f9088b.d()) {
                MeteredConnectionStatus b = QuickPromotionEventManager.m9426b(this.f11279a);
                if (!(this.f11279a.f9092f == MeteredConnectionStatus.UNKNOWN || this.f11279a.f9092f == b)) {
                    this.f11279a.f9093g = this.f11279a.f9090d.a();
                }
                this.f11279a.f9092f = b;
                LogUtils.e(958500354, a);
                return;
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 2031313550, a);
        }
    }

    public static com.facebook.quickpromotion.event.QuickPromotionEventManager m9425a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9086h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.quickpromotion.event.QuickPromotionEventManager.class;
        monitor-enter(r1);
        r0 = f9086h;	 Catch:{ all -> 0x003a }
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
        r0 = m9427b(r0);	 Catch:{ all -> 0x0035 }
        f9086h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9086h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.quickpromotion.event.QuickPromotionEventManager.a(com.facebook.inject.InjectorLike):com.facebook.quickpromotion.event.QuickPromotionEventManager");
    }

    private static QuickPromotionEventManager m9427b(InjectorLike injectorLike) {
        return new QuickPromotionEventManager((BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), FbNetworkManager.a(injectorLike), ConnectivityManagerMethodAutoProvider.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    QuickPromotionEventManager(BaseFbBroadcastManager baseFbBroadcastManager, FbNetworkManager fbNetworkManager, ConnectivityManager connectivityManager, Clock clock) {
        this.f9087a = baseFbBroadcastManager;
        this.f9088b = fbNetworkManager;
        this.f9089c = connectivityManager;
        this.f9090d = clock;
    }

    public void init() {
        this.f9091e = this.f9087a.a().a("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED", new C05461(this)).a();
        if (this.f9088b.d()) {
            this.f9092f = m9426b(this);
        }
        this.f9091e.b();
    }

    public static MeteredConnectionStatus m9426b(QuickPromotionEventManager quickPromotionEventManager) {
        try {
            return quickPromotionEventManager.f9088b.h() ? MeteredConnectionStatus.METERED : MeteredConnectionStatus.UNMETERED;
        } catch (NoSuchMethodError e) {
            return MeteredConnectionStatus.UNKNOWN;
        }
    }
}

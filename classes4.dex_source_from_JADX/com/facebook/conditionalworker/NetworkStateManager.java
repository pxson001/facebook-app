package com.facebook.conditionalworker;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.CrossFbAppBroadcastManager;
import com.facebook.conditionalworker.States.NetworkState;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: max_delay_ms */
public class NetworkStateManager {
    private static volatile NetworkStateManager f8207f;
    private final Context f8208a;
    private final BaseFbBroadcastManager f8209b;
    private SelfRegistrableReceiverImpl f8210c;
    private volatile ConditionalWorkerManager f8211d;
    private volatile NetworkState f8212e;

    /* compiled from: max_delay_ms */
    class C04591 implements ActionReceiver {
        final /* synthetic */ NetworkStateManager f10091a;

        C04591(NetworkStateManager networkStateManager) {
            this.f10091a = networkStateManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1882745361);
            NetworkStateManager.m8503d(this.f10091a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -920909045, a);
        }
    }

    public static com.facebook.conditionalworker.NetworkStateManager m8499a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8207f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.conditionalworker.NetworkStateManager.class;
        monitor-enter(r1);
        r0 = f8207f;	 Catch:{ all -> 0x003a }
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
        r0 = m8500b(r0);	 Catch:{ all -> 0x0035 }
        f8207f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8207f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.conditionalworker.NetworkStateManager.a(com.facebook.inject.InjectorLike):com.facebook.conditionalworker.NetworkStateManager");
    }

    private static NetworkStateManager m8500b(InjectorLike injectorLike) {
        return new NetworkStateManager((Context) injectorLike.getInstance(Context.class, ForAppContext.class), (BaseFbBroadcastManager) CrossFbAppBroadcastManager.a(injectorLike));
    }

    @Inject
    public NetworkStateManager(@ForAppContext Context context, BaseFbBroadcastManager baseFbBroadcastManager) {
        this.f8208a = context;
        this.f8209b = baseFbBroadcastManager;
    }

    public final NetworkState m8504a() {
        return m8501b();
    }

    public final void m8505a(@Nonnull ConditionalWorkerManager conditionalWorkerManager) {
        this.f8211d = conditionalWorkerManager;
        m8502c();
    }

    private NetworkState m8501b() {
        if (this.f8208a.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return null;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f8208a.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return null;
        }
        switch (activeNetworkInfo.getType()) {
            case 0:
                return NetworkState.CONNECTED_THROUGH_MOBILE;
            case 1:
                return NetworkState.CONNECTED_THROUGH_WIFI;
            default:
                return NetworkState.CONNECTED;
        }
    }

    private void m8502c() {
        if (this.f8210c == null) {
            this.f8212e = m8501b();
            this.f8210c = this.f8209b.a().a("android.net.conn.CONNECTIVITY_CHANGE", new C04591(this)).a();
            this.f8210c.b();
        }
    }

    public static void m8503d(NetworkStateManager networkStateManager) {
        NetworkState b = networkStateManager.m8501b();
        if (b == null) {
            if (networkStateManager.f8212e != null) {
                networkStateManager.f8212e = null;
                ConditionalWorkerManager.m8494n(networkStateManager.f8211d);
            }
        } else if (!b.equals(networkStateManager.f8212e)) {
            networkStateManager.f8212e = b;
            ConditionalWorkerManager.m8494n(networkStateManager.f8211d);
        }
    }
}

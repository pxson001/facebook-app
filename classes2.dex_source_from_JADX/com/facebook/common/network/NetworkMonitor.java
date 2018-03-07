package com.facebook.common.network;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.upload.manager.UploadManager.2;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: pymk_size_param */
public class NetworkMonitor {
    private static volatile NetworkMonitor f8570c;
    private final BaseFbBroadcastManager f8571a;
    public final FbNetworkManager f8572b;

    /* compiled from: pymk_size_param */
    public enum State {
        CONNECTED,
        NO_INTERNET
    }

    public static com.facebook.common.network.NetworkMonitor m13133a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8570c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.network.NetworkMonitor.class;
        monitor-enter(r1);
        r0 = f8570c;	 Catch:{ all -> 0x003a }
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
        r0 = m13134b(r0);	 Catch:{ all -> 0x0035 }
        f8570c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8570c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.network.NetworkMonitor.a(com.facebook.inject.InjectorLike):com.facebook.common.network.NetworkMonitor");
    }

    private static NetworkMonitor m13134b(InjectorLike injectorLike) {
        return new NetworkMonitor(LocalFbBroadcastManager.m2946a(injectorLike), FbNetworkManager.m3811a(injectorLike));
    }

    @Inject
    public NetworkMonitor(BaseFbBroadcastManager baseFbBroadcastManager, FbNetworkManager fbNetworkManager) {
        this.f8571a = baseFbBroadcastManager;
        this.f8572b = fbNetworkManager;
    }

    public final SelfRegistrableReceiverImpl m13136a(final State state, final Runnable runnable) {
        SelfRegistrableReceiverImpl a = this.f8571a.m2951a().mo506a("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED", new ActionReceiver(this) {
            final /* synthetic */ NetworkMonitor f22197c;

            public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -317594116);
                switch (3.a[state.ordinal()]) {
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        if (this.f22197c.f8572b.m3828d()) {
                            runnable.run();
                            break;
                        }
                        break;
                    case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                        if (!this.f22197c.f8572b.m3828d()) {
                            runnable.run();
                            break;
                        }
                        break;
                }
                LogUtils.e(1591032739, a);
            }
        }).mo503a();
        a.m3296b();
        return a;
    }

    public final SelfRegistrableReceiverImpl m13135a(State state, 2 2) {
        SelfRegistrableReceiverImpl a = this.f8571a.m2951a().mo506a("com.facebook.common.hardware.ACTION_INET_CONDITION_CHANGED", new 2(this, state, 2)).mo503a();
        a.m3296b();
        return a;
    }

    public final boolean m13137a() {
        return this.f8572b.m3828d();
    }
}

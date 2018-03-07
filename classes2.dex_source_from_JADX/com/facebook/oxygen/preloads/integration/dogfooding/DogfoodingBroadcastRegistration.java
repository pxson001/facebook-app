package com.facebook.oxygen.preloads.integration.dogfooding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.broadcast.FbBroadcastManagerType;
import com.facebook.common.init.INeedInitForBroadcastReceiverRegistration;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: total_device_bytes_sent */
public class DogfoodingBroadcastRegistration extends INeedInitForBroadcastReceiverRegistration<Boolean> {
    private static volatile DogfoodingBroadcastRegistration f2372a;

    public static com.facebook.oxygen.preloads.integration.dogfooding.DogfoodingBroadcastRegistration m4531a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2372a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.oxygen.preloads.integration.dogfooding.DogfoodingBroadcastRegistration.class;
        monitor-enter(r1);
        r0 = f2372a;	 Catch:{ all -> 0x003a }
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
        r0 = m4532b(r0);	 Catch:{ all -> 0x0035 }
        f2372a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2372a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.oxygen.preloads.integration.dogfooding.DogfoodingBroadcastRegistration.a(com.facebook.inject.InjectorLike):com.facebook.oxygen.preloads.integration.dogfooding.DogfoodingBroadcastRegistration");
    }

    private static DogfoodingBroadcastRegistration m4532b(InjectorLike injectorLike) {
        return new DogfoodingBroadcastRegistration(IdBasedLazy.m1808a(injectorLike, 4244));
    }

    @Inject
    public DogfoodingBroadcastRegistration(Lazy<Boolean> lazy) {
        super(FbBroadcastManagerType.GLOBAL, (Lazy) lazy, "com.facebook.oxygen.preloads.integration.dogfooding.PROCESS_RUNING");
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -891436134);
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_running", true);
        broadcastReceiverLike.setResultCode(-1);
        broadcastReceiverLike.setResultExtras(bundle);
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1694582819, a);
    }
}

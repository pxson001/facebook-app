package com.facebook.zero.service;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.FbBroadcastManagerType;
import com.facebook.common.init.INeedInitForBroadcastReceiverRegistration;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: total_bytes_sent */
public class C0159xeeee0c1b extends INeedInitForBroadcastReceiverRegistration<ZeroHeaderRequestManager> {
    private static volatile C0159xeeee0c1b f2378a;

    public static com.facebook.zero.service.C0159xeeee0c1b m4542a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2378a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.zero.service.C0159xeeee0c1b.class;
        monitor-enter(r1);
        r0 = f2378a;	 Catch:{ all -> 0x003a }
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
        r0 = com.facebook.zero.service.C0159xeeee0c1b.m4543b(r0);	 Catch:{ all -> 0x0035 }
        f2378a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2378a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.service.ZeroHeaderRequestManager$CrossProcessZeroHeaderRequestManagerReceiverRegistration.a(com.facebook.inject.InjectorLike):com.facebook.zero.service.ZeroHeaderRequestManager$CrossProcessZeroHeaderRequestManagerReceiverRegistration");
    }

    private static C0159xeeee0c1b m4543b(InjectorLike injectorLike) {
        return new C0159xeeee0c1b(IdBasedSingletonScopeProvider.m1810b(injectorLike, 3813));
    }

    protected void onReceive(Context context, Intent intent, Object obj) {
        ZeroHeaderRequestManager zeroHeaderRequestManager = (ZeroHeaderRequestManager) obj;
        if ("com.facebook.zero.ACTION_FORCE_ZERO_HEADER_REFRESH".equals(intent.getAction())) {
            zeroHeaderRequestManager.a(true);
        }
    }

    @Inject
    public C0159xeeee0c1b(Lazy<ZeroHeaderRequestManager> lazy) {
        super(FbBroadcastManagerType.CROSS_PROCESS, (Lazy) lazy, "com.facebook.zero.ACTION_FORCE_ZERO_HEADER_REFRESH");
    }
}

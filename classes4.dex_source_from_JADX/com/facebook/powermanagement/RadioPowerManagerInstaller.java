package com.facebook.powermanagement;

import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.hardware.NetworkActivityBroadcastManager;
import com.facebook.common.init.INeedInit;
import com.facebook.content.ActionReceiver;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.powermanagement.RadioPowerManager.NetworkActivityActionReceiver;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: lockscreen_show_facebook */
public class RadioPowerManagerInstaller implements INeedInit {
    private static volatile RadioPowerManagerInstaller f9066d;
    private final Lazy<RadioPowerManager> f9067a;
    private final Lazy<FbBroadcastManager> f9068b;
    private SelfRegistrableReceiverImpl f9069c;

    public static com.facebook.powermanagement.RadioPowerManagerInstaller m9414a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9066d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.powermanagement.RadioPowerManagerInstaller.class;
        monitor-enter(r1);
        r0 = f9066d;	 Catch:{ all -> 0x003a }
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
        r0 = m9415b(r0);	 Catch:{ all -> 0x0035 }
        f9066d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9066d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.powermanagement.RadioPowerManagerInstaller.a(com.facebook.inject.InjectorLike):com.facebook.powermanagement.RadioPowerManagerInstaller");
    }

    private static RadioPowerManagerInstaller m9415b(InjectorLike injectorLike) {
        return new RadioPowerManagerInstaller(IdBasedLazy.a(injectorLike, 392), IdBasedSingletonScopeProvider.b(injectorLike, 3067));
    }

    @Inject
    public RadioPowerManagerInstaller(Lazy<FbBroadcastManager> lazy, Lazy<RadioPowerManager> lazy2) {
        this.f9067a = lazy2;
        this.f9068b = lazy;
    }

    public void init() {
        RadioPowerManager radioPowerManager = (RadioPowerManager) this.f9067a.get();
        NetworkActivityActionReceiver networkActivityActionReceiver = new NetworkActivityActionReceiver(radioPowerManager);
        radioPowerManager.f11179e = networkActivityActionReceiver;
        ActionReceiver actionReceiver = networkActivityActionReceiver;
        this.f9069c = ((BaseFbBroadcastManager) this.f9068b.get()).a().a(NetworkActivityBroadcastManager.a, actionReceiver).a(NetworkActivityBroadcastManager.b, actionReceiver).a();
        this.f9069c.b();
    }
}

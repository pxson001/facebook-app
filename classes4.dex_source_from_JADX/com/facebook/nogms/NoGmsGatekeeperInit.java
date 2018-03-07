package com.facebook.nogms;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.facebook.common.init.INeedInit;
import com.facebook.common.util.TriState;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: login_approvals_push_auth */
public class NoGmsGatekeeperInit implements INeedInit {
    private static volatile NoGmsGatekeeperInit f8869d;
    @Inject
    public volatile Provider<GatekeeperStore> f8870a = UltralightRuntime.a;
    @Inject
    public volatile Provider<PackageManager> f8871b = UltralightRuntime.a;
    @Inject
    public volatile Provider<Context> f8872c = UltralightRuntime.a;

    public static com.facebook.nogms.NoGmsGatekeeperInit m9234a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8869d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.nogms.NoGmsGatekeeperInit.class;
        monitor-enter(r1);
        r0 = f8869d;	 Catch:{ all -> 0x003a }
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
        r0 = m9235b(r0);	 Catch:{ all -> 0x0035 }
        f8869d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8869d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.nogms.NoGmsGatekeeperInit.a(com.facebook.inject.InjectorLike):com.facebook.nogms.NoGmsGatekeeperInit");
    }

    private static NoGmsGatekeeperInit m9235b(InjectorLike injectorLike) {
        NoGmsGatekeeperInit noGmsGatekeeperInit = new NoGmsGatekeeperInit();
        Provider a = IdBasedSingletonScopeProvider.a(injectorLike, 2128);
        Provider a2 = IdBasedSingletonScopeProvider.a(injectorLike, 28);
        Provider provider = injectorLike.getProvider(Context.class);
        noGmsGatekeeperInit.f8870a = a;
        noGmsGatekeeperInit.f8871b = a2;
        noGmsGatekeeperInit.f8872c = provider;
        return noGmsGatekeeperInit;
    }

    public void init() {
        int i;
        Context context = (Context) this.f8872c.get();
        PackageManager packageManager = (PackageManager) this.f8871b.get();
        GatekeeperStoreImpl gatekeeperStoreImpl = (GatekeeperStoreImpl) this.f8870a.get();
        ComponentName componentName = new ComponentName(context.getPackageName(), "com.google.android.gms.measurement.AppMeasurementContentProvider");
        ComponentName componentName2 = new ComponentName(context.getPackageName(), "com.google.android.gms.measurement.AppMeasurementService");
        ComponentName componentName3 = new ComponentName(context.getPackageName(), "com.google.android.gms.measurement.AppMeasurementReceiver");
        if ((gatekeeperStoreImpl.a(389) == TriState.YES ? 1 : 0) != 0) {
            i = 2;
        } else {
            i = 0;
        }
        packageManager.setComponentEnabledSetting(componentName, i, 1);
        packageManager.setComponentEnabledSetting(componentName2, i, 1);
        packageManager.setComponentEnabledSetting(componentName3, i, 1);
    }
}

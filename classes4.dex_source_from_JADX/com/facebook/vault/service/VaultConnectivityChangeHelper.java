package com.facebook.vault.service;

import android.content.ComponentName;
import android.content.Context;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: latestInboxFromFetch */
public class VaultConnectivityChangeHelper {
    private static volatile VaultConnectivityChangeHelper f9481b;
    private final Context f9482a;

    public static com.facebook.vault.service.VaultConnectivityChangeHelper m9852a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9481b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.vault.service.VaultConnectivityChangeHelper.class;
        monitor-enter(r1);
        r0 = f9481b;	 Catch:{ all -> 0x003a }
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
        r0 = m9854b(r0);	 Catch:{ all -> 0x0035 }
        f9481b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9481b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.vault.service.VaultConnectivityChangeHelper.a(com.facebook.inject.InjectorLike):com.facebook.vault.service.VaultConnectivityChangeHelper");
    }

    private static VaultConnectivityChangeHelper m9854b(InjectorLike injectorLike) {
        return new VaultConnectivityChangeHelper((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public VaultConnectivityChangeHelper(Context context) {
        this.f9482a = context;
    }

    public final void m9855a() {
        m9853a(1);
    }

    public final void m9856b() {
        m9853a(2);
    }

    private void m9853a(int i) {
        ComponentName componentName = new ComponentName(this.f9482a, VaultConnectivityChangeReceiver.class);
        if (this.f9482a.getPackageManager().getComponentEnabledSetting(componentName) != i) {
            this.f9482a.getPackageManager().setComponentEnabledSetting(componentName, i, 1);
        }
    }
}

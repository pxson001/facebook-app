package com.facebook.vault.service;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.alarm.FbAlarmManager;
import com.facebook.common.alarm.FbAlarmManagerImpl;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.init.INeedInit;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ThreadInitDetour;
import com.facebook.vault.prefs.BlacklistedSyncPathsPref;
import com.facebook.vault.prefs.SyncModePref;
import com.facebook.vault.prefs.VaultPrefKeys;
import com.google.common.util.concurrent.Futures;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: legacy_thread_id */
public class VaultManager implements IHaveUserData, INeedInit {
    private static final Class<?> f9410a = VaultManager.class;
    private static volatile VaultManager f9411p;
    public final Context f9412b;
    private final VaultLogger f9413c;
    private final DefaultBlueServiceOperationFactory f9414d;
    private final SyncModePref f9415e;
    public final BlacklistedSyncPathsPref f9416f;
    public final VaultHelpers f9417g;
    public final FbAlarmManagerImpl f9418h;
    public final AbstractFbErrorReporter f9419i;
    private final VaultConnectivityChangeHelper f9420j;
    private final Lazy<VaultDeviceSetup> f9421k;
    private final Lazy<VaultNotificationManager> f9422l;
    public final Lazy<VaultTable> f9423m;
    private final Product f9424n;
    private boolean f9425o = false;

    public static com.facebook.vault.service.VaultManager m9796a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9411p;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.vault.service.VaultManager.class;
        monitor-enter(r1);
        r0 = f9411p;	 Catch:{ all -> 0x003a }
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
        r0 = m9797b(r0);	 Catch:{ all -> 0x0035 }
        f9411p = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9411p;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.vault.service.VaultManager.a(com.facebook.inject.InjectorLike):com.facebook.vault.service.VaultManager");
    }

    private static VaultManager m9797b(InjectorLike injectorLike) {
        return new VaultManager((Context) injectorLike.getInstance(Context.class), DefaultBlueServiceOperationFactory.b(injectorLike), SyncModePref.m9802a(injectorLike), BlacklistedSyncPathsPref.m9806a(injectorLike), VaultHelpers.m9810b(injectorLike), VaultLogger.m9823c(injectorLike), FbAlarmManagerImpl.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), VaultConnectivityChangeHelper.m9852a(injectorLike), IdBasedLazy.a(injectorLike, 3625), IdBasedSingletonScopeProvider.b(injectorLike, 3631), IdBasedSingletonScopeProvider.b(injectorLike, 3633), ProductMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public VaultManager(Context context, BlueServiceOperationFactory blueServiceOperationFactory, SyncModePref syncModePref, BlacklistedSyncPathsPref blacklistedSyncPathsPref, VaultHelpers vaultHelpers, VaultLogger vaultLogger, FbAlarmManager fbAlarmManager, FbErrorReporter fbErrorReporter, VaultConnectivityChangeHelper vaultConnectivityChangeHelper, Lazy<VaultDeviceSetup> lazy, Lazy<VaultNotificationManager> lazy2, Lazy<VaultTable> lazy3, Product product) {
        this.f9412b = context;
        this.f9414d = blueServiceOperationFactory;
        this.f9415e = syncModePref;
        this.f9416f = blacklistedSyncPathsPref;
        this.f9417g = vaultHelpers;
        this.f9413c = vaultLogger;
        this.f9418h = fbAlarmManager;
        this.f9419i = fbErrorReporter;
        this.f9420j = vaultConnectivityChangeHelper;
        this.f9421k = lazy;
        this.f9422l = lazy2;
        this.f9423m = lazy3;
        this.f9424n = product;
    }

    public void init() {
        if (this.f9424n == Product.FB4A && VERSION.SDK_INT <= 22) {
            if (this.f9425o) {
                if (this.f9417g.m9814b()) {
                    m9801b();
                }
            } else if (this.f9417g.m9811a()) {
                Intent intent = new Intent(this.f9412b, VaultManagerService.class);
                intent.putExtra(VaultManagerService.f11511a, 1);
                this.f9412b.startService(intent);
                this.f9425o = true;
            }
            if (this.f9417g.m9814b()) {
                this.f9420j.m9855a();
            } else {
                this.f9420j.m9856b();
            }
        }
    }

    public final void m9800a() {
        String a = this.f9415e.m9804a();
        new StringBuilder("sync mode changed to: ").append(a);
        this.f9413c.m9831b(a);
        if (this.f9417g.m9814b()) {
            this.f9420j.m9855a();
            Intent intent = new Intent(this.f9412b, VaultManagerService.class);
            intent.putExtra(VaultManagerService.f11511a, 2);
            this.f9412b.startService(intent);
            return;
        }
        this.f9420j.m9856b();
        if (((VaultDeviceSetup) this.f9421k.get()).m12016a()) {
            this.f9412b.startService(new Intent(this.f9412b, VaultUpdateService.class));
        }
        m9799f();
    }

    public final void m9801b() {
        Object obj;
        BlacklistedSyncPathsPref blacklistedSyncPathsPref = this.f9416f;
        if (blacklistedSyncPathsPref.f9431c.a() - blacklistedSyncPathsPref.f9429a.a(VaultPrefKeys.f11556k, 0) > 604800000) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            Futures.a(BlueServiceOperationFactoryDetour.a(this.f9414d, "fetch_blacklisted_sync_paths", new Bundle(), 617096061).c(), new 1(this));
        } else {
            m9798e(this);
        }
    }

    public static void m9798e(VaultManager vaultManager) {
        vaultManager.f9412b.startService(new Intent(vaultManager.f9412b, VaultObserverService.class));
    }

    private void m9799f() {
        this.f9412b.stopService(new Intent(this.f9412b, VaultObserverService.class));
        this.f9412b.stopService(new Intent(this.f9412b, VaultSyncService.class));
        this.f9412b.stopService(new Intent(this.f9412b, VaultSyncJobProcessor.class));
        PendingIntent service = PendingIntent.getService(this.f9412b, 0, this.f9417g.m9813b(3), 536870912);
        if (service != null) {
            service.cancel();
            this.f9418h.a(service);
        }
        ThreadInitDetour.a(new 2(this), -2000693261).start();
        if (((VaultNotificationManager) this.f9422l.get()).m12110e() != "end_vault_upload") {
            ((VaultNotificationManager) this.f9422l.get()).m12108c();
        }
        this.f9420j.m9856b();
    }

    public void clearUserData() {
        this.f9425o = false;
        m9799f();
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f9412b.getSystemService("activity")).getRunningAppProcesses();
        String str = this.f9412b.getPackageName() + ":vault";
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(str)) {
                Process.killProcess(runningAppProcessInfo.pid);
            }
        }
    }
}

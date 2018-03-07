package com.facebook.push.crossapp;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.init.INeedInit;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.content.ActionReceiver;
import com.facebook.content.AppInfo;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: lockscreen_notification_dropped */
public class PendingReportedPackages implements INeedInit {
    private static final Class<?> f9077a = PendingReportedPackages.class;
    public static final PrefKey f9078b = ((PrefKey) SharedPrefKeys.c.a("package_removed_for_fbns/"));
    private static volatile PendingReportedPackages f9079i;
    private final boolean f9080c = PackageRemovedReceiverInitializer.m9419a(this.f9081d.getPackageName());
    private final Context f9081d;
    public final FbSharedPreferences f9082e;
    private final BaseFbBroadcastManager f9083f;
    private final FbNetworkManager f9084g;
    private final AppInfo f9085h;

    /* compiled from: lockscreen_notification_dropped */
    class C05441 implements ActionReceiver {
        final /* synthetic */ PendingReportedPackages f11238a;

        C05441(PendingReportedPackages pendingReportedPackages) {
            this.f11238a = pendingReportedPackages;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -671144207);
            PendingReportedPackages.m9422a(this.f11238a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 935263279, a);
        }
    }

    public static com.facebook.push.crossapp.PendingReportedPackages m9421a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9079i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.crossapp.PendingReportedPackages.class;
        monitor-enter(r1);
        r0 = f9079i;	 Catch:{ all -> 0x003a }
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
        r0 = m9423b(r0);	 Catch:{ all -> 0x0035 }
        f9079i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9079i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.crossapp.PendingReportedPackages.a(com.facebook.inject.InjectorLike):com.facebook.push.crossapp.PendingReportedPackages");
    }

    private static PendingReportedPackages m9423b(InjectorLike injectorLike) {
        return new PendingReportedPackages((Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), FbNetworkManager.a(injectorLike), AppInfo.a(injectorLike));
    }

    @Inject
    public PendingReportedPackages(Context context, FbSharedPreferences fbSharedPreferences, BaseFbBroadcastManager baseFbBroadcastManager, FbNetworkManager fbNetworkManager, AppInfo appInfo) {
        this.f9081d = context;
        this.f9082e = fbSharedPreferences;
        this.f9083f = baseFbBroadcastManager;
        this.f9084g = fbNetworkManager;
        this.f9085h = appInfo;
    }

    public final void m9424b(String str) {
        this.f9082e.edit().a((PrefKey) f9078b.a(str)).commit();
    }

    public void init() {
        if (this.f9080c) {
            this.f9083f.a().a(AppStateManager.b, new C05441(this)).a().b();
            m9422a(this);
        }
    }

    public static void m9422a(PendingReportedPackages pendingReportedPackages) {
        if (pendingReportedPackages.f9084g.d()) {
            Set<PrefKey> d = pendingReportedPackages.f9082e.d(f9078b);
            if (!d.isEmpty()) {
                for (PrefKey b : d) {
                    String b2 = b.b(f9078b);
                    if (pendingReportedPackages.f9085h.c(b2, 0) != null) {
                        pendingReportedPackages.m9424b(b2);
                    } else {
                        PackageRemovedReporterService.a(pendingReportedPackages.f9081d, b2, "retry");
                    }
                }
            }
        }
    }
}

package com.facebook.push.crossapp;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.push.analytics.PushNotifAnalyticsLogger;
import com.facebook.push.analytics.PushServerUnregistrationClientEvent;
import com.facebook.push.fbpushtoken.ReportAppDeletionParams;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: hotspotUpdate */
public class PackageRemovedReporter {
    public static final Class<?> f11246a = PackageRemovedReporter.class;
    private static volatile PackageRemovedReporter f11247g;
    public final DefaultBlueServiceOperationFactory f11248b;
    @DefaultExecutorService
    private final ExecutorService f11249c;
    private final UniqueIdForDeviceHolderImpl f11250d;
    public final PushNotifAnalyticsLogger f11251e;
    public final PendingReportedPackages f11252f;

    public static com.facebook.push.crossapp.PackageRemovedReporter m13152a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f11247g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.crossapp.PackageRemovedReporter.class;
        monitor-enter(r1);
        r0 = f11247g;	 Catch:{ all -> 0x003a }
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
        r0 = m13153b(r0);	 Catch:{ all -> 0x0035 }
        f11247g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11247g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.crossapp.PackageRemovedReporter.a(com.facebook.inject.InjectorLike):com.facebook.push.crossapp.PackageRemovedReporter");
    }

    private static PackageRemovedReporter m13153b(InjectorLike injectorLike) {
        return new PackageRemovedReporter(DefaultBlueServiceOperationFactory.b(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), UniqueIdForDeviceHolderMethodAutoProvider.b(injectorLike), PushNotifAnalyticsLogger.a(injectorLike), PendingReportedPackages.a(injectorLike));
    }

    @Inject
    public PackageRemovedReporter(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, ExecutorService executorService, UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl, PushNotifAnalyticsLogger pushNotifAnalyticsLogger, PendingReportedPackages pendingReportedPackages) {
        this.f11248b = defaultBlueServiceOperationFactory;
        this.f11249c = executorService;
        this.f11250d = uniqueIdForDeviceHolderImpl;
        this.f11251e = pushNotifAnalyticsLogger;
        this.f11252f = pendingReportedPackages;
    }

    public final Future<Void> m13154a(final String str, final String str2) {
        this.f11252f.e.edit().putBoolean((PrefKey) PendingReportedPackages.b.a(str), true).commit();
        Parcelable reportAppDeletionParams = new ReportAppDeletionParams(str, this.f11250d.a());
        final Bundle bundle = new Bundle();
        bundle.putParcelable("reportAppDeletionParams", reportAppDeletionParams);
        return ExecutorDetour.a(this.f11249c, new Callable<Void>(this) {
            final /* synthetic */ PackageRemovedReporter f11245d;

            public Object call() {
                try {
                    FutureDetour.a(BlueServiceOperationFactoryDetour.a(this.f11245d.f11248b, "report_app_deletion", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(PackageRemovedReporter.class), 1184611713).a(), 90210387);
                    this.f11245d.f11252f.b(str);
                    this.f11245d.f11251e.c(str, PushServerUnregistrationClientEvent.SUCCESS.name(), str2);
                } catch (Throwable th) {
                    BLog.b(PackageRemovedReporter.f11246a, th, "Report package:%s failed", new Object[]{str});
                    this.f11245d.f11251e.c(str, PushServerUnregistrationClientEvent.FAILED.name(), str2);
                }
                return null;
            }
        }, 326582914);
    }
}

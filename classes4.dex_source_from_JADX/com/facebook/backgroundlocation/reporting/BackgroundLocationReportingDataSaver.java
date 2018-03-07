package com.facebook.backgroundlocation.reporting;

import android.content.Context;
import android.content.Intent;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.backgroundtasks.RadioBasedBackgroundTaskRunner;
import com.facebook.content.FacebookOnlyIntentActionFactory;
import com.facebook.content.SecurePendingIntent;
import com.facebook.inject.InjectorLike;
import com.facebook.location.LocationComparisonUtil;
import com.facebook.location.LocationSignalDataPackage;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: i2o_rtt */
public class BackgroundLocationReportingDataSaver implements IHaveUserData {
    private static volatile BackgroundLocationReportingDataSaver f10560j;
    private final Context f10561a;
    private final FacebookOnlyIntentActionFactory f10562b;
    private final RadioBasedBackgroundTaskRunner f10563c;
    private final BackgroundLocationReportingNewImplAnalyticsLogger f10564d;
    private final Object f10565e = new Object();
    @GuardedBy("mLock")
    private final List<LocationSignalDataPackage> f10566f = new LinkedList();
    @GuardedBy("mLock")
    @Nullable
    private LocationSignalDataPackage f10567g;
    @GuardedBy("mLock")
    private final List<String> f10568h = new LinkedList();
    private final Runnable f10569i = new C04821(this);

    /* compiled from: i2o_rtt */
    class C04821 implements Runnable {
        final /* synthetic */ BackgroundLocationReportingDataSaver f10576a;

        C04821(BackgroundLocationReportingDataSaver backgroundLocationReportingDataSaver) {
            this.f10576a = backgroundLocationReportingDataSaver;
        }

        public void run() {
            BackgroundLocationReportingDataSaver.m11098a(this.f10576a);
        }
    }

    public static com.facebook.backgroundlocation.reporting.BackgroundLocationReportingDataSaver m11097a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10560j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backgroundlocation.reporting.BackgroundLocationReportingDataSaver.class;
        monitor-enter(r1);
        r0 = f10560j;	 Catch:{ all -> 0x003a }
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
        r0 = m11099b(r0);	 Catch:{ all -> 0x0035 }
        f10560j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10560j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backgroundlocation.reporting.BackgroundLocationReportingDataSaver.a(com.facebook.inject.InjectorLike):com.facebook.backgroundlocation.reporting.BackgroundLocationReportingDataSaver");
    }

    private static BackgroundLocationReportingDataSaver m11099b(InjectorLike injectorLike) {
        return new BackgroundLocationReportingDataSaver((Context) injectorLike.getInstance(Context.class), FacebookOnlyIntentActionFactory.a(injectorLike), RadioBasedBackgroundTaskRunner.m11103a(injectorLike), BackgroundLocationReportingNewImplAnalyticsLogger.m10133a(injectorLike));
    }

    @Inject
    public BackgroundLocationReportingDataSaver(Context context, FacebookOnlyIntentActionFactory facebookOnlyIntentActionFactory, RadioBasedBackgroundTaskRunner radioBasedBackgroundTaskRunner, BackgroundLocationReportingNewImplAnalyticsLogger backgroundLocationReportingNewImplAnalyticsLogger) {
        this.f10561a = context;
        this.f10562b = facebookOnlyIntentActionFactory;
        this.f10563c = radioBasedBackgroundTaskRunner;
        this.f10564d = backgroundLocationReportingNewImplAnalyticsLogger;
    }

    final void m11101a(LocationSignalDataPackage locationSignalDataPackage) {
        synchronized (this.f10565e) {
            this.f10566f.add(locationSignalDataPackage);
            if (this.f10567g == null || LocationComparisonUtil.b(this.f10567g.a, locationSignalDataPackage.a) >= 840000) {
                m11098a(this);
            } else if (this.f10566f.size() == 1) {
                this.f10563c.m11112a(this.f10569i);
            }
        }
    }

    final void m11100a(@Nullable BackgroundLocationReportingUpdateResult backgroundLocationReportingUpdateResult, BackgroundLocationReportingUpdateParams backgroundLocationReportingUpdateParams) {
        if (backgroundLocationReportingUpdateResult == null || !backgroundLocationReportingUpdateResult.a) {
            this.f10564d.m10138a(backgroundLocationReportingUpdateResult, backgroundLocationReportingUpdateResult == null ? "No response from location update is available" : "The update did not succeed", null, "background_location_reporting_data_saver");
        } else {
            this.f10564d.m10144a(null, "background_location_reporting_data_saver");
        }
        if (backgroundLocationReportingUpdateResult != null) {
            synchronized (this.f10565e) {
                this.f10567g = (LocationSignalDataPackage) Iterables.g(backgroundLocationReportingUpdateParams.a);
                ImmutableList immutableList = backgroundLocationReportingUpdateParams.a;
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    LocationSignalDataPackage locationSignalDataPackage = (LocationSignalDataPackage) immutableList.get(i);
                    Iterator it = this.f10566f.iterator();
                    while (it.hasNext()) {
                        if (((LocationSignalDataPackage) it.next()).a.g().equals(locationSignalDataPackage.a.g())) {
                            it.remove();
                        }
                    }
                }
                this.f10568h.removeAll(backgroundLocationReportingUpdateParams.b);
            }
        }
    }

    final void m11102a(@Nullable LocationSignalDataPackage locationSignalDataPackage, BackgroundLocationReportingLocationRequestParams backgroundLocationReportingLocationRequestParams) {
        if (locationSignalDataPackage == null) {
            this.f10564d.m10146b(backgroundLocationReportingLocationRequestParams);
            return;
        }
        this.f10564d.m10142a(locationSignalDataPackage.a, backgroundLocationReportingLocationRequestParams);
        synchronized (this.f10565e) {
            this.f10566f.add(locationSignalDataPackage);
            if (backgroundLocationReportingLocationRequestParams.b != null) {
                this.f10568h.add(backgroundLocationReportingLocationRequestParams.b);
            }
            if (this.f10567g == null || LocationComparisonUtil.a(this.f10567g.a, locationSignalDataPackage.a) >= backgroundLocationReportingLocationRequestParams.a) {
                m11098a(this);
            } else if (this.f10566f.size() == 1) {
                this.f10563c.m11112a(this.f10569i);
            }
        }
    }

    public void clearUserData() {
        synchronized (this.f10565e) {
            this.f10566f.clear();
            this.f10567g = null;
        }
    }

    public static void m11098a(BackgroundLocationReportingDataSaver backgroundLocationReportingDataSaver) {
        synchronized (backgroundLocationReportingDataSaver.f10565e) {
            if (backgroundLocationReportingDataSaver.f10566f.isEmpty()) {
                return;
            }
            Intent intent = new Intent();
            intent.setAction(backgroundLocationReportingDataSaver.f10562b.a("BACKGROUND_LOCATION_REPORTING_ACTION_WRITE_FINISHED"));
            BackgroundLocationReportingUpdateParams backgroundLocationReportingUpdateParams = new BackgroundLocationReportingUpdateParams(ImmutableList.copyOf(backgroundLocationReportingDataSaver.f10566f), ImmutableList.copyOf(backgroundLocationReportingDataSaver.f10568h));
            backgroundLocationReportingDataSaver.f10564d.m10137a(backgroundLocationReportingUpdateParams);
            BackgroundLocationReportingNewImplService.m10170a(backgroundLocationReportingDataSaver.f10561a, backgroundLocationReportingUpdateParams, SecurePendingIntent.m10163b(backgroundLocationReportingDataSaver.f10561a, 0, intent, 0));
        }
    }
}

package com.facebook.backgroundlocation.reporting;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import com.facebook.backgroundlocation.reporting.LocationSignalPackageDbContract.SnapshotsTable.Columns;
import com.facebook.backgroundlocation.reporting.abtest.ExperimentsForBackgroundLocationReportingModule;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.wakelock.FbWakeLockManager;
import com.facebook.common.wakelock.FbWakeLockManager.WakeLock;
import com.facebook.content.FacebookOnlyIntentActionFactory;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.location.ImmutableLocation;
import com.facebook.location.LocationSignalDataPackage;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: distance_to_last_geofence_meters */
public class BackgroundLocationReportingGcmUploadSchedulerService extends FbIntentService {
    private static final CallerContext f14866o = CallerContext.a(BackgroundLocationReportingGcmUploadSchedulerService.class);
    @Inject
    AppStateManager f14867a;
    @Inject
    BackgroundLocationReportingNewImplAnalyticsLogger f14868b;
    @Inject
    BackgroundLocationReportingNewImplManager f14869c;
    @Inject
    BackgroundLocationReportingUtils f14870d;
    @Inject
    QeAccessor f14871e;
    @Inject
    FbWakeLockManager f14872f;
    @Inject
    Lazy<GeofenceLocationTracker> f14873g;
    @Inject
    LocationSignalPackageDatabaseSupplier f14874h;
    @Inject
    Lazy<BackgroundLocationReportingDataSaver> f14875i;
    @Inject
    BackgroundLocationReportingUpdateMethod f14876j;
    @Inject
    FacebookOnlyIntentActionFactory f14877k;
    @Inject
    AbstractSingleMethodRunner f14878l;
    @Inject
    AbstractFbErrorReporter f14879m;
    @Inject
    Clock f14880n;
    private WakeLock f14881p;

    private static <T extends Context> void m15335a(Class<T> cls, T t) {
        m15336a((Object) t, (Context) t);
    }

    public static void m15336a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BackgroundLocationReportingGcmUploadSchedulerService) obj).m15333a(AppStateManager.a(injectorLike), BackgroundLocationReportingNewImplAnalyticsLogger.a(injectorLike), BackgroundLocationReportingNewImplManager.a(injectorLike), BackgroundLocationReportingUtils.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FbWakeLockManager.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 4923), LocationSignalPackageDatabaseSupplier.m15412a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 377), BackgroundLocationReportingUpdateMethod.m15355a(injectorLike), FacebookOnlyIntentActionFactory.a(injectorLike), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    public static Intent m15330a(Context context, FacebookOnlyIntentActionFactory facebookOnlyIntentActionFactory, ImmutableLocation immutableLocation) {
        return new Intent(context, BackgroundLocationReportingGcmUploadSchedulerService.class).setPackage(context.getPackageName()).setAction(facebookOnlyIntentActionFactory.a("BACKGROUND_LOCATION_REPORTING_ACTION_LOCATION_UPDATE_FROM_LOCATION_PROVIDER")).putExtra("fb_location", immutableLocation);
    }

    public static Intent m15331a(Context context, FacebookOnlyIntentActionFactory facebookOnlyIntentActionFactory, LocationSignalDataPackage locationSignalDataPackage) {
        return new Intent().setPackage(context.getPackageName()).setClass(context, BackgroundLocationReportingGcmUploadSchedulerService.class).setAction(facebookOnlyIntentActionFactory.a("BACKGROUND_LOCATION_REPORTING_ACTION_SCHEDULE_LOCATION_UPLOAD")).putExtra("location_signal_data_package", locationSignalDataPackage);
    }

    public static Intent m15332a(Context context, FacebookOnlyIntentActionFactory facebookOnlyIntentActionFactory, String str) {
        return new Intent().setPackage(context.getPackageName()).setClass(context, BackgroundLocationReportingGcmUploadSchedulerService.class).setAction(facebookOnlyIntentActionFactory.a("BACKGROUND_LOCATION_REPORTING_ACTION_UPLOAD_LOCATION")).putExtra("task_tag", str);
    }

    private void m15333a(AppStateManager appStateManager, BackgroundLocationReportingNewImplAnalyticsLogger backgroundLocationReportingNewImplAnalyticsLogger, BackgroundLocationReportingNewImplManager backgroundLocationReportingNewImplManager, BackgroundLocationReportingUtils backgroundLocationReportingUtils, QeAccessor qeAccessor, FbWakeLockManager fbWakeLockManager, Lazy<GeofenceLocationTracker> lazy, LocationSignalPackageDatabaseSupplier locationSignalPackageDatabaseSupplier, Lazy<BackgroundLocationReportingDataSaver> lazy2, BackgroundLocationReportingUpdateMethod backgroundLocationReportingUpdateMethod, FacebookOnlyIntentActionFactory facebookOnlyIntentActionFactory, SingleMethodRunner singleMethodRunner, FbErrorReporter fbErrorReporter, Clock clock) {
        this.f14867a = appStateManager;
        this.f14868b = backgroundLocationReportingNewImplAnalyticsLogger;
        this.f14869c = backgroundLocationReportingNewImplManager;
        this.f14870d = backgroundLocationReportingUtils;
        this.f14871e = qeAccessor;
        this.f14872f = fbWakeLockManager;
        this.f14873g = lazy;
        this.f14874h = locationSignalPackageDatabaseSupplier;
        this.f14875i = lazy2;
        this.f14876j = backgroundLocationReportingUpdateMethod;
        this.f14877k = facebookOnlyIntentActionFactory;
        this.f14878l = singleMethodRunner;
        this.f14879m = fbErrorReporter;
        this.f14880n = clock;
    }

    public BackgroundLocationReportingGcmUploadSchedulerService() {
        super("bglr-gcm-scheduler");
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 1043710923);
        super.onCreate();
        Class cls = BackgroundLocationReportingGcmUploadSchedulerService.class;
        m15336a((Object) this, (Context) this);
        this.f14881p = this.f14872f.a(1, "bglr-gcm-scheduler");
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 946010967, a);
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -910863763);
        super.onDestroy();
        this.f14872f.a(this.f14881p);
        this.f14881p = null;
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -1640919354, a);
    }

    protected final void m15343a(Intent intent) {
        this.f14881p.c();
        try {
            m15339b(intent);
        } finally {
            this.f14881p.d();
        }
    }

    private void m15339b(Intent intent) {
        if (intent == null) {
            this.f14879m.a("bglr-gcm-scheduler", "intent is null");
            return;
        }
        String action = intent.getAction();
        if (action.endsWith("BACKGROUND_LOCATION_REPORTING_ACTION_LOCATION_UPDATE_FROM_LOCATION_PROVIDER")) {
            m15341d(intent);
        } else if (action.endsWith("BACKGROUND_LOCATION_REPORTING_ACTION_UPLOAD_LOCATION")) {
            m15342e(intent);
        } else if (action.endsWith("BACKGROUND_LOCATION_REPORTING_ACTION_SCHEDULE_LOCATION_UPLOAD")) {
            m15340c(intent);
        }
    }

    private void m15340c(Intent intent) {
        LocationSignalDataPackage locationSignalDataPackage = (LocationSignalDataPackage) intent.getParcelableExtra("location_signal_data_package");
        if (locationSignalDataPackage == null) {
            this.f14879m.a("bglr-gcm-scheduler", "intent does not contain location signal data package");
        } else {
            m15334a(locationSignalDataPackage);
        }
    }

    private void m15341d(Intent intent) {
        this.f14869c.b();
        ImmutableLocation immutableLocation = (ImmutableLocation) intent.getParcelableExtra("fb_location");
        if (immutableLocation == null) {
            this.f14879m.a("bglr-gcm-scheduler", "location should not be null");
            return;
        }
        LocationSignalDataPackage locationSignalDataPackage = new LocationSignalDataPackage(immutableLocation, Boolean.valueOf(this.f14867a.l()), this.f14870d.a(), this.f14870d.b(), null, null);
        if (this.f14871e.a(ExperimentsForBackgroundLocationReportingModule.k, false)) {
            ((GeofenceLocationTracker) this.f14873g.get()).m15410a(locationSignalDataPackage.a);
        }
        m15334a(locationSignalDataPackage);
    }

    private void m15334a(LocationSignalDataPackage locationSignalDataPackage) {
        ContentValues contentValues = new ContentValues();
        Parcel obtain = Parcel.obtain();
        try {
            long a;
            obtain.writeParcelable(locationSignalDataPackage, 0);
            contentValues.put(Columns.f14982a.a(), obtain.marshall());
            String a2 = Columns.f14983b.a();
            if (locationSignalDataPackage.a == null || !locationSignalDataPackage.a.g().isPresent()) {
                a = this.f14880n.a();
            } else {
                a = ((Long) locationSignalDataPackage.a.g().get()).longValue();
            }
            contentValues.put(a2, Long.valueOf(a));
            SQLiteDatabase a3 = this.f14874h.a();
            try {
                SQLiteDetour.a(-848953020);
                a3.insertOrThrow("snapshots", null, contentValues);
                SQLiteDetour.a(-1736733616);
                BackgroundLocationReportingGcmUploadService.m15344a(this, 0, this.f14871e.a(ExperimentsForBackgroundLocationReportingModule.d, 30));
            } catch (SQLException e) {
                this.f14868b.a(e);
                ((BackgroundLocationReportingDataSaver) this.f14875i.get()).a(locationSignalDataPackage);
            }
        } finally {
            obtain.recycle();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m15342e(android.content.Intent r15) {
        /*
        r14 = this;
        r8 = 0;
        r2 = 0;
        r0 = "task_tag";
        r9 = r15.getStringExtra(r0);
        r10 = com.google.common.collect.ImmutableList.builder();
        r11 = com.google.common.collect.ImmutableList.builder();
        r0 = r14.f14874h;
        r0 = r0.a();
        r1 = "snapshots";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = com.facebook.backgroundlocation.reporting.LocationSignalPackageDbContract.SnapshotsTable.Columns.f14983b;
        r4 = r4.a();
        r3 = r3.append(r4);
        r4 = " ASC";
        r3 = r3.append(r4);
        r7 = r3.toString();
        r3 = r2;
        r4 = r2;
        r5 = r2;
        r6 = r2;
        r3 = r0.query(r1, r2, r3, r4, r5, r6, r7);
        r1 = r3.getCount();	 Catch:{ all -> 0x007c }
        if (r1 != 0) goto L_0x0043;
    L_0x003f:
        r3.close();
    L_0x0042:
        return;
    L_0x0043:
        r1 = r3.moveToNext();	 Catch:{  }
        if (r1 == 0) goto L_0x0090;
    L_0x0049:
        r4 = android.os.Parcel.obtain();	 Catch:{  }
        r1 = com.facebook.backgroundlocation.reporting.LocationSignalPackageDbContract.SnapshotsTable.Columns.f14982a;	 Catch:{ Exception -> 0x0081 }
        r1 = r1.e(r3);	 Catch:{ Exception -> 0x0081 }
        r5 = com.facebook.backgroundlocation.reporting.LocationSignalPackageDbContract.SnapshotsTable.Columns.f14983b;	 Catch:{ Exception -> 0x0081 }
        r6 = r5.c(r3);	 Catch:{ Exception -> 0x0081 }
        r5 = 0;
        r12 = r1.length;	 Catch:{ Exception -> 0x0081 }
        r4.unmarshall(r1, r5, r12);	 Catch:{ Exception -> 0x0081 }
        r1 = 0;
        r4.setDataPosition(r1);	 Catch:{ Exception -> 0x0081 }
        r1 = com.facebook.location.LocationSignalDataPackage.class;
        r1 = r1.getClassLoader();	 Catch:{ Exception -> 0x0081 }
        r1 = r4.readParcelable(r1);	 Catch:{ Exception -> 0x0081 }
        r1 = (com.facebook.location.LocationSignalDataPackage) r1;	 Catch:{ Exception -> 0x0081 }
        r10.c(r1);	 Catch:{ Exception -> 0x0081 }
        r1 = java.lang.Long.valueOf(r6);	 Catch:{ Exception -> 0x0081 }
        r11.c(r1);	 Catch:{ Exception -> 0x0081 }
        r4.recycle();	 Catch:{  }
        goto L_0x0043;
    L_0x007c:
        r0 = move-exception;
        r3.close();
        throw r0;
    L_0x0081:
        r1 = move-exception;
        r5 = r14.f14868b;	 Catch:{ all -> 0x008b }
        r5.a(r1);	 Catch:{ all -> 0x008b }
        r4.recycle();	 Catch:{  }
        goto L_0x0043;
    L_0x008b:
        r0 = move-exception;
        r4.recycle();	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0090:
        r3.close();
        r4 = r10.b();
        r5 = r11.b();
        r1 = r4.isEmpty();
        if (r1 == 0) goto L_0x00a7;
    L_0x00a1:
        r1 = "snapshots";
        r0.delete(r1, r2, r2);
        goto L_0x0042;
    L_0x00a7:
        r1 = r14.f14871e;
        r2 = com.facebook.backgroundlocation.reporting.abtest.ExperimentsForBackgroundLocationReportingModule.c;
        r3 = 20;
        r6 = r1.a(r2, r3);
        r7 = r4.size();
        r3 = r8;
    L_0x00b6:
        if (r3 >= r7) goto L_0x0042;
    L_0x00b8:
        r1 = r3 + r6;
        r1 = java.lang.Math.min(r7, r1);
        r2 = r1;
    L_0x00bf:
        if (r2 >= r7) goto L_0x00d7;
    L_0x00c1:
        r1 = r2 + -1;
        r1 = r5.get(r1);
        r1 = (java.lang.Long) r1;
        r10 = r5.get(r2);
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x00d7;
    L_0x00d3:
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x00bf;
    L_0x00d7:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r9);
        r10 = "_";
        r1 = r1.append(r10);
        r1 = r1.append(r3);
        r10 = "_";
        r1 = r1.append(r10);
        r1 = r1.append(r2);
        r10 = "_";
        r1 = r1.append(r10);
        r1 = r1.append(r7);
        r1 = r1.toString();
        r3 = r4.subList(r3, r2);
        r1 = r14.m15337a(r1, r3);
        if (r1 == 0) goto L_0x0042;
    L_0x010c:
        r3 = "snapshots";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r10 = com.facebook.backgroundlocation.reporting.LocationSignalPackageDbContract.SnapshotsTable.Columns.f14983b;
        r10 = r10.a();
        r1 = r1.append(r10);
        r10 = " <= ?";
        r1 = r1.append(r10);
        r10 = r1.toString();
        r1 = 1;
        r11 = new java.lang.String[r1];
        r1 = r2 + -1;
        r1 = r5.get(r1);
        r1 = (java.lang.Long) r1;
        r12 = r1.longValue();
        r1 = java.lang.Long.toString(r12);
        r11[r8] = r1;
        r0.delete(r3, r10, r11);
        r3 = r2;
        goto L_0x00b6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backgroundlocation.reporting.BackgroundLocationReportingGcmUploadSchedulerService.e(android.content.Intent):void");
    }

    private boolean m15337a(String str, ImmutableList<LocationSignalDataPackage> immutableList) {
        BackgroundLocationReportingUpdateParams backgroundLocationReportingUpdateParams = new BackgroundLocationReportingUpdateParams(immutableList, ImmutableList.of(str));
        this.f14868b.a(backgroundLocationReportingUpdateParams);
        try {
            BackgroundLocationReportingUpdateResult backgroundLocationReportingUpdateResult = (BackgroundLocationReportingUpdateResult) this.f14878l.a(this.f14876j, backgroundLocationReportingUpdateParams, f14866o);
            if (backgroundLocationReportingUpdateResult == null) {
                this.f14868b.a(null, "No response from location update is available", str, "bglr-gcm-scheduler");
                return false;
            }
            if (backgroundLocationReportingUpdateResult.f14902a) {
                this.f14868b.a(str, "bglr-gcm-scheduler");
            } else {
                this.f14868b.a(backgroundLocationReportingUpdateResult, "The update did not succeed", str, "bglr-gcm-scheduler");
            }
            if (!backgroundLocationReportingUpdateResult.f14903b) {
                m15338b();
            }
            return true;
        } catch (Exception e) {
            this.f14868b.a(null, e.getMessage(), str, "bglr-gcm-scheduler");
            return false;
        }
    }

    private void m15338b() {
        Intent intent = new Intent(this.f14877k.a("BACKGROUND_LOCATION_REPORTING_SETTINGS_REQUEST_REFRESH_ACTION"));
        intent.putExtra("expected_location_history_setting", false);
        sendBroadcast(intent);
    }
}

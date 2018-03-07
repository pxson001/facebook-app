package com.facebook.backgroundlocation.reporting;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Parcel;
import com.facebook.backgroundlocation.reporting.abtest.ExperimentsForBackgroundLocationReportingModule;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.SecurePendingIntent;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.location.ImmutableLocation;
import com.facebook.location.ImmutableLocation.Builder;
import com.facebook.location.LocationSignalDataPackage;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.internal.ParcelableGeofence;
import com.google.android.gms.location.internal.zzo;
import com.google.common.base.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: dialtone_info_screen */
public class GeofenceLocationTracker {
    static final String f14955a = GeofenceLocationTracker.class.getSimpleName();
    static final PrefKey f14956b;
    static final PrefKey f14957c;
    static final PrefKey f14958d;
    static final PrefKey f14959e = ((PrefKey) f14957c.a("longitude"));
    static final PrefKey f14960f = ((PrefKey) f14957c.a("accuracy_meters"));
    static final PrefKey f14961g = ((PrefKey) f14957c.a("altitude_meters"));
    static final PrefKey f14962h = ((PrefKey) f14957c.a("speed_meters_per_sec"));
    static final PrefKey f14963i = ((PrefKey) f14957c.a("bearing_degrees"));
    static final PrefKey f14964j = ((PrefKey) f14957c.a("elapsed_time_since_boot_ms"));
    static final PrefKey f14965k = ((PrefKey) f14957c.a("timestamp_ms"));
    static final PrefKey f14966l = ((PrefKey) f14957c.a("age_ms"));
    static final PrefKey f14967m = ((PrefKey) f14957c.a("radius_meters"));
    private static volatile GeofenceLocationTracker f14968z;
    private final float[] f14969n = new float[1];
    private final Context f14970o;
    private final FbSharedPreferences f14971p;
    private final PendingIntent f14972q;
    private final Clock f14973r;
    private final MonotonicClock f14974s;
    private final AbstractFbErrorReporter f14975t;
    private final GeofenceAnalyticsLogger f14976u;
    private final BackgroundLocationReportingDataSaver f14977v;
    private final GcmLocationUploadScheduler f14978w;
    private final QeAccessor f14979x;
    private final AppStateManager f14980y;

    /* compiled from: dialtone_info_screen */
    public class GeofenceLocationMonitorService extends FbIntentService {
        private static final String f14952c = GeofenceLocationMonitorService.class.getSimpleName();
        @Inject
        GeofenceLocationTracker f14953a;
        @Inject
        GeofenceAnalyticsLogger f14954b;

        private static <T extends Context> void m15402a(Class<T> cls, T t) {
            m15403a((Object) t, (Context) t);
        }

        public static void m15403a(Object obj, Context context) {
            InjectorLike injectorLike = FbInjector.get(context);
            ((GeofenceLocationMonitorService) obj).m15401a(GeofenceLocationTracker.m15405a(injectorLike), GeofenceAnalyticsLogger.m15377a(injectorLike));
        }

        private void m15401a(GeofenceLocationTracker geofenceLocationTracker, GeofenceAnalyticsLogger geofenceAnalyticsLogger) {
            this.f14953a = geofenceLocationTracker;
            this.f14954b = geofenceAnalyticsLogger;
        }

        public GeofenceLocationMonitorService() {
            super(f14952c);
        }

        public void onCreate() {
            int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 1698241541);
            super.onCreate();
            Class cls = GeofenceLocationMonitorService.class;
            m15403a((Object) this, (Context) this);
            Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 409379476, a);
        }

        protected final void m15404a(Intent intent) {
            GeofencingEvent geofencingEvent;
            if (intent == null) {
                geofencingEvent = null;
            } else {
                List list;
                int intExtra = intent.getIntExtra("gms_error_code", -1);
                int i = -1;
                int intExtra2 = intent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
                if (intExtra2 != -1 && (intExtra2 == 1 || intExtra2 == 2 || intExtra2 == 4)) {
                    i = intExtra2;
                }
                int i2 = i;
                ArrayList arrayList = (ArrayList) intent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
                if (arrayList == null) {
                    list = null;
                } else {
                    ArrayList arrayList2 = new ArrayList(arrayList.size());
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        byte[] bArr = (byte[]) it.next();
                        Parcel obtain = Parcel.obtain();
                        obtain.unmarshall(bArr, 0, bArr.length);
                        obtain.setDataPosition(0);
                        ParcelableGeofence a = zzo.a(obtain);
                        obtain.recycle();
                        arrayList2.add(a);
                    }
                    Object obj = arrayList2;
                }
                geofencingEvent = new GeofencingEvent(intExtra, i2, list, (Location) intent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
            }
            GeofencingEvent geofencingEvent2 = geofencingEvent;
            if (geofencingEvent2 == null || geofencingEvent2.a()) {
                this.f14954b.m15387a(geofencingEvent2);
                this.f14953a.m15409a();
            } else if (geofencingEvent2.c() == 2) {
                this.f14953a.m15411b(ImmutableLocation.a(geofencingEvent2.d()));
            }
        }
    }

    public static com.facebook.backgroundlocation.reporting.GeofenceLocationTracker m15405a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14968z;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backgroundlocation.reporting.GeofenceLocationTracker.class;
        monitor-enter(r1);
        r0 = f14968z;	 Catch:{ all -> 0x003a }
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
        r0 = m15407b(r0);	 Catch:{ all -> 0x0035 }
        f14968z = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14968z;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backgroundlocation.reporting.GeofenceLocationTracker.a(com.facebook.inject.InjectorLike):com.facebook.backgroundlocation.reporting.GeofenceLocationTracker");
    }

    private static GeofenceLocationTracker m15407b(InjectorLike injectorLike) {
        return new GeofenceLocationTracker((Context) injectorLike.getInstance(Context.class), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (MonotonicClock) RealtimeSinceBootClockMethodAutoProvider.a(injectorLike), BackgroundLocationReportingDataSaver.a(injectorLike), GcmLocationUploadScheduler.m15374a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GeofenceAnalyticsLogger.m15377a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), AppStateManager.a(injectorLike));
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("geofence/");
        f14956b = prefKey;
        prefKey = (PrefKey) prefKey.a("last_geofence/");
        f14957c = prefKey;
        f14958d = (PrefKey) prefKey.a("latitude");
    }

    @Inject
    public GeofenceLocationTracker(Context context, Clock clock, MonotonicClock monotonicClock, BackgroundLocationReportingDataSaver backgroundLocationReportingDataSaver, GcmLocationUploadScheduler gcmLocationUploadScheduler, FbSharedPreferences fbSharedPreferences, AbstractFbErrorReporter abstractFbErrorReporter, GeofenceAnalyticsLogger geofenceAnalyticsLogger, QeAccessor qeAccessor, AppStateManager appStateManager) {
        this.f14970o = context;
        this.f14973r = clock;
        this.f14974s = monotonicClock;
        this.f14977v = backgroundLocationReportingDataSaver;
        this.f14978w = gcmLocationUploadScheduler;
        this.f14971p = fbSharedPreferences;
        this.f14972q = SecurePendingIntent.c(this.f14970o, 0, new Intent(context, GeofenceLocationMonitorService.class), 134217728);
        this.f14975t = abstractFbErrorReporter;
        this.f14976u = geofenceAnalyticsLogger;
        this.f14979x = qeAccessor;
        this.f14980y = appStateManager;
    }

    public final synchronized void m15410a(ImmutableLocation immutableLocation) {
        this.f14976u.m15381a(immutableLocation);
        if (!this.f14971p.a()) {
            this.f14975t.a(f14955a, "FbSharedPreferences is not initialized");
            this.f14976u.m15391c(immutableLocation);
        } else if (this.f14971p.a(f14964j)) {
            long now = this.f14974s.now();
            long a = this.f14973r.a();
            long a2 = this.f14971p.a(f14964j, 0);
            long a3 = this.f14971p.a(f14965k, 0);
            if (Math.abs((a - a3) - (now - a2)) > 60000) {
                this.f14976u.m15393d(immutableLocation);
                m15408c(immutableLocation);
            } else {
                long longValue = ((Long) immutableLocation.g().get()).longValue() - a3;
                if (longValue < 0) {
                    this.f14976u.m15385a(immutableLocation, longValue);
                } else {
                    Location.distanceBetween(immutableLocation.a(), immutableLocation.b(), this.f14971p.a(f14958d, 0.0d), this.f14971p.a(f14959e, 0.0d), this.f14969n);
                    float f = this.f14969n[0];
                    double a4 = (double) this.f14971p.a(f14967m, 0.0f);
                    if (((double) f) > ((double) ((Float) immutableLocation.c().get()).floatValue()) + a4) {
                        this.f14976u.m15382a(immutableLocation, f, a4);
                        m15408c(immutableLocation);
                    } else {
                        this.f14971p.edit().a(f14966l, longValue).commit();
                        if (longValue > 18000000) {
                            this.f14976u.m15390b(immutableLocation, 18000000);
                            m15408c(immutableLocation);
                        } else {
                            this.f14976u.m15395e(immutableLocation);
                        }
                    }
                }
            }
        } else {
            this.f14976u.m15389b(immutableLocation);
            m15408c(immutableLocation);
        }
    }

    final synchronized void m15411b(ImmutableLocation immutableLocation) {
        this.f14976u.m15396f(immutableLocation);
        if (this.f14971p.a(f14965k)) {
            Optional g = immutableLocation.g();
            if (g.isPresent()) {
                long longValue = ((Long) g.get()).longValue() - this.f14971p.a(f14965k, 0);
                if (longValue < 0) {
                    this.f14976u.m15392c(immutableLocation, longValue);
                } else {
                    this.f14971p.edit().a(f14966l, longValue).commit();
                    m15408c(immutableLocation);
                    this.f14976u.m15394d(immutableLocation, longValue);
                }
            } else {
                this.f14976u.m15398h(immutableLocation);
                m15408c(immutableLocation);
            }
        } else {
            this.f14976u.m15397g(immutableLocation);
            m15408c(immutableLocation);
        }
    }

    final synchronized void m15409a() {
        this.f14976u.m15380a();
        if (this.f14971p.a(f14966l)) {
            try {
                double a = this.f14971p.a(f14958d, 0.0d);
                double a2 = this.f14971p.a(f14959e, 0.0d);
                long a3 = this.f14971p.a(f14966l, 0);
                long a4 = this.f14971p.a(f14965k, 0);
                Builder b = ImmutableLocation.a(a, a2).c(a4).a(a4).b(a3 + a4).a(this.f14971p.a(f14967m, 0.0f)).b(this.f14971p.a(f14960f, 0.0f));
                if (this.f14971p.a(f14963i)) {
                    b.c(this.f14971p.a(f14963i, 0.0f));
                }
                if (this.f14971p.a(f14962h)) {
                    b.d(this.f14971p.a(f14962h, 0.0f));
                }
                if (this.f14971p.a(f14961g)) {
                    b.a(this.f14971p.a(f14961g, 0.0d));
                }
                ImmutableLocation a5 = b.a();
                m15406a(new LocationSignalDataPackage(a5, Boolean.valueOf(this.f14980y.l())));
                this.f14976u.m15399i(a5);
            } finally {
                this.f14971p.edit().b(f14957c).commit();
            }
        } else {
            this.f14976u.m15388b();
        }
    }

    private void m15406a(LocationSignalDataPackage locationSignalDataPackage) {
        if (this.f14979x.a(ExperimentsForBackgroundLocationReportingModule.j, false)) {
            GcmLocationUploadScheduler gcmLocationUploadScheduler = this.f14978w;
            gcmLocationUploadScheduler.f14947b.c(BackgroundLocationReportingGcmUploadSchedulerService.m15331a(gcmLocationUploadScheduler.f14946a, gcmLocationUploadScheduler.f14948c, locationSignalDataPackage), gcmLocationUploadScheduler.f14946a);
            return;
        }
        this.f14977v.a(locationSignalDataPackage);
    }

    private synchronized void m15408c(ImmutableLocation immutableLocation) {
        this.f14976u.m15400j(immutableLocation);
        m15409a();
        GoogleApiClient b = new GoogleApiClient.Builder(this.f14970o).a(LocationServices.a).b();
        ConnectionResult a = b.a(10, TimeUnit.SECONDS);
        if (a.b()) {
            double a2 = immutableLocation.a();
            double b2 = immutableLocation.b();
            float a3 = this.f14979x.a(ExperimentsForBackgroundLocationReportingModule.f, 100.0f);
            int a4 = this.f14979x.a(ExperimentsForBackgroundLocationReportingModule.e, 60000);
            Status status = (Status) LocationServices.c.a(b, new GeofencingRequest.Builder().a(new Geofence.Builder().a("geofence").a(a2, b2, a3).a(-1).a(2).b(a4).a()).a(), this.f14972q).a(10, TimeUnit.SECONDS);
            if (status.e()) {
                Editor a5 = this.f14971p.edit().a(f14958d, a2).a(f14959e, b2).a(f14960f, ((Float) immutableLocation.c().get()).floatValue()).a(f14964j, this.f14974s.now()).a(f14965k, this.f14973r.a()).a(f14967m, a3).a(f14966l, 0);
                Optional d = immutableLocation.d();
                if (d.isPresent()) {
                    a5.a(f14961g, ((Double) d.get()).doubleValue());
                }
                d = immutableLocation.f();
                if (d.isPresent()) {
                    a5.a(f14962h, ((Float) d.get()).floatValue());
                }
                d = immutableLocation.e();
                if (d.isPresent()) {
                    a5.a(f14963i, ((Float) d.get()).floatValue());
                }
                a5.commit();
                b.e();
                this.f14976u.m15383a(immutableLocation, a3, a4);
            } else {
                b.e();
                this.f14976u.m15384a(immutableLocation, a3, (long) a4, status);
            }
        } else {
            this.f14976u.m15386a(immutableLocation, a);
        }
    }
}

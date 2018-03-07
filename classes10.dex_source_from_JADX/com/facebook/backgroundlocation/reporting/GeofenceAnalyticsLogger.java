package com.facebook.backgroundlocation.reporting;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.location.ImmutableLocation;
import com.facebook.location.LocationAgeUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.GeofencingEvent;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: didComplete */
public class GeofenceAnalyticsLogger {
    private static volatile GeofenceAnalyticsLogger f14949c;
    private final AnalyticsLogger f14950a;
    private final LocationAgeUtil f14951b;

    public static com.facebook.backgroundlocation.reporting.GeofenceAnalyticsLogger m15377a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14949c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backgroundlocation.reporting.GeofenceAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f14949c;	 Catch:{ all -> 0x003a }
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
        r0 = m15378b(r0);	 Catch:{ all -> 0x0035 }
        f14949c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14949c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backgroundlocation.reporting.GeofenceAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.backgroundlocation.reporting.GeofenceAnalyticsLogger");
    }

    private static GeofenceAnalyticsLogger m15378b(InjectorLike injectorLike) {
        return new GeofenceAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), LocationAgeUtil.a(injectorLike));
    }

    @Inject
    public GeofenceAnalyticsLogger(AnalyticsLogger analyticsLogger, LocationAgeUtil locationAgeUtil) {
        this.f14950a = analyticsLogger;
        this.f14951b = locationAgeUtil;
    }

    public final void m15381a(ImmutableLocation immutableLocation) {
        HoneyClientEventFast c = m15379c();
        if (c.a()) {
            m15376a(c, immutableLocation).a("action", "location_update_received_start").b();
        }
    }

    public final void m15389b(ImmutableLocation immutableLocation) {
        HoneyClientEventFast c = m15379c();
        if (c.a()) {
            m15376a(c, immutableLocation).a("action", "location_update_received").a("sub_action", "geofence_was_not_set").b();
        }
    }

    public final void m15391c(ImmutableLocation immutableLocation) {
        HoneyClientEventFast c = m15379c();
        if (c.a()) {
            m15376a(c, immutableLocation).a("action", "location_update_received").a("sub_action", "shared_prefs_not_initialized").b();
        }
    }

    public final void m15393d(ImmutableLocation immutableLocation) {
        HoneyClientEventFast c = m15379c();
        if (c.a()) {
            m15376a(c, immutableLocation).a("action", "location_update_received").a("sub_action", "location_has_inconsistent_timestamp").b();
        }
    }

    public final void m15385a(ImmutableLocation immutableLocation, long j) {
        HoneyClientEventFast c = m15379c();
        if (c.a()) {
            m15376a(c, immutableLocation).a("action", "location_update_received").a("sub_action", "location_older_than_last_geofence").a("delta_wall_time_to_last_geofence_ms", j).b();
        }
    }

    public final void m15382a(ImmutableLocation immutableLocation, float f, double d) {
        HoneyClientEventFast c = m15379c();
        if (c.a()) {
            m15376a(c, immutableLocation).a("action", "location_update_received").a("sub_action", "distance_to_last_geofence_threshold_exceeded").a("distance_to_last_geofence_meters", (double) f).a("geofence_radius_meters", d).b();
        }
    }

    public final void m15390b(ImmutableLocation immutableLocation, long j) {
        HoneyClientEventFast c = m15379c();
        if (c.a()) {
            m15376a(c, immutableLocation).a("action", "location_update_received").a("sub_action", "time_threshold_to_restart_geofence_exceeded").a("time_threshold_to_restart_geofence_ms", j).b();
        }
    }

    public final void m15395e(ImmutableLocation immutableLocation) {
        HoneyClientEventFast c = m15379c();
        if (c.a()) {
            m15376a(c, immutableLocation).a("action", "location_update_received").a("sub_action", "no_need_to_request_geofence").b();
        }
    }

    public final void m15396f(ImmutableLocation immutableLocation) {
        HoneyClientEventFast c = m15379c();
        if (c.a()) {
            m15376a(c, immutableLocation).a("action", "geofence_exited_start").b();
        }
    }

    public final void m15397g(ImmutableLocation immutableLocation) {
        HoneyClientEventFast c = m15379c();
        if (c.a()) {
            m15376a(c, immutableLocation).a("action", "geofence_exited").a("sub_action", "geofence_was_not_set").b();
        }
    }

    public final void m15398h(ImmutableLocation immutableLocation) {
        HoneyClientEventFast c = m15379c();
        if (c.a()) {
            m15376a(c, immutableLocation).a("action", "geofence_exited").a("sub_action", "location_lacking_timestamp").b();
        }
    }

    public final void m15392c(ImmutableLocation immutableLocation, long j) {
        HoneyClientEventFast c = m15379c();
        if (c.a()) {
            m15376a(c, immutableLocation).a("action", "geofence_exited").a("sub_action", "location_older_than_last_geofence").a("delta_wall_time_to_last_geofence_ms", j).b();
        }
    }

    public final void m15394d(ImmutableLocation immutableLocation, long j) {
        HoneyClientEventFast c = m15379c();
        if (c.a()) {
            m15376a(c, immutableLocation).a("action", "geofence_exited").a("sub_action", "last_geofence_flushed").a("delta_wall_time_to_last_geofence_ms", j).b();
        }
    }

    public final void m15380a() {
        HoneyClientEventFast c = m15379c();
        if (c.a()) {
            c.a("action", "last_geofence_flushed_start").b();
        }
    }

    public final void m15388b() {
        HoneyClientEventFast c = m15379c();
        if (c.a()) {
            c.a("action", "last_geofence_flushed_cancel").b();
        }
    }

    public final void m15399i(ImmutableLocation immutableLocation) {
        HoneyClientEventFast c = m15379c();
        if (c.a()) {
            c = m15376a(c, immutableLocation).a("action", "last_geofence_flushed_server_request_sent");
            Optional k = immutableLocation.k();
            if (k.isPresent()) {
                c.a("geofence_radius_meters", k.get());
            }
            k = immutableLocation.i();
            if (k.isPresent()) {
                c.a("geofence_start_time_ms", k.get());
            }
            k = immutableLocation.j();
            if (k.isPresent()) {
                c.a("geofence_end_time_ms", k.get());
            }
            c.b();
        }
    }

    public final void m15400j(ImmutableLocation immutableLocation) {
        HoneyClientEventFast c = m15379c();
        if (c.a()) {
            m15376a(c, immutableLocation).a("action", "geofence_requested_start").b();
        }
    }

    public final void m15386a(ImmutableLocation immutableLocation, ConnectionResult connectionResult) {
        HoneyClientEventFast c = m15379c();
        if (c.a()) {
            m15376a(c, immutableLocation).a("action", "geofence_requested_failure").a("sub_action", "google_api_client_failed").a("api_error_code", connectionResult.c).b();
        }
    }

    public final void m15384a(ImmutableLocation immutableLocation, float f, long j, Status status) {
        HoneyClientEventFast c = m15379c();
        if (c.a()) {
            m15376a(c, immutableLocation).a("action", "geofence_requested_failure").a("sub_action", "geofence_api_request_failed").a("geofence_radius_meters", (double) f).a("geofence_notification_responsiveness_ms", j).a("api_error_code", status.g).b();
        }
    }

    public final void m15383a(ImmutableLocation immutableLocation, float f, int i) {
        HoneyClientEventFast c = m15379c();
        if (c.a()) {
            m15376a(c, immutableLocation).a("action", "geofence_requested_success").a("geofence_radius_meters", (double) f).a("geofence_notification_responsiveness_ms", i).b();
        }
    }

    public final void m15387a(@Nullable GeofencingEvent geofencingEvent) {
        HoneyClientEventFast c = m15379c();
        if (c.a()) {
            c.a("action", "geofence_error_event_received").a("api_error_code", geofencingEvent == null ? null : Integer.valueOf(geofencingEvent.a)).b();
        }
    }

    private HoneyClientEventFast m15376a(HoneyClientEventFast honeyClientEventFast, ImmutableLocation immutableLocation) {
        long a = LocationAgeUtil.a(immutableLocation, this.f14951b.a.a());
        if (a != Long.MIN_VALUE) {
            honeyClientEventFast.a("wall_clock_age_ms", a);
        }
        a = LocationAgeUtil.b(immutableLocation, this.f14951b.b.now());
        if (a != Long.MIN_VALUE) {
            honeyClientEventFast.a("since_boot_clock_age_ms", a);
        }
        Optional c = immutableLocation.c();
        if (c.isPresent()) {
            honeyClientEventFast.a("accuracy_meters", c.get());
        }
        return honeyClientEventFast;
    }

    private HoneyClientEventFast m15379c() {
        return this.f14950a.a("geofence_events", false);
    }
}

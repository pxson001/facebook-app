package com.facebook.backgroundlocation.reporting;

import android.database.SQLException;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationContinuousListenerException;
import com.facebook.location.ImmutableLocation;
import com.facebook.location.LocationAgeUtil;
import com.facebook.location.LocationSignalDataPackage;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: kMGTPE */
public class BackgroundLocationReportingNewImplAnalyticsLogger {
    private static volatile BackgroundLocationReportingNewImplAnalyticsLogger f9713g;
    public final LocationAgeUtil f9714a;
    public final AnalyticsLogger f9715b;
    private final MonotonicClock f9716c;
    private long f9717d = -1;
    private long f9718e = -1;
    private long f9719f = -1;

    /* compiled from: kMGTPE */
    public enum RefreshReason {
        FIRST,
        TIME,
        HINT
    }

    public static com.facebook.backgroundlocation.reporting.BackgroundLocationReportingNewImplAnalyticsLogger m10133a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9713g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backgroundlocation.reporting.BackgroundLocationReportingNewImplAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f9713g;	 Catch:{ all -> 0x003a }
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
        r0 = m10134b(r0);	 Catch:{ all -> 0x0035 }
        f9713g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9713g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backgroundlocation.reporting.BackgroundLocationReportingNewImplAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.backgroundlocation.reporting.BackgroundLocationReportingNewImplAnalyticsLogger");
    }

    private static BackgroundLocationReportingNewImplAnalyticsLogger m10134b(InjectorLike injectorLike) {
        return new BackgroundLocationReportingNewImplAnalyticsLogger(LocationAgeUtil.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (MonotonicClock) RealtimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BackgroundLocationReportingNewImplAnalyticsLogger(LocationAgeUtil locationAgeUtil, AnalyticsLogger analyticsLogger, MonotonicClock monotonicClock) {
        this.f9714a = locationAgeUtil;
        this.f9715b = analyticsLogger;
        this.f9716c = monotonicClock;
    }

    public final void m10135a(int i) {
        this.f9715b.a(m10132a("background_location_location_request_start").a("google_api_availability", i));
    }

    public final void m10139a(FbLocationContinuousListenerException fbLocationContinuousListenerException) {
        this.f9715b.a(m10132a("background_location_location_request_failure").a("type", fbLocationContinuousListenerException.type).a("cause", fbLocationContinuousListenerException.getCause()));
    }

    public final void m10145b() {
        this.f9715b.a(m10132a("background_location_location_request_stop"));
    }

    public final void m10140a(ImmutableLocation immutableLocation) {
        this.f9715b.a(m10131a(m10132a("background_location_location_update")).a("age_ms", this.f9714a.a(immutableLocation)).a("accuracy_meters", immutableLocation.c().get()));
        this.f9717d = this.f9716c.now();
    }

    public final void m10136a(SQLException sQLException) {
        this.f9715b.a(m10131a(m10132a("background_location_saving_location_to_storage_fail")).b("exception", sQLException.getMessage()));
    }

    public final void m10143a(Exception exception) {
        this.f9715b.a(m10131a(m10132a("background_location_loading_location_from_storage_fail")).b("exception", exception.getMessage()));
    }

    public final void m10137a(BackgroundLocationReportingUpdateParams backgroundLocationReportingUpdateParams) {
        AnalyticsLogger analyticsLogger = this.f9715b;
        HoneyClientEvent a = m10131a(m10132a("background_location_server_write_start"));
        String str = "locationPackages";
        ImmutableList<LocationSignalDataPackage> immutableList = backgroundLocationReportingUpdateParams.a;
        ArrayNode b = JsonNodeFactory.a.b();
        for (LocationSignalDataPackage locationSignalDataPackage : immutableList) {
            ObjectNode c = JsonNodeFactory.a.c();
            c.a("age_ms", this.f9714a.a(locationSignalDataPackage.a));
            c.a("accuracy_meters", (Float) locationSignalDataPackage.a.c().get());
            b.a(c);
        }
        a = a.a(str, b);
        str = "trace_ids";
        ImmutableList<String> immutableList2 = backgroundLocationReportingUpdateParams.b;
        b = JsonNodeFactory.a.b();
        for (String h : immutableList2) {
            b.h(h);
        }
        analyticsLogger.a(a.a(str, b));
        this.f9718e = this.f9716c.now();
    }

    public final void m10144a(String str, String str2) {
        this.f9715b.a(m10131a(m10132a("background_location_server_write_success").b("task_tag", str).b("uploader_name", str2)));
        this.f9719f = this.f9716c.now();
    }

    public final void m10138a(@Nullable BackgroundLocationReportingUpdateResult backgroundLocationReportingUpdateResult, String str, @Nullable String str2, String str3) {
        HoneyClientEvent b = m10132a("background_location_server_write_failure").b("failure_reason", str).b("task_tag", str2).b("uploader_name", str3);
        if (backgroundLocationReportingUpdateResult != null) {
            b.a("succeeded", backgroundLocationReportingUpdateResult.a).a("is_best_device", backgroundLocationReportingUpdateResult.c).a("is_location_history_enabled", backgroundLocationReportingUpdateResult.b);
        }
        this.f9715b.a(b);
    }

    public final void m10142a(ImmutableLocation immutableLocation, BackgroundLocationReportingLocationRequestParams backgroundLocationReportingLocationRequestParams) {
        this.f9715b.a(m10132a("background_location_obtain_single_location_success").b("trace_id", backgroundLocationReportingLocationRequestParams.b).a("age_ms", this.f9714a.a(immutableLocation)).a("accuracy_meters", immutableLocation.c().get()));
    }

    public final void m10146b(BackgroundLocationReportingLocationRequestParams backgroundLocationReportingLocationRequestParams) {
        this.f9715b.a(m10132a("background_location_obtain_single_location_failure").b("trace_id", backgroundLocationReportingLocationRequestParams.b));
    }

    public final void m10141a(ImmutableLocation immutableLocation, long j, long j2) {
        this.f9715b.a(m10132a("background_location_inconsistent_ages_between_clocks").a("wall_clock_timestamp_ms", immutableLocation.g().orNull()).a("since_boot_clock_timestamp_ns", immutableLocation.h().orNull()).a("wall_clock_now_ms", j).a("since_boot_clock_now_ms", j2));
    }

    private HoneyClientEvent m10131a(HoneyClientEvent honeyClientEvent) {
        if (this.f9717d != -1) {
            honeyClientEvent.a("last_location_update_age_ms", this.f9716c.now() - this.f9717d);
        }
        if (this.f9718e != -1) {
            honeyClientEvent.a("last_write_attempt_age_ms", this.f9716c.now() - this.f9718e);
        }
        if (this.f9719f != -1) {
            honeyClientEvent.a("last_write_success_age_ms", this.f9716c.now() - this.f9719f);
        }
        return honeyClientEvent;
    }

    public static HoneyClientEvent m10132a(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "background_location";
        return honeyClientEvent;
    }
}

package com.facebook.location.foreground;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.graphql.error.GraphQLException;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationManagerException;
import com.facebook.location.FbLocationOperationParams;
import com.facebook.location.ImmutableLocation;
import com.facebook.location.LocationAgeUtil;
import com.facebook.location.LocationSignalPackage;
import com.facebook.wifiscan.ScanResultAgeUtil;
import com.facebook.wifiscan.WifiScanOperationException;
import com.facebook.wifiscan.WifiScanOperationParams;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.base.Preconditions;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: many */
public class ForegroundLocationFrameworkAnalyticsLogger {
    private static volatile ForegroundLocationFrameworkAnalyticsLogger f15195p;
    private final AnalyticsLogger f15196a;
    private final Clock f15197b;
    private final MonotonicClock f15198c;
    private final ForegroundLocationFrameworkAnalyticsDeviceStatusEncoder f15199d;
    private long f15200e = Long.MIN_VALUE;
    public long f15201f = Long.MIN_VALUE;
    public long f15202g = Long.MIN_VALUE;
    public long f15203h = Long.MIN_VALUE;
    private int f15204i = Integer.MIN_VALUE;
    private int f15205j = Integer.MIN_VALUE;
    private int f15206k = Integer.MIN_VALUE;
    private int f15207l = Integer.MIN_VALUE;
    private int f15208m = Integer.MIN_VALUE;
    private int f15209n = Integer.MIN_VALUE;
    private int f15210o = Integer.MIN_VALUE;

    public static com.facebook.location.foreground.ForegroundLocationFrameworkAnalyticsLogger m21719a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15195p;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.location.foreground.ForegroundLocationFrameworkAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f15195p;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m21724b(r0);	 Catch:{ all -> 0x0035 }
        f15195p = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15195p;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.location.foreground.ForegroundLocationFrameworkAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.location.foreground.ForegroundLocationFrameworkAnalyticsLogger");
    }

    private static ForegroundLocationFrameworkAnalyticsLogger m21724b(InjectorLike injectorLike) {
        return new ForegroundLocationFrameworkAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), RealtimeSinceBootClockMethodAutoProvider.m6582a(injectorLike), ForegroundLocationFrameworkAnalyticsDeviceStatusEncoder.m21740a(injectorLike));
    }

    @Inject
    public ForegroundLocationFrameworkAnalyticsLogger(AnalyticsLogger analyticsLogger, Clock clock, MonotonicClock monotonicClock, ForegroundLocationFrameworkAnalyticsDeviceStatusEncoder foregroundLocationFrameworkAnalyticsDeviceStatusEncoder) {
        this.f15196a = analyticsLogger;
        this.f15197b = clock;
        this.f15198c = monotonicClock;
        this.f15199d = foregroundLocationFrameworkAnalyticsDeviceStatusEncoder;
    }

    public final void m21731a(long j) {
        m21723a(false);
        m21726b(false);
        m21728c(false);
        m21730d(false);
        this.f15200e = this.f15198c.now();
        this.f15204i = 0;
        this.f15205j = 0;
        this.f15206k = 0;
        this.f15207l = 0;
        this.f15208m = 0;
        this.f15209n = 0;
        this.f15210o = 0;
        HoneyClientEventFast a = m21718a("fgl_app_foreground");
        if (a != null) {
            a.m17382a("next_request_delay_ms", j);
            a.m17390b();
        }
    }

    public final void m21732a(FbLocationOperationParams fbLocationOperationParams, WifiScanOperationParams wifiScanOperationParams) {
        m21723a(true);
        m21726b(false);
        m21728c(false);
        m21730d(false);
        this.f15205j++;
        this.f15201f = this.f15198c.now();
        this.f15202g = this.f15201f;
        HoneyClientEventFast a = m21718a("fgl_scan_start");
        if (a != null) {
            JsonNode jsonNode;
            String str = "location_manager_params";
            if (fbLocationOperationParams == null) {
                jsonNode = null;
            } else {
                JsonNode a2 = JsonNodeFactory.f3121a.m5233c().m5137a("priority", fbLocationOperationParams.f16481a.toString()).m5130a("desired_age_ms", fbLocationOperationParams.f16482b).m5128a("desired_accuracy_meters", fbLocationOperationParams.f16483c).m5130a("timeout_ms", fbLocationOperationParams.f16484d);
                if (fbLocationOperationParams.f16485e.isPresent()) {
                    a2.m5135a("age_limit_ms", (Long) fbLocationOperationParams.f16485e.get());
                }
                if (fbLocationOperationParams.f16486f.isPresent()) {
                    a2.m5133a("accuracy_limit_meters", (Float) fbLocationOperationParams.f16486f.get());
                }
                jsonNode = a2;
            }
            a.m17383a(str, jsonNode);
            str = "wifi_scan_params";
            if (wifiScanOperationParams == null) {
                jsonNode = null;
            } else {
                jsonNode = JsonNodeFactory.f3121a.m5233c().m5130a("timeout_ms", wifiScanOperationParams.f16578a).m5130a("age_limit_ms", wifiScanOperationParams.f16579b);
            }
            a.m17383a(str, jsonNode);
            a.m17390b();
        }
    }

    public final void m21735b() {
        this.f15202g = Long.MIN_VALUE;
        this.f15201f = Long.MIN_VALUE;
    }

    public final void m21733a(@Nullable LocationSignalPackage locationSignalPackage) {
        m21723a(true);
        m21726b(true);
        m21728c(true);
        m21730d(false);
        this.f15206k++;
        HoneyClientEventFast a = m21718a("fgl_scan_fail");
        if (a != null) {
            long now = this.f15198c.now();
            long a2 = this.f15197b.mo211a();
            a.m17382a("request_duration_ms", now - this.f15201f);
            m21722a(a, locationSignalPackage, now, a2);
            a.m17390b();
        }
        this.f15202g = Long.MIN_VALUE;
        this.f15201f = Long.MIN_VALUE;
    }

    public final void m21736b(LocationSignalPackage locationSignalPackage) {
        m21723a(true);
        m21726b(true);
        m21728c(true);
        m21730d(false);
        this.f15207l++;
        HoneyClientEventFast a = m21718a("fgl_scan_success");
        if (a != null) {
            m21722a(a, locationSignalPackage, this.f15198c.now(), this.f15197b.mo211a());
            a.m17390b();
        }
        this.f15202g = Long.MIN_VALUE;
    }

    private void m21722a(HoneyClientEventFast honeyClientEventFast, @Nullable LocationSignalPackage locationSignalPackage, long j, long j2) {
        honeyClientEventFast.m17382a("scan_duration_ms", j - this.f15202g);
        if (locationSignalPackage != null) {
            JsonNode jsonNode;
            String str = "location_manager_result";
            ImmutableLocation immutableLocation = locationSignalPackage.a.a;
            if (immutableLocation == null) {
                jsonNode = null;
            } else {
                JsonNode c = JsonNodeFactory.f3121a.m5233c();
                c.m5130a("age_ms", LocationAgeUtil.m8264a(immutableLocation, j2, j));
                c.m5133a("accuracy_meters", (Float) immutableLocation.m11986c().get());
                jsonNode = c;
            }
            honeyClientEventFast.m17383a(str, jsonNode);
            honeyClientEventFast.m17383a("wifi_scan_result", m21721a(locationSignalPackage.a.d, j));
            honeyClientEventFast.m17383a("connected_wifi_result", m21720a(locationSignalPackage.a.c));
            honeyClientEventFast.m17383a("location_manager_throwable", m21725b(locationSignalPackage.b.a));
            honeyClientEventFast.m17383a("wifi_scan_throwable", m21727c(locationSignalPackage.b.b));
        }
    }

    public final void m21737c() {
        m21723a(true);
        m21726b(true);
        m21728c(false);
        m21730d(false);
        this.f15208m++;
        this.f15203h = this.f15198c.now();
        HoneyClientEventFast a = m21718a("fgl_write_start");
        if (a != null) {
            a.m17390b();
        }
    }

    public final void m21734a(Throwable th) {
        m21723a(true);
        m21726b(true);
        m21728c(false);
        m21730d(true);
        this.f15209n++;
        HoneyClientEventFast a = m21718a("fgl_write_fail");
        if (a != null) {
            long now = this.f15198c.now();
            long j = now - this.f15203h;
            now -= this.f15201f;
            a.m17382a("write_duration_ms", j);
            a.m17382a("request_duration_ms", now);
            a.m17383a("write_throwable", m21729d(th));
            a.m17390b();
        }
        this.f15203h = Long.MIN_VALUE;
        this.f15202g = Long.MIN_VALUE;
        this.f15201f = Long.MIN_VALUE;
    }

    public final void m21738e() {
        m21723a(true);
        m21726b(true);
        m21728c(false);
        m21730d(true);
        this.f15210o++;
        HoneyClientEventFast a = m21718a("fgl_write_success");
        if (a != null) {
            long now = this.f15198c.now();
            long j = now - this.f15203h;
            now -= this.f15201f;
            a.m17382a("write_duration_ms", j);
            a.m17382a("request_duration_ms", now);
            a.m17390b();
        }
        this.f15203h = Long.MIN_VALUE;
        this.f15202g = Long.MIN_VALUE;
        this.f15201f = Long.MIN_VALUE;
    }

    public final void m21739f() {
        m21723a(true);
        m21726b(false);
        m21728c(false);
        m21730d(false);
        HoneyClientEventFast a = m21718a("fgl_app_background");
        if (a != null) {
            a.m17382a("session_duration_ms", this.f15198c.now() - this.f15200e);
            a.m17381a("session_request_count", this.f15204i);
            a.m17381a("session_scan_count", this.f15205j);
            a.m17381a("session_scan_fail_count", this.f15206k);
            a.m17381a("session_scan_success_count", this.f15207l);
            a.m17381a("session_write_count", this.f15208m);
            a.m17381a("session_write_fail_count", this.f15209n);
            a.m17381a("session_write_success_count", this.f15210o);
            a.m17390b();
        }
        this.f15200e = Long.MIN_VALUE;
        this.f15204i = Integer.MIN_VALUE;
        this.f15205j = Integer.MIN_VALUE;
        this.f15206k = Integer.MIN_VALUE;
        this.f15207l = Integer.MIN_VALUE;
        this.f15208m = Integer.MIN_VALUE;
        this.f15209n = Integer.MIN_VALUE;
        this.f15210o = Integer.MIN_VALUE;
    }

    @Nullable
    private static JsonNode m21721a(@Nullable List<ScanResult> list, long j) {
        if (list == null) {
            return null;
        }
        JsonNode b = JsonNodeFactory.f3121a.m5232b();
        for (ScanResult a : list) {
            b.m13388b(ScanResultAgeUtil.m27026a(a, j));
        }
        JsonNode c = JsonNodeFactory.f3121a.m5233c();
        c.m5143c("ages_ms", b);
        return c;
    }

    @Nullable
    private static JsonNode m21720a(@Nullable WifiInfo wifiInfo) {
        if (wifiInfo == null) {
            return null;
        }
        JsonNode c = JsonNodeFactory.f3121a.m5233c();
        c.m5138a("is_connected", true);
        return c;
    }

    @Nullable
    private static JsonNode m21725b(Throwable th) {
        if (th == null) {
            return null;
        }
        JsonNode c = JsonNodeFactory.f3121a.m5233c();
        c.m5137a("class", th.getClass().getSimpleName());
        if (th instanceof FbLocationManagerException) {
            c.m5137a("location_manager_exception_type", ((FbLocationManagerException) th).type.toString());
            return c;
        } else if (!(th instanceof ExecutionException)) {
            return c;
        } else {
            c.m5137a("execution_exception_cause_class", ((ExecutionException) th).getCause().getClass().getSimpleName());
            return c;
        }
    }

    @Nullable
    private static JsonNode m21727c(Throwable th) {
        if (th == null) {
            return null;
        }
        JsonNode c = JsonNodeFactory.f3121a.m5233c();
        c.m5137a("class", th.getClass().getSimpleName());
        if (th instanceof WifiScanOperationException) {
            c.m5137a("wifi_scan_operation_exception_type", ((WifiScanOperationException) th).type.toString());
            return c;
        } else if (!(th instanceof ExecutionException)) {
            return c;
        } else {
            c.m5137a("execution_exception_cause_class", ((ExecutionException) th).getCause().getClass().getSimpleName());
            return c;
        }
    }

    private static JsonNode m21729d(Throwable th) {
        JsonNode c = JsonNodeFactory.f3121a.m5233c();
        c.m5137a("class", th.getClass().getSimpleName());
        if (th instanceof GraphQLException) {
            GraphQLException graphQLException = (GraphQLException) th;
            if (graphQLException.error != null) {
                c.m5129a("graphql_error_code", graphQLException.error.code);
            }
        } else if (th instanceof ExecutionException) {
            c.m5137a("execution_exception_cause_class", ((ExecutionException) th).getCause().getClass().getSimpleName());
        }
        return c;
    }

    private void m21723a(boolean z) {
        boolean z2;
        boolean z3 = true;
        if (this.f15200e != Long.MIN_VALUE) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 != z) {
            z3 = false;
        }
        Preconditions.checkState(z3);
    }

    private void m21726b(boolean z) {
        boolean z2;
        boolean z3 = true;
        if (this.f15201f != Long.MIN_VALUE) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 != z) {
            z3 = false;
        }
        Preconditions.checkState(z3);
    }

    private void m21728c(boolean z) {
        boolean z2;
        boolean z3 = true;
        if (this.f15202g != Long.MIN_VALUE) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 != z) {
            z3 = false;
        }
        Preconditions.checkState(z3);
    }

    private void m21730d(boolean z) {
        boolean z2;
        boolean z3 = true;
        if (this.f15203h != Long.MIN_VALUE) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 != z) {
            z3 = false;
        }
        Preconditions.checkState(z3);
    }

    @Nullable
    private HoneyClientEventFast m21718a(String str) {
        HoneyClientEventFast a = this.f15196a.mo535a(str, false);
        if (!a.m17388a()) {
            return null;
        }
        a.m17379a("foreground_location");
        a.m17383a("device_status", this.f15199d.m21743a());
        if (this.f15200e != Long.MIN_VALUE) {
            a.m17382a("session_id", this.f15200e);
        }
        if (this.f15201f == Long.MIN_VALUE) {
            return a;
        }
        a.m17382a("request_id", this.f15201f);
        return a;
    }
}

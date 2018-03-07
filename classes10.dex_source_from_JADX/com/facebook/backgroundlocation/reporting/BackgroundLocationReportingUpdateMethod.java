package com.facebook.backgroundlocation.reporting;

import com.facebook.backgroundlocation.reporting.BackgroundLocationSnapshot.Builder;
import com.facebook.backgroundlocation.reporting.BackgroundLocationSnapshot.Coordinates;
import com.facebook.backgroundlocation.reporting.BackgroundLocationSnapshot.WifiInfo;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.location.LocationAgeUtil;
import com.facebook.location.LocationSignalDataPackage;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.instagram.common.json.JsonFactoryHolder;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

@Singleton
/* compiled from: disablePullToRefresh */
public class BackgroundLocationReportingUpdateMethod implements ApiMethod<BackgroundLocationReportingUpdateParams, BackgroundLocationReportingUpdateResult> {
    private static volatile BackgroundLocationReportingUpdateMethod f14895e;
    private final Clock f14896a;
    private final MonotonicClock f14897b;
    private final UniqueIdForDeviceHolderImpl f14898c;
    private final BackgroundLocationReportingNewImplAnalyticsLogger f14899d;

    public static com.facebook.backgroundlocation.reporting.BackgroundLocationReportingUpdateMethod m15355a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14895e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backgroundlocation.reporting.BackgroundLocationReportingUpdateMethod.class;
        monitor-enter(r1);
        r0 = f14895e;	 Catch:{ all -> 0x003a }
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
        r0 = m15357b(r0);	 Catch:{ all -> 0x0035 }
        f14895e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14895e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backgroundlocation.reporting.BackgroundLocationReportingUpdateMethod.a(com.facebook.inject.InjectorLike):com.facebook.backgroundlocation.reporting.BackgroundLocationReportingUpdateMethod");
    }

    private static BackgroundLocationReportingUpdateMethod m15357b(InjectorLike injectorLike) {
        return new BackgroundLocationReportingUpdateMethod((Clock) SystemClockMethodAutoProvider.a(injectorLike), (MonotonicClock) RealtimeSinceBootClockMethodAutoProvider.a(injectorLike), UniqueIdForDeviceHolderMethodAutoProvider.b(injectorLike), BackgroundLocationReportingNewImplAnalyticsLogger.a(injectorLike));
    }

    public final ApiRequest m15359a(Object obj) {
        BackgroundLocationReportingUpdateParams backgroundLocationReportingUpdateParams = (BackgroundLocationReportingUpdateParams) obj;
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "update-background-location";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "me/locationupdates";
        newBuilder = newBuilder;
        newBuilder.g = m15358b(backgroundLocationReportingUpdateParams);
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    @Inject
    public BackgroundLocationReportingUpdateMethod(Clock clock, MonotonicClock monotonicClock, UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl, BackgroundLocationReportingNewImplAnalyticsLogger backgroundLocationReportingNewImplAnalyticsLogger) {
        this.f14896a = clock;
        this.f14897b = monotonicClock;
        this.f14898c = uniqueIdForDeviceHolderImpl;
        this.f14899d = backgroundLocationReportingNewImplAnalyticsLogger;
    }

    public final Object m15360a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        JsonNode c = apiResponse.c();
        JsonNode b = c.b("success");
        JsonNode b2 = c.b("tracking");
        JsonNode b3 = c.b("best_device");
        if (b != null && b2 != null && b3 != null && b.p() && b2.p() && b3.p()) {
            return new BackgroundLocationReportingUpdateResult(b.F(), b2.F(), b3.F());
        }
        throw new IllegalArgumentException(c.toString());
    }

    private List<NameValuePair> m15358b(BackgroundLocationReportingUpdateParams backgroundLocationReportingUpdateParams) {
        long a = this.f14896a.a();
        long now = this.f14897b.now();
        List arrayList = new ArrayList();
        ImmutableList immutableList = backgroundLocationReportingUpdateParams.f14900a;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            String str;
            Long valueOf;
            Integer valueOf2;
            LocationSignalDataPackage locationSignalDataPackage = (LocationSignalDataPackage) immutableList.get(i);
            Optional i2 = locationSignalDataPackage.a.i();
            Optional j = locationSignalDataPackage.a.j();
            Optional k = locationSignalDataPackage.a.k();
            long a2 = LocationAgeUtil.a(locationSignalDataPackage.a, a);
            long b = LocationAgeUtil.b(locationSignalDataPackage.a, now);
            if (!(a2 == Long.MIN_VALUE || b == Long.MIN_VALUE || Math.abs(a2 - b) <= 60000)) {
                this.f14899d.a(locationSignalDataPackage.a, a, now);
            }
            if (i2.isPresent()) {
                str = "GEOFENCE";
            } else {
                str = "LOCATION";
            }
            Coordinates coordinates = new Coordinates(locationSignalDataPackage.a.a(), locationSignalDataPackage.a.b());
            if (b == Long.MIN_VALUE || b < 0) {
                b = a2;
            }
            Builder b2 = new Builder(str, coordinates, Long.valueOf(b), (Float) locationSignalDataPackage.a.c().get()).m15363a((Double) locationSignalDataPackage.a.d().orNull()).m15364a((Float) locationSignalDataPackage.a.e().orNull()).m15368b((Float) locationSignalDataPackage.a.f().orNull());
            if (i2.isPresent()) {
                valueOf = Long.valueOf(a - ((Long) i2.get()).longValue());
            } else {
                valueOf = null;
            }
            b2 = b2.m15366a(valueOf);
            if (j.isPresent()) {
                valueOf = Long.valueOf(a - ((Long) j.get()).longValue());
            } else {
                valueOf = null;
            }
            b2 = b2.m15369b(valueOf);
            if (k.isPresent()) {
                valueOf2 = Integer.valueOf(((Float) k.get()).intValue());
            } else {
                valueOf2 = null;
            }
            arrayList.add(b2.m15365a(valueOf2).m15362a(WifiInfo.m15371a(locationSignalDataPackage.d, locationSignalDataPackage.c, this.f14897b)).m15367a());
        }
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("locations", m15356a(arrayList));
        ArrayNode b3 = JsonNodeFactory.a.b();
        ImmutableList immutableList2 = backgroundLocationReportingUpdateParams.f14901b;
        int size2 = immutableList2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            b3.h((String) immutableList2.get(i3));
        }
        return ImmutableList.of(basicNameValuePair, new BasicNameValuePair("trace_ids", b3.toString()), new BasicNameValuePair("deviceid", this.f14898c.a()));
    }

    private static String m15356a(List<BackgroundLocationSnapshot> list) {
        try {
            Writer stringWriter = new StringWriter();
            JsonGenerator a = JsonFactoryHolder.a.a(stringWriter);
            a.d();
            for (BackgroundLocationSnapshot a2 : list) {
                BackgroundLocationSnapshot__JsonHelper.m15373a(a, a2, true);
            }
            a.e();
            a.close();
            return stringWriter.toString();
        } catch (IOException e) {
            return "[]";
        }
    }
}

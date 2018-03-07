package com.facebook.analytics.service;

import com.facebook.analytics.ExperimentsForAnalyticsClientModule;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.RawJsonBlobNode;
import com.facebook.analytics.db.AnalyticsDbProperties;
import com.facebook.analytics.db.AnalyticsSessionManager;
import com.facebook.analytics.db.AnalyticsStorage;
import com.facebook.analytics.db.AnalyticsStorage.EventBatch;
import com.facebook.analytics.samplingpolicy.AnalyticsLoggingPolicy;
import com.facebook.analytics.webmethod.AnalyticsServerResponse;
import com.facebook.analytics.webmethod.SendAnalyticLogsMethod;
import com.facebook.analytics.webmethod.SendAnalyticLogsParams;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.crudolib.params.ParamsCollectionPool;
import com.facebook.device_id.DeviceIdRegenerationHandler;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.http.protocol.BootstrapTierUtil;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: third_party_id */
public class HoneyAnalyticsUploadHandler {
    private static volatile HoneyAnalyticsUploadHandler f1204p;
    private final AppVersionInfo f1205a;
    private final AnalyticsLoggingPolicy f1206b;
    private final AnalyticsStorage f1207c;
    private final AnalyticsSessionManager f1208d;
    private final AbstractSingleMethodRunner f1209e;
    private final SendAnalyticLogsMethod f1210f;
    private final FbNetworkManager f1211g;
    private final Clock f1212h;
    private final Provider<Boolean> f1213i;
    private final BootstrapTierUtil f1214j;
    private final ParamsCollectionPool f1215k = ParamsCollectionPool.a();
    private final Lazy<QeAccessor> f1216l;
    private ObjectMapper f1217m;
    private DeviceIdRegenerationHandler f1218n;
    private BatchMetaDataHelper f1219o;

    public static com.facebook.analytics.service.HoneyAnalyticsUploadHandler m1460a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1204p;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.service.HoneyAnalyticsUploadHandler.class;
        monitor-enter(r1);
        r0 = f1204p;	 Catch:{ all -> 0x003a }
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
        r0 = m1467b(r0);	 Catch:{ all -> 0x0035 }
        f1204p = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1204p;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.service.HoneyAnalyticsUploadHandler.a(com.facebook.inject.InjectorLike):com.facebook.analytics.service.HoneyAnalyticsUploadHandler");
    }

    private static HoneyAnalyticsUploadHandler m1467b(InjectorLike injectorLike) {
        return new HoneyAnalyticsUploadHandler(AppVersionInfoMethodAutoProvider.a(injectorLike), AnalyticsLoggingPolicy.a(injectorLike), AnalyticsStorage.m1421a(injectorLike), AnalyticsSessionManager.m1434a(injectorLike), DeviceIdRegenerationHandler.m1472a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), FbNetworkManager.a(injectorLike), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), SendAnalyticLogsMethod.m1476a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3887), BootstrapTierUtil.a(injectorLike), BatchMetaDataHelper.m1479b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3219));
    }

    @Inject
    public HoneyAnalyticsUploadHandler(AppVersionInfo appVersionInfo, AnalyticsLoggingPolicy analyticsLoggingPolicy, AnalyticsStorage analyticsStorage, AnalyticsSessionManager analyticsSessionManager, DeviceIdRegenerationHandler deviceIdRegenerationHandler, ObjectMapper objectMapper, FbNetworkManager fbNetworkManager, SingleMethodRunner singleMethodRunner, SendAnalyticLogsMethod sendAnalyticLogsMethod, Clock clock, Provider<Boolean> provider, BootstrapTierUtil bootstrapTierUtil, BatchMetaDataHelper batchMetaDataHelper, Lazy<QeAccessor> lazy) {
        this.f1205a = appVersionInfo;
        this.f1206b = analyticsLoggingPolicy;
        this.f1207c = analyticsStorage;
        this.f1208d = analyticsSessionManager;
        this.f1209e = singleMethodRunner;
        this.f1210f = sendAnalyticLogsMethod;
        this.f1211g = fbNetworkManager;
        this.f1212h = clock;
        this.f1213i = provider;
        this.f1214j = bootstrapTierUtil;
        this.f1217m = objectMapper;
        this.f1218n = deviceIdRegenerationHandler;
        this.f1219o = batchMetaDataHelper;
        this.f1216l = lazy;
    }

    private static String m1463a(ImmutableList<String> immutableList) {
        int i;
        int i2 = 2;
        for (i = 0; i < immutableList.size(); i++) {
            i2 += ((String) immutableList.get(i)).length() + 1;
        }
        StringBuilder stringBuilder = new StringBuilder(i2);
        stringBuilder.append('[');
        Object obj = 1;
        i = 0;
        while (i < immutableList.size()) {
            Object obj2;
            if (obj != null) {
                obj2 = null;
            } else {
                stringBuilder.append(',');
                obj2 = obj;
            }
            stringBuilder.append((String) immutableList.get(i));
            i++;
            obj = obj2;
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    private ObjectNode m1462a(EventBatch eventBatch, boolean z) {
        String a = m1463a(eventBatch.g);
        if (a.length() <= 2) {
            return null;
        }
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        this.f1219o.m1482a(objectNode, eventBatch.a, eventBatch.d, eventBatch.e, eventBatch.c, eventBatch.b, "regular", z);
        objectNode.c("data", new RawJsonBlobNode(a));
        return objectNode;
    }

    private String m1468b(List<HoneyAnalyticsEvent> list) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        BatchMetaDataHelper batchMetaDataHelper = this.f1219o;
        long a = this.f1212h.a();
        String a2 = this.f1205a.a();
        int b = this.f1205a.b();
        AnalyticsSessionManager analyticsSessionManager = this.f1208d;
        int i = 0;
        if (analyticsSessionManager.f1180f == -1) {
            analyticsSessionManager.f1180f = analyticsSessionManager.f1183i.m8549a(AnalyticsDbProperties.f1040j, 0);
        }
        if (analyticsSessionManager.f1180f != Integer.MAX_VALUE) {
            i = analyticsSessionManager.f1180f + 1;
        }
        analyticsSessionManager.f1180f = i;
        analyticsSessionManager.f1183i.m8556b(AnalyticsDbProperties.f1040j, analyticsSessionManager.f1180f);
        batchMetaDataHelper.m1482a(objectNode, a, a2, b, analyticsSessionManager.f1180f, SafeUUIDGenerator.a().toString(), "ads", false);
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (HoneyAnalyticsEvent e : list) {
            arrayNode.a(new RawJsonBlobNode(e.e()));
        }
        objectNode.c("data", arrayNode);
        return objectNode.toString();
    }

    private String m1469c(List<EventBatch> list) {
        if (list.isEmpty()) {
            return null;
        }
        ObjectNode a;
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (EventBatch a2 : list) {
            a = m1462a(a2, true);
            if (a != null) {
                arrayNode.a(a);
            }
        }
        a = new ObjectNode(JsonNodeFactory.a);
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
        a.c("batches", arrayNode);
        a.c("request_info", this.f1219o.m1480a(objectNode));
        a.c("config", this.f1219o.m1481a(objectNode2, true));
        return a.toString();
    }

    private AnalyticsServerResponse m1461a(String str, boolean z) {
        ApiMethodRunnerParams apiMethodRunnerParams = new ApiMethodRunnerParams();
        if (StringUtil.a(this.f1208d.m1444b())) {
            this.f1214j.a(apiMethodRunnerParams);
        }
        if (((Boolean) this.f1213i.get()).booleanValue()) {
            return new AnalyticsServerResponse(null, null, null);
        }
        return (AnalyticsServerResponse) this.f1209e.a(this.f1210f, new SendAnalyticLogsParams(str, z), apiMethodRunnerParams);
    }

    private EventBatch m1459a(@Nullable String str, long j, int i) {
        if (str != null) {
            return this.f1207c.m1432b(str);
        }
        String b = this.f1207c.m1433b();
        if (b == null) {
            return null;
        }
        this.f1208d.m1443a(b);
        if (j == -1) {
            return this.f1207c.m1428a(b);
        }
        return this.f1207c.m1429a(b, j, i);
    }

    private boolean m1465a() {
        return ((QeAccessor) this.f1216l.get()).a(ExperimentsForAnalyticsClientModule.f13690a, false);
    }

    private int m1466b() {
        return ((QeAccessor) this.f1216l.get()).a(ExperimentsForAnalyticsClientModule.f13691b, 20000);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m1471a(@javax.annotation.Nullable java.lang.String r12) {
        /*
        r11 = this;
        r0 = r11.f1211g;
        r0 = r0.d();
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = r11.f1212h;
        r8 = r0.a();
        r1 = 0;
        r0 = 0;
        r2 = r1;
        r1 = r0;
    L_0x0013:
        r0 = r11.m1465a();
        if (r0 == 0) goto L_0x008c;
    L_0x0019:
        if (r12 != 0) goto L_0x008c;
    L_0x001b:
        r3 = 0;
        r0 = 0;
        r4 = -1;
        r7 = new java.util.ArrayList;
        r7.<init>();
        r10 = new java.util.ArrayList;
        r10.<init>();
        r6 = r3;
    L_0x002a:
        if (r0 == 0) goto L_0x0032;
    L_0x002c:
        r3 = r11.m1466b();
        if (r0 >= r3) goto L_0x005e;
    L_0x0032:
        r3 = 0;
        r4 = r11.m1459a(r3, r4, r6);
        if (r4 == 0) goto L_0x005e;
    L_0x0039:
        r3 = r4.f;
        r10.addAll(r3);
        r7.add(r4);
        r3 = r4.a();
        r3 = r3 + r0;
        r6 = r6 + 1;
        r0 = r4.f;
        r4 = r4.f;
        r4 = r4.size();
        r4 = r4 + -1;
        r0 = r0.get(r4);
        r0 = (java.lang.Long) r0;
        r4 = r0.longValue();
        r0 = r3;
        goto L_0x002a;
    L_0x005e:
        r0 = r7.isEmpty();
        if (r0 != 0) goto L_0x0082;
    L_0x0064:
        r0 = r11.m1469c(r7);
        r3 = 1;
        r0 = r11.m1461a(r0, r3);	 Catch:{ Exception -> 0x0086 }
        if (r0 == 0) goto L_0x0079;
    L_0x006f:
        r2 = r2 + r6;
        r3 = com.google.common.collect.ImmutableList.copyOf(r10);	 Catch:{ Exception -> 0x0086 }
        r4 = 0;
        r11.m1464a(r0, r3, r6, r4);	 Catch:{ Exception -> 0x0086 }
        r1 = 0;
    L_0x0079:
        r0 = r1;
        r1 = r2;
    L_0x007b:
        r2 = 3;
        if (r0 < r2) goto L_0x00b9;
    L_0x007e:
        java.lang.Integer.valueOf(r0);
        r2 = r1;
    L_0x0082:
        java.lang.Integer.valueOf(r2);
        goto L_0x0008;
    L_0x0086:
        r0 = move-exception;
        r1 = r1 + 1;
        r0 = r1;
        r1 = r2;
        goto L_0x007b;
    L_0x008c:
        r4 = -1;
        r0 = 0;
        r0 = r11.m1459a(r12, r4, r0);
        if (r0 == 0) goto L_0x0082;
    L_0x0095:
        r3 = 0;
        r3 = r11.m1462a(r0, r3);
        if (r3 == 0) goto L_0x0082;
    L_0x009c:
        r3 = r3.toString();	 Catch:{ Exception -> 0x00b3 }
        r4 = 0;
        r3 = r11.m1461a(r3, r4);	 Catch:{ Exception -> 0x00b3 }
        if (r3 == 0) goto L_0x00b0;
    L_0x00a7:
        r2 = r2 + 1;
        r0 = r0.f;	 Catch:{ Exception -> 0x00b3 }
        r4 = 1;
        r11.m1464a(r3, r0, r4, r12);	 Catch:{ Exception -> 0x00b3 }
        r1 = 0;
    L_0x00b0:
        r0 = r1;
        r1 = r2;
        goto L_0x007b;
    L_0x00b3:
        r0 = move-exception;
        r1 = r1 + 1;
        r0 = r1;
        r1 = r2;
        goto L_0x007b;
    L_0x00b9:
        r2 = r11.f1212h;
        r2 = r2.a();
        r2 = r2 - r8;
        r4 = 120000; // 0x1d4c0 float:1.68156E-40 double:5.9288E-319;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x00c9;
    L_0x00c7:
        r2 = r1;
        goto L_0x0082;
    L_0x00c9:
        r2 = r1;
        r1 = r0;
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.service.HoneyAnalyticsUploadHandler.a(java.lang.String):void");
    }

    private void m1464a(AnalyticsServerResponse analyticsServerResponse, ImmutableList<Long> immutableList, int i, @Nullable String str) {
        if (str == null) {
            AnalyticsSessionManager analyticsSessionManager = this.f1208d;
            analyticsSessionManager.f1179e += i;
            Integer.valueOf(analyticsSessionManager.f1179e);
            analyticsSessionManager.f1183i.m8556b(AnalyticsDbProperties.f1036f, analyticsSessionManager.f1179e);
            this.f1207c.m1431b(((Long) immutableList.get(immutableList.size() - 1)).longValue());
        } else {
            this.f1207c.m1427a((ImmutableList) immutableList);
        }
        this.f1206b.a(analyticsServerResponse);
        JsonNode a = analyticsServerResponse.c == null ? null : this.f1217m.a(analyticsServerResponse.c);
        a = a == null ? null : a.b("pigeon_internal");
        if (a != null && a.b("regenerate_deviceid") != null) {
            this.f1218n.m1474a();
        }
    }

    public final AnalyticsServerResponse m1470a(List<HoneyAnalyticsEvent> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        String b = m1468b((List) list);
        Integer.valueOf(list.size());
        return m1461a(b, false);
    }
}

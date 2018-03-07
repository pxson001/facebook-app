package com.facebook.backgroundlocation.reporting;

import android.content.Intent;
import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.SecurePendingIntent;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationManagerParams.Priority;
import com.facebook.location.FbLocationOperationParams;
import com.facebook.location.FbLocationOperationParams.Builder;
import com.facebook.push.PushProperty;
import com.facebook.push.fbpushdata.BaseFbPushDataHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.annotations.VisibleForTesting;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: disable_swipe_to_close */
public class BackgroundLocationReportingPushDataHandler extends BaseFbPushDataHandler {
    private static volatile BackgroundLocationReportingPushDataHandler f14892d;
    private final GatekeeperStoreImpl f14893b;
    private final BackgroundLocationReportingNewImplManager f14894c;

    public static com.facebook.backgroundlocation.reporting.BackgroundLocationReportingPushDataHandler m15350a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14892d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backgroundlocation.reporting.BackgroundLocationReportingPushDataHandler.class;
        monitor-enter(r1);
        r0 = f14892d;	 Catch:{ all -> 0x003a }
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
        r0 = m15353b(r0);	 Catch:{ all -> 0x0035 }
        f14892d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14892d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backgroundlocation.reporting.BackgroundLocationReportingPushDataHandler.a(com.facebook.inject.InjectorLike):com.facebook.backgroundlocation.reporting.BackgroundLocationReportingPushDataHandler");
    }

    private static BackgroundLocationReportingPushDataHandler m15353b(InjectorLike injectorLike) {
        return new BackgroundLocationReportingPushDataHandler(ReliabilityAnalyticsLogger.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), BackgroundLocationReportingNewImplManager.a(injectorLike));
    }

    @Inject
    public BackgroundLocationReportingPushDataHandler(ReliabilityAnalyticsLogger reliabilityAnalyticsLogger, GatekeeperStoreImpl gatekeeperStoreImpl, BackgroundLocationReportingNewImplManager backgroundLocationReportingNewImplManager) {
        super(reliabilityAnalyticsLogger);
        this.f14893b = gatekeeperStoreImpl;
        this.f14894c = backgroundLocationReportingNewImplManager;
    }

    public final void m15354b(JsonNode jsonNode, PushProperty pushProperty) {
        if (this.f14893b.a(514) == TriState.YES) {
            if ("request_location_update".equals(JSONUtil.b(jsonNode.b("type")))) {
                m15351a(jsonNode);
            }
        }
    }

    private void m15351a(JsonNode jsonNode) {
        JsonNode b = jsonNode.b("params");
        BackgroundLocationReportingNewImplManager backgroundLocationReportingNewImplManager = this.f14894c;
        BackgroundLocationReportingLocationRequestParams b2 = m15352b(b);
        backgroundLocationReportingNewImplManager.i.b.a(BackgroundLocationReportingNewImplAnalyticsLogger.a("background_location_obtain_single_location_start").a("delay_distance_meters", (double) b2.f14888a).b("trace_id", b2.f14889b).a("priority", b2.f14890c.a).a("desired_age_ms", b2.f14890c.b).a("desired_accuracy_meters", (double) b2.f14890c.c).a("timeout_ms", b2.f14890c.d));
        Intent intent = new Intent();
        intent.setAction(backgroundLocationReportingNewImplManager.g.a("BACKGROUND_LOCATION_REPORTING_ACTION_OBTAIN_SINGLE_LOCATION_FINISHED"));
        BackgroundLocationReportingNewImplService.a(backgroundLocationReportingNewImplManager.f, b2, SecurePendingIntent.b(backgroundLocationReportingNewImplManager.f, 0, intent, 0));
    }

    @VisibleForTesting
    private static BackgroundLocationReportingLocationRequestParams m15352b(JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = new ObjectNode(JsonNodeFactory.a);
        }
        Priority priority = Priority.BALANCED_POWER_AND_ACCURACY;
        if (JSONUtil.a(jsonNode.b("lg"), true)) {
            priority = Priority.HIGH_ACCURACY;
        }
        Builder a = FbLocationOperationParams.a(priority);
        a.c = JSONUtil.a(jsonNode.b("lam"), 50.0f);
        a = a;
        a.b = JSONUtil.a(jsonNode.b("lda"), 15000);
        a = a;
        a.d = JSONUtil.a(jsonNode.b("lt"), 7000);
        return new BackgroundLocationReportingLocationRequestParams(JSONUtil.a(jsonNode.b("ld"), 0.0f), JSONUtil.b(jsonNode.b("li")), a.a());
    }
}

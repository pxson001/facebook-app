package com.facebook.common.dextricksdi;

import android.content.Context;
import android.os.Looper;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.dextricks.DexErrorRecoveryInfo;
import com.facebook.common.dextricks.DexLibLoader;
import com.facebook.common.dextricks.DexStore;
import com.facebook.common.dextricks.DexStore.OptimizationLog;
import com.facebook.common.dextricks.OptimizationConfiguration.Builder;
import com.facebook.common.init.INeedInit;
import com.facebook.debug.log.BLog;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.inject.Singleton;

@Singleton
/* compiled from: messagePreview */
public final class DexOptimizationKickoffThing implements INeedInit {
    private static final Class f8126a = DexOptimizationKickoffThing.class;
    private static volatile DexOptimizationKickoffThing f8127d;
    @ForAppContext
    @Inject
    public Context f8128b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<AnalyticsLogger> f8129c = UltralightRuntime.b;

    public static com.facebook.common.dextricksdi.DexOptimizationKickoffThing m8404a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8127d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.dextricksdi.DexOptimizationKickoffThing.class;
        monitor-enter(r1);
        r0 = f8127d;	 Catch:{ all -> 0x003a }
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
        r0 = m8408b(r0);	 Catch:{ all -> 0x0035 }
        f8127d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8127d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.dextricksdi.DexOptimizationKickoffThing.a(com.facebook.inject.InjectorLike):com.facebook.common.dextricksdi.DexOptimizationKickoffThing");
    }

    private static DexOptimizationKickoffThing m8408b(InjectorLike injectorLike) {
        DexOptimizationKickoffThing dexOptimizationKickoffThing = new DexOptimizationKickoffThing();
        Context context = (Context) injectorLike.getInstance(Context.class, ForAppContext.class);
        com.facebook.inject.Lazy b = IdBasedSingletonScopeProvider.b(injectorLike, 175);
        dexOptimizationKickoffThing.f8128b = context;
        dexOptimizationKickoffThing.f8129c = b;
        return dexOptimizationKickoffThing;
    }

    public final void init() {
        DexErrorRecoveryInfo mainDexStoreLoadInformation = DexLibLoader.getMainDexStoreLoadInformation();
        if (mainDexStoreLoadInformation == null) {
            BLog.a(f8126a, "missing dex load information!");
            return;
        }
        int i = mainDexStoreLoadInformation.loadResult;
        if ((mainDexStoreLoadInformation.loadResult & 1) != 0) {
            m8406a(mainDexStoreLoadInformation);
        }
        DexStore mainDexStore = DexLibLoader.getMainDexStore();
        OptimizationLog optimizationLog = null;
        try {
            optimizationLog = mainDexStore.getAndClearCompletedOptimizationLog();
        } catch (Throwable e) {
            BLog.a(f8126a, e, "error reading dex error log", new Object[0]);
        }
        if (optimizationLog != null) {
            m8407a(optimizationLog);
        }
        if ((i & 2) != 0) {
            long max = Math.max(mainDexStore.getNextRecommendedOptimizationAttemptTime(new Builder().build()) - System.currentTimeMillis(), 10000);
            Long.valueOf(max);
            new 1(this, Looper.getMainLooper()).sendEmptyMessageDelayed(0, max);
        }
    }

    private void m8407a(OptimizationLog optimizationLog) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("main_dex_store_optimization_complete");
        honeyClientEvent.a("success", (optimizationLog.flags & 2) != 0);
        honeyClientEvent.a("nrOptimizationsAttempted", optimizationLog.nrOptimizationsAttempted);
        honeyClientEvent.a("nrOptimizationsFailed", optimizationLog.nrOptimizationsFailed);
        for (int i = 0; i < 4; i++) {
            String counterName = OptimizationLog.getCounterName(i);
            String str = counterName + "_LAST_ATTEMPT";
            honeyClientEvent.a(counterName, optimizationLog.counters[i]);
            honeyClientEvent.a(str, optimizationLog.lastAttemptCounters[i]);
        }
        if (!"".equals(optimizationLog.lastFailureExceptionJson)) {
            JsonNode jsonNode;
            try {
                jsonNode = (JsonNode) new MappingJsonFactory().b(optimizationLog.lastFailureExceptionJson).J();
            } catch (Throwable e) {
                Throwable th = e;
                BLog.a(f8126a, th, "failure to decode exception JSON!!!!", new Object[0]);
                ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
                objectNode.a("error", "error reading error JSON: " + th.toString());
                jsonNode = objectNode;
            }
            honeyClientEvent.a("lastFailureExceptionJson", jsonNode);
        }
        ((AnalyticsLogger) this.f8129c.get()).c(honeyClientEvent);
    }

    private void m8406a(DexErrorRecoveryInfo dexErrorRecoveryInfo) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("main_dex_store_regen");
        int i = dexErrorRecoveryInfo.loadResult;
        if ((i & 16) != 0) {
            honeyClientEvent.a("LOAD_RESULT_RECOVERED_FROM_CORRUPTION", true);
        }
        if ((i & 64) != 0) {
            honeyClientEvent.a("LOAD_RESULT_RECOVERED_FROM_BAD_GEN", true);
        }
        if ((i & 32) != 0) {
            honeyClientEvent.a("LOAD_RESULT_REGEN_FORCED", true);
        }
        if (dexErrorRecoveryInfo.regenRetryCause != null) {
            honeyClientEvent.a("regenRetryCause", m8405a(dexErrorRecoveryInfo.regenRetryCause));
        }
        if (dexErrorRecoveryInfo.fallbackCause != null) {
            honeyClientEvent.a("fallbackCause", m8405a(dexErrorRecoveryInfo.fallbackCause));
        }
        if (dexErrorRecoveryInfo.xdexFailureCause != null) {
            honeyClientEvent.a("xdexFailureCause", m8405a(dexErrorRecoveryInfo.xdexFailureCause));
        }
        if (dexErrorRecoveryInfo.odexSchemeName != null) {
            honeyClientEvent.b("odexSchemeName", dexErrorRecoveryInfo.odexSchemeName);
        }
        ((AnalyticsLogger) this.f8129c.get()).c(honeyClientEvent);
    }

    private JsonNode m8405a(Throwable th) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("excls", th.getClass().getName());
        objectNode.a("msg", th.getMessage());
        StackTraceElement[] stackTrace = th.getStackTrace();
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (StackTraceElement stackTraceElement : stackTrace) {
            ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
            objectNode2.a("cls", stackTraceElement.getClassName());
            objectNode2.a("method", stackTraceElement.getMethodName());
            objectNode2.a("ln", stackTraceElement.getLineNumber());
            arrayNode.a(objectNode2);
        }
        objectNode.c("stack", arrayNode);
        Throwable cause = th.getCause();
        if (cause != null) {
            objectNode.c("cause", m8405a(cause));
        }
        return objectNode;
    }
}

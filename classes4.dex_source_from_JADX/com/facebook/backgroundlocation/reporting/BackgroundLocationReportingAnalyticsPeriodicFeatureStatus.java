package com.facebook.backgroundlocation.reporting;

import com.facebook.analytics.feature.PeriodicFeatureStatus;
import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: hack_action */
public class BackgroundLocationReportingAnalyticsPeriodicFeatureStatus extends PeriodicFeatureStatus {
    private static volatile BackgroundLocationReportingAnalyticsPeriodicFeatureStatus f10916c;
    private final GatekeeperStoreImpl f10917a;
    private final BackgroundLocationReportingSettingsManager f10918b;

    public static com.facebook.backgroundlocation.reporting.BackgroundLocationReportingAnalyticsPeriodicFeatureStatus m11351a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10916c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backgroundlocation.reporting.BackgroundLocationReportingAnalyticsPeriodicFeatureStatus.class;
        monitor-enter(r1);
        r0 = f10916c;	 Catch:{ all -> 0x003a }
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
        r0 = m11352b(r0);	 Catch:{ all -> 0x0035 }
        f10916c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10916c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backgroundlocation.reporting.BackgroundLocationReportingAnalyticsPeriodicFeatureStatus.a(com.facebook.inject.InjectorLike):com.facebook.backgroundlocation.reporting.BackgroundLocationReportingAnalyticsPeriodicFeatureStatus");
    }

    private static BackgroundLocationReportingAnalyticsPeriodicFeatureStatus m11352b(InjectorLike injectorLike) {
        return new BackgroundLocationReportingAnalyticsPeriodicFeatureStatus(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), BackgroundLocationReportingSettingsManager.m10123a(injectorLike));
    }

    @Inject
    public BackgroundLocationReportingAnalyticsPeriodicFeatureStatus(GatekeeperStoreImpl gatekeeperStoreImpl, BackgroundLocationReportingSettingsManager backgroundLocationReportingSettingsManager) {
        this.f10917a = gatekeeperStoreImpl;
        this.f10918b = backgroundLocationReportingSettingsManager;
    }

    public final String mo61b() {
        return "background_location";
    }

    public final boolean mo62c() {
        return this.f10917a.a(514) == TriState.YES;
    }

    public final JsonNode mo829a() {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("collecting", this.f10918b.m10130a());
        return objectNode;
    }
}

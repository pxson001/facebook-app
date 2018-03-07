package com.facebook.analytics.reporters.periodic;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.feature.PeriodicFeatureStatus;
import com.facebook.analytics.feature.STATICDI_MULTIBIND_PROVIDER$PeriodicFeatureStatus;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.logger.IAnalyticsPeriodicEventReporter;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: half_screen_count */
public class PeriodicFeatureStatusReporter implements IAnalyticsPeriodicEventReporter {
    private static final Class<?> f10912a = PeriodicFeatureStatusReporter.class;
    private static volatile PeriodicFeatureStatusReporter f10913c;
    private Lazy<Set<PeriodicFeatureStatus>> f10914b;

    public static com.facebook.analytics.reporters.periodic.PeriodicFeatureStatusReporter m11346a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10913c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.reporters.periodic.PeriodicFeatureStatusReporter.class;
        monitor-enter(r1);
        r0 = f10913c;	 Catch:{ all -> 0x003a }
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
        r0 = m11349b(r0);	 Catch:{ all -> 0x0035 }
        f10913c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10913c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.reporters.periodic.PeriodicFeatureStatusReporter.a(com.facebook.inject.InjectorLike):com.facebook.analytics.reporters.periodic.PeriodicFeatureStatusReporter");
    }

    private static PeriodicFeatureStatusReporter m11349b(InjectorLike injectorLike) {
        return new PeriodicFeatureStatusReporter(ProviderLazy.a(new STATICDI_MULTIBIND_PROVIDER$PeriodicFeatureStatus(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()));
    }

    @Inject
    public PeriodicFeatureStatusReporter(Lazy<Set<PeriodicFeatureStatus>> lazy) {
        this.f10914b = lazy;
    }

    public final HoneyAnalyticsEvent mo804a(long j, String str) {
        if (m11347a().isEmpty()) {
            BLog.a(f10912a, "No feature status reporters found; is this dead code?");
            return null;
        }
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("features_status");
        m11348a(m11347a(), honeyClientEvent);
        return honeyClientEvent;
    }

    private static void m11348a(Set<PeriodicFeatureStatus> set, HoneyClientEvent honeyClientEvent) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
        for (PeriodicFeatureStatus periodicFeatureStatus : set) {
            objectNode.a(periodicFeatureStatus.mo61b(), periodicFeatureStatus.mo62c());
            objectNode2.c(periodicFeatureStatus.mo61b(), periodicFeatureStatus.mo829a());
        }
        honeyClientEvent.a("features", objectNode);
        honeyClientEvent.a("features_extra_data", objectNode2);
    }

    private Set<PeriodicFeatureStatus> m11347a() {
        return (Set) this.f10914b.get();
    }
}

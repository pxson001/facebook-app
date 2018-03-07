package com.facebook.analytics.reporters;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.feature.FeatureStatus;
import com.facebook.analytics.feature.STATICDI_MULTIBIND_PROVIDER$FeatureStatus;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: updateFolderCountsParams */
public class FeatureStatusReporter {
    private static volatile FeatureStatusReporter f514b;
    private Lazy<Set<FeatureStatus>> f515a;

    public static com.facebook.analytics.reporters.FeatureStatusReporter m807a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f514b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.reporters.FeatureStatusReporter.class;
        monitor-enter(r1);
        r0 = f514b;	 Catch:{ all -> 0x003a }
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
        r0 = m808b(r0);	 Catch:{ all -> 0x0035 }
        f514b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f514b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.reporters.FeatureStatusReporter.a(com.facebook.inject.InjectorLike):com.facebook.analytics.reporters.FeatureStatusReporter");
    }

    private static FeatureStatusReporter m808b(InjectorLike injectorLike) {
        return new FeatureStatusReporter(ProviderLazy.a(new STATICDI_MULTIBIND_PROVIDER$FeatureStatus(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()));
    }

    @Inject
    public FeatureStatusReporter(Lazy<Set<FeatureStatus>> lazy) {
        this.f515a = lazy;
    }

    @Deprecated
    public final HoneyAnalyticsEvent m809a(HoneyAnalyticsEvent honeyAnalyticsEvent) {
        if (!((Set) this.f515a.get()).isEmpty()) {
            for (FeatureStatus featureStatus : (Set) this.f515a.get()) {
                if (featureStatus.mo62c()) {
                    String code = featureStatus.mo60a().getCode();
                    if (honeyAnalyticsEvent.k == null) {
                        honeyAnalyticsEvent.k = new ArrayNode(JsonNodeFactory.a);
                    }
                    honeyAnalyticsEvent.k.h(code);
                }
            }
        }
        return honeyAnalyticsEvent;
    }
}

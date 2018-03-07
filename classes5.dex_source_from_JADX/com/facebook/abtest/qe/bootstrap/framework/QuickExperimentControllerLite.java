package com.facebook.abtest.qe.bootstrap.framework;

import com.facebook.abtest.qe.bootstrap.data.QuickExperimentParameters;
import com.google.common.base.Preconditions;
import com.google.common.collect.RegularImmutableBiMap;
import javax.inject.Singleton;

@Singleton
/* compiled from: transaction_discount */
public class QuickExperimentControllerLite implements QuickExperimentController {
    private static final Class<?> f1702a = QuickExperimentControllerLite.class;
    private static volatile QuickExperimentControllerLite f1703c;
    private final QuickExperimentParameters f1704b = new QuickExperimentParameters(false, false, "local_default_group", RegularImmutableBiMap.a);

    public static com.facebook.abtest.qe.bootstrap.framework.QuickExperimentControllerLite m2308a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f1703c;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.abtest.qe.bootstrap.framework.QuickExperimentControllerLite.class;
        monitor-enter(r1);
        r0 = f1703c;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m2307a();	 Catch:{ all -> 0x0034 }
        f1703c = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f1703c;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.abtest.qe.bootstrap.framework.QuickExperimentControllerLite.a(com.facebook.inject.InjectorLike):com.facebook.abtest.qe.bootstrap.framework.QuickExperimentControllerLite");
    }

    private static QuickExperimentControllerLite m2307a() {
        return new QuickExperimentControllerLite();
    }

    private static <CONFIG> QuickExperiment<CONFIG> m2309d(BaseQuickExperiment<CONFIG> baseQuickExperiment) {
        Preconditions.checkState(baseQuickExperiment instanceof QuickExperiment, "QuickExperimentControllerLite can only handle the new QE API");
        return (QuickExperiment) baseQuickExperiment;
    }

    public final <CONFIG> CONFIG m2310a(BaseQuickExperiment<CONFIG> baseQuickExperiment) {
        return m2309d(baseQuickExperiment).a(this.f1704b);
    }

    public final <CONFIG> void m2311b(BaseQuickExperiment<CONFIG> baseQuickExperiment) {
        m2309d(baseQuickExperiment);
    }

    public final <CONFIG> QuickExperimentMetadata m2312c(BaseQuickExperiment<CONFIG> baseQuickExperiment) {
        return new QuickExperimentMetadata("local_default_group");
    }
}

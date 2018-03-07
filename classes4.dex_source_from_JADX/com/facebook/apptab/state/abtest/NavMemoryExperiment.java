package com.facebook.apptab.state.abtest;

import com.facebook.abtest.qe.bootstrap.data.QuickExperimentParameters;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperiment;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentController;
import com.facebook.abtest.qe.framework.QuickExperimentControllerImpl;
import com.facebook.apptab.state.NavigationMemoryConfig;
import com.facebook.apptab.state.NavigationMemoryConfig$Builder;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: messagerequests */
public class NavMemoryExperiment implements QuickExperiment<NavigationMemoryConfig> {
    private static volatile NavMemoryExperiment f8100b;
    private final QuickExperimentController f8101a;

    public static com.facebook.apptab.state.abtest.NavMemoryExperiment m8381a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8100b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.apptab.state.abtest.NavMemoryExperiment.class;
        monitor-enter(r1);
        r0 = f8100b;	 Catch:{ all -> 0x003a }
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
        r0 = m8382b(r0);	 Catch:{ all -> 0x0035 }
        f8100b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8100b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.apptab.state.abtest.NavMemoryExperiment.a(com.facebook.inject.InjectorLike):com.facebook.apptab.state.abtest.NavMemoryExperiment");
    }

    private static NavMemoryExperiment m8382b(InjectorLike injectorLike) {
        return new NavMemoryExperiment((QuickExperimentController) QuickExperimentControllerImpl.a(injectorLike));
    }

    @Inject
    public NavMemoryExperiment(QuickExperimentController quickExperimentController) {
        this.f8101a = quickExperimentController;
    }

    public final Object m8383a(QuickExperimentParameters quickExperimentParameters) {
        NavigationMemoryConfig$Builder navigationMemoryConfig$Builder = new NavigationMemoryConfig$Builder();
        navigationMemoryConfig$Builder.f9828c = quickExperimentParameters.a("low_memory_optimization_threshold_mb", 0);
        return navigationMemoryConfig$Builder.m10236a();
    }

    public final String m8384a() {
        return "android_memory_nav_tests";
    }
}

package com.facebook.sideloading;

import com.facebook.abtest.qe.bootstrap.registry.QuickExperimentSpecification;
import com.facebook.abtest.qe.bootstrap.registry.QuickExperimentSpecificationBuilder;
import com.facebook.abtest.qe.bootstrap.registry.QuickExperimentSpecificationHolder;
import com.facebook.inject.InjectorLike;
import com.facebook.sideloading.GeneratedSideloadMessengerViaDiodeQuickExperiment.Config;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: last_clicked_notif_cache_id */
public class AutoQESpecForSideloadingModule implements QuickExperimentSpecificationHolder {
    private static final ImmutableSet<QuickExperimentSpecification> f9591a;
    private static volatile AutoQESpecForSideloadingModule f9592c;
    private final AutoQECacheForSideloadingModule f9593b;

    public static com.facebook.sideloading.AutoQESpecForSideloadingModule m9981a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9592c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.sideloading.AutoQESpecForSideloadingModule.class;
        monitor-enter(r1);
        r0 = f9592c;	 Catch:{ all -> 0x003a }
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
        r0 = m9982b(r0);	 Catch:{ all -> 0x0035 }
        f9592c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9592c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.sideloading.AutoQESpecForSideloadingModule.a(com.facebook.inject.InjectorLike):com.facebook.sideloading.AutoQESpecForSideloadingModule");
    }

    private static AutoQESpecForSideloadingModule m9982b(InjectorLike injectorLike) {
        return new AutoQESpecForSideloadingModule(AutoQECacheForSideloadingModule.m9989a(injectorLike));
    }

    static {
        QuickExperimentSpecificationBuilder newBuilder = QuickExperimentSpecification.newBuilder();
        newBuilder.f9571a = "android_sideloading_messenger_via_fb4a_diode_screen";
        newBuilder = newBuilder.m9953a(GeneratedSideloadMessengerViaDiodeQuickExperiment.class);
        newBuilder.f9573c = false;
        f9591a = ImmutableSet.of(newBuilder.m9952a());
    }

    @Inject
    public AutoQESpecForSideloadingModule(AutoQECacheForSideloadingModule autoQECacheForSideloadingModule) {
        this.f9593b = autoQECacheForSideloadingModule;
    }

    public final ImmutableSet<QuickExperimentSpecification> mo765a() {
        return f9591a;
    }

    public final Config m9984b() {
        return this.f9593b.m9992b();
    }
}

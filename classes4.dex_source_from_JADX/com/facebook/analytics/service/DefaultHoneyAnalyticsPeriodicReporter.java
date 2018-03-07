package com.facebook.analytics.service;

import android.os.Bundle;
import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.analytics.logger.AnalyticsConfig.Level;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbAnalyticsConfig;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: thread/ */
public class DefaultHoneyAnalyticsPeriodicReporter {
    private static volatile DefaultHoneyAnalyticsPeriodicReporter f1192g;
    private final DefaultBlueServiceOperationFactory f1193a;
    private final BaseAnalyticsConfig f1194b;
    private final boolean f1195c;
    private List<String> f1196d = Lists.b();
    private String f1197e;
    private OperationFuture f1198f;

    /* compiled from: thread/ */
    class C00731 implements FutureCallback<OperationResult> {
        final /* synthetic */ DefaultHoneyAnalyticsPeriodicReporter f1199a;

        C00731(DefaultHoneyAnalyticsPeriodicReporter defaultHoneyAnalyticsPeriodicReporter) {
            this.f1199a = defaultHoneyAnalyticsPeriodicReporter;
        }

        public void onSuccess(Object obj) {
            this.f1199a.m1453a();
        }

        public void onFailure(Throwable th) {
            this.f1199a.m1453a();
        }
    }

    public static com.facebook.analytics.service.DefaultHoneyAnalyticsPeriodicReporter m1451a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1192g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.service.DefaultHoneyAnalyticsPeriodicReporter.class;
        monitor-enter(r1);
        r0 = f1192g;	 Catch:{ all -> 0x003a }
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
        r0 = m1452b(r0);	 Catch:{ all -> 0x0035 }
        f1192g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1192g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.service.DefaultHoneyAnalyticsPeriodicReporter.a(com.facebook.inject.InjectorLike):com.facebook.analytics.service.DefaultHoneyAnalyticsPeriodicReporter");
    }

    private static DefaultHoneyAnalyticsPeriodicReporter m1452b(InjectorLike injectorLike) {
        return new DefaultHoneyAnalyticsPeriodicReporter(DefaultBlueServiceOperationFactory.b(injectorLike), (BaseAnalyticsConfig) FbAnalyticsConfig.a(injectorLike));
    }

    @Inject
    public DefaultHoneyAnalyticsPeriodicReporter(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, BaseAnalyticsConfig baseAnalyticsConfig) {
        this.f1193a = defaultBlueServiceOperationFactory;
        this.f1194b = baseAnalyticsConfig;
        this.f1195c = ((int) (Math.random() * 2.147483647E9d)) % 1 == 0;
    }

    public final synchronized void m1454a(@Nullable String str) {
        if (this.f1198f != null) {
            if (!(Objects.equal(str, this.f1197e) || this.f1196d.contains(str))) {
                this.f1196d.add(str);
            }
        } else if (this.f1194b.a() == Level.CORE || this.f1194b.a() == Level.CORE_AND_SAMPLED || this.f1195c) {
            this.f1197e = str;
            Bundle bundle = new Bundle();
            bundle.putString("flush_tag", str);
            this.f1198f = BlueServiceOperationFactoryDetour.a(this.f1193a, "analytics_upload", bundle, -183862826).a();
            Futures.a(this.f1198f, new C00731(this));
        }
    }

    final synchronized void m1453a() {
        this.f1198f = null;
        if (!this.f1196d.isEmpty()) {
            m1454a((String) this.f1196d.remove(0));
        }
    }
}

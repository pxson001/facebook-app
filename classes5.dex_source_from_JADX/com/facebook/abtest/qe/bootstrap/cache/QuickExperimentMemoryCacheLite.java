package com.facebook.abtest.qe.bootstrap.cache;

import com.facebook.abtest.qe.bootstrap.cache.QuickExperimentMemoryCache.QuickExperimentMemoryCacheInitializer;
import com.facebook.abtest.qe.bootstrap.cache.QuickExperimentMemoryCache.QuickExperimentMemoryCacheObserver;
import com.facebook.abtest.qe.bootstrap.data.QuickExperimentInfo;
import com.facebook.abtest.qe.bootstrap.data.QuickExperimentInfo.Builder;
import com.facebook.abtest.qe.bootstrap.db.DataSource;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryInterfaces.Configuration;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryModels.ConfigurationModel;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: transaction_status */
public class QuickExperimentMemoryCacheLite implements QuickExperimentMemoryCache {
    private static volatile QuickExperimentMemoryCacheLite f1701a;

    /* compiled from: transaction_status */
    class C01011 implements QuickExperimentMemoryCacheInitializer {
        final /* synthetic */ QuickExperimentMemoryCacheLite f1700a;

        C01011(QuickExperimentMemoryCacheLite quickExperimentMemoryCacheLite) {
            this.f1700a = quickExperimentMemoryCacheLite;
        }

        public final void m2294a() {
        }
    }

    public static com.facebook.abtest.qe.bootstrap.cache.QuickExperimentMemoryCacheLite m2295a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1701a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.abtest.qe.bootstrap.cache.QuickExperimentMemoryCacheLite.class;
        monitor-enter(r1);
        r0 = f1701a;	 Catch:{ all -> 0x0039 }
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
        r0 = m2296f();	 Catch:{ all -> 0x0034 }
        f1701a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f1701a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.abtest.qe.bootstrap.cache.QuickExperimentMemoryCacheLite.a(com.facebook.inject.InjectorLike):com.facebook.abtest.qe.bootstrap.cache.QuickExperimentMemoryCacheLite");
    }

    private static QuickExperimentMemoryCacheLite m2296f() {
        return new QuickExperimentMemoryCacheLite();
    }

    public final ListenableFuture<QuickExperimentMemoryCache> m2299a() {
        return Futures.a(this);
    }

    public final void m2302b() {
    }

    public final void m2303c() {
    }

    public final Map<String, Configuration> m2304d() {
        return new HashMap();
    }

    @Nullable
    public final ConfigurationModel m2298a(String str) {
        return null;
    }

    public final QuickExperimentInfo m2301b(String str) {
        return new Builder().a();
    }

    public final QuickExperimentInfo m2297a(String str, DataSource dataSource) {
        return new Builder().a();
    }

    public final void m2300a(QuickExperimentMemoryCacheObserver quickExperimentMemoryCacheObserver) {
    }

    public final QuickExperimentMemoryCacheInitializer m2305e() {
        return new C01011(this);
    }
}

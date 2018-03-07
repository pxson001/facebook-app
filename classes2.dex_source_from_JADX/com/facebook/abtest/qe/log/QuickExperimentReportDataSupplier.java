package com.facebook.abtest.qe.log;

import com.facebook.abtest.qe.bootstrap.cache.QuickExperimentMemoryCache;
import com.facebook.abtest.qe.bootstrap.cache.QuickExperimentMemoryCache.QuickExperimentMemoryCacheObserver;
import com.facebook.abtest.qe.bootstrap.data.BasicQuickExperimentInfo;
import com.facebook.abtest.qe.bootstrap.registry.QuickExperimentRegistry;
import com.facebook.common.errorreporting.FbCustomReportDataSupplier;
import com.facebook.common.init.INeedInit;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.manager.Authority;
import com.facebook.qe.api.manager.QeManager;
import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: udp_prime_succeeded */
public class QuickExperimentReportDataSupplier implements QuickExperimentMemoryCacheObserver, FbCustomReportDataSupplier, INeedInit {
    private static volatile QuickExperimentReportDataSupplier f2067e;
    private final Lazy<QuickExperimentMemoryCache> f2068a;
    private final Lazy<QuickExperimentRegistry> f2069b;
    private final Lazy<QeManager> f2070c;
    private String f2071d;

    public static com.facebook.abtest.qe.log.QuickExperimentReportDataSupplier m4218a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2067e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.abtest.qe.log.QuickExperimentReportDataSupplier.class;
        monitor-enter(r1);
        r0 = f2067e;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m4219b(r0);	 Catch:{ all -> 0x0035 }
        f2067e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2067e;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.abtest.qe.log.QuickExperimentReportDataSupplier.a(com.facebook.inject.InjectorLike):com.facebook.abtest.qe.log.QuickExperimentReportDataSupplier");
    }

    private static QuickExperimentReportDataSupplier m4219b(InjectorLike injectorLike) {
        return new QuickExperimentReportDataSupplier(IdBasedSingletonScopeProvider.m1810b(injectorLike, 3219), IdBasedSingletonScopeProvider.m1810b(injectorLike, 72), IdBasedSingletonScopeProvider.m1810b(injectorLike, 71));
    }

    @Inject
    public QuickExperimentReportDataSupplier(Lazy<QeManager> lazy, Lazy<QuickExperimentMemoryCache> lazy2, Lazy<QuickExperimentRegistry> lazy3) {
        this.f2070c = lazy;
        this.f2068a = lazy2;
        this.f2069b = lazy3;
    }

    public void init() {
        ((QuickExperimentMemoryCache) this.f2068a.get()).mo539a((QuickExperimentMemoryCacheObserver) this);
    }

    public final String mo633a(Throwable th) {
        return this.f2071d;
    }

    public final String mo632a() {
        return "active_quick_experiments";
    }

    public final void mo634b() {
        Map c = Maps.m838c();
        Iterator it = ((QuickExperimentRegistry) this.f2069b.get()).a().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            BasicQuickExperimentInfo b = ((QuickExperimentMemoryCache) this.f2068a.get()).mo540b(str);
            if (b.f10006c) {
                c.put(str, b.f10008e);
            }
        }
        for (String str2 : ((QeManager) this.f2070c.get()).mo603d()) {
            if (((QeManager) this.f2070c.get()).mo595a(Authority.EFFECTIVE, str2)) {
                c.put(str2, ((QeManager) this.f2070c.get()).mo597b(Authority.EFFECTIVE, str2));
            }
        }
        this.f2071d = Joiner.on("\n").withKeyValueSeparator(": ").join(c);
    }

    public final void mo635c() {
        this.f2071d = "";
    }
}

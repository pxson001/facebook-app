package com.facebook.feed.rows.prefetch;

import com.facebook.feed.rows.prefetch.abtest.ExperimentsForPrefetchAbtestModule;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.prefetch.DefaultPrefetcherFactoryProvider;
import com.facebook.photos.prefetch.PrefetchRange;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: param_key_bug_report_activity_files */
public class MultiRowImagePrefetcherFactory {
    private static volatile MultiRowImagePrefetcherFactory f10399d;
    private final MultiRowImagePrefetcherWrapperImplProvider f10400a;
    private final DefaultPrefetcherFactoryProvider f10401b;
    private final QeAccessor f10402c;

    public static com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherFactory m15494a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10399d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherFactory.class;
        monitor-enter(r1);
        r0 = f10399d;	 Catch:{ all -> 0x003a }
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
        r0 = m15495b(r0);	 Catch:{ all -> 0x0035 }
        f10399d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10399d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherFactory.a(com.facebook.inject.InjectorLike):com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherFactory");
    }

    private static MultiRowImagePrefetcherFactory m15495b(InjectorLike injectorLike) {
        return new MultiRowImagePrefetcherFactory((DefaultPrefetcherFactoryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DefaultPrefetcherFactoryProvider.class), (MultiRowImagePrefetcherWrapperImplProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MultiRowImagePrefetcherWrapperImplProvider.class), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public MultiRowImagePrefetcherFactory(DefaultPrefetcherFactoryProvider defaultPrefetcherFactoryProvider, MultiRowImagePrefetcherWrapperImplProvider multiRowImagePrefetcherWrapperImplProvider, QeAccessor qeAccessor) {
        this.f10401b = defaultPrefetcherFactoryProvider;
        this.f10400a = multiRowImagePrefetcherWrapperImplProvider;
        this.f10402c = qeAccessor;
    }

    public final MultiRowImagePrefetcherWrapper m15496a() {
        return this.f10400a.m15498a(this.f10401b.m15497a(new PrefetchRange(this.f10402c.mo572a(ExperimentsForPrefetchAbtestModule.f10435b, 50), this.f10402c.mo572a(ExperimentsForPrefetchAbtestModule.f10437d, 20), this.f10402c.mo572a(ExperimentsForPrefetchAbtestModule.f10434a, 60), this.f10402c.mo572a(ExperimentsForPrefetchAbtestModule.f10436c, 20))));
    }
}

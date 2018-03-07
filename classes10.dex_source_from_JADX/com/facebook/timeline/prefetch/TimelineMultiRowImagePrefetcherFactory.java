package com.facebook.timeline.prefetch;

import com.facebook.feed.rows.prefetch.EmptyPrefetcher;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherWrapper;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherWrapperImplProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.prefetch.DefaultPrefetcherFactoryProvider;
import com.facebook.photos.prefetch.PrefetchRange;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: feed_find_friends */
public class TimelineMultiRowImagePrefetcherFactory {
    private static volatile TimelineMultiRowImagePrefetcherFactory f12079d;
    private final MultiRowImagePrefetcherWrapperImplProvider f12080a;
    private final DefaultPrefetcherFactoryProvider f12081b;
    private final QeAccessor f12082c;

    public static com.facebook.timeline.prefetch.TimelineMultiRowImagePrefetcherFactory m12085a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12079d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.prefetch.TimelineMultiRowImagePrefetcherFactory.class;
        monitor-enter(r1);
        r0 = f12079d;	 Catch:{ all -> 0x003a }
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
        r0 = m12086b(r0);	 Catch:{ all -> 0x0035 }
        f12079d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12079d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.prefetch.TimelineMultiRowImagePrefetcherFactory.a(com.facebook.inject.InjectorLike):com.facebook.timeline.prefetch.TimelineMultiRowImagePrefetcherFactory");
    }

    private static TimelineMultiRowImagePrefetcherFactory m12086b(InjectorLike injectorLike) {
        return new TimelineMultiRowImagePrefetcherFactory((DefaultPrefetcherFactoryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DefaultPrefetcherFactoryProvider.class), (MultiRowImagePrefetcherWrapperImplProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MultiRowImagePrefetcherWrapperImplProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public TimelineMultiRowImagePrefetcherFactory(DefaultPrefetcherFactoryProvider defaultPrefetcherFactoryProvider, MultiRowImagePrefetcherWrapperImplProvider multiRowImagePrefetcherWrapperImplProvider, QeAccessor qeAccessor) {
        this.f12081b = defaultPrefetcherFactoryProvider;
        this.f12080a = multiRowImagePrefetcherWrapperImplProvider;
        this.f12082c = qeAccessor;
    }

    public final MultiRowImagePrefetcherWrapper m12087a() {
        if (!this.f12082c.a(ExperimentsForTimelineAbTestModule.at, false)) {
            return new EmptyPrefetcher();
        }
        return this.f12080a.a(this.f12081b.a(new PrefetchRange(this.f12082c.a(ExperimentsForTimelineAbTestModule.av, 0), this.f12082c.a(ExperimentsForTimelineAbTestModule.au, 0), this.f12082c.a(ExperimentsForTimelineAbTestModule.as, 0), this.f12082c.a(ExperimentsForTimelineAbTestModule.ar, 0))));
    }
}

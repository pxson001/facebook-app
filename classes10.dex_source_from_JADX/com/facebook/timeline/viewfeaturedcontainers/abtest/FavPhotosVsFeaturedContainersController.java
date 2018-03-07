package com.facebook.timeline.viewfeaturedcontainers.abtest;

import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.ultralight.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: extra_events_discovery_fragment_time_filters */
public class FavPhotosVsFeaturedContainersController {
    private static volatile FavPhotosVsFeaturedContainersController f12831b;
    private final QeAccessor f12832a;

    public static com.facebook.timeline.viewfeaturedcontainers.abtest.FavPhotosVsFeaturedContainersController m12774a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12831b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.viewfeaturedcontainers.abtest.FavPhotosVsFeaturedContainersController.class;
        monitor-enter(r1);
        r0 = f12831b;	 Catch:{ all -> 0x003a }
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
        r0 = m12775b(r0);	 Catch:{ all -> 0x0035 }
        f12831b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12831b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.abtest.FavPhotosVsFeaturedContainersController.a(com.facebook.inject.InjectorLike):com.facebook.timeline.viewfeaturedcontainers.abtest.FavPhotosVsFeaturedContainersController");
    }

    private static FavPhotosVsFeaturedContainersController m12775b(InjectorLike injectorLike) {
        return new FavPhotosVsFeaturedContainersController((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    private FavPhotosVsFeaturedContainersController(QeAccessor qeAccessor) {
        this.f12832a = qeAccessor;
    }

    public final boolean m12776a() {
        return !m12778c() && this.f12832a.a(ExperimentsForTimelineAbTestModule.ad, false);
    }

    public final boolean m12777b() {
        return !m12778c() && this.f12832a.a(ExperimentsForTimelineAbTestModule.ab, false);
    }

    public final boolean m12778c() {
        return this.f12832a.a(ExperimentsForTimelineAbTestModule.K, false);
    }
}

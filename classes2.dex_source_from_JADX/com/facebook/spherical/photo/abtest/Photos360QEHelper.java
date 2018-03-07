package com.facebook.spherical.photo.abtest;

import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: hidden */
public class Photos360QEHelper {
    private static volatile Photos360QEHelper f21101b;
    public final QeAccessor f21102a;

    public static com.facebook.spherical.photo.abtest.Photos360QEHelper m28837a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21101b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.spherical.photo.abtest.Photos360QEHelper.class;
        monitor-enter(r1);
        r0 = f21101b;	 Catch:{ all -> 0x003a }
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
        r0 = m28838b(r0);	 Catch:{ all -> 0x0035 }
        f21101b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21101b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.spherical.photo.abtest.Photos360QEHelper.a(com.facebook.inject.InjectorLike):com.facebook.spherical.photo.abtest.Photos360QEHelper");
    }

    private static Photos360QEHelper m28838b(InjectorLike injectorLike) {
        return new Photos360QEHelper(QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public Photos360QEHelper(QeAccessor qeAccessor) {
        this.f21102a = qeAccessor;
    }

    public final int m28839d() {
        return this.f21102a.mo572a(ExperimentsForPhotos360AbTestModule.a, 768);
    }

    public final int m28840e() {
        return this.f21102a.mo572a(ExperimentsForPhotos360AbTestModule.c, 1024);
    }

    public final int m28841f() {
        return this.f21102a.mo572a(ExperimentsForPhotos360AbTestModule.b, 1536);
    }

    public final int m28842g() {
        return this.f21102a.mo572a(ExperimentsForPhotos360AbTestModule.d, 1536);
    }

    public final boolean m28843i() {
        return this.f21102a.mo596a(ExperimentsForPhotos360AbTestModule.i, false);
    }

    public final boolean m28844j() {
        return this.f21102a.mo596a(ExperimentsForPhotos360AbTestModule.j, false);
    }
}

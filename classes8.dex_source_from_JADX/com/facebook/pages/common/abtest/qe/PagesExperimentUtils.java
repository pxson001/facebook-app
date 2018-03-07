package com.facebook.pages.common.abtest.qe;

import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: task_key_mutate_like */
public class PagesExperimentUtils {
    private static volatile PagesExperimentUtils f1675c;
    private final QeAccessor f1676a;
    private final FbAppType f1677b;

    public static com.facebook.pages.common.abtest.qe.PagesExperimentUtils m1891a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1675c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.common.abtest.qe.PagesExperimentUtils.class;
        monitor-enter(r1);
        r0 = f1675c;	 Catch:{ all -> 0x003a }
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
        r0 = m1892b(r0);	 Catch:{ all -> 0x0035 }
        f1675c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1675c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.abtest.qe.PagesExperimentUtils.a(com.facebook.inject.InjectorLike):com.facebook.pages.common.abtest.qe.PagesExperimentUtils");
    }

    private static PagesExperimentUtils m1892b(InjectorLike injectorLike) {
        return new PagesExperimentUtils((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class));
    }

    @Inject
    public PagesExperimentUtils(QeAccessor qeAccessor, FbAppType fbAppType) {
        this.f1676a = qeAccessor;
        this.f1677b = fbAppType;
    }

    public final boolean m1893a() {
        if (this.f1677b.j != Product.PAA && m1897e() && this.f1676a.a(Liveness.Live, ExperimentsForPagesCommonAbTestModule.f1673m, false)) {
            return true;
        }
        return false;
    }

    public final boolean m1894b() {
        return m1897e() && this.f1676a.a(ExperimentsForPagesCommonAbTestModule.f1668h, false);
    }

    public final boolean m1895c() {
        return m1897e() && this.f1676a.a(Liveness.Live, ExperimentsForPagesCommonAbTestModule.f1674n, false);
    }

    public final boolean m1896d() {
        return m1897e() && this.f1676a.a(Liveness.Live, ExperimentsForPagesCommonAbTestModule.f1671k, false);
    }

    public final boolean m1897e() {
        return this.f1676a.a(Liveness.Live, ExperimentsForPagesCommonAbTestModule.f1672l, false);
    }

    public final boolean m1898g() {
        return m1897e() && m1893a() && m1896d() && this.f1676a.a(Liveness.Live, ExperimentsForPagesCommonAbTestModule.f1663c, false);
    }

    public final boolean m1899h() {
        return m1897e() && m1893a() && m1896d() && this.f1676a.a(Liveness.Live, ExperimentsForPagesCommonAbTestModule.f1665e, false);
    }

    public final boolean m1900i() {
        return m1897e() && m1893a() && m1896d() && this.f1676a.a(Liveness.Live, ExperimentsForPagesCommonAbTestModule.f1664d, false);
    }

    public final boolean m1901j() {
        return m1897e() && m1893a() && m1896d() && this.f1676a.a(Liveness.Live, ExperimentsForPagesCommonAbTestModule.f1666f, false);
    }

    public final boolean m1902k() {
        return m1897e() && m1893a() && m1896d() && this.f1676a.a(Liveness.Live, ExperimentsForPagesCommonAbTestModule.f1667g, false);
    }
}

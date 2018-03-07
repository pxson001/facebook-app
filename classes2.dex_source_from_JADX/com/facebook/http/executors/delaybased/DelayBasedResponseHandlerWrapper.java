package com.facebook.http.executors.delaybased;

import com.facebook.common.init.INeedInit;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.http.engine.HttpRequestExecutor;
import com.facebook.http.qe.ExperimentsForHttpQeModule;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.Random;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: timestamp_ms */
public class DelayBasedResponseHandlerWrapper implements INeedInit {
    private static volatile DelayBasedResponseHandlerWrapper f2695g;
    private final Lazy<HttpRequestExecutor> f2696a;
    public final Random f2697b = new Random();
    public final Liger2gEmpathyConfigParams f2698c;
    private final QeAccessor f2699d;
    private final FbAppType f2700e;
    public int f2701f;

    public static com.facebook.http.executors.delaybased.DelayBasedResponseHandlerWrapper m4731a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2695g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.executors.delaybased.DelayBasedResponseHandlerWrapper.class;
        monitor-enter(r1);
        r0 = f2695g;	 Catch:{ all -> 0x003a }
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
        r0 = m4732b(r0);	 Catch:{ all -> 0x0035 }
        f2695g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2695g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.executors.delaybased.DelayBasedResponseHandlerWrapper.a(com.facebook.inject.InjectorLike):com.facebook.http.executors.delaybased.DelayBasedResponseHandlerWrapper");
    }

    private static DelayBasedResponseHandlerWrapper m4732b(InjectorLike injectorLike) {
        return new DelayBasedResponseHandlerWrapper(IdBasedSingletonScopeProvider.m1810b(injectorLike, 2263), Liger2gEmpathyConfigParams.m4733a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class));
    }

    @Inject
    public DelayBasedResponseHandlerWrapper(Lazy<HttpRequestExecutor> lazy, Liger2gEmpathyConfigParams liger2gEmpathyConfigParams, QeAccessor qeAccessor, FbAppType fbAppType) {
        this.f2696a = lazy;
        this.f2698c = liger2gEmpathyConfigParams;
        this.f2699d = qeAccessor;
        this.f2700e = fbAppType;
        this.f2701f = 10;
    }

    public void init() {
        if (this.f2700e.j != Product.MESSENGER && this.f2699d.mo596a(ExperimentsForHttpQeModule.aL, false)) {
            this.f2696a.get();
        }
    }
}

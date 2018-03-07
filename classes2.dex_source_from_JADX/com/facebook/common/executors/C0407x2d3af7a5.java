package com.facebook.common.executors;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.util.concurrent.ListeningExecutorService;

/* compiled from: postponed_until */
public class C0407x2d3af7a5 extends AbstractProvider<ListeningExecutorService> {
    private static volatile ListeningExecutorService f9359a;

    public static com.google.common.util.concurrent.ListeningExecutorService m14328a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9359a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.executors.C0407x2d3af7a5.class;
        monitor-enter(r1);
        r0 = f9359a;	 Catch:{ all -> 0x003a }
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
        r0 = com.facebook.common.executors.C0407x2d3af7a5.m14329b(r0);	 Catch:{ all -> 0x0035 }
        f9359a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9359a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.executors.ListeningExecutorService_BrowserBackgroundRequestExecutorMethodAutoProvider.a(com.facebook.inject.InjectorLike):com.google.common.util.concurrent.ListeningExecutorService");
    }

    private static ListeningExecutorService m14329b(InjectorLike injectorLike) {
        return ExecutorsModule.m1734g(ThreadPoolFactory.m1885a(injectorLike), BaseBackgroundWorkLogger.m1660a(injectorLike), IdBasedProvider.m1811a(injectorLike, 375), ConstrainedExecutorsStatusController.m1909a(injectorLike));
    }

    public Object get() {
        return ExecutorsModule.m1734g(ThreadPoolFactory.m1885a((InjectorLike) this), BaseBackgroundWorkLogger.m1660a((InjectorLike) this), IdBasedProvider.m1811a(this, 375), ConstrainedExecutorsStatusController.m1909a(this));
    }
}

package com.facebook.common.executors;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;

/* compiled from: update_recent_emoji */
public class C0115xfdf5bd2 extends AbstractProvider<ListeningScheduledExecutorService> {
    private static volatile ListeningScheduledExecutorService f1767a;

    public static com.google.common.util.concurrent.ListeningScheduledExecutorService m3569a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1767a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.executors.C0115xfdf5bd2.class;
        monitor-enter(r1);
        r0 = f1767a;	 Catch:{ all -> 0x003a }
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
        r0 = com.facebook.common.executors.C0115xfdf5bd2.m3570b(r0);	 Catch:{ all -> 0x0035 }
        f1767a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1767a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(com.facebook.inject.InjectorLike):com.google.common.util.concurrent.ListeningScheduledExecutorService");
    }

    private static ListeningScheduledExecutorService m3570b(InjectorLike injectorLike) {
        return ExecutorsModule.m1712a(Looper_ForNonUiThreadMethodAutoProvider.m3572b(injectorLike), IdBasedProvider.m1811a(injectorLike, 375));
    }

    public Object get() {
        return ExecutorsModule.m1712a(Looper_ForNonUiThreadMethodAutoProvider.m3572b(this), IdBasedProvider.m1811a(this, 375));
    }
}

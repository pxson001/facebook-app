package com.facebook.qe.module;

import android.content.Context;
import com.facebook.common.process.DefaultProcessUtil;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.impl.QeInternalImpl;

/* compiled from: unsupported_category */
public class QeInternalImplMethodAutoProvider extends AbstractProvider<QeInternalImpl> {
    private static volatile QeInternalImpl f1852a;

    public static com.facebook.qe.api.impl.QeInternalImpl m3744a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1852a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.qe.module.QeInternalImplMethodAutoProvider.class;
        monitor-enter(r1);
        r0 = f1852a;	 Catch:{ all -> 0x003a }
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
        r0 = m3745b(r0);	 Catch:{ all -> 0x0035 }
        f1852a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1852a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.qe.module.QeInternalImplMethodAutoProvider.a(com.facebook.inject.InjectorLike):com.facebook.qe.api.impl.QeInternalImpl");
    }

    private static QeInternalImpl m3745b(InjectorLike injectorLike) {
        return QeModule.m3853a((Context) injectorLike.getInstance(Context.class), QeLoggedInUserIdentityProvider.m3746b(injectorLike), QeRecentUserIdentitiesProvider.m3748b(injectorLike), QeExposureLogger.m3755b(injectorLike), QeMigratedExperimentProvider.m3848b(injectorLike), DefaultProcessUtil.m2387a(injectorLike), QeAccessorObserverMethodAutoProvider.m3849a(injectorLike));
    }

    public Object get() {
        return QeModule.m3853a((Context) getInstance(Context.class), QeLoggedInUserIdentityProvider.m3746b(this), QeRecentUserIdentitiesProvider.m3748b(this), QeExposureLogger.m3755b(this), QeMigratedExperimentProvider.m3848b(this), DefaultProcessUtil.m2387a(this), QeAccessorObserverMethodAutoProvider.m3849a(this));
    }
}

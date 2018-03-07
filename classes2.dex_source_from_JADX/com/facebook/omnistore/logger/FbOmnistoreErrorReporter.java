package com.facebook.omnistore.logger;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.omnistore.OmnistoreErrorReporter;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mAnimationFrames */
public class FbOmnistoreErrorReporter implements OmnistoreErrorReporter {
    private static volatile FbOmnistoreErrorReporter f15716x451940cc;
    private final AbstractFbErrorReporter mFbErrorReporter;

    public static com.facebook.omnistore.logger.FbOmnistoreErrorReporter m22402x8d6f1acc(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15716x451940cc;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.omnistore.logger.FbOmnistoreErrorReporter.class;
        monitor-enter(r1);
        r0 = f15716x451940cc;	 Catch:{ all -> 0x003a }
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
        r0 = m22401xdda515f2(r0);	 Catch:{ all -> 0x0035 }
        f15716x451940cc = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15716x451940cc;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.omnistore.logger.FbOmnistoreErrorReporter.getInstance__com_facebook_omnistore_logger_FbOmnistoreErrorReporter__INJECTED_BY_TemplateInjector(com.facebook.inject.InjectorLike):com.facebook.omnistore.logger.FbOmnistoreErrorReporter");
    }

    private static FbOmnistoreErrorReporter m22401xdda515f2(InjectorLike injectorLike) {
        return new FbOmnistoreErrorReporter(FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public FbOmnistoreErrorReporter(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.mFbErrorReporter = abstractFbErrorReporter;
    }

    public void reportError(String str, String str2) {
        this.mFbErrorReporter.m2340a(str, str2);
    }
}

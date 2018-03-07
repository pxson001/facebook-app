package com.facebook.adinterfaces.error;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: \d{4} */
public class AdInterfacesErrorReporter {
    private static volatile AdInterfacesErrorReporter f21649b;
    private AbstractFbErrorReporter f21650a;

    public static com.facebook.adinterfaces.error.AdInterfacesErrorReporter m22724a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21649b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.adinterfaces.error.AdInterfacesErrorReporter.class;
        monitor-enter(r1);
        r0 = f21649b;	 Catch:{ all -> 0x003a }
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
        r0 = m22725b(r0);	 Catch:{ all -> 0x0035 }
        f21649b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21649b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.error.AdInterfacesErrorReporter.a(com.facebook.inject.InjectorLike):com.facebook.adinterfaces.error.AdInterfacesErrorReporter");
    }

    private static AdInterfacesErrorReporter m22725b(InjectorLike injectorLike) {
        return new AdInterfacesErrorReporter((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    AdInterfacesErrorReporter(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f21650a = abstractFbErrorReporter;
    }

    public final void m22727a(Class cls, String str, Throwable th) {
        AbstractFbErrorReporter abstractFbErrorReporter = this.f21650a;
        SoftErrorBuilder a = SoftError.a("Ad Interfaces: " + cls.toString(), str);
        a.e = 100;
        a = a;
        a.c = th;
        abstractFbErrorReporter.a(a.g());
    }

    public final void m22726a(Class cls, String str) {
        AbstractFbErrorReporter abstractFbErrorReporter = this.f21650a;
        SoftErrorBuilder a = SoftError.a("Ad Interfaces: " + cls.toString(), str);
        a.e = 100;
        abstractFbErrorReporter.a(a.g());
    }
}

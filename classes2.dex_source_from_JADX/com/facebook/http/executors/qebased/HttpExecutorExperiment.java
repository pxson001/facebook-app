package com.facebook.http.executors.qebased;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.common.perftest.base.PerfTestConfigBase.MainLoader;
import com.facebook.common.util.TriState;
import com.facebook.http.executors.liger.LigerLibraryLoader;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.app.module.MainProcessModule;
import com.facebook.katana.app.module.MainProcessModule.C03331;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: referer_data */
public class HttpExecutorExperiment {
    private static final String f7830a = HttpExecutorExperiment.class.getName();
    private static volatile HttpExecutorExperiment f7831h;
    private final QeAccessor f7832b;
    private final C03331 f7833c;
    private final AbstractFbErrorReporter f7834d;
    private final LigerLibraryLoader f7835e;
    private final PerfTestConfig f7836f;
    private TriState f7837g = TriState.UNSET;

    /* compiled from: referer_data */
    public enum HttpEngine {
        APACHE,
        LIGER
    }

    public static com.facebook.http.executors.qebased.HttpExecutorExperiment m12375a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7831h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.executors.qebased.HttpExecutorExperiment.class;
        monitor-enter(r1);
        r0 = f7831h;	 Catch:{ all -> 0x003a }
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
        r0 = m12376b(r0);	 Catch:{ all -> 0x0035 }
        f7831h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7831h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.executors.qebased.HttpExecutorExperiment.a(com.facebook.inject.InjectorLike):com.facebook.http.executors.qebased.HttpExecutorExperiment");
    }

    private static HttpExecutorExperiment m12376b(InjectorLike injectorLike) {
        return new HttpExecutorExperiment(QeInternalImplMethodAutoProvider.m3744a(injectorLike), MainProcessModule.m4778a((QeAccessor) QeInternalImplMethodAutoProvider.m3744a(injectorLike)), FbErrorReporterImpl.m2317a(injectorLike), LigerLibraryLoader.m12379b(injectorLike), PerfTestConfig.m2936a(injectorLike));
    }

    @Inject
    public HttpExecutorExperiment(QeAccessor qeAccessor, C03331 c03331, AbstractFbErrorReporter abstractFbErrorReporter, LigerLibraryLoader ligerLibraryLoader, PerfTestConfig perfTestConfig) {
        this.f7832b = qeAccessor;
        this.f7833c = c03331;
        this.f7834d = abstractFbErrorReporter;
        this.f7835e = ligerLibraryLoader;
        this.f7836f = perfTestConfig;
    }

    public final HttpEngine m12378a() {
        HttpEngine httpEngine = HttpEngine.APACHE;
        if (!m12377b() || !this.f7835e.m12380a()) {
            return httpEngine;
        }
        if (PerfTestConfigBase.m2938a()) {
            String str;
            if (MainLoader.f2040b) {
                str = "liger_engine_enabled";
            } else if (MainLoader.f2041c) {
                str = "okhttp_engine_enabled";
            } else {
                str = "no_valid_engine";
            }
            if (str.equals("liger_engine_enabled")) {
                return HttpEngine.LIGER;
            }
        }
        if (this.f7833c.f7838a) {
            return HttpEngine.LIGER;
        }
        return HttpEngine.APACHE;
    }

    private boolean m12377b() {
        try {
            Class.forName("org.apache.http.client.methods.HttpUriRequest").getMethod("getAllHeaders", new Class[0]).equals(null);
            return true;
        } catch (Throwable th) {
            this.f7834d.m2346a(f7830a, th);
            return false;
        }
    }
}

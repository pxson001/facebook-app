package com.facebook.http.common;

import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.xconfig.core.XConfigReader;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: refetched */
public class FbHttpRequestSampleController {
    private static volatile FbHttpRequestSampleController f7822f;
    private int f7823a = 20;
    private double f7824b = (1.0d / ((double) this.f7823a));
    private boolean f7825c;
    public final Provider<TriState> f7826d;
    private final Lazy<XConfigReader> f7827e;

    public static com.facebook.http.common.FbHttpRequestSampleController m12366a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7822f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.common.FbHttpRequestSampleController.class;
        monitor-enter(r1);
        r0 = f7822f;	 Catch:{ all -> 0x003a }
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
        r0 = m12368b(r0);	 Catch:{ all -> 0x0035 }
        f7822f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7822f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.FbHttpRequestSampleController.a(com.facebook.inject.InjectorLike):com.facebook.http.common.FbHttpRequestSampleController");
    }

    private static FbHttpRequestSampleController m12368b(InjectorLike injectorLike) {
        return new FbHttpRequestSampleController(IdBasedProvider.m1811a(injectorLike, 692), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3749));
    }

    @Inject
    public FbHttpRequestSampleController(Provider<TriState> provider, Lazy<XConfigReader> lazy) {
        this.f7826d = provider;
        this.f7827e = lazy;
    }

    private double m12367b() {
        m12369c();
        return this.f7824b;
    }

    private synchronized void m12369c() {
        if (!this.f7825c) {
            this.f7825c = true;
            this.f7823a = ((XConfigReader) this.f7827e.get()).m2683a(RequestSamplingConfig.f11974c, 20);
            this.f7824b = 1.0d / ((double) this.f7823a);
        }
    }

    public final boolean m12370a() {
        return ((TriState) this.f7826d.get()).asBoolean(false) || Math.random() < m12367b();
    }
}

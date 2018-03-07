package com.facebook.crudolib.netengine.fbhttp;

import com.facebook.crudolib.netengine.fbhttp.RequestSynchronizationBarrier.RequestFutureCallback;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.inject.InjectorLike;
import com.google.common.util.concurrent.Futures;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: TincanFindOrCreateThread */
public class FbHttpEngine {
    private static volatile FbHttpEngine f24052b;
    private final FbHttpRequestProcessor f24053a;

    public static com.facebook.crudolib.netengine.fbhttp.FbHttpEngine m25995a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f24052b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.crudolib.netengine.fbhttp.FbHttpEngine.class;
        monitor-enter(r1);
        r0 = f24052b;	 Catch:{ all -> 0x003a }
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
        r0 = m25996b(r0);	 Catch:{ all -> 0x0035 }
        f24052b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f24052b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.crudolib.netengine.fbhttp.FbHttpEngine.a(com.facebook.inject.InjectorLike):com.facebook.crudolib.netengine.fbhttp.FbHttpEngine");
    }

    private static FbHttpEngine m25996b(InjectorLike injectorLike) {
        return new FbHttpEngine(FbHttpRequestProcessor.a(injectorLike));
    }

    @Inject
    public FbHttpEngine(FbHttpRequestProcessor fbHttpRequestProcessor) {
        this.f24053a = fbHttpRequestProcessor;
    }

    public final FbHttpEngineResponse m25997a(FbHttpEngineRequest fbHttpEngineRequest) {
        fbHttpEngineRequest = fbHttpEngineRequest;
        FbHttpEngineResponse fbHttpEngineResponse = new FbHttpEngineResponse();
        fbHttpEngineRequest.f24064d.f24072a = fbHttpEngineResponse;
        Futures.a(this.f24053a.b(fbHttpEngineRequest.f24065e).b, new RequestFutureCallback(fbHttpEngineResponse.f24070a));
        fbHttpEngineResponse.f24070a.m26023b();
        return fbHttpEngineResponse;
    }
}

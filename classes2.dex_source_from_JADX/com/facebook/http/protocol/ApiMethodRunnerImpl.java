package com.facebook.http.protocol;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.http.protocol.ApiMethodRunner.Batch;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: payments_force_full_refresh */
public class ApiMethodRunnerImpl {
    private static volatile ApiMethodRunnerImpl f10314c;
    private final AbstractSingleMethodRunner f10315a;
    private final MethodBatcherImpl f10316b;

    public static com.facebook.http.protocol.ApiMethodRunnerImpl m15381a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10314c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.protocol.ApiMethodRunnerImpl.class;
        monitor-enter(r1);
        r0 = f10314c;	 Catch:{ all -> 0x003a }
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
        r0 = m15382b(r0);	 Catch:{ all -> 0x0035 }
        f10314c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10314c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.protocol.ApiMethodRunnerImpl.a(com.facebook.inject.InjectorLike):com.facebook.http.protocol.ApiMethodRunnerImpl");
    }

    private static ApiMethodRunnerImpl m15382b(InjectorLike injectorLike) {
        return new ApiMethodRunnerImpl(SingleMethodRunnerImpl.m11724a(injectorLike), MethodBatcherImpl.m15387a(injectorLike));
    }

    @Inject
    public ApiMethodRunnerImpl(AbstractSingleMethodRunner abstractSingleMethodRunner, MethodBatcherImpl methodBatcherImpl) {
        this.f10315a = abstractSingleMethodRunner;
        this.f10316b = methodBatcherImpl;
    }

    public final <PARAMS, RESULT> RESULT m15384a(ApiMethod<PARAMS, RESULT> apiMethod, @Nullable PARAMS params) {
        return m15385a(apiMethod, params, null);
    }

    public final <PARAMS, RESULT> RESULT m15385a(ApiMethod<PARAMS, RESULT> apiMethod, @Nullable PARAMS params, @Nullable ApiMethodRunnerParams apiMethodRunnerParams) {
        return this.f10315a.m11745a((ApiMethod) apiMethod, (Object) params, apiMethodRunnerParams);
    }

    public final <PARAMS, RESULT> RESULT m15386a(ApiMethod<PARAMS, RESULT> apiMethod, @Nullable PARAMS params, @Nullable ApiMethodRunnerParams apiMethodRunnerParams, CallerContext callerContext) {
        return this.f10315a.m11746a(apiMethod, params, apiMethodRunnerParams, callerContext);
    }

    public final Batch m15383a() {
        return this.f10316b.m15389a();
    }
}

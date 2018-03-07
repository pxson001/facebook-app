package com.facebook.zero.datacheck;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.http.protocol.ApiMethodRunnerParams.HttpConfig;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: ौ */
public class ZeroDataCheckerRequestMaker {
    private static final Class<?> f96a = ZeroDataCheckerRequestMaker.class;
    private static final CallerContext f97b = CallerContext.a(ZeroDataCheckerRequestMaker.class);
    private static volatile ZeroDataCheckerRequestMaker f98f;
    private final Lazy<SingleMethodRunner> f99c;
    private final ListeningExecutorService f100d;
    public final ZeroDataCheckerRequestMethod f101e;

    public static com.facebook.zero.datacheck.ZeroDataCheckerRequestMaker m90a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f98f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.zero.datacheck.ZeroDataCheckerRequestMaker.class;
        monitor-enter(r1);
        r0 = f98f;	 Catch:{ all -> 0x003a }
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
        r0 = m92b(r0);	 Catch:{ all -> 0x0035 }
        f98f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f98f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.datacheck.ZeroDataCheckerRequestMaker.a(com.facebook.inject.InjectorLike):com.facebook.zero.datacheck.ZeroDataCheckerRequestMaker");
    }

    private static ZeroDataCheckerRequestMaker m92b(InjectorLike injectorLike) {
        return new ZeroDataCheckerRequestMaker(IdBasedSingletonScopeProvider.b(injectorLike, 2289), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), new ZeroDataCheckerRequestMethod());
    }

    @Inject
    public ZeroDataCheckerRequestMaker(Lazy<SingleMethodRunner> lazy, ListeningExecutorService listeningExecutorService, ZeroDataCheckerRequestMethod zeroDataCheckerRequestMethod) {
        this.f99c = lazy;
        this.f100d = listeningExecutorService;
        this.f101e = zeroDataCheckerRequestMethod;
    }

    public final ListenableFuture<Void> m93a() {
        final ApiMethodRunnerParams apiMethodRunnerParams = new ApiMethodRunnerParams();
        return this.f100d.a(new Callable<Void>(this) {
            final /* synthetic */ ZeroDataCheckerRequestMaker f93b;

            public Object call() {
                ZeroDataCheckerRequestMaker.m91a(this.f93b, this.f93b.f101e, null, apiMethodRunnerParams);
                return null;
            }
        });
    }

    public final ListenableFuture<Void> m94b() {
        final ApiMethodRunnerParams apiMethodRunnerParams = new ApiMethodRunnerParams();
        apiMethodRunnerParams.a(HttpConfig.BOOTSTRAP);
        return this.f100d.a(new Callable<Void>(this) {
            final /* synthetic */ ZeroDataCheckerRequestMaker f95b;

            public Object call() {
                ZeroDataCheckerRequestMaker.m91a(this.f95b, this.f95b.f101e, null, apiMethodRunnerParams);
                return null;
            }
        });
    }

    public static <PARAMS, RESULT> Object m91a(ZeroDataCheckerRequestMaker zeroDataCheckerRequestMaker, @Nullable ApiMethod apiMethod, Object obj, ApiMethodRunnerParams apiMethodRunnerParams) {
        return ((AbstractSingleMethodRunner) zeroDataCheckerRequestMaker.f99c.get()).a(apiMethod, obj, apiMethodRunnerParams, f97b);
    }
}

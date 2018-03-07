package com.facebook.zero.service;

import android.os.Bundle;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.zero.sdk.util.ZeroNetworkAndTelephonyHelper;
import com.facebook.zero.server.ZeroUpdateStatusParams;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: wed */
public class ZeroUpdateStatusManager {
    public static final Class<?> f235a = ZeroUpdateStatusManager.class;
    public static final CallerContext f236b = CallerContext.a(ZeroUpdateStatusManager.class);
    private static volatile ZeroUpdateStatusManager f237g;
    public final Lazy<BlueServiceOperationFactory> f238c;
    public final Lazy<FbErrorReporter> f239d;
    public final Lazy<ZeroNetworkAndTelephonyHelper> f240e;
    @DefaultExecutorService
    private final Lazy<ExecutorService> f241f;

    public static com.facebook.zero.service.ZeroUpdateStatusManager m236a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f237g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.zero.service.ZeroUpdateStatusManager.class;
        monitor-enter(r1);
        r0 = f237g;	 Catch:{ all -> 0x003a }
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
        r0 = m237b(r0);	 Catch:{ all -> 0x0035 }
        f237g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f237g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.service.ZeroUpdateStatusManager.a(com.facebook.inject.InjectorLike):com.facebook.zero.service.ZeroUpdateStatusManager");
    }

    private static ZeroUpdateStatusManager m237b(InjectorLike injectorLike) {
        return new ZeroUpdateStatusManager(IdBasedLazy.a(injectorLike, 1144), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedLazy.a(injectorLike, 3799), IdBasedLazy.a(injectorLike, 393), IdBasedSingletonScopeProvider.b(injectorLike, 3834));
    }

    @Inject
    public ZeroUpdateStatusManager(Lazy<BlueServiceOperationFactory> lazy, Lazy<FbErrorReporter> lazy2, Lazy<ZeroNetworkAndTelephonyHelper> lazy3, Lazy<FbBroadcastManager> lazy4, Lazy<ExecutorService> lazy5) {
        this.f238c = lazy;
        this.f239d = lazy2;
        this.f240e = lazy3;
        this.f241f = lazy5;
    }

    public final void m238a(final String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("zeroUpdateStatusParams", new ZeroUpdateStatusParams(((ZeroNetworkAndTelephonyHelper) this.f240e.get()).a(), ((ZeroNetworkAndTelephonyHelper) this.f240e.get()).b(), str));
        OperationFuture a = BlueServiceOperationFactoryDetour.a((DefaultBlueServiceOperationFactory) this.f238c.get(), "zero_update_status", bundle, ErrorPropagation.BY_EXCEPTION, f236b, -859668491).a();
        a.a(RequestPriority.INTERACTIVE);
        Futures.a(a, new FutureCallback<OperationResult>(this) {
            final /* synthetic */ ZeroUpdateStatusManager f234b;

            public void onFailure(Throwable th) {
                Class cls = ZeroUpdateStatusManager.f235a;
                th.getMessage();
                ((AbstractFbErrorReporter) this.f234b.f239d.get()).a("zero_rating", "Error update zero status", th);
            }

            public void onSuccess(Object obj) {
                Class cls = ZeroUpdateStatusManager.f235a;
            }
        }, (Executor) this.f241f.get());
    }
}

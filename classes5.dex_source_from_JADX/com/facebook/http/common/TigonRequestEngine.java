package com.facebook.http.common;

import com.facebook.debug.log.BLog;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.FallbackBehavior;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tigon.httpclientadapter.ExperimentsForTigonHttpClientAdapterIfaceModule;
import com.facebook.tigon.httpclientadapter.TigonHttpClientAdapter;
import com.facebook.tigon.httpclientadapter.TigonHttpClientAdapterImpl;
import com.facebook.tigon.httpclientadapter.TigonHttpClientAdapterModule;
import com.facebook.tigon.iface.TigonPriorityData;
import com.facebook.tigon.tigonapi.TigonRequestToken;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import com.google.common.util.concurrent.SettableFuture;
import java.io.IOException;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: doMaybeUploadNext */
public class TigonRequestEngine implements FbHttpRequestEngine {
    public static final Class<?> f4946a = TigonRequestEngine.class;
    private static volatile TigonRequestEngine f4947f;
    private final FbHttpRequestExecutorAdapter f4948b;
    private final TigonHttpClientAdapterImpl f4949c;
    public final Lazy<PassthroughRequestEngine> f4950d;
    private final QeAccessor f4951e;

    public static com.facebook.http.common.TigonRequestEngine m9887a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4947f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.common.TigonRequestEngine.class;
        monitor-enter(r1);
        r0 = f4947f;	 Catch:{ all -> 0x003a }
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
        r0 = m9889b(r0);	 Catch:{ all -> 0x0035 }
        f4947f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4947f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.TigonRequestEngine.a(com.facebook.inject.InjectorLike):com.facebook.http.common.TigonRequestEngine");
    }

    private static TigonRequestEngine m9889b(InjectorLike injectorLike) {
        return new TigonRequestEngine(FbHttpRequestExecutorAdapter.a(injectorLike), TigonHttpClientAdapterImpl.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 7177), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public TigonRequestEngine(FbHttpRequestExecutorAdapter fbHttpRequestExecutorAdapter, TigonHttpClientAdapter tigonHttpClientAdapter, Lazy<PassthroughRequestEngine> lazy, QeAccessor qeAccessor) {
        this.f4948b = fbHttpRequestExecutorAdapter;
        this.f4949c = tigonHttpClientAdapter;
        this.f4950d = lazy;
        this.f4951e = qeAccessor;
    }

    private <T> boolean m9890c(FbHttpRequest<T> fbHttpRequest) {
        if (fbHttpRequest.c == "hprofUpload") {
            return this.f4951e.a(ExperimentsForTigonHttpClientAdapterIfaceModule.a, true);
        }
        return false;
    }

    public final <T> ListenableFuture<T> m9891a(FbHttpRequest<T> fbHttpRequest) {
        if (m9890c(fbHttpRequest)) {
            return ((PassthroughRequestEngine) this.f4950d.get()).m9873a((FbHttpRequest) fbHttpRequest);
        }
        SettableFuture f = SettableFuture.f();
        SettableFuture a = m9888a((FbHttpRequest) fbHttpRequest, f);
        this.f4949c.a(this.f4948b.b(fbHttpRequest), fbHttpRequest.c, fbHttpRequest.c(), fbHttpRequest.m(), fbHttpRequest.f(), fbHttpRequest.h(), fbHttpRequest.n(), fbHttpRequest.o(), fbHttpRequest.j(), fbHttpRequest.i(), a);
        return f;
    }

    private <T> SettableFuture<T> m9888a(final FbHttpRequest<T> fbHttpRequest, final SettableFuture<T> settableFuture) {
        if (fbHttpRequest.f != FallbackBehavior.FALLBACK_REQUIRED) {
            return settableFuture;
        }
        SettableFuture<T> f = SettableFuture.f();
        Futures.a(f, new FutureCallback<T>(this) {
            final /* synthetic */ TigonRequestEngine f4945c;

            /* compiled from: doMaybeUploadNext */
            class C04761 implements FutureCallback<T> {
                final /* synthetic */ C04771 f4942a;

                C04761(C04771 c04771) {
                    this.f4942a = c04771;
                }

                public void onSuccess(@Nullable T t) {
                    FutureDetour.a(settableFuture, t, 541493880);
                }

                public void onFailure(Throwable th) {
                    settableFuture.a(new IOException("Fallback stack exception", th));
                }
            }

            public void onSuccess(@Nullable T t) {
                FutureDetour.a(settableFuture, t, 1645738995);
            }

            public void onFailure(Throwable th) {
                BLog.a(TigonRequestEngine.f4946a, th, "Making fallback request for '%s'", new Object[]{fbHttpRequest.c});
                Futures.a(((PassthroughRequestEngine) this.f4945c.f4950d.get()).m9873a(fbHttpRequest), new C04761(this), DirectExecutor.INSTANCE);
            }
        }, DirectExecutor.INSTANCE);
        return f;
    }

    public final boolean m9896b(FbHttpRequest<?> fbHttpRequest) {
        if (m9890c(fbHttpRequest)) {
            return ((PassthroughRequestEngine) this.f4950d.get()).m9878b((FbHttpRequest) fbHttpRequest);
        }
        TigonHttpClientAdapterImpl tigonHttpClientAdapterImpl = this.f4949c;
        int i = fbHttpRequest.n;
        TigonHttpClientAdapterImpl.a(i, "cancel");
        TigonRequestToken a = tigonHttpClientAdapterImpl.d.a(i);
        if (a == null) {
            BLog.a("TigonHttpClientAdapter", "Race condition trying to cancel");
        } else {
            a.cancel();
        }
        return true;
    }

    public final void m9893a(FbHttpRequest<?> fbHttpRequest, RequestPriority requestPriority) {
        if (m9890c(fbHttpRequest)) {
            ((PassthroughRequestEngine) this.f4950d.get()).m9875a((FbHttpRequest) fbHttpRequest, requestPriority);
            return;
        }
        TigonHttpClientAdapterImpl tigonHttpClientAdapterImpl = this.f4949c;
        int i = fbHttpRequest.n;
        TigonPriorityData tigonPriorityData = new TigonPriorityData(requestPriority.getNumericValue(), 0);
        TigonRequestToken a = tigonHttpClientAdapterImpl.d.a(i);
        if (a == null) {
            boolean z = TigonHttpClientAdapterModule.a;
        } else {
            a.a(tigonPriorityData);
        }
    }

    public final void m9894a(String str, String str2) {
    }

    public final void m9892a() {
        this.f4949c.a.cancelAllRequests();
    }

    public final RequestProcessorSnapshot m9895b() {
        return new RequestProcessorSnapshot(new ArrayList(), new ArrayList());
    }

    public final String m9897c() {
        return this.f4949c.d.a();
    }

    public final String m9898d() {
        return f4946a.getSimpleName();
    }

    public final String m9899e() {
        return "Tigon";
    }
}

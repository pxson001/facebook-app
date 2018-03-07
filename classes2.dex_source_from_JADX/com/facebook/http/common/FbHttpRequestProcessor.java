package com.facebook.http.common;

import android.annotation.SuppressLint;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.C0087xd695ba9d;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.config.application.Product;
import com.facebook.http.common.FbHttpRequest.Builder;
import com.facebook.http.common.FbHttpRequestProcessorLogger.C04981;
import com.facebook.http.common.prioritization.RequestPriorityChanger;
import com.facebook.http.executors.delaybased.DelayBasedResponseHandlerWrapper;
import com.facebook.http.executors.delaybased.DelayBasedResponseHandlerWrapper.DelayedResponseHandler;
import com.facebook.http.executors.delaybased.Liger2gEmpathyConfigParams;
import com.facebook.http.executors.qebased.HttpExecutorExperiment;
import com.facebook.http.executors.qebased.HttpExecutorExperiment.HttpEngine;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.http.qe.ExperimentsForHttpQeModule;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.trafficcontrol.pref.ExperimentsForMessengerTrafficControlPrefModule;
import com.facebook.messaging.trafficcontrol.pref.TrafficControlPrefKeys;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tigon.httpclientadapter.ExperimentsForTigonHttpClientAdapterIfaceModule;
import com.facebook.tigon.httpclientadapter.TigonHttpClientAdapter;
import com.facebook.tigon.httpclientadapter.TigonHttpClientAdapterImpl;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import com.google.common.util.concurrent.Uninterruptibles;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.apache.http.client.ResponseHandler;

@Singleton
/* compiled from: rejecting unknown signature %s */
public class FbHttpRequestProcessor {
    private static final Class<?> f7722a = FbHttpRequestProcessor.class;
    private static volatile FbHttpRequestProcessor f7723p;
    private final FbHttpRequestExecutorAdapter f7724b;
    private final DefaultAndroidThreadUtil f7725c;
    private final Provider<Boolean> f7726d;
    private final QeAccessor f7727e;
    private final Lazy<TigonHttpClientAdapter> f7728f;
    private final Lazy<TigonRequestEngine> f7729g;
    private final Lazy<PassthroughRequestEngine> f7730h;
    private final Lazy<PriorityRequestEngine> f7731i;
    private final HttpExecutorExperiment f7732j;
    private final DelayBasedResponseHandlerWrapper f7733k;
    private final FbHttpRequestProcessorLogger f7734l;
    private final RequestPriorityChanger f7735m;
    @GuardedBy("this")
    public volatile FbHttpRequestEngine f7736n;
    private volatile boolean f7737o;

    /* compiled from: rejecting unknown signature %s */
    public class C03341 implements Runnable {
        final /* synthetic */ FbHttpRequestProcessor f7863a;

        public C03341(FbHttpRequestProcessor fbHttpRequestProcessor) {
            this.f7863a = fbHttpRequestProcessor;
        }

        public void run() {
            FbHttpRequestProcessor.m12265i(this.f7863a);
        }
    }

    public static com.facebook.http.common.FbHttpRequestProcessor m12260a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7723p;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.common.FbHttpRequestProcessor.class;
        monitor-enter(r1);
        r0 = f7723p;	 Catch:{ all -> 0x003a }
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
        r0 = m12262b(r0);	 Catch:{ all -> 0x0035 }
        f7723p = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7723p;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.FbHttpRequestProcessor.a(com.facebook.inject.InjectorLike):com.facebook.http.common.FbHttpRequestProcessor");
    }

    private static FbHttpRequestProcessor m12262b(InjectorLike injectorLike) {
        return new FbHttpRequestProcessor(FbHttpRequestExecutorAdapter.m12274a(injectorLike), DefaultAndroidThreadUtil.m1646b(injectorLike), IdBasedProvider.m1811a(injectorLike, 4027), QeInternalImplMethodAutoProvider.m3744a(injectorLike), IdBasedLazy.m1808a(injectorLike, 11113), IdBasedSingletonScopeProvider.m1810b(injectorLike, 7178), IdBasedSingletonScopeProvider.m1810b(injectorLike, 7177), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2231), HttpExecutorExperiment.m12375a(injectorLike), DelayBasedResponseHandlerWrapper.m4731a(injectorLike), FbHttpRequestProcessorLogger.m12382a(injectorLike), RequestPriorityChanger.m12440a(injectorLike), C0087xd695ba9d.m2486a(injectorLike));
    }

    @Inject
    @SuppressLint({"ConstructorMayLeakThis"})
    public FbHttpRequestProcessor(FbHttpRequestExecutorAdapter fbHttpRequestExecutorAdapter, AndroidThreadUtil androidThreadUtil, Provider<Boolean> provider, QeAccessor qeAccessor, Lazy<TigonHttpClientAdapter> lazy, Lazy<TigonRequestEngine> lazy2, Lazy<PassthroughRequestEngine> lazy3, Lazy<PriorityRequestEngine> lazy4, HttpExecutorExperiment httpExecutorExperiment, DelayBasedResponseHandlerWrapper delayBasedResponseHandlerWrapper, FbHttpRequestProcessorLogger fbHttpRequestProcessorLogger, RequestPriorityChanger requestPriorityChanger, ExecutorService executorService) {
        this.f7724b = fbHttpRequestExecutorAdapter;
        this.f7725c = androidThreadUtil;
        this.f7726d = provider;
        this.f7727e = qeAccessor;
        this.f7728f = lazy;
        this.f7729g = lazy2;
        this.f7730h = lazy3;
        this.f7731i = lazy4;
        this.f7732j = httpExecutorExperiment;
        this.f7733k = delayBasedResponseHandlerWrapper;
        this.f7734l = fbHttpRequestProcessorLogger;
        this.f7735m = requestPriorityChanger;
        ExecutorDetour.a(executorService, new C03341(this), 229195058);
    }

    public final RequestProcessorSnapshot m12266a() {
        return m12265i(this).mo1697b();
    }

    public final <T> T m12267a(FbHttpRequest<T> fbHttpRequest) {
        this.f7725c.m1655b();
        try {
            return Uninterruptibles.m1584a(m12269b((FbHttpRequest) fbHttpRequest).m17398a());
        } catch (ExecutionException e) {
            throw m12261a(e);
        }
    }

    public final <T> HttpFutureWrapper<T> m12269b(FbHttpRequest<T> fbHttpRequest) {
        ListenableFuture a;
        FbHttpRequest d = m12263d(this.f7735m.m12443a((FbHttpRequest) fbHttpRequest));
        this.f7734l.m12387a(d, m12265i(this).mo1700d(), m12265i(this).mo1701e());
        if (this.f7737o) {
            a = Futures.m2453a(new IOException("In lame duck mode"));
        } else {
            a = m12265i(this).mo1693a(d);
        }
        Futures.m2458a(a, new C04981(this.f7734l, d), (Executor) DirectExecutor.INSTANCE);
        return new HttpFutureWrapper(d, a, this);
    }

    private <T> FbHttpRequest<T> m12263d(FbHttpRequest<T> fbHttpRequest) {
        ResponseHandler delayedResponseHandler;
        DelayBasedResponseHandlerWrapper delayBasedResponseHandlerWrapper = this.f7733k;
        ResponseHandler responseHandler = fbHttpRequest.f7690g;
        String str = fbHttpRequest.f7686c;
        Liger2gEmpathyConfigParams liger2gEmpathyConfigParams = delayBasedResponseHandlerWrapper.f2698c;
        boolean z = false;
        if (Product.MESSENGER.equals(liger2gEmpathyConfigParams.f2705c)) {
            z = liger2gEmpathyConfigParams.f2703a.mo286a(TrafficControlPrefKeys.f23793b, false);
        } else if (liger2gEmpathyConfigParams.f2704b.mo594a(Liveness.Live, ExperimentsForHttpQeModule.al, false) && liger2gEmpathyConfigParams.f2703a.mo286a(InternalHttpPrefKeys.f2518m, false)) {
            z = true;
        }
        if (z) {
            int a;
            liger2gEmpathyConfigParams = delayBasedResponseHandlerWrapper.f2698c;
            if (Product.MESSENGER.equals(liger2gEmpathyConfigParams.f2705c)) {
                a = liger2gEmpathyConfigParams.f2704b.mo573a(Liveness.Live, ExperimentsForMessengerTrafficControlPrefModule.d, 3000);
            } else {
                a = liger2gEmpathyConfigParams.f2704b.mo573a(Liveness.Live, ExperimentsForHttpQeModule.am, 3600000);
            }
            int i = a;
            String toLowerCase = str.toLowerCase(Locale.US);
            if (toLowerCase.contains("video")) {
                liger2gEmpathyConfigParams = delayBasedResponseHandlerWrapper.f2698c;
                if (Product.MESSENGER.equals(liger2gEmpathyConfigParams.f2705c)) {
                    a = liger2gEmpathyConfigParams.f2704b.mo573a(Liveness.Live, ExperimentsForMessengerTrafficControlPrefModule.l, 3000);
                } else {
                    a = liger2gEmpathyConfigParams.f2704b.mo573a(Liveness.Live, ExperimentsForHttpQeModule.as, 3000);
                }
                i = a;
            } else if (toLowerCase.contains("image")) {
                liger2gEmpathyConfigParams = delayBasedResponseHandlerWrapper.f2698c;
                if (Product.MESSENGER.equals(liger2gEmpathyConfigParams.f2705c)) {
                    a = liger2gEmpathyConfigParams.f2704b.mo573a(Liveness.Live, ExperimentsForMessengerTrafficControlPrefModule.h, 3000);
                } else {
                    a = liger2gEmpathyConfigParams.f2704b.mo573a(Liveness.Live, ExperimentsForHttpQeModule.ao, 3000);
                }
                i = a;
            }
            Liger2gEmpathyConfigParams liger2gEmpathyConfigParams2 = delayBasedResponseHandlerWrapper.f2698c;
            if (Product.MESSENGER.equals(liger2gEmpathyConfigParams2.f2705c)) {
                z = liger2gEmpathyConfigParams2.f2704b.mo594a(Liveness.Live, ExperimentsForMessengerTrafficControlPrefModule.i, false);
            } else {
                z = liger2gEmpathyConfigParams2.f2704b.mo594a(Liveness.Live, ExperimentsForHttpQeModule.ap, false);
            }
            if (z) {
                i = delayBasedResponseHandlerWrapper.f2697b.nextInt(i);
            }
            boolean z2 = false;
            Liger2gEmpathyConfigParams liger2gEmpathyConfigParams3 = delayBasedResponseHandlerWrapper.f2698c;
            if (Product.MESSENGER.equals(liger2gEmpathyConfigParams3.f2705c)) {
                z = liger2gEmpathyConfigParams3.f2704b.mo594a(Liveness.Live, ExperimentsForMessengerTrafficControlPrefModule.k, false);
            } else {
                z = liger2gEmpathyConfigParams3.f2704b.mo594a(Liveness.Live, ExperimentsForHttpQeModule.ar, false);
            }
            if (z) {
                int i2 = delayBasedResponseHandlerWrapper.f2701f;
                delayBasedResponseHandlerWrapper.f2701f = i2 - 1;
                if (i2 < 0) {
                    liger2gEmpathyConfigParams2 = delayBasedResponseHandlerWrapper.f2698c;
                    if (Product.MESSENGER.equals(liger2gEmpathyConfigParams2.f2705c)) {
                        a = liger2gEmpathyConfigParams2.f2704b.mo573a(Liveness.Live, ExperimentsForMessengerTrafficControlPrefModule.j, 15);
                    } else {
                        a = liger2gEmpathyConfigParams2.f2704b.mo573a(Liveness.Live, ExperimentsForHttpQeModule.aq, 15);
                    }
                    delayBasedResponseHandlerWrapper.f2701f = delayBasedResponseHandlerWrapper.f2697b.nextInt(a);
                    z2 = true;
                }
            }
            delayedResponseHandler = new DelayedResponseHandler(responseHandler, str, i, z2);
        } else {
            delayedResponseHandler = null;
        }
        ResponseHandler responseHandler2 = delayedResponseHandler;
        if (responseHandler2 == null) {
            return fbHttpRequest;
        }
        Builder a2 = FbHttpRequest.m12226a((FbHttpRequest) fbHttpRequest);
        a2.f7707g = responseHandler2;
        return a2.m12256a();
    }

    private boolean m12264g() {
        if (!this.f7727e.mo596a(ExperimentsForTigonHttpClientAdapterIfaceModule.f7865b, false)) {
            return false;
        }
        boolean z;
        if (this.f7732j.m12378a() == HttpEngine.LIGER) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return this.f7728f.get() != null && ((TigonHttpClientAdapterImpl) this.f7728f.get()).a.a();
        } else {
            return false;
        }
    }

    public final void m12268a(FbHttpRequest<?> fbHttpRequest, RequestPriority requestPriority) {
        m12265i(this).mo1695a((FbHttpRequest) fbHttpRequest, requestPriority);
    }

    public final <T> boolean m12272c(FbHttpRequest<T> fbHttpRequest) {
        return m12265i(this).mo1698b(fbHttpRequest);
    }

    public final void m12270b() {
        this.f7737o = true;
    }

    public final void m12271c() {
        this.f7737o = false;
    }

    public final void m12273d() {
        m12265i(this).mo1694a();
    }

    @VisibleForTesting
    private static RuntimeException m12261a(ExecutionException executionException) {
        Throwable th = (Throwable) Preconditions.checkNotNull(executionException.getCause());
        Throwables.propagateIfInstanceOf(th, IOException.class);
        throw Throwables.propagate(th);
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    public static FbHttpRequestEngine m12265i(FbHttpRequestProcessor fbHttpRequestProcessor) {
        if (fbHttpRequestProcessor.f7736n != null) {
            return fbHttpRequestProcessor.f7736n;
        }
        synchronized (fbHttpRequestProcessor) {
            FbHttpRequestEngine fbHttpRequestEngine;
            if (fbHttpRequestProcessor.f7736n != null) {
                fbHttpRequestEngine = fbHttpRequestProcessor.f7736n;
                return fbHttpRequestEngine;
            } else if (fbHttpRequestProcessor.m12264g()) {
                fbHttpRequestEngine = (FbHttpRequestEngine) fbHttpRequestProcessor.f7729g.get();
                fbHttpRequestProcessor.f7736n = fbHttpRequestEngine;
                return fbHttpRequestEngine;
            } else if (((Boolean) fbHttpRequestProcessor.f7726d.get()).booleanValue()) {
                try {
                    fbHttpRequestEngine = (FbHttpRequestEngine) fbHttpRequestProcessor.f7731i.get();
                    fbHttpRequestProcessor.f7736n = fbHttpRequestEngine;
                    return fbHttpRequestEngine;
                } catch (NoSuchFieldError e) {
                    fbHttpRequestEngine = (FbHttpRequestEngine) fbHttpRequestProcessor.f7730h.get();
                    fbHttpRequestProcessor.f7736n = fbHttpRequestEngine;
                    return fbHttpRequestEngine;
                }
            } else {
                fbHttpRequestEngine = (FbHttpRequestEngine) fbHttpRequestProcessor.f7730h.get();
                fbHttpRequestProcessor.f7736n = fbHttpRequestEngine;
                return fbHttpRequestEngine;
            }
        }
    }
}

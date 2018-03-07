package com.facebook.http.common;

import com.facebook.cdn.handler.CdnHttpRequestHandler;
import com.facebook.cdn.handlerimpl.CdnHttpRequestHandlerImpl;
import com.facebook.common.appstate.handler.AppStateHttpRequestHandler;
import com.facebook.common.carrier.CarrierMonitor;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.log.BLog;
import com.facebook.dialtone.handler.DialtoneHttpRequestHandler;
import com.facebook.http.engine.HttpRequestExecutor;
import com.facebook.http.interfaces.RequestStage;
import com.facebook.http.observer.RequestContext;
import com.facebook.http.onion.TorProxy;
import com.facebook.http.onion.TorProxyMethodAutoProvider;
import com.facebook.http.protocol.FallbackBehavior;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.zero.token.request.ZeroTokenHttpRequestHandler;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

@Singleton
/* compiled from: reject_place_suggestion */
public class FbHttpRequestExecutorAdapter {
    private static final Class<?> f7738a;
    private static final String f7739b;
    private static final Logger f7740c = Logger.getLogger(f7738a.getName());
    private static volatile FbHttpRequestExecutorAdapter f7741r;
    private final Lazy<HttpRequestExecutor> f7742d;
    private final CdnHttpRequestHandler f7743e;
    private final DialtoneHttpRequestHandler f7744f;
    private final ZeroTokenHttpRequestHandler f7745g;
    private final AppStateHttpRequestHandler f7746h;
    public final CarrierMonitor f7747i;
    private final Lazy<HttpClient> f7748j;
    private final HttpFilterProcessor f7749k;
    private final FbRedirectController f7750l;
    private final TorProxy f7751m;
    private final FbHttpRequestSampleController f7752n;
    private final MeasuringHttpResponseWrapperProvider f7753o;
    private final NetworkThreadTimeLogger f7754p;
    private final MonotonicClock f7755q;

    public static com.facebook.http.common.FbHttpRequestExecutorAdapter m12274a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7741r;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.common.FbHttpRequestExecutorAdapter.class;
        monitor-enter(r1);
        r0 = f7741r;	 Catch:{ all -> 0x003a }
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
        r0 = m12283b(r0);	 Catch:{ all -> 0x0035 }
        f7741r = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7741r;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.FbHttpRequestExecutorAdapter.a(com.facebook.inject.InjectorLike):com.facebook.http.common.FbHttpRequestExecutorAdapter");
    }

    private static FbHttpRequestExecutorAdapter m12283b(InjectorLike injectorLike) {
        return new FbHttpRequestExecutorAdapter(IdBasedSingletonScopeProvider.m1810b(injectorLike, 2263), CdnHttpRequestHandlerImpl.m12290a(injectorLike), DialtoneHttpRequestHandler.m12298a(injectorLike), ZeroTokenHttpRequestHandler.m8011a(injectorLike), AppStateHttpRequestHandler.m12300a(injectorLike), CarrierMonitor.m12302a(injectorLike), IdBasedLazy.m1808a(injectorLike, 4543), HttpFilterProcessor.m12312a(injectorLike), FbRedirectController.m12334a(injectorLike), TorProxyMethodAutoProvider.m3888b(injectorLike), FbHttpRequestSampleController.m12366a(injectorLike), (MeasuringHttpResponseWrapperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MeasuringHttpResponseWrapperProvider.class), NetworkThreadTimeLogger.m12372a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike));
    }

    private void m12281a(HttpUriRequest httpUriRequest, String str, boolean z, long j, RequestIdempotency requestIdempotency) {
        Preconditions.checkNotNull(httpUriRequest);
        httpUriRequest.getParams().setParameter("fb_user_request_identifier", str);
        Preconditions.checkNotNull(httpUriRequest);
        httpUriRequest.getParams().setBooleanParameter("fb_user_request_is_sampled", z);
        Preconditions.checkNotNull(httpUriRequest);
        httpUriRequest.getParams().setLongParameter("fb_request_creation_time", j);
        Preconditions.checkNotNull(requestIdempotency);
        httpUriRequest.getParams().setBooleanParameter("replay_safe", requestIdempotency == RequestIdempotency.RETRY_SAFE);
        this.f7743e.mo1677a((HttpRequest) httpUriRequest);
        DialtoneHttpRequestHandler dialtoneHttpRequestHandler = this.f7744f;
        if (((Boolean) dialtoneHttpRequestHandler.f7759a.get()).booleanValue() && (!((Boolean) dialtoneHttpRequestHandler.f7761c.get()).booleanValue() || ((Boolean) dialtoneHttpRequestHandler.f7760b.get()).booleanValue())) {
            httpUriRequest.addHeader("X-ZERO-CATEGORY", "dialtone");
        }
        httpUriRequest.addHeader("x-fb-net-hni", this.f7747i.m12308a());
        httpUriRequest.addHeader("x-fb-sim-hni", this.f7747i.m12309b());
        httpUriRequest.addHeader("x-fb-net-sid", this.f7747i.m12310c());
        if (((Boolean) this.f7746h.f7764a.get()).booleanValue() && httpUriRequest.getHeaders("X-FB-Background-State").length == 0) {
            httpUriRequest.addHeader("X-FB-Background-State", "1");
        }
        this.f7745g.m8014a((HttpRequest) httpUriRequest);
    }

    static {
        Class cls = FbHttpRequestExecutorAdapter.class;
        f7738a = cls;
        f7739b = cls.getSimpleName();
    }

    public final RequestWrapper m12288b(FbHttpRequest fbHttpRequest) {
        m12281a(fbHttpRequest.f7685b, SafeUUIDGenerator.m2795a().toString(), this.f7752n.m12370a(), fbHttpRequest.f7698o, fbHttpRequest.f7694k);
        return this.f7749k.m12315a(fbHttpRequest);
    }

    private static void m12282a(HttpContext httpContext, FbHttpRequest fbHttpRequest) {
        String str = fbHttpRequest.f7688e;
        String str2 = fbHttpRequest.f7686c;
        new RequestContext(str2, fbHttpRequest.m12235h().toString(), fbHttpRequest.m12243q(), fbHttpRequest.f7697n, fbHttpRequest.f7687d, str != null ? str + ":" + str2 : null).m17676b(httpContext);
    }

    private HttpResponse m12278a(FbHttpRequest fbHttpRequest, Throwable th) {
        if (fbHttpRequest.f7689f == FallbackBehavior.FALLBACK_REQUIRED) {
            String th2;
            Class cls = f7738a;
            String str = "Got %s while executing %s, retrying on a safe network stack";
            Object[] objArr = new Object[2];
            if (th != null) {
                th2 = th.toString();
            } else {
                th2 = "";
            }
            objArr[0] = th2;
            objArr[1] = fbHttpRequest.f7686c;
            BLog.a(cls, str, objArr);
            return ((HttpClient) this.f7748j.get()).execute(fbHttpRequest.f7685b);
        }
        Throwables.propagateIfInstanceOf(th, IOException.class);
        throw Throwables.propagate(th);
    }

    private <T> T m12276a(FbHttpRequest<T> fbHttpRequest, String str, boolean z) {
        ResponseHandler responseHandler = fbHttpRequest.f7690g;
        HttpResponse b = m12284b(fbHttpRequest, str, z);
        fbHttpRequest.m12229a(RequestStage.DOWNLOADING_RESPONSE);
        T a = m12277a((FbHttpRequest) fbHttpRequest, responseHandler, b);
        fbHttpRequest.m12229a(RequestStage.FINISHED);
        m12279a(fbHttpRequest.f7686c, false);
        return a;
    }

    @Inject
    public FbHttpRequestExecutorAdapter(Lazy<HttpRequestExecutor> lazy, CdnHttpRequestHandler cdnHttpRequestHandler, DialtoneHttpRequestHandler dialtoneHttpRequestHandler, ZeroTokenHttpRequestHandler zeroTokenHttpRequestHandler, AppStateHttpRequestHandler appStateHttpRequestHandler, CarrierMonitor carrierMonitor, Lazy<HttpClient> lazy2, HttpFilterProcessor httpFilterProcessor, FbRedirectController fbRedirectController, TorProxy torProxy, FbHttpRequestSampleController fbHttpRequestSampleController, MeasuringHttpResponseWrapperProvider measuringHttpResponseWrapperProvider, NetworkThreadTimeLogger networkThreadTimeLogger, MonotonicClock monotonicClock) {
        this.f7742d = lazy;
        this.f7743e = cdnHttpRequestHandler;
        this.f7744f = dialtoneHttpRequestHandler;
        this.f7746h = appStateHttpRequestHandler;
        this.f7747i = carrierMonitor;
        this.f7748j = lazy2;
        this.f7749k = httpFilterProcessor;
        this.f7750l = fbRedirectController;
        this.f7751m = torProxy;
        this.f7752n = fbHttpRequestSampleController;
        this.f7745g = zeroTokenHttpRequestHandler;
        this.f7753o = measuringHttpResponseWrapperProvider;
        this.f7754p = networkThreadTimeLogger;
        this.f7755q = monotonicClock;
    }

    public final <T> T m12286a(FbHttpRequest<T> fbHttpRequest) {
        String b = fbHttpRequest.m12231b();
        TracerDetour.a("%s[%s]", new Object[]{f7739b, b}, -544975161);
        try {
            fbHttpRequest.m12229a(RequestStage.WAITING_RESPONSE);
            T a = m12276a((FbHttpRequest) fbHttpRequest, SafeUUIDGenerator.m2795a().toString(), this.f7752n.m12370a());
            return a;
        } finally {
            TracerDetour.a(-1075103778);
        }
    }

    final String m12287a() {
        return ((HttpRequestExecutor) this.f7742d.get()).mo1704b();
    }

    public final boolean m12289b() {
        return ((HttpRequestExecutor) this.f7742d.get()).mo1705c();
    }

    private <T> HttpResponse m12284b(FbHttpRequest<T> fbHttpRequest, String str, boolean z) {
        try {
            return m12285c(fbHttpRequest, str, z);
        } catch (IOException e) {
            fbHttpRequest.m12229a(RequestStage.FAILED);
            m12279a(fbHttpRequest.m12231b(), true);
            throw m12275a(e);
        }
    }

    private HttpResponse m12285c(FbHttpRequest fbHttpRequest, String str, boolean z) {
        try {
            m12281a(fbHttpRequest.m12228a(), str, z, fbHttpRequest.m12238l(), fbHttpRequest.m12237j());
            fbHttpRequest.m12230a(true);
            HttpContext basicHttpContext = new BasicHttpContext();
            m12282a(basicHttpContext, fbHttpRequest);
            HttpUriRequest a = this.f7749k.m12315a(fbHttpRequest);
            basicHttpContext.setAttribute("request_method", fbHttpRequest.m12228a().getMethod());
            return this.f7750l.m12341a(a, fbHttpRequest.m12236i(), (HttpRequestExecutor) this.f7742d.get(), fbHttpRequest.m12234g(), basicHttpContext, fbHttpRequest.m12242p(), fbHttpRequest.m12241o());
        } catch (Throwable th) {
            return m12278a(fbHttpRequest, th);
        }
    }

    private <T> T m12277a(FbHttpRequest<T> fbHttpRequest, ResponseHandler<? extends T> responseHandler, HttpResponse httpResponse) {
        MeasuringHttpResponseWrapper a = this.f7753o.m12371a(httpResponse);
        long now = this.f7755q.now();
        try {
            T handleResponse = responseHandler.handleResponse(a);
            m12280a(httpResponse, null);
            now = this.f7755q.now() - now;
            this.f7754p.m12374a(fbHttpRequest, now, a.m22190a());
            return handleResponse;
        } catch (Throwable th) {
            Throwable th2 = th;
            now = this.f7755q.now() - now;
            this.f7754p.m12374a(fbHttpRequest, now, a.m22190a());
        }
    }

    private static void m12280a(HttpResponse httpResponse, @Nullable Throwable th) {
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null) {
            try {
                entity.consumeContent();
            } catch (Throwable e) {
                if (th != null) {
                    f7740c.log(Level.WARNING, "Error consuming content after an exception.", e);
                } else {
                    f7740c.log(Level.WARNING, "Error consuming content after response handler executed", e);
                }
            }
        }
    }

    private IOException m12275a(IOException iOException) {
        if (ProtocolExceptions.a(iOException)) {
            ((HttpRequestExecutor) this.f7742d.get()).mo1703a();
        }
        throw iOException;
    }

    private void m12279a(String str, boolean z) {
        if (this.f7751m.mo562a() && !"Tor integrity checker".equals(str) && z != this.f7751m.mo564b()) {
            this.f7751m.mo566d();
        }
    }
}

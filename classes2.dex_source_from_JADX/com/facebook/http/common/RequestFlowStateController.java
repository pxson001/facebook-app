package com.facebook.http.common;

import android.os.SystemClock;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.http.common.observerimpl.HttpFlowState;
import com.facebook.http.engine.HttpRequestExecutor;
import com.facebook.http.interfaces.RequestState;
import com.facebook.http.observer.DownloadBandwidthManager;
import com.facebook.http.observer.FbHttpFlowObserver;
import com.facebook.http.observer.HttpFlowStatistics;
import com.facebook.http.observer.STATICDI_MULTIBIND_PROVIDER$FbHttpFlowObserver;
import com.facebook.http.protocol.HttpWireCallback;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.HttpRequestExecutorDetour;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

@Singleton
/* compiled from: refreshAfterWrite requires a LoadingCache */
public class RequestFlowStateController {
    private static volatile RequestFlowStateController f7814e;
    private final Provider<Set<FbHttpFlowObserver>> f7815a;
    private final FbNetworkManager f7816b;
    private final DownloadBandwidthManager f7817c;
    private final MonotonicClock f7818d;

    /* compiled from: refreshAfterWrite requires a LoadingCache */
    public final class C03321 implements Provider<Set<T>> {
        final /* synthetic */ Provider f7820a;
        final /* synthetic */ Predicate f7821b;

        public C03321(Provider provider, Predicate predicate) {
            this.f7820a = provider;
            this.f7821b = predicate;
        }

        public final Object get() {
            return Sets.m1317a((Set) this.f7820a.get(), this.f7821b);
        }
    }

    public static com.facebook.http.common.RequestFlowStateController m12360a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7814e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.common.RequestFlowStateController.class;
        monitor-enter(r1);
        r0 = f7814e;	 Catch:{ all -> 0x003a }
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
        r0 = m12363b(r0);	 Catch:{ all -> 0x0035 }
        f7814e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7814e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.RequestFlowStateController.a(com.facebook.inject.InjectorLike):com.facebook.http.common.RequestFlowStateController");
    }

    private static RequestFlowStateController m12363b(InjectorLike injectorLike) {
        return new RequestFlowStateController(STATICDI_MULTIBIND_PROVIDER$FbHttpFlowObserver.m12365a(injectorLike), FbNetworkManager.m3811a(injectorLike), DownloadBandwidthManager.m4071a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike));
    }

    @Inject
    public RequestFlowStateController(Provider<Set<FbHttpFlowObserver>> provider, FbNetworkManager fbNetworkManager, DownloadBandwidthManager downloadBandwidthManager, MonotonicClock monotonicClock) {
        this.f7815a = new C03321(provider, Predicates.notNull());
        this.f7816b = fbNetworkManager;
        this.f7817c = downloadBandwidthManager;
        this.f7818d = monotonicClock;
    }

    public final HttpResponse m12364a(HttpUriRequest httpUriRequest, RequestState requestState, HttpContext httpContext, HttpRequestExecutor httpRequestExecutor, Optional<List<HttpFlowStatistics>> optional, HttpWireCallback httpWireCallback) {
        HttpFlowStatistics httpFlowStatistics = new HttpFlowStatistics(httpRequestExecutor.mo1704b(), this.f7817c, this.f7818d, httpWireCallback);
        if (optional.isPresent()) {
            ((List) optional.get()).add(httpFlowStatistics);
        }
        HttpFlowState a = m12361a(httpContext, httpUriRequest, httpFlowStatistics);
        httpFlowStatistics.m17688a(SystemClock.uptimeMillis() - FbHttpParamsUtility.m17904a(httpUriRequest));
        if (this.f7816b != null) {
            httpFlowStatistics.m17692b(this.f7816b.m3835k());
            httpFlowStatistics.m17696d(this.f7816b.m3836l());
            httpFlowStatistics.m17694c(this.f7816b.m3834j());
        }
        try {
            HttpResponse a2 = HttpRequestExecutorDetour.a(httpRequestExecutor, httpUriRequest, requestState, httpContext, httpFlowStatistics, -1270570149);
            a.m17712a(a2, httpContext);
            return a2;
        } catch (IOException e) {
            throw m12362a(a, e);
        }
    }

    private static IOException m12362a(HttpFlowState httpFlowState, IOException iOException) {
        httpFlowState.m17715b(iOException);
        throw iOException;
    }

    private HttpFlowState m12361a(HttpContext httpContext, HttpUriRequest httpUriRequest, HttpFlowStatistics httpFlowStatistics) {
        HttpFlowState httpFlowState = new HttpFlowState(httpContext, httpUriRequest, (Set) this.f7815a.get());
        httpFlowState.f12016c = httpFlowStatistics;
        for (FbHttpFlowObserver a : httpFlowState.f12017d) {
            a.mo2284a(httpUriRequest, httpContext, httpFlowStatistics);
        }
        for (FbHttpFlowObserver a2 : httpFlowState.f12017d) {
            a2.mo2283a((HttpRequest) httpUriRequest, httpContext);
        }
        return httpFlowState;
    }
}

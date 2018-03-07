package com.facebook.http.common.executorimpl.apache;

import com.facebook.http.common.FbRequestState;
import com.facebook.http.engine.HttpRequestExecutor;
import com.facebook.http.observer.HttpFlowStatistics;
import com.facebook.http.onion.OnionRewriter;
import com.facebook.http.onion.impl.FbOnionRewriter;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.net.InetAddress;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.conn.AbstractClientConnAdapter;
import org.apache.http.protocol.HttpContext;

@Singleton
/* compiled from: display_region_hint */
public class FbHttpClientRequestExecutor implements HttpRequestExecutor {
    private static final Class<?> f4988a = FbHttpClientRequestExecutor.class;
    private static volatile FbHttpClientRequestExecutor f4989d;
    private final Lazy<FbHttpClient> f4990b;
    private final FbOnionRewriter f4991c;

    public static com.facebook.http.common.executorimpl.apache.FbHttpClientRequestExecutor m9918a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4989d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.common.executorimpl.apache.FbHttpClientRequestExecutor.class;
        monitor-enter(r1);
        r0 = f4989d;	 Catch:{ all -> 0x003a }
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
        r0 = m9920b(r0);	 Catch:{ all -> 0x0035 }
        f4989d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4989d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.executorimpl.apache.FbHttpClientRequestExecutor.a(com.facebook.inject.InjectorLike):com.facebook.http.common.executorimpl.apache.FbHttpClientRequestExecutor");
    }

    private static FbHttpClientRequestExecutor m9920b(InjectorLike injectorLike) {
        return new FbHttpClientRequestExecutor(IdBasedSingletonScopeProvider.b(injectorLike, 7182), FbOnionRewriter.a(injectorLike));
    }

    @Inject
    public FbHttpClientRequestExecutor(Lazy<FbHttpClient> lazy, OnionRewriter onionRewriter) {
        this.f4990b = lazy;
        this.f4991c = onionRewriter;
    }

    public final HttpResponse m9922a(HttpUriRequest httpUriRequest, FbRequestState fbRequestState, HttpContext httpContext, HttpFlowStatistics httpFlowStatistics) {
        String str = null;
        httpFlowStatistics.a(false);
        httpContext.setAttribute("fb_http_flow_statistics", httpFlowStatistics);
        HttpUriRequest a = this.f4991c.a(httpUriRequest);
        try {
            a.addHeader("X-FB-HTTP-Engine", "Apache");
            HttpResponse execute = ((FbHttpClient) this.f4990b.get()).execute(a, httpContext);
            if (str != null) {
                httpFlowStatistics.a(str);
            }
            httpFlowStatistics.h();
            return execute;
        } finally {
            try {
                str = m9921b(httpContext);
            } catch (IllegalStateException e) {
            }
            if (str != null) {
                httpFlowStatistics.a(str);
            }
            httpFlowStatistics.h();
        }
    }

    public final void m9923a() {
        ((FbHttpClient) this.f4990b.get()).mo613a().clear();
    }

    public final String m9924b() {
        return "HttpClient";
    }

    public final boolean m9925c() {
        return false;
    }

    public static HttpFlowStatistics m9919a(HttpContext httpContext) {
        return (HttpFlowStatistics) Preconditions.checkNotNull((HttpFlowStatistics) httpContext.getAttribute("fb_http_flow_statistics"), "HttpFlowStatistics not attached to context?");
    }

    @Nullable
    @VisibleForTesting
    private static String m9921b(HttpContext httpContext) {
        Object attribute = httpContext.getAttribute("http.connection");
        if (attribute != null && (attribute instanceof AbstractClientConnAdapter)) {
            InetAddress remoteAddress = ((AbstractClientConnAdapter) attribute).getRemoteAddress();
            if (remoteAddress != null) {
                return remoteAddress.getHostAddress();
            }
        }
        return null;
    }
}

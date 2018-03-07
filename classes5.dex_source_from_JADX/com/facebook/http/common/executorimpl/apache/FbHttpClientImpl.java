package com.facebook.http.common.executorimpl.apache;

import com.facebook.http.common.HttpParamsMethodAutoProvider;
import com.facebook.http.common.NetworkDataLogUtils;
import com.facebook.http.common.executorimpl.apache.ClientGZipContentCompression.MyHttpRequestInterceptor;
import com.facebook.http.common.executorimpl.apache.ClientGZipContentCompression.MyHttpResponseInterceptor;
import com.facebook.inject.InjectorLike;
import java.net.URI;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;

@Singleton
/* compiled from: display_text */
public final class FbHttpClientImpl implements FbHttpClient {
    private static volatile FbHttpClientImpl f4985c;
    private final HttpClient f4986a;
    public final FbCookieStore f4987b;

    public static com.facebook.http.common.executorimpl.apache.FbHttpClientImpl m9913a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4985c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.common.executorimpl.apache.FbHttpClientImpl.class;
        monitor-enter(r1);
        r0 = f4985c;	 Catch:{ all -> 0x003a }
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
        r0 = m9915b(r0);	 Catch:{ all -> 0x0035 }
        f4985c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4985c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.executorimpl.apache.FbHttpClientImpl.a(com.facebook.inject.InjectorLike):com.facebook.http.common.executorimpl.apache.FbHttpClientImpl");
    }

    private static FbHttpClientImpl m9915b(InjectorLike injectorLike) {
        return new FbHttpClientImpl(FbClientConnManager.m9902a(injectorLike), HttpParamsMethodAutoProvider.b(injectorLike), FbCookieStore.m9911a(injectorLike), NoRetryRetryHandler.m9927a(injectorLike), NetworkDataLogUtils.a(injectorLike));
    }

    @Inject
    public FbHttpClientImpl(ClientConnectionManager clientConnectionManager, HttpParams httpParams, FbCookieStore fbCookieStore, NoRetryRetryHandler noRetryRetryHandler, final NetworkDataLogUtils networkDataLogUtils) {
        this.f4987b = fbCookieStore;
        HttpClient c04791 = new DefaultHttpClient(this, clientConnectionManager, httpParams) {
            final /* synthetic */ FbHttpClientImpl f4984b;

            protected BasicHttpProcessor createHttpProcessor() {
                BasicHttpProcessor createHttpProcessor = super.createHttpProcessor();
                createHttpProcessor.addRequestInterceptor(new MyHttpRequestInterceptor());
                createHttpProcessor.addResponseInterceptor(new MyHttpResponseInterceptor());
                Object byteCountingInterceptor = new ByteCountingInterceptor(networkDataLogUtils);
                createHttpProcessor.addRequestInterceptor(byteCountingInterceptor);
                createHttpProcessor.addResponseInterceptor(byteCountingInterceptor, 0);
                return createHttpProcessor;
            }

            protected HttpContext createHttpContext() {
                HttpContext basicHttpContext = new BasicHttpContext();
                basicHttpContext.setAttribute("http.authscheme-registry", getAuthSchemes());
                basicHttpContext.setAttribute("http.cookiespec-registry", getCookieSpecs());
                basicHttpContext.setAttribute("http.auth.credentials-provider", getCredentialsProvider());
                basicHttpContext.setAttribute("http.cookie-store", this.f4984b.f4987b);
                return basicHttpContext;
            }

            protected ConnectionReuseStrategy createConnectionReuseStrategy() {
                return new FbConnectionReuseStrategy();
            }
        };
        c04791.setHttpRequestRetryHandler(noRetryRetryHandler);
        c04791.setRedirectHandler(new DoNothingRedirectHandler());
        this.f4986a = c04791;
    }

    public final HttpParams getParams() {
        return this.f4986a.getParams();
    }

    public final ClientConnectionManager getConnectionManager() {
        return this.f4986a.getConnectionManager();
    }

    public final HttpResponse execute(HttpUriRequest httpUriRequest) {
        return execute(m9914a(httpUriRequest), (HttpRequest) httpUriRequest, null);
    }

    public final HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) {
        return execute(m9914a(httpUriRequest), (HttpRequest) httpUriRequest, httpContext);
    }

    public final HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) {
        return execute(httpHost, httpRequest, null);
    }

    public final HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) {
        return this.f4986a.execute(httpHost, httpRequest, httpContext);
    }

    public final <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) {
        throw m9916b();
    }

    public final <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) {
        throw m9916b();
    }

    public final <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) {
        throw m9916b();
    }

    public final <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) {
        throw m9916b();
    }

    private static RuntimeException m9916b() {
        throw new UnsupportedOperationException("Use FbHttpRequest and FbHttpRequestProcessor instead");
    }

    public final CookieStore mo613a() {
        return this.f4987b;
    }

    private static HttpHost m9914a(HttpUriRequest httpUriRequest) {
        URI uri = httpUriRequest.getURI();
        if (uri.isAbsolute()) {
            return new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());
        }
        return null;
    }
}

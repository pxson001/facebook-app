package com.facebook.http.common;

import android.annotation.SuppressLint;
import com.facebook.common.util.TriState;
import com.facebook.http.engine.HttpRequestExecutor;
import com.facebook.http.interfaces.RequestState;
import com.facebook.http.observer.HttpFlowStatistics;
import com.facebook.http.protocol.HttpWireCallback;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Optional;
import java.net.URI;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.impl.client.ClientParamsStack;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

@Singleton
@SuppressLint({"Deprecated"})
/* compiled from: regenerate_deviceid */
public class FbRedirectController {
    private static final Class<?> f7795a = FbRedirectController.class;
    private static volatile FbRedirectController f7796e;
    private final int f7797b;
    private final HttpParams f7798c;
    private final RequestFlowStateController f7799d;

    public static com.facebook.http.common.FbRedirectController m12334a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7796e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.common.FbRedirectController.class;
        monitor-enter(r1);
        r0 = f7796e;	 Catch:{ all -> 0x003a }
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
        r0 = m12340b(r0);	 Catch:{ all -> 0x0035 }
        f7796e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7796e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.FbRedirectController.a(com.facebook.inject.InjectorLike):com.facebook.http.common.FbRedirectController");
    }

    private static FbRedirectController m12340b(InjectorLike injectorLike) {
        return new FbRedirectController(FbHttpModule.m12171b(), HttpParamsMethodAutoProvider.m12342b(injectorLike), RequestFlowStateController.m12360a(injectorLike));
    }

    @Inject
    public FbRedirectController(Integer num, HttpParams httpParams, RequestFlowStateController requestFlowStateController) {
        this.f7797b = num.intValue();
        this.f7798c = httpParams;
        this.f7799d = requestFlowStateController;
    }

    public final HttpResponse m12341a(HttpUriRequest httpUriRequest, RequestState requestState, HttpRequestExecutor httpRequestExecutor, RedirectHandler redirectHandler, HttpContext httpContext, Optional<List<HttpFlowStatistics>> optional, HttpWireCallback httpWireCallback) {
        Throwable th;
        TriState triState;
        int i = 0;
        HttpUriRequest httpUriRequest2 = httpUriRequest;
        while (i <= this.f7797b) {
            TriState triState2 = TriState.UNSET;
            HttpContext basicHttpContext = new BasicHttpContext(httpContext);
            HttpResponse a = this.f7799d.m12364a(httpUriRequest2, requestState, basicHttpContext, httpRequestExecutor, optional, httpWireCallback);
            try {
                boolean z = m12339a((HttpRequest) httpUriRequest2) && redirectHandler.isRedirectRequested(a, basicHttpContext);
                TriState valueOf = TriState.valueOf(z);
                try {
                    if (valueOf.asBoolean()) {
                        httpUriRequest = m12336a(httpUriRequest2.getAllHeaders(), a, basicHttpContext, redirectHandler);
                        m12338a(httpUriRequest2, httpUriRequest);
                        if (!valueOf.isSet() || valueOf.asBoolean()) {
                            m12337a(a);
                        }
                        i++;
                        httpUriRequest2 = httpUriRequest;
                    } else {
                        if (!valueOf.isSet() || valueOf.asBoolean()) {
                            m12337a(a);
                        }
                        return a;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    triState = valueOf;
                }
            } catch (Throwable th3) {
                th = th3;
                triState = triState2;
            }
        }
        throw new RedirectsNotCompletedException();
        if (!triState.isSet() || triState.asBoolean()) {
            m12337a(a);
        }
        throw th;
    }

    private static void m12338a(HttpUriRequest httpUriRequest, HttpUriRequest httpUriRequest2) {
        httpUriRequest.getURI().toString();
        httpUriRequest2.getURI().toString();
    }

    private static void m12337a(HttpResponse httpResponse) {
        if (httpResponse != null && httpResponse.getEntity() != null) {
            httpResponse.getEntity().consumeContent();
        }
    }

    private static HttpUriRequest m12336a(Header[] headerArr, HttpResponse httpResponse, HttpContext httpContext, RedirectHandler redirectHandler) {
        try {
            URI locationURI = redirectHandler.getLocationURI(httpResponse, httpContext);
            if (locationURI.isAbsolute()) {
                return m12335a(locationURI, headerArr);
            }
            throw new ProtocolException("The specified URI must be absolute");
        } catch (Throwable e) {
            throw new ClientProtocolException(e);
        }
    }

    private static HttpUriRequest m12335a(URI uri, Header[] headerArr) {
        HttpUriRequest httpGet = new HttpGet(uri);
        HttpClientParams.setRedirecting(httpGet.getParams(), true);
        for (Header header : headerArr) {
            if (HttpHeaders.a.contains(header.getName())) {
                httpGet.addHeader(header);
            }
        }
        return httpGet;
    }

    private boolean m12339a(HttpRequest httpRequest) {
        return HttpClientParams.isRedirecting(new ClientParamsStack(null, this.f7798c, httpRequest.getParams(), null));
    }
}

package com.facebook.http.common;

import com.facebook.inject.InjectorLike;
import com.google.common.base.Strings;
import java.net.URI;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.ResponseHandler;
import org.apache.http.protocol.HttpContext;

@Singleton
/* compiled from: draft_banner */
public class HttpRedirectFetcher {
    public static final RedirectHandler f4927b = new C04731();
    public static final ResponseHandler<URI> f4928c = new C04742();
    private static volatile HttpRedirectFetcher f4929d;
    public final FbHttpRequestProcessor f4930a;

    /* compiled from: draft_banner */
    final class C04731 implements RedirectHandler {
        C04731() {
        }

        public final boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
            return false;
        }

        public final URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext) {
            return null;
        }
    }

    /* compiled from: draft_banner */
    final class C04742 implements ResponseHandler<URI> {
        C04742() {
        }

        public final Object handleResponse(HttpResponse httpResponse) {
            Header firstHeader = httpResponse.getFirstHeader("Location");
            if (firstHeader != null && !Strings.isNullOrEmpty(firstHeader.getValue())) {
                return URI.create(firstHeader.getValue());
            }
            throw new ClientProtocolException("Result had no Location header");
        }
    }

    public static com.facebook.http.common.HttpRedirectFetcher m9867a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4929d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.common.HttpRedirectFetcher.class;
        monitor-enter(r1);
        r0 = f4929d;	 Catch:{ all -> 0x003a }
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
        r0 = m9868b(r0);	 Catch:{ all -> 0x0035 }
        f4929d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4929d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.HttpRedirectFetcher.a(com.facebook.inject.InjectorLike):com.facebook.http.common.HttpRedirectFetcher");
    }

    private static HttpRedirectFetcher m9868b(InjectorLike injectorLike) {
        return new HttpRedirectFetcher(FbHttpRequestProcessor.a(injectorLike));
    }

    @Inject
    public HttpRedirectFetcher(FbHttpRequestProcessor fbHttpRequestProcessor) {
        this.f4930a = fbHttpRequestProcessor;
    }
}

package com.facebook.cdn.handlerimpl;

import com.facebook.cdn.handler.CdnHeaderResponse;
import com.facebook.cdn.handler.CdnHttpRequestHandler;
import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

@Singleton
/* compiled from: reinserted_unit */
public class CdnHttpRequestHandlerImpl extends CdnHttpRequestHandler {
    private static volatile CdnHttpRequestHandlerImpl f7756b;
    private final boolean f7757a;

    public static com.facebook.cdn.handlerimpl.CdnHttpRequestHandlerImpl m12290a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7756b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.cdn.handlerimpl.CdnHttpRequestHandlerImpl.class;
        monitor-enter(r1);
        r0 = f7756b;	 Catch:{ all -> 0x003a }
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
        r0 = m12291b(r0);	 Catch:{ all -> 0x0035 }
        f7756b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7756b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.cdn.handlerimpl.CdnHttpRequestHandlerImpl.a(com.facebook.inject.InjectorLike):com.facebook.cdn.handlerimpl.CdnHttpRequestHandlerImpl");
    }

    private static CdnHttpRequestHandlerImpl m12291b(InjectorLike injectorLike) {
        return new CdnHttpRequestHandlerImpl(Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike).m2189a(786, false)));
    }

    @Inject
    public CdnHttpRequestHandlerImpl(Boolean bool) {
        this.f7757a = bool.booleanValue();
    }

    public final boolean mo1678a() {
        return this.f7757a;
    }

    public final void mo1677a(HttpRequest httpRequest) {
        if (this.f7757a) {
            Object obj;
            String uri = httpRequest.getRequestLine().getUri();
            if (uri.contains(".webp") || uri.contains(".jpg") || uri.contains(".jpeg") || uri.contains(".png")) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                if (uri.contains(".akamaihd.net") || uri.contains(".fbcdn.net")) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    httpRequest.addHeader("Pragma", "akamai-x-cache-on, akamai-x-cache-remote-on");
                    httpRequest.addHeader("X-FB-Debug", "True");
                }
            }
        }
    }

    public final CdnHeaderResponse mo1676a(HttpResponse httpResponse) {
        if (!this.f7757a) {
            return CdnHeaderResponse.NOT_IN_GK;
        }
        Header[] allHeaders = httpResponse.getAllHeaders();
        TriState triState = TriState.UNSET;
        TriState triState2 = TriState.UNSET;
        TriState triState3 = TriState.UNSET;
        int length = allHeaders.length;
        int i = 0;
        while (i < length) {
            TriState triState4;
            Header header = allHeaders[i];
            String name = header.getName();
            boolean z;
            TriState triState5;
            if (name.equalsIgnoreCase("x-edge-hit")) {
                if ("0".equals(header.getValue())) {
                    z = false;
                } else {
                    z = true;
                }
                triState5 = triState3;
                triState3 = triState2;
                triState2 = TriState.valueOf(z);
                triState4 = triState5;
            } else if (name.equalsIgnoreCase("x-cache")) {
                z = (header.getValue().contains("tcp_miss") || header.getValue().contains("TCP_MISS")) ? false : true;
                triState2 = triState;
                triState5 = TriState.valueOf(z);
                triState4 = triState3;
                triState3 = triState5;
            } else if (name.equalsIgnoreCase("x-cache-remote")) {
                z = (header.getValue().contains("tcp_miss") || header.getValue().contains("TCP_MISS")) ? false : true;
                triState4 = TriState.valueOf(z);
                triState3 = triState2;
                triState2 = triState;
            } else {
                triState4 = triState3;
                triState3 = triState2;
                triState2 = triState;
            }
            i++;
            triState = triState2;
            triState2 = triState3;
            triState3 = triState4;
        }
        if (triState == TriState.UNSET && triState2 == TriState.UNSET && triState3 == TriState.UNSET) {
            return CdnHeaderResponse.NO_HEADER;
        }
        if (triState != TriState.UNSET) {
            return triState.asBoolean() ? CdnHeaderResponse.FB_CDN_CACHE_HIT : CdnHeaderResponse.FB_CDN_CACHE_MISS;
        } else {
            if (triState2 == TriState.NO && triState3 == TriState.NO) {
                return CdnHeaderResponse.AKAMAI_CDN_CACHE_MISS;
            }
            return triState2.asBoolean() ? CdnHeaderResponse.AKAMAI_CDN_CACHE_EDGE_HIT : CdnHeaderResponse.AKAMAI_CDN_CACHE_MIDGRESS_HIT;
        }
    }
}

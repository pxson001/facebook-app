package com.facebook.http.tigon;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.debug.log.BLog;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequest.Builder;
import com.facebook.http.common.FbHttpRequestCancelTrigger;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.http.common.HttpFutureWrapper;
import com.facebook.http.common.RequestIdempotency;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.FallbackBehavior;
import com.facebook.inject.InjectorLike;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import com.facebook.tigon.iface.FacebookLoggingRequestInfo;
import com.facebook.tigon.iface.TigonRequest;
import com.facebook.tigon.iface.TigonRequestLayers;
import com.facebook.tigon.javaservice.AbstractRequestToken;
import com.facebook.tigon.javaservice.JavaBackedTigonService;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.message.BasicHeader;

@DoNotStrip
@Singleton
/* compiled from: push_missing_multiway_payload */
public class Tigon4aHttpService implements JavaBackedTigonService {
    private static final String f9516a = Tigon4aHttpService.class.getSimpleName();
    private static volatile Tigon4aHttpService f9517c;
    private final FbHttpRequestProcessor f9518b;

    public static com.facebook.http.tigon.Tigon4aHttpService m9888a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9517c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.tigon.Tigon4aHttpService.class;
        monitor-enter(r1);
        r0 = f9517c;	 Catch:{ all -> 0x003a }
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
        r0 = m9892b(r0);	 Catch:{ all -> 0x0035 }
        f9517c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9517c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.tigon.Tigon4aHttpService.a(com.facebook.inject.InjectorLike):com.facebook.http.tigon.Tigon4aHttpService");
    }

    private static Tigon4aHttpService m9892b(InjectorLike injectorLike) {
        return new Tigon4aHttpService(FbHttpRequestProcessor.a(injectorLike));
    }

    static {
        SoLoader.a("tigon4a");
    }

    @Inject
    public Tigon4aHttpService(FbHttpRequestProcessor fbHttpRequestProcessor) {
        this.f9518b = fbHttpRequestProcessor;
    }

    @DoNotStrip
    public void submitHttpRequest(AbstractRequestToken abstractRequestToken, TigonRequest tigonRequest, byte[] bArr) {
        try {
            Tigon4aRequestToken tigon4aRequestToken = (Tigon4aRequestToken) abstractRequestToken;
            TigonSpoolingResponseHandler tigonSpoolingResponseHandler = new TigonSpoolingResponseHandler(tigon4aRequestToken);
            HttpEntity httpEntity = null;
            if (bArr != null) {
                httpEntity = new ByteArrayEntity(bArr);
            }
            tigon4aRequestToken.m9884a(m9887a(tigonRequest, httpEntity, tigonSpoolingResponseHandler));
        } catch (Throwable e) {
            BLog.a(f9516a, e, "submitHttpRequest", new Object[0]);
            throw e;
        } catch (Throwable e2) {
            BLog.a(f9516a, e2, "submitHttpRequest", new Object[0]);
            IOException iOException = new IOException(e2);
        }
    }

    private HttpFutureWrapper<TigonResult> m9887a(TigonRequest tigonRequest, @Nullable HttpEntity httpEntity, final TigonSpoolingResponseHandler tigonSpoolingResponseHandler) {
        CallerContext a;
        String str;
        String str2 = "unspecified tigon";
        FacebookLoggingRequestInfo facebookLoggingRequestInfo = (FacebookLoggingRequestInfo) tigonRequest.mo307a(TigonRequestLayers.f4023c);
        if (facebookLoggingRequestInfo != null) {
            str2 = facebookLoggingRequestInfo.logName();
            String str3 = str2;
            a = CallerContext.a(getClass(), facebookLoggingRequestInfo.logNamespace(), str2);
            str = str3;
        } else {
            str = str2;
            a = null;
        }
        FbHttpRequestCancelTrigger fbHttpRequestCancelTrigger = new FbHttpRequestCancelTrigger();
        FallbackBehavior fallbackBehavior = FallbackBehavior.FALLBACK_NOT_REQUIRED;
        if (str.startsWith("mobile_config_request:")) {
            fallbackBehavior = FallbackBehavior.FALLBACK_REQUIRED;
            tigonSpoolingResponseHandler.f4039c = true;
        }
        Builder newBuilder = FbHttpRequest.newBuilder();
        newBuilder.b = m9889a(tigonRequest, httpEntity);
        newBuilder = newBuilder;
        newBuilder.c = str;
        Builder builder = newBuilder;
        builder.d = a;
        builder = builder;
        builder.e = "Tigon";
        builder = builder;
        builder.g = tigonSpoolingResponseHandler;
        builder = builder;
        builder.f = fallbackBehavior;
        builder = builder;
        builder.i = fbHttpRequestCancelTrigger;
        builder = builder;
        builder.k = RequestIdempotency.CONSERVATIVE;
        builder = builder;
        builder.l = RequestPriority.fromNumericValue(tigonRequest.mo311d().f4019a, RequestPriority.DEFAULT_PRIORITY);
        HttpFutureWrapper<TigonResult> b = this.f9518b.b(builder.a());
        Futures.a(b.b, new FutureCallback<TigonResult>(this) {
            final /* synthetic */ Tigon4aHttpService f4041b;

            public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
            }

            public void onFailure(Throwable th) {
                tigonSpoolingResponseHandler.f4038b.m9885a(th);
            }
        }, MoreExecutors.a());
        return b;
    }

    private static HttpUriRequest m9889a(TigonRequest tigonRequest, @Nullable HttpEntity httpEntity) {
        HttpUriRequest httpGet;
        if (TigonRequest.GET.equalsIgnoreCase(tigonRequest.mo308a())) {
            httpGet = new HttpGet(tigonRequest.mo309b());
            HttpClientParams.setRedirecting(httpGet.getParams(), true);
        } else if (TigonRequest.POST.equalsIgnoreCase(tigonRequest.mo308a())) {
            httpGet = new HttpPost(tigonRequest.mo309b());
            if (httpEntity != null) {
                httpGet.setEntity(httpEntity);
            }
        } else {
            throw new InvalidParameterException("Unsupported HTTP method " + tigonRequest.mo308a());
        }
        httpGet.setHeaders(m9891a(tigonRequest.mo310c()));
        return httpGet;
    }

    private static Header[] m9891a(Map<String, String> map) {
        ArrayList a = Lists.a(map.size());
        for (Entry entry : map.entrySet()) {
            a.add(entry.getKey());
            a.add(entry.getValue());
        }
        return m9890a(a);
    }

    private static Header[] m9890a(ArrayList<String> arrayList) {
        int size = arrayList.size();
        if ((size & 1) != 0) {
            throw new IllegalArgumentException("Received odd number of strings; keys and vals unmatched");
        }
        ArrayList a = Lists.a(size / 2);
        for (int i = 0; i < size; i += 2) {
            String str = (String) arrayList.get(i);
            if (!"Content-Length".equalsIgnoreCase(str)) {
                a.add(new BasicHeader(str, (String) arrayList.get(i + 1)));
            }
        }
        return (Header[]) a.toArray(new Header[a.size()]);
    }
}

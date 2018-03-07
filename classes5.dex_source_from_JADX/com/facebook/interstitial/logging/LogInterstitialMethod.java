package com.facebook.interstitial.logging;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.message.BasicNameValuePair;

@Singleton
/* compiled from: TOPIC_FEED_PIVOT */
public class LogInterstitialMethod implements ApiMethod<LogInterstitialParams, Void> {
    private static volatile LogInterstitialMethod f13861b;
    private final ObjectMapper f13862a;

    public static com.facebook.interstitial.logging.LogInterstitialMethod m23233a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13861b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.interstitial.logging.LogInterstitialMethod.class;
        monitor-enter(r1);
        r0 = f13861b;	 Catch:{ all -> 0x003a }
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
        r0 = m23234b(r0);	 Catch:{ all -> 0x0035 }
        f13861b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13861b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.interstitial.logging.LogInterstitialMethod.a(com.facebook.inject.InjectorLike):com.facebook.interstitial.logging.LogInterstitialMethod");
    }

    private static LogInterstitialMethod m23234b(InjectorLike injectorLike) {
        return new LogInterstitialMethod((ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    public final ApiRequest m23235a(Object obj) {
        LogInterstitialParams logInterstitialParams = (LogInterstitialParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        String a2 = StringFormatUtil.a("me/interstitials/%s", new Object[]{logInterstitialParams.f13863a});
        a.add(new BasicNameValuePair("log_event", logInterstitialParams.f13864b.toString()));
        a.add(new BasicNameValuePair("log_data", this.f13862a.a(logInterstitialParams.f13865c)));
        return new ApiRequest("LogInterstitialMethod", "POST", a2, a, ApiResponseType.JSON);
    }

    @Inject
    public LogInterstitialMethod(ObjectMapper objectMapper) {
        this.f13862a = objectMapper;
    }

    public final Object m23236a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}

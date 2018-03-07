package com.facebook.messaging.payment.protocol.eligibility;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.payment.service.model.eligibility.FetchP2PSendEligibilityParams;
import com.facebook.messaging.payment.service.model.eligibility.FetchP2PSendEligibilityResult;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Singleton;
import org.apache.http.message.BasicNameValuePair;

@Singleton
/* compiled from: followUpActionButtonText */
public class FetchP2PSendEligibilityMethod implements ApiMethod<FetchP2PSendEligibilityParams, FetchP2PSendEligibilityResult> {
    private static final Class<?> f14587b = FetchP2PSendEligibilityMethod.class;
    private static volatile FetchP2PSendEligibilityMethod f14588c;
    @VisibleForTesting
    String f14589a;

    public static com.facebook.messaging.payment.protocol.eligibility.FetchP2PSendEligibilityMethod m15049a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f14588c;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.messaging.payment.protocol.eligibility.FetchP2PSendEligibilityMethod.class;
        monitor-enter(r1);
        r0 = f14588c;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m15048a();	 Catch:{ all -> 0x0034 }
        f14588c = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f14588c;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.protocol.eligibility.FetchP2PSendEligibilityMethod.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.protocol.eligibility.FetchP2PSendEligibilityMethod");
    }

    private static FetchP2PSendEligibilityMethod m15048a() {
        return new FetchP2PSendEligibilityMethod();
    }

    public final ApiRequest m15050a(Object obj) {
        FetchP2PSendEligibilityParams fetchP2PSendEligibilityParams = (FetchP2PSendEligibilityParams) obj;
        List a = Lists.a();
        this.f14589a = StringFormatUtil.formatStrLocaleSafe("node(%s) { %s }", fetchP2PSendEligibilityParams.f14662c, "can_viewer_send_money");
        a.add(new BasicNameValuePair("q", this.f14589a));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "fetchP2PSendEligibility";
        newBuilder = newBuilder;
        newBuilder.c = "GET";
        newBuilder = newBuilder;
        newBuilder.d = "graphql";
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSONPARSER;
        return apiRequestBuilder.C();
    }

    public final Object m15051a(Object obj, ApiResponse apiResponse) {
        FetchP2PSendEligibilityParams fetchP2PSendEligibilityParams = (FetchP2PSendEligibilityParams) obj;
        JsonParser d = apiResponse.d();
        String str = fetchP2PSendEligibilityParams.f14662c;
        d.c();
        while (d.h() && !str.equals(d.i())) {
            d.c();
        }
        if (d.h()) {
            return (FetchP2PSendEligibilityResult) apiResponse.d().a(FetchP2PSendEligibilityResult.class);
        }
        throw new IllegalStateException("Response did not contain desired receiver ID");
    }
}

package com.facebook.messaging.payment.protocol.sync;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.payment.service.model.sync.FetchIrisSequenceIdResult;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Singleton;
import org.apache.http.message.BasicNameValuePair;

@Singleton
/* compiled from: folder='%1$s' AND action_id > %2$d */
public class FetchIrisSequenceIdMethod implements ApiMethod<Void, FetchIrisSequenceIdResult> {
    private static volatile FetchIrisSequenceIdMethod f14596a;

    public static com.facebook.messaging.payment.protocol.sync.FetchIrisSequenceIdMethod m15092a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14596a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.messaging.payment.protocol.sync.FetchIrisSequenceIdMethod.class;
        monitor-enter(r1);
        r0 = f14596a;	 Catch:{ all -> 0x0039 }
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
        r0 = m15093b();	 Catch:{ all -> 0x0034 }
        f14596a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f14596a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.protocol.sync.FetchIrisSequenceIdMethod.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.protocol.sync.FetchIrisSequenceIdMethod");
    }

    private static FetchIrisSequenceIdMethod m15093b() {
        return new FetchIrisSequenceIdMethod();
    }

    public final ApiRequest m15094a(Object obj) {
        List a = Lists.a();
        a.add(new BasicNameValuePair("q", "viewer() { peer_to_peer_payments { iris_sequence_id } }"));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "fetchIrisSequenceId";
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

    public final Object m15095a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        JsonParser d = apiResponse.d();
        d.c();
        while (d.h() && d.i() != "peer_to_peer_payments") {
            d.c();
        }
        if (!d.h()) {
            return new FetchIrisSequenceIdResult(null);
        }
        d.c();
        return (FetchIrisSequenceIdResult) d.a(FetchIrisSequenceIdResult.class);
    }
}

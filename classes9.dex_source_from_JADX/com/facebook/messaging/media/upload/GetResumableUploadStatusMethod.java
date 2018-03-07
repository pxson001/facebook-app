package com.facebook.messaging.media.upload;

import com.facebook.common.util.JSONUtil;
import com.facebook.http.common.RequestIdempotency;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.Immutable;
import javax.inject.Singleton;
import org.apache.http.NameValuePair;

@Singleton
/* compiled from: location_full_address */
public class GetResumableUploadStatusMethod implements ApiMethod<Params, Integer> {
    private static final List<NameValuePair> f11837a = new ArrayList();
    private static volatile GetResumableUploadStatusMethod f11838b;

    @Immutable
    /* compiled from: location_full_address */
    public class Params {
        public final String f11836a;

        public Params(String str) {
            this.f11836a = str;
        }
    }

    public static com.facebook.messaging.media.upload.GetResumableUploadStatusMethod m12451a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11838b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.messaging.media.upload.GetResumableUploadStatusMethod.class;
        monitor-enter(r1);
        r0 = f11838b;	 Catch:{ all -> 0x0039 }
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
        r0 = m12450a();	 Catch:{ all -> 0x0034 }
        f11838b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f11838b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.GetResumableUploadStatusMethod.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.GetResumableUploadStatusMethod");
    }

    private static GetResumableUploadStatusMethod m12450a() {
        return new GetResumableUploadStatusMethod();
    }

    public final ApiRequest m12452a(Object obj) {
        Params params = (Params) obj;
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "get_resumable_upload_session";
        newBuilder = newBuilder;
        newBuilder.c = "GET";
        newBuilder = newBuilder;
        newBuilder.d = "up/" + params.f11836a;
        newBuilder = newBuilder;
        newBuilder.o = true;
        newBuilder = newBuilder;
        newBuilder.g = f11837a;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.a(RequestIdempotency.RETRY_SAFE).C();
    }

    public final Object m12453a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Integer.valueOf(JSONUtil.a(apiResponse.c().b("offset"), 0));
    }
}

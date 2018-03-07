package com.facebook.messaging.media.upload.segmented;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Singleton;
import org.apache.http.HttpException;
import org.apache.http.message.BasicNameValuePair;

@Singleton
/* compiled from: last_visitied_ms_type */
public class CancelStreamUploadMethod implements ApiMethod<Params, Void> {
    private static volatile CancelStreamUploadMethod f12078a;

    /* compiled from: last_visitied_ms_type */
    public class Params {
        public final String f12076a;
        public final String f12077b;

        public Params(String str, String str2) {
            this.f12076a = str;
            this.f12077b = str2;
        }
    }

    public static com.facebook.messaging.media.upload.segmented.CancelStreamUploadMethod m12598a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12078a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.messaging.media.upload.segmented.CancelStreamUploadMethod.class;
        monitor-enter(r1);
        r0 = f12078a;	 Catch:{ all -> 0x0039 }
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
        r0 = m12597a();	 Catch:{ all -> 0x0034 }
        f12078a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f12078a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.segmented.CancelStreamUploadMethod.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.segmented.CancelStreamUploadMethod");
    }

    private static CancelStreamUploadMethod m12597a() {
        return new CancelStreamUploadMethod();
    }

    public final ApiRequest m12599a(Object obj) {
        Params params = (Params) obj;
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "cancel_stream_upload";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "messenger_videos/" + params.f12076a + "/?phase=cancel";
        newBuilder = newBuilder;
        newBuilder.o = true;
        newBuilder = newBuilder;
        Builder builder = ImmutableList.builder();
        builder.c(new BasicNameValuePair("Stream-Id", params.f12077b));
        newBuilder.g = builder.b();
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    public final Object m12600a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        if (apiResponse.b == 200) {
            return null;
        }
        throw new HttpException("Video segment transcoding upload failed. " + apiResponse.toString());
    }
}

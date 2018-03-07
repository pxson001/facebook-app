package com.facebook.messaging.media.upload.segmented;

import com.facebook.common.util.JSONUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.model.attachment.VideoData.Source;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Singleton;
import org.apache.http.HttpException;
import org.apache.http.message.BasicNameValuePair;

@Singleton
/* compiled from: last_used_targeting */
public class StartStreamUploadMethod implements ApiMethod<Params, String> {
    private static volatile StartStreamUploadMethod f12090a;

    /* compiled from: last_used_targeting */
    public class Params {
        public final MediaResource f12088a;
        public final String f12089b;

        public Params(MediaResource mediaResource, String str) {
            Preconditions.checkNotNull(mediaResource, "MediaResource is null");
            this.f12088a = mediaResource;
            this.f12089b = str;
        }
    }

    public static com.facebook.messaging.media.upload.segmented.StartStreamUploadMethod m12610a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12090a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.messaging.media.upload.segmented.StartStreamUploadMethod.class;
        monitor-enter(r1);
        r0 = f12090a;	 Catch:{ all -> 0x0039 }
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
        r0 = m12609a();	 Catch:{ all -> 0x0034 }
        f12090a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f12090a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.segmented.StartStreamUploadMethod.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.segmented.StartStreamUploadMethod");
    }

    private static StartStreamUploadMethod m12609a() {
        return new StartStreamUploadMethod();
    }

    public final ApiRequest m12611a(Object obj) {
        String str;
        Params params = (Params) obj;
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "start_stream_upload";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "messenger_videos/" + params.f12089b + "/?phase=start";
        newBuilder = newBuilder;
        newBuilder.o = true;
        newBuilder = newBuilder;
        Builder builder = ImmutableList.builder();
        String str2 = "video_type";
        if (params.f12088a.e.isQuickCamSource()) {
            str = Source.QUICKCAM.apiStringValue;
        } else {
            str = Source.NONQUICKCAM.apiStringValue;
        }
        builder.c(new BasicNameValuePair(str2, str));
        newBuilder.g = builder.b();
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    public final Object m12612a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        if (apiResponse.b == 200) {
            return JSONUtil.b(apiResponse.c().b("stream_id"));
        }
        throw new HttpException("Video segment transcode upload failed. " + apiResponse.toString());
    }
}

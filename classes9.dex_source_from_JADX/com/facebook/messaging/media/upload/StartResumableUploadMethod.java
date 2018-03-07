package com.facebook.messaging.media.upload;

import com.facebook.common.util.JSONUtil;
import com.facebook.http.common.RequestIdempotency;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequest.PostEntityType;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.upload.util.MediaHashCache;
import com.facebook.messaging.model.attachment.ImageData;
import com.facebook.messaging.model.attachment.VideoData.Source;
import com.facebook.messaging.model.attribution.ContentAppAttribution;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.File;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.message.BasicNameValuePair;

@Singleton
/* compiled from: leave_fullscreen_button */
public class StartResumableUploadMethod implements ApiMethod<Params, Response> {
    private static volatile StartResumableUploadMethod f12058c;
    public final SkipUploadExperimentHelper f12059a;
    public final MediaHashCache f12060b;

    @Immutable
    /* compiled from: leave_fullscreen_button */
    public class Params {
        public final File f12051a;
        public final String f12052b;
        public final MediaResource f12053c;
        public final String f12054d;
        public final int f12055e;

        public Params(File file, String str, MediaResource mediaResource, String str2, int i) {
            Preconditions.checkState(file.length() > 0, "Object size is invalid : " + file.length());
            this.f12051a = file;
            this.f12052b = str;
            this.f12053c = mediaResource;
            this.f12054d = str2;
            this.f12055e = i;
        }
    }

    @Immutable
    /* compiled from: leave_fullscreen_button */
    public class Response {
        public final String f12056a;
        public final String f12057b;

        public Response(String str, String str2) {
            this.f12056a = str;
            this.f12057b = str2;
        }
    }

    public static com.facebook.messaging.media.upload.StartResumableUploadMethod m12580a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12058c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.media.upload.StartResumableUploadMethod.class;
        monitor-enter(r1);
        r0 = f12058c;	 Catch:{ all -> 0x003a }
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
        r0 = m12581b(r0);	 Catch:{ all -> 0x0035 }
        f12058c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12058c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.StartResumableUploadMethod.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.StartResumableUploadMethod");
    }

    private static StartResumableUploadMethod m12581b(InjectorLike injectorLike) {
        return new StartResumableUploadMethod(SkipUploadExperimentHelper.a(injectorLike), MediaHashCache.a(injectorLike));
    }

    public final ApiRequest m12583a(Object obj) {
        Params params = (Params) obj;
        int length = ((int) params.f12051a.length()) - params.f12055e;
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "post_resumable_upload_session";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "up/" + params.f12052b;
        newBuilder = newBuilder;
        newBuilder.o = true;
        newBuilder = newBuilder;
        Builder builder = ImmutableList.builder();
        builder.c(new BasicNameValuePair("Offset", Long.toString((long) params.f12055e)));
        builder.c(new BasicNameValuePair("X-Entity-Length", Long.toString(params.f12051a.length())));
        builder.c(new BasicNameValuePair("X-Entity-Name", params.f12051a.getName()));
        builder.c(new BasicNameValuePair("X-Entity-Type", params.f12053c.o));
        if (params.f12055e == 0) {
            MediaResource mediaResource = params.f12053c;
            if (mediaResource.d == Type.PHOTO) {
                builder.c(new BasicNameValuePair("image_type", m12582b(mediaResource)));
            } else if (mediaResource.d == Type.VIDEO) {
                String str;
                String str2 = "video_type";
                if (mediaResource.e.isQuickCamSource()) {
                    str = Source.QUICKCAM.apiStringValue;
                } else {
                    str = Source.NONQUICKCAM.apiStringValue;
                }
                builder.c(new BasicNameValuePair(str2, str));
            } else if (mediaResource.d == Type.ENCRYPTED_PHOTO) {
                builder.c(new BasicNameValuePair("encrypted_blob", "FILE_ATTACHMENT"));
            } else if (mediaResource.d == Type.ENT_PHOTO) {
                builder.c(new BasicNameValuePair("image_type", m12582b(mediaResource)));
                builder.c(new BasicNameValuePair("use_ent_photo", "1"));
            } else if (mediaResource.d == Type.AUDIO) {
                builder.c(new BasicNameValuePair("audio_type", "VOICE_MESSAGE"));
                builder.c(new BasicNameValuePair("duration", String.valueOf(mediaResource.i)));
                builder.c(new BasicNameValuePair("is_voicemail", mediaResource.C ? "1" : "0"));
            }
            if (params.f12054d != null) {
                builder.c(new BasicNameValuePair("original_fbid", params.f12054d));
            } else {
                if (this.f12059a.a(mediaResource) && !Strings.isNullOrEmpty(this.f12060b.c(mediaResource))) {
                    builder.c(new BasicNameValuePair("media_hash", this.f12060b.c(mediaResource)));
                }
                ContentAppAttribution contentAppAttribution = mediaResource.x;
                if (contentAppAttribution != null) {
                    builder.c(new BasicNameValuePair("attribution_app_id", contentAppAttribution.b));
                    builder.c(new BasicNameValuePair("android_key_hash", contentAppAttribution.d));
                    if (contentAppAttribution.f != null) {
                        builder.c(new BasicNameValuePair("attribution_app_metadata", contentAppAttribution.f));
                    }
                }
            }
        }
        newBuilder.g = builder.b();
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        newBuilder = newBuilder;
        newBuilder.w = PostEntityType.FILE_PART_ENTITY;
        return newBuilder.a(params.f12051a, params.f12055e, length).a(RequestIdempotency.RETRY_SAFE).C();
    }

    @Inject
    public StartResumableUploadMethod(SkipUploadExperimentHelper skipUploadExperimentHelper, MediaHashCache mediaHashCache) {
        this.f12059a = skipUploadExperimentHelper;
        this.f12060b = mediaHashCache;
    }

    public final Object m12584a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        JsonNode c = apiResponse.c();
        return new Response(JSONUtil.a(c.b("id"), ""), JSONUtil.a(c.b("media_id"), ""));
    }

    public static String m12582b(MediaResource mediaResource) {
        return mediaResource.e.isQuickCamSource() ? ImageData.Source.QUICKCAM.apiStringValue : ImageData.Source.NONQUICKCAM.apiStringValue;
    }
}

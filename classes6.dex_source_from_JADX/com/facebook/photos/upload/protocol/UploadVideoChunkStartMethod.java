package com.facebook.photos.upload.protocol;

import com.facebook.common.util.StringUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.upload.uploaders.UploadAssetSegment;
import com.facebook.share.model.ComposerAppAttribution;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: gatekeeper_pairs.txt */
public class UploadVideoChunkStartMethod implements ApiMethod<UploadVideoChunkStartParams, UploadVideoChunkStartResponse> {
    public static UploadVideoChunkStartMethod m21869a(InjectorLike injectorLike) {
        return new UploadVideoChunkStartMethod();
    }

    public static ApiRequest m21868a(UploadVideoChunkStartParams uploadVideoChunkStartParams) {
        Builder builder = ImmutableList.builder();
        String str = uploadVideoChunkStartParams.f14200c;
        if (!StringUtil.a(str)) {
            builder.c(new BasicNameValuePair("composer_session_id", str));
        }
        String str2 = uploadVideoChunkStartParams.f14201d;
        if (!StringUtil.a(str2)) {
            builder.c(new BasicNameValuePair("original_file_hash", str2));
        }
        long j = uploadVideoChunkStartParams.f14198a;
        if (j > 0) {
            builder.c(new BasicNameValuePair("file_size", Long.toString(j)));
        }
        UploadAssetSegment uploadAssetSegment = uploadVideoChunkStartParams.f14207j;
        if (uploadAssetSegment != null) {
            builder.c(new BasicNameValuePair("partition_start_offset", Long.toString(uploadAssetSegment.f14444e)));
            builder.c(new BasicNameValuePair("partition_end_offset", Long.toString(uploadAssetSegment.f14445f)));
        }
        builder.c(new BasicNameValuePair("published", String.valueOf(uploadVideoChunkStartParams.f14205h)));
        if (uploadVideoChunkStartParams.m21873i() > 0) {
            builder.c(new BasicNameValuePair("scheduled_publish_time", Long.toString(uploadVideoChunkStartParams.m21873i())));
        }
        ComposerAppAttribution composerAppAttribution = uploadVideoChunkStartParams.f14202e;
        if (composerAppAttribution != null) {
            builder.c(new BasicNameValuePair("proxied_app_id", composerAppAttribution.m7689a()));
            builder.c(new BasicNameValuePair("proxied_app_name", composerAppAttribution.m7690b()));
            builder.c(new BasicNameValuePair("android_key_hash", composerAppAttribution.m7691c()));
            builder.c(new BasicNameValuePair("user_selected_tags", String.valueOf(uploadVideoChunkStartParams.f14203f)));
            builder.c(new BasicNameValuePair("user_selected_place", String.valueOf(uploadVideoChunkStartParams.f14204g)));
        }
        str2 = "v2.3/" + uploadVideoChunkStartParams.m21872a() + "/videos";
        builder.c(new BasicNameValuePair("upload_phase", "start"));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "upload-video-chunk-start";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = str2;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.g = builder.b();
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        apiRequestBuilder2.n = true;
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.p = true;
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.A = str;
        return apiRequestBuilder2.C();
    }

    public final Object m21871a(Object obj, ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        boolean z = false;
        if (c.d("skip_upload")) {
            z = c.b("skip_upload").F();
        }
        return new UploadVideoChunkStartResponse(c.b("upload_session_id").s(), c.b("video_id").s(), c.b("start_offset").D(), c.b("end_offset").D(), z);
    }
}

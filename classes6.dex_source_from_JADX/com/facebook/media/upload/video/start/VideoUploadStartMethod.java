package com.facebook.media.upload.video.start;

import com.facebook.common.util.StringUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.media.upload.MediaUploadParameters;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: item_id */
class VideoUploadStartMethod implements ApiMethod<VideoUploadStartParams, VideoUploadStartResponse> {
    VideoUploadStartMethod() {
    }

    public final ApiRequest m18896a(Object obj) {
        ImmutableList immutableList;
        VideoUploadStartParams videoUploadStartParams = (VideoUploadStartParams) obj;
        Builder builder = ImmutableList.builder();
        MediaUploadParameters mediaUploadParameters = videoUploadStartParams.f11980b;
        String str = mediaUploadParameters.f11891a;
        if (!StringUtil.a(str)) {
            builder.c(new BasicNameValuePair("composer_session_id", str));
        }
        String str2 = mediaUploadParameters.f11894d;
        if (!StringUtil.a(str2)) {
            builder.c(new BasicNameValuePair("original_file_hash", str2));
        }
        long j = videoUploadStartParams.f11979a;
        if (j > 0) {
            builder.c(new BasicNameValuePair("file_size", Long.toString(j)));
        }
        builder.c(new BasicNameValuePair("upload_phase", "start"));
        if (mediaUploadParameters.f11895e == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.copyOf(mediaUploadParameters.f11895e);
        }
        builder.b(immutableList);
        String str3 = "v2.3/" + mediaUploadParameters.f11892b + "/videos";
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "media-upload-video-chunk-start";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = str3;
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

    public final Object m18897a(Object obj, ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        boolean z = false;
        if (c.d("skip_upload")) {
            z = c.b("skip_upload").F();
        }
        return new VideoUploadStartResponse(c.b("upload_session_id").s(), c.b("video_id").s(), c.b("start_offset").D(), c.b("end_offset").D(), z);
    }
}

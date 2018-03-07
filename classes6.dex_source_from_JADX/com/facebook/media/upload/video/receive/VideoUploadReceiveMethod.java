package com.facebook.media.upload.video.receive;

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
import org.apache.http.message.BasicNameValuePair;

/* compiled from: javax.net. */
class VideoUploadReceiveMethod implements ApiMethod<VideoUploadReceiveParams, VideoUploadReceiveResponse> {
    VideoUploadReceiveMethod() {
    }

    public final ApiRequest m18878a(Object obj) {
        VideoUploadReceiveParams videoUploadReceiveParams = (VideoUploadReceiveParams) obj;
        Builder builder = ImmutableList.builder();
        MediaUploadParameters mediaUploadParameters = videoUploadReceiveParams.f11947d;
        builder.c(new BasicNameValuePair("start_offset", Long.toString(videoUploadReceiveParams.f11945b)));
        String str = mediaUploadParameters.f11891a;
        if (!StringUtil.a(str)) {
            builder.c(new BasicNameValuePair("composer_session_id", str));
        }
        builder.c(new BasicNameValuePair("target", mediaUploadParameters.f11892b));
        builder.c(new BasicNameValuePair("upload_speed", Float.toString(videoUploadReceiveParams.f11946c)));
        builder.c(new BasicNameValuePair("upload_phase", "transfer"));
        builder.c(new BasicNameValuePair("upload_session_id", videoUploadReceiveParams.f11944a));
        builder.c(new BasicNameValuePair("fbuploader_video_file_chunk", videoUploadReceiveParams.f11948e));
        String str2 = "v2.3/" + mediaUploadParameters.f11892b + "/videos";
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "upload-video-chunk-receive";
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

    public final Object m18879a(Object obj, ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        return new VideoUploadReceiveResponse(c.b("start_offset").D(), c.b("end_offset").D());
    }
}

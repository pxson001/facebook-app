package com.facebook.photos.upload.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: genie_attachment */
public class UploadVideoChunkCancelMethod implements ApiMethod<UploadVideoChunkCancelParams, Boolean> {
    public static UploadVideoChunkCancelMethod m21836a(InjectorLike injectorLike) {
        return new UploadVideoChunkCancelMethod();
    }

    public final ApiRequest m21837a(Object obj) {
        UploadVideoChunkCancelParams uploadVideoChunkCancelParams = (UploadVideoChunkCancelParams) obj;
        Builder builder = ImmutableList.builder();
        String str = uploadVideoChunkCancelParams.f14139b;
        builder.c(new BasicNameValuePair("composer_session_id", uploadVideoChunkCancelParams.f14139b));
        String str2 = "v2.3/" + uploadVideoChunkCancelParams.f14140c + "/videos";
        builder.c(new BasicNameValuePair("upload_phase", "cancel"));
        builder.c(new BasicNameValuePair("upload_session_id", uploadVideoChunkCancelParams.f14138a));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "upload-video-chunk-cancel";
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

    public final Object m21838a(Object obj, ApiResponse apiResponse) {
        return Boolean.valueOf(apiResponse.c().b("success").F());
    }
}

package com.facebook.photos.upload.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* compiled from: general_feedback_screen_tag */
public class UploadVideoChunkSettingsMethod implements ApiMethod<UploadVideoChunkSettingsParams, UploadVideoChunkSettingsResponse> {
    public static UploadVideoChunkSettingsMethod m21863a(InjectorLike injectorLike) {
        return new UploadVideoChunkSettingsMethod();
    }

    public final ApiRequest m21864a(Object obj) {
        UploadVideoChunkSettingsParams uploadVideoChunkSettingsParams = (UploadVideoChunkSettingsParams) obj;
        Builder builder = ImmutableList.builder();
        Map hashMap = new HashMap();
        hashMap.put("upload_settings_version", "v0.1");
        hashMap.put("video", uploadVideoChunkSettingsParams.f14194c);
        hashMap.put("context", uploadVideoChunkSettingsParams.f14195d);
        builder.c(new BasicNameValuePair("upload_setting_properties", new JSONObject(hashMap).toString()));
        String str = "v2.6/" + uploadVideoChunkSettingsParams.f14193b + "/videos";
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "upload-video-chunk-settings";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = str;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.g = builder.b();
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        apiRequestBuilder2.n = true;
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.p = true;
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.A = uploadVideoChunkSettingsParams.f14192a;
        return apiRequestBuilder2.C();
    }

    public final Object m21865a(Object obj, ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        return new UploadVideoChunkSettingsResponse(c.b("transcode_dimension").D(), c.b("transcode_bit_rate_bps").D());
    }
}

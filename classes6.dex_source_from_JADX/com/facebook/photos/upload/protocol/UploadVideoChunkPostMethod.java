package com.facebook.photos.upload.protocol;

import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.publish.protocol.TopicFeedsPublishHelper;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: generic_map_runtime_permission_result */
public class UploadVideoChunkPostMethod implements ApiMethod<UploadVideoChunkPostParams, Boolean> {
    private final Clock f14141a;
    private final FbObjectMapper f14142b;

    public static UploadVideoChunkPostMethod m21839a(InjectorLike injectorLike) {
        return new UploadVideoChunkPostMethod((Clock) SystemClockMethodAutoProvider.a(injectorLike), FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public UploadVideoChunkPostMethod(Clock clock, FbObjectMapper fbObjectMapper) {
        this.f14141a = clock;
        this.f14142b = fbObjectMapper;
    }

    public final ApiRequest m21840a(UploadVideoChunkPostParams uploadVideoChunkPostParams) {
        Builder builder = ImmutableList.builder();
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        UploadVideoPostHelper.m21881a(builder, newBuilder, uploadVideoChunkPostParams, this.f14141a, this.f14142b);
        String str = "v2.3/" + uploadVideoChunkPostParams.f14160j + "/videos";
        builder.c(new BasicNameValuePair("upload_phase", "finish"));
        if (!StringUtil.a(uploadVideoChunkPostParams.f14153c)) {
            builder.c(new BasicNameValuePair("upload_session_id", uploadVideoChunkPostParams.f14153c));
        }
        TopicFeedsPublishHelper.m11663a(uploadVideoChunkPostParams.f14149E, builder);
        newBuilder.b = "upload-video-chunk-post";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = str;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        newBuilder = newBuilder;
        newBuilder.g = builder.b();
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.n = true;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.p = true;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.A = uploadVideoChunkPostParams.f14163m;
        return apiRequestBuilder.C();
    }

    public final Object m21842a(Object obj, ApiResponse apiResponse) {
        return Boolean.valueOf(apiResponse.c().b("success").F());
    }
}

package com.facebook.photos.upload.protocol;

import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: gCoreClientName */
public class UploadVideoSlideshowPostMethod implements ApiMethod<UploadVideoSlideshowPostParams, String> {
    private final Clock f14213a;
    private final FbObjectMapper f14214b;

    public static UploadVideoSlideshowPostMethod m21882a(InjectorLike injectorLike) {
        return new UploadVideoSlideshowPostMethod((Clock) SystemClockMethodAutoProvider.a(injectorLike), FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    public final ApiRequest m21883a(Object obj) {
        UploadVideoSlideshowPostParams uploadVideoSlideshowPostParams = (UploadVideoSlideshowPostParams) obj;
        Builder builder = ImmutableList.builder();
        UploadVideoPostHelper.m21881a(builder, ApiRequest.newBuilder(), uploadVideoSlideshowPostParams, this.f14213a, this.f14214b);
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("images_urls", UploadVideoPostHelper.m21880a((List) uploadVideoSlideshowPostParams.f14215c));
        objectNode.a("duration_ms", uploadVideoSlideshowPostParams.f14216d);
        objectNode.a("transition_ms", uploadVideoSlideshowPostParams.f14217e);
        builder.c(new BasicNameValuePair("slideshow_spec", objectNode.toString()));
        String str = "v2.3/" + uploadVideoSlideshowPostParams.f14160j + "/videos";
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "post-slideshow-video";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        newBuilder = newBuilder;
        newBuilder.d = str;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.n = true;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.A = uploadVideoSlideshowPostParams.f14163m;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.g = builder.b();
        return apiRequestBuilder.C();
    }

    @Inject
    public UploadVideoSlideshowPostMethod(Clock clock, FbObjectMapper fbObjectMapper) {
        this.f14213a = clock;
        this.f14214b = fbObjectMapper;
    }

    public final Object m21884a(Object obj, ApiResponse apiResponse) {
        if (apiResponse.c() == null || apiResponse.c().b("id") == null) {
            return null;
        }
        return apiResponse.c().b("id").B();
    }
}

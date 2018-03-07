package com.facebook.photos.upload.protocol;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
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

/* compiled from: getLevelNumber */
public class PublishCoverPhotoMethod implements ApiMethod<UploadPhotoParams, Long> {
    private final Clock f14025a;

    public static PublishCoverPhotoMethod m21729a(InjectorLike injectorLike) {
        return new PublishCoverPhotoMethod((Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    public final ApiRequest m21730a(Object obj) {
        UploadPhotoParams uploadPhotoParams = (UploadPhotoParams) obj;
        float f = 0.5f;
        Builder builder = ImmutableList.builder();
        String str = uploadPhotoParams.f14122p;
        if (!StringUtil.a(str)) {
            builder.c(new BasicNameValuePair("qn", str));
        }
        long H = uploadPhotoParams.m21801H();
        if (H != 0) {
            builder.c(new BasicNameValuePair("time_since_original_post", String.valueOf(Math.max((this.f14025a.a() / 1000) - H, 0))));
        }
        builder.c(new BasicNameValuePair("photo", Long.toString(uploadPhotoParams.m21831v())));
        float f2 = uploadPhotoParams.f14088F;
        float f3 = uploadPhotoParams.f14089G;
        if (Float.isNaN(f2)) {
            f2 = 0.5f;
        }
        if (!Float.isNaN(f3)) {
            f = f3;
        }
        builder.c(new BasicNameValuePair("focus_x", Float.toString(f2)));
        builder.c(new BasicNameValuePair("focus_y", Float.toString(f)));
        str = uploadPhotoParams.m21818g() + "/cover";
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "publish-photo";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = str;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.g = builder.b();
        return apiRequestBuilder.C();
    }

    public final Object m21731a(Object obj, ApiResponse apiResponse) {
        return Long.valueOf(((UploadPhotoParams) obj).f14084B);
    }

    @Inject
    public PublishCoverPhotoMethod(Clock clock) {
        this.f14025a = clock;
    }
}

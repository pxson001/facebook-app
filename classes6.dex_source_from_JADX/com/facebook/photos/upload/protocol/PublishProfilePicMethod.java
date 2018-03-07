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
import org.json.JSONObject;

/* compiled from: getId */
public class PublishProfilePicMethod implements ApiMethod<UploadPhotoParams, Long> {
    private final Clock f14030a;

    public static PublishProfilePicMethod m21736a(InjectorLike injectorLike) {
        return new PublishProfilePicMethod((Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    public final ApiRequest m21737a(Object obj) {
        UploadPhotoParams uploadPhotoParams = (UploadPhotoParams) obj;
        Builder builder = ImmutableList.builder();
        String str = uploadPhotoParams.f14122p;
        if (!StringUtil.a(str)) {
            builder.c(new BasicNameValuePair("qn", str));
        }
        long H = uploadPhotoParams.m21801H();
        if (H != 0) {
            builder.c(new BasicNameValuePair("time_since_original_post", String.valueOf(Math.max((this.f14030a.a() / 1000) - H, 0))));
        }
        builder.c(new BasicNameValuePair("scaled_crop_rect", new JSONObject().put("x", 0).put("y", 0).put("width", 1).put("height", 1).toString()));
        builder.c(new BasicNameValuePair("profile_pic_method", uploadPhotoParams.f14098P));
        if (uploadPhotoParams.f14099Q != null) {
            builder.c(new BasicNameValuePair("sticker_source_object_id", uploadPhotoParams.f14099Q));
        }
        if (uploadPhotoParams.m21807W() != 0) {
            builder.c(new BasicNameValuePair("expiration_time", String.valueOf(uploadPhotoParams.m21807W())));
        }
        if (uploadPhotoParams.f14101S != null) {
            builder.c(new BasicNameValuePair("sticker_id", uploadPhotoParams.f14101S));
        }
        if (uploadPhotoParams.f14117k != null) {
            builder.c(new BasicNameValuePair("caption", uploadPhotoParams.f14117k));
        }
        builder.c(new BasicNameValuePair("has_umg", String.valueOf(uploadPhotoParams.f14102T)));
        str = uploadPhotoParams.m21818g() + "/picture/" + Long.toString(uploadPhotoParams.m21831v());
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "publish-photo";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = str;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.STRING;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.g = builder.b();
        return apiRequestBuilder.C();
    }

    public final Object m21738a(Object obj, ApiResponse apiResponse) {
        return Long.valueOf(((UploadPhotoParams) obj).f14084B);
    }

    @Inject
    public PublishProfilePicMethod(Clock clock) {
        this.f14030a = clock;
    }
}

package com.facebook.timeline.profilepiccoverphotoupload;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: mSessionId */
public class SetCoverPhotoMethod implements ApiMethod<SetCoverPhotoParams, String> {
    public static SetCoverPhotoMethod m11011a(InjectorLike injectorLike) {
        return new SetCoverPhotoMethod();
    }

    public final ApiRequest m11012a(Object obj) {
        SetCoverPhotoParams setCoverPhotoParams = (SetCoverPhotoParams) obj;
        if (setCoverPhotoParams.m11016h()) {
            Object obj2;
            List a = Lists.a();
            if (setCoverPhotoParams.m11015e() > 0.0f) {
                a.add(new BasicNameValuePair("focus_y", Float.toString(setCoverPhotoParams.m11015e())));
            }
            if (setCoverPhotoParams.m11014d() > 0.0f) {
                a.add(new BasicNameValuePair("focus_x", Float.toString(setCoverPhotoParams.m11014d())));
            }
            String str = "%s/cover";
            if (setCoverPhotoParams.f9245a == -1) {
                obj2 = "me";
            } else {
                obj2 = String.valueOf(setCoverPhotoParams.f9245a);
            }
            String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(str, obj2);
            ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
            newBuilder.b = "set_cover_photo";
            newBuilder = newBuilder;
            newBuilder.c = "POST";
            newBuilder = newBuilder;
            newBuilder.d = formatStrLocaleSafe;
            ApiRequestBuilder apiRequestBuilder = newBuilder;
            apiRequestBuilder.k = ApiResponseType.JSON;
            apiRequestBuilder = apiRequestBuilder;
            a.add(new BasicNameValuePair("photo", Long.toString(setCoverPhotoParams.f9249e)));
            apiRequestBuilder.g = a;
            return apiRequestBuilder.C();
        }
        throw new IllegalArgumentException("SetCoverPhotoMethod must be called withsetCoverPhotoParams.getUseExistingPhoto() == true");
    }

    public final Object m11013a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return apiResponse.c().b("id").B();
    }
}

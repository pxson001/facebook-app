package com.facebook.photos.data.method;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: icon_id */
public class EditPhotoLocationMethod implements ApiMethod<EditPhotoLocationParams, Boolean> {
    private static final Class<?> f12925a = EditPhotoLocationMethod.class;

    public static EditPhotoLocationMethod m20303a(InjectorLike injectorLike) {
        return new EditPhotoLocationMethod();
    }

    public final ApiRequest m20304a(Object obj) {
        EditPhotoLocationParams editPhotoLocationParams = (EditPhotoLocationParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("is_explicit_location", "true"));
        String str = editPhotoLocationParams.f12927b;
        if (!str.equals("-1")) {
            a.add(new BasicNameValuePair("place", str));
        }
        str = editPhotoLocationParams.f12928c;
        if (str != null) {
            a.add(new BasicNameValuePair("text_only_place", str));
        }
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = f12925a.toString();
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = editPhotoLocationParams.f12926a;
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m20305a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(apiResponse.c().F());
    }
}

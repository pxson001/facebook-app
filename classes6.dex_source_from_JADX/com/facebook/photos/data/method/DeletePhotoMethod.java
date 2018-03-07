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

/* compiled from: ignored_suggested_friend */
public class DeletePhotoMethod implements ApiMethod<DeletePhotoParams, DeletePhotoResponse> {
    private static final Class<?> f12914a = DeletePhotoMethod.class;

    public static DeletePhotoMethod m20291a(InjectorLike injectorLike) {
        return new DeletePhotoMethod();
    }

    public final ApiRequest m20292a(Object obj) {
        DeletePhotoParams deletePhotoParams = (DeletePhotoParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = f12914a.toString();
        newBuilder = newBuilder;
        newBuilder.c = "DELETE";
        newBuilder = newBuilder;
        newBuilder.d = deletePhotoParams.f12915a;
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m20293a(Object obj, ApiResponse apiResponse) {
        return new DeletePhotoResponse(Boolean.valueOf(apiResponse.c().F()).booleanValue());
    }
}

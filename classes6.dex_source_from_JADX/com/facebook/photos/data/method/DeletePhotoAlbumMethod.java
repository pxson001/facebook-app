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

/* compiled from: imageSource */
public class DeletePhotoAlbumMethod implements ApiMethod<DeletePhotoAlbumParams, DeletePhotoAlbumResponse> {
    private static final Class<?> f12911a = DeletePhotoAlbumMethod.class;

    public static DeletePhotoAlbumMethod m20288a(InjectorLike injectorLike) {
        return new DeletePhotoAlbumMethod();
    }

    public final ApiRequest m20289a(Object obj) {
        DeletePhotoAlbumParams deletePhotoAlbumParams = (DeletePhotoAlbumParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = f12911a.toString();
        newBuilder = newBuilder;
        newBuilder.c = "DELETE";
        newBuilder = newBuilder;
        newBuilder.d = String.valueOf(deletePhotoAlbumParams.f12912a);
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m20290a(Object obj, ApiResponse apiResponse) {
        return new DeletePhotoAlbumResponse(Boolean.valueOf(apiResponse.c().F()).booleanValue());
    }
}

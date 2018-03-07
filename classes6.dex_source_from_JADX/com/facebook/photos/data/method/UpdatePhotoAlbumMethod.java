package com.facebook.photos.data.method;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.method.UpdatePhotoAlbumParams.ConversionType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: http_5xx */
public class UpdatePhotoAlbumMethod implements ApiMethod<UpdatePhotoAlbumParams, Boolean> {
    public static UpdatePhotoAlbumMethod m20325a(InjectorLike injectorLike) {
        return new UpdatePhotoAlbumMethod();
    }

    public final ApiRequest m20327a(Object obj) {
        UpdatePhotoAlbumParams updatePhotoAlbumParams = (UpdatePhotoAlbumParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("aid", updatePhotoAlbumParams.f12957a));
        if (updatePhotoAlbumParams.f12958b != null) {
            a.add(new BasicNameValuePair("name", updatePhotoAlbumParams.f12958b));
        }
        if (updatePhotoAlbumParams.f12959c != null) {
            a.add(new BasicNameValuePair("place", m20326a(updatePhotoAlbumParams.f12959c)));
        }
        if (updatePhotoAlbumParams.f12960d != null) {
            a.add(new BasicNameValuePair("description", m20326a(updatePhotoAlbumParams.f12960d)));
        }
        if (updatePhotoAlbumParams.f12961e != null) {
            a.add(new BasicNameValuePair("audience", updatePhotoAlbumParams.f12961e));
        }
        if (!(updatePhotoAlbumParams.f12963g == null || updatePhotoAlbumParams.f12962f == ConversionType.NORMAL_TO_SHARED)) {
            a.add(new BasicNameValuePair("allow_contributors", Boolean.toString(updatePhotoAlbumParams.f12963g.booleanValue())));
        }
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "editPhotoAlbum";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = String.valueOf(updatePhotoAlbumParams.f12957a);
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m20328a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(true);
    }

    private static String m20326a(String str) {
        return str.length() == 0 ? " " : str;
    }
}

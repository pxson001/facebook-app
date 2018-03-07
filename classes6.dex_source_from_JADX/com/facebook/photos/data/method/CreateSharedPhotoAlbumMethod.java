package com.facebook.photos.data.method;

import com.facebook.common.util.JSONUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* compiled from: imageUrl */
public class CreateSharedPhotoAlbumMethod implements ApiMethod<CreateSharedPhotoAlbumParams, String> {
    public static CreateSharedPhotoAlbumMethod m20282a(InjectorLike injectorLike) {
        return new CreateSharedPhotoAlbumMethod();
    }

    public final ApiRequest m20283a(Object obj) {
        CreateSharedPhotoAlbumParams createSharedPhotoAlbumParams = (CreateSharedPhotoAlbumParams) obj;
        boolean z = true;
        List a = Lists.a();
        JSONObject jSONObject = new JSONObject();
        a.add(new BasicNameValuePair("format", "json"));
        Preconditions.checkArgument(createSharedPhotoAlbumParams.f12904b != null);
        a.add(new BasicNameValuePair("existing_album_id", createSharedPhotoAlbumParams.f12904b));
        if (createSharedPhotoAlbumParams.f12903a == null) {
            z = false;
        }
        Preconditions.checkArgument(z);
        a.add(new BasicNameValuePair("privacy", createSharedPhotoAlbumParams.f12903a));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "create_shared_album";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "me/sharedalbums";
        newBuilder = newBuilder;
        newBuilder.g = a;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    public final Object m20284a(Object obj, ApiResponse apiResponse) {
        return JSONUtil.b(apiResponse.c().b("id"));
    }
}

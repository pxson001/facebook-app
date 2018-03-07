package com.facebook.photos.data.method;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: image_file_bytes */
public class CreatePagePhotoAlbumMethod implements ApiMethod<CreatePagePhotoAlbumParams, String> {
    public static CreatePagePhotoAlbumMethod m20276a(InjectorLike injectorLike) {
        return new CreatePagePhotoAlbumMethod();
    }

    public final ApiRequest m20277a(Object obj) {
        CreatePagePhotoAlbumParams createPagePhotoAlbumParams = (CreatePagePhotoAlbumParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("name", createPagePhotoAlbumParams.f12893b));
        if (createPagePhotoAlbumParams.f12894c != null) {
            a.add(new BasicNameValuePair("description", createPagePhotoAlbumParams.f12894c));
        }
        if (createPagePhotoAlbumParams.f12895d != null) {
            a.add(new BasicNameValuePair("location", createPagePhotoAlbumParams.f12895d));
        }
        return new ApiRequest("createPagePhotoAlbum", "POST", StringFormatUtil.a("/%d/albums", new Object[]{Long.valueOf(createPagePhotoAlbumParams.f12892a)}), a, ApiResponseType.JSON);
    }

    public final Object m20278a(Object obj, ApiResponse apiResponse) {
        return apiResponse.c().b("id").B();
    }
}

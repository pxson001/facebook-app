package com.facebook.photos.data.method;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: image_ids */
public class AddPhotoTagMethod implements ApiMethod<AddPhotoTagParams, Boolean> {
    private static final Class<?> f12886a = AddPhotoTagMethod.class;

    public static AddPhotoTagMethod m20268a(InjectorLike injectorLike) {
        return new AddPhotoTagMethod();
    }

    public final ApiRequest m20269a(Object obj) {
        AddPhotoTagParams addPhotoTagParams = (AddPhotoTagParams) obj;
        Preconditions.checkNotNull(addPhotoTagParams);
        Preconditions.checkNotNull(addPhotoTagParams.f12887a);
        f12886a.toString();
        String str = addPhotoTagParams.f12888b;
        str = addPhotoTagParams.f12891e;
        str = addPhotoTagParams.f12887a;
        addPhotoTagParams.m20275d();
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = f12886a.toString();
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        String str2 = addPhotoTagParams.f12887a;
        newBuilder.d = StringFormatUtil.a("%s/tags", new Object[]{str2});
        newBuilder = newBuilder;
        newBuilder.g = ImmutableList.of(new BasicNameValuePair("tags", addPhotoTagParams.m20275d()));
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    public final Object m20270a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(apiResponse.c().F());
    }
}

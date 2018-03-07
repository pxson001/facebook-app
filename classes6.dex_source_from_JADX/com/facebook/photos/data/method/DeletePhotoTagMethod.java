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

/* compiled from: ignore */
public class DeletePhotoTagMethod implements ApiMethod<DeletePhotoTagParams, Boolean> {
    private static final Class<?> f12918a = DeletePhotoTagMethod.class;

    public static DeletePhotoTagMethod m20294a(InjectorLike injectorLike) {
        return new DeletePhotoTagMethod();
    }

    public final ApiRequest m20295a(Object obj) {
        DeletePhotoTagParams deletePhotoTagParams = (DeletePhotoTagParams) obj;
        Preconditions.checkNotNull(deletePhotoTagParams);
        Preconditions.checkNotNull(deletePhotoTagParams.f12919a);
        f12918a.toString();
        String str = deletePhotoTagParams.f12920b;
        str = deletePhotoTagParams.f12921c;
        str = deletePhotoTagParams.f12919a;
        deletePhotoTagParams.m20299d();
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = f12918a.toString();
        newBuilder = newBuilder;
        newBuilder.c = "DELETE";
        newBuilder = newBuilder;
        String str2 = deletePhotoTagParams.f12919a;
        newBuilder.d = StringFormatUtil.a("%s/tags", new Object[]{str2});
        newBuilder = newBuilder;
        newBuilder.g = ImmutableList.of(new BasicNameValuePair("tags", deletePhotoTagParams.m20299d()));
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    public final Object m20296a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(apiResponse.c().F());
    }
}

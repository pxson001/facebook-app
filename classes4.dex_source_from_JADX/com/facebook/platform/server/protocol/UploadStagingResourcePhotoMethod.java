package com.facebook.platform.server.protocol;

import android.graphics.Bitmap.CompressFormat;
import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.http.protocol.ByteArrayBody;
import com.facebook.tigon.iface.TigonRequest;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;

/* compiled from: function */
public class UploadStagingResourcePhotoMethod implements ApiMethod<Params, String> {
    private static final Class<?> f11324a = UploadStagingResourcePhotoMethod.class;

    public final ApiRequest m11757a(Object obj) {
        Params params = (Params) obj;
        Preconditions.checkNotNull(params);
        Preconditions.checkNotNull(params.b);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        params.b.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
        FormBodyPart formBodyPart = new FormBodyPart(params.a, new ByteArrayBody(byteArrayOutputStream.toByteArray(), "image/jpeg", params.a));
        List a = Lists.a();
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "uploadStagingResourcePhoto";
        newBuilder = newBuilder;
        newBuilder.c = TigonRequest.POST;
        newBuilder = newBuilder;
        newBuilder.d = "me/staging_resources";
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        newBuilder = newBuilder;
        newBuilder.l = ImmutableList.of(formBodyPart);
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.g = a;
        return apiRequestBuilder.C();
    }

    public final Object m11758a(Object obj, ApiResponse apiResponse) {
        return apiResponse.c().b("uri").B();
    }
}

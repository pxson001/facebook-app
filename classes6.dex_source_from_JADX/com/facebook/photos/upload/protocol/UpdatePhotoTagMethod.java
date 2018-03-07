package com.facebook.photos.upload.protocol;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.base.tagging.compat.FacebookPhotoTagBase;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: getAttributions */
public class UpdatePhotoTagMethod implements ApiMethod<UploadPhotoParams, Boolean> {
    public static UpdatePhotoTagMethod m21747a(InjectorLike injectorLike) {
        return new UpdatePhotoTagMethod();
    }

    public final ApiRequest m21748a(Object obj) {
        UploadPhotoParams uploadPhotoParams = (UploadPhotoParams) obj;
        ImmutableList immutableList = uploadPhotoParams.f14120n;
        boolean z = (immutableList == null || immutableList.isEmpty() || Long.valueOf(uploadPhotoParams.f14084B).longValue() == 0) ? false : true;
        Preconditions.checkArgument(z);
        Builder builder = ImmutableList.builder();
        builder.c(new BasicNameValuePair("tags", FacebookPhotoTagBase.m20177a(immutableList)));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "photoUpdate";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = StringFormatUtil.a("%s/tags", new Object[]{Long.toString(r2.longValue())});
        newBuilder = newBuilder;
        newBuilder.g = builder.b();
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m21749a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        boolean z = apiResponse.b == 200 && (apiResponse.c instanceof BooleanNode) && ((BooleanNode) apiResponse.c).F();
        return Boolean.valueOf(z);
    }
}

package com.facebook.groups.create.protocol;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import org.apache.http.HttpException;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: payments_payment_method_selected */
public class SetAsCoverPhotoMethod implements ApiMethod<SetAsCoverPhotoParams, Boolean> {
    public final ApiRequest m7120a(Object obj) {
        SetAsCoverPhotoParams setAsCoverPhotoParams = (SetAsCoverPhotoParams) obj;
        Builder builder = ImmutableList.builder();
        builder.c(new BasicNameValuePair("cover", setAsCoverPhotoParams.f6842b));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "group_set_as_cover";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = StringFormatUtil.a("/%s", new Object[]{setAsCoverPhotoParams.f6841a});
        newBuilder = newBuilder;
        newBuilder.g = builder.b();
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m7121a(Object obj, ApiResponse apiResponse) {
        if (apiResponse.b == 200) {
            return Boolean.valueOf(apiResponse.c().F());
        }
        throw new HttpException("Group Set As Cover Photo Request failed," + apiResponse.toString());
    }
}

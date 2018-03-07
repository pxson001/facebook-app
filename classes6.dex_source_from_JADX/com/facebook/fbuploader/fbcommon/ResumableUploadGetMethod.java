package com.facebook.fbuploader.fbcommon;

import com.facebook.http.common.RequestIdempotency;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.ImmutableList;

/* compiled from: neko_di_dialog */
public class ResumableUploadGetMethod implements ApiMethod<ResumableUploadGetParams, String> {
    public final ApiRequest m15789a(Object obj) {
        ResumableUploadGetParams resumableUploadGetParams = (ResumableUploadGetParams) obj;
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "Resumable-Upload-Get";
        newBuilder = newBuilder;
        newBuilder.c = "GET";
        newBuilder = newBuilder;
        newBuilder.g = ImmutableList.builder().b();
        newBuilder = newBuilder;
        newBuilder.o = true;
        newBuilder = newBuilder;
        newBuilder.d = resumableUploadGetParams.f10103a;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.STRING;
        return newBuilder.a(RequestIdempotency.RETRY_SAFE).C();
    }

    public final Object m15790a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return apiResponse.b();
    }
}

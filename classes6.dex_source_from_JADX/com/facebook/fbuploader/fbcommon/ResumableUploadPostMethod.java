package com.facebook.fbuploader.fbcommon;

import com.facebook.http.common.RequestIdempotency;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequest.PostEntityType;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Map.Entry;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: neko_di_app_details_screenshot_interaction */
public class ResumableUploadPostMethod implements ApiMethod<ResumableUploadPostParams, String> {
    public final ApiRequest m15791a(Object obj) {
        ResumableUploadPostParams resumableUploadPostParams = (ResumableUploadPostParams) obj;
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "Resumable-Upload-Post";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        Builder builder = ImmutableList.builder();
        for (Entry entry : resumableUploadPostParams.f10108e.entrySet()) {
            builder.c(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
        }
        newBuilder.g = builder.b();
        newBuilder = newBuilder;
        newBuilder.o = true;
        newBuilder = newBuilder;
        newBuilder.w = PostEntityType.FILE_PART_ENTITY;
        newBuilder = newBuilder.a(resumableUploadPostParams.f10105b, resumableUploadPostParams.f10106c, resumableUploadPostParams.f10107d);
        newBuilder.d = resumableUploadPostParams.f10104a;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.STRING;
        return newBuilder.a(RequestIdempotency.RETRY_SAFE).C();
    }

    public final Object m15792a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return apiResponse.b();
    }
}

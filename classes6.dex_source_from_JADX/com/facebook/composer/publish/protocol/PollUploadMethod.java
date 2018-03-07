package com.facebook.composer.publish.protocol;

import com.facebook.composer.publish.common.PollUploadParams;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: photo_preuploading_batch */
public class PollUploadMethod implements ApiMethod<PollUploadParams, String> {
    public final ApiRequest m11646a(Object obj) {
        PollUploadParams pollUploadParams = (PollUploadParams) obj;
        Builder builder = ImmutableList.builder();
        builder.c(new BasicNameValuePair("id", pollUploadParams.a));
        builder.c(new BasicNameValuePair("question", pollUploadParams.b));
        builder.c(new BasicNameValuePair("allow_new_options", Boolean.toString(pollUploadParams.d)));
        builder.c(new BasicNameValuePair("choose_multiple_options", Boolean.toString(pollUploadParams.e)));
        builder.c(new BasicNameValuePair("published", Boolean.toString(pollUploadParams.f)));
        ImmutableList copyOf = ImmutableList.copyOf(pollUploadParams.c);
        int size = copyOf.size();
        for (int i = 0; i < size; i++) {
            builder.c(new BasicNameValuePair("options[]", (String) copyOf.get(i)));
        }
        String str = pollUploadParams.a + "/questions";
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "uploadPoll";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = str;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.g = builder.b();
        return apiRequestBuilder.C();
    }

    public final Object m11647a(Object obj, ApiResponse apiResponse) {
        if (apiResponse == null || apiResponse.c() == null) {
            return null;
        }
        return apiResponse.c().b("id").B();
    }
}

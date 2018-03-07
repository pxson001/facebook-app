package com.facebook.messaging.service.methods;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.service.model.IgnoreMessageRequestsParams;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: customthreads/ */
public class IgnoreMessageRequestsMethod implements ApiMethod<IgnoreMessageRequestsParams, Void> {
    public final ApiRequest m16959a(Object obj) {
        IgnoreMessageRequestsParams ignoreMessageRequestsParams = (IgnoreMessageRequestsParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("thread_ids", ignoreMessageRequestsParams.f17195b.toString()));
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        apiRequestBuilder.b = "ignoreMessageRequests";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.c = "POST";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.d = "/me/message_ignore_requests";
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        apiRequestBuilder2.g = arrayList;
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.k = ApiResponseType.STRING;
        return apiRequestBuilder2.C();
    }

    public final Object m16960a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}

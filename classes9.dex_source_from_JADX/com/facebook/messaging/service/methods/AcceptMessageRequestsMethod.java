package com.facebook.messaging.service.methods;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.service.model.AcceptMessageRequestsParams;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: decline_payment_dialog_fragment */
public class AcceptMessageRequestsMethod implements ApiMethod<AcceptMessageRequestsParams, Void> {
    public final ApiRequest m16848a(Object obj) {
        AcceptMessageRequestsParams acceptMessageRequestsParams = (AcceptMessageRequestsParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("thread_ids", acceptMessageRequestsParams.f17004b.toString()));
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        apiRequestBuilder.b = "acceptMessageRequests";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.c = "POST";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.d = "/me/message_accept_requests";
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        apiRequestBuilder2.g = arrayList;
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.k = ApiResponseType.STRING;
        return apiRequestBuilder2.C();
    }

    public final Object m16849a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}

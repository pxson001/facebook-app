package com.facebook.messaging.payment.protocol.request;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.service.model.request.CreatePaymentRequestParams;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: folder=? AND last_fetch_action_id != action_id */
public class CreatePaymentRequestMethod implements ApiMethod<CreatePaymentRequestParams, String> {
    public static CreatePaymentRequestMethod m15066a(InjectorLike injectorLike) {
        return new CreatePaymentRequestMethod();
    }

    public final ApiRequest m15067a(Object obj) {
        CreatePaymentRequestParams createPaymentRequestParams = (CreatePaymentRequestParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("amount", createPaymentRequestParams.f14707b));
        arrayList.add(new BasicNameValuePair("offline_threading_id", createPaymentRequestParams.f14708c));
        arrayList.add(new BasicNameValuePair("memo_text", createPaymentRequestParams.f14710e));
        arrayList.add(new BasicNameValuePair("group_thread_id", createPaymentRequestParams.f14711f));
        arrayList.add(new BasicNameValuePair("theme_id", createPaymentRequestParams.f14712g));
        arrayList.add(new BasicNameValuePair("platform_context_id", createPaymentRequestParams.f14713h));
        arrayList.add(new BasicNameValuePair("format", "json"));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "create_payment_request";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = StringFormatUtil.formatStrLocaleSafe("/%s/p2p_payment_requests", createPaymentRequestParams.f14709d);
        newBuilder = newBuilder;
        newBuilder.g = arrayList;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m15068a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return apiResponse.c().b("id").B();
    }
}

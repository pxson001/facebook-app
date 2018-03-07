package com.facebook.messaging.payment.protocol.transactions;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.service.model.transactions.DeclinePaymentParams;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: flv */
public class DeclinePaymentMethod implements ApiMethod<DeclinePaymentParams, Boolean> {
    public static DeclinePaymentMethod m15104a(InjectorLike injectorLike) {
        return new DeclinePaymentMethod();
    }

    public final ApiRequest m15105a(Object obj) {
        DeclinePaymentParams declinePaymentParams = (DeclinePaymentParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("transfer_id", declinePaymentParams.f14736c));
        a.add(new BasicNameValuePair("format", "json"));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "decline_payment";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = StringFormatUtil.formatStrLocaleSafe("%s/p2p_declined_transfers", declinePaymentParams.f14735b);
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m15106a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(apiResponse.c().F());
    }
}

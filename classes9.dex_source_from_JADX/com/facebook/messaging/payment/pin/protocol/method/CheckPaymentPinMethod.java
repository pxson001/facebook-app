package com.facebook.messaging.payment.pin.protocol.method;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.payment.pin.model.CheckPaymentPinParams;
import com.facebook.messaging.payment.pin.model.PaymentPin;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: growthUserSetContactInfoParamsKey */
public class CheckPaymentPinMethod implements ApiMethod<CheckPaymentPinParams, PaymentPin> {
    public final ApiRequest m14299a(Object obj) {
        CheckPaymentPinParams checkPaymentPinParams = (CheckPaymentPinParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("pin", checkPaymentPinParams.f13703b));
        a.add(new BasicNameValuePair("format", "json"));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "check_payment_pins";
        newBuilder = newBuilder;
        newBuilder.c = "GET";
        newBuilder = newBuilder;
        newBuilder.d = StringFormatUtil.formatStrLocaleSafe("/%d", Long.valueOf(checkPaymentPinParams.f13704c));
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSONPARSER;
        return apiRequestBuilder.C();
    }

    public final Object m14300a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return (PaymentPin) apiResponse.d().a(PaymentPin.class);
    }
}

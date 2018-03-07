package com.facebook.messaging.payment.pin.protocol.method;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.payment.pin.model.DeletePaymentPinParams;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: growthSetNativeNameParams */
public class DeletePaymentPinMethod implements ApiMethod<DeletePaymentPinParams, Boolean> {
    public final ApiRequest m14301a(Object obj) {
        DeletePaymentPinParams deletePaymentPinParams = (DeletePaymentPinParams) obj;
        List a = Lists.a();
        if (deletePaymentPinParams.f13708d) {
            a.add(new BasicNameValuePair("pin", deletePaymentPinParams.f13706b));
        } else {
            a.add(new BasicNameValuePair("password", deletePaymentPinParams.f13706b));
        }
        a.add(new BasicNameValuePair("format", "json"));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "delete_payment_pins";
        newBuilder = newBuilder;
        newBuilder.c = "DELETE";
        newBuilder = newBuilder;
        newBuilder.d = StringFormatUtil.formatStrLocaleSafe("%d", Long.valueOf(deletePaymentPinParams.f13707c));
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m14302a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(apiResponse.c().F());
    }
}

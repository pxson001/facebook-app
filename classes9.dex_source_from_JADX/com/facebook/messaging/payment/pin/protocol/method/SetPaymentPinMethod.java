package com.facebook.messaging.payment.pin.protocol.method;

import com.facebook.common.identifiers.UniqueIdGenerator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.payment.pin.model.PaymentPin;
import com.facebook.messaging.payment.pin.model.SetPaymentPinParams;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: groups_you_should_create */
public class SetPaymentPinMethod implements ApiMethod<SetPaymentPinParams, PaymentPin> {
    private final UniqueIdGenerator f13753a;

    public final ApiRequest m14317a(Object obj) {
        SetPaymentPinParams setPaymentPinParams = (SetPaymentPinParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("pin", setPaymentPinParams.f13714b));
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("idempotence_token", StringFormatUtil.formatStrLocaleSafe("%d_%s", Long.valueOf(this.f13753a.a()), "p2p_payment_pins")));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "p2p_payment_pins";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = StringFormatUtil.formatStrLocaleSafe("/%d/%s", Long.valueOf(setPaymentPinParams.f13715c), "p2p_payment_pins");
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSONPARSER;
        return apiRequestBuilder.C();
    }

    @Inject
    public SetPaymentPinMethod(UniqueIdGenerator uniqueIdGenerator) {
        this.f13753a = uniqueIdGenerator;
    }

    public final Object m14318a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return (PaymentPin) apiResponse.d().a(PaymentPin.class);
    }
}

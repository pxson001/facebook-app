package com.facebook.messaging.payment.protocol.cards;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.service.model.cards.ValidatePaymentCardBinParams;
import com.facebook.messaging.payment.service.model.cards.ValidatePaymentCardBinResult;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: for_this_device */
public class ValidatePaymentCardBinMethod implements ApiMethod<ValidatePaymentCardBinParams, ValidatePaymentCardBinResult> {
    private static final Class<?> f14585a = ValidatePaymentCardBinMethod.class;

    public static ValidatePaymentCardBinMethod m15033a(InjectorLike injectorLike) {
        return new ValidatePaymentCardBinMethod();
    }

    public final ApiRequest m15034a(Object obj) {
        ValidatePaymentCardBinParams validatePaymentCardBinParams = (ValidatePaymentCardBinParams) obj;
        List a = Lists.a();
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "validate_payment_card_bin";
        newBuilder = newBuilder;
        newBuilder.c = "GET";
        newBuilder = newBuilder;
        newBuilder.d = StringFormatUtil.formatStrLocaleSafe("/P2P_BIN_%s", validatePaymentCardBinParams.f14658b);
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSONPARSER;
        return apiRequestBuilder.C();
    }

    public final Object m15035a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return (ValidatePaymentCardBinResult) apiResponse.d().a(ValidatePaymentCardBinResult.class);
    }
}

package com.facebook.adspayments.protocol;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.Quartet;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.common.PaymentNetworkOperationHelper;
import com.facebook.payments.common.UnrestrictedResultPaymentsNetworkOperation;
import com.facebook.payments.model.CurrencyAmount;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;

/* compiled from: URI is not canonical. */
public class PrepayFundMethod extends UnrestrictedResultPaymentsNetworkOperation<Quartet<String, PaymentMethod, CurrencyAmount, String>, String> {
    public static PrepayFundMethod m25745b(InjectorLike injectorLike) {
        return new PrepayFundMethod(PaymentNetworkOperationHelper.a(injectorLike));
    }

    public final ApiRequest m25746a(Object obj) {
        Quartet quartet = (Quartet) obj;
        CurrencyAmount currencyAmount = (CurrencyAmount) quartet.b;
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.d = StringFormatUtil.formatStrLocaleSafe("/act_%s/prepay_fund", quartet.first);
        newBuilder = newBuilder;
        newBuilder.b = m25748a();
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder.a(ImmutableMap.of("credential_id", ((PaymentMethod) quartet.second).a(), "currency", currencyAmount.b, "amount", currencyAmount.c.toPlainString()), ImmutableBiMap.b("cached_csc_token", Optional.fromNullable(quartet.a)));
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    @Inject
    public PrepayFundMethod(PaymentNetworkOperationHelper paymentNetworkOperationHelper) {
        super(paymentNetworkOperationHelper, String.class);
    }

    @VisibleForTesting
    private static CurrencyAmount m25744a(CurrencyAmount currencyAmount) {
        return currencyAmount;
    }

    public final Object m25747a(Object obj, ApiResponse apiResponse) {
        return UnrestrictedResultPaymentsNetworkOperation.a(apiResponse, "payment_id");
    }

    protected final String m25748a() {
        return "prepay_fund";
    }
}

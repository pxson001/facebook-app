package com.facebook.adspayments.protocol;

import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.common.PaymentNetworkOperationHelper;
import com.facebook.payments.common.VoidResultPaymentsNetworkOperation;
import javax.inject.Inject;

/* compiled from: foreground_battery_drain */
public class EditPaymentCardMethod extends VoidResultPaymentsNetworkOperation<EditPaymentCardParams> {
    public final ApiRequest m25710a(Object obj) {
        EditPaymentCardParams editPaymentCardParams = (EditPaymentCardParams) obj;
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "edit_credit_card";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = editPaymentCardParams.f23696a;
        newBuilder = newBuilder;
        newBuilder.g = editPaymentCardParams.m25703f();
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.STRING;
        return newBuilder.C();
    }

    public static EditPaymentCardMethod m25709b(InjectorLike injectorLike) {
        return new EditPaymentCardMethod(PaymentNetworkOperationHelper.a(injectorLike));
    }

    @Inject
    public EditPaymentCardMethod(PaymentNetworkOperationHelper paymentNetworkOperationHelper) {
        super(paymentNetworkOperationHelper);
    }

    protected final String m25711a() {
        return "edit_payments_card";
    }
}

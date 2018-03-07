package com.facebook.payments.paymentmethods.cardform.protocol.method;

import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.common.PaymentNetworkOperationHelper;
import com.facebook.payments.common.VoidResultPaymentsNetworkOperation;
import com.facebook.payments.paymentmethods.cardform.protocol.model.EditCreditCardParams;
import javax.inject.Inject;

/* compiled from: swipe-up */
public class EditCreditCardMethod extends VoidResultPaymentsNetworkOperation<EditCreditCardParams> {
    public static EditCreditCardMethod m2114b(InjectorLike injectorLike) {
        return new EditCreditCardMethod(PaymentNetworkOperationHelper.m1921a(injectorLike));
    }

    public final ApiRequest m2115a(Object obj) {
        EditCreditCardParams editCreditCardParams = (EditCreditCardParams) obj;
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "edit_credit_card";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.g = editCreditCardParams.mo88a();
        newBuilder = newBuilder;
        newBuilder.d = editCreditCardParams.f1927b;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    @Inject
    public EditCreditCardMethod(PaymentNetworkOperationHelper paymentNetworkOperationHelper) {
        super(paymentNetworkOperationHelper);
    }

    protected final String mo87a() {
        return "Edit_credit_card";
    }
}

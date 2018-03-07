package com.facebook.payments.paymentmethods.picker.protocol;

import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.common.PaymentNetworkOperationHandler;
import com.facebook.payments.common.UnrestrictedResultPaymentsNetworkOperation;
import javax.inject.Inject;

/* compiled from: big5 */
public class PickerWebServiceHandler extends PaymentNetworkOperationHandler {
    public static PickerWebServiceHandler m18864b(InjectorLike injectorLike) {
        return new PickerWebServiceHandler(ApiMethodRunnerImpl.a(injectorLike), GetPaymentMethodsInfoMethod.m18858b(injectorLike));
    }

    @Inject
    public PickerWebServiceHandler(ApiMethodRunnerImpl apiMethodRunnerImpl, GetPaymentMethodsInfoMethod getPaymentMethodsInfoMethod) {
        super(apiMethodRunnerImpl, new UnrestrictedResultPaymentsNetworkOperation[]{getPaymentMethodsInfoMethod});
    }
}

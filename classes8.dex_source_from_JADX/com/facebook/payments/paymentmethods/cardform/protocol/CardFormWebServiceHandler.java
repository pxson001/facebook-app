package com.facebook.payments.paymentmethods.cardform.protocol;

import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.common.PaymentNetworkOperationHandler;
import com.facebook.payments.paymentmethods.cardform.protocol.method.AddCreditCardMethod;
import com.facebook.payments.paymentmethods.cardform.protocol.method.EditCreditCardMethod;
import javax.inject.Inject;

/* compiled from: swipe_percent */
public class CardFormWebServiceHandler extends PaymentNetworkOperationHandler {
    public static CardFormWebServiceHandler m2110b(InjectorLike injectorLike) {
        return new CardFormWebServiceHandler(ApiMethodRunnerImpl.a(injectorLike), EditCreditCardMethod.m2114b(injectorLike), AddCreditCardMethod.m2111b(injectorLike));
    }

    @Inject
    public CardFormWebServiceHandler(ApiMethodRunnerImpl apiMethodRunnerImpl, EditCreditCardMethod editCreditCardMethod, AddCreditCardMethod addCreditCardMethod) {
        super(apiMethodRunnerImpl, addCreditCardMethod, editCreditCardMethod);
    }
}

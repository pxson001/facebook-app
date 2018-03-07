package com.facebook.messaging.payment.value.input.checkout;

import com.facebook.inject.Lazy;
import com.facebook.payments.checkout.CheckoutStyle;
import com.facebook.payments.checkout.CheckoutStyleAssociation;
import com.facebook.payments.checkout.SimpleCheckoutDataLoader;
import com.facebook.payments.checkout.SimpleCheckoutDataMutator;
import com.facebook.payments.checkout.SimpleCheckoutOnActivityResultHandler;
import com.facebook.payments.checkout.statemachine.SimpleCheckoutStateMachineHandler;
import com.facebook.payments.checkout.statemachine.SimpleCheckoutStateMachineOrganizer;
import javax.inject.Inject;

/* compiled from: ephemeral_confirm_change */
public class MCheckoutStyleAssociation extends CheckoutStyleAssociation<SimpleCheckoutDataLoader, SimpleCheckoutDataMutator, SimpleCheckoutOnActivityResultHandler, MCheckoutSubScreenParamsGenerator, MCheckoutRowsGenerator, MCheckoutSender, SimpleCheckoutStateMachineOrganizer, SimpleCheckoutStateMachineHandler, MCheckoutStyleRenderer, MCheckoutRowViewHolderFactory> {
    @Inject
    public MCheckoutStyleAssociation(Lazy<SimpleCheckoutDataLoader> lazy, Lazy<SimpleCheckoutDataMutator> lazy2, Lazy<SimpleCheckoutOnActivityResultHandler> lazy3, Lazy<MCheckoutSubScreenParamsGenerator> lazy4, Lazy<MCheckoutRowsGenerator> lazy5, Lazy<MCheckoutSender> lazy6, Lazy<SimpleCheckoutStateMachineOrganizer> lazy7, Lazy<SimpleCheckoutStateMachineHandler> lazy8, Lazy<MCheckoutStyleRenderer> lazy9, Lazy<MCheckoutRowViewHolderFactory> lazy10) {
        super(CheckoutStyle.M, lazy, lazy2, lazy3, lazy4, lazy5, lazy6, lazy7, lazy8, lazy9, lazy10);
    }
}

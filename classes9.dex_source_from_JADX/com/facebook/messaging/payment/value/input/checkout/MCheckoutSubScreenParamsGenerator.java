package com.facebook.messaging.payment.value.input.checkout;

import android.content.res.Resources;
import com.facebook.payments.checkout.recyclerview.SimpleCheckoutSubScreenParamsGenerator;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyle;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: entity_name */
public class MCheckoutSubScreenParamsGenerator extends SimpleCheckoutSubScreenParamsGenerator {
    @Inject
    public MCheckoutSubScreenParamsGenerator(Resources resources) {
        super(resources);
    }

    protected final PickerScreenStyle mo633b() {
        return PickerScreenStyle.MESSENGER_COMMERCE;
    }

    protected final ImmutableList<NewPaymentOptionType> mo634d() {
        return ImmutableList.of(NewPaymentOptionType.NEW_PAYPAL);
    }
}

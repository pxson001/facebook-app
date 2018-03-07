package com.facebook.messaging.payment.value.input.checkout;

import android.content.res.Resources;
import com.facebook.payments.checkout.recyclerview.SimpleCheckoutSubScreenParamsGenerator;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyle;
import com.facebook.payments.shipping.model.ShippingStyle;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: encrypted_blob */
public class MessengerCommerceCheckoutSubScreenParamsGenerator extends SimpleCheckoutSubScreenParamsGenerator {
    @Inject
    public MessengerCommerceCheckoutSubScreenParamsGenerator(Resources resources) {
        super(resources);
    }

    protected final ShippingStyle mo644a() {
        return ShippingStyle.MESSENGER_COMMERCE;
    }

    protected final PickerScreenStyle mo633b() {
        return PickerScreenStyle.MESSENGER_COMMERCE;
    }

    protected final PickerScreenStyle mo645c() {
        return PickerScreenStyle.MESSENGER_COMMERCE_SHIPPING_OPTION_PICKER;
    }

    protected final ImmutableList<NewPaymentOptionType> mo634d() {
        return ImmutableList.of(NewPaymentOptionType.NEW_PAYPAL);
    }
}

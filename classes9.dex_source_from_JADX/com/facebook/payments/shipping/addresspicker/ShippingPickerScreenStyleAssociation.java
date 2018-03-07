package com.facebook.payments.shipping.addresspicker;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsPickerScreenSubScreenParamsGenerator;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyle;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyleAssociation;
import javax.inject.Inject;

/* compiled from: badgeCount */
public class ShippingPickerScreenStyleAssociation extends PickerScreenStyleAssociation<ShippingPickerScreenStyleRenderer, ShippingPickerScreenDataFetcher, ShippingSectionOrganizer, ShippingRowItemsGenerator, ShippingPickerScreenOnActivityResultHandler, ShippingPickerScreenDataMutator, PaymentMethodsPickerScreenSubScreenParamsGenerator, ShippingRowItemViewFactory> {
    public static ShippingPickerScreenStyleAssociation m18910b(InjectorLike injectorLike) {
        return new ShippingPickerScreenStyleAssociation(IdBasedLazy.a(injectorLike, 9207), IdBasedLazy.a(injectorLike, 9203), IdBasedLazy.a(injectorLike, 9210), IdBasedLazy.a(injectorLike, 9209), IdBasedLazy.a(injectorLike, 9205), IdBasedLazy.a(injectorLike, 9204), IdBasedLazy.a(injectorLike, 9176), IdBasedLazy.a(injectorLike, 9208));
    }

    @Inject
    public ShippingPickerScreenStyleAssociation(Lazy<ShippingPickerScreenStyleRenderer> lazy, Lazy<ShippingPickerScreenDataFetcher> lazy2, Lazy<ShippingSectionOrganizer> lazy3, Lazy<ShippingRowItemsGenerator> lazy4, Lazy<ShippingPickerScreenOnActivityResultHandler> lazy5, Lazy<ShippingPickerScreenDataMutator> lazy6, Lazy<PaymentMethodsPickerScreenSubScreenParamsGenerator> lazy7, Lazy<ShippingRowItemViewFactory> lazy8) {
        super(PickerScreenStyle.SIMPLE_SHIPPING_ADDRESS, lazy, lazy2, lazy3, lazy4, lazy5, lazy6, lazy7, lazy8);
    }
}

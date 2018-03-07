package com.facebook.payments.shipping.optionpicker;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsPickerScreenSubScreenParamsGenerator;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyle;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyleAssociation;
import javax.inject.Inject;

/* compiled from: backstage_id */
public class ShippingOptionPickerScreenStyleAssociation extends PickerScreenStyleAssociation<ShippingOptionPickerScreenStyleRenderer, ShippingOptionPickerScreenDataFetcher, ShippingOptionSectionOrganizer, ShippingOptionsRowItemsGenerator, ShippingOptionPickerScreenOnActivityResultHandler, ShippingOptionsPickerScreenDataMutator, PaymentMethodsPickerScreenSubScreenParamsGenerator, ShippingOptionRowItemViewFactory> {
    public static ShippingOptionPickerScreenStyleAssociation m18995b(InjectorLike injectorLike) {
        return new ShippingOptionPickerScreenStyleAssociation(IdBasedLazy.a(injectorLike, 9219), IdBasedLazy.a(injectorLike, 9216), IdBasedLazy.a(injectorLike, 9221), IdBasedLazy.a(injectorLike, 9223), IdBasedLazy.a(injectorLike, 9217), IdBasedLazy.a(injectorLike, 9222), IdBasedLazy.a(injectorLike, 9176), IdBasedLazy.a(injectorLike, 9220));
    }

    @Inject
    public ShippingOptionPickerScreenStyleAssociation(Lazy<ShippingOptionPickerScreenStyleRenderer> lazy, Lazy<ShippingOptionPickerScreenDataFetcher> lazy2, Lazy<ShippingOptionSectionOrganizer> lazy3, Lazy<ShippingOptionsRowItemsGenerator> lazy4, Lazy<ShippingOptionPickerScreenOnActivityResultHandler> lazy5, Lazy<ShippingOptionsPickerScreenDataMutator> lazy6, Lazy<PaymentMethodsPickerScreenSubScreenParamsGenerator> lazy7, Lazy<ShippingOptionRowItemViewFactory> lazy8) {
        super(PickerScreenStyle.SIMPLE_SHIPPING_OPTION_PICKER, lazy, lazy2, lazy3, lazy4, lazy5, lazy6, lazy7, lazy8);
    }
}

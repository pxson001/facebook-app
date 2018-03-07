package com.facebook.messaging.payment.value.input.picker;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsPickerScreenSubScreenParamsGenerator;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyle;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyleAssociation;
import com.facebook.payments.shipping.optionpicker.ShippingOptionPickerScreenDataFetcher;
import com.facebook.payments.shipping.optionpicker.ShippingOptionPickerScreenOnActivityResultHandler;
import com.facebook.payments.shipping.optionpicker.ShippingOptionRowItemViewFactory;
import com.facebook.payments.shipping.optionpicker.ShippingOptionSectionOrganizer;
import com.facebook.payments.shipping.optionpicker.ShippingOptionsPickerScreenDataMutator;
import com.facebook.payments.shipping.optionpicker.ShippingOptionsRowItemsGenerator;
import javax.inject.Inject;

/* compiled from: edit_payment_card */
public class CommerceShippingOptionPickerScreenStyleAssociation extends PickerScreenStyleAssociation<CommercePickerScreenStyleRender, ShippingOptionPickerScreenDataFetcher, ShippingOptionSectionOrganizer, ShippingOptionsRowItemsGenerator, ShippingOptionPickerScreenOnActivityResultHandler, ShippingOptionsPickerScreenDataMutator, PaymentMethodsPickerScreenSubScreenParamsGenerator, ShippingOptionRowItemViewFactory> {
    public static CommerceShippingOptionPickerScreenStyleAssociation m16041b(InjectorLike injectorLike) {
        return new CommerceShippingOptionPickerScreenStyleAssociation(IdBasedLazy.a(injectorLike, 8268), IdBasedLazy.a(injectorLike, 9216), IdBasedLazy.a(injectorLike, 9221), IdBasedLazy.a(injectorLike, 9223), IdBasedLazy.a(injectorLike, 9217), IdBasedLazy.a(injectorLike, 9222), IdBasedLazy.a(injectorLike, 9176), IdBasedLazy.a(injectorLike, 9220));
    }

    @Inject
    public CommerceShippingOptionPickerScreenStyleAssociation(Lazy<CommercePickerScreenStyleRender> lazy, Lazy<ShippingOptionPickerScreenDataFetcher> lazy2, Lazy<ShippingOptionSectionOrganizer> lazy3, Lazy<ShippingOptionsRowItemsGenerator> lazy4, Lazy<ShippingOptionPickerScreenOnActivityResultHandler> lazy5, Lazy<ShippingOptionsPickerScreenDataMutator> lazy6, Lazy<PaymentMethodsPickerScreenSubScreenParamsGenerator> lazy7, Lazy<ShippingOptionRowItemViewFactory> lazy8) {
        super(PickerScreenStyle.MESSENGER_COMMERCE_SHIPPING_OPTION_PICKER, lazy, lazy2, lazy3, lazy4, lazy5, lazy6, lazy7, lazy8);
    }
}

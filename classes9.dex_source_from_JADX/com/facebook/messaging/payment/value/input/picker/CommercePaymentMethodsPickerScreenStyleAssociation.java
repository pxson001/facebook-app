package com.facebook.messaging.payment.value.input.picker;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsPickerScreenDataFetcher;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsPickerScreenDataMutator;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyle;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyleAssociation;
import javax.inject.Inject;

/* compiled from: eglChooseConfig failed  */
public class CommercePaymentMethodsPickerScreenStyleAssociation extends PickerScreenStyleAssociation<CommercePickerScreenStyleRender, PaymentMethodsPickerScreenDataFetcher, CommercePaymentMethodsSectionOrganizer, CommercePaymentMethodsPickerScreenRowItemsGenerator, CommercePaymentMethodsPickerScreenOnActivityResultHandler, PaymentMethodsPickerScreenDataMutator, CommercePaymentMethodsPickerScreenSubScreenParamsGenerator, CommercePaymentMethodsPickerScreenRowItemViewFactory> {
    public static CommercePaymentMethodsPickerScreenStyleAssociation m16034b(InjectorLike injectorLike) {
        return new CommercePaymentMethodsPickerScreenStyleAssociation(IdBasedLazy.a(injectorLike, 8268), IdBasedLazy.a(injectorLike, 9171), IdBasedLazy.a(injectorLike, 8267), IdBasedLazy.a(injectorLike, 8264), IdBasedLazy.a(injectorLike, 8262), IdBasedLazy.a(injectorLike, 9172), IdBasedLazy.a(injectorLike, 8266), IdBasedLazy.a(injectorLike, 8263));
    }

    @Inject
    public CommercePaymentMethodsPickerScreenStyleAssociation(Lazy<CommercePickerScreenStyleRender> lazy, Lazy<PaymentMethodsPickerScreenDataFetcher> lazy2, Lazy<CommercePaymentMethodsSectionOrganizer> lazy3, Lazy<CommercePaymentMethodsPickerScreenRowItemsGenerator> lazy4, Lazy<CommercePaymentMethodsPickerScreenOnActivityResultHandler> lazy5, Lazy<PaymentMethodsPickerScreenDataMutator> lazy6, Lazy<CommercePaymentMethodsPickerScreenSubScreenParamsGenerator> lazy7, Lazy<CommercePaymentMethodsPickerScreenRowItemViewFactory> lazy8) {
        super(PickerScreenStyle.MESSENGER_COMMERCE, lazy, lazy2, lazy3, lazy4, lazy5, lazy6, lazy7, lazy8);
    }
}

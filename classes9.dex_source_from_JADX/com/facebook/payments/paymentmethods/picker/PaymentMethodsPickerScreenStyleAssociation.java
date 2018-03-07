package com.facebook.payments.paymentmethods.picker;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: bookmarks_expire_time */
public class PaymentMethodsPickerScreenStyleAssociation extends PickerScreenStyleAssociation<PaymentMethodsPickerScreenStyleRenderer, PaymentMethodsPickerScreenDataFetcher, PaymentMethodsSectionOrganizer, PaymentMethodsRowItemsGenerator, PaymentMethodsPickerScreenOnActivityResultHandler, PaymentMethodsPickerScreenDataMutator, PaymentMethodsPickerScreenSubScreenParamsGenerator, PaymentMethodsRowItemViewFactory> {
    public static PaymentMethodsPickerScreenStyleAssociation m18764b(InjectorLike injectorLike) {
        return new PaymentMethodsPickerScreenStyleAssociation(IdBasedLazy.a(injectorLike, 9175), IdBasedLazy.a(injectorLike, 9171), IdBasedLazy.a(injectorLike, 9179), IdBasedLazy.a(injectorLike, 9178), IdBasedLazy.a(injectorLike, 9173), IdBasedLazy.a(injectorLike, 9172), IdBasedLazy.a(injectorLike, 9176), IdBasedLazy.a(injectorLike, 9177));
    }

    @Inject
    public PaymentMethodsPickerScreenStyleAssociation(Lazy<PaymentMethodsPickerScreenStyleRenderer> lazy, Lazy<PaymentMethodsPickerScreenDataFetcher> lazy2, Lazy<PaymentMethodsSectionOrganizer> lazy3, Lazy<PaymentMethodsRowItemsGenerator> lazy4, Lazy<PaymentMethodsPickerScreenOnActivityResultHandler> lazy5, Lazy<PaymentMethodsPickerScreenDataMutator> lazy6, Lazy<PaymentMethodsPickerScreenSubScreenParamsGenerator> lazy7, Lazy<PaymentMethodsRowItemViewFactory> lazy8) {
        super(PickerScreenStyle.PAYMENT_METHODS, lazy, lazy2, lazy3, lazy4, lazy5, lazy6, lazy7, lazy8);
    }
}

package com.facebook.payments.settings;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsPickerScreenStyleRenderer;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsPickerScreenSubScreenParamsGenerator;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyle;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyleAssociation;
import com.facebook.payments.paymentmethods.picker.SimplePickerScreenDataMutator;
import javax.inject.Inject;

/* compiled from: location_update_received */
public class PaymentSettingsStyleAssociation extends PickerScreenStyleAssociation<PaymentMethodsPickerScreenStyleRenderer, PaymentSettingsPickerScreenDataFetcher, PaymentSettingsSectionOrganizer, PaymentSettingsRowItemsGenerator, PaymentSettingsPickerScreenOnActivityResultHandler, SimplePickerScreenDataMutator, PaymentMethodsPickerScreenSubScreenParamsGenerator, PaymentSettingsRowItemViewFactory> {
    public static PaymentSettingsStyleAssociation m8369b(InjectorLike injectorLike) {
        return new PaymentSettingsStyleAssociation(IdBasedLazy.a(injectorLike, 9175), IdBasedLazy.a(injectorLike, 9197), IdBasedLazy.a(injectorLike, 9201), IdBasedLazy.a(injectorLike, 9200), IdBasedLazy.a(injectorLike, 9198), IdBasedLazy.a(injectorLike, 9182), IdBasedLazy.a(injectorLike, 9176), IdBasedLazy.a(injectorLike, 9199));
    }

    @Inject
    public PaymentSettingsStyleAssociation(Lazy<PaymentMethodsPickerScreenStyleRenderer> lazy, Lazy<PaymentSettingsPickerScreenDataFetcher> lazy2, Lazy<PaymentSettingsSectionOrganizer> lazy3, Lazy<PaymentSettingsRowItemsGenerator> lazy4, Lazy<PaymentSettingsPickerScreenOnActivityResultHandler> lazy5, Lazy<SimplePickerScreenDataMutator> lazy6, Lazy<PaymentMethodsPickerScreenSubScreenParamsGenerator> lazy7, Lazy<PaymentSettingsRowItemViewFactory> lazy8) {
        super(PickerScreenStyle.FB_PAYMENT_SETTINGS, lazy, lazy2, lazy3, lazy4, lazy5, lazy6, lazy7, lazy8);
    }
}

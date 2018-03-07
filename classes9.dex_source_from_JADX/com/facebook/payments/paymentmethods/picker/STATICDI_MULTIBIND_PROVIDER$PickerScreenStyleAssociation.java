package com.facebook.payments.paymentmethods.picker;

import com.facebook.adspayments.AdsPaymentsPickerScreenStyleAssociation;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.payment.value.input.picker.CommercePaymentMethodsPickerScreenStyleAssociation;
import com.facebook.messaging.payment.value.input.picker.CommerceShippingOptionPickerScreenStyleAssociation;
import com.facebook.payments.settings.PaymentSettingsStyleAssociation;
import com.facebook.payments.shipping.addresspicker.ShippingPickerScreenStyleAssociation;
import com.facebook.payments.shipping.optionpicker.ShippingOptionPickerScreenStyleAssociation;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: recommended_radius */
public final class STATICDI_MULTIBIND_PROVIDER$PickerScreenStyleAssociation implements MultiBindIndexedProvider<PickerScreenStyleAssociation>, Provider<Set<PickerScreenStyleAssociation>> {
    private final InjectorLike f18816a;

    public STATICDI_MULTIBIND_PROVIDER$PickerScreenStyleAssociation(InjectorLike injectorLike) {
        this.f18816a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f18816a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 7;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new AdsPaymentsPickerScreenStyleAssociation(IdBasedLazy.a(injector, 9175), IdBasedLazy.a(injector, 4735), IdBasedLazy.a(injector, 4741), IdBasedLazy.a(injector, 4742), IdBasedLazy.a(injector, 4737), IdBasedLazy.a(injector, 4736), IdBasedLazy.a(injector, 4739), IdBasedLazy.a(injector, 4740));
            case 1:
                return CommercePaymentMethodsPickerScreenStyleAssociation.m16034b(injector);
            case 2:
                return CommerceShippingOptionPickerScreenStyleAssociation.m16041b(injector);
            case 3:
                return PaymentMethodsPickerScreenStyleAssociation.m18764b(injector);
            case 4:
                return PaymentSettingsStyleAssociation.b(injector);
            case 5:
                return ShippingPickerScreenStyleAssociation.m18910b(injector);
            case 6:
                return ShippingOptionPickerScreenStyleAssociation.m18995b(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

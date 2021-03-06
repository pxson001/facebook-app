package com.facebook.payments.paymentmethods.picker;

import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenData;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsSectionType;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedMap.Builder;

/* compiled from: bookmark_unread_count */
public class PaymentMethodsSectionOrganizer implements SectionOrganizer<PaymentMethodsSectionType, PaymentMethodsPickerScreenData> {
    public final ImmutableSortedMap mo655a(PickerScreenData pickerScreenData) {
        PaymentMethodsPickerScreenData paymentMethodsPickerScreenData = (PaymentMethodsPickerScreenData) pickerScreenData;
        int i = 2;
        Builder b = ImmutableSortedMap.b();
        if (paymentMethodsPickerScreenData.f18844a.d.isEmpty()) {
            b.a(Integer.valueOf(1), PaymentMethodsSectionType.COUNTRY_SELECTOR);
            if (!paymentMethodsPickerScreenData.f18844a.e.isEmpty()) {
                b.a(Integer.valueOf(2), PaymentMethodsSectionType.SINGLE_ROW_DIVIDER);
                i = 4;
                b.a(Integer.valueOf(3), PaymentMethodsSectionType.ADD_PAYMENT_METHOD);
            }
        } else {
            b.a(Integer.valueOf(1), PaymentMethodsSectionType.SELECT_PAYMENT_METHOD);
        }
        int i2 = i + 1;
        b.a(Integer.valueOf(i), PaymentMethodsSectionType.SINGLE_ROW_DIVIDER);
        b.a(Integer.valueOf(i2), PaymentMethodsSectionType.SECURITY_FOOTER);
        return b.a();
    }
}

package com.facebook.adspayments;

import com.facebook.payments.paymentmethods.picker.SectionOrganizer;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsSectionType;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedMap.Builder;

/* compiled from: Unable to query media files. */
public class AdsPaymentsSectionOrganizer implements SectionOrganizer<PaymentMethodsSectionType, AdsPaymentsPickerScreenData> {
    public final ImmutableSortedMap mo655a(PickerScreenData pickerScreenData) {
        Object obj;
        AdsPaymentsPickerScreenData adsPaymentsPickerScreenData = (AdsPaymentsPickerScreenData) pickerScreenData;
        int i = 1;
        Builder b = ImmutableSortedMap.b();
        if (adsPaymentsPickerScreenData.f23519d) {
            b.a(Integer.valueOf(1), PaymentMethodsSectionType.COUNTRY_SELECTOR);
            i = 3;
            b.a(Integer.valueOf(2), PaymentMethodsSectionType.SINGLE_ROW_DIVIDER);
        }
        int i2 = i + 1;
        Integer valueOf = Integer.valueOf(i);
        if (adsPaymentsPickerScreenData.f18844a.d.isEmpty()) {
            obj = PaymentMethodsSectionType.ADD_PAYMENT_METHOD;
        } else {
            obj = PaymentMethodsSectionType.SELECT_PAYMENT_METHOD;
        }
        b.a(valueOf, obj);
        i = i2 + 1;
        b.a(Integer.valueOf(i2), PaymentMethodsSectionType.SINGLE_ROW_DIVIDER);
        b.a(Integer.valueOf(i), PaymentMethodsSectionType.SECURITY_FOOTER);
        return b.a();
    }
}

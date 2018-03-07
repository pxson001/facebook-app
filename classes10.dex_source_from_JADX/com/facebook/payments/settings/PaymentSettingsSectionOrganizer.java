package com.facebook.payments.settings;

import com.facebook.payments.paymentmethods.picker.SectionOrganizer;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import com.facebook.payments.settings.model.PaymentSettingsPickerScreenData;
import com.facebook.payments.settings.model.PaymentSettingsSectionType;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedMap.Builder;

/* compiled from: location_update_received_start */
public class PaymentSettingsSectionOrganizer implements SectionOrganizer<PaymentSettingsSectionType, PaymentSettingsPickerScreenData> {
    public final ImmutableSortedMap m8368a(PickerScreenData pickerScreenData) {
        Builder b = ImmutableSortedMap.b();
        b.a(Integer.valueOf(1), PaymentSettingsSectionType.PAYMENT_METHODS);
        b.a(Integer.valueOf(2), PaymentSettingsSectionType.DOUBLE_ROW_DIVIDER);
        b.a(Integer.valueOf(3), PaymentSettingsSectionType.PAYMENT_HISTORY);
        b.a(Integer.valueOf(4), PaymentSettingsSectionType.DOUBLE_ROW_DIVIDER);
        b.a(Integer.valueOf(5), PaymentSettingsSectionType.PERSONAL_INFORMATION);
        return b.a();
    }
}

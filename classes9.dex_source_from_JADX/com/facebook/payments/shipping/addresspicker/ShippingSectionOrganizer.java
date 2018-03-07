package com.facebook.payments.shipping.addresspicker;

import com.facebook.payments.paymentmethods.picker.SectionOrganizer;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedMap.Builder;

/* compiled from: backstage_user_update_audience_mode */
public class ShippingSectionOrganizer implements SectionOrganizer<ShippingSectionType, ShippingPickerScreenData> {
    public final ImmutableSortedMap mo655a(PickerScreenData pickerScreenData) {
        Builder b = ImmutableSortedMap.b();
        b.a(Integer.valueOf(1), ShippingSectionType.SHIPPING_ADDRESSES);
        b.a(Integer.valueOf(2), ShippingSectionType.SHIPPING_SECURITY_MESSAGE);
        return b.a();
    }
}

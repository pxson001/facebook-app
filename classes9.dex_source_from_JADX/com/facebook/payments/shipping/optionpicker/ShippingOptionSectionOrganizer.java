package com.facebook.payments.shipping.optionpicker;

import com.facebook.payments.paymentmethods.picker.SectionOrganizer;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedMap.Builder;

/* compiled from: backstage_entered_import_gallery */
public class ShippingOptionSectionOrganizer implements SectionOrganizer<ShippingOptionSectionType, PickerScreenData> {
    public final ImmutableSortedMap<Integer, ShippingOptionSectionType> mo655a(PickerScreenData pickerScreenData) {
        Builder b = ImmutableSortedMap.b();
        b.a(Integer.valueOf(1), ShippingOptionSectionType.SHIPPING_OPTIONS);
        return b.a();
    }
}

package com.facebook.payments.paymentmethods.picker;

import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import com.google.common.collect.ImmutableSortedMap;

/* compiled from: ee7876af4ac18f40d38f7b803eeea336 */
public interface SectionOrganizer<SECTION_TYPE, PICKER_SCREEN_DATA extends PickerScreenData> {
    ImmutableSortedMap<Integer, SECTION_TYPE> mo655a(PICKER_SCREEN_DATA picker_screen_data);
}

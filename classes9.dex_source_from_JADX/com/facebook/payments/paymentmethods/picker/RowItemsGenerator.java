package com.facebook.payments.paymentmethods.picker;

import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import com.facebook.payments.picker.model.RowItem;
import com.google.common.collect.ImmutableList;

/* compiled from: eglCreateWindowSurface returned EGL10.EGL_BAD_NATIVE_WINDOW */
public interface RowItemsGenerator<PICKER_SCREEN_DATA extends PickerScreenData> {
    ImmutableList<RowItem> mo652a(PICKER_SCREEN_DATA picker_screen_data);
}

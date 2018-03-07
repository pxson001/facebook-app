package com.facebook.photos.simplepicker.controller;

import android.content.Context;
import android.view.View;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.photos.simplepicker.view.PickerLongPressProgressBar;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Optional;

/* compiled from: shortcut_fallback_path */
public class DraweeSimplePickerViewControllerProvider extends AbstractAssistedProvider<DraweeSimplePickerViewController> {
    public final DraweeSimplePickerViewController m3065a(View view, PickerSelectionController pickerSelectionController, Optional<PickerLongPressProgressBar> optional, Context context, SimplePickerViewControllerAdapter simplePickerViewControllerAdapter, boolean z, boolean z2, boolean z3) {
        return new DraweeSimplePickerViewController(view, pickerSelectionController, optional, context, simplePickerViewControllerAdapter, z, z2, z3, IdBasedProvider.a(this, 4250), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}

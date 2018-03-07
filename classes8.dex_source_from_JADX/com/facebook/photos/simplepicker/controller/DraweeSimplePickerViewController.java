package com.facebook.photos.simplepicker.controller;

import android.content.Context;
import android.view.View;
import com.facebook.inject.Assisted;
import com.facebook.photos.simplepicker.view.PickerLongPressProgressBar;
import com.facebook.qe.api.QeAccessor;
import com.google.common.base.Optional;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: shortcut_path */
public class DraweeSimplePickerViewController extends SimplePickerViewController {
    @Inject
    public DraweeSimplePickerViewController(@Assisted View view, @Assisted PickerSelectionController pickerSelectionController, @Assisted Optional<PickerLongPressProgressBar> optional, @Assisted Context context, @Assisted SimplePickerViewControllerAdapter simplePickerViewControllerAdapter, @Assisted boolean z, @Assisted boolean z2, @Assisted boolean z3, Provider<Boolean> provider, QeAccessor qeAccessor) {
        super(view, pickerSelectionController, optional, simplePickerViewControllerAdapter, z, z2, z3, provider, qeAccessor);
    }
}

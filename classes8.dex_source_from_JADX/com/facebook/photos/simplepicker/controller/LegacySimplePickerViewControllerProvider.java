package com.facebook.photos.simplepicker.controller;

import android.content.Context;
import android.view.View;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.photos.simplepicker.SimplePickerFragment.BitmapRenderedCallback;
import com.facebook.photos.simplepicker.view.PickerLongPressProgressBar;
import com.facebook.photos.thumbnailsource.ThumbnailSource;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Optional;

/* compiled from: share_params */
public class LegacySimplePickerViewControllerProvider extends AbstractAssistedProvider<LegacySimplePickerViewController> {
    public final LegacySimplePickerViewController m3123a(View view, PickerSelectionController pickerSelectionController, ThumbnailSource thumbnailSource, BitmapRenderedCallback bitmapRenderedCallback, Optional<PickerLongPressProgressBar> optional, Context context, SimplePickerViewControllerAdapter simplePickerViewControllerAdapter, boolean z, boolean z2, boolean z3) {
        return new LegacySimplePickerViewController(view, pickerSelectionController, thumbnailSource, bitmapRenderedCallback, optional, context, simplePickerViewControllerAdapter, z, z2, z3, IdBasedProvider.a(this, 4250), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}

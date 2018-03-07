package com.facebook.photos.simplepicker.controller;

import android.content.Context;
import android.view.View;
import com.facebook.bitmaps.BitmapResizingParam;
import com.facebook.inject.Assisted;
import com.facebook.photos.simplepicker.LegacySimplePickerFragment.DecodedImage;
import com.facebook.photos.simplepicker.SimplePickerFragment.BitmapRenderedCallback;
import com.facebook.photos.simplepicker.SimplePickerFragment.C03817;
import com.facebook.photos.simplepicker.view.PickerGridItemView;
import com.facebook.photos.simplepicker.view.PickerGridPhotoItemView;
import com.facebook.photos.simplepicker.view.PickerGridVideoItemView;
import com.facebook.photos.simplepicker.view.PickerLongPressProgressBar;
import com.facebook.photos.thumbnailsource.ThumbnailSource;
import com.facebook.qe.api.QeAccessor;
import com.google.common.base.Optional;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: share_photo_to_page_tap */
public class LegacySimplePickerViewController extends SimplePickerViewController {
    public final ThumbnailSource f3089c;
    public final C03817 f3090d;
    public final int f3091e;
    public Map<Integer, BitmapResizingParam> f3092f;

    @Inject
    public LegacySimplePickerViewController(@Assisted View view, @Assisted PickerSelectionController pickerSelectionController, @Assisted ThumbnailSource thumbnailSource, @Assisted BitmapRenderedCallback bitmapRenderedCallback, @Assisted Optional<PickerLongPressProgressBar> optional, @Assisted Context context, @Assisted SimplePickerViewControllerAdapter simplePickerViewControllerAdapter, @Assisted boolean z, @Assisted boolean z2, @Assisted boolean z3, Provider<Boolean> provider, QeAccessor qeAccessor) {
        super(view, pickerSelectionController, optional, simplePickerViewControllerAdapter, z, z2, z3, provider, qeAccessor);
        this.f3091e = context.getResources().getDimensionPixelSize(2131429470);
        this.f3089c = thumbnailSource;
        this.f3090d = bitmapRenderedCallback;
    }

    public static void m3122a(PickerGridItemView pickerGridItemView, DecodedImage decodedImage) {
        switch (pickerGridItemView.getItemType()) {
            case VIDEO:
                ((PickerGridVideoItemView) pickerGridItemView).setMediaBitmap(decodedImage.f2855b);
                return;
            default:
                ((PickerGridPhotoItemView) pickerGridItemView).setMediaBitmap(decodedImage.f2855b);
                return;
        }
    }
}

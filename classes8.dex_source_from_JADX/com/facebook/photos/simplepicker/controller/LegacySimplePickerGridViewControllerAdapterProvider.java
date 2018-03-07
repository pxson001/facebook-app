package com.facebook.photos.simplepicker.controller;

import android.view.View;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.photos.simplepicker.SimplePickerFragment.C03817;
import com.facebook.photos.thumbnailsource.ThumbnailSource;

/* compiled from: shared_text */
public class LegacySimplePickerGridViewControllerAdapterProvider extends AbstractAssistedProvider<LegacySimplePickerGridViewControllerAdapter> {
    public final LegacySimplePickerGridViewControllerAdapter m3080a(View view, ThumbnailSource thumbnailSource, C03817 c03817, boolean z) {
        return new LegacySimplePickerGridViewControllerAdapter(view, (LegacySimplePickerGridViewCursorAdapterProvider) getOnDemandAssistedProviderForStaticDi(LegacySimplePickerGridViewCursorAdapterProvider.class), thumbnailSource, c03817, z);
    }
}

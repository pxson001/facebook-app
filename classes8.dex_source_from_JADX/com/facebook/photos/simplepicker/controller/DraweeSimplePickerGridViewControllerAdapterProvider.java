package com.facebook.photos.simplepicker.controller;

import android.view.View;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.photos.simplepicker.SimplePickerFragment.C03817;

/* compiled from: show_bottom_gradient */
public class DraweeSimplePickerGridViewControllerAdapterProvider extends AbstractAssistedProvider<DraweeSimplePickerGridViewControllerAdapter> {
    public final DraweeSimplePickerGridViewControllerAdapter m3020a(View view, C03817 c03817, boolean z) {
        return new DraweeSimplePickerGridViewControllerAdapter(view, (DraweeSimplePickerGridViewCursorAdapterProvider) getOnDemandAssistedProviderForStaticDi(DraweeSimplePickerGridViewCursorAdapterProvider.class), c03817, z);
    }
}

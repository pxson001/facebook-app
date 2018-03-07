package com.facebook.photos.simplepicker.controller;

import android.view.View;
import com.facebook.friendsharing.souvenirs.attachment.SouvenirAttachmentPagerAdapter.Delegate;
import com.facebook.friendsharing.souvenirs.models.SouvenirModel;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.photos.simplepicker.SimplePickerFragment.BitmapRenderedCallback;
import com.google.common.collect.ImmutableList;

/* compiled from: shouldBeCu */
public class DraweeSimplePickerRecyclerViewControllerAdapterProvider extends AbstractAssistedProvider<DraweeSimplePickerRecyclerViewControllerAdapter> {
    public final DraweeSimplePickerRecyclerViewControllerAdapter m3059a(Delegate delegate, View view, ImmutableList<SouvenirModel> immutableList, BitmapRenderedCallback bitmapRenderedCallback, boolean z) {
        return new DraweeSimplePickerRecyclerViewControllerAdapter(delegate, view, immutableList, (DraweeSimplePickerRecyclerViewAdapterProvider) getOnDemandAssistedProviderForStaticDi(DraweeSimplePickerRecyclerViewAdapterProvider.class), bitmapRenderedCallback, z);
    }
}

package com.facebook.photos.simplepicker.controller;

import android.database.Cursor;
import com.facebook.friendsharing.souvenirs.attachment.SouvenirAttachmentPagerAdapter.Delegate;
import com.facebook.friendsharing.souvenirs.attachment.SouvenirAttachmentPagerAdapterProvider;
import com.facebook.friendsharing.souvenirs.models.SouvenirModel;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.photos.simplepicker.SimplePickerFragment.BitmapRenderedCallback;
import com.facebook.photos.simplepicker.view.PickerLongPressProgressBar;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;

/* compiled from: should_reload */
public class DraweeSimplePickerRecyclerViewAdapterProvider extends AbstractAssistedProvider<DraweeSimplePickerRecyclerViewAdapter> {
    public final DraweeSimplePickerRecyclerViewAdapter m3044a(Delegate delegate, Cursor cursor, BitmapRenderedCallback bitmapRenderedCallback, PickerSelectionController pickerSelectionController, Optional<PickerLongPressProgressBar> optional, boolean z, boolean z2, ImmutableList<SouvenirModel> immutableList) {
        return new DraweeSimplePickerRecyclerViewAdapter(delegate, cursor, bitmapRenderedCallback, pickerSelectionController, optional, z, z2, immutableList, (DraweeSimplePickerGridViewCursorAdapterProvider) getOnDemandAssistedProviderForStaticDi(DraweeSimplePickerGridViewCursorAdapterProvider.class), (SouvenirAttachmentPagerAdapterProvider) getOnDemandAssistedProviderForStaticDi(SouvenirAttachmentPagerAdapterProvider.class), (SimplePickerHeaderHolderProvider) getOnDemandAssistedProviderForStaticDi(SimplePickerHeaderHolderProvider.class), (SimplePickerItemHolderProvider) getOnDemandAssistedProviderForStaticDi(SimplePickerItemHolderProvider.class));
    }
}

package com.facebook.photos.simplepicker.controller;

import android.database.Cursor;
import com.facebook.friendsharing.souvenirs.attachment.SouvenirAttachmentPagerAdapter.Delegate;
import com.facebook.friendsharing.souvenirs.attachment.SouvenirAttachmentPagerAdapterProvider;
import com.facebook.friendsharing.souvenirs.models.SouvenirModel;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.photos.simplepicker.SimplePickerFragment.BitmapRenderedCallback;
import com.facebook.photos.simplepicker.view.PickerLongPressProgressBar;
import com.facebook.photos.thumbnailsource.ThumbnailSource;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;

/* compiled from: share_to_pinterest */
public class LegacySimplePickerRecyclerViewAdapterProvider extends AbstractAssistedProvider<LegacySimplePickerRecyclerViewAdapter> {
    public final LegacySimplePickerRecyclerViewAdapter m3105a(Delegate delegate, ThumbnailSource thumbnailSource, Cursor cursor, BitmapRenderedCallback bitmapRenderedCallback, PickerSelectionController pickerSelectionController, Optional<PickerLongPressProgressBar> optional, boolean z, boolean z2, ImmutableList<SouvenirModel> immutableList) {
        return new LegacySimplePickerRecyclerViewAdapter(delegate, thumbnailSource, cursor, bitmapRenderedCallback, pickerSelectionController, optional, z, z2, immutableList, (LegacySimplePickerGridViewCursorAdapterProvider) getOnDemandAssistedProviderForStaticDi(LegacySimplePickerGridViewCursorAdapterProvider.class), (SouvenirAttachmentPagerAdapterProvider) getOnDemandAssistedProviderForStaticDi(SouvenirAttachmentPagerAdapterProvider.class), (SimplePickerHeaderHolderProvider) getOnDemandAssistedProviderForStaticDi(SimplePickerHeaderHolderProvider.class), (SimplePickerItemHolderProvider) getOnDemandAssistedProviderForStaticDi(SimplePickerItemHolderProvider.class));
    }
}

package com.facebook.photos.simplepicker.controller;

import android.view.View;
import com.facebook.friendsharing.souvenirs.attachment.SouvenirAttachmentPagerAdapter.Delegate;
import com.facebook.friendsharing.souvenirs.models.SouvenirModel;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.photos.simplepicker.SimplePickerFragment.BitmapRenderedCallback;
import com.facebook.photos.thumbnailsource.ThumbnailSource;
import com.google.common.collect.ImmutableList;

/* compiled from: share_saved_link */
public class LegacySimplePickerRecyclerViewControllerAdapterProvider extends AbstractAssistedProvider<LegacySimplePickerRecyclerViewControllerAdapter> {
    public final LegacySimplePickerRecyclerViewControllerAdapter m3121a(Delegate delegate, View view, ImmutableList<SouvenirModel> immutableList, ThumbnailSource thumbnailSource, BitmapRenderedCallback bitmapRenderedCallback, boolean z) {
        return new LegacySimplePickerRecyclerViewControllerAdapter(delegate, view, immutableList, (LegacySimplePickerRecyclerViewAdapterProvider) getOnDemandAssistedProviderForStaticDi(LegacySimplePickerRecyclerViewAdapterProvider.class), thumbnailSource, bitmapRenderedCallback, z);
    }
}

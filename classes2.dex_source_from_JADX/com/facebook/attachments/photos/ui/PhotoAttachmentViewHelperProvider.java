package com.facebook.attachments.photos.ui;

import android.view.View;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;

/* compiled from: graphql_cache/ */
public class PhotoAttachmentViewHelperProvider extends AbstractAssistedProvider<PhotoAttachmentViewHelper> {
    public final <V extends View & HasPhotoAttachment> PhotoAttachmentViewHelper<V> m29750a(V v, View view, PostPostBadge postPostBadge) {
        return new PhotoAttachmentViewHelper(v, view, postPostBadge, ConsumptionPhotoEventBus.m14866a(this));
    }
}

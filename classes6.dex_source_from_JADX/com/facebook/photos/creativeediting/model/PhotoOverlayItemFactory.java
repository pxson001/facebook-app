package com.facebook.photos.creativeediting.model;

import com.facebook.photos.creativeediting.interfaces.PhotoOverlayItem;
import com.facebook.photos.creativeediting.interfaces.UriAwarePhotoOverlayItem;
import com.facebook.photos.creativeediting.model.TextParams.Builder;
import com.google.common.base.Preconditions;

/* compiled from: system_tray_id */
public class PhotoOverlayItemFactory {

    /* compiled from: system_tray_id */
    public interface PhotoOverlayItemBuilder {
        PhotoOverlayItemBuilder mo213a(boolean z);

        UriAwarePhotoOverlayItem mo214b();

        PhotoOverlayItemBuilder mo215f(float f);

        PhotoOverlayItemBuilder mo216g(float f);

        PhotoOverlayItemBuilder mo217h(float f);

        PhotoOverlayItemBuilder mo218i(float f);

        PhotoOverlayItemBuilder mo219j(float f);
    }

    public static PhotoOverlayItemBuilder m4668a(PhotoOverlayItem photoOverlayItem) {
        boolean z = (photoOverlayItem instanceof TextParams) || (photoOverlayItem instanceof StickerParams) || (photoOverlayItem instanceof DoodleParams);
        Preconditions.checkArgument(z);
        if (photoOverlayItem instanceof TextParams) {
            return new Builder((TextParams) photoOverlayItem);
        }
        if (photoOverlayItem instanceof DoodleParams) {
            return new DoodleParams.Builder((DoodleParams) photoOverlayItem);
        }
        return new StickerParams.Builder((StickerParams) photoOverlayItem);
    }
}

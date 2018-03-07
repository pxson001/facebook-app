package com.facebook.photos.base.photos;

import android.graphics.Bitmap;
import com.facebook.photos.base.photos.Photo.PhotoSize;
import com.facebook.ui.images.base.UrlImageProcessor;

/* compiled from: initial_red_space_value */
class LocalPhotoImageProcessor extends UrlImageProcessor {
    private final String f12752b;

    public LocalPhotoImageProcessor(int i, PhotoSize photoSize) {
        this.f12752b = photoSize == PhotoSize.THUMBNAIL ? ":" + i + ":" + photoSize : null;
    }

    public final Bitmap mo1096a(Bitmap bitmap) {
        return bitmap;
    }

    public final String mo1097a() {
        return this.f12752b;
    }
}

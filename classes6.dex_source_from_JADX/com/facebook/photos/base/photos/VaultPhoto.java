package com.facebook.photos.base.photos;

import android.net.Uri;
import android.os.Parcelable;
import com.facebook.photos.base.photos.Photo.PhotoSize;

/* compiled from: initial_page_data */
public abstract class VaultPhoto extends Photo implements Parcelable {
    public abstract long mo1098b();

    public final Uri m20137c() {
        return mo1095a(PhotoSize.THUMBNAIL).a;
    }
}

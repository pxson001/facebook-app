package com.facebook.photos.base.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.data.FocusPoint;
import com.facebook.ipc.media.data.MediaData;
import com.facebook.ipc.media.data.MediaData.Builder;
import com.facebook.photos.base.photos.LocalPhoto;
import com.facebook.photos.base.photos.Photo;
import com.facebook.photos.base.util.PhotoHashUtil;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* compiled from: initial_target_data */
public class PhotoItem extends MediaItem {
    public static final Creator<PhotoItem> CREATOR = new C08021();
    public boolean f12736c;
    @Nullable
    public String f12737d;
    public boolean f12738e;
    public LocalPhoto f12739f;

    /* compiled from: initial_target_data */
    final class C08021 implements Creator<PhotoItem> {
        C08021() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhotoItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhotoItem[i];
        }
    }

    PhotoItem(MediaItemFactory$PhotoItemBuilder mediaItemFactory$PhotoItemBuilder) {
        super(mediaItemFactory$PhotoItemBuilder.f12719f, mediaItemFactory$PhotoItemBuilder.f12715b, mediaItemFactory$PhotoItemBuilder.f12714a, mediaItemFactory$PhotoItemBuilder.f12720g);
        this.f12739f = new LocalPhoto(c(), new ArrayList(), null, e(), g());
        this.f12736c = mediaItemFactory$PhotoItemBuilder.f12716c;
        this.f12737d = mediaItemFactory$PhotoItemBuilder.f12718e;
        this.f12738e = mediaItemFactory$PhotoItemBuilder.f12717d;
    }

    public final Photo m20116r() {
        return this.f12739f;
    }

    public final String m20117u() {
        return PhotoHashUtil.m20206a(this);
    }

    public PhotoItem(Parcel parcel) {
        super(parcel);
        this.f12739f = (LocalPhoto) parcel.readParcelable(LocalPhoto.class.getClassLoader());
        this.f12736c = ParcelUtil.a(parcel);
        this.f12737d = parcel.readString();
        this.f12738e = ParcelUtil.a(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f12739f, i);
        ParcelUtil.a(parcel, this.f12736c);
        parcel.writeString(this.f12737d);
        ParcelUtil.a(parcel, this.f12738e);
    }

    @Deprecated
    public final void m20115b(int i) {
        Object obj = 1;
        MediaData b = b();
        Builder a = new Builder().a(b.mId).a(b.mType).a(b.mUri).a(b.mMimeType);
        a.e = b.mOrientation;
        a = a;
        a.f = b.mWidth;
        a = a;
        a.g = b.mHeight;
        a = a;
        a.h = b.mAspectRatio;
        a = a;
        a.i = (FocusPoint) Preconditions.checkNotNull(b.mFocusPoint);
        Builder b2 = a.a(b.mLatitude).b(b.mLongitude);
        b2.e = i;
        Builder builder = b2;
        int i2 = b().mOrientation;
        Object obj2 = (i2 == 90 || i2 == 270) ? 1 : null;
        Object obj3 = (i == 90 || i == 270) ? 1 : null;
        if (obj2 == obj3) {
            obj = null;
        }
        if (obj != null && b().mAspectRatio > 0.0f) {
            builder.h = 1.0f / b().mAspectRatio;
        }
        this.c = this.c.e().a(builder.a()).a();
        this.f12739f.f12749e = i;
    }
}

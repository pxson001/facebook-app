package com.facebook.photos.taggablegallery;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.creativeediting.model.CreativeEditingData;

/* compiled from: sendConfirmationCode */
public class PhotoGalleryContent implements Parcelable {
    public static final Creator<PhotoGalleryContent> CREATOR = new C04311();
    public final PhotoItem f3407a;
    public final CreativeEditingData f3408b;

    /* compiled from: sendConfirmationCode */
    final class C04311 implements Creator<PhotoGalleryContent> {
        C04311() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhotoGalleryContent(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhotoGalleryContent[i];
        }
    }

    /* compiled from: sendConfirmationCode */
    public class Builder {
        private PhotoItem f3405a;
        public CreativeEditingData f3406b = null;

        private Builder(PhotoItem photoItem) {
            this.f3405a = photoItem;
        }

        public static Builder m3368a(PhotoItem photoItem) {
            return new Builder(photoItem);
        }

        public final Builder m3369a(CreativeEditingData creativeEditingData) {
            this.f3406b = creativeEditingData;
            return this;
        }

        public final PhotoGalleryContent m3370a() {
            return new PhotoGalleryContent(this.f3405a, this.f3406b);
        }
    }

    public PhotoGalleryContent(PhotoItem photoItem, CreativeEditingData creativeEditingData) {
        this.f3407a = photoItem;
        this.f3408b = creativeEditingData;
    }

    public final CreativeEditingData m3371a() {
        return this.f3408b;
    }

    public final PhotoItem m3372b() {
        return this.f3407a;
    }

    protected PhotoGalleryContent(Parcel parcel) {
        this.f3407a = (PhotoItem) parcel.readParcelable(PhotoItem.class.getClassLoader());
        this.f3408b = (CreativeEditingData) parcel.readParcelable(CreativeEditingData.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f3407a, i);
        parcel.writeParcelable(this.f3408b, i);
    }
}

package com.facebook.photos.data.method;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: imageMetadata */
public class DeletePhotoAlbumParams implements Parcelable {
    public static final Creator<DeletePhotoAlbumParams> CREATOR = new C08281();
    public final String f12912a;

    /* compiled from: imageMetadata */
    final class C08281 implements Creator<DeletePhotoAlbumParams> {
        C08281() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DeletePhotoAlbumParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new DeletePhotoAlbumParams[i];
        }
    }

    public DeletePhotoAlbumParams(String str) {
        this.f12912a = str;
    }

    public DeletePhotoAlbumParams(Parcel parcel) {
        this.f12912a = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12912a);
    }
}

package com.facebook.photos.upload.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: geofence can't be null. */
public class UploadPhotoSource implements Parcelable {
    public static final Creator<UploadPhotoSource> CREATOR = new C09171();
    public final String f14133a;
    public final long f14134b;

    /* compiled from: geofence can't be null. */
    final class C09171 implements Creator<UploadPhotoSource> {
        C09171() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UploadPhotoSource(parcel);
        }

        public final Object[] newArray(int i) {
            return new UploadPhotoSource[i];
        }
    }

    public UploadPhotoSource(String str, long j) {
        this.f14133a = str;
        this.f14134b = j;
    }

    public final String m21835a() {
        return this.f14133a;
    }

    public int describeContents() {
        return 0;
    }

    public UploadPhotoSource(Parcel parcel) {
        this.f14133a = parcel.readString();
        this.f14134b = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14133a);
        parcel.writeLong(this.f14134b);
    }
}

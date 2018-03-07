package com.facebook.photos.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: homepage */
public class PhotoPlaceholder implements Parcelable {
    public static final Creator<PhotoPlaceholder> CREATOR = new C08431();
    public final long f12966a;
    private final int f12967b;
    private final int f12968c;
    private final String f12969d;
    private final String f12970e;

    /* compiled from: homepage */
    final class C08431 implements Creator<PhotoPlaceholder> {
        C08431() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhotoPlaceholder(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhotoPlaceholder[i];
        }
    }

    public PhotoPlaceholder(Parcel parcel) {
        this.f12966a = parcel.readLong();
        this.f12967b = parcel.readInt();
        this.f12968c = parcel.readInt();
        this.f12969d = parcel.readString();
        this.f12970e = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f12966a);
        parcel.writeInt(this.f12967b);
        parcel.writeInt(this.f12968c);
        parcel.writeString(this.f12969d);
        parcel.writeString(this.f12970e);
    }

    public int describeContents() {
        return 0;
    }
}

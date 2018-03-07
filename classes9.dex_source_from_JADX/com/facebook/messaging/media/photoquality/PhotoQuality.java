package com.facebook.messaging.media.photoquality;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: low_data_mode_enabled */
public class PhotoQuality implements Parcelable {
    public static final Creator<PhotoQuality> CREATOR = new C13231();
    public static PhotoQuality f11787a = new PhotoQuality(960);
    public final int f11788b;
    public final int f11789c;

    /* compiled from: low_data_mode_enabled */
    final class C13231 implements Creator<PhotoQuality> {
        C13231() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhotoQuality(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhotoQuality[i];
        }
    }

    public PhotoQuality(int i) {
        this.f11788b = i;
        this.f11789c = PhotoQualityHelper.a(i);
    }

    public PhotoQuality(Parcel parcel) {
        this.f11788b = parcel.readInt();
        this.f11789c = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f11788b);
        parcel.writeInt(this.f11789c);
    }
}

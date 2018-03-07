package com.facebook.photos.creativeediting.analytics;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: mUrl */
public class DoodleOnPhotosLoggingParams implements Parcelable {
    public static final Creator<DoodleOnPhotosLoggingParams> CREATOR = new C07771();
    public boolean f9562a;
    public boolean f9563b;
    public int f9564c;
    public int f9565d;
    public int f9566e;

    /* compiled from: mUrl */
    final class C07771 implements Creator<DoodleOnPhotosLoggingParams> {
        C07771() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DoodleOnPhotosLoggingParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new DoodleOnPhotosLoggingParams[i];
        }
    }

    public DoodleOnPhotosLoggingParams(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f9564c = parcel.readInt();
        this.f9565d = parcel.readInt();
        this.f9566e = parcel.readInt();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f9562a = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.f9563b = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeInt(this.f9564c);
        parcel.writeInt(this.f9565d);
        parcel.writeInt(this.f9566e);
        if (this.f9562a) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.f9563b) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }
}

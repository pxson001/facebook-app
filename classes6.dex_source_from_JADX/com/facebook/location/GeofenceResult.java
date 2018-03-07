package com.facebook.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: ฿ */
public class GeofenceResult implements Parcelable {
    public static final Creator<GeofenceResult> CREATOR = new C00011();
    public final ImmutableLocation f22a;
    public final long f23b;
    public final long f24c;
    public final float f25d;

    /* compiled from: ฿ */
    final class C00011 implements Creator<GeofenceResult> {
        C00011() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GeofenceResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new GeofenceResult[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f22a, i);
        parcel.writeLong(this.f23b);
        parcel.writeLong(this.f24c);
        parcel.writeFloat(this.f25d);
    }

    protected GeofenceResult(Parcel parcel) {
        this.f22a = (ImmutableLocation) parcel.readParcelable(ImmutableLocation.class.getClassLoader());
        this.f23b = parcel.readLong();
        this.f24c = parcel.readLong();
        this.f25d = parcel.readFloat();
    }
}

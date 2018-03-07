package com.facebook.android.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: author */
public final class LatLng implements Parcelable {
    public static final Creator<LatLng> CREATOR = new C09341();
    public final double f8568a;
    public final double f8569b;

    /* compiled from: author */
    final class C09341 implements Creator<LatLng> {
        C09341() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LatLng(parcel);
        }

        public final Object[] newArray(int i) {
            return new LatLng[i];
        }
    }

    public LatLng(double d, double d2) {
        this.f8568a = d;
        this.f8569b = d2;
    }

    public LatLng(Parcel parcel) {
        this.f8568a = parcel.readDouble();
        this.f8569b = parcel.readDouble();
    }

    public final int hashCode() {
        return (int) (((527.0d + this.f8568a) * 31.0d) + this.f8569b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        if (Math.abs(this.f8568a - latLng.f8568a) >= 0.002d || Math.abs(this.f8569b - latLng.f8569b) >= 2.0E-4d) {
            return false;
        }
        return true;
    }

    public final String toString() {
        return getClass().getSimpleName() + "{latitude=" + this.f8568a + ", longitude=" + this.f8569b + "}";
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.f8568a);
        parcel.writeDouble(this.f8569b);
    }
}

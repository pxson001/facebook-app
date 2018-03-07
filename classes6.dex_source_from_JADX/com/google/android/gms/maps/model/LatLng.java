package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class LatLng implements SafeParcelable {
    public static final zze CREATOR = new zze();
    public final double f6746a;
    public final double f6747b;
    public final int f6748c;

    public LatLng(double d, double d2) {
        this(1, d, d2);
    }

    LatLng(int i, double d, double d2) {
        this.f6748c = i;
        if (-180.0d > d2 || d2 >= 180.0d) {
            this.f6747b = ((((d2 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d;
        } else {
            this.f6747b = d2;
        }
        this.f6746a = Math.max(-90.0d, Math.min(90.0d, d));
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        return Double.doubleToLongBits(this.f6746a) == Double.doubleToLongBits(latLng.f6746a) && Double.doubleToLongBits(this.f6747b) == Double.doubleToLongBits(latLng.f6747b);
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f6746a);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.f6747b);
        return (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public final String toString() {
        return "lat/lng: (" + this.f6746a + "," + this.f6747b + ")";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6748c);
        zzb.a(parcel, 2, this.f6746a);
        zzb.a(parcel, 3, this.f6747b);
        zzb.c(parcel, a);
    }
}

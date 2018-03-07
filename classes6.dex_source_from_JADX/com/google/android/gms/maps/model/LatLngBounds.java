package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public final class LatLngBounds implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    public final LatLng f6753a;
    public final LatLng f6754b;
    public final int f6755c;

    public final class Builder {
        private double f6749a = Double.POSITIVE_INFINITY;
        private double f6750b = Double.NEGATIVE_INFINITY;
        public double f6751c = Double.NaN;
        public double f6752d = Double.NaN;

        public final Builder m9655a(LatLng latLng) {
            this.f6749a = Math.min(this.f6749a, latLng.f6746a);
            this.f6750b = Math.max(this.f6750b, latLng.f6746a);
            double d = latLng.f6747b;
            if (Double.isNaN(this.f6751c)) {
                this.f6751c = d;
            } else {
                Object obj = 1;
                if (this.f6751c <= this.f6752d) {
                    if (this.f6751c > d || d > this.f6752d) {
                        obj = null;
                    }
                } else if (this.f6751c > d && d > this.f6752d) {
                    obj = null;
                }
                if (obj == null) {
                    if (LatLngBounds.m9658c(this.f6751c, d) < LatLngBounds.m9659d(this.f6752d, d)) {
                        this.f6751c = d;
                    }
                }
                return this;
            }
            this.f6752d = d;
            return this;
        }

        public final LatLngBounds m9656a() {
            zzx.a(!Double.isNaN(this.f6751c), "no included points");
            return new LatLngBounds(new LatLng(this.f6749a, this.f6751c), new LatLng(this.f6750b, this.f6752d));
        }
    }

    LatLngBounds(int i, LatLng latLng, LatLng latLng2) {
        zzx.a(latLng, "null southwest");
        zzx.a(latLng2, "null northeast");
        zzx.b(latLng2.f6746a >= latLng.f6746a, "southern latitude exceeds northern latitude (%s > %s)", new Object[]{Double.valueOf(latLng.f6746a), Double.valueOf(latLng2.f6746a)});
        this.f6755c = i;
        this.f6753a = latLng;
        this.f6754b = latLng2;
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }

    public static Builder m9657b() {
        return new Builder();
    }

    public static double m9658c(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    public static double m9659d(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.f6753a.equals(latLngBounds.f6753a) && this.f6754b.equals(latLngBounds.f6754b);
    }

    public final int hashCode() {
        return zzw.a(new Object[]{this.f6753a, this.f6754b});
    }

    public final String toString() {
        return zzw.a(this).a("southwest", this.f6753a).a("northeast", this.f6754b).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6755c);
        zzb.a(parcel, 2, this.f6753a, i, false);
        zzb.a(parcel, 3, this.f6754b, i, false);
        zzb.c(parcel, a);
    }
}

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class StreetViewPanoramaOrientation implements SafeParcelable {
    public static final zzm CREATOR = new zzm();
    public final float f6806a;
    public final float f6807b;
    public final int f6808c;

    public final class Builder {
        public float f6804a;
        public float f6805b;
    }

    public StreetViewPanoramaOrientation(float f, float f2) {
        this(1, f, f2);
    }

    StreetViewPanoramaOrientation(int i, float f, float f2) {
        boolean z = -90.0f <= f && f <= 90.0f;
        zzx.b(z, "Tilt needs to be between -90 and 90 inclusive");
        this.f6808c = i;
        this.f6806a = 0.0f + f;
        if (((double) f2) <= 0.0d) {
            f2 = (f2 % 360.0f) + 360.0f;
        }
        this.f6807b = f2 % 360.0f;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaOrientation)) {
            return false;
        }
        StreetViewPanoramaOrientation streetViewPanoramaOrientation = (StreetViewPanoramaOrientation) obj;
        return Float.floatToIntBits(this.f6806a) == Float.floatToIntBits(streetViewPanoramaOrientation.f6806a) && Float.floatToIntBits(this.f6807b) == Float.floatToIntBits(streetViewPanoramaOrientation.f6807b);
    }

    public int hashCode() {
        return zzw.a(new Object[]{Float.valueOf(this.f6806a), Float.valueOf(this.f6807b)});
    }

    public String toString() {
        return zzw.a(this).a("tilt", Float.valueOf(this.f6806a)).a("bearing", Float.valueOf(this.f6807b)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6808c);
        zzb.a(parcel, 2, this.f6806a);
        zzb.a(parcel, 3, this.f6807b);
        zzb.c(parcel, a);
    }
}

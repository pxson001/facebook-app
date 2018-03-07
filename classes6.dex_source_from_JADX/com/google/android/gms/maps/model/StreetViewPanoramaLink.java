package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;

public class StreetViewPanoramaLink implements SafeParcelable {
    public static final zzk CREATOR = new zzk();
    public final String f6797a;
    public final float f6798b;
    public final int f6799c;

    StreetViewPanoramaLink(int i, String str, float f) {
        this.f6799c = i;
        this.f6797a = str;
        if (((double) f) <= 0.0d) {
            f = (f % 360.0f) + 360.0f;
        }
        this.f6798b = f % 360.0f;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLink)) {
            return false;
        }
        StreetViewPanoramaLink streetViewPanoramaLink = (StreetViewPanoramaLink) obj;
        return this.f6797a.equals(streetViewPanoramaLink.f6797a) && Float.floatToIntBits(this.f6798b) == Float.floatToIntBits(streetViewPanoramaLink.f6798b);
    }

    public int hashCode() {
        return zzw.a(new Object[]{this.f6797a, Float.valueOf(this.f6798b)});
    }

    public String toString() {
        return zzw.a(this).a("panoId", this.f6797a).a("bearing", Float.valueOf(this.f6798b)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6799c);
        zzb.a(parcel, 2, this.f6797a, false);
        zzb.a(parcel, 3, this.f6798b);
        zzb.c(parcel, a);
    }
}

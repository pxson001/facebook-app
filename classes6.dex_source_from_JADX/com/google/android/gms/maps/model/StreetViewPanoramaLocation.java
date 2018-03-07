package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;

public class StreetViewPanoramaLocation implements SafeParcelable {
    public static final zzl CREATOR = new zzl();
    public final StreetViewPanoramaLink[] f6800a;
    public final LatLng f6801b;
    public final String f6802c;
    public final int f6803d;

    StreetViewPanoramaLocation(int i, StreetViewPanoramaLink[] streetViewPanoramaLinkArr, LatLng latLng, String str) {
        this.f6803d = i;
        this.f6800a = streetViewPanoramaLinkArr;
        this.f6801b = latLng;
        this.f6802c = str;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLocation)) {
            return false;
        }
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) obj;
        return this.f6802c.equals(streetViewPanoramaLocation.f6802c) && this.f6801b.equals(streetViewPanoramaLocation.f6801b);
    }

    public int hashCode() {
        return zzw.a(new Object[]{this.f6801b, this.f6802c});
    }

    public String toString() {
        return zzw.a(this).a("panoId", this.f6802c).a("position", this.f6801b.toString()).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6803d);
        zzb.a(parcel, 2, this.f6800a, i, false);
        zzb.a(parcel, 3, this.f6801b, i, false);
        zzb.a(parcel, 4, this.f6802c, false);
        zzb.c(parcel, a);
    }
}

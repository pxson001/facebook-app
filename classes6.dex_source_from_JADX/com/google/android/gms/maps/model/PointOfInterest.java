package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class PointOfInterest implements SafeParcelable {
    public static final zzg CREATOR = new zzg();
    public final LatLng f6771a;
    public final String f6772b;
    public final String f6773c;
    public final int f6774d;

    PointOfInterest(int i, LatLng latLng, String str, String str2) {
        this.f6774d = i;
        this.f6771a = latLng;
        this.f6772b = str;
        this.f6773c = str2;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6774d);
        zzb.a(parcel, 2, this.f6771a, i, false);
        zzb.a(parcel, 3, this.f6772b, false);
        zzb.a(parcel, 4, this.f6773c, false);
        zzb.c(parcel, a);
    }
}

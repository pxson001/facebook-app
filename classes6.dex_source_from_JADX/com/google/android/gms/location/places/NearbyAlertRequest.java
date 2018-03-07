package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;

public final class NearbyAlertRequest implements SafeParcelable {
    public static final zze CREATOR = new zze();
    public final int f6427a;
    public final int f6428b;
    public final int f6429c;
    @Deprecated
    private final PlaceFilter f6430d;
    public final NearbyAlertFilter f6431e;
    public final boolean f6432f;
    public final int f6433g;

    NearbyAlertRequest(int i, int i2, int i3, PlaceFilter placeFilter, NearbyAlertFilter nearbyAlertFilter, boolean z, int i4) {
        this.f6427a = i;
        this.f6428b = i2;
        this.f6429c = i3;
        this.f6432f = z;
        if (nearbyAlertFilter != null) {
            this.f6431e = nearbyAlertFilter;
        } else if (placeFilter == null) {
            this.f6431e = null;
        } else if (placeFilter.f6444h != null && !placeFilter.f6444h.isEmpty()) {
            this.f6431e = NearbyAlertFilter.m8964a(placeFilter.f6444h);
        } else if (placeFilter.f6442f == null || placeFilter.f6442f.isEmpty()) {
            this.f6431e = null;
        } else {
            this.f6431e = NearbyAlertFilter.m8965b(placeFilter.f6442f);
        }
        this.f6430d = null;
        this.f6433g = i4;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearbyAlertRequest)) {
            return false;
        }
        NearbyAlertRequest nearbyAlertRequest = (NearbyAlertRequest) obj;
        return this.f6428b == nearbyAlertRequest.f6428b && this.f6429c == nearbyAlertRequest.f6429c && zzw.a(this.f6430d, nearbyAlertRequest.f6430d) && zzw.a(this.f6431e, nearbyAlertRequest.f6431e);
    }

    public final int hashCode() {
        return zzw.a(new Object[]{Integer.valueOf(this.f6428b), Integer.valueOf(this.f6429c)});
    }

    public final String toString() {
        return zzw.a(this).a("transitionTypes", Integer.valueOf(this.f6428b)).a("loiteringTimeMillis", Integer.valueOf(this.f6429c)).a("nearbyAlertFilter", this.f6431e).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6428b);
        zzb.a(parcel, 1000, this.f6427a);
        zzb.a(parcel, 2, this.f6429c);
        zzb.a(parcel, 3, null, i, false);
        zzb.a(parcel, 4, this.f6431e, i, false);
        zzb.a(parcel, 5, this.f6432f);
        zzb.a(parcel, 6, this.f6433g);
        zzb.c(parcel, a);
    }
}

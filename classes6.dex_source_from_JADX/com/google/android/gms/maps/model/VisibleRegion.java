package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;

public final class VisibleRegion implements SafeParcelable {
    public static final zzp CREATOR = new zzp();
    public final LatLng f6822a;
    public final LatLng f6823b;
    public final LatLng f6824c;
    public final LatLng f6825d;
    public final LatLngBounds f6826e;
    public final int f6827f;

    VisibleRegion(int i, LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this.f6827f = i;
        this.f6822a = latLng;
        this.f6823b = latLng2;
        this.f6824c = latLng3;
        this.f6825d = latLng4;
        this.f6826e = latLngBounds;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) obj;
        return this.f6822a.equals(visibleRegion.f6822a) && this.f6823b.equals(visibleRegion.f6823b) && this.f6824c.equals(visibleRegion.f6824c) && this.f6825d.equals(visibleRegion.f6825d) && this.f6826e.equals(visibleRegion.f6826e);
    }

    public final int hashCode() {
        return zzw.a(new Object[]{this.f6822a, this.f6823b, this.f6824c, this.f6825d, this.f6826e});
    }

    public final String toString() {
        return zzw.a(this).a("nearLeft", this.f6822a).a("nearRight", this.f6823b).a("farLeft", this.f6824c).a("farRight", this.f6825d).a("latLngBounds", this.f6826e).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6827f);
        zzb.a(parcel, 2, this.f6822a, i, false);
        zzb.a(parcel, 3, this.f6823b, i, false);
        zzb.a(parcel, 4, this.f6824c, i, false);
        zzb.a(parcel, 5, this.f6825d, i, false);
        zzb.a(parcel, 6, this.f6826e, i, false);
        zzb.c(parcel, a);
    }
}

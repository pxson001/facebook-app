package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class LocationResult implements SafeParcelable {
    public static final Creator<LocationResult> CREATOR = new zze();
    static final List<Location> f6333a = Collections.emptyList();
    public final int f6334b;
    public final List<Location> f6335c;

    LocationResult(int i, List<Location> list) {
        this.f6334b = i;
        this.f6335c = list;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (locationResult.f6335c.size() != this.f6335c.size()) {
            return false;
        }
        Iterator it = this.f6335c.iterator();
        for (Location time : locationResult.f6335c) {
            if (((Location) it.next()).getTime() != time.getTime()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 17;
        for (Location time : this.f6335c) {
            long time2 = time.getTime();
            i = ((int) (time2 ^ (time2 >>> 32))) + (i * 31);
        }
        return i;
    }

    public final String toString() {
        return "LocationResult[locations: " + this.f6335c + "]";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.c(parcel, 1, this.f6335c, false);
        zzb.a(parcel, 1000, this.f6334b);
        zzb.c(parcel, a);
    }
}

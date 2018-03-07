package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;

public final class LocationAvailability implements SafeParcelable {
    public static final LocationAvailabilityCreator CREATOR = new LocationAvailabilityCreator();
    public int f6319a;
    public int f6320b;
    public long f6321c;
    public int f6322d;
    public final int f6323e;

    LocationAvailability(int i, int i2, int i3, int i4, long j) {
        this.f6323e = i;
        this.f6322d = i2;
        this.f6319a = i3;
        this.f6320b = i4;
        this.f6321c = j;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LocationAvailability)) {
            return false;
        }
        LocationAvailability locationAvailability = (LocationAvailability) obj;
        return this.f6322d == locationAvailability.f6322d && this.f6319a == locationAvailability.f6319a && this.f6320b == locationAvailability.f6320b && this.f6321c == locationAvailability.f6321c;
    }

    public final int hashCode() {
        return zzw.a(new Object[]{Integer.valueOf(this.f6322d), Integer.valueOf(this.f6319a), Integer.valueOf(this.f6320b), Long.valueOf(this.f6321c)});
    }

    public final String toString() {
        return "LocationAvailability[isLocationAvailable: " + (this.f6322d < 1000) + "]";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6319a);
        zzb.a(parcel, 1000, this.f6323e);
        zzb.a(parcel, 2, this.f6320b);
        zzb.a(parcel, 3, this.f6321c);
        zzb.a(parcel, 4, this.f6322d);
        zzb.c(parcel, a);
    }
}

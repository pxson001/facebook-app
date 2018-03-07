package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class LocationSettingsStates implements SafeParcelable {
    public static final Creator<LocationSettingsStates> CREATOR = new zzh();
    public final int f6346a;
    public final boolean f6347b;
    public final boolean f6348c;
    public final boolean f6349d;
    public final boolean f6350e;
    public final boolean f6351f;
    public final boolean f6352g;

    LocationSettingsStates(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.f6346a = i;
        this.f6347b = z;
        this.f6348c = z2;
        this.f6349d = z3;
        this.f6350e = z4;
        this.f6351f = z5;
        this.f6352g = z6;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6347b);
        zzb.a(parcel, 1000, this.f6346a);
        zzb.a(parcel, 2, this.f6348c);
        zzb.a(parcel, 3, this.f6349d);
        zzb.a(parcel, 4, this.f6350e);
        zzb.a(parcel, 5, this.f6351f);
        zzb.a(parcel, 6, this.f6352g);
        zzb.c(parcel, a);
    }
}

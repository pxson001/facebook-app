package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class LocationSettingsResult implements Result, SafeParcelable {
    public static final Creator<LocationSettingsResult> CREATOR = new zzg();
    public final int f6343a;
    private final Status f6344b;
    public final LocationSettingsStates f6345c;

    LocationSettingsResult(int i, Status status, LocationSettingsStates locationSettingsStates) {
        this.f6343a = i;
        this.f6344b = status;
        this.f6345c = locationSettingsStates;
    }

    public LocationSettingsResult(Status status) {
        this(1, status, null);
    }

    public final Status cp_() {
        return this.f6344b;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, cp_(), i, false);
        zzb.a(parcel, 1000, this.f6343a);
        zzb.a(parcel, 2, this.f6345c, i, false);
        zzb.c(parcel, a);
    }
}

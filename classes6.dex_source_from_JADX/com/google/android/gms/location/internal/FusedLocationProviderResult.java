package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class FusedLocationProviderResult implements Result, SafeParcelable {
    public static final Creator<FusedLocationProviderResult> CREATOR = new zze();
    public static final FusedLocationProviderResult f6356a = new FusedLocationProviderResult(Status.a);
    public final int f6357b;
    private final Status f6358c;

    FusedLocationProviderResult(int i, Status status) {
        this.f6357b = i;
        this.f6358c = status;
    }

    private FusedLocationProviderResult(Status status) {
        this(1, status);
    }

    public final Status cp_() {
        return this.f6358c;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, cp_(), i, false);
        zzb.a(parcel, 1000, this.f6357b);
        zzb.c(parcel, a);
    }
}

package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class AddLocalCapabilityResponse implements SafeParcelable {
    public static final Creator<AddLocalCapabilityResponse> CREATOR = new zzd();
    public final int f13201a;
    public final int f13202b;

    AddLocalCapabilityResponse(int i, int i2) {
        this.f13201a = i;
        this.f13202b = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13201a);
        zzb.a(parcel, 2, this.f13202b);
        zzb.c(parcel, a);
    }
}

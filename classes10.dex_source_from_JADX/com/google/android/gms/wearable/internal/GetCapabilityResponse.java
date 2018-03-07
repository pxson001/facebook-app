package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class GetCapabilityResponse implements SafeParcelable {
    public static final Creator<GetCapabilityResponse> CREATOR = new zzaj();
    public final int f13255a;
    public final int f13256b;
    public final CapabilityInfoParcelable f13257c;

    GetCapabilityResponse(int i, int i2, CapabilityInfoParcelable capabilityInfoParcelable) {
        this.f13255a = i;
        this.f13256b = i2;
        this.f13257c = capabilityInfoParcelable;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13255a);
        zzb.a(parcel, 2, this.f13256b);
        zzb.a(parcel, 3, this.f13257c, i, false);
        zzb.c(parcel, a);
    }
}

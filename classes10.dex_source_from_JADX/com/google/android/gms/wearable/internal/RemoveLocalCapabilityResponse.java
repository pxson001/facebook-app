package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class RemoveLocalCapabilityResponse implements SafeParcelable {
    public static final Creator<RemoveLocalCapabilityResponse> CREATOR = new zzbw();
    public final int f13357a;
    public final int f13358b;

    RemoveLocalCapabilityResponse(int i, int i2) {
        this.f13357a = i;
        this.f13358b = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13357a);
        zzb.a(parcel, 2, this.f13358b);
        zzb.c(parcel, a);
    }
}

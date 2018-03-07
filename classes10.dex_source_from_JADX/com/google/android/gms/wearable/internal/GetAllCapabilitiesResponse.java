package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class GetAllCapabilitiesResponse implements SafeParcelable {
    public static final Creator<GetAllCapabilitiesResponse> CREATOR = new zzai();
    public final int f13252a;
    public final int f13253b;
    public final List<CapabilityInfoParcelable> f13254c;

    GetAllCapabilitiesResponse(int i, int i2, List<CapabilityInfoParcelable> list) {
        this.f13252a = i;
        this.f13253b = i2;
        this.f13254c = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13252a);
        zzb.a(parcel, 2, this.f13253b);
        zzb.c(parcel, 3, this.f13254c, false);
        zzb.c(parcel, a);
    }
}

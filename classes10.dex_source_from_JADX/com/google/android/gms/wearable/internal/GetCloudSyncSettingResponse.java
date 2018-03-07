package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class GetCloudSyncSettingResponse implements SafeParcelable {
    public static final Creator<GetCloudSyncSettingResponse> CREATOR = new zzao();
    public final int f13271a;
    public final int f13272b;
    public final boolean f13273c;

    GetCloudSyncSettingResponse(int i, int i2, boolean z) {
        this.f13271a = i;
        this.f13272b = i2;
        this.f13273c = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13271a);
        zzb.a(parcel, 2, this.f13272b);
        zzb.a(parcel, 3, this.f13273c);
        zzb.c(parcel, a);
    }
}

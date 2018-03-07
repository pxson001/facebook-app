package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class GetCloudSyncOptInStatusResponse implements SafeParcelable {
    public static final Creator<GetCloudSyncOptInStatusResponse> CREATOR = new zzan();
    public final int f13267a;
    public final int f13268b;
    public final boolean f13269c;
    public final boolean f13270d;

    GetCloudSyncOptInStatusResponse(int i, int i2, boolean z, boolean z2) {
        this.f13267a = i;
        this.f13268b = i2;
        this.f13269c = z;
        this.f13270d = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13267a);
        zzb.a(parcel, 2, this.f13268b);
        zzb.a(parcel, 3, this.f13269c);
        zzb.a(parcel, 4, this.f13270d);
        zzb.c(parcel, a);
    }
}

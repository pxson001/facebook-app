package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class GetCloudSyncOptInOutDoneResponse implements SafeParcelable {
    public static final Creator<GetCloudSyncOptInOutDoneResponse> CREATOR = new zzam();
    public final int f13264a;
    public final int f13265b;
    public final boolean f13266c;

    GetCloudSyncOptInOutDoneResponse(int i, int i2, boolean z) {
        this.f13264a = i;
        this.f13265b = i2;
        this.f13266c = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13264a);
        zzb.a(parcel, 2, this.f13265b);
        zzb.a(parcel, 3, this.f13266c);
        zzb.c(parcel, a);
    }
}

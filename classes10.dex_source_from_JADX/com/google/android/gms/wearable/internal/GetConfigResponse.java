package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.ConnectionConfiguration;

@Deprecated
public class GetConfigResponse implements SafeParcelable {
    public static final Creator<GetConfigResponse> CREATOR = new zzap();
    public final int f13274a;
    public final int f13275b;
    public final ConnectionConfiguration f13276c;

    GetConfigResponse(int i, int i2, ConnectionConfiguration connectionConfiguration) {
        this.f13274a = i;
        this.f13275b = i2;
        this.f13276c = connectionConfiguration;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13274a);
        zzb.a(parcel, 2, this.f13275b);
        zzb.a(parcel, 3, this.f13276c, i, false);
        zzb.c(parcel, a);
    }
}

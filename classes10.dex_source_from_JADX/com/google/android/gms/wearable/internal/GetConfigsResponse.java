package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.ConnectionConfiguration;

public class GetConfigsResponse implements SafeParcelable {
    public static final Creator<GetConfigsResponse> CREATOR = new zzaq();
    public final int f13277a;
    public final int f13278b;
    public final ConnectionConfiguration[] f13279c;

    GetConfigsResponse(int i, int i2, ConnectionConfiguration[] connectionConfigurationArr) {
        this.f13277a = i;
        this.f13278b = i2;
        this.f13279c = connectionConfigurationArr;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13277a);
        zzb.a(parcel, 2, this.f13278b);
        zzb.a(parcel, 3, this.f13279c, i, false);
        zzb.c(parcel, a);
    }
}

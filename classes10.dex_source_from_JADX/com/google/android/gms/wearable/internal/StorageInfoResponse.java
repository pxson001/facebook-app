package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class StorageInfoResponse implements SafeParcelable {
    public static final Creator<StorageInfoResponse> CREATOR = new zzca();
    public final int f13362a;
    public final int f13363b;
    public final long f13364c;
    public final List<PackageStorageInfo> f13365d;

    StorageInfoResponse(int i, int i2, long j, List<PackageStorageInfo> list) {
        this.f13362a = i;
        this.f13363b = i2;
        this.f13364c = j;
        this.f13365d = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13362a);
        zzb.a(parcel, 2, this.f13363b);
        zzb.a(parcel, 3, this.f13364c);
        zzb.c(parcel, 4, this.f13365d, false);
        zzb.c(parcel, a);
    }
}

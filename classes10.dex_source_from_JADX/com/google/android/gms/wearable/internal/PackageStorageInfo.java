package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class PackageStorageInfo implements SafeParcelable {
    public static final Creator<PackageStorageInfo> CREATOR = new zzbr();
    public final int f13345a;
    public final String f13346b;
    public final String f13347c;
    public final long f13348d;

    PackageStorageInfo(int i, String str, String str2, long j) {
        this.f13345a = i;
        this.f13346b = str;
        this.f13347c = str2;
        this.f13348d = j;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13345a);
        zzb.a(parcel, 2, this.f13346b, false);
        zzb.a(parcel, 3, this.f13347c, false);
        zzb.a(parcel, 4, this.f13348d);
        zzb.c(parcel, a);
    }
}

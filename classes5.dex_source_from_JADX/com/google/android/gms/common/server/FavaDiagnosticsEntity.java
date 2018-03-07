package com.google.android.gms.common.server;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class FavaDiagnosticsEntity implements SafeParcelable {
    public static final zza CREATOR = new zza();
    public final int f6592a;
    public final String f6593b;
    public final int f6594c;

    public FavaDiagnosticsEntity(int i, String str, int i2) {
        this.f6592a = i;
        this.f6593b = str;
        this.f6594c = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6592a);
        zzb.m12247a(parcel, 2, this.f6593b, false);
        zzb.m12241a(parcel, 3, this.f6594c);
        zzb.m12258c(parcel, a);
    }
}

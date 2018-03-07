package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class Feature implements SafeParcelable {
    public static final zze CREATOR = new zze();
    public final int f20548a;
    public final int f20549b;
    public final Bundle f20550c;

    Feature(int i, int i2, Bundle bundle) {
        this.f20548a = i;
        this.f20549b = i2;
        this.f20550c = bundle;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f20549b);
        zzb.a(parcel, 1000, this.f20548a);
        zzb.a(parcel, 2, this.f20550c, false);
        zzb.c(parcel, a);
    }
}

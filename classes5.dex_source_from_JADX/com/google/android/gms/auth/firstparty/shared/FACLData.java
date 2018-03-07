package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class FACLData implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    public final int f6426a;
    public FACLConfig f6427b;
    public String f6428c;
    public boolean f6429d;
    public String f6430e;

    FACLData(int i, FACLConfig fACLConfig, String str, boolean z, String str2) {
        this.f6426a = i;
        this.f6427b = fACLConfig;
        this.f6428c = str;
        this.f6429d = z;
        this.f6430e = str2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6426a);
        zzb.m12245a(parcel, 2, this.f6427b, i, false);
        zzb.m12247a(parcel, 3, this.f6428c, false);
        zzb.m12249a(parcel, 4, this.f6429d);
        zzb.m12247a(parcel, 5, this.f6430e, false);
        zzb.m12258c(parcel, a);
    }
}

package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;

public class FACLConfig implements SafeParcelable {
    public static final zza CREATOR = new zza();
    public final int f6419a;
    public boolean f6420b;
    public String f6421c;
    public boolean f6422d;
    public boolean f6423e;
    public boolean f6424f;
    public boolean f6425g;

    FACLConfig(int i, boolean z, String str, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.f6419a = i;
        this.f6420b = z;
        this.f6421c = str;
        this.f6422d = z2;
        this.f6423e = z3;
        this.f6424f = z4;
        this.f6425g = z5;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FACLConfig)) {
            return false;
        }
        FACLConfig fACLConfig = (FACLConfig) obj;
        return this.f6420b == fACLConfig.f6420b && TextUtils.equals(this.f6421c, fACLConfig.f6421c) && this.f6422d == fACLConfig.f6422d && this.f6423e == fACLConfig.f6423e && this.f6424f == fACLConfig.f6424f && this.f6425g == fACLConfig.f6425g;
    }

    public int hashCode() {
        return zzw.a(new Object[]{Boolean.valueOf(this.f6420b), this.f6421c, Boolean.valueOf(this.f6422d), Boolean.valueOf(this.f6423e), Boolean.valueOf(this.f6424f), Boolean.valueOf(this.f6425g)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6419a);
        zzb.m12249a(parcel, 2, this.f6420b);
        zzb.m12247a(parcel, 3, this.f6421c, false);
        zzb.m12249a(parcel, 4, this.f6422d);
        zzb.m12249a(parcel, 5, this.f6423e);
        zzb.m12249a(parcel, 6, this.f6424f);
        zzb.m12249a(parcel, 7, this.f6425g);
        zzb.m12258c(parcel, a);
    }
}

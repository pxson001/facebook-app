package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class SignInButtonConfig implements SafeParcelable {
    public static final Creator<SignInButtonConfig> CREATOR = new zzaa();
    public final int f6550a;
    public final int f6551b;
    public final int f6552c;
    public final Scope[] f6553d;

    SignInButtonConfig(int i, int i2, int i3, Scope[] scopeArr) {
        this.f6550a = i;
        this.f6551b = i2;
        this.f6552c = i3;
        this.f6553d = scopeArr;
    }

    public SignInButtonConfig(int i, int i2, Scope[] scopeArr) {
        this(1, i, i2, scopeArr);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6550a);
        zzb.m12241a(parcel, 2, this.f6551b);
        zzb.m12241a(parcel, 3, this.f6552c);
        zzb.m12252a(parcel, 4, (Parcelable[]) this.f6553d, i, false);
        zzb.m12258c(parcel, a);
    }
}

package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class AuthAccountResult implements Result, SafeParcelable {
    public static final Creator<AuthAccountResult> CREATOR = new zza();
    public final int f7152a;
    public int f7153b;
    public Intent f7154c;

    public AuthAccountResult() {
        this(0, null);
    }

    AuthAccountResult(int i, int i2, Intent intent) {
        this.f7152a = i;
        this.f7153b = i2;
        this.f7154c = intent;
    }

    public AuthAccountResult(int i, Intent intent) {
        this(2, i, intent);
    }

    public final Status cp_() {
        return this.f7153b == 0 ? Status.a : Status.e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f7152a);
        zzb.m12241a(parcel, 2, this.f7153b);
        zzb.m12245a(parcel, 3, (Parcelable) this.f7154c, i, false);
        zzb.m12258c(parcel, a);
    }
}

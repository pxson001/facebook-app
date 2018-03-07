package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class GoogleNowAuthState implements SafeParcelable {
    public static final Creator<GoogleNowAuthState> CREATOR = new zza();
    public final int f20592a;
    public String f20593b;
    public String f20594c;
    public long f20595d;

    GoogleNowAuthState(int i, String str, String str2, long j) {
        this.f20592a = i;
        this.f20593b = str;
        this.f20594c = str2;
        this.f20595d = j;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "mAuthCode = " + this.f20593b + "\nmAccessToken = " + this.f20594c + "\nmNextAllowedTimeMillis = " + this.f20595d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f20593b, false);
        zzb.a(parcel, 1000, this.f20592a);
        zzb.a(parcel, 2, this.f20594c, false);
        zzb.a(parcel, 3, this.f20595d);
        zzb.c(parcel, a);
    }
}

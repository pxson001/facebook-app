package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class GetRecentContextCall$Request implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    public final int f20551a;
    public final Account f20552b;
    public final boolean f20553c;
    public final boolean f20554d;
    public final boolean f20555e;
    public final String f20556f;

    public GetRecentContextCall$Request() {
        this(null, false, false, false, null);
    }

    GetRecentContextCall$Request(int i, Account account, boolean z, boolean z2, boolean z3, String str) {
        this.f20551a = i;
        this.f20552b = account;
        this.f20553c = z;
        this.f20554d = z2;
        this.f20555e = z3;
        this.f20556f = str;
    }

    private GetRecentContextCall$Request(Account account, boolean z, boolean z2, boolean z3, String str) {
        this(1, account, z, z2, z3, str);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f20552b, i, false);
        zzb.a(parcel, 1000, this.f20551a);
        zzb.a(parcel, 2, this.f20553c);
        zzb.a(parcel, 3, this.f20554d);
        zzb.a(parcel, 4, this.f20555e);
        zzb.a(parcel, 5, this.f20556f, false);
        zzb.c(parcel, a);
    }
}

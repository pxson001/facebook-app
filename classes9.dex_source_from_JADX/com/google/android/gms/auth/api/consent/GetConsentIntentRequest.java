package com.google.android.gms.auth.api.consent;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;

public class GetConsentIntentRequest implements SafeParcelable {
    public static final Creator<GetConsentIntentRequest> CREATOR = new zzb();
    public final ScopeDetail[] f3578a;
    public final int f3579b;
    public final String f3580c;
    public final int f3581d;
    public final String f3582e;
    public final Account f3583f;
    public final boolean f3584g;
    public final int f3585h;
    public final String f3586i;

    GetConsentIntentRequest(int i, String str, int i2, String str2, Account account, ScopeDetail[] scopeDetailArr, boolean z, int i3, String str3) {
        this.f3579b = i;
        this.f3580c = str;
        this.f3581d = i2;
        this.f3582e = str2;
        this.f3583f = (Account) zzx.a(account);
        this.f3578a = scopeDetailArr;
        this.f3584g = z;
        this.f3585h = i3;
        this.f3586i = str3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f3579b);
        zzb.a(parcel, 2, this.f3580c, false);
        zzb.a(parcel, 3, this.f3581d);
        zzb.a(parcel, 4, this.f3582e, false);
        zzb.a(parcel, 5, this.f3583f, i, false);
        zzb.a(parcel, 6, this.f3578a, i, false);
        zzb.a(parcel, 7, this.f3584g);
        zzb.a(parcel, 8, this.f3585h);
        zzb.a(parcel, 9, this.f3586i, false);
        zzb.c(parcel, a);
    }
}

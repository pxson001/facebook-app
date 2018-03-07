package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class AccountChangeEventsRequest implements SafeParcelable {
    public static final Creator<AccountChangeEventsRequest> CREATOR = new zzb();
    public final int f6340a;
    public int f6341b;
    @Deprecated
    public String f6342c;
    public Account f6343d;

    public AccountChangeEventsRequest() {
        this.f6340a = 1;
    }

    AccountChangeEventsRequest(int i, int i2, String str, Account account) {
        this.f6340a = i;
        this.f6341b = i2;
        this.f6342c = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.f6343d = account;
        } else {
            this.f6343d = new Account(str, "com.google");
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6340a);
        zzb.m12241a(parcel, 2, this.f6341b);
        zzb.m12247a(parcel, 3, this.f6342c, false);
        zzb.m12245a(parcel, 4, this.f6343d, i, false);
        zzb.m12258c(parcel, a);
    }
}

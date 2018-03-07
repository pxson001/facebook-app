package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class ResolveAccountRequest implements SafeParcelable {
    public static final Creator<ResolveAccountRequest> CREATOR = new zzy();
    public final int f6541a;
    public final Account f6542b;
    public final int f6543c;
    public final GoogleSignInAccount f6544d;

    ResolveAccountRequest(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.f6541a = i;
        this.f6542b = account;
        this.f6543c = i2;
        this.f6544d = googleSignInAccount;
    }

    public ResolveAccountRequest(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6541a);
        zzb.m12245a(parcel, 2, (Parcelable) this.f6542b, i, false);
        zzb.m12241a(parcel, 3, this.f6543c);
        zzb.m12245a(parcel, 4, (Parcelable) this.f6544d, i, false);
        zzb.m12258c(parcel, a);
    }
}

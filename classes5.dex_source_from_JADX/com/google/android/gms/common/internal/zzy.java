package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzy implements Creator<ResolveAccountRequest> {
    public Object createFromParcel(Parcel parcel) {
        int b = zza.m12210b(parcel);
        int i = 0;
        Account account = null;
        int i2 = 0;
        GoogleSignInAccount googleSignInAccount = null;
        while (parcel.dataPosition() < b) {
            int a = zza.m12206a(parcel);
            switch (zza.m12205a(a)) {
                case 1:
                    i2 = zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    account = (Account) zza.m12207a(parcel, a, Account.CREATOR);
                    break;
                case 3:
                    i = zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    googleSignInAccount = (GoogleSignInAccount) zza.m12207a(parcel, a, GoogleSignInAccount.CREATOR);
                    break;
                default:
                    zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ResolveAccountRequest(i2, account, i, googleSignInAccount);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new ResolveAccountRequest[i];
    }
}

package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzf implements Creator<GetRecentContextCall$Request> {
    public Object createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int b = zza.b(parcel);
        boolean z2 = false;
        boolean z3 = false;
        Account account = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    account = (Account) zza.a(parcel, a, Account.CREATOR);
                    break;
                case 2:
                    z3 = zza.b(parcel, a);
                    break;
                case 3:
                    z2 = zza.b(parcel, a);
                    break;
                case 4:
                    z = zza.b(parcel, a);
                    break;
                case 5:
                    str = zza.n(parcel, a);
                    break;
                case 1000:
                    i = zza.e(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GetRecentContextCall$Request(i, account, z3, z2, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new GetRecentContextCall$Request[i];
    }
}

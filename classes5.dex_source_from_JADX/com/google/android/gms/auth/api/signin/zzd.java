package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

public class zzd implements Creator<GoogleSignInOptions> {
    public Object createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int b = zza.m12210b(parcel);
        boolean z2 = false;
        boolean z3 = false;
        Account account = null;
        ArrayList arrayList = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.m12206a(parcel);
            switch (zza.m12205a(a)) {
                case 1:
                    i = zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    arrayList = zza.m12215c(parcel, a, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) zza.m12207a(parcel, a, Account.CREATOR);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    z3 = zza.m12212b(parcel, a);
                    break;
                case 5:
                    z2 = zza.m12212b(parcel, a);
                    break;
                case 6:
                    z = zza.m12212b(parcel, a);
                    break;
                case 7:
                    str = zza.m12224n(parcel, a);
                    break;
                default:
                    zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GoogleSignInOptions(i, arrayList, account, z3, z2, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new GoogleSignInOptions[i];
    }
}

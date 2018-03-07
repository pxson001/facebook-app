package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzg implements Creator<RecordConsentRequest> {
    public Object createFromParcel(Parcel parcel) {
        int b = zza.m12210b(parcel);
        Scope[] scopeArr = null;
        Account account = null;
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = zza.m12206a(parcel);
            switch (zza.m12205a(a)) {
                case 1:
                    i = zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    account = (Account) zza.m12207a(parcel, a, Account.CREATOR);
                    break;
                case 3:
                    scopeArr = (Scope[]) zza.m12213b(parcel, a, Scope.CREATOR);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    str = zza.m12224n(parcel, a);
                    break;
                default:
                    zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new RecordConsentRequest(i, account, scopeArr, str);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new RecordConsentRequest[i];
    }
}

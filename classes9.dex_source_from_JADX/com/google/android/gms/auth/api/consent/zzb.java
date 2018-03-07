package com.google.android.gms.auth.api.consent;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<GetConsentIntentRequest> {
    public Object createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = zza.b(parcel);
        boolean z = false;
        ScopeDetail[] scopeDetailArr = null;
        Account account = null;
        String str2 = null;
        int i2 = 0;
        String str3 = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i3 = zza.e(parcel, a);
                    break;
                case 2:
                    str3 = zza.n(parcel, a);
                    break;
                case 3:
                    i2 = zza.e(parcel, a);
                    break;
                case 4:
                    str2 = zza.n(parcel, a);
                    break;
                case 5:
                    account = (Account) zza.a(parcel, a, Account.CREATOR);
                    break;
                case 6:
                    scopeDetailArr = (ScopeDetail[]) zza.b(parcel, a, ScopeDetail.CREATOR);
                    break;
                case 7:
                    z = zza.b(parcel, a);
                    break;
                case 8:
                    i = zza.e(parcel, a);
                    break;
                case 9:
                    str = zza.n(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GetConsentIntentRequest(i3, str3, i2, str2, account, scopeDetailArr, z, i, str);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new GetConsentIntentRequest[i];
    }
}

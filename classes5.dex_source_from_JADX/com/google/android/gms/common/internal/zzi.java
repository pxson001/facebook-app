package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzi implements Creator<GetServiceRequest> {
    public Object createFromParcel(Parcel parcel) {
        int i = 0;
        Account account = null;
        int b = zza.m12210b(parcel);
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.m12206a(parcel);
            switch (zza.m12205a(a)) {
                case 1:
                    i3 = zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    i2 = zza.m12217e(parcel, a);
                    break;
                case 3:
                    i = zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    str = zza.m12224n(parcel, a);
                    break;
                case 5:
                    iBinder = zza.m12225o(parcel, a);
                    break;
                case 6:
                    scopeArr = (Scope[]) zza.m12213b(parcel, a, Scope.CREATOR);
                    break;
                case 7:
                    bundle = zza.m12226p(parcel, a);
                    break;
                case 8:
                    account = (Account) zza.m12207a(parcel, a, Account.CREATOR);
                    break;
                default:
                    zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GetServiceRequest(i3, i2, i, str, iBinder, scopeArr, bundle, account);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new GetServiceRequest[i];
    }
}

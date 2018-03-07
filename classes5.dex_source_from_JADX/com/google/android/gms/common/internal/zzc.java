package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzc implements Creator<AuthAccountRequest> {
    public Object createFromParcel(Parcel parcel) {
        Scope[] scopeArr = null;
        int b = zza.m12210b(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < b) {
            int a = zza.m12206a(parcel);
            switch (zza.m12205a(a)) {
                case 1:
                    i = zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    iBinder = zza.m12225o(parcel, a);
                    break;
                case 3:
                    scopeArr = (Scope[]) zza.m12213b(parcel, a, Scope.CREATOR);
                    break;
                default:
                    zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AuthAccountRequest(i, iBinder, scopeArr);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new AuthAccountRequest[i];
    }
}

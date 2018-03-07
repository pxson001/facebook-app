package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzz implements Creator<ResolveAccountResponse> {
    public Object createFromParcel(Parcel parcel) {
        ConnectionResult connectionResult = null;
        boolean z = false;
        int b = zza.m12210b(parcel);
        boolean z2 = false;
        IBinder iBinder = null;
        int i = 0;
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
                    connectionResult = (ConnectionResult) zza.m12207a(parcel, a, ConnectionResult.CREATOR);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    z2 = zza.m12212b(parcel, a);
                    break;
                case 5:
                    z = zza.m12212b(parcel, a);
                    break;
                default:
                    zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ResolveAccountResponse(i, iBinder, connectionResult, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new ResolveAccountResponse[i];
    }
}

package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<FACLData> {
    public Object createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int b = zza.m12210b(parcel);
        String str2 = null;
        FACLConfig fACLConfig = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.m12206a(parcel);
            switch (zza.m12205a(a)) {
                case 1:
                    i = zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    fACLConfig = (FACLConfig) zza.m12207a(parcel, a, FACLConfig.CREATOR);
                    break;
                case 3:
                    str2 = zza.m12224n(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    z = zza.m12212b(parcel, a);
                    break;
                case 5:
                    str = zza.m12224n(parcel, a);
                    break;
                default:
                    zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new FACLData(i, fACLConfig, str2, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new FACLData[i];
    }
}

package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzd implements Creator<TokenData> {
    public Object createFromParcel(Parcel parcel) {
        List list = null;
        boolean z = false;
        int b = zza.m12210b(parcel);
        boolean z2 = false;
        Long l = null;
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.m12206a(parcel);
            switch (zza.m12205a(a)) {
                case 1:
                    i = zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    str = zza.m12224n(parcel, a);
                    break;
                case 3:
                    l = zza.m12219h(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    z2 = zza.m12212b(parcel, a);
                    break;
                case 5:
                    z = zza.m12212b(parcel, a);
                    break;
                case 6:
                    list = zza.m12201A(parcel, a);
                    break;
                default:
                    zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new TokenData(i, str, l, z2, z, list);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new TokenData[i];
    }
}

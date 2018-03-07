package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzf implements Creator<AmsEntityUpdateParcelable> {
    public Object createFromParcel(Parcel parcel) {
        byte b = (byte) 0;
        int b2 = zza.b(parcel);
        String str = null;
        byte b3 = (byte) 0;
        int i = 0;
        while (parcel.dataPosition() < b2) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i = zza.e(parcel, a);
                    break;
                case 2:
                    b3 = zza.c(parcel, a);
                    break;
                case 3:
                    b = zza.c(parcel, a);
                    break;
                case 4:
                    str = zza.n(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b2) {
            return new AmsEntityUpdateParcelable(i, b3, b, str);
        }
        throw new zza.zza("Overread allowed size end=" + b2, parcel);
    }

    public Object[] newArray(int i) {
        return new AmsEntityUpdateParcelable[i];
    }
}

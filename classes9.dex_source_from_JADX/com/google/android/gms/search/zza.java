package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class zza implements Creator<GoogleNowAuthState> {
    public Object createFromParcel(Parcel parcel) {
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        long j = 0;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a)) {
                case 1:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a);
                    break;
                case 3:
                    j = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GoogleNowAuthState(i, str2, str, j);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new GoogleNowAuthState[i];
    }
}

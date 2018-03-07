package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class zza implements Creator<ApplicationStatus> {
    public Object createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ApplicationStatus(i, str);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new ApplicationStatus[i];
    }
}

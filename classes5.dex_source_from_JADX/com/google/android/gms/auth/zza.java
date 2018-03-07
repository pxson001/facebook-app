package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;

public class zza implements Creator<AccountChangeEvent> {
    public Object createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.m12210b(parcel);
        long j = 0;
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = com.google.android.gms.common.internal.safeparcel.zza.m12206a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.m12205a(a)) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    j = com.google.android.gms.common.internal.safeparcel.zza.m12218g(parcel, a);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.m12224n(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.m12217e(parcel, a);
                    break;
                case 5:
                    i = com.google.android.gms.common.internal.safeparcel.zza.m12217e(parcel, a);
                    break;
                case 6:
                    str = com.google.android.gms.common.internal.safeparcel.zza.m12224n(parcel, a);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AccountChangeEvent(i3, j, str2, i2, i, str);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new AccountChangeEvent[i];
    }
}

package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;

public class zza implements Creator<FACLConfig> {
    public Object createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.m12210b(parcel);
        String str = null;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = com.google.android.gms.common.internal.safeparcel.zza.m12206a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.m12205a(a)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    z5 = com.google.android.gms.common.internal.safeparcel.zza.m12212b(parcel, a);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.m12224n(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    z4 = com.google.android.gms.common.internal.safeparcel.zza.m12212b(parcel, a);
                    break;
                case 5:
                    z3 = com.google.android.gms.common.internal.safeparcel.zza.m12212b(parcel, a);
                    break;
                case 6:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.m12212b(parcel, a);
                    break;
                case 7:
                    z = com.google.android.gms.common.internal.safeparcel.zza.m12212b(parcel, a);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new FACLConfig(i, z5, str, z4, z3, z2, z);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new FACLConfig[i];
    }
}

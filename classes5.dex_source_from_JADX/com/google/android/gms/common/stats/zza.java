package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;

public class zza implements Creator<ConnectionEvent> {
    private static ConnectionEvent m12448a(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.m12210b(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        long j2 = 0;
        long j3 = 0;
        while (parcel.dataPosition() < b) {
            int a = com.google.android.gms.common.internal.safeparcel.zza.m12206a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.m12205a(a)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    j = com.google.android.gms.common.internal.safeparcel.zza.m12218g(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    str = com.google.android.gms.common.internal.safeparcel.zza.m12224n(parcel, a);
                    break;
                case 5:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.m12224n(parcel, a);
                    break;
                case 6:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.m12224n(parcel, a);
                    break;
                case 7:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.m12224n(parcel, a);
                    break;
                case 8:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.m12224n(parcel, a);
                    break;
                case 10:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.m12218g(parcel, a);
                    break;
                case 11:
                    j3 = com.google.android.gms.common.internal.safeparcel.zza.m12218g(parcel, a);
                    break;
                case 12:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.m12217e(parcel, a);
                    break;
                case 13:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.m12224n(parcel, a);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionEvent(i, j, i2, str, str2, str3, str4, str5, str6, j2, j3);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m12448a(parcel);
    }

    public Object[] newArray(int i) {
        return new ConnectionEvent[i];
    }
}

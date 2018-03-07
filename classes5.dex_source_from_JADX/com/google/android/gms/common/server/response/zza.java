package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;

public class zza implements Creator<Field> {
    public Object createFromParcel(Parcel parcel) {
        ConverterWrapper converterWrapper = null;
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.m12210b(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a = com.google.android.gms.common.internal.safeparcel.zza.m12206a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.m12205a(a)) {
                case 1:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.m12217e(parcel, a);
                    break;
                case 3:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.m12212b(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.m12217e(parcel, a);
                    break;
                case 5:
                    z = com.google.android.gms.common.internal.safeparcel.zza.m12212b(parcel, a);
                    break;
                case 6:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.m12224n(parcel, a);
                    break;
                case 7:
                    i = com.google.android.gms.common.internal.safeparcel.zza.m12217e(parcel, a);
                    break;
                case 8:
                    str = com.google.android.gms.common.internal.safeparcel.zza.m12224n(parcel, a);
                    break;
                case 9:
                    converterWrapper = (ConverterWrapper) com.google.android.gms.common.internal.safeparcel.zza.m12207a(parcel, a, ConverterWrapper.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Field(i4, i3, z2, i2, z, str2, i, str, converterWrapper);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new Field[i];
    }
}

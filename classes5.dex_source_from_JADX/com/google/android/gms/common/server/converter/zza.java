package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;

public class zza implements Creator<ConverterWrapper> {
    public Object createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.m12210b(parcel);
        int i = 0;
        StringToIntConverter stringToIntConverter = null;
        while (parcel.dataPosition() < b) {
            int a = com.google.android.gms.common.internal.safeparcel.zza.m12206a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.m12205a(a)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    stringToIntConverter = (StringToIntConverter) com.google.android.gms.common.internal.safeparcel.zza.m12207a(parcel, a, StringToIntConverter.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ConverterWrapper(i, stringToIntConverter);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new ConverterWrapper[i];
    }
}

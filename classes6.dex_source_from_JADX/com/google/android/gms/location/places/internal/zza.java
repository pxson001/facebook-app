package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.places.internal.AutocompletePredictionEntity.SubstringEntity;
import java.util.List;

public class zza implements Creator<AutocompletePredictionEntity> {
    public Object createFromParcel(Parcel parcel) {
        int i = 0;
        List list = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        String str = null;
        List list2 = null;
        String str2 = null;
        List list3 = null;
        String str3 = null;
        List list4 = null;
        String str4 = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a)) {
                case 1:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a);
                    break;
                case 2:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a);
                    break;
                case 3:
                    list4 = com.google.android.gms.common.internal.safeparcel.zza.z(parcel, a);
                    break;
                case 4:
                    list3 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a, SubstringEntity.CREATOR);
                    break;
                case 5:
                    i = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a);
                    break;
                case 6:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a);
                    break;
                case 7:
                    list2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a, SubstringEntity.CREATOR);
                    break;
                case 8:
                    str = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a);
                    break;
                case 9:
                    list = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a, SubstringEntity.CREATOR);
                    break;
                case 1000:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AutocompletePredictionEntity(i2, str4, list4, i, str3, list3, str2, list2, str, list);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new AutocompletePredictionEntity[i];
    }
}

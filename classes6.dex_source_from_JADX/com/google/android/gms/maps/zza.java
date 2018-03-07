package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.CameraPosition;

public class zza implements Creator<GoogleMapOptions> {
    public static GoogleMapOptions m9943a(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        byte b2 = (byte) -1;
        byte b3 = (byte) -1;
        int i2 = 0;
        CameraPosition cameraPosition = null;
        byte b4 = (byte) -1;
        byte b5 = (byte) -1;
        byte b6 = (byte) -1;
        byte b7 = (byte) -1;
        byte b8 = (byte) -1;
        byte b9 = (byte) -1;
        byte b10 = (byte) -1;
        byte b11 = (byte) -1;
        byte b12 = (byte) -1;
        while (parcel.dataPosition() < b) {
            int a = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a);
                    break;
                case 2:
                    b2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a);
                    break;
                case 3:
                    b3 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a, CameraPosition.CREATOR);
                    break;
                case 6:
                    b4 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a);
                    break;
                case 7:
                    b5 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a);
                    break;
                case 8:
                    b6 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a);
                    break;
                case 9:
                    b7 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a);
                    break;
                case 10:
                    b8 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a);
                    break;
                case 11:
                    b9 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a);
                    break;
                case 12:
                    b10 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a);
                    break;
                case 14:
                    b11 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a);
                    break;
                case 15:
                    b12 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GoogleMapOptions(i, b2, b3, i2, cameraPosition, b4, b5, b6, b7, b8, b9, b10, b11, b12);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9943a(parcel);
    }

    public Object[] newArray(int i) {
        return new GoogleMapOptions[i];
    }
}

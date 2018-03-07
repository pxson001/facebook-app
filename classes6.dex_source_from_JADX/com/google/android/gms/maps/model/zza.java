package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class zza implements Creator<CameraPosition> {
    public static CameraPosition m9928a(Parcel parcel) {
        float f = 0.0f;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        LatLng latLng = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (parcel.dataPosition() < b) {
            int a = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a);
                    break;
                case 2:
                    latLng = (LatLng) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a, LatLng.CREATOR);
                    break;
                case 3:
                    f3 = com.google.android.gms.common.internal.safeparcel.zza.j(parcel, a);
                    break;
                case 4:
                    f2 = com.google.android.gms.common.internal.safeparcel.zza.j(parcel, a);
                    break;
                case 5:
                    f = com.google.android.gms.common.internal.safeparcel.zza.j(parcel, a);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new CameraPosition(i, latLng, f3, f2, f);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9928a(parcel);
    }

    public Object[] newArray(int i) {
        return new CameraPosition[i];
    }
}

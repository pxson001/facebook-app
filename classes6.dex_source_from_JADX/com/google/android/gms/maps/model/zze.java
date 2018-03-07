package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zze implements Creator<LatLng> {
    public static LatLng m9932a(Parcel parcel) {
        double d = 0.0d;
        int b = zza.b(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i = zza.e(parcel, a);
                    break;
                case 2:
                    d2 = zza.l(parcel, a);
                    break;
                case 3:
                    d = zza.l(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new LatLng(i, d2, d);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9932a(parcel);
    }

    public Object[] newArray(int i) {
        return new LatLng[i];
    }
}

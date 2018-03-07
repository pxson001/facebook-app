package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzd implements Creator<LatLngBounds> {
    public static LatLngBounds m9931a(Parcel parcel) {
        int b = zza.b(parcel);
        LatLng latLng = null;
        int i = 0;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i = zza.e(parcel, a);
                    break;
                case 2:
                    latLng = (LatLng) zza.a(parcel, a, LatLng.CREATOR);
                    break;
                case 3:
                    latLng2 = (LatLng) zza.a(parcel, a, LatLng.CREATOR);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new LatLngBounds(i, latLng, latLng2);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9931a(parcel);
    }

    public Object[] newArray(int i) {
        return new LatLngBounds[i];
    }
}

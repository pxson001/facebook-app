package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzp implements Creator<VisibleRegion> {
    public static VisibleRegion m9942a(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int b = zza.b(parcel);
        int i = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i = zza.e(parcel, a);
                    break;
                case 2:
                    latLng4 = (LatLng) zza.a(parcel, a, LatLng.CREATOR);
                    break;
                case 3:
                    latLng3 = (LatLng) zza.a(parcel, a, LatLng.CREATOR);
                    break;
                case 4:
                    latLng2 = (LatLng) zza.a(parcel, a, LatLng.CREATOR);
                    break;
                case 5:
                    latLng = (LatLng) zza.a(parcel, a, LatLng.CREATOR);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) zza.a(parcel, a, LatLngBounds.CREATOR);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new VisibleRegion(i, latLng4, latLng3, latLng2, latLng, latLngBounds);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9942a(parcel);
    }

    public Object[] newArray(int i) {
        return new VisibleRegion[i];
    }
}

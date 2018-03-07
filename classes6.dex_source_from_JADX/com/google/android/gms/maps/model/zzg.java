package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzg implements Creator<PointOfInterest> {
    public static PointOfInterest m9934a(Parcel parcel) {
        int b = zza.b(parcel);
        String str = null;
        LatLng latLng = null;
        int i = 0;
        String str2 = null;
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
                    str = zza.n(parcel, a);
                    break;
                case 4:
                    str2 = zza.n(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new PointOfInterest(i, latLng, str, str2);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9934a(parcel);
    }

    public Object[] newArray(int i) {
        return new PointOfInterest[i];
    }
}

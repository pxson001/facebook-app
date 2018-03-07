package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zze implements Creator<NearbyAlertRequest> {
    public static NearbyAlertRequest m9130a(Parcel parcel) {
        NearbyAlertFilter nearbyAlertFilter = null;
        int i = 0;
        int b = zza.b(parcel);
        int i2 = -1;
        boolean z = false;
        PlaceFilter placeFilter = null;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i3 = zza.e(parcel, a);
                    break;
                case 2:
                    i2 = zza.e(parcel, a);
                    break;
                case 3:
                    placeFilter = (PlaceFilter) zza.a(parcel, a, PlaceFilter.CREATOR);
                    break;
                case 4:
                    nearbyAlertFilter = (NearbyAlertFilter) zza.a(parcel, a, NearbyAlertFilter.CREATOR);
                    break;
                case 5:
                    z = zza.b(parcel, a);
                    break;
                case 6:
                    i = zza.e(parcel, a);
                    break;
                case 1000:
                    i4 = zza.e(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new NearbyAlertRequest(i4, i3, i2, placeFilter, nearbyAlertFilter, z, i);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9130a(parcel);
    }

    public Object[] newArray(int i) {
        return new NearbyAlertRequest[i];
    }
}

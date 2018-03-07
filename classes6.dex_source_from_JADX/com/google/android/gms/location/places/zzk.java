package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzk implements Creator<PlaceRequest> {
    public Object createFromParcel(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        PlaceFilter placeFilter = null;
        long j = PlaceRequest.f6461a;
        int i2 = 102;
        long j2 = Long.MAX_VALUE;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 2:
                    placeFilter = (PlaceFilter) zza.a(parcel, a, PlaceFilter.CREATOR);
                    break;
                case 3:
                    j = zza.g(parcel, a);
                    break;
                case 4:
                    i2 = zza.e(parcel, a);
                    break;
                case 5:
                    j2 = zza.g(parcel, a);
                    break;
                case 1000:
                    i = zza.e(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new PlaceRequest(i, placeFilter, j, i2, j2);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new PlaceRequest[i];
    }
}

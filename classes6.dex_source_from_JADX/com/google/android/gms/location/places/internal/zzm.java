package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzm implements Creator<PlaceLikelihoodEntity> {
    public Object createFromParcel(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        PlaceImpl placeImpl = null;
        float f = 0.0f;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    placeImpl = (PlaceImpl) zza.a(parcel, a, PlaceImpl.CREATOR);
                    break;
                case 2:
                    f = zza.j(parcel, a);
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
            return new PlaceLikelihoodEntity(i, placeImpl, f);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new PlaceLikelihoodEntity[i];
    }
}

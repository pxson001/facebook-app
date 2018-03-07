package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzm implements Creator<StreetViewPanoramaOrientation> {
    public static StreetViewPanoramaOrientation m9939a(Parcel parcel) {
        float f = 0.0f;
        int b = zza.b(parcel);
        int i = 0;
        float f2 = 0.0f;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i = zza.e(parcel, a);
                    break;
                case 2:
                    f2 = zza.j(parcel, a);
                    break;
                case 3:
                    f = zza.j(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new StreetViewPanoramaOrientation(i, f2, f);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9939a(parcel);
    }

    public Object[] newArray(int i) {
        return new StreetViewPanoramaOrientation[i];
    }
}

package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class zzb implements Creator<StreetViewPanoramaOptions> {
    public static StreetViewPanoramaOptions m9944a(Parcel parcel) {
        Integer num = null;
        byte b = (byte) 0;
        int b2 = zza.b(parcel);
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        byte b6 = (byte) 0;
        LatLng latLng = null;
        String str = null;
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        int i = 0;
        while (parcel.dataPosition() < b2) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i = zza.e(parcel, a);
                    break;
                case 2:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) zza.a(parcel, a, StreetViewPanoramaCamera.CREATOR);
                    break;
                case 3:
                    str = zza.n(parcel, a);
                    break;
                case 4:
                    latLng = (LatLng) zza.a(parcel, a, LatLng.CREATOR);
                    break;
                case 5:
                    Integer num2;
                    int D = zza.D(parcel, a);
                    if (D == 0) {
                        num2 = null;
                    } else {
                        zza.b(parcel, D, 4);
                        num2 = Integer.valueOf(parcel.readInt());
                    }
                    num = num2;
                    break;
                case 6:
                    b6 = zza.c(parcel, a);
                    break;
                case 7:
                    b5 = zza.c(parcel, a);
                    break;
                case 8:
                    b4 = zza.c(parcel, a);
                    break;
                case 9:
                    b3 = zza.c(parcel, a);
                    break;
                case 10:
                    b = zza.c(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b2) {
            return new StreetViewPanoramaOptions(i, streetViewPanoramaCamera, str, latLng, num, b6, b5, b4, b3, b);
        }
        throw new zza.zza("Overread allowed size end=" + b2, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9944a(parcel);
    }

    public Object[] newArray(int i) {
        return new StreetViewPanoramaOptions[i];
    }
}

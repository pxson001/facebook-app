package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzj implements Creator<StreetViewPanoramaCamera> {
    public static StreetViewPanoramaCamera m9937a(Parcel parcel) {
        float f = 0.0f;
        int b = zza.b(parcel);
        float f2 = 0.0f;
        int i = 0;
        float f3 = 0.0f;
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
                    f3 = zza.j(parcel, a);
                    break;
                case 4:
                    f = zza.j(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new StreetViewPanoramaCamera(i, f2, f3, f);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9937a(parcel);
    }

    public Object[] newArray(int i) {
        return new StreetViewPanoramaCamera[i];
    }
}

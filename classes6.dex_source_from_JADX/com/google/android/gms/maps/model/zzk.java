package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzk implements Creator<StreetViewPanoramaLink> {
    public Object createFromParcel(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        String str = null;
        float f = 0.0f;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i = zza.e(parcel, a);
                    break;
                case 2:
                    str = zza.n(parcel, a);
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
            return new StreetViewPanoramaLink(i, str, f);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new StreetViewPanoramaLink[i];
    }
}

package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<CircleOptions> {
    public static CircleOptions m9929a(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int b = zza.b(parcel);
        LatLng latLng = null;
        double d = 0.0d;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i3 = zza.e(parcel, a);
                    break;
                case 2:
                    latLng = (LatLng) zza.a(parcel, a, LatLng.CREATOR);
                    break;
                case 3:
                    d = zza.l(parcel, a);
                    break;
                case 4:
                    f2 = zza.j(parcel, a);
                    break;
                case 5:
                    i2 = zza.e(parcel, a);
                    break;
                case 6:
                    i = zza.e(parcel, a);
                    break;
                case 7:
                    f = zza.j(parcel, a);
                    break;
                case 8:
                    z = zza.b(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new CircleOptions(i3, latLng, d, f2, i2, i, f, z);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9929a(parcel);
    }

    public Object[] newArray(int i) {
        return new CircleOptions[i];
    }
}

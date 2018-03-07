package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzi implements Creator<PolylineOptions> {
    public static PolylineOptions m9936a(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int b = zza.b(parcel);
        List list = null;
        boolean z2 = false;
        int i = 0;
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i2 = zza.e(parcel, a);
                    break;
                case 2:
                    list = zza.c(parcel, a, LatLng.CREATOR);
                    break;
                case 3:
                    f2 = zza.j(parcel, a);
                    break;
                case 4:
                    i = zza.e(parcel, a);
                    break;
                case 5:
                    f = zza.j(parcel, a);
                    break;
                case 6:
                    z2 = zza.b(parcel, a);
                    break;
                case 7:
                    z = zza.b(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new PolylineOptions(i2, list, f2, i, f, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9936a(parcel);
    }

    public Object[] newArray(int i) {
        return new PolylineOptions[i];
    }
}

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzf implements Creator<MarkerOptions> {
    public static MarkerOptions m9933a(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = 0.0f;
        float f6 = 1.0f;
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
                case 5:
                    iBinder = zza.o(parcel, a);
                    break;
                case 6:
                    f = zza.j(parcel, a);
                    break;
                case 7:
                    f2 = zza.j(parcel, a);
                    break;
                case 8:
                    z = zza.b(parcel, a);
                    break;
                case 9:
                    z2 = zza.b(parcel, a);
                    break;
                case 10:
                    z3 = zza.b(parcel, a);
                    break;
                case 11:
                    f3 = zza.j(parcel, a);
                    break;
                case 12:
                    f4 = zza.j(parcel, a);
                    break;
                case 13:
                    f5 = zza.j(parcel, a);
                    break;
                case 14:
                    f6 = zza.j(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new MarkerOptions(i, latLng, str, str2, iBinder, f, f2, z, z2, z3, f3, f4, f5, f6);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9933a(parcel);
    }

    public Object[] newArray(int i) {
        return new MarkerOptions[i];
    }
}

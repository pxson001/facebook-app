package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzc implements Creator<GroundOverlayOptions> {
    public static GroundOverlayOptions m9930a(Parcel parcel) {
        boolean z = false;
        LatLngBounds latLngBounds = null;
        float f = 0.0f;
        int b = zza.b(parcel);
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        LatLng latLng = null;
        IBinder iBinder = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i = zza.e(parcel, a);
                    break;
                case 2:
                    iBinder = zza.o(parcel, a);
                    break;
                case 3:
                    latLng = (LatLng) zza.a(parcel, a, LatLng.CREATOR);
                    break;
                case 4:
                    f7 = zza.j(parcel, a);
                    break;
                case 5:
                    f6 = zza.j(parcel, a);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) zza.a(parcel, a, LatLngBounds.CREATOR);
                    break;
                case 7:
                    f5 = zza.j(parcel, a);
                    break;
                case 8:
                    f4 = zza.j(parcel, a);
                    break;
                case 9:
                    z = zza.b(parcel, a);
                    break;
                case 10:
                    f3 = zza.j(parcel, a);
                    break;
                case 11:
                    f2 = zza.j(parcel, a);
                    break;
                case 12:
                    f = zza.j(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GroundOverlayOptions(i, iBinder, latLng, f7, f6, latLngBounds, f5, f4, z, f3, f2, f);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9930a(parcel);
    }

    public Object[] newArray(int i) {
        return new GroundOverlayOptions[i];
    }
}

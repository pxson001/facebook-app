package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzo implements Creator<TileOverlayOptions> {
    public static TileOverlayOptions m9941a(Parcel parcel) {
        boolean z = false;
        int b = zza.b(parcel);
        IBinder iBinder = null;
        float f = 0.0f;
        boolean z2 = true;
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
                    z = zza.b(parcel, a);
                    break;
                case 4:
                    f = zza.j(parcel, a);
                    break;
                case 5:
                    z2 = zza.b(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new TileOverlayOptions(i, iBinder, z, f, z2);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9941a(parcel);
    }

    public Object[] newArray(int i) {
        return new TileOverlayOptions[i];
    }
}

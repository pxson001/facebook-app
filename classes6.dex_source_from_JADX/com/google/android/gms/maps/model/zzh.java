package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.List;

public class zzh implements Creator<PolygonOptions> {
    public final PolygonOptions m9935a(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int b = zza.b(parcel);
        List list = null;
        List arrayList = new ArrayList();
        boolean z2 = false;
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
                    list = zza.c(parcel, a, LatLng.CREATOR);
                    break;
                case 3:
                    ClassLoader classLoader = getClass().getClassLoader();
                    int D = zza.D(parcel, a);
                    int dataPosition = parcel.dataPosition();
                    if (D != 0) {
                        parcel.readList(arrayList, classLoader);
                        parcel.setDataPosition(D + dataPosition);
                    }
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
                    z2 = zza.b(parcel, a);
                    break;
                case 9:
                    z = zza.b(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new PolygonOptions(i3, list, arrayList, f2, i2, i, f, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9935a(parcel);
    }

    public Object[] newArray(int i) {
        return new PolygonOptions[i];
    }
}

package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzg implements Creator<PlaceFilter> {
    public static PlaceFilter m9131a(Parcel parcel) {
        boolean z = false;
        List list = null;
        int b = zza.b(parcel);
        List list2 = null;
        List list3 = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    list3 = zza.z(parcel, a);
                    break;
                case 3:
                    z = zza.b(parcel, a);
                    break;
                case 4:
                    list = zza.c(parcel, a, UserDataType.CREATOR);
                    break;
                case 6:
                    list2 = zza.A(parcel, a);
                    break;
                case 1000:
                    i = zza.e(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new PlaceFilter(i, list3, z, list2, list);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9131a(parcel);
    }

    public Object[] newArray(int i) {
        return new PlaceFilter[i];
    }
}

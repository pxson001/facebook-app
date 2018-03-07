package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzd implements Creator<NearbyAlertFilter> {
    public Object createFromParcel(Parcel parcel) {
        List list = null;
        int b = zza.b(parcel);
        List list2 = null;
        int i = 0;
        List list3 = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    list2 = zza.A(parcel, a);
                    break;
                case 2:
                    list3 = zza.z(parcel, a);
                    break;
                case 3:
                    list = zza.c(parcel, a, UserDataType.CREATOR);
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
            return new NearbyAlertFilter(i, list2, list3, list);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new NearbyAlertFilter[i];
    }
}

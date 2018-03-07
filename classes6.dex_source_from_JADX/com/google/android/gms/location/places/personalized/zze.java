package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zze implements Creator<PlaceUserData> {
    public Object createFromParcel(Parcel parcel) {
        List list = null;
        int b = zza.b(parcel);
        String str = null;
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    str = zza.n(parcel, a);
                    break;
                case 2:
                    str2 = zza.n(parcel, a);
                    break;
                case 6:
                    list = zza.c(parcel, a, PlaceAlias.CREATOR);
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
            return new PlaceUserData(i, str, str2, list);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new PlaceUserData[i];
    }
}

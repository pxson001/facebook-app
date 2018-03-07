package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzo implements Creator<PlaceLocalization> {
    public Object createFromParcel(Parcel parcel) {
        List list = null;
        int b = zza.b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    str4 = zza.n(parcel, a);
                    break;
                case 2:
                    str3 = zza.n(parcel, a);
                    break;
                case 3:
                    str2 = zza.n(parcel, a);
                    break;
                case 4:
                    str = zza.n(parcel, a);
                    break;
                case 5:
                    list = zza.A(parcel, a);
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
            return new PlaceLocalization(i, str4, str3, str2, str, list);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new PlaceLocalization[i];
    }
}

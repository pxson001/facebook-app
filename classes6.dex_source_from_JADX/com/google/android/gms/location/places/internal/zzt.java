package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzt implements Creator<PlacesParams> {
    public static PlacesParams m9123a(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = zza.b(parcel);
        int i2 = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
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
                case 6:
                    i2 = zza.e(parcel, a);
                    break;
                case 7:
                    i = zza.e(parcel, a);
                    break;
                case 1000:
                    i3 = zza.e(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new PlacesParams(i3, str4, str3, str2, str, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9123a(parcel);
    }

    public Object[] newArray(int i) {
        return new PlacesParams[i];
    }
}

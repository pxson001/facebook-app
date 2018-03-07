package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzb implements Creator<CastDevice> {
    public Object createFromParcel(Parcel parcel) {
        int i = 0;
        List list = null;
        int b = zza.b(parcel);
        int i2 = 0;
        int i3 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i4 = zza.e(parcel, a);
                    break;
                case 2:
                    str5 = zza.n(parcel, a);
                    break;
                case 3:
                    str4 = zza.n(parcel, a);
                    break;
                case 4:
                    str3 = zza.n(parcel, a);
                    break;
                case 5:
                    str2 = zza.n(parcel, a);
                    break;
                case 6:
                    str = zza.n(parcel, a);
                    break;
                case 7:
                    i3 = zza.e(parcel, a);
                    break;
                case 8:
                    list = zza.c(parcel, a, WebImage.CREATOR);
                    break;
                case 9:
                    i2 = zza.e(parcel, a);
                    break;
                case 10:
                    i = zza.e(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new CastDevice(i4, str5, str4, str3, str2, str, i3, list, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new CastDevice[i];
    }
}

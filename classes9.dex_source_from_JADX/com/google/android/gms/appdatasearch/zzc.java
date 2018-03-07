package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzc implements Creator<DocumentId> {
    public Object createFromParcel(Parcel parcel) {
        String str = null;
        int b = zza.b(parcel);
        String str2 = null;
        int i = 0;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    str2 = zza.n(parcel, a);
                    break;
                case 2:
                    str3 = zza.n(parcel, a);
                    break;
                case 3:
                    str = zza.n(parcel, a);
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
            return new DocumentId(i, str2, str3, str);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new DocumentId[i];
    }
}

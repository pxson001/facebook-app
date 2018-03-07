package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzd implements Creator<DocumentSection> {
    public Object createFromParcel(Parcel parcel) {
        byte[] bArr = null;
        int b = zza.b(parcel);
        int i = 0;
        int i2 = -1;
        RegisterSectionInfo registerSectionInfo = null;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    str = zza.n(parcel, a);
                    break;
                case 3:
                    registerSectionInfo = (RegisterSectionInfo) zza.a(parcel, a, RegisterSectionInfo.CREATOR);
                    break;
                case 4:
                    i2 = zza.e(parcel, a);
                    break;
                case 5:
                    bArr = zza.q(parcel, a);
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
            return new DocumentSection(i, str, registerSectionInfo, i2, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new DocumentSection[i];
    }
}

package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzi implements Creator<RegisterSectionInfo> {
    public Object createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int b = zza.b(parcel);
        int i = 1;
        int[] iArr = null;
        Feature[] featureArr = null;
        String str2 = null;
        boolean z2 = false;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
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
                    z2 = zza.b(parcel, a);
                    break;
                case 4:
                    i = zza.e(parcel, a);
                    break;
                case 5:
                    z = zza.b(parcel, a);
                    break;
                case 6:
                    str2 = zza.n(parcel, a);
                    break;
                case 7:
                    featureArr = (Feature[]) zza.b(parcel, a, Feature.CREATOR);
                    break;
                case 8:
                    iArr = zza.s(parcel, a);
                    break;
                case 11:
                    str = zza.n(parcel, a);
                    break;
                case 1000:
                    i2 = zza.e(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new RegisterSectionInfo(i2, str4, str3, z2, i, z, str2, featureArr, iArr, str);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new RegisterSectionInfo[i];
    }
}

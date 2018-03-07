package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzg implements Creator<ConnectionConfiguration> {
    public Object createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int b = zza.b(parcel);
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        int i2 = 0;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i3 = zza.e(parcel, a);
                    break;
                case 2:
                    str4 = zza.n(parcel, a);
                    break;
                case 3:
                    str3 = zza.n(parcel, a);
                    break;
                case 4:
                    i2 = zza.e(parcel, a);
                    break;
                case 5:
                    i = zza.e(parcel, a);
                    break;
                case 6:
                    z3 = zza.b(parcel, a);
                    break;
                case 7:
                    z2 = zza.b(parcel, a);
                    break;
                case 8:
                    str2 = zza.n(parcel, a);
                    break;
                case 9:
                    z = zza.b(parcel, a);
                    break;
                case 10:
                    str = zza.n(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionConfiguration(i3, str4, str3, i2, i, z3, z2, str2, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new ConnectionConfiguration[i];
    }
}

package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzh implements Creator<LocationSettingsStates> {
    public Object createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = zza.b(parcel);
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    z6 = zza.b(parcel, a);
                    break;
                case 2:
                    z5 = zza.b(parcel, a);
                    break;
                case 3:
                    z4 = zza.b(parcel, a);
                    break;
                case 4:
                    z3 = zza.b(parcel, a);
                    break;
                case 5:
                    z2 = zza.b(parcel, a);
                    break;
                case 6:
                    z = zza.b(parcel, a);
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
            return new LocationSettingsStates(i, z6, z5, z4, z3, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new LocationSettingsStates[i];
    }
}

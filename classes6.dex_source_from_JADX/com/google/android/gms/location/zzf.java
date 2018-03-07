package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzf implements Creator<LocationSettingsRequest> {
    public Object createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = zza.b(parcel);
        List list = null;
        int i = 0;
        boolean z2 = false;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    list = zza.c(parcel, a, LocationRequest.CREATOR);
                    break;
                case 2:
                    z2 = zza.b(parcel, a);
                    break;
                case 3:
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
            return new LocationSettingsRequest(i, list, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new LocationSettingsRequest[i];
    }
}

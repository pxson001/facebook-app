package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class LocationRequestCreator implements Creator<LocationRequest> {
    public static LocationRequest m8854a(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        int i2 = 102;
        long j = 3600000;
        long j2 = 600000;
        boolean z = false;
        long j3 = Long.MAX_VALUE;
        int i3 = Integer.MAX_VALUE;
        float f = 0.0f;
        long j4 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i2 = zza.e(parcel, a);
                    break;
                case 2:
                    j = zza.g(parcel, a);
                    break;
                case 3:
                    j2 = zza.g(parcel, a);
                    break;
                case 4:
                    z = zza.b(parcel, a);
                    break;
                case 5:
                    j3 = zza.g(parcel, a);
                    break;
                case 6:
                    i3 = zza.e(parcel, a);
                    break;
                case 7:
                    f = zza.j(parcel, a);
                    break;
                case 8:
                    j4 = zza.g(parcel, a);
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
            return new LocationRequest(i, i2, j, j2, z, j3, i3, f, j4);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8854a(parcel);
    }

    public Object[] newArray(int i) {
        return new LocationRequest[i];
    }
}

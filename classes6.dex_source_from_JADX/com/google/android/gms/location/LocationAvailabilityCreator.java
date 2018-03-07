package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class LocationAvailabilityCreator implements Creator<LocationAvailability> {
    public static LocationAvailability m8847a(Parcel parcel) {
        int i = 1;
        int b = zza.b(parcel);
        int i2 = 0;
        int i3 = 1000;
        long j = 0;
        int i4 = 1;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i4 = zza.e(parcel, a);
                    break;
                case 2:
                    i = zza.e(parcel, a);
                    break;
                case 3:
                    j = zza.g(parcel, a);
                    break;
                case 4:
                    i3 = zza.e(parcel, a);
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
            return new LocationAvailability(i2, i3, i4, i, j);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8847a(parcel);
    }

    public Object[] newArray(int i) {
        return new LocationAvailability[i];
    }
}

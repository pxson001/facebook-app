package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.List;

public class zza implements Creator<GeofencingRequest> {
    public Object createFromParcel(Parcel parcel) {
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a)) {
                case 1:
                    list = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a, ParcelableGeofence.CREATOR);
                    break;
                case 2:
                    i = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a);
                    break;
                case 1000:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GeofencingRequest(i2, list, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new GeofencingRequest[i];
    }
}

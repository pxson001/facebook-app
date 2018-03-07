package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public class zzm implements Creator<LocationRequestInternal> {
    public static LocationRequestInternal m8951a(Parcel parcel) {
        String str = null;
        boolean z = true;
        boolean z2 = false;
        int b = zza.b(parcel);
        List list = LocationRequestInternal.f6359a;
        boolean z3 = true;
        boolean z4 = false;
        LocationRequest locationRequest = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    locationRequest = (LocationRequest) zza.a(parcel, a, LocationRequest.CREATOR);
                    break;
                case 2:
                    z4 = zza.b(parcel, a);
                    break;
                case 3:
                    z3 = zza.b(parcel, a);
                    break;
                case 4:
                    z = zza.b(parcel, a);
                    break;
                case 5:
                    list = zza.c(parcel, a, ClientIdentity.CREATOR);
                    break;
                case 6:
                    str = zza.n(parcel, a);
                    break;
                case 7:
                    z2 = zza.b(parcel, a);
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
            return new LocationRequestInternal(i, locationRequest, z4, z3, z, list, str, z2);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8951a(parcel);
    }

    public Object[] newArray(int i) {
        return new LocationRequestInternal[i];
    }
}

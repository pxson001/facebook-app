package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzg implements Creator<LocationSettingsResult> {
    public Object createFromParcel(Parcel parcel) {
        int b = zza.b(parcel);
        Status status = null;
        int i = 0;
        LocationSettingsStates locationSettingsStates = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    status = (Status) zza.a(parcel, a, Status.CREATOR);
                    break;
                case 2:
                    locationSettingsStates = (LocationSettingsStates) zza.a(parcel, a, LocationSettingsStates.CREATOR);
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
            return new LocationSettingsResult(i, status, locationSettingsStates);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new LocationSettingsResult[i];
    }
}

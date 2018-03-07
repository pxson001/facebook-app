package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzg implements Creator<DeviceStatus> {
    public Object createFromParcel(Parcel parcel) {
        int i = 0;
        int b = zza.b(parcel);
        double d = 0.0d;
        ApplicationMetadata applicationMetadata = null;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i3 = zza.e(parcel, a);
                    break;
                case 2:
                    d = zza.l(parcel, a);
                    break;
                case 3:
                    z = zza.b(parcel, a);
                    break;
                case 4:
                    i2 = zza.e(parcel, a);
                    break;
                case 5:
                    applicationMetadata = (ApplicationMetadata) zza.a(parcel, a, ApplicationMetadata.CREATOR);
                    break;
                case 6:
                    i = zza.e(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new DeviceStatus(i3, d, z, i2, applicationMetadata, i);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new DeviceStatus[i];
    }
}

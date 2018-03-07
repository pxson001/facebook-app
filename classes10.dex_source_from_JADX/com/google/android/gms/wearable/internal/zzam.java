package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzam implements Creator<GetCloudSyncOptInOutDoneResponse> {
    public Object createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = zza.b(parcel);
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i2 = zza.e(parcel, a);
                    break;
                case 2:
                    i = zza.e(parcel, a);
                    break;
                case 3:
                    z = zza.b(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GetCloudSyncOptInOutDoneResponse(i2, i, z);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new GetCloudSyncOptInOutDoneResponse[i];
    }
}

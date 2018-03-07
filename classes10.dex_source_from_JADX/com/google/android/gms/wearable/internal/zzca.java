package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzca implements Creator<StorageInfoResponse> {
    public Object createFromParcel(Parcel parcel) {
        int i = 0;
        int b = zza.b(parcel);
        long j = 0;
        List list = null;
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
                    j = zza.g(parcel, a);
                    break;
                case 4:
                    list = zza.c(parcel, a, PackageStorageInfo.CREATOR);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new StorageInfoResponse(i2, i, j, list);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new StorageInfoResponse[i];
    }
}

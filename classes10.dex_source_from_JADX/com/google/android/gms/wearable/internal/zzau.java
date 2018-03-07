package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzau implements Creator<GetLargeAssetQueueStateResponse> {
    public Object createFromParcel(Parcel parcel) {
        int b = zza.b(parcel);
        Status status = null;
        int i = 0;
        LargeAssetQueueStateParcelable largeAssetQueueStateParcelable = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i = zza.e(parcel, a);
                    break;
                case 2:
                    status = (Status) zza.a(parcel, a, Status.CREATOR);
                    break;
                case 3:
                    largeAssetQueueStateParcelable = (LargeAssetQueueStateParcelable) zza.a(parcel, a, LargeAssetQueueStateParcelable.CREATOR);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GetLargeAssetQueueStateResponse(i, status, largeAssetQueueStateParcelable);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new GetLargeAssetQueueStateResponse[i];
    }
}

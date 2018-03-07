package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzah implements Creator<EnqueueLargeAssetResponse> {
    public Object createFromParcel(Parcel parcel) {
        int i = 0;
        int b = zza.b(parcel);
        LargeAssetQueueEntryParcelable largeAssetQueueEntryParcelable = null;
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
                    largeAssetQueueEntryParcelable = (LargeAssetQueueEntryParcelable) zza.a(parcel, a, LargeAssetQueueEntryParcelable.CREATOR);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new EnqueueLargeAssetResponse(i2, i, largeAssetQueueEntryParcelable);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new EnqueueLargeAssetResponse[i];
    }
}

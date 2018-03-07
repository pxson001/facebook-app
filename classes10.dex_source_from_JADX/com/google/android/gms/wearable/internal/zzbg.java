package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbg implements Creator<LargeAssetQueueStateChangeParcelable> {
    public Object createFromParcel(Parcel parcel) {
        int b = zza.b(parcel);
        DataHolder dataHolder = null;
        int i = 0;
        LargeAssetQueueStateParcelable largeAssetQueueStateParcelable = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i = zza.e(parcel, a);
                    break;
                case 4:
                    dataHolder = (DataHolder) zza.a(parcel, a, DataHolder.CREATOR);
                    break;
                case 5:
                    largeAssetQueueStateParcelable = (LargeAssetQueueStateParcelable) zza.a(parcel, a, LargeAssetQueueStateParcelable.CREATOR);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new LargeAssetQueueStateChangeParcelable(i, dataHolder, largeAssetQueueStateParcelable);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new LargeAssetQueueStateChangeParcelable[i];
    }
}

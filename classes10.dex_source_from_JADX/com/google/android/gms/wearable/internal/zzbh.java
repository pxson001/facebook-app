package com.google.android.gms.wearable.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbh implements Creator<LargeAssetQueueStateParcelable> {
    public Object createFromParcel(Parcel parcel) {
        Bundle bundle = null;
        int i = 0;
        int b = zza.b(parcel);
        int i2 = 0;
        String str = null;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i4 = zza.e(parcel, a);
                    break;
                case 2:
                    i3 = zza.e(parcel, a);
                    break;
                case 3:
                    str = zza.n(parcel, a);
                    break;
                case 4:
                    bundle = zza.p(parcel, a);
                    break;
                case 5:
                    i2 = zza.e(parcel, a);
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
            return new LargeAssetQueueStateParcelable(i4, i3, str, bundle, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new LargeAssetQueueStateParcelable[i];
    }
}

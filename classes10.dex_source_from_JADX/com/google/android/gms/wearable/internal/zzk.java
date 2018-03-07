package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzk implements Creator<CapabilityInfoParcelable> {
    public Object createFromParcel(Parcel parcel) {
        List list = null;
        int b = zza.b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i = zza.e(parcel, a);
                    break;
                case 2:
                    str = zza.n(parcel, a);
                    break;
                case 3:
                    list = zza.c(parcel, a, NodeParcelable.CREATOR);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new CapabilityInfoParcelable(i, str, list);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new CapabilityInfoParcelable[i];
    }
}

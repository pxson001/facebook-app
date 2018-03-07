package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzo implements Creator<ChannelImpl> {
    public Object createFromParcel(Parcel parcel) {
        String str = null;
        int b = zza.b(parcel);
        String str2 = null;
        int i = 0;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i = zza.e(parcel, a);
                    break;
                case 2:
                    str2 = zza.n(parcel, a);
                    break;
                case 3:
                    str3 = zza.n(parcel, a);
                    break;
                case 4:
                    str = zza.n(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ChannelImpl(i, str2, str3, str);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new ChannelImpl[i];
    }
}

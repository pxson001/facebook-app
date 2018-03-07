package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzn implements Creator<ChannelEventParcelable> {
    public Object createFromParcel(Parcel parcel) {
        int i = 0;
        int b = zza.b(parcel);
        ChannelImpl channelImpl = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i4 = zza.e(parcel, a);
                    break;
                case 2:
                    channelImpl = (ChannelImpl) zza.a(parcel, a, ChannelImpl.CREATOR);
                    break;
                case 3:
                    i3 = zza.e(parcel, a);
                    break;
                case 4:
                    i2 = zza.e(parcel, a);
                    break;
                case 5:
                    i = zza.e(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ChannelEventParcelable(i4, channelImpl, i3, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new ChannelEventParcelable[i];
    }
}

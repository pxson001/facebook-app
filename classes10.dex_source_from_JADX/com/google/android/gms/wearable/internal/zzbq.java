package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbq implements Creator<OpenChannelResponse> {
    public Object createFromParcel(Parcel parcel) {
        int i = 0;
        int b = zza.b(parcel);
        ChannelImpl channelImpl = null;
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
                    channelImpl = (ChannelImpl) zza.a(parcel, a, ChannelImpl.CREATOR);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new OpenChannelResponse(i2, i, channelImpl);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new OpenChannelResponse[i];
    }
}

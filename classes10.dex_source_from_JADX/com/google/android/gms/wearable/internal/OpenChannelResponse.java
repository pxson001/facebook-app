package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class OpenChannelResponse implements SafeParcelable {
    public static final Creator<OpenChannelResponse> CREATOR = new zzbq();
    public final int f13342a;
    public final int f13343b;
    public final ChannelImpl f13344c;

    OpenChannelResponse(int i, int i2, ChannelImpl channelImpl) {
        this.f13342a = i;
        this.f13343b = i2;
        this.f13344c = channelImpl;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13342a);
        zzb.a(parcel, 2, this.f13343b);
        zzb.a(parcel, 3, this.f13344c, i, false);
        zzb.c(parcel, a);
    }
}

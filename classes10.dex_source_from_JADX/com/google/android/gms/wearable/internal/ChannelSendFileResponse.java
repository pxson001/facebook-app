package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class ChannelSendFileResponse implements SafeParcelable {
    public static final Creator<ChannelSendFileResponse> CREATOR = new zzs();
    public final int f13235a;
    public final int f13236b;

    ChannelSendFileResponse(int i, int i2) {
        this.f13235a = i;
        this.f13236b = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13235a);
        zzb.a(parcel, 2, this.f13236b);
        zzb.c(parcel, a);
    }
}

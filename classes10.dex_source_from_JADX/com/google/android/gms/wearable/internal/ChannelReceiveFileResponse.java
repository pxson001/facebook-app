package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class ChannelReceiveFileResponse implements SafeParcelable {
    public static final Creator<ChannelReceiveFileResponse> CREATOR = new zzr();
    public final int f13233a;
    public final int f13234b;

    ChannelReceiveFileResponse(int i, int i2) {
        this.f13233a = i;
        this.f13234b = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13233a);
        zzb.a(parcel, 2, this.f13234b);
        zzb.c(parcel, a);
    }
}

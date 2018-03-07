package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class CloseChannelResponse implements SafeParcelable {
    public static final Creator<CloseChannelResponse> CREATOR = new zzv();
    public final int f13237a;
    public final int f13238b;

    CloseChannelResponse(int i, int i2) {
        this.f13237a = i;
        this.f13238b = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13237a);
        zzb.a(parcel, 2, this.f13238b);
        zzb.c(parcel, a);
    }
}

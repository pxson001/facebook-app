package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class SendMessageResponse implements SafeParcelable {
    public static final Creator<SendMessageResponse> CREATOR = new zzbx();
    public final int f13359a;
    public final int f13360b;
    public final int f13361c;

    SendMessageResponse(int i, int i2, int i3) {
        this.f13359a = i;
        this.f13360b = i2;
        this.f13361c = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13359a);
        zzb.a(parcel, 2, this.f13360b);
        zzb.a(parcel, 3, this.f13361c);
        zzb.c(parcel, a);
    }
}

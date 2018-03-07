package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class GetLocalNodeResponse implements SafeParcelable {
    public static final Creator<GetLocalNodeResponse> CREATOR = new zzav();
    public final int f13292a;
    public final int f13293b;
    public final NodeParcelable f13294c;

    GetLocalNodeResponse(int i, int i2, NodeParcelable nodeParcelable) {
        this.f13292a = i;
        this.f13293b = i2;
        this.f13294c = nodeParcelable;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13292a);
        zzb.a(parcel, 2, this.f13293b);
        zzb.a(parcel, 3, this.f13294c, i, false);
        zzb.c(parcel, a);
    }
}

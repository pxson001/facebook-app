package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class DeleteDataItemsResponse implements SafeParcelable {
    public static final Creator<DeleteDataItemsResponse> CREATOR = new zzag();
    public final int f13246a;
    public final int f13247b;
    public final int f13248c;

    DeleteDataItemsResponse(int i, int i2, int i3) {
        this.f13246a = i;
        this.f13247b = i2;
        this.f13248c = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13246a);
        zzb.a(parcel, 2, this.f13247b);
        zzb.a(parcel, 3, this.f13248c);
        zzb.c(parcel, a);
    }
}

package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class GetDataItemResponse implements SafeParcelable {
    public static final Creator<GetDataItemResponse> CREATOR = new zzas();
    public final int f13283a;
    public final int f13284b;
    public final DataItemParcelable f13285c;

    GetDataItemResponse(int i, int i2, DataItemParcelable dataItemParcelable) {
        this.f13283a = i;
        this.f13284b = i2;
        this.f13285c = dataItemParcelable;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13283a);
        zzb.a(parcel, 2, this.f13284b);
        zzb.a(parcel, 3, this.f13285c, i, false);
        zzb.c(parcel, a);
    }
}

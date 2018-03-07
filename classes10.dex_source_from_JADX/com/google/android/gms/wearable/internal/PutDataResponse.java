package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class PutDataResponse implements SafeParcelable {
    public static final Creator<PutDataResponse> CREATOR = new zzbs();
    public final int f13349a;
    public final int f13350b;
    public final DataItemParcelable f13351c;

    PutDataResponse(int i, int i2, DataItemParcelable dataItemParcelable) {
        this.f13349a = i;
        this.f13350b = i2;
        this.f13351c = dataItemParcelable;
    }

    public PutDataResponse(int i, DataItemParcelable dataItemParcelable) {
        this(1, i, dataItemParcelable);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13349a);
        zzb.a(parcel, 2, this.f13350b);
        zzb.a(parcel, 3, this.f13351c, i, false);
        zzb.c(parcel, a);
    }
}

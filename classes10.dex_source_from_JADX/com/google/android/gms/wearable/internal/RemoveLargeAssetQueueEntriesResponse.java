package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;

public final class RemoveLargeAssetQueueEntriesResponse implements SafeParcelable {
    public static final Creator<RemoveLargeAssetQueueEntriesResponse> CREATOR = new zzbu();
    public final int f13352a;
    public final Status f13353b;
    public final int f13354c;

    RemoveLargeAssetQueueEntriesResponse(int i, Status status, int i2) {
        this.f13352a = i;
        this.f13353b = (Status) zzx.a(status, "status");
        this.f13354c = i2;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13352a);
        zzb.a(parcel, 2, this.f13353b, i, false);
        zzb.a(parcel, 3, this.f13354c);
        zzb.c(parcel, a);
    }
}

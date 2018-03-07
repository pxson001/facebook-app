package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;

public final class GetLargeAssetQueueStateResponse implements SafeParcelable {
    public static final Creator<GetLargeAssetQueueStateResponse> CREATOR = new zzau();
    public final int f13289a;
    public final Status f13290b;
    public final LargeAssetQueueStateParcelable f13291c;

    GetLargeAssetQueueStateResponse(int i, Status status, LargeAssetQueueStateParcelable largeAssetQueueStateParcelable) {
        this.f13289a = i;
        this.f13290b = status;
        if (status.e()) {
            zzx.a(largeAssetQueueStateParcelable);
        }
        this.f13291c = largeAssetQueueStateParcelable;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13289a);
        zzb.a(parcel, 2, this.f13290b, i, false);
        zzb.a(parcel, 3, this.f13291c, i, false);
        zzb.c(parcel, a);
    }
}

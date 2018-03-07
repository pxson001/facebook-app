package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.Arrays;

public final class LargeAssetRemoveRequest implements SafeParcelable {
    public static final Creator<LargeAssetRemoveRequest> CREATOR = new zzbi();
    private static final LargeAssetRemoveRequest f13326c = new LargeAssetRemoveRequest(1, null);
    public final int f13327a;
    public final long[] f13328b;

    LargeAssetRemoveRequest(int i, long[] jArr) {
        this.f13327a = i;
        this.f13328b = jArr;
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "LargeAssetRemoveRequest{transferIdsToRemove=" + Arrays.toString(this.f13328b) + "}";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13327a);
        long[] jArr = this.f13328b;
        if (jArr != null) {
            int b = zzb.b(parcel, 2);
            parcel.writeLongArray(jArr);
            zzb.c(parcel, b);
        } else if (null != null) {
            zzb.b(parcel, 2, 0);
        }
        zzb.c(parcel, a);
    }
}

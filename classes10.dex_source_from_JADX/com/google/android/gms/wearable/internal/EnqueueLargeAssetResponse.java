package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;

public final class EnqueueLargeAssetResponse implements SafeParcelable {
    public static final Creator<EnqueueLargeAssetResponse> CREATOR = new zzah();
    public final int f13249a;
    public final int f13250b;
    public final LargeAssetQueueEntryParcelable f13251c;

    EnqueueLargeAssetResponse(int i, int i2, LargeAssetQueueEntryParcelable largeAssetQueueEntryParcelable) {
        boolean z = true;
        this.f13249a = i;
        this.f13250b = i2;
        if (i2 == 0) {
            if (largeAssetQueueEntryParcelable == null) {
                z = false;
            }
            zzx.b(z, "Expecting non-null queueEntry");
        } else {
            zzx.b(largeAssetQueueEntryParcelable == null, "Expecting null queueEntry: %s", new Object[]{largeAssetQueueEntryParcelable});
        }
        this.f13251c = largeAssetQueueEntryParcelable;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13249a);
        zzb.a(parcel, 2, this.f13250b);
        zzb.a(parcel, 3, this.f13251c, i, false);
        zzb.c(parcel, a);
    }
}

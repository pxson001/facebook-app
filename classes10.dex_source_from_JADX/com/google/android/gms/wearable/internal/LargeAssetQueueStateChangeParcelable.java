package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.LargeAssetApi.zzd;

public final class LargeAssetQueueStateChangeParcelable implements SafeParcelable, zzd {
    public static final Creator<LargeAssetQueueStateChangeParcelable> CREATOR = new zzbg();
    public final int f13316a;
    public final DataHolder f13317b;
    private final zzbt f13318c;
    public final LargeAssetQueueStateParcelable f13319d;

    LargeAssetQueueStateChangeParcelable(int i, DataHolder dataHolder, LargeAssetQueueStateParcelable largeAssetQueueStateParcelable) {
        this.f13316a = i;
        this.f13317b = (DataHolder) zzx.a(dataHolder);
        this.f13318c = new zzbt(dataHolder);
        this.f13319d = (LargeAssetQueueStateParcelable) zzx.a(largeAssetQueueStateParcelable);
    }

    public final void m13330c() {
        this.f13318c.c();
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "LargeAssetQueueStateChangeParcelable{queueEntryBuffer=" + this.f13318c + ", queueState=" + this.f13319d + "}";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13316a);
        zzb.a(parcel, 4, this.f13317b, i, false);
        zzb.a(parcel, 5, this.f13319d, i, false);
        zzb.c(parcel, a);
    }
}

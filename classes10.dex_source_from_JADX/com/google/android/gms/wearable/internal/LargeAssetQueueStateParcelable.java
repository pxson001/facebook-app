package com.google.android.gms.wearable.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.LargeAssetApi.QueueState;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class LargeAssetQueueStateParcelable implements SafeParcelable, QueueState {
    public static final Creator<LargeAssetQueueStateParcelable> CREATOR = new zzbh();
    public final int f13320a;
    public final int f13321b;
    public final String f13322c;
    public final Map<String, Integer> f13323d;
    public final int f13324e;
    public final int f13325f;

    LargeAssetQueueStateParcelable(int i, int i2, String str, Bundle bundle, int i3, int i4) {
        this.f13320a = i;
        this.f13321b = i2 & 15;
        this.f13322c = (String) zzx.a(str);
        Set<String> keySet = bundle.keySet();
        ArrayMap arrayMap = new ArrayMap(keySet.size());
        for (String str2 : keySet) {
            arrayMap.put(str2, Integer.valueOf(bundle.getInt(str2) & 15));
        }
        this.f13323d = arrayMap;
        this.f13324e = i3;
        this.f13325f = i4;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LargeAssetQueueStateParcelable)) {
            return false;
        }
        LargeAssetQueueStateParcelable largeAssetQueueStateParcelable = (LargeAssetQueueStateParcelable) obj;
        return this.f13320a == largeAssetQueueStateParcelable.f13320a && this.f13321b == largeAssetQueueStateParcelable.f13321b && this.f13324e == largeAssetQueueStateParcelable.f13324e && this.f13325f == largeAssetQueueStateParcelable.f13325f && this.f13322c.equals(largeAssetQueueStateParcelable.f13322c) && this.f13323d.equals(largeAssetQueueStateParcelable.f13323d);
    }

    public final int hashCode() {
        return (((((((((this.f13320a * 31) + this.f13321b) * 31) + this.f13322c.hashCode()) * 31) + this.f13323d.hashCode()) * 31) + this.f13324e) * 31) + this.f13325f;
    }

    public final String toString() {
        return "QueueState{localNodeFlags=" + this.f13321b + ", localNodeId='" + this.f13322c + "', remoteNodeFlags=" + this.f13323d + ", pausedCount=" + this.f13324e + ", runningCount=" + this.f13325f + "}";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13320a);
        zzb.a(parcel, 2, this.f13321b);
        zzb.a(parcel, 3, this.f13322c, false);
        Bundle bundle = new Bundle();
        for (Entry entry : this.f13323d.entrySet()) {
            bundle.putInt((String) entry.getKey(), ((Integer) entry.getValue()).intValue());
        }
        zzb.a(parcel, 4, bundle, false);
        zzb.a(parcel, 5, this.f13324e);
        zzb.a(parcel, 6, this.f13325f);
        zzb.c(parcel, a);
    }
}

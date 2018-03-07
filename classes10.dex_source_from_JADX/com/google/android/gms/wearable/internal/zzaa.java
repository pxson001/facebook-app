package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

public class zzaa implements DataItemAsset {
    private final String f13366a;
    private final String f13367b;

    public zzaa(DataItemAsset dataItemAsset) {
        this.f13366a = dataItemAsset.mo576b();
        this.f13367b = dataItemAsset.mo577c();
    }

    public final Object m13393a() {
        return this;
    }

    public final String mo576b() {
        return this.f13366a;
    }

    public final String mo577c() {
        return this.f13367b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataItemAssetEntity[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.f13366a == null) {
            stringBuilder.append(",noid");
        } else {
            stringBuilder.append(",");
            stringBuilder.append(this.f13366a);
        }
        stringBuilder.append(", key=");
        stringBuilder.append(this.f13367b);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

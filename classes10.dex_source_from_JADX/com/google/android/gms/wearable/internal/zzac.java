package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.wearable.DataItemAsset;

public class zzac extends zzc implements DataItemAsset {
    public zzac(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final Object m13396a() {
        return new zzaa(this);
    }

    public final String mo576b() {
        return d("asset_id");
    }

    public final String mo577c() {
        return d("asset_key");
    }
}

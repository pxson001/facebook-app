package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class zzaf extends zzc implements DataItem {
    private final int f13371c;

    public zzaf(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.f13371c = i2;
    }

    public final Object m13403a() {
        return new zzad(this);
    }

    public final Uri mo578b() {
        return Uri.parse(d("path"));
    }

    public final byte[] mo579c() {
        return f("data");
    }

    public final Map<String, DataItemAsset> mo580d() {
        Map<String, DataItemAsset> hashMap = new HashMap(this.f13371c);
        for (int i = 0; i < this.f13371c; i++) {
            zzac com_google_android_gms_wearable_internal_zzac = new zzac(this.a, this.b + i);
            if (com_google_android_gms_wearable_internal_zzac.mo577c() != null) {
                hashMap.put(com_google_android_gms_wearable_internal_zzac.mo577c(), com_google_android_gms_wearable_internal_zzac);
            }
        }
        return hashMap;
    }

    public final String toString() {
        boolean isLoggable = Log.isLoggable("DataItem", 3);
        byte[] c = mo579c();
        Map d = mo580d();
        StringBuilder stringBuilder = new StringBuilder("DataItemInternal{ ");
        stringBuilder.append("uri=" + mo578b());
        stringBuilder.append(", dataSz=" + (c == null ? "null" : Integer.valueOf(c.length)));
        stringBuilder.append(", numAssets=" + d.size());
        if (isLoggable && !d.isEmpty()) {
            stringBuilder.append(", assets=[");
            String str = "";
            for (Entry entry : d.entrySet()) {
                stringBuilder.append(str + ((String) entry.getKey()) + ": " + ((DataItemAsset) entry.getValue()).mo576b());
                str = ", ";
            }
            stringBuilder.append("]");
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}

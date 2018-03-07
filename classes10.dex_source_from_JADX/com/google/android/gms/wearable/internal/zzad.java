package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class zzad implements DataItem {
    public Uri f13368a;
    public byte[] f13369b;
    public Map<String, DataItemAsset> f13370c;

    public zzad(DataItem dataItem) {
        this.f13368a = dataItem.mo578b();
        this.f13369b = dataItem.mo579c();
        Map hashMap = new HashMap();
        for (Entry entry : dataItem.mo580d().entrySet()) {
            if (entry.getKey() != null) {
                hashMap.put(entry.getKey(), ((DataItemAsset) entry.getValue()).a());
            }
        }
        this.f13370c = Collections.unmodifiableMap(hashMap);
    }

    public final Object m13399a() {
        return this;
    }

    public final Uri mo578b() {
        return this.f13368a;
    }

    public final byte[] mo579c() {
        return this.f13369b;
    }

    public final Map<String, DataItemAsset> mo580d() {
        return this.f13370c;
    }

    public String toString() {
        boolean isLoggable = Log.isLoggable("DataItem", 3);
        StringBuilder stringBuilder = new StringBuilder("DataItemEntity{ ");
        stringBuilder.append("uri=" + this.f13368a);
        stringBuilder.append(", dataSz=" + (this.f13369b == null ? "null" : Integer.valueOf(this.f13369b.length)));
        stringBuilder.append(", numAssets=" + this.f13370c.size());
        if (isLoggable && !this.f13370c.isEmpty()) {
            stringBuilder.append(", assets=[");
            String str = "";
            for (Entry entry : this.f13370c.entrySet()) {
                stringBuilder.append(str + ((String) entry.getKey()) + ": " + ((DataItemAsset) entry.getValue()).mo576b());
                str = ", ";
            }
            stringBuilder.append("]");
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}

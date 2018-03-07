package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DataItemParcelable implements SafeParcelable, DataItem {
    public static final Creator<DataItemParcelable> CREATOR = new zzae();
    public final int f13242a;
    public final Uri f13243b;
    public final Map<String, DataItemAsset> f13244c;
    public byte[] f13245d;

    DataItemParcelable(int i, Uri uri, Bundle bundle, byte[] bArr) {
        this.f13242a = i;
        this.f13243b = uri;
        Map hashMap = new HashMap();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (String str : bundle.keySet()) {
            hashMap.put(str, (DataItemAssetParcelable) bundle.getParcelable(str));
        }
        this.f13244c = hashMap;
        this.f13245d = bArr;
    }

    public final Object m13326a() {
        return this;
    }

    public final Uri mo578b() {
        return this.f13243b;
    }

    public final byte[] mo579c() {
        return this.f13245d;
    }

    public final Map<String, DataItemAsset> mo580d() {
        return this.f13244c;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        String stringBuilder;
        boolean isLoggable = Log.isLoggable("DataItem", 3);
        StringBuilder stringBuilder2 = new StringBuilder("DataItemParcelable[");
        stringBuilder2.append("@");
        stringBuilder2.append(Integer.toHexString(hashCode()));
        stringBuilder2.append(",dataSz=" + (this.f13245d == null ? "null" : Integer.valueOf(this.f13245d.length)));
        stringBuilder2.append(", numAssets=" + this.f13244c.size());
        stringBuilder2.append(", uri=" + this.f13243b);
        if (isLoggable) {
            stringBuilder2.append("]\n  assets: ");
            for (String stringBuilder3 : this.f13244c.keySet()) {
                stringBuilder2.append("\n    " + stringBuilder3 + ": " + this.f13244c.get(stringBuilder3));
            }
            stringBuilder2.append("\n  ]");
            stringBuilder3 = stringBuilder2.toString();
        } else {
            stringBuilder2.append("]");
            stringBuilder3 = stringBuilder2.toString();
        }
        return stringBuilder3;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13242a);
        zzb.a(parcel, 2, mo578b(), i, false);
        Bundle bundle = new Bundle();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (Entry entry : this.f13244c.entrySet()) {
            bundle.putParcelable((String) entry.getKey(), new DataItemAssetParcelable((DataItemAsset) entry.getValue()));
        }
        zzb.a(parcel, 4, bundle, false);
        zzb.a(parcel, 5, mo579c(), false);
        zzb.c(parcel, a);
    }
}

package com.google.android.gms.wearable;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PutDataRequest implements SafeParcelable {
    public static final Creator<PutDataRequest> CREATOR = new zzi();
    private static final long f13150b = TimeUnit.MINUTES.toMillis(30);
    private static final Random f13151c = new SecureRandom();
    public final int f13152a;
    public final Uri f13153d;
    public final Bundle f13154e;
    public byte[] f13155f;
    public long f13156g;

    private PutDataRequest(int i, Uri uri) {
        this(i, uri, new Bundle(), null, f13150b);
    }

    PutDataRequest(int i, Uri uri, Bundle bundle, byte[] bArr, long j) {
        this.f13152a = i;
        this.f13153d = uri;
        this.f13154e = bundle;
        this.f13154e.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        this.f13155f = bArr;
        this.f13156g = j;
    }

    public static PutDataRequest m13281a(Uri uri) {
        return new PutDataRequest(2, uri);
    }

    public static Uri m13282b(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("An empty path was supplied.");
        } else if (!str.startsWith("/")) {
            throw new IllegalArgumentException("A path must start with a single / .");
        } else if (!str.startsWith("//")) {
            return new Builder().scheme("wear").path(str).build();
        } else {
            throw new IllegalArgumentException("A path must start with a single / .");
        }
    }

    public final Uri m13283a() {
        return this.f13153d;
    }

    public final PutDataRequest m13284a(String str, Asset asset) {
        zzx.a(str);
        zzx.a(asset);
        this.f13154e.putParcelable(str, asset);
        return this;
    }

    public final PutDataRequest m13285a(byte[] bArr) {
        this.f13155f = bArr;
        return this;
    }

    public final byte[] m13286b() {
        return this.f13155f;
    }

    public final Map<String, Asset> m13287c() {
        Map hashMap = new HashMap();
        for (String str : this.f13154e.keySet()) {
            hashMap.put(str, (Asset) this.f13154e.getParcelable(str));
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public int describeContents() {
        return 0;
    }

    public final boolean m13288f() {
        return this.f13156g == 0;
    }

    public final PutDataRequest m13289g() {
        this.f13156g = 0;
        return this;
    }

    public String toString() {
        String stringBuilder;
        boolean isLoggable = Log.isLoggable("DataMap", 3);
        StringBuilder stringBuilder2 = new StringBuilder("PutDataRequest[");
        stringBuilder2.append("dataSz=" + (this.f13155f == null ? "null" : Integer.valueOf(this.f13155f.length)));
        stringBuilder2.append(", numAssets=" + this.f13154e.size());
        stringBuilder2.append(", uri=" + this.f13153d);
        stringBuilder2.append(", syncDeadline=" + this.f13156g);
        if (isLoggable) {
            stringBuilder2.append("]\n  assets: ");
            for (String stringBuilder3 : this.f13154e.keySet()) {
                stringBuilder2.append("\n    " + stringBuilder3 + ": " + this.f13154e.getParcelable(stringBuilder3));
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
        zzb.a(parcel, 1, this.f13152a);
        zzb.a(parcel, 2, this.f13153d, i, false);
        zzb.a(parcel, 4, this.f13154e, false);
        zzb.a(parcel, 5, this.f13155f, false);
        zzb.a(parcel, 6, this.f13156g);
        zzb.c(parcel, a);
    }
}

package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.zzsy;
import com.google.android.gms.internal.zzsy.zza;
import com.google.android.gms.internal.zzsz;
import com.google.android.gms.internal.zztk;

public class PutDataMapRequest {
    private final PutDataRequest f13148a;
    private final DataMap f13149b = new DataMap();

    private PutDataMapRequest(PutDataRequest putDataRequest, DataMap dataMap) {
        this.f13148a = putDataRequest;
        if (dataMap != null) {
            DataMap dataMap2 = this.f13149b;
            for (String str : dataMap.m13263b()) {
                dataMap2.f13145a.put(str, dataMap.m13262b(str));
            }
        }
    }

    public static PutDataMapRequest m13277a(String str) {
        return new PutDataMapRequest(PutDataRequest.m13281a(PutDataRequest.m13282b(str)), null);
    }

    public final Uri m13278a() {
        return this.f13148a.f13153d;
    }

    public final DataMap m13279b() {
        return this.f13149b;
    }

    public final PutDataRequest m13280c() {
        zza a = zzsy.m13204a(this.f13149b);
        PutDataRequest putDataRequest = this.f13148a;
        zzsz com_google_android_gms_internal_zzsz = a.f13105a;
        byte[] bArr = new byte[com_google_android_gms_internal_zzsz.d()];
        zztk.a(com_google_android_gms_internal_zzsz, bArr, 0, bArr.length);
        putDataRequest.f13155f = bArr;
        int size = a.f13106b.size();
        int i = 0;
        while (i < size) {
            String num = Integer.toString(i);
            Asset asset = (Asset) a.f13106b.get(i);
            if (num == null) {
                throw new IllegalStateException("asset key cannot be null: " + asset);
            } else if (asset == null) {
                throw new IllegalStateException("asset cannot be null: key=" + num);
            } else {
                if (Log.isLoggable("DataMap", 3)) {
                    Log.d("DataMap", "asPutDataRequest: adding asset: " + num + " " + asset);
                }
                this.f13148a.m13284a(num, asset);
                i++;
            }
        }
        return this.f13148a;
    }
}

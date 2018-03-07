package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.util.LongSparseArray;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.LargeAssetApi.zzb;
import com.google.android.gms.wearable.LargeAssetApi.zzc;

public final class zzbt extends AbstractDataBuffer<zzb> implements zzc {
    public static final long[] f13387b = new long[0];
    public static final int[] f13388c = new int[0];
    private final Status f13389d;
    private final LongSparseArray<zza> f13390e;

    public final class zza {
        public final int f13385a;
        public final int f13386b;

        public zza(int i, int i2) {
            boolean z = i == 2 || i == 1 || i == 3 || i == 4 || i == 5;
            zzx.b(z, "Invalid queue entry state: %s", new Object[]{Integer.valueOf(i)});
            this.f13385a = i;
            this.f13386b = i2;
        }

        public final String toString() {
            return "EntryMetadata{state=" + this.f13385a + ", refuseCode=" + this.f13386b + "}";
        }
    }

    public zzbt(DataHolder dataHolder) {
        LongSparseArray longSparseArray;
        super(dataHolder);
        this.f13389d = zzbz.m13577a(dataHolder.h);
        Bundle bundle = dataHolder.i;
        if (bundle == null) {
            longSparseArray = new LongSparseArray(0);
        } else {
            long[] longArray = bundle.getLongArray("notPausedTransferIds");
            if (longArray == null) {
                longArray = f13387b;
            }
            long[] jArr = longArray;
            int[] intArray = bundle.getIntArray("notPausedStates");
            if (intArray == null) {
                zza com_google_android_gms_wearable_internal_zzbt_zza = new zza(2, 0);
                zzx.a(com_google_android_gms_wearable_internal_zzbt_zza);
                LongSparseArray longSparseArray2 = new LongSparseArray(jArr.length);
                for (long b : jArr) {
                    longSparseArray2.b(b, com_google_android_gms_wearable_internal_zzbt_zza);
                }
                longSparseArray = longSparseArray2;
            } else {
                int[] intArray2 = bundle.getIntArray("refuseCodes");
                if (intArray2 == null) {
                    intArray2 = f13388c;
                }
                longSparseArray = m13568a(jArr, intArray, intArray2);
            }
        }
        this.f13390e = longSparseArray;
    }

    private int m13567a(long j) {
        zza com_google_android_gms_wearable_internal_zzbt_zza = (zza) this.f13390e.a(j);
        return com_google_android_gms_wearable_internal_zzbt_zza == null ? 1 : com_google_android_gms_wearable_internal_zzbt_zza.f13385a;
    }

    public static LongSparseArray<zza> m13568a(long[] jArr, int[] iArr, int[] iArr2) {
        zzx.b(jArr.length == iArr.length, "transferIds and states differ in length.");
        zzx.a(iArr2);
        LongSparseArray<zza> longSparseArray = new LongSparseArray(jArr.length);
        int i = 0;
        for (int i2 = 0; i2 < jArr.length; i2++) {
            int i3;
            if (iArr[i2] == 4) {
                zzx.b(i < iArr2.length, "More entries in STATE_REFUSED than refuseCodes");
                i3 = iArr2[i];
                i++;
            } else {
                i3 = 0;
            }
            longSparseArray.b(jArr[i2], new zza(iArr[i2], i3));
        }
        return longSparseArray;
    }

    private int m13569b(long j) {
        zza com_google_android_gms_wearable_internal_zzbt_zza = (zza) this.f13390e.a(j);
        return com_google_android_gms_wearable_internal_zzbt_zza == null ? 0 : com_google_android_gms_wearable_internal_zzbt_zza.f13386b;
    }

    private String m13570b(int i, int i2) {
        return this.a.c("path", i, i2);
    }

    private String m13571c(int i, int i2) {
        return this.a.c("nodeId", i, i2);
    }

    private Uri m13572d(int i, int i2) {
        return Uri.parse(this.a.c("destinationUri", i, i2));
    }

    private boolean m13573e(int i, int i2) {
        return this.a.d("append", i, i2);
    }

    private boolean m13574f(int i, int i2) {
        return this.a.d("allowedOverMetered", i, i2);
    }

    private boolean m13575g(int i, int i2) {
        return this.a.d("allowedWithLowBattery", i, i2);
    }

    public final Object m13576a(int i) {
        int a = this.a.a(i);
        long a2 = this.a.a("transferId", i, a);
        return new LargeAssetQueueEntryParcelable(a2, m13567a(a2), m13570b(i, a), m13571c(i, a), m13572d(i, a), m13569b(a2), m13573e(i, a), m13574f(i, a), m13575g(i, a));
    }

    public final Status cp_() {
        return this.f13389d;
    }

    public final String toString() {
        return "QueueEntryBufferImpl{status=" + this.f13389d + ", entryMetadataByTransferId=" + this.f13390e + "}";
    }
}

package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;

/* compiled from: event_suggestions */
public final class Result {
    public final String f13467a;
    private final byte[] f13468b;
    private ResultPoint[] f13469c;
    private final BarcodeFormat f13470d;
    private Map<ResultMetadataType, Object> f13471e;
    private final long f13472f;

    public Result(String str, byte[] bArr, ResultPoint[] resultPointArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, resultPointArr, barcodeFormat, System.currentTimeMillis());
    }

    private Result(String str, byte[] bArr, ResultPoint[] resultPointArr, BarcodeFormat barcodeFormat, long j) {
        this.f13467a = str;
        this.f13468b = bArr;
        this.f13469c = resultPointArr;
        this.f13470d = barcodeFormat;
        this.f13471e = null;
        this.f13472f = j;
    }

    public final void m13660a(ResultMetadataType resultMetadataType, Object obj) {
        if (this.f13471e == null) {
            this.f13471e = new EnumMap(ResultMetadataType.class);
        }
        this.f13471e.put(resultMetadataType, obj);
    }

    public final String toString() {
        return this.f13467a;
    }
}

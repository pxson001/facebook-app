package android_src.mmsv2.util;

import android_src.mmsv2.pdu.GenericPdu;

/* compiled from: sentTimestampMs */
public final class PduCacheEntry {
    private final GenericPdu f3897a;
    public final int f3898b;
    public final long f3899c;

    public PduCacheEntry(GenericPdu genericPdu, int i, long j) {
        this.f3897a = genericPdu;
        this.f3898b = i;
        this.f3899c = j;
    }

    public final GenericPdu m3759a() {
        return this.f3897a;
    }

    public final int m3760b() {
        return this.f3898b;
    }

    public final long m3761c() {
        return this.f3899c;
    }
}

package com.facebook.livephotos.exoplayer.extractor.ts;

/* compiled from: page_checkin_error */
public final class PtsTimestampAdjuster {
    private final long f7482a;
    private long f7483b;
    private volatile long f7484c = Long.MIN_VALUE;

    public PtsTimestampAdjuster(long j) {
        this.f7482a = j;
    }

    public final void m9177a() {
        this.f7484c = Long.MIN_VALUE;
    }

    public final long m9176a(long j) {
        long j2;
        long j3;
        if (this.f7484c != Long.MIN_VALUE) {
            j2 = (this.f7484c + 4294967296L) / 8589934592L;
            j3 = ((j2 - 1) * 8589934592L) + j;
            j2 = (j2 * 8589934592L) + j;
            if (Math.abs(j3 - this.f7484c) >= Math.abs(j2 - this.f7484c)) {
                j3 = j2;
            }
        } else {
            j3 = j;
        }
        j2 = m9175b(j3);
        if (this.f7482a != Long.MAX_VALUE && this.f7484c == Long.MIN_VALUE) {
            this.f7483b = this.f7482a - j2;
        }
        this.f7484c = j3;
        return this.f7483b + j2;
    }

    private static long m9175b(long j) {
        return (1000000 * j) / 90000;
    }
}

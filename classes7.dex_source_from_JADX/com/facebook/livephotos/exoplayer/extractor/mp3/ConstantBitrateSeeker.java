package com.facebook.livephotos.exoplayer.extractor.mp3;

/* compiled from: page_recommendation_successful */
final class ConstantBitrateSeeker implements Seeker {
    private final long f7080a;
    private final int f7081b;
    private final long f7082c;

    public ConstantBitrateSeeker(long j, int i, long j2) {
        long j3 = -1;
        this.f7080a = j;
        this.f7081b = i;
        if (j2 != -1) {
            j3 = mo432b(j2);
        }
        this.f7082c = j3;
    }

    public final boolean mo407a() {
        return this.f7082c != -1;
    }

    public final long mo406a(long j) {
        return this.f7082c == -1 ? 0 : this.f7080a + ((((long) this.f7081b) * j) / 8000000);
    }

    public final long mo432b(long j) {
        return ((Math.max(0, j - this.f7080a) * 1000000) * 8) / ((long) this.f7081b);
    }

    public final long mo431b() {
        return this.f7082c;
    }
}

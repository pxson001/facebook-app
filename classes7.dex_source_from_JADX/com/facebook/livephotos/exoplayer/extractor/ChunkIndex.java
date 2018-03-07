package com.facebook.livephotos.exoplayer.extractor;

import com.facebook.livephotos.exoplayer.util.Util;

/* compiled from: page_target */
public final class ChunkIndex implements SeekMap {
    public final int f6956a;
    public final int[] f6957b;
    public final long[] f6958c;
    public final long[] f6959d;
    public final long[] f6960e;

    public ChunkIndex(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f6956a = iArr.length;
        this.f6957b = iArr;
        this.f6958c = jArr;
        this.f6959d = jArr2;
        this.f6960e = jArr3;
    }

    public final boolean mo407a() {
        return true;
    }

    public final long mo406a(long j) {
        return this.f6958c[Util.m9361a(this.f6960e, j, true, true)];
    }
}

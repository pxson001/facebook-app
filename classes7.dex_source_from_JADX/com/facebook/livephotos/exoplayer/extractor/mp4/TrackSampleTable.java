package com.facebook.livephotos.exoplayer.extractor.mp4;

import com.facebook.livephotos.exoplayer.util.Assertions;

/* compiled from: page_like_error */
public final class TrackSampleTable {
    public final int f7252a;
    public final long[] f7253b;
    public final int[] f7254c;
    public final int f7255d;
    public final long[] f7256e;
    public final int[] f7257f;

    TrackSampleTable(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        boolean z;
        boolean z2 = true;
        Assertions.m9295a(iArr.length == jArr2.length);
        if (jArr.length == jArr2.length) {
            z = true;
        } else {
            z = false;
        }
        Assertions.m9295a(z);
        if (iArr2.length != jArr2.length) {
            z2 = false;
        }
        Assertions.m9295a(z2);
        this.f7253b = jArr;
        this.f7254c = iArr;
        this.f7255d = i;
        this.f7256e = jArr2;
        this.f7257f = iArr2;
        this.f7252a = jArr.length;
    }
}

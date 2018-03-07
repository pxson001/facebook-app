package com.facebook.livephotos.exoplayer.upstream;

import android.net.Uri;
import com.facebook.livephotos.exoplayer.util.Assertions;
import java.util.Arrays;

/* compiled from: p2p */
public final class DataSpec {
    public final Uri f7634a;
    public final byte[] f7635b;
    public final long f7636c;
    public final long f7637d;
    public final long f7638e;
    public final String f7639f;
    public final int f7640g;

    public DataSpec(Uri uri, long j, long j2, String str) {
        this(uri, j, j, j2, str, 0);
    }

    private DataSpec(Uri uri, long j, long j2, long j3, String str, int i) {
        this(uri, null, j, j2, j3, str, i);
    }

    private DataSpec(Uri uri, byte[] bArr, long j, long j2, long j3, String str, int i) {
        Assertions.m9295a(j >= 0);
        Assertions.m9295a(j2 >= 0);
        boolean z = j3 > 0 || j3 == -1;
        Assertions.m9295a(z);
        this.f7634a = uri;
        this.f7635b = bArr;
        this.f7636c = j;
        this.f7637d = j2;
        this.f7638e = j3;
        this.f7639f = str;
        this.f7640g = i;
    }

    public final String toString() {
        return "DataSpec[" + this.f7634a + ", " + Arrays.toString(this.f7635b) + ", " + this.f7636c + ", " + this.f7637d + ", " + this.f7638e + ", " + this.f7639f + ", " + this.f7640g + "]";
    }
}

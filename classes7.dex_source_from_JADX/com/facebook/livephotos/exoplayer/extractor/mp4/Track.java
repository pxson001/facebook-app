package com.facebook.livephotos.exoplayer.extractor.mp4;

import com.facebook.livephotos.exoplayer.MediaFormat;
import com.facebook.livephotos.exoplayer.util.Util;

/* compiled from: page_load_successful */
public final class Track {
    public static final int f7221a = Util.m9368c("vide");
    public static final int f7222b = Util.m9368c("soun");
    public static final int f7223c = Util.m9368c("text");
    public static final int f7224d = Util.m9368c("sbtl");
    public static final int f7225e = Util.m9368c("subt");
    public final int f7226f;
    public final int f7227g;
    public final long f7228h;
    public final long f7229i;
    public final long f7230j;
    public final MediaFormat f7231k;
    public final TrackEncryptionBox[] f7232l;
    public final long[] f7233m;
    public final long[] f7234n;
    public final int f7235o;

    public Track(int i, int i2, long j, long j2, long j3, MediaFormat mediaFormat, TrackEncryptionBox[] trackEncryptionBoxArr, int i3, long[] jArr, long[] jArr2) {
        this.f7226f = i;
        this.f7227g = i2;
        this.f7228h = j;
        this.f7229i = j2;
        this.f7230j = j3;
        this.f7231k = mediaFormat;
        this.f7232l = trackEncryptionBoxArr;
        this.f7235o = i3;
        this.f7233m = jArr;
        this.f7234n = jArr2;
    }
}

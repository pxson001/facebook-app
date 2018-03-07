package com.facebook.livephotos.exoplayer;

import com.facebook.livephotos.exoplayer.util.Util;

/* compiled from: param_souvenir_id */
public final class CryptoInfo {
    public byte[] f6699a;
    public byte[] f6700b;
    public int f6701c;
    public int[] f6702d;
    public int[] f6703e;
    public int f6704f;
    public final android.media.MediaCodec.CryptoInfo f6705g;

    public CryptoInfo() {
        android.media.MediaCodec.CryptoInfo cryptoInfo;
        if (Util.f7736a >= 16) {
            cryptoInfo = new android.media.MediaCodec.CryptoInfo();
        } else {
            cryptoInfo = null;
        }
        this.f6705g = cryptoInfo;
    }

    public final void m8575a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2) {
        this.f6704f = i;
        this.f6702d = iArr;
        this.f6703e = iArr2;
        this.f6700b = bArr;
        this.f6699a = bArr2;
        this.f6701c = i2;
        if (Util.f7736a >= 16) {
            this.f6705g.set(this.f6704f, this.f6702d, this.f6703e, this.f6700b, this.f6699a, this.f6701c);
        }
    }
}

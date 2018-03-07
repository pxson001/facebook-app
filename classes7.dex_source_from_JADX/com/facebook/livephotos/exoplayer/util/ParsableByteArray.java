package com.facebook.livephotos.exoplayer.util;

import java.nio.charset.Charset;

/* compiled from: open_edit_history */
public final class ParsableByteArray {
    public byte[] f7731a;
    public int f7732b;
    public int f7733c;

    public ParsableByteArray(int i) {
        this.f7731a = new byte[i];
        this.f7733c = this.f7731a.length;
    }

    public ParsableByteArray(byte[] bArr) {
        this.f7731a = bArr;
        this.f7733c = bArr.length;
    }

    public ParsableByteArray(byte[] bArr, int i) {
        this.f7731a = bArr;
        this.f7733c = i;
    }

    public final void m9334a(byte[] bArr, int i) {
        this.f7731a = bArr;
        this.f7733c = i;
        this.f7732b = 0;
    }

    public final void m9331a() {
        this.f7732b = 0;
        this.f7733c = 0;
    }

    public final int m9336b() {
        return this.f7733c - this.f7732b;
    }

    public final int m9338c() {
        return this.f7733c;
    }

    public final void m9332a(int i) {
        boolean z = i >= 0 && i <= this.f7731a.length;
        Assertions.m9295a(z);
        this.f7733c = i;
    }

    public final int m9340d() {
        return this.f7732b;
    }

    public final int m9342e() {
        return this.f7731a == null ? 0 : this.f7731a.length;
    }

    public final void m9337b(int i) {
        boolean z = i >= 0 && i <= this.f7733c;
        Assertions.m9295a(z);
        this.f7732b = i;
    }

    public final void m9339c(int i) {
        m9337b(this.f7732b + i);
    }

    public final void m9333a(ParsableBitArray parsableBitArray, int i) {
        m9335a(parsableBitArray.f7727a, 0, i);
        parsableBitArray.m9322a(0);
    }

    public final void m9335a(byte[] bArr, int i, int i2) {
        System.arraycopy(this.f7731a, this.f7732b, bArr, i, i2);
        this.f7732b += i2;
    }

    public final int m9343f() {
        byte[] bArr = this.f7731a;
        int i = this.f7732b;
        this.f7732b = i + 1;
        return bArr[i] & 255;
    }

    public final int m9344g() {
        byte[] bArr = this.f7731a;
        int i = this.f7732b;
        this.f7732b = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        byte[] bArr2 = this.f7731a;
        int i3 = this.f7732b;
        this.f7732b = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    public final int m9345h() {
        byte[] bArr = this.f7731a;
        int i = this.f7732b;
        this.f7732b = i + 1;
        int i2 = bArr[i] & 255;
        byte[] bArr2 = this.f7731a;
        int i3 = this.f7732b;
        this.f7732b = i3 + 1;
        return i2 | ((bArr2[i3] & 255) << 8);
    }

    public final int m9346j() {
        byte[] bArr = this.f7731a;
        int i = this.f7732b;
        this.f7732b = i + 1;
        int i2 = (bArr[i] & 255) << 16;
        byte[] bArr2 = this.f7731a;
        int i3 = this.f7732b;
        this.f7732b = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 8;
        bArr2 = this.f7731a;
        i3 = this.f7732b;
        this.f7732b = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    public final long m9347k() {
        byte[] bArr = this.f7731a;
        int i = this.f7732b;
        this.f7732b = i + 1;
        long j = (((long) bArr[i]) & 255) << 24;
        byte[] bArr2 = this.f7731a;
        int i2 = this.f7732b;
        this.f7732b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.f7731a;
        i2 = this.f7732b;
        this.f7732b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.f7731a;
        i2 = this.f7732b;
        this.f7732b = i2 + 1;
        return j | (((long) bArr2[i2]) & 255);
    }

    public final long m9348l() {
        byte[] bArr = this.f7731a;
        int i = this.f7732b;
        this.f7732b = i + 1;
        long j = ((long) bArr[i]) & 255;
        byte[] bArr2 = this.f7731a;
        int i2 = this.f7732b;
        this.f7732b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.f7731a;
        i2 = this.f7732b;
        this.f7732b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.f7731a;
        i2 = this.f7732b;
        this.f7732b = i2 + 1;
        return j | ((((long) bArr2[i2]) & 255) << 24);
    }

    public final int m9349m() {
        byte[] bArr = this.f7731a;
        int i = this.f7732b;
        this.f7732b = i + 1;
        int i2 = (bArr[i] & 255) << 24;
        byte[] bArr2 = this.f7731a;
        int i3 = this.f7732b;
        this.f7732b = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 16;
        bArr2 = this.f7731a;
        i3 = this.f7732b;
        this.f7732b = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 8;
        bArr2 = this.f7731a;
        i3 = this.f7732b;
        this.f7732b = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    public final int m9350n() {
        byte[] bArr = this.f7731a;
        int i = this.f7732b;
        this.f7732b = i + 1;
        int i2 = bArr[i] & 255;
        byte[] bArr2 = this.f7731a;
        int i3 = this.f7732b;
        this.f7732b = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 8;
        bArr2 = this.f7731a;
        i3 = this.f7732b;
        this.f7732b = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 16;
        bArr2 = this.f7731a;
        i3 = this.f7732b;
        this.f7732b = i3 + 1;
        return i2 | ((bArr2[i3] & 255) << 24);
    }

    public final long m9351o() {
        byte[] bArr = this.f7731a;
        int i = this.f7732b;
        this.f7732b = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        byte[] bArr2 = this.f7731a;
        int i2 = this.f7732b;
        this.f7732b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 48;
        bArr2 = this.f7731a;
        i2 = this.f7732b;
        this.f7732b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 40;
        bArr2 = this.f7731a;
        i2 = this.f7732b;
        this.f7732b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 32;
        bArr2 = this.f7731a;
        i2 = this.f7732b;
        this.f7732b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 24;
        bArr2 = this.f7731a;
        i2 = this.f7732b;
        this.f7732b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.f7731a;
        i2 = this.f7732b;
        this.f7732b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.f7731a;
        i2 = this.f7732b;
        this.f7732b = i2 + 1;
        return j | (((long) bArr2[i2]) & 255);
    }

    public final long m9352p() {
        byte[] bArr = this.f7731a;
        int i = this.f7732b;
        this.f7732b = i + 1;
        long j = ((long) bArr[i]) & 255;
        byte[] bArr2 = this.f7731a;
        int i2 = this.f7732b;
        this.f7732b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.f7731a;
        i2 = this.f7732b;
        this.f7732b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.f7731a;
        i2 = this.f7732b;
        this.f7732b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 24;
        bArr2 = this.f7731a;
        i2 = this.f7732b;
        this.f7732b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 32;
        bArr2 = this.f7731a;
        i2 = this.f7732b;
        this.f7732b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 40;
        bArr2 = this.f7731a;
        i2 = this.f7732b;
        this.f7732b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 48;
        bArr2 = this.f7731a;
        i2 = this.f7732b;
        this.f7732b = i2 + 1;
        return j | ((((long) bArr2[i2]) & 255) << 56);
    }

    public final int m9353q() {
        byte[] bArr = this.f7731a;
        int i = this.f7732b;
        this.f7732b = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        byte[] bArr2 = this.f7731a;
        int i3 = this.f7732b;
        this.f7732b = i3 + 1;
        i2 |= bArr2[i3] & 255;
        this.f7732b += 2;
        return i2;
    }

    public final int m9354r() {
        return (((m9343f() << 21) | (m9343f() << 14)) | (m9343f() << 7)) | m9343f();
    }

    public final int m9355s() {
        int m = m9349m();
        if (m >= 0) {
            return m;
        }
        throw new IllegalStateException("Top bit not zero: " + m);
    }

    public final int m9356t() {
        int n = m9350n();
        if (n >= 0) {
            return n;
        }
        throw new IllegalStateException("Top bit not zero: " + n);
    }

    public final long m9357u() {
        long o = m9351o();
        if (o >= 0) {
            return o;
        }
        throw new IllegalStateException("Top bit not zero: " + o);
    }

    public final String m9341d(int i) {
        return m9330a(i, Charset.defaultCharset());
    }

    public final String m9330a(int i, Charset charset) {
        String str = new String(this.f7731a, this.f7732b, i, charset);
        this.f7732b += i;
        return str;
    }
}

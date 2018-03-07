package com.google.zxing.common;

/* compiled from: event_seen_state_megaphone_show */
public final class BitSource {
    private final byte[] f13481a;
    private int f13482b;
    private int f13483c;

    public BitSource(byte[] bArr) {
        this.f13481a = bArr;
    }

    public final int m13681a(int i) {
        if (i <= 0 || i > 32 || i > m13680a()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        int i2;
        int i3;
        if (this.f13483c > 0) {
            i2 = 8 - this.f13483c;
            i3 = i < i2 ? i : i2;
            i2 -= i3;
            i2 = (((255 >> (8 - i3)) << i2) & this.f13481a[this.f13482b]) >> i2;
            i -= i3;
            this.f13483c = i3 + this.f13483c;
            if (this.f13483c == 8) {
                this.f13483c = 0;
                this.f13482b++;
            }
            i3 = i2;
            i2 = i;
        } else {
            i3 = 0;
            i2 = i;
        }
        if (i2 <= 0) {
            return i3;
        }
        while (i2 >= 8) {
            i3 = (i3 << 8) | (this.f13481a[this.f13482b] & 255);
            this.f13482b++;
            i2 -= 8;
        }
        if (i2 <= 0) {
            return i3;
        }
        int i4 = 8 - i2;
        i3 = (i3 << i2) | ((((255 >> i4) << i4) & this.f13481a[this.f13482b]) >> i4);
        this.f13483c = i2 + this.f13483c;
        return i3;
    }

    public final int m13680a() {
        return ((this.f13481a.length - this.f13482b) * 8) - this.f13483c;
    }
}

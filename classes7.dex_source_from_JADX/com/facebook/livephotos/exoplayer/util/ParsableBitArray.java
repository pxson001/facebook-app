package com.facebook.livephotos.exoplayer.util;

/* compiled from: optimistic_fetch_failure */
public final class ParsableBitArray {
    public byte[] f7727a;
    private int f7728b;
    private int f7729c;
    private int f7730d;

    public ParsableBitArray(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public ParsableBitArray(byte[] bArr, int i) {
        this.f7727a = bArr;
        this.f7730d = i;
    }

    public final void m9323a(byte[] bArr, int i) {
        this.f7727a = bArr;
        this.f7728b = 0;
        this.f7729c = 0;
        this.f7730d = i;
    }

    public final int m9321a() {
        return ((this.f7730d - this.f7728b) * 8) - this.f7729c;
    }

    public final void m9322a(int i) {
        this.f7728b = i / 8;
        this.f7729c = i - (this.f7728b * 8);
        m9320g();
    }

    public final void m9324b(int i) {
        this.f7728b += i / 8;
        this.f7729c += i % 8;
        if (this.f7729c > 7) {
            this.f7728b++;
            this.f7729c -= 8;
        }
        m9320g();
    }

    public final boolean m9325b() {
        return m9326c(1) == 1;
    }

    public final int m9326c(int i) {
        int i2 = 0;
        if (i != 0) {
            int i3;
            int i4 = i / 8;
            int i5 = 0;
            for (i3 = 0; i3 < i4; i3++) {
                if (this.f7729c != 0) {
                    i2 = ((this.f7727a[this.f7728b] & 255) << this.f7729c) | ((this.f7727a[this.f7728b + 1] & 255) >>> (8 - this.f7729c));
                } else {
                    i2 = this.f7727a[this.f7728b];
                }
                i -= 8;
                i5 |= (i2 & 255) << i;
                this.f7728b++;
            }
            if (i > 0) {
                i3 = this.f7729c + i;
                byte b = (byte) (255 >> (8 - i));
                if (i3 > 8) {
                    i2 = (b & (((this.f7727a[this.f7728b] & 255) << (i3 - 8)) | ((this.f7727a[this.f7728b + 1] & 255) >> (16 - i3)))) | i5;
                    this.f7728b++;
                } else {
                    i2 = (b & ((this.f7727a[this.f7728b] & 255) >> (8 - i3))) | i5;
                    if (i3 == 8) {
                        this.f7728b++;
                    }
                }
                this.f7729c = i3 % 8;
            } else {
                i2 = i5;
            }
            m9320g();
        }
        return i2;
    }

    public final boolean m9327c() {
        boolean z;
        int i = this.f7728b;
        int i2 = this.f7729c;
        int i3 = 0;
        while (this.f7728b < this.f7730d && !m9325b()) {
            i3++;
        }
        if (this.f7728b == this.f7730d) {
            z = true;
        } else {
            z = false;
        }
        this.f7728b = i;
        this.f7729c = i2;
        if (z || m9321a() < (i3 * 2) + 1) {
            return false;
        }
        return true;
    }

    public final int m9328d() {
        return m9319f();
    }

    public final int m9329e() {
        int f = m9319f();
        return (f % 2 == 0 ? -1 : 1) * ((f + 1) / 2);
    }

    private int m9319f() {
        int i = 0;
        int i2 = 0;
        while (!m9325b()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = m9326c(i2);
        }
        return i3 + i;
    }

    private void m9320g() {
        boolean z = this.f7728b >= 0 && this.f7729c >= 0 && this.f7729c < 8 && (this.f7728b < this.f7730d || (this.f7728b == this.f7730d && this.f7729c == 0));
        Assertions.m9297b(z);
    }
}

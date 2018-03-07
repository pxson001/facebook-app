package com.facebook.livephotos.exoplayer.extractor.ogg;

import com.facebook.livephotos.exoplayer.util.Assertions;

/* compiled from: page_follow_success */
public final class VorbisBitArray {
    public final byte[] f7301a;
    private int f7302b;
    private int f7303c;
    private int f7304d;

    public VorbisBitArray(byte[] bArr) {
        this(bArr, bArr.length);
    }

    private VorbisBitArray(byte[] bArr, int i) {
        this.f7301a = bArr;
        this.f7302b = i * 8;
    }

    public final boolean m9073a() {
        return m9072a(1) == 1;
    }

    public final int m9072a(int i) {
        Assertions.m9297b(m9074b() + i <= this.f7302b);
        if (i == 0) {
            return 0;
        }
        long min;
        int i2;
        int i3;
        int i4;
        if (this.f7304d != 0) {
            min = Math.min(i, 8 - this.f7304d);
            i2 = (255 >>> (8 - min)) & (this.f7301a[this.f7303c] >>> this.f7304d);
            this.f7304d += min;
            if (this.f7304d == 8) {
                this.f7303c++;
                this.f7304d = 0;
            }
        } else {
            min = 0;
            i2 = 0;
        }
        if (i - min > 7) {
            int i5 = (i - min) / 8;
            i3 = i2;
            i2 = 0;
            while (i2 < i5) {
                long j = (long) i3;
                byte[] bArr = this.f7301a;
                int i6 = this.f7303c;
                this.f7303c = i6 + 1;
                min += 8;
                i2++;
                i3 = (int) (j | ((((long) bArr[i6]) & 255) << min));
            }
            int i7 = min;
            i4 = i3;
            i3 = i7;
        } else {
            i3 = min;
            i4 = i2;
        }
        if (i > i3) {
            i2 = i - i3;
            i4 |= ((255 >>> (8 - i2)) & this.f7301a[this.f7303c]) << i3;
            this.f7304d += i2;
        }
        return i4;
    }

    public final void m9075b(int i) {
        Assertions.m9297b(m9074b() + i <= this.f7302b);
        this.f7303c += i / 8;
        this.f7304d += i % 8;
        if (this.f7304d > 7) {
            this.f7303c++;
            this.f7304d -= 8;
        }
    }

    public final int m9074b() {
        return (this.f7303c * 8) + this.f7304d;
    }
}

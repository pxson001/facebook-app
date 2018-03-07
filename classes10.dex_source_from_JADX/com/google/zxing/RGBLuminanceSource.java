package com.google.zxing;

/* compiled from: event_themes */
public final class RGBLuminanceSource extends LuminanceSource {
    private final byte[] f13462a;
    private final int f13463b;
    private final int f13464c;
    private final int f13465d = 0;
    private final int f13466e = 0;

    public RGBLuminanceSource(int i, int i2, int[] iArr) {
        super(i, i2);
        this.f13463b = i;
        this.f13464c = i2;
        this.f13462a = new byte[(i * i2)];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * i;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = iArr[i4 + i5];
                int i7 = (i6 >> 16) & 255;
                int i8 = (i6 >> 8) & 255;
                i6 &= 255;
                if (i7 == i8 && i8 == i6) {
                    this.f13462a[i4 + i5] = (byte) i7;
                } else {
                    this.f13462a[i4 + i5] = (byte) ((i6 + ((i7 + i8) + i8)) >> 2);
                }
            }
        }
    }

    public final byte[] mo679a(int i, byte[] bArr) {
        if (i < 0 || i >= this.f13455b) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        int i2 = this.f13454a;
        if (bArr == null || bArr.length < i2) {
            bArr = new byte[i2];
        }
        System.arraycopy(this.f13462a, ((this.f13466e + i) * this.f13463b) + this.f13465d, bArr, 0, i2);
        return bArr;
    }

    public final byte[] mo678a() {
        int i = 0;
        int i2 = this.f13454a;
        int i3 = this.f13455b;
        if (i2 == this.f13463b && i3 == this.f13464c) {
            return this.f13462a;
        }
        int i4 = i2 * i3;
        byte[] bArr = new byte[i4];
        int i5 = (this.f13466e * this.f13463b) + this.f13465d;
        if (i2 == this.f13463b) {
            System.arraycopy(this.f13462a, i5, bArr, 0, i4);
            return bArr;
        }
        Object obj = this.f13462a;
        while (i < i3) {
            System.arraycopy(obj, i5, bArr, i * i2, i2);
            i5 += this.f13463b;
            i++;
        }
        return bArr;
    }
}

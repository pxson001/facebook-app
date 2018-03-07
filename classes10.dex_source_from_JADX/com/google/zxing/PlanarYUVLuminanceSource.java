package com.google.zxing;

/* compiled from: event_ticket_purchase_async */
public final class PlanarYUVLuminanceSource extends LuminanceSource {
    private final byte[] f13457a;
    private final int f13458b;
    private final int f13459c;
    private final int f13460d;
    private final int f13461e;

    public PlanarYUVLuminanceSource(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        super(i5, i6);
        if (i3 + i5 > i || i4 + i6 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f13457a = bArr;
        this.f13458b = i;
        this.f13459c = i2;
        this.f13460d = i3;
        this.f13461e = i4;
        if (z) {
            m13655a(i5, i6);
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
        System.arraycopy(this.f13457a, ((this.f13461e + i) * this.f13458b) + this.f13460d, bArr, 0, i2);
        return bArr;
    }

    public final byte[] mo678a() {
        int i = 0;
        int i2 = this.f13454a;
        int i3 = this.f13455b;
        if (i2 == this.f13458b && i3 == this.f13459c) {
            return this.f13457a;
        }
        int i4 = i2 * i3;
        byte[] bArr = new byte[i4];
        int i5 = (this.f13461e * this.f13458b) + this.f13460d;
        if (i2 == this.f13458b) {
            System.arraycopy(this.f13457a, i5, bArr, 0, i4);
            return bArr;
        }
        Object obj = this.f13457a;
        while (i < i3) {
            System.arraycopy(obj, i5, bArr, i * i2, i2);
            i5 += this.f13458b;
            i++;
        }
        return bArr;
    }

    private void m13655a(int i, int i2) {
        byte[] bArr = this.f13457a;
        int i3 = this.f13460d + (this.f13461e * this.f13458b);
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i3 + (i / 2);
            int i6 = (i3 + i) - 1;
            int i7 = i3;
            while (i7 < i5) {
                byte b = bArr[i7];
                bArr[i7] = bArr[i6];
                bArr[i6] = b;
                i7++;
                i6--;
            }
            i3 += this.f13458b;
        }
    }
}

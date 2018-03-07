package com.google.zxing.qrcode.decoder;

import com.google.zxing.qrcode.decoder.Version.ECB;
import com.google.zxing.qrcode.decoder.Version.ECBlocks;

/* compiled from: event_location_summary_open_in_uber */
final class DataBlock {
    private final int f13531a;
    private final byte[] f13532b;

    private DataBlock(int i, byte[] bArr) {
        this.f13531a = i;
        this.f13532b = bArr;
    }

    static DataBlock[] m13736a(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length != version.m13776c()) {
            throw new IllegalArgumentException();
        }
        int i;
        ECBlocks a = version.m13774a(errorCorrectionLevel);
        ECB[] d = a.m13769d();
        int i2 = 0;
        for (ECB a2 : d) {
            i2 += a2.m13764a();
        }
        DataBlock[] dataBlockArr = new DataBlock[i2];
        int length = d.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            ECB ecb = d[i3];
            i2 = i4;
            i4 = 0;
            while (i4 < ecb.m13764a()) {
                int b = ecb.m13765b();
                i = i2 + 1;
                dataBlockArr[i2] = new DataBlock(b, new byte[(a.m13766a() + b)]);
                i4++;
                i2 = i;
            }
            i3++;
            i4 = i2;
        }
        i = dataBlockArr[0].f13532b.length;
        i2 = dataBlockArr.length - 1;
        while (i2 >= 0 && dataBlockArr[i2].f13532b.length != i) {
            i2--;
        }
        length = i2 + 1;
        i -= a.m13766a();
        int i5 = 0;
        i2 = 0;
        while (i5 < i) {
            i3 = i2;
            i2 = 0;
            while (i2 < i4) {
                int i6 = i3 + 1;
                dataBlockArr[i2].f13532b[i5] = bArr[i3];
                i2++;
                i3 = i6;
            }
            i5++;
            i2 = i3;
        }
        i3 = length;
        while (i3 < i4) {
            i6 = i2 + 1;
            dataBlockArr[i3].f13532b[i] = bArr[i2];
            i3++;
            i2 = i6;
        }
        int length2 = dataBlockArr[0].f13532b.length;
        while (i < length2) {
            i3 = 0;
            i6 = i2;
            while (i3 < i4) {
                i5 = i6 + 1;
                dataBlockArr[i3].f13532b[i3 < length ? i : i + 1] = bArr[i6];
                i3++;
                i6 = i5;
            }
            i++;
            i2 = i6;
        }
        return dataBlockArr;
    }

    final int m13737a() {
        return this.f13531a;
    }

    final byte[] m13738b() {
        return this.f13532b;
    }
}

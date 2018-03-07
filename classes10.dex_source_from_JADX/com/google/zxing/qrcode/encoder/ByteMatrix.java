package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;

/* compiled from: event_discovery_dashboard_first_scroll */
public final class ByteMatrix {
    public final byte[][] f13578a;
    public final int f13579b;
    public final int f13580c;

    public ByteMatrix(int i, int i2) {
        this.f13578a = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{i2, i});
        this.f13579b = i;
        this.f13580c = i2;
    }

    public final int m13811a() {
        return this.f13580c;
    }

    public final int m13814b() {
        return this.f13579b;
    }

    public final byte m13810a(int i, int i2) {
        return this.f13578a[i2][i];
    }

    public final void m13812a(int i, int i2, int i3) {
        this.f13578a[i2][i] = (byte) i3;
    }

    public final void m13813a(int i, int i2, boolean z) {
        this.f13578a[i2][i] = (byte) (z ? 1 : 0);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(((this.f13579b * 2) * this.f13580c) + 2);
        for (int i = 0; i < this.f13580c; i++) {
            for (int i2 = 0; i2 < this.f13579b; i2++) {
                switch (this.f13578a[i][i2]) {
                    case (byte) 0:
                        stringBuilder.append(" 0");
                        break;
                    case (byte) 1:
                        stringBuilder.append(" 1");
                        break;
                    default:
                        stringBuilder.append("  ");
                        break;
                }
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}

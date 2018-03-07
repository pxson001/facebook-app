package com.google.zxing;

/* compiled from: event_update_notification_subscription_level */
public abstract class LuminanceSource {
    public final int f13454a;
    public final int f13455b;

    public abstract byte[] mo678a();

    public abstract byte[] mo679a(int i, byte[] bArr);

    protected LuminanceSource(int i, int i2) {
        this.f13454a = i;
        this.f13455b = i2;
    }

    public final String toString() {
        byte[] bArr = new byte[this.f13454a];
        StringBuilder stringBuilder = new StringBuilder(this.f13455b * (this.f13454a + 1));
        byte[] bArr2 = bArr;
        for (int i = 0; i < this.f13455b; i++) {
            bArr2 = mo679a(i, bArr2);
            for (int i2 = 0; i2 < this.f13454a; i2++) {
                char c;
                int i3 = bArr2[i2] & 255;
                if (i3 < 64) {
                    c = '#';
                } else if (i3 < 128) {
                    c = '+';
                } else if (i3 < 192) {
                    c = '.';
                } else {
                    c = ' ';
                }
                stringBuilder.append(c);
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}

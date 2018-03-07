package com.facebook.thrift.transport;

/* compiled from: flow_control_window */
public abstract class TTransport {
    public abstract int mo3466a(byte[] bArr, int i, int i2);

    public abstract void mo3467b(byte[] bArr, int i, int i2);

    public final int m31925c(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int a = mo3466a(bArr, i + i3, i2 - i3);
            if (a <= 0) {
                throw new TTransportException("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i3 + " bytes.");
            }
            i3 += a;
        }
        return i3;
    }

    public static byte[] m31920b() {
        return null;
    }

    public static int m31921c() {
        return 0;
    }

    public static int m31922d() {
        return -1;
    }
}

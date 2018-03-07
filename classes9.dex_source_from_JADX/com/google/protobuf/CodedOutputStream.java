package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: android-app */
public final class CodedOutputStream {
    private final byte[] f20613a;
    private final int f20614b;
    private int f20615c;
    private final OutputStream f20616d = null;

    /* compiled from: android-app */
    public class OutOfSpaceException extends IOException {
        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public CodedOutputStream(byte[] bArr, int i, int i2) {
        this.f20613a = bArr;
        this.f20615c = i;
        this.f20614b = i + i2;
    }

    public static int m20227a(LazyField lazyField) {
        int b;
        if (lazyField.f20955e) {
            b = lazyField.f20954d.mo855b();
        } else {
            b = lazyField.f20953c.mo912b();
        }
        int i = b;
        return i + m20255m(i);
    }

    public static CodedOutputStream m20228a(byte[] bArr) {
        return new CodedOutputStream(bArr, 0, bArr.length);
    }

    public final void m20263a(int i, long j) {
        m20285i(i, 0);
        m20267a(j);
    }

    public final void m20262a(int i, int i2) {
        m20285i(i, 0);
        m20261a(i2);
    }

    public final void m20277c(int i, long j) {
        m20285i(i, 1);
        m20279c(j);
    }

    public final void m20266a(int i, boolean z) {
        m20285i(i, 0);
        m20270a(z);
    }

    public final void m20265a(int i, MessageLite messageLite) {
        m20285i(i, 3);
        messageLite.mo853a(this);
        m20285i(i, 4);
    }

    public final void m20273b(int i, MessageLite messageLite) {
        m20285i(i, 2);
        m20275b(messageLite);
    }

    public final void m20264a(int i, ByteString byteString) {
        m20285i(i, 2);
        m20268a(byteString);
    }

    public final void m20276c(int i, int i2) {
        m20285i(i, 0);
        m20286l(i2);
    }

    public final void m20280d(int i, int i2) {
        m20285i(i, 0);
        m20261a(i2);
    }

    public final void m20278c(int i, MessageLite messageLite) {
        m20285i(1, 3);
        m20276c(2, i);
        m20273b(3, messageLite);
        m20285i(1, 4);
    }

    public final void m20272b(int i, ByteString byteString) {
        m20285i(1, 3);
        m20276c(2, i);
        m20264a(3, byteString);
        m20285i(1, 4);
    }

    public final void m20259a(double d) {
        m20253k(Double.doubleToRawLongBits(d));
    }

    public final void m20260a(float f) {
        m20257o(Float.floatToRawIntBits(f));
    }

    public final void m20267a(long j) {
        m20249i(j);
    }

    public final void m20274b(long j) {
        m20249i(j);
    }

    public final void m20261a(int i) {
        if (i >= 0) {
            m20286l(i);
        } else {
            m20249i((long) i);
        }
    }

    public final void m20279c(long j) {
        m20253k(j);
    }

    public final void m20271b(int i) {
        m20257o(i);
    }

    public final void m20270a(boolean z) {
        m20256n(z ? 1 : 0);
    }

    public final void m20269a(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        m20286l(bytes.length);
        m20234b(bytes);
    }

    public final void m20275b(MessageLite messageLite) {
        m20286l(messageLite.mo855b());
        messageLite.mo853a(this);
    }

    public final void m20268a(ByteString byteString) {
        m20286l(byteString.mo912b());
        m20238c(byteString);
    }

    public final void m20282e(int i) {
        m20257o(i);
    }

    public final void m20281d(long j) {
        m20253k(j);
    }

    public final void m20283e(long j) {
        m20249i(m20254l(j));
    }

    public static int m20239d(int i, long j) {
        return m20252k(i) + m20251j(j);
    }

    public static int m20241e(int i, int i2) {
        return m20252k(i) + m20245g(i2);
    }

    public static int m20243f(int i, long j) {
        return m20252k(i) + 8;
    }

    public static int m20231b(int i, boolean z) {
        return m20252k(i) + 1;
    }

    public static int m20242e(int i, MessageLite messageLite) {
        return m20252k(i) + m20240d(messageLite);
    }

    public static int m20236c(int i, ByteString byteString) {
        return m20252k(i) + m20232b(byteString);
    }

    public static int m20246g(int i, int i2) {
        return m20252k(i) + m20255m(i2);
    }

    public static int m20247h(int i, int i2) {
        return m20252k(i) + m20245g(i2);
    }

    public static int m20244f(int i, MessageLite messageLite) {
        return ((m20252k(1) * 2) + m20246g(2, i)) + m20242e(3, messageLite);
    }

    public static int m20245g(int i) {
        if (i >= 0) {
            return m20255m(i);
        }
        return 10;
    }

    public static int m20233b(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + m20255m(bytes.length);
        } catch (Throwable e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    public static int m20237c(MessageLite messageLite) {
        return messageLite.mo855b();
    }

    public static int m20240d(MessageLite messageLite) {
        int b = messageLite.mo855b();
        return b + m20255m(b);
    }

    public static int m20232b(ByteString byteString) {
        return m20255m(byteString.mo912b()) + byteString.mo912b();
    }

    private void m20248i() {
        if (this.f20616d == null) {
            throw new OutOfSpaceException();
        }
        this.f20616d.write(this.f20613a, 0, this.f20615c);
        this.f20615c = 0;
    }

    private int m20250j() {
        if (this.f20616d == null) {
            return this.f20614b - this.f20615c;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    public final void m20284h() {
        if (m20250j() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    private void m20229a(byte b) {
        if (this.f20615c == this.f20614b) {
            m20248i();
        }
        byte[] bArr = this.f20613a;
        int i = this.f20615c;
        this.f20615c = i + 1;
        bArr[i] = b;
    }

    private void m20256n(int i) {
        m20229a((byte) i);
    }

    private void m20238c(ByteString byteString) {
        m20230a(byteString, 0, byteString.mo912b());
    }

    private void m20234b(byte[] bArr) {
        m20235b(bArr, 0, bArr.length);
    }

    private void m20235b(byte[] bArr, int i, int i2) {
        if (this.f20614b - this.f20615c >= i2) {
            System.arraycopy(bArr, i, this.f20613a, this.f20615c, i2);
            this.f20615c += i2;
            return;
        }
        int i3 = this.f20614b - this.f20615c;
        System.arraycopy(bArr, i, this.f20613a, this.f20615c, i3);
        int i4 = i + i3;
        i3 = i2 - i3;
        this.f20615c = this.f20614b;
        m20248i();
        if (i3 <= this.f20614b) {
            System.arraycopy(bArr, i4, this.f20613a, 0, i3);
            this.f20615c = i3;
            return;
        }
        this.f20616d.write(bArr, i4, i3);
    }

    private void m20230a(ByteString byteString, int i, int i2) {
        if (this.f20614b - this.f20615c >= i2) {
            byteString.m20180a(this.f20613a, i, this.f20615c, i2);
            this.f20615c += i2;
            return;
        }
        int i3 = this.f20614b - this.f20615c;
        byteString.m20180a(this.f20613a, i, this.f20615c, i3);
        int i4 = i + i3;
        i3 = i2 - i3;
        this.f20615c = this.f20614b;
        m20248i();
        if (i3 <= this.f20614b) {
            byteString.m20180a(this.f20613a, i4, 0, i3);
            this.f20615c = i3;
            return;
        }
        InputStream g = byteString.mo917g();
        if (((long) i4) != g.skip((long) i4)) {
            throw new IllegalStateException("Skip failed? Should never happen.");
        }
        while (i3 > 0) {
            i4 = Math.min(i3, this.f20614b);
            int read = g.read(this.f20613a, 0, i4);
            if (read != i4) {
                throw new IllegalStateException("Read failed? Should never happen");
            }
            this.f20616d.write(this.f20613a, 0, read);
            i3 -= read;
        }
    }

    public final void m20285i(int i, int i2) {
        m20286l(WireFormat.m21527a(i, i2));
    }

    public static int m20252k(int i) {
        return m20255m(WireFormat.m21527a(i, 0));
    }

    public final void m20286l(int i) {
        while ((i & -128) != 0) {
            m20256n((i & 127) | 128);
            i >>>= 7;
        }
        m20256n(i);
    }

    public static int m20255m(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        if ((-268435456 & i) == 0) {
            return 4;
        }
        return 5;
    }

    private void m20249i(long j) {
        while ((-128 & j) != 0) {
            m20256n((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m20256n((int) j);
    }

    public static int m20251j(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        if ((Long.MIN_VALUE & j) == 0) {
            return 9;
        }
        return 10;
    }

    private void m20257o(int i) {
        m20256n(i & 255);
        m20256n((i >> 8) & 255);
        m20256n((i >> 16) & 255);
        m20256n((i >> 24) & 255);
    }

    private void m20253k(long j) {
        m20256n(((int) j) & 255);
        m20256n(((int) (j >> 8)) & 255);
        m20256n(((int) (j >> 16)) & 255);
        m20256n(((int) (j >> 24)) & 255);
        m20256n(((int) (j >> 32)) & 255);
        m20256n(((int) (j >> 40)) & 255);
        m20256n(((int) (j >> 48)) & 255);
        m20256n(((int) (j >> 56)) & 255);
    }

    public static int m20258p(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public static long m20254l(long j) {
        return (j << 1) ^ (j >> 63);
    }
}

package com.facebook.livephotos.exoplayer.util;

import android.util.Log;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: optin_type */
public final class NalUnitUtil {
    public static final byte[] f7723a = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1};
    public static final float[] f7724b = new float[]{1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object f7725c = new Object();
    private static int[] f7726d = new int[10];

    /* compiled from: optin_type */
    public final class PpsData {
        public final int f7710a;
        public final int f7711b;
        public final boolean f7712c;

        public PpsData(int i, int i2, boolean z) {
            this.f7710a = i;
            this.f7711b = i2;
            this.f7712c = z;
        }
    }

    /* compiled from: optin_type */
    public final class SpsData {
        public final int f7713a;
        public final int f7714b;
        public final int f7715c;
        public final float f7716d;
        public final boolean f7717e;
        public final boolean f7718f;
        public final int f7719g;
        public final int f7720h;
        public final int f7721i;
        public final boolean f7722j;

        public SpsData(int i, int i2, int i3, float f, boolean z, boolean z2, int i4, int i5, int i6, boolean z3) {
            this.f7713a = i;
            this.f7714b = i2;
            this.f7715c = i3;
            this.f7716d = f;
            this.f7717e = z;
            this.f7718f = z2;
            this.f7719g = i4;
            this.f7720h = i5;
            this.f7721i = i6;
            this.f7722j = z3;
        }
    }

    public static int m9310a(byte[] bArr, int i) {
        int i2;
        int i3 = 0;
        synchronized (f7725c) {
            int a;
            int i4 = 0;
            int i5 = 0;
            while (i5 < i) {
                a = m9311a(bArr, i5, i);
                if (a < i) {
                    if (f7726d.length <= i4) {
                        f7726d = Arrays.copyOf(f7726d, f7726d.length * 2);
                    }
                    i5 = i4 + 1;
                    f7726d[i4] = a;
                    i4 = i5;
                    i5 = a + 3;
                } else {
                    i5 = a;
                }
            }
            i2 = i - i4;
            i5 = 0;
            a = 0;
            while (i3 < i4) {
                int i6 = f7726d[i3] - a;
                System.arraycopy(bArr, a, bArr, i5, i6);
                i5 += i6;
                int i7 = i5 + 1;
                bArr[i5] = (byte) 0;
                i5 = i7 + 1;
                bArr[i7] = (byte) 0;
                a += i6 + 3;
                i3++;
            }
            System.arraycopy(bArr, a, bArr, i5, i2 - i5);
        }
        return i2;
    }

    public static void m9315a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i = 0;
        int i2 = 0;
        while (i + 1 < position) {
            int i3 = byteBuffer.get(i) & 255;
            if (i2 == 3) {
                if (i3 == 1 && (byteBuffer.get(i + 1) & 31) == 7) {
                    ByteBuffer duplicate = byteBuffer.duplicate();
                    duplicate.position(i - 3);
                    duplicate.limit(position);
                    byteBuffer.position(0);
                    byteBuffer.put(duplicate);
                    return;
                }
            } else if (i3 == 0) {
                i2++;
            }
            if (i3 != 0) {
                i2 = 0;
            }
            i++;
        }
        byteBuffer.clear();
    }

    public static byte[] m9317a(ParsableByteArray parsableByteArray) {
        int g = parsableByteArray.m9344g();
        int i = parsableByteArray.f7732b;
        parsableByteArray.m9339c(g);
        Object obj = parsableByteArray.f7731a;
        Object obj2 = new byte[(CodecSpecificDataUtil.f7687a.length + g)];
        System.arraycopy(CodecSpecificDataUtil.f7687a, 0, obj2, 0, CodecSpecificDataUtil.f7687a.length);
        System.arraycopy(obj, i, obj2, CodecSpecificDataUtil.f7687a.length, g);
        return obj2;
    }

    public static SpsData m9313a(ParsableBitArray parsableBitArray) {
        int d;
        int i;
        boolean z;
        int i2;
        float f;
        int c = parsableBitArray.m9326c(8);
        parsableBitArray.m9324b(16);
        int d2 = parsableBitArray.m9328d();
        boolean z2 = false;
        if (c == 100 || c == 110 || c == 122 || c == 244 || c == 44 || c == 83 || c == 86 || c == 118 || c == 128 || c == 138) {
            d = parsableBitArray.m9328d();
            if (d == 3) {
                z2 = parsableBitArray.m9325b();
            }
            parsableBitArray.m9328d();
            parsableBitArray.m9328d();
            parsableBitArray.m9324b(1);
            if (parsableBitArray.m9325b()) {
                i = d != 3 ? 8 : 12;
                int i3 = 0;
                while (i3 < i) {
                    if (parsableBitArray.m9325b()) {
                        m9314a(parsableBitArray, i3 < 6 ? 16 : 64);
                    }
                    i3++;
                }
            }
            z = z2;
            i2 = d;
        } else {
            z = false;
            i2 = 1;
        }
        int d3 = parsableBitArray.m9328d() + 4;
        int d4 = parsableBitArray.m9328d();
        int i4 = 0;
        boolean z3 = false;
        if (d4 == 0) {
            i4 = parsableBitArray.m9328d() + 4;
        } else if (d4 == 1) {
            z3 = parsableBitArray.m9325b();
            parsableBitArray.m9329e();
            parsableBitArray.m9329e();
            long d5 = (long) parsableBitArray.m9328d();
            for (i = 0; ((long) i) < d5; i++) {
                parsableBitArray.m9328d();
            }
        }
        parsableBitArray.m9328d();
        parsableBitArray.m9324b(1);
        c = parsableBitArray.m9328d() + 1;
        d = parsableBitArray.m9328d() + 1;
        boolean b = parsableBitArray.m9325b();
        i = (2 - (b ? 1 : 0)) * d;
        if (!b) {
            parsableBitArray.m9324b(1);
        }
        parsableBitArray.m9324b(1);
        d = c * 16;
        c = i * 16;
        if (parsableBitArray.m9325b()) {
            int d6 = parsableBitArray.m9328d();
            int d7 = parsableBitArray.m9328d();
            int d8 = parsableBitArray.m9328d();
            int d9 = parsableBitArray.m9328d();
            if (i2 == 0) {
                i = 1;
                i2 = 2 - (b ? 1 : 0);
            } else {
                i = i2 == 3 ? 1 : 2;
                i2 = (2 - (b ? 1 : 0)) * (i2 == 1 ? 2 : 1);
            }
            i = d - (i * (d6 + d7));
            c -= i2 * (d8 + d9);
        } else {
            i = d;
        }
        float f2 = 1.0f;
        if (parsableBitArray.m9325b() && parsableBitArray.m9325b()) {
            d = parsableBitArray.m9326c(8);
            if (d == 255) {
                d = parsableBitArray.m9326c(16);
                int c2 = parsableBitArray.m9326c(16);
                if (!(d == 0 || c2 == 0)) {
                    f2 = ((float) d) / ((float) c2);
                }
                f = f2;
            } else if (d < f7724b.length) {
                f = f7724b[d];
            } else {
                Log.w("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + d);
            }
            return new SpsData(d2, i, c, f, z, b, d3, d4, i4, z3);
        }
        f = 1.0f;
        return new SpsData(d2, i, c, f, z, b, d3, d4, i4, z3);
    }

    public static PpsData m9318b(ParsableBitArray parsableBitArray) {
        int d = parsableBitArray.m9328d();
        int d2 = parsableBitArray.m9328d();
        parsableBitArray.m9324b(1);
        return new PpsData(d, d2, parsableBitArray.m9325b());
    }

    public static int m9312a(byte[] bArr, int i, int i2, boolean[] zArr) {
        boolean z = true;
        int i3 = i2 - i;
        Assertions.m9297b(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr != null) {
            if (zArr[0]) {
                m9316a(zArr);
                return i - 3;
            } else if (i3 > 1 && zArr[1] && bArr[i] == (byte) 1) {
                m9316a(zArr);
                return i - 2;
            } else if (i3 > 2 && zArr[2] && bArr[i] == (byte) 0 && bArr[i + 1] == (byte) 1) {
                m9316a(zArr);
                return i - 1;
            }
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            if ((bArr[i5] & 254) == 0) {
                if (bArr[i5 - 2] == (byte) 0 && bArr[i5 - 1] == (byte) 0 && bArr[i5] == (byte) 1) {
                    if (zArr != null) {
                        m9316a(zArr);
                    }
                    return i5 - 2;
                }
                i5 -= 2;
            }
            i5 += 3;
        }
        if (zArr == null) {
            return i2;
        }
        boolean z2 = i3 > 2 ? bArr[i2 + -3] == (byte) 0 && bArr[i2 - 2] == (byte) 0 && bArr[i4] == (byte) 1 : i3 == 2 ? zArr[2] && bArr[i2 - 2] == (byte) 0 && bArr[i4] == (byte) 1 : zArr[1] && bArr[i4] == (byte) 1;
        zArr[0] = z2;
        z2 = i3 > 1 ? bArr[i2 + -2] == (byte) 0 && bArr[i4] == (byte) 0 : zArr[2] && bArr[i4] == (byte) 0;
        zArr[1] = z2;
        if (bArr[i4] != (byte) 0) {
            z = false;
        }
        zArr[2] = z;
        return i2;
    }

    public static void m9316a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    private static int m9311a(byte[] bArr, int i, int i2) {
        int i3 = i;
        while (i3 < i2 - 2) {
            if (bArr[i3] == (byte) 0 && bArr[i3 + 1] == (byte) 0 && bArr[i3 + 2] == (byte) 3) {
                return i3;
            }
            i3++;
        }
        return i2;
    }

    private static void m9314a(ParsableBitArray parsableBitArray, int i) {
        int i2 = 8;
        int i3 = 8;
        for (int i4 = 0; i4 < i; i4++) {
            if (i2 != 0) {
                i2 = ((parsableBitArray.m9329e() + i3) + 256) % 256;
            }
            if (i2 != 0) {
                i3 = i2;
            }
        }
    }

    private NalUnitUtil() {
    }
}

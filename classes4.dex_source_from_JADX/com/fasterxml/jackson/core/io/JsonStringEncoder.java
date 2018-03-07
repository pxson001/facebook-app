package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.lang.ref.SoftReference;

/* compiled from: vault.row_upload_key */
public final class JsonStringEncoder {
    protected static final ThreadLocal<SoftReference<JsonStringEncoder>> f369a = new ThreadLocal();
    private static final char[] f370e = CharTypes.g();
    private static final byte[] f371f = CharTypes.h();
    protected TextBuffer f372b;
    protected ByteArrayBuilder f373c;
    protected final char[] f374d = new char[6];

    public JsonStringEncoder() {
        this.f374d[0] = '\\';
        this.f374d[2] = '0';
        this.f374d[3] = '0';
    }

    public static JsonStringEncoder m636a() {
        SoftReference softReference = (SoftReference) f369a.get();
        JsonStringEncoder jsonStringEncoder = softReference == null ? null : (JsonStringEncoder) softReference.get();
        if (jsonStringEncoder != null) {
            return jsonStringEncoder;
        }
        jsonStringEncoder = new JsonStringEncoder();
        f369a.set(new SoftReference(jsonStringEncoder));
        return jsonStringEncoder;
    }

    public final char[] m639a(String str) {
        TextBuffer textBuffer = this.f372b;
        if (textBuffer == null) {
            textBuffer = new TextBuffer(null);
            this.f372b = textBuffer;
        }
        Object l = textBuffer.l();
        int[] iArr = CharTypes.f;
        char length = iArr.length;
        int length2 = str.length();
        int i = 0;
        int i2 = 0;
        loop0:
        while (i2 < length2) {
            int i3;
            while (true) {
                char charAt = str.charAt(i2);
                if (charAt < length && iArr[charAt] != 0) {
                    break;
                }
                if (i >= l.length) {
                    l = textBuffer.n();
                    i3 = 0;
                } else {
                    i3 = i;
                }
                i = i3 + 1;
                l[i3] = charAt;
                i2++;
                if (i2 >= length2) {
                    break loop0;
                }
            }
            i3 = i2 + 1;
            i2 = str.charAt(i2);
            int i4 = iArr[i2];
            if (i4 < 0) {
                i2 = m635a(i2, this.f374d);
            } else {
                i2 = m638b(i4, this.f374d);
            }
            if (i + i2 > l.length) {
                i4 = l.length - i;
                if (i4 > 0) {
                    System.arraycopy(this.f374d, 0, l, i, i4);
                }
                l = textBuffer.n();
                i = i2 - i4;
                System.arraycopy(this.f374d, i4, l, 0, i);
                i2 = i3;
            } else {
                System.arraycopy(this.f374d, 0, l, i, i2);
                i += i2;
                i2 = i3;
            }
        }
        textBuffer.j = i;
        return textBuffer.h();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] m640b(java.lang.String r13) {
        /*
        r12 = this;
        r9 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        r5 = 0;
        r0 = r12.f373c;
        if (r0 != 0) goto L_0x000f;
    L_0x0007:
        r0 = new com.fasterxml.jackson.core.util.ByteArrayBuilder;
        r1 = 0;
        r0.<init>(r1);
        r12.f373c = r0;
    L_0x000f:
        r7 = r13.length();
        r1 = r0.m12030d();
        r2 = r5;
        r3 = r5;
    L_0x0019:
        if (r3 >= r7) goto L_0x0039;
    L_0x001b:
        r11 = com.fasterxml.jackson.core.io.CharTypes.f;
        r6 = r11;
    L_0x001e:
        r8 = r13.charAt(r3);
        if (r8 > r9) goto L_0x0040;
    L_0x0024:
        r4 = r6[r8];
        if (r4 != 0) goto L_0x0040;
    L_0x0028:
        r4 = r1.length;
        if (r2 < r4) goto L_0x010c;
    L_0x002b:
        r1 = r0.m12033e();
        r4 = r5;
    L_0x0030:
        r2 = r4 + 1;
        r8 = (byte) r8;
        r1[r4] = r8;
        r3 = r3 + 1;
        if (r3 < r7) goto L_0x001e;
    L_0x0039:
        r0 = r12.f373c;
        r0 = r0.m12031d(r2);
        return r0;
    L_0x0040:
        r4 = r1.length;
        if (r2 < r4) goto L_0x0048;
    L_0x0043:
        r1 = r0.m12033e();
        r2 = r5;
    L_0x0048:
        r4 = r3 + 1;
        r8 = r13.charAt(r3);
        if (r8 > r9) goto L_0x005b;
    L_0x0050:
        r1 = r6[r8];
        r2 = m634a(r8, r1, r0, r2);
        r11 = r0.f11541e;
        r1 = r11;
        r3 = r4;
        goto L_0x0019;
    L_0x005b:
        r3 = 2047; // 0x7ff float:2.868E-42 double:1.0114E-320;
        if (r8 > r3) goto L_0x0080;
    L_0x005f:
        r3 = r2 + 1;
        r6 = r8 >> 6;
        r6 = r6 | 192;
        r6 = (byte) r6;
        r1[r2] = r6;
        r2 = r8 & 63;
        r2 = r2 | 128;
        r10 = r2;
        r2 = r1;
        r1 = r10;
    L_0x006f:
        r6 = r2.length;
        if (r3 < r6) goto L_0x0077;
    L_0x0072:
        r2 = r0.m12033e();
        r3 = r5;
    L_0x0077:
        r6 = r3 + 1;
        r1 = (byte) r1;
        r2[r3] = r1;
        r1 = r2;
        r3 = r4;
        r2 = r6;
        goto L_0x0019;
    L_0x0080:
        r3 = 55296; // 0xd800 float:7.7486E-41 double:2.732E-319;
        if (r8 < r3) goto L_0x008a;
    L_0x0085:
        r3 = 57343; // 0xdfff float:8.0355E-41 double:2.8331E-319;
        if (r8 <= r3) goto L_0x00ae;
    L_0x008a:
        r3 = r2 + 1;
        r6 = r8 >> 12;
        r6 = r6 | 224;
        r6 = (byte) r6;
        r1[r2] = r6;
        r2 = r1.length;
        if (r3 < r2) goto L_0x010a;
    L_0x0096:
        r1 = r0.m12033e();
        r2 = r5;
    L_0x009b:
        r3 = r2 + 1;
        r6 = r8 >> 6;
        r6 = r6 & 63;
        r6 = r6 | 128;
        r6 = (byte) r6;
        r1[r2] = r6;
        r2 = r8 & 63;
        r2 = r2 | 128;
        r10 = r2;
        r2 = r1;
        r1 = r10;
        goto L_0x006f;
    L_0x00ae:
        r3 = 56319; // 0xdbff float:7.892E-41 double:2.78253E-319;
        if (r8 <= r3) goto L_0x00b6;
    L_0x00b3:
        m637a(r8);
    L_0x00b6:
        if (r4 < r7) goto L_0x00bb;
    L_0x00b8:
        m637a(r8);
    L_0x00bb:
        r6 = r4 + 1;
        r3 = r13.charAt(r4);
        r4 = m633a(r8, r3);
        r3 = 1114111; // 0x10ffff float:1.561202E-39 double:5.50444E-318;
        if (r4 <= r3) goto L_0x00cd;
    L_0x00ca:
        m637a(r4);
    L_0x00cd:
        r3 = r2 + 1;
        r8 = r4 >> 18;
        r8 = r8 | 240;
        r8 = (byte) r8;
        r1[r2] = r8;
        r2 = r1.length;
        if (r3 < r2) goto L_0x0108;
    L_0x00d9:
        r1 = r0.m12033e();
        r2 = r5;
    L_0x00de:
        r3 = r2 + 1;
        r8 = r4 >> 12;
        r8 = r8 & 63;
        r8 = r8 | 128;
        r8 = (byte) r8;
        r1[r2] = r8;
        r2 = r1.length;
        if (r3 < r2) goto L_0x0106;
    L_0x00ec:
        r1 = r0.m12033e();
        r2 = r5;
    L_0x00f1:
        r3 = r2 + 1;
        r8 = r4 >> 6;
        r8 = r8 & 63;
        r8 = r8 | 128;
        r8 = (byte) r8;
        r1[r2] = r8;
        r2 = r4 & 63;
        r2 = r2 | 128;
        r4 = r6;
        r10 = r1;
        r1 = r2;
        r2 = r10;
        goto L_0x006f;
    L_0x0106:
        r2 = r3;
        goto L_0x00f1;
    L_0x0108:
        r2 = r3;
        goto L_0x00de;
    L_0x010a:
        r2 = r3;
        goto L_0x009b;
    L_0x010c:
        r4 = r2;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.JsonStringEncoder.b(java.lang.String):byte[]");
    }

    public final byte[] m641c(String str) {
        int i;
        ByteArrayBuilder byteArrayBuilder = this.f373c;
        if (byteArrayBuilder == null) {
            byteArrayBuilder = new ByteArrayBuilder(null);
            this.f373c = byteArrayBuilder;
        }
        int length = str.length();
        byte[] d = byteArrayBuilder.m12030d();
        int length2 = d.length;
        int i2 = 0;
        int i3 = 0;
        loop0:
        while (i3 < length) {
            int i4;
            int i5 = i3 + 1;
            i3 = str.charAt(i3);
            int i6 = length2;
            byte[] bArr = d;
            int i7 = i2;
            i2 = i6;
            while (i3 <= 127) {
                if (i7 >= i2) {
                    bArr = byteArrayBuilder.m12033e();
                    i2 = bArr.length;
                    i7 = 0;
                }
                i4 = i7 + 1;
                bArr[i7] = (byte) i3;
                if (i5 >= length) {
                    i = i4;
                    break loop0;
                }
                i7 = i5 + 1;
                i3 = str.charAt(i5);
                i5 = i7;
                i7 = i4;
            }
            if (i7 >= i2) {
                bArr = byteArrayBuilder.m12033e();
                i2 = bArr.length;
                i4 = 0;
            } else {
                i4 = i7;
            }
            if (i3 < 2048) {
                i7 = i4 + 1;
                bArr[i4] = (byte) ((i3 >> 6) | 192);
                i4 = i3;
                i3 = i5;
            } else if (i3 < 55296 || i3 > 57343) {
                i7 = i4 + 1;
                bArr[i4] = (byte) ((i3 >> 12) | 224);
                if (i7 >= i2) {
                    bArr = byteArrayBuilder.m12033e();
                    i2 = bArr.length;
                    i7 = 0;
                }
                i4 = i7 + 1;
                bArr[i7] = (byte) (((i3 >> 6) & 63) | 128);
                i7 = i4;
                i4 = i3;
                i3 = i5;
            } else {
                if (i3 > 56319) {
                    m637a(i3);
                }
                if (i5 >= length) {
                    m637a(i3);
                }
                int i8 = i5 + 1;
                i3 = m633a(i3, str.charAt(i5));
                if (i3 > 1114111) {
                    m637a(i3);
                }
                i7 = i4 + 1;
                bArr[i4] = (byte) ((i3 >> 18) | 240);
                if (i7 >= i2) {
                    bArr = byteArrayBuilder.m12033e();
                    i2 = bArr.length;
                    i7 = 0;
                }
                i4 = i7 + 1;
                bArr[i7] = (byte) (((i3 >> 12) & 63) | 128);
                if (i4 >= i2) {
                    bArr = byteArrayBuilder.m12033e();
                    i2 = bArr.length;
                    i7 = 0;
                } else {
                    i7 = i4;
                }
                i4 = i7 + 1;
                bArr[i7] = (byte) (((i3 >> 6) & 63) | 128);
                i7 = i4;
                i4 = i3;
                i3 = i8;
            }
            if (i7 >= i2) {
                bArr = byteArrayBuilder.m12033e();
                i2 = bArr.length;
                i7 = 0;
            }
            i5 = i7 + 1;
            bArr[i7] = (byte) ((i4 & 63) | 128);
            d = bArr;
            length2 = i2;
            i2 = i5;
        }
        i = i2;
        return this.f373c.m12031d(i);
    }

    private static int m635a(int i, char[] cArr) {
        cArr[1] = 'u';
        cArr[4] = f370e[i >> 4];
        cArr[5] = f370e[i & 15];
        return 6;
    }

    private static int m638b(int i, char[] cArr) {
        cArr[1] = (char) i;
        return 2;
    }

    private static int m634a(int i, int i2, ByteArrayBuilder byteArrayBuilder, int i3) {
        byteArrayBuilder.f11542f = i3;
        byteArrayBuilder.m12025a(92);
        if (i2 < 0) {
            byteArrayBuilder.m12025a(117);
            if (i > 255) {
                int i4 = i >> 8;
                byteArrayBuilder.m12025a(f371f[i4 >> 4]);
                byteArrayBuilder.m12025a(f371f[i4 & 15]);
                i &= 255;
            } else {
                byteArrayBuilder.m12025a(48);
                byteArrayBuilder.m12025a(48);
            }
            byteArrayBuilder.m12025a(f371f[i >> 4]);
            byteArrayBuilder.m12025a(f371f[i & 15]);
        } else {
            byteArrayBuilder.m12025a((byte) i2);
        }
        return byteArrayBuilder.f11542f;
    }

    private static int m633a(int i, int i2) {
        if (i2 >= 56320 && i2 <= 57343) {
            return (65536 + ((i - 55296) << 10)) + (i2 - 56320);
        }
        throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(i2) + "; illegal combination");
    }

    private static void m637a(int i) {
        throw new IllegalArgumentException(UTF8Writer.a(i));
    }
}

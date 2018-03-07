package com.fasterxml.jackson.core.io;

import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Arrays;

/* compiled from: request_feature_tag */
public final class CharTypes {
    public static final int[] f7340a;
    public static final int[] f7341b;
    public static final int[] f7342c;
    public static final int[] f7343d;
    public static final int[] f7344e = new int[256];
    public static final int[] f7345f;
    static final int[] f7346g;
    private static final char[] f7347h;
    private static final byte[] f7348i;

    private CharTypes() {
    }

    static {
        int i;
        char[] toCharArray = "0123456789ABCDEF".toCharArray();
        f7347h = toCharArray;
        int length = toCharArray.length;
        f7348i = new byte[length];
        for (i = 0; i < length; i++) {
            f7348i[i] = (byte) f7347h[i];
        }
        int[] iArr = new int[256];
        for (i = 0; i < 32; i++) {
            iArr[i] = -1;
        }
        iArr[34] = 1;
        iArr[92] = 1;
        f7340a = iArr;
        Object obj = new int[iArr.length];
        System.arraycopy(f7340a, 0, obj, 0, f7340a.length);
        for (length = HTTPTransportCallback.BODY_BYTES_RECEIVED; length < 256; length++) {
            i = (length & 224) == 192 ? 2 : (length & 240) == 224 ? 3 : (length & 248) == 240 ? 4 : -1;
            obj[length] = i;
        }
        f7341b = obj;
        iArr = new int[256];
        Arrays.fill(iArr, -1);
        for (i = 33; i < 256; i++) {
            if (Character.isJavaIdentifierPart((char) i)) {
                iArr[i] = 0;
            }
        }
        iArr[64] = 0;
        iArr[35] = 0;
        iArr[42] = 0;
        iArr[45] = 0;
        iArr[43] = 0;
        f7342c = iArr;
        Object obj2 = new int[256];
        System.arraycopy(f7342c, 0, obj2, 0, f7342c.length);
        Arrays.fill(obj2, HTTPTransportCallback.BODY_BYTES_RECEIVED, HTTPTransportCallback.BODY_BYTES_RECEIVED, 0);
        f7343d = obj2;
        System.arraycopy(f7341b, HTTPTransportCallback.BODY_BYTES_RECEIVED, f7344e, HTTPTransportCallback.BODY_BYTES_RECEIVED, HTTPTransportCallback.BODY_BYTES_RECEIVED);
        Arrays.fill(f7344e, 0, 32, -1);
        f7344e[9] = 0;
        f7344e[10] = 10;
        f7344e[13] = 13;
        f7344e[42] = 42;
        iArr = new int[HTTPTransportCallback.BODY_BYTES_RECEIVED];
        for (i = 0; i < 32; i++) {
            iArr[i] = -1;
        }
        iArr[34] = 34;
        iArr[92] = 92;
        iArr[8] = 98;
        iArr[9] = 116;
        iArr[12] = 102;
        iArr[10] = 110;
        iArr[13] = 114;
        f7345f = iArr;
        int[] iArr2 = new int[HTTPTransportCallback.BODY_BYTES_RECEIVED];
        f7346g = iArr2;
        Arrays.fill(iArr2, -1);
        for (i = 0; i < 10; i++) {
            f7346g[i + 48] = i;
        }
        for (i = 0; i < 6; i++) {
            f7346g[i + 97] = i + 10;
            f7346g[i + 65] = i + 10;
        }
    }

    public static int[] m11933a() {
        return f7340a;
    }

    public static int[] m11934b() {
        return f7341b;
    }

    public static int[] m11935c() {
        return f7342c;
    }

    public static int[] m11936d() {
        return f7343d;
    }

    public static int[] m11937e() {
        return f7344e;
    }

    public static int[] m11938f() {
        return f7345f;
    }

    public static int m11931a(int i) {
        return i > 127 ? -1 : f7346g[i];
    }

    public static void m11932a(StringBuilder stringBuilder, String str) {
        int[] iArr = f7345f;
        char length = iArr.length;
        int length2 = str.length();
        for (int i = 0; i < length2; i++) {
            char charAt = str.charAt(i);
            if (charAt >= length || iArr[charAt] == 0) {
                stringBuilder.append(charAt);
            } else {
                stringBuilder.append('\\');
                int i2 = iArr[charAt];
                if (i2 < 0) {
                    stringBuilder.append('u');
                    stringBuilder.append('0');
                    stringBuilder.append('0');
                    stringBuilder.append(f7347h[charAt >> 4]);
                    stringBuilder.append(f7347h[charAt & 15]);
                } else {
                    stringBuilder.append((char) i2);
                }
            }
        }
    }

    public static char[] m11939g() {
        return (char[]) f7347h.clone();
    }

    public static byte[] m11940h() {
        return (byte[]) f7348i.clone();
    }
}

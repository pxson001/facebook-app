package com.fasterxml.jackson.core;

import com.facebook.proxygen.HTTPTransportCallback;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import java.io.Serializable;
import java.util.Arrays;

/* compiled from: story  */
public final class Base64Variant implements Serializable {
    private static final long serialVersionUID = 1;
    protected final String _name;
    public final transient boolean f4076a;
    public final transient char f4077b;
    public final transient int f4078c;
    private final transient int[] f4079d;
    private final transient char[] f4080e;
    private final transient byte[] f4081f;

    public Base64Variant(String str, String str2, boolean z, char c, int i) {
        int i2 = 0;
        this.f4079d = new int[HTTPTransportCallback.BODY_BYTES_RECEIVED];
        this.f4080e = new char[64];
        this.f4081f = new byte[64];
        this._name = str;
        this.f4076a = z;
        this.f4077b = c;
        this.f4078c = i;
        int length = str2.length();
        if (length != 64) {
            throw new IllegalArgumentException("Base64Alphabet length must be exactly 64 (was " + length + ")");
        }
        str2.getChars(0, length, this.f4080e, 0);
        Arrays.fill(this.f4079d, -1);
        while (i2 < length) {
            char c2 = this.f4080e[i2];
            this.f4081f[i2] = (byte) c2;
            this.f4079d[c2] = i2;
            i2++;
        }
        if (z) {
            this.f4079d[c] = -2;
        }
    }

    public Base64Variant(Base64Variant base64Variant, String str, int i) {
        this(base64Variant, str, base64Variant.f4076a, base64Variant.f4077b, i);
    }

    public Base64Variant(Base64Variant base64Variant, String str, boolean z, char c, int i) {
        this.f4079d = new int[HTTPTransportCallback.BODY_BYTES_RECEIVED];
        this.f4080e = new char[64];
        this.f4081f = new byte[64];
        this._name = str;
        Object obj = base64Variant.f4081f;
        System.arraycopy(obj, 0, this.f4081f, 0, obj.length);
        obj = base64Variant.f4080e;
        System.arraycopy(obj, 0, this.f4080e, 0, obj.length);
        obj = base64Variant.f4079d;
        System.arraycopy(obj, 0, this.f4079d, 0, obj.length);
        this.f4076a = z;
        this.f4077b = c;
        this.f4078c = i;
    }

    protected final Object readResolve() {
        return Base64Variants.m7131a(this._name);
    }

    public final boolean m7142a() {
        return this.f4076a;
    }

    public final boolean m7143a(char c) {
        return c == this.f4077b;
    }

    public final boolean m7144a(int i) {
        return i == this.f4077b;
    }

    public final char m7145b() {
        return this.f4077b;
    }

    public final int m7148c() {
        return this.f4078c;
    }

    public final int m7146b(char c) {
        return c <= '' ? this.f4079d[c] : -1;
    }

    public final int m7147b(int i) {
        return i <= 127 ? this.f4079d[i] : -1;
    }

    public final int m7139a(int i, char[] cArr, int i2) {
        int i3 = i2 + 1;
        cArr[i2] = this.f4080e[(i >> 18) & 63];
        int i4 = i3 + 1;
        cArr[i3] = this.f4080e[(i >> 12) & 63];
        i3 = i4 + 1;
        cArr[i4] = this.f4080e[(i >> 6) & 63];
        i4 = i3 + 1;
        cArr[i3] = this.f4080e[i & 63];
        return i4;
    }

    private void m7133a(StringBuilder stringBuilder, int i) {
        stringBuilder.append(this.f4080e[(i >> 18) & 63]);
        stringBuilder.append(this.f4080e[(i >> 12) & 63]);
        stringBuilder.append(this.f4080e[(i >> 6) & 63]);
        stringBuilder.append(this.f4080e[i & 63]);
    }

    public final int m7137a(int i, int i2, char[] cArr, int i3) {
        int i4 = i3 + 1;
        cArr[i3] = this.f4080e[(i >> 18) & 63];
        int i5 = i4 + 1;
        cArr[i4] = this.f4080e[(i >> 12) & 63];
        if (this.f4076a) {
            int i6 = i5 + 1;
            cArr[i5] = i2 == 2 ? this.f4080e[(i >> 6) & 63] : this.f4077b;
            i4 = i6 + 1;
            cArr[i6] = this.f4077b;
            return i4;
        } else if (i2 != 2) {
            return i5;
        } else {
            i4 = i5 + 1;
            cArr[i5] = this.f4080e[(i >> 6) & 63];
            return i4;
        }
    }

    private void m7134a(StringBuilder stringBuilder, int i, int i2) {
        stringBuilder.append(this.f4080e[(i >> 18) & 63]);
        stringBuilder.append(this.f4080e[(i >> 12) & 63]);
        if (this.f4076a) {
            stringBuilder.append(i2 == 2 ? this.f4080e[(i >> 6) & 63] : this.f4077b);
            stringBuilder.append(this.f4077b);
        } else if (i2 == 2) {
            stringBuilder.append(this.f4080e[(i >> 6) & 63]);
        }
    }

    public final int m7138a(int i, byte[] bArr, int i2) {
        int i3 = i2 + 1;
        bArr[i2] = this.f4081f[(i >> 18) & 63];
        int i4 = i3 + 1;
        bArr[i3] = this.f4081f[(i >> 12) & 63];
        i3 = i4 + 1;
        bArr[i4] = this.f4081f[(i >> 6) & 63];
        i4 = i3 + 1;
        bArr[i3] = this.f4081f[i & 63];
        return i4;
    }

    public final int m7136a(int i, int i2, byte[] bArr, int i3) {
        int i4 = i3 + 1;
        bArr[i3] = this.f4081f[(i >> 18) & 63];
        int i5 = i4 + 1;
        bArr[i4] = this.f4081f[(i >> 12) & 63];
        if (this.f4076a) {
            byte b = (byte) this.f4077b;
            int i6 = i5 + 1;
            bArr[i5] = i2 == 2 ? this.f4081f[(i >> 6) & 63] : b;
            i4 = i6 + 1;
            bArr[i6] = b;
            return i4;
        } else if (i2 != 2) {
            return i5;
        } else {
            i4 = i5 + 1;
            bArr[i5] = this.f4081f[(i >> 6) & 63];
            return i4;
        }
    }

    public final String m7140a(byte[] bArr, boolean z) {
        int i;
        int length = bArr.length;
        StringBuilder stringBuilder = new StringBuilder(((length >> 2) + length) + (length >> 3));
        if (z) {
            stringBuilder.append('\"');
        }
        int i2 = 0;
        int i3 = length - 3;
        int i4 = this.f4078c >> 2;
        while (i2 <= i3) {
            i = i2 + 1;
            int i5 = i + 1;
            i = i5 + 1;
            m7133a(stringBuilder, (((bArr[i2] << 8) | (bArr[i] & 255)) << 8) | (bArr[i5] & 255));
            i2 = i4 - 1;
            if (i2 <= 0) {
                stringBuilder.append('\\');
                stringBuilder.append('n');
                i2 = this.f4078c >> 2;
            }
            i4 = i2;
            i2 = i;
        }
        i = length - i2;
        if (i > 0) {
            i4 = i2 + 1;
            i2 = bArr[i2] << 16;
            if (i == 2) {
                i2 |= (bArr[i4] & 255) << 8;
            }
            m7134a(stringBuilder, i2, i);
        }
        if (z) {
            stringBuilder.append('\"');
        }
        return stringBuilder.toString();
    }

    public final void m7141a(String str, ByteArrayBuilder byteArrayBuilder) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2;
            char charAt;
            while (true) {
                i2 = i + 1;
                charAt = str.charAt(i);
                if (i2 >= length) {
                    return;
                }
                if (charAt > ' ') {
                    break;
                }
                i = i2;
            }
            int b = m7146b(charAt);
            if (b < 0) {
                m7132a(charAt, 0, null);
            }
            if (i2 >= length) {
                m7135d();
            }
            i = i2 + 1;
            char charAt2 = str.charAt(i2);
            int b2 = m7146b(charAt2);
            if (b2 < 0) {
                m7132a(charAt2, 1, null);
            }
            i2 = (b << 6) | b2;
            if (i >= length) {
                if (this.f4076a) {
                    m7135d();
                } else {
                    byteArrayBuilder.a(i2 >> 4);
                    return;
                }
            }
            b = i + 1;
            charAt = str.charAt(i);
            b2 = m7146b(charAt);
            char charAt3;
            if (b2 < 0) {
                if (b2 != -2) {
                    m7132a(charAt, 2, null);
                }
                if (b >= length) {
                    m7135d();
                }
                i = b + 1;
                charAt3 = str.charAt(b);
                if (!m7143a(charAt3)) {
                    m7132a(charAt3, 3, "expected padding character '" + this.f4077b + "'");
                }
                byteArrayBuilder.a(i2 >> 4);
            } else {
                i2 = (i2 << 6) | b2;
                if (b >= length) {
                    if (this.f4076a) {
                        m7135d();
                    } else {
                        byteArrayBuilder.b(i2 >> 2);
                        return;
                    }
                }
                i = b + 1;
                charAt3 = str.charAt(b);
                b2 = m7146b(charAt3);
                if (b2 < 0) {
                    if (b2 != -2) {
                        m7132a(charAt3, 3, null);
                    }
                    byteArrayBuilder.b(i2 >> 2);
                } else {
                    byteArrayBuilder.c((i2 << 6) | b2);
                }
            }
        }
    }

    public final String toString() {
        return this._name;
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return this._name.hashCode();
    }

    private void m7132a(char c, int i, String str) {
        String str2;
        if (c <= ' ') {
            str2 = "Illegal white space character (code 0x" + Integer.toHexString(c) + ") as character #" + (i + 1) + " of 4-char base64 unit: can only used between units";
        } else if (m7143a(c)) {
            str2 = "Unexpected padding character ('" + this.f4077b + "') as character #" + (i + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(c) || Character.isISOControl(c)) {
            str2 = "Illegal character (code 0x" + Integer.toHexString(c) + ") in base64 content";
        } else {
            str2 = "Illegal character '" + c + "' (code 0x" + Integer.toHexString(c) + ") in base64 content";
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        throw new IllegalArgumentException(str2);
    }

    private static void m7135d() {
        throw new IllegalArgumentException("Unexpected end-of-String in base64 content");
    }
}

package com.fasterxml.jackson.dataformat.smile;

import android.support.v7.widget.LinearLayoutCompat;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer;
import com.fasterxml.jackson.core.sym.Name;
import com.fasterxml.jackson.core.util.VersionUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/* compiled from: can_viewer_create_post */
public class SmileParser extends ParserBase {
    protected static final ThreadLocal<SoftReference<SmileBufferRecycler<String>>> ad = new ThreadLocal();
    private static final int[] ae = new int[0];
    private static final String[] af = new String[0];
    protected ObjectCodec f6295M;
    protected boolean f6296N;
    protected final SmileBufferRecycler<String> f6297O;
    protected InputStream f6298P;
    protected byte[] f6299Q;
    protected boolean f6300R;
    protected boolean f6301S = false;
    protected int f6302T;
    protected boolean f6303U;
    protected final BytesToNameCanonicalizer f6304V;
    protected int[] f6305W = ae;
    protected int f6306X;
    protected int f6307Y;
    protected String[] f6308Z = af;
    protected int aa = 0;
    protected String[] ab = null;
    protected int ac = -1;

    /* compiled from: can_viewer_create_post */
    /* synthetic */ class C05601 {
        static final /* synthetic */ int[] f6294a = new int[JsonToken.values().length];

        static {
            try {
                f6294a[JsonToken.VALUE_TRUE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6294a[JsonToken.VALUE_FALSE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6294a[JsonToken.VALUE_STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6294a[JsonToken.FIELD_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f6294a[JsonToken.VALUE_NUMBER_INT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f6294a[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* compiled from: can_viewer_create_post */
    public enum Feature {
        REQUIRE_HEADER(true);
        
        final boolean _defaultState;
        final int _mask;

        public static int collectDefaults() {
            int i = 0;
            for (Feature feature : values()) {
                if (feature.enabledByDefault()) {
                    i |= feature.getMask();
                }
            }
            return i;
        }

        private Feature(boolean z) {
            this._defaultState = z;
            this._mask = 1 << ordinal();
        }

        public final boolean enabledByDefault() {
            return this._defaultState;
        }

        public final int getMask() {
            return this._mask;
        }
    }

    public SmileParser(IOContext iOContext, int i, ObjectCodec objectCodec, BytesToNameCanonicalizer bytesToNameCanonicalizer, InputStream inputStream, byte[] bArr, int i2, int i3, boolean z) {
        super(iOContext, i);
        this.f6295M = objectCodec;
        this.f6304V = bytesToNameCanonicalizer;
        this.f6298P = inputStream;
        this.f6299Q = bArr;
        this.d = i2;
        this.e = i3;
        this.f6300R = z;
        this.j = -1;
        this.k = -1;
        this.f6297O = m11945V();
    }

    public final ObjectCodec m11982a() {
        return this.f6295M;
    }

    public final void m11984a(ObjectCodec objectCodec) {
        this.f6295M = objectCodec;
    }

    protected final boolean m11985a(boolean z, boolean z2) {
        boolean z3 = false;
        if (z) {
            this.d = this.d + 1;
        }
        if (this.d >= this.e) {
            K();
        }
        if (this.f6299Q[this.d] == (byte) 41) {
            int i = this.d + 1;
            this.d = i;
            if (i >= this.e) {
                K();
            }
            if (this.f6299Q[this.d] == (byte) 10) {
                i = this.d + 1;
                this.d = i;
                if (i >= this.e) {
                    K();
                }
                byte[] bArr = this.f6299Q;
                int i2 = this.d;
                this.d = i2 + 1;
                byte b = bArr[i2];
                i2 = (b >> 4) & 15;
                if (i2 != 0) {
                    e("Header version number bits (0x" + Integer.toHexString(i2) + ") indicate unrecognized version; only 0x0 handled by parser");
                }
                if ((b & 1) == 0) {
                    this.f6308Z = null;
                    this.aa = -1;
                }
                if ((b & 2) != 0) {
                    this.ab = af;
                    this.ac = 0;
                }
                if ((b & 4) != 0) {
                    z3 = true;
                }
                this.f6296N = z3;
                return true;
            } else if (!z2) {
                return false;
            } else {
                e("Malformed content: signature not valid, starts with 0x3a, 0x29, but followed by 0x" + Integer.toHexString(this.f6299Q[this.d]) + ", not 0xA");
                return false;
            }
        } else if (!z2) {
            return false;
        } else {
            e("Malformed content: signature not valid, starts with 0x3a but followed by 0x" + Integer.toHexString(this.f6299Q[this.d]) + ", not 0x29");
            return false;
        }
    }

    private static SmileBufferRecycler<String> m11945V() {
        SoftReference softReference = (SoftReference) ad.get();
        SmileBufferRecycler<String> smileBufferRecycler = softReference == null ? null : (SmileBufferRecycler) softReference.get();
        if (smileBufferRecycler != null) {
            return smileBufferRecycler;
        }
        smileBufferRecycler = new SmileBufferRecycler();
        ad.set(new SoftReference(smileBufferRecycler));
        return smileBufferRecycler;
    }

    public Version version() {
        return PackageVersion.VERSION;
    }

    public final int m11981a(OutputStream outputStream) {
        int i = this.e - this.d;
        if (i <= 0) {
            return 0;
        }
        outputStream.write(this.f6299Q, this.d, i);
        return i;
    }

    public final Object m11987b() {
        return this.f6298P;
    }

    public final JsonLocation m11991k() {
        return new JsonLocation(this.b.a, this.i, -1, -1, (int) this.i);
    }

    public final JsonLocation m11992l() {
        long j = ((long) this.d) + this.f;
        return new JsonLocation(this.b.a, j, -1, -1, (int) j);
    }

    protected final boolean m11976L() {
        this.f = this.f + ((long) this.e);
        if (this.f6298P == null) {
            return false;
        }
        int read = this.f6298P.read(this.f6299Q, 0, this.f6299Q.length);
        if (read > 0) {
            this.d = 0;
            this.e = read;
            return true;
        }
        m11978N();
        if (read != 0) {
            return false;
        }
        throw new IOException("InputStream.read() returned 0 characters when trying to read " + this.f6299Q.length + " bytes");
    }

    private boolean m11955f(int i) {
        if (this.f6298P == null) {
            return false;
        }
        int i2 = this.e - this.d;
        if (i2 <= 0 || this.d <= 0) {
            this.e = 0;
        } else {
            this.f = this.f + ((long) this.d);
            System.arraycopy(this.f6299Q, this.d, this.f6299Q, 0, i2);
            this.e = i2;
        }
        this.d = 0;
        while (this.e < i) {
            int read = this.f6298P.read(this.f6299Q, this.e, this.f6299Q.length - this.e);
            if (read <= 0) {
                m11978N();
                if (read != 0) {
                    return false;
                }
                throw new IOException("InputStream.read() returned 0 characters when trying to read " + i2 + " bytes");
            }
            this.e = read + this.e;
        }
        return true;
    }

    protected final void m11978N() {
        if (this.f6298P != null) {
            if (this.b.c || a(com.fasterxml.jackson.core.JsonParser.Feature.AUTO_CLOSE_SOURCE)) {
                this.f6298P.close();
            }
            this.f6298P = null;
        }
    }

    protected final void m11977M() {
        VersionUtil.m10782b();
    }

    public void close() {
        super.close();
        this.f6304V.b();
    }

    public final boolean m11997s() {
        if (this.K == JsonToken.VALUE_STRING) {
            return this.n.e();
        }
        if (this.K == JsonToken.FIELD_NAME) {
            return this.p;
        }
        return false;
    }

    protected final void m11979O() {
        super.O();
        if (this.f6300R) {
            byte[] bArr = this.f6299Q;
            if (bArr != null) {
                this.f6299Q = null;
                this.b.a(bArr);
            }
        }
        String[] strArr = this.f6308Z;
        if (strArr != null && strArr.length > 0) {
            this.f6308Z = null;
            if (this.aa > 0) {
                Arrays.fill(strArr, 0, this.aa, null);
            }
            this.f6297O.f6270a = strArr;
        }
        strArr = this.ab;
        if (strArr != null && strArr.length > 0) {
            this.ab = null;
            if (this.ac > 0) {
                Arrays.fill(strArr, 0, this.ac, null);
            }
            this.f6297O.f6271b = strArr;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.fasterxml.jackson.core.JsonToken m11988c() {
        /*
        r11 = this;
        r9 = 2;
        r8 = -1;
        r2 = 0;
        r1 = 0;
        r0 = 1;
        r11.A = r1;
        r3 = r11.f6301S;
        if (r3 == 0) goto L_0x000e;
    L_0x000b:
        r11.an();
    L_0x000e:
        r4 = r11.f;
        r3 = r11.d;
        r6 = (long) r3;
        r4 = r4 + r6;
        r11.i = r4;
        r11.r = r2;
        r3 = r11.l;
        r3 = r3.d();
        if (r3 == 0) goto L_0x002d;
    L_0x0020:
        r3 = r11.K;
        r4 = com.fasterxml.jackson.core.JsonToken.FIELD_NAME;
        if (r3 == r4) goto L_0x002d;
    L_0x0026:
        r0 = r11.m11948Y();
        r11.K = r0;
    L_0x002c:
        return r0;
    L_0x002d:
        r3 = r11.d;
        r4 = r11.e;
        if (r3 < r4) goto L_0x0043;
    L_0x0033:
        r3 = r11.m11976L();
        if (r3 != 0) goto L_0x0043;
    L_0x0039:
        r11.P();
        r11.close();
        r11.K = r2;
        r0 = r2;
        goto L_0x002c;
    L_0x0043:
        r3 = r11.f6299Q;
        r4 = r11.d;
        r5 = r4 + 1;
        r11.d = r5;
        r3 = r3[r4];
        r11.f6302T = r3;
        r4 = r3 >> 5;
        r4 = r4 & 7;
        switch(r4) {
            case 0: goto L_0x0076;
            case 1: goto L_0x0084;
            case 2: goto L_0x00ef;
            case 3: goto L_0x00ef;
            case 4: goto L_0x00ef;
            case 5: goto L_0x00ef;
            case 6: goto L_0x0101;
            case 7: goto L_0x0111;
            default: goto L_0x0056;
        };
    L_0x0056:
        r0 = new java.lang.StringBuilder;
        r1 = "Invalid type marker byte 0x";
        r0.<init>(r1);
        r1 = r3 & 255;
        r1 = java.lang.Integer.toHexString(r1);
        r0 = r0.append(r1);
        r1 = " for expected value token";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r11.e(r0);
        r0 = r2;
        goto L_0x002c;
    L_0x0076:
        if (r3 != 0) goto L_0x007d;
    L_0x0078:
        r0 = "Invalid token byte 0x00";
        r11.e(r0);
    L_0x007d:
        r0 = r3 + -1;
        r0 = r11.m11956g(r0);
        goto L_0x002c;
    L_0x0084:
        r4 = r3 & 31;
        r5 = 4;
        if (r4 >= r5) goto L_0x00a5;
    L_0x0089:
        switch(r4) {
            case 0: goto L_0x0091;
            case 1: goto L_0x009b;
            case 2: goto L_0x00a0;
            default: goto L_0x008c;
        };
    L_0x008c:
        r0 = com.fasterxml.jackson.core.JsonToken.VALUE_TRUE;
        r11.K = r0;
        goto L_0x002c;
    L_0x0091:
        r0 = r11.n;
        r0.b();
        r0 = com.fasterxml.jackson.core.JsonToken.VALUE_STRING;
        r11.K = r0;
        goto L_0x002c;
    L_0x009b:
        r0 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
        r11.K = r0;
        goto L_0x002c;
    L_0x00a0:
        r0 = com.fasterxml.jackson.core.JsonToken.VALUE_FALSE;
        r11.K = r0;
        goto L_0x002c;
    L_0x00a5:
        r5 = 8;
        if (r4 >= r5) goto L_0x00b7;
    L_0x00a9:
        r4 = r4 & 3;
        if (r4 > r9) goto L_0x0056;
    L_0x00ad:
        r11.f6301S = r0;
        r11.A = r1;
        r0 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_INT;
        r11.K = r0;
        goto L_0x002c;
    L_0x00b7:
        r5 = 12;
        if (r4 >= r5) goto L_0x00cf;
    L_0x00bb:
        r4 = r4 & 3;
        if (r4 > r9) goto L_0x0056;
    L_0x00bf:
        r11.f6301S = r0;
        r11.A = r1;
        if (r4 != 0) goto L_0x00cd;
    L_0x00c5:
        r11.f6303U = r0;
        r0 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_FLOAT;
        r11.K = r0;
        goto L_0x002c;
    L_0x00cd:
        r0 = r1;
        goto L_0x00c5;
    L_0x00cf:
        r0 = 26;
        if (r4 != r0) goto L_0x00e8;
    L_0x00d3:
        r0 = r11.m11985a(r1, r1);
        if (r0 == 0) goto L_0x00e8;
    L_0x00d9:
        r0 = r11.K;
        if (r0 != 0) goto L_0x00e3;
    L_0x00dd:
        r0 = r11.c();
        goto L_0x002c;
    L_0x00e3:
        r11.K = r2;
        r0 = r2;
        goto L_0x002c;
    L_0x00e8:
        r0 = "Unrecognized token byte 0x3A (malformed segment header?";
        r11.e(r0);
        goto L_0x0056;
    L_0x00ef:
        r1 = com.fasterxml.jackson.core.JsonToken.VALUE_STRING;
        r11.K = r1;
        r1 = r11.ac;
        if (r1 < 0) goto L_0x00fe;
    L_0x00f7:
        r11.m11946W();
    L_0x00fa:
        r0 = r11.K;
        goto L_0x002c;
    L_0x00fe:
        r11.f6301S = r0;
        goto L_0x00fa;
    L_0x0101:
        r1 = r3 & 31;
        r1 = com.fasterxml.jackson.dataformat.smile.SmileUtil.m12003b(r1);
        r11.B = r1;
        r11.A = r0;
        r0 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_INT;
        r11.K = r0;
        goto L_0x002c;
    L_0x0111:
        r1 = r3 & 31;
        switch(r1) {
            case 0: goto L_0x0118;
            case 4: goto L_0x0118;
            case 8: goto L_0x0120;
            case 12: goto L_0x0128;
            case 13: goto L_0x0128;
            case 14: goto L_0x0128;
            case 15: goto L_0x0128;
            case 24: goto L_0x0148;
            case 25: goto L_0x0156;
            case 26: goto L_0x0172;
            case 27: goto L_0x0180;
            case 29: goto L_0x0185;
            case 31: goto L_0x018d;
            default: goto L_0x0116;
        };
    L_0x0116:
        goto L_0x0056;
    L_0x0118:
        r11.f6301S = r0;
        r0 = com.fasterxml.jackson.core.JsonToken.VALUE_STRING;
        r11.K = r0;
        goto L_0x002c;
    L_0x0120:
        r11.f6301S = r0;
        r0 = com.fasterxml.jackson.core.JsonToken.VALUE_EMBEDDED_OBJECT;
        r11.K = r0;
        goto L_0x002c;
    L_0x0128:
        r0 = r11.d;
        r1 = r11.e;
        if (r0 < r1) goto L_0x0131;
    L_0x012e:
        r11.K();
    L_0x0131:
        r0 = r3 & 3;
        r0 = r0 << 8;
        r1 = r11.f6299Q;
        r2 = r11.d;
        r3 = r2 + 1;
        r11.d = r3;
        r1 = r1[r2];
        r1 = r1 & 255;
        r0 = r0 + r1;
        r0 = r11.m11956g(r0);
        goto L_0x002c;
    L_0x0148:
        r0 = r11.l;
        r0 = r0.b(r8, r8);
        r11.l = r0;
        r0 = com.fasterxml.jackson.core.JsonToken.START_ARRAY;
        r11.K = r0;
        goto L_0x002c;
    L_0x0156:
        r0 = r11.l;
        r0 = r0.b();
        if (r0 != 0) goto L_0x0165;
    L_0x015e:
        r0 = 93;
        r1 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        r11.a(r0, r1);
    L_0x0165:
        r0 = r11.l;
        r10 = r0.c;
        r0 = r10;
        r11.l = r0;
        r0 = com.fasterxml.jackson.core.JsonToken.END_ARRAY;
        r11.K = r0;
        goto L_0x002c;
    L_0x0172:
        r0 = r11.l;
        r0 = r0.c(r8, r8);
        r11.l = r0;
        r0 = com.fasterxml.jackson.core.JsonToken.START_OBJECT;
        r11.K = r0;
        goto L_0x002c;
    L_0x0180:
        r1 = "Invalid type marker byte 0xFB in value mode (would be END_OBJECT in key mode)";
        r11.e(r1);
    L_0x0185:
        r11.f6301S = r0;
        r0 = com.fasterxml.jackson.core.JsonToken.VALUE_EMBEDDED_OBJECT;
        r11.K = r0;
        goto L_0x002c;
    L_0x018d:
        r11.K = r2;
        r0 = r2;
        goto L_0x002c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.dataformat.smile.SmileParser.c():com.fasterxml.jackson.core.JsonToken");
    }

    private final JsonToken m11956g(int i) {
        if (i >= this.ac) {
            m11970u(i);
        }
        this.n.a(this.ab[i]);
        JsonToken jsonToken = JsonToken.VALUE_STRING;
        this.K = jsonToken;
        return jsonToken;
    }

    private final void m11946W() {
        aa();
        if (this.ac < this.ab.length) {
            String[] strArr = this.ab;
            int i = this.ac;
            this.ac = i + 1;
            strArr[i] = this.n.g();
            return;
        }
        m11947X();
    }

    private final void m11947X() {
        String[] strArr;
        int i = 1024;
        Object obj = this.ab;
        int length = obj.length;
        if (length == 0) {
            strArr = (String[]) this.f6297O.m11866b();
            if (strArr == null) {
                strArr = new String[64];
            }
        } else if (length == 1024) {
            this.ac = 0;
            Object obj2 = obj;
        } else {
            if (length == 64) {
                i = 256;
            }
            strArr = new String[i];
            System.arraycopy(obj, 0, strArr, 0, obj.length);
        }
        this.ab = strArr;
        strArr = this.ab;
        int i2 = this.ac;
        this.ac = i2 + 1;
        strArr[i2] = this.n.g();
    }

    public final NumberType m11998u() {
        if (this.f6303U) {
            return NumberType.FLOAT;
        }
        return super.u();
    }

    public final String m11990e() {
        if (!this.l.d() || this.K == JsonToken.FIELD_NAME) {
            if (this.f6301S) {
                an();
            }
            int i = this.d;
            if (i >= this.e) {
                if (m11976L()) {
                    i = this.d;
                } else {
                    P();
                    close();
                    this.K = null;
                    return null;
                }
            }
            int i2 = i + 1;
            byte b = this.f6299Q[i];
            this.i = this.f + ((long) this.d);
            this.r = null;
            this.f6302T = b;
            String str;
            String[] strArr;
            int i3;
            switch ((b >> 5) & 7) {
                case 0:
                    if (b == (byte) 0) {
                        e("Invalid token byte 0x00");
                    }
                    i = b - 1;
                    if (i >= this.ac) {
                        m11970u(i);
                    }
                    this.d = i2;
                    str = this.ab[i];
                    this.n.a(str);
                    this.K = JsonToken.VALUE_STRING;
                    return str;
                case 1:
                    if ((b & 31) == 0) {
                        this.d = i2;
                        this.n.b();
                        this.K = JsonToken.VALUE_STRING;
                        return "";
                    }
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                case 3:
                    this.K = JsonToken.VALUE_STRING;
                    this.d = i2;
                    m11962m((b & 63) + 1);
                    if (this.ac >= 0) {
                        if (this.ac < this.ab.length) {
                            str = this.n.g();
                            strArr = this.ab;
                            i3 = this.ac;
                            this.ac = i3 + 1;
                            strArr[i3] = str;
                            return str;
                        }
                        m11947X();
                    }
                    return this.n.g();
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                case 5:
                    this.K = JsonToken.VALUE_STRING;
                    this.d = i2;
                    m11963n((b & 63) + 2);
                    if (this.ac >= 0) {
                        if (this.ac < this.ab.length) {
                            str = this.n.g();
                            strArr = this.ab;
                            i3 = this.ac;
                            this.ac = i3 + 1;
                            strArr[i3] = str;
                            return str;
                        }
                        m11947X();
                    }
                    return this.n.g();
            }
        }
        if (c() == JsonToken.VALUE_STRING) {
            return o();
        }
        return null;
    }

    public final int m11980a(int i) {
        if (c() == JsonToken.VALUE_NUMBER_INT) {
            return x();
        }
        return i;
    }

    public final String m11993o() {
        if (this.f6301S) {
            this.f6301S = false;
            int i = this.f6302T;
            int i2 = (i >> 5) & 7;
            if (i2 == 2 || i2 == 3) {
                m11962m((i & 63) + 1);
                return this.n.g();
            } else if (i2 == 4 || i2 == 5) {
                m11963n((i & 63) + 2);
                return this.n.g();
            } else {
                aa();
            }
        }
        if (this.K == JsonToken.VALUE_STRING) {
            return this.n.g();
        }
        JsonToken jsonToken = this.K;
        if (jsonToken == null) {
            return null;
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            return this.l.h();
        }
        if (jsonToken.isNumeric()) {
            return t().toString();
        }
        return this.K.asString();
    }

    public final char[] m11994p() {
        if (this.K == null) {
            return null;
        }
        if (this.f6301S) {
            aa();
        }
        switch (C05601.f6294a[this.K.ordinal()]) {
            case 3:
                return this.n.f();
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                if (!this.p) {
                    String h = this.l.h();
                    int length = h.length();
                    if (this.o == null) {
                        this.o = this.b.a(length);
                    } else if (this.o.length < length) {
                        this.o = new char[length];
                    }
                    h.getChars(0, length, this.o, 0);
                    this.p = true;
                }
                return this.o;
            case 5:
            case 6:
                return t().toString().toCharArray();
            default:
                return this.K.asCharArray();
        }
    }

    public final int m11995q() {
        if (this.K == null) {
            return 0;
        }
        if (this.f6301S) {
            aa();
        }
        switch (C05601.f6294a[this.K.ordinal()]) {
            case 3:
                return this.n.c();
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                return this.l.h().length();
            case 5:
            case 6:
                return t().toString().length();
            default:
                return this.K.asCharArray().length;
        }
    }

    public final int m11996r() {
        return 0;
    }

    public final String m11975I() {
        if (this.K == JsonToken.VALUE_STRING || (this.K != null && this.K != JsonToken.VALUE_NULL && this.K.isScalarValue())) {
            return o();
        }
        return null;
    }

    public final String m11983a(String str) {
        return (this.K == JsonToken.VALUE_STRING || !(this.K == null || this.K == JsonToken.VALUE_NULL || !this.K.isScalarValue())) ? o() : str;
    }

    public final byte[] m11986a(Base64Variant base64Variant) {
        if (this.f6301S) {
            aa();
        }
        if (this.K != JsonToken.VALUE_EMBEDDED_OBJECT) {
            e("Current token (" + this.K + ") not VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        return this.r;
    }

    public final Object m11974D() {
        if (this.f6301S) {
            aa();
        }
        if (this.K == JsonToken.VALUE_EMBEDDED_OBJECT) {
            return this.r;
        }
        return null;
    }

    private JsonToken m11948Y() {
        if (this.d >= this.e) {
            K();
        }
        byte[] bArr = this.f6299Q;
        int i = this.d;
        this.d = i + 1;
        byte b = bArr[i];
        this.f6302T = b;
        int i2;
        int i3;
        Name j;
        String str;
        String[] strArr;
        switch ((b >> 6) & 3) {
            case 0:
                switch (b) {
                    case (byte) 32:
                        this.l.f = "";
                        return JsonToken.FIELD_NAME;
                    case (byte) 48:
                    case (byte) 49:
                    case (byte) 50:
                    case (byte) 51:
                        if (this.d >= this.e) {
                            K();
                        }
                        i2 = (b & 3) << 8;
                        byte[] bArr2 = this.f6299Q;
                        i3 = this.d;
                        this.d = i3 + 1;
                        i2 += bArr2[i3] & 255;
                        if (i2 >= this.aa) {
                            m11969t(i2);
                        }
                        this.l.f = this.f6308Z[i2];
                        return JsonToken.FIELD_NAME;
                    case (byte) 52:
                        m11949Z();
                        return JsonToken.FIELD_NAME;
                    default:
                        break;
                }
            case 1:
                i2 = b & 63;
                if (i2 >= this.aa) {
                    m11969t(i2);
                }
                this.l.f = this.f6308Z[i2];
                return JsonToken.FIELD_NAME;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                i = (b & 63) + 1;
                j = m11959j(i);
                if (j != null) {
                    str = j.a;
                    this.d = i + this.d;
                } else {
                    str = m11954d(i, m11957h(i));
                }
                if (this.f6308Z != null) {
                    if (this.aa >= this.f6308Z.length) {
                        this.f6308Z = m11953a(this.f6308Z);
                    }
                    strArr = this.f6308Z;
                    i3 = this.aa;
                    this.aa = i3 + 1;
                    strArr[i3] = str;
                }
                this.l.f = str;
                return JsonToken.FIELD_NAME;
            case 3:
                i2 = b & 63;
                if (i2 <= 55) {
                    i = i2 + 2;
                    j = m11959j(i);
                    if (j != null) {
                        str = j.a;
                        this.d = i + this.d;
                    } else {
                        str = m11954d(i, m11958i(i));
                    }
                    if (this.f6308Z != null) {
                        if (this.aa >= this.f6308Z.length) {
                            this.f6308Z = m11953a(this.f6308Z);
                        }
                        strArr = this.f6308Z;
                        i3 = this.aa;
                        this.aa = i3 + 1;
                        strArr[i3] = str;
                    }
                    this.l.f = str;
                    return JsonToken.FIELD_NAME;
                } else if (i2 == 59) {
                    if (!this.l.d()) {
                        a(125, ']');
                    }
                    this.l = this.l.c;
                    return JsonToken.END_OBJECT;
                }
                break;
        }
        e("Invalid type marker byte 0x" + Integer.toHexString(this.f6302T) + " for expected field name (or END_OBJECT marker)");
        return null;
    }

    private final String[] m11953a(String[] strArr) {
        int i = 1024;
        int length = strArr.length;
        String[] strArr2;
        if (length == 0) {
            strArr2 = (String[]) this.f6297O.m11864a();
            if (strArr2 == null) {
                return new String[64];
            }
            return strArr2;
        } else if (length == 1024) {
            this.aa = 0;
            return strArr;
        } else {
            if (length == 64) {
                i = 256;
            }
            strArr2 = new String[i];
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            return strArr2;
        }
    }

    private final String m11954d(int i, String str) {
        if (i < 5) {
            return this.f6304V.a(str, this.f6306X, 0).a;
        }
        if (i < 9) {
            return this.f6304V.a(str, this.f6306X, this.f6307Y).a;
        }
        return this.f6304V.a(str, this.f6305W, (i + 3) >> 2).a;
    }

    private final String m11957h(int i) {
        int i2;
        char[] l = this.n.l();
        byte[] bArr = this.f6299Q;
        int i3 = this.d;
        int i4 = (i3 + i) - 3;
        int i5 = 0;
        while (i3 < i4) {
            i2 = i5 + 1;
            int i6 = i3 + 1;
            l[i5] = (char) bArr[i3];
            i3 = i2 + 1;
            i5 = i6 + 1;
            l[i2] = (char) bArr[i6];
            i6 = i3 + 1;
            int i7 = i5 + 1;
            l[i3] = (char) bArr[i5];
            i2 = i6 + 1;
            i3 = i7 + 1;
            l[i6] = (char) bArr[i7];
            i5 = i2;
        }
        i4 = i & 3;
        if (i4 > 0) {
            i6 = i5 + 1;
            i2 = i3 + 1;
            l[i5] = (char) bArr[i3];
            if (i4 > 1) {
                i5 = i6 + 1;
                i3 = i2 + 1;
                l[i6] = (char) bArr[i2];
                if (i4 > 2) {
                    i2 = i3 + 1;
                    l[i5] = (char) bArr[i3];
                }
            }
            this.d = i2;
            this.n.j = i;
            return this.n.g();
        }
        i2 = i3;
        this.d = i2;
        this.n.j = i;
        return this.n.g();
    }

    private final String m11958i(int i) {
        int i2 = 0;
        char[] l = this.n.l();
        int i3 = this.d;
        this.d = this.d + i;
        int[] iArr = SmileConstants.f6272a;
        byte[] bArr = this.f6299Q;
        int i4 = i3 + i;
        while (i3 < i4) {
            int i5 = i3 + 1;
            int i6 = bArr[i3] & 255;
            i3 = iArr[i6];
            if (i3 != 0) {
                switch (i3) {
                    case 1:
                        i3 = i5 + 1;
                        i6 = ((i6 & 31) << 6) | (bArr[i5] & 63);
                        i5 = i2;
                        continue;
                    case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                        int i7 = i5 + 1;
                        i3 = i7 + 1;
                        i6 = (((i6 & 15) << 12) | ((bArr[i5] & 63) << 6)) | (bArr[i7] & 63);
                        i5 = i2;
                        continue;
                    case 3:
                        i3 = i5 + 1;
                        i6 = ((i6 & 7) << 18) | ((bArr[i5] & 63) << 12);
                        i5 = i3 + 1;
                        i6 |= (bArr[i3] & 63) << 6;
                        i3 = i5 + 1;
                        i6 = (i6 | (bArr[i5] & 63)) - 65536;
                        i5 = i2 + 1;
                        l[i2] = (char) (55296 | (i6 >> 10));
                        i6 = (i6 & 1023) | 56320;
                        continue;
                    default:
                        e("Invalid byte " + Integer.toHexString(i6) + " in short Unicode text block");
                        break;
                }
            }
            i3 = i5;
            i5 = i2;
            i2 = i5 + 1;
            l[i5] = (char) i6;
        }
        this.n.j = i2;
        return this.n.g();
    }

    private final Name m11950a(int[] iArr, int i, int i2) {
        int i3;
        int i4 = i & 3;
        if (i4 < 4) {
            i3 = iArr[i2 - 1];
            iArr[i2 - 1] = i3 << ((4 - i4) << 3);
        } else {
            i3 = 0;
        }
        char[] l = this.n.l();
        int i5 = 0;
        int i6 = 0;
        while (i6 < i) {
            char[] cArr;
            int i7;
            int i8 = (iArr[i6 >> 2] >> ((3 - (i6 & 3)) << 3)) & 255;
            i6++;
            if (i8 > 127) {
                int i9;
                if ((i8 & 224) == 192) {
                    i8 &= 31;
                    i9 = 1;
                } else if ((i8 & 240) == 224) {
                    i8 &= 15;
                    i9 = 2;
                } else if ((i8 & 248) == 240) {
                    i8 &= 7;
                    i9 = 3;
                } else {
                    m11972w(i8);
                    i8 = 1;
                    i9 = 1;
                }
                if (i6 + i9 > i) {
                    d(" in long field name");
                }
                int i10 = iArr[i6 >> 2] >> ((3 - (i6 & 3)) << 3);
                i6++;
                if ((i10 & 192) != 128) {
                    m11973x(i10);
                }
                i8 = (i8 << 6) | (i10 & 63);
                if (i9 > 1) {
                    i10 = iArr[i6 >> 2] >> ((3 - (i6 & 3)) << 3);
                    i6++;
                    if ((i10 & 192) != 128) {
                        m11973x(i10);
                    }
                    i8 = (i8 << 6) | (i10 & 63);
                    if (i9 > 2) {
                        i10 = iArr[i6 >> 2] >> ((3 - (i6 & 3)) << 3);
                        i6++;
                        if ((i10 & 192) != 128) {
                            m11973x(i10 & 255);
                        }
                        i8 = (i8 << 6) | (i10 & 63);
                    }
                }
                if (i9 > 2) {
                    i8 -= 65536;
                    if (i5 >= l.length) {
                        l = this.n.o();
                    }
                    i9 = i5 + 1;
                    l[i5] = (char) (55296 + (i8 >> 10));
                    int i11 = (i8 & 1023) | 56320;
                    i8 = i6;
                    i6 = i9;
                    cArr = l;
                    i7 = i11;
                    if (i6 >= cArr.length) {
                        cArr = this.n.o();
                    }
                    i5 = i6 + 1;
                    cArr[i6] = (char) i7;
                    i6 = i8;
                    l = cArr;
                }
            }
            cArr = l;
            i7 = i8;
            i8 = i6;
            i6 = i5;
            if (i6 >= cArr.length) {
                cArr = this.n.o();
            }
            i5 = i6 + 1;
            cArr[i6] = (char) i7;
            i6 = i8;
            l = cArr;
        }
        String str = new String(l, 0, i5);
        if (i4 < 4) {
            iArr[i2 - 1] = i3;
        }
        return this.f6304V.a(str, iArr, i2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m11949Z() {
        /*
        r8 = this;
        r1 = 0;
        r6 = -4;
        r4 = r8.f6299Q;
        r0 = r1;
        r2 = r1;
    L_0x0006:
        r3 = r8.d;
        r5 = r8.e;
        if (r3 < r5) goto L_0x000f;
    L_0x000c:
        r8.K();
    L_0x000f:
        r3 = r8.d;
        r5 = r3 + 1;
        r8.d = r5;
        r3 = r4[r3];
        if (r6 != r3) goto L_0x0068;
    L_0x0019:
        r3 = r0;
        r4 = r1;
    L_0x001b:
        r0 = r2 << 2;
        if (r4 <= 0) goto L_0x0039;
    L_0x001f:
        r1 = r8.f6305W;
        r1 = r1.length;
        if (r2 < r1) goto L_0x0031;
    L_0x0024:
        r1 = r8.f6305W;
        r5 = r8.f6305W;
        r5 = r5.length;
        r5 = r5 + 256;
        r1 = m11952a(r1, r5);
        r8.f6305W = r1;
    L_0x0031:
        r5 = r8.f6305W;
        r1 = r2 + 1;
        r5[r2] = r3;
        r0 = r0 + r4;
        r2 = r1;
    L_0x0039:
        r1 = r8.f6304V;
        r3 = r8.f6305W;
        r1 = r1.a(r3, r2);
        if (r1 == 0) goto L_0x00db;
    L_0x0043:
        r7 = r1.a;
        r0 = r7;
    L_0x0046:
        r1 = r8.f6308Z;
        if (r1 == 0) goto L_0x0063;
    L_0x004a:
        r1 = r8.aa;
        r2 = r8.f6308Z;
        r2 = r2.length;
        if (r1 < r2) goto L_0x0059;
    L_0x0051:
        r1 = r8.f6308Z;
        r1 = r8.m11953a(r1);
        r8.f6308Z = r1;
    L_0x0059:
        r1 = r8.f6308Z;
        r2 = r8.aa;
        r3 = r2 + 1;
        r8.aa = r3;
        r1[r2] = r0;
    L_0x0063:
        r1 = r8.l;
        r1.f = r0;
        return;
    L_0x0068:
        r0 = r3 & 255;
        r3 = r8.d;
        r5 = r8.e;
        if (r3 < r5) goto L_0x0073;
    L_0x0070:
        r8.K();
    L_0x0073:
        r3 = r8.d;
        r5 = r3 + 1;
        r8.d = r5;
        r3 = r4[r3];
        if (r6 != r3) goto L_0x0081;
    L_0x007d:
        r1 = 1;
        r3 = r0;
        r4 = r1;
        goto L_0x001b;
    L_0x0081:
        r0 = r0 << 8;
        r3 = r3 & 255;
        r0 = r0 | r3;
        r3 = r8.d;
        r5 = r8.e;
        if (r3 < r5) goto L_0x008f;
    L_0x008c:
        r8.K();
    L_0x008f:
        r3 = r8.d;
        r5 = r3 + 1;
        r8.d = r5;
        r3 = r4[r3];
        if (r6 != r3) goto L_0x009e;
    L_0x0099:
        r1 = 2;
        r3 = r0;
        r4 = r1;
        goto L_0x001b;
    L_0x009e:
        r0 = r0 << 8;
        r3 = r3 & 255;
        r0 = r0 | r3;
        r3 = r8.d;
        r5 = r8.e;
        if (r3 < r5) goto L_0x00ac;
    L_0x00a9:
        r8.K();
    L_0x00ac:
        r3 = r8.d;
        r5 = r3 + 1;
        r8.d = r5;
        r3 = r4[r3];
        if (r6 != r3) goto L_0x00bb;
    L_0x00b6:
        r1 = 3;
        r3 = r0;
        r4 = r1;
        goto L_0x001b;
    L_0x00bb:
        r0 = r0 << 8;
        r3 = r3 & 255;
        r0 = r0 | r3;
        r3 = r8.f6305W;
        r3 = r3.length;
        if (r2 < r3) goto L_0x00d2;
    L_0x00c5:
        r3 = r8.f6305W;
        r5 = r8.f6305W;
        r5 = r5.length;
        r5 = r5 + 256;
        r3 = m11952a(r3, r5);
        r8.f6305W = r3;
    L_0x00d2:
        r5 = r8.f6305W;
        r3 = r2 + 1;
        r5[r2] = r0;
        r2 = r3;
        goto L_0x0006;
    L_0x00db:
        r1 = r8.f6305W;
        r0 = r8.m11950a(r1, r0, r2);
        r7 = r0.a;
        r0 = r7;
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.dataformat.smile.SmileParser.Z():void");
    }

    private final Name m11959j(int i) {
        if (this.e - this.d < i) {
            m11955f(i);
        }
        int i2;
        int i3;
        if (i < 5) {
            int i4 = this.d;
            byte[] bArr = this.f6299Q;
            i2 = bArr[i4] & 255;
            i3 = i - 1;
            if (i3 > 0) {
                i4++;
                i2 = (i2 << 8) + (bArr[i4] & 255);
                i3--;
                if (i3 > 0) {
                    i4++;
                    i2 = (i2 << 8) + (bArr[i4] & 255);
                    if (i3 - 1 > 0) {
                        i2 = (i2 << 8) + (bArr[i4 + 1] & 255);
                    }
                }
            }
            this.f6306X = i2;
            return this.f6304V.a(i2);
        } else if (i >= 9) {
            return m11960k(i);
        } else {
            i2 = this.d;
            byte[] bArr2 = this.f6299Q;
            i2++;
            i2++;
            i2++;
            int i5 = ((((((bArr2[i2] & 255) << 8) + (bArr2[i2] & 255)) << 8) + (bArr2[i2] & 255)) << 8) + (bArr2[i2] & 255);
            i3 = i2 + 1;
            i2 = bArr2[i3] & 255;
            int i6 = i - 5;
            if (i6 > 0) {
                i3++;
                i2 = (i2 << 8) + (bArr2[i3] & 255);
                i6--;
                if (i6 > 0) {
                    i3++;
                    i2 = (i2 << 8) + (bArr2[i3] & 255);
                    if (i6 - 1 > 0) {
                        i2 = (i2 << 8) + (bArr2[i3 + 1] & 255);
                    }
                }
            }
            this.f6306X = i5;
            this.f6307Y = i2;
            return this.f6304V.a(i5, i2);
        }
    }

    private final Name m11960k(int i) {
        int i2;
        int i3 = (i + 3) >> 2;
        if (i3 > this.f6305W.length) {
            this.f6305W = m11952a(this.f6305W, i3);
        }
        int i4 = 0;
        i3 = this.d;
        byte[] bArr = this.f6299Q;
        while (true) {
            i2 = i3 + 1;
            int i5 = i2 + 1;
            i2 = i5 + 1;
            i5 = (((((bArr[i3] & 255) << 8) | (bArr[i2] & 255)) << 8) | (bArr[i5] & 255)) << 8;
            i3 = i2 + 1;
            i5 |= bArr[i2] & 255;
            i2 = i4 + 1;
            this.f6305W[i4] = i5;
            i -= 4;
            if (i <= 3) {
                break;
            }
            i4 = i2;
        }
        if (i > 0) {
            i4 = bArr[i3] & 255;
            i5 = i - 1;
            if (i5 > 0) {
                int i6 = i3 + 1;
                i3 = (bArr[i6] & 255) + (i4 << 8);
                if (i5 - 1 > 0) {
                    i3 = (i3 << 8) + (bArr[i6 + 1] & 255);
                }
            } else {
                i3 = i4;
            }
            i4 = i2 + 1;
            this.f6305W[i2] = i3;
            i2 = i4;
        }
        return this.f6304V.a(this.f6305W, i2);
    }

    private static int[] m11952a(int[] iArr, int i) {
        Object obj = new int[(i + 4)];
        if (iArr != null) {
            System.arraycopy(iArr, 0, obj, 0, iArr.length);
        }
        return obj;
    }

    protected final void m11989c(int i) {
        if (this.f6301S) {
            int i2 = this.f6302T;
            if (((i2 >> 5) & 7) != 1) {
                e("Current token (" + this.K + ") not numeric, can not use numeric value accessors");
            }
            this.f6301S = false;
            m11961l(i2);
        }
    }

    private void aa() {
        this.f6301S = false;
        int i = this.f6302T;
        int i2 = (i >> 5) & 7;
        if (i2 == 1) {
            m11961l(i);
        } else if (i2 <= 3) {
            m11962m((i & 63) + 1);
        } else if (i2 <= 5) {
            m11963n((i & 63) + 2);
        } else {
            if (i2 == 7) {
                switch ((i & 31) >> 2) {
                    case 0:
                        ak();
                        return;
                    case 1:
                        al();
                        return;
                    case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                        this.r = aj();
                        return;
                    case 7:
                        am();
                        return;
                }
            }
            VersionUtil.m10782b();
        }
    }

    private void m11961l(int i) {
        int i2 = i & 31;
        int i3 = i2 >> 2;
        if (i3 == 1) {
            i2 &= 3;
            if (i2 == 0) {
                ab();
                return;
            } else if (i2 == 1) {
                ac();
                return;
            } else if (i2 == 2) {
                ad();
                return;
            } else {
                VersionUtil.m10782b();
                return;
            }
        }
        if (i3 == 2) {
            switch (i2 & 3) {
                case 0:
                    ae();
                    return;
                case 1:
                    af();
                    return;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    ah();
                    return;
            }
        }
        VersionUtil.m10782b();
    }

    private final void ab() {
        int i;
        if (this.d >= this.e) {
            K();
        }
        byte[] bArr = this.f6299Q;
        int i2 = this.d;
        this.d = i2 + 1;
        i2 = bArr[i2];
        if (i2 < 0) {
            i = i2 & 63;
        } else {
            if (this.d >= this.e) {
                K();
            }
            bArr = this.f6299Q;
            int i3 = this.d;
            this.d = i3 + 1;
            i = bArr[i3];
            if (i >= 0) {
                i2 = (i2 << 7) + i;
                if (this.d >= this.e) {
                    K();
                }
                bArr = this.f6299Q;
                i3 = this.d;
                this.d = i3 + 1;
                i = bArr[i3];
                if (i >= 0) {
                    i2 = (i2 << 7) + i;
                    if (this.d >= this.e) {
                        K();
                    }
                    bArr = this.f6299Q;
                    i3 = this.d;
                    this.d = i3 + 1;
                    i = bArr[i3];
                    if (i >= 0) {
                        i2 = (i2 << 7) + i;
                        if (this.d >= this.e) {
                            K();
                        }
                        bArr = this.f6299Q;
                        i3 = this.d;
                        this.d = i3 + 1;
                        i = bArr[i3];
                        if (i >= 0) {
                            e("Corrupt input; 32-bit VInt extends beyond 5 data bytes");
                        }
                    }
                }
            }
            i = (i & 63) + (i2 << 6);
        }
        this.B = SmileUtil.m12003b(i);
        this.A = 1;
    }

    private final void ac() {
        long ag = (long) ag();
        while (true) {
            if (this.d >= this.e) {
                K();
            }
            byte[] bArr = this.f6299Q;
            int i = this.d;
            this.d = i + 1;
            byte b = bArr[i];
            if (b < (byte) 0) {
                this.C = SmileUtil.m12004b((ag << 6) + ((long) (b & 63)));
                this.A = 2;
                return;
            }
            ag = (ag << 7) + ((long) b);
        }
    }

    private final void ad() {
        this.E = new BigInteger(aj());
        this.A = 4;
    }

    private final void ae() {
        int ag = ag();
        if (this.d >= this.e) {
            K();
        }
        ag <<= 7;
        byte[] bArr = this.f6299Q;
        int i = this.d;
        this.d = i + 1;
        this.D = (double) Float.intBitsToFloat(ag + bArr[i]);
        this.A = 8;
    }

    private final void af() {
        long ag = (((long) ag()) << 28) + ((long) ag());
        if (this.d >= this.e) {
            K();
        }
        ag <<= 7;
        byte[] bArr = this.f6299Q;
        int i = this.d;
        this.d = i + 1;
        ag += (long) bArr[i];
        if (this.d >= this.e) {
            K();
        }
        ag <<= 7;
        bArr = this.f6299Q;
        i = this.d;
        this.d = i + 1;
        this.D = Double.longBitsToDouble(ag + ((long) bArr[i]));
        this.A = 8;
    }

    private final int ag() {
        if (this.d >= this.e) {
            K();
        }
        byte[] bArr = this.f6299Q;
        int i = this.d;
        this.d = i + 1;
        byte b = bArr[i];
        if (this.d >= this.e) {
            K();
        }
        int i2 = b << 7;
        byte[] bArr2 = this.f6299Q;
        int i3 = this.d;
        this.d = i3 + 1;
        i2 += bArr2[i3];
        if (this.d >= this.e) {
            K();
        }
        i2 <<= 7;
        bArr2 = this.f6299Q;
        i3 = this.d;
        this.d = i3 + 1;
        i2 += bArr2[i3];
        if (this.d >= this.e) {
            K();
        }
        i2 <<= 7;
        bArr2 = this.f6299Q;
        i3 = this.d;
        this.d = i3 + 1;
        return i2 + bArr2[i3];
    }

    private final void ah() {
        this.F = new BigDecimal(new BigInteger(aj()), SmileUtil.m12003b(ai()));
        this.A = 16;
    }

    private final int ai() {
        int i = 0;
        while (true) {
            if (this.d >= this.e) {
                K();
            }
            byte[] bArr = this.f6299Q;
            int i2 = this.d;
            this.d = i2 + 1;
            byte b = bArr[i2];
            if (b < (byte) 0) {
                return (i << 6) + (b & 63);
            }
            i = (i << 7) + b;
        }
    }

    private final byte[] aj() {
        int i;
        int ai = ai();
        byte[] bArr = new byte[ai];
        int i2 = 0;
        int i3 = ai - 7;
        while (i2 <= i3) {
            if (this.e - this.d < 8) {
                m11955f(8);
            }
            byte[] bArr2 = this.f6299Q;
            i = this.d;
            this.d = i + 1;
            int i4 = bArr2[i] << 25;
            byte[] bArr3 = this.f6299Q;
            int i5 = this.d;
            this.d = i5 + 1;
            i4 += bArr3[i5] << 18;
            bArr3 = this.f6299Q;
            i5 = this.d;
            this.d = i5 + 1;
            i4 += bArr3[i5] << 11;
            bArr3 = this.f6299Q;
            i5 = this.d;
            this.d = i5 + 1;
            i4 += bArr3[i5] << 4;
            bArr3 = this.f6299Q;
            i5 = this.d;
            this.d = i5 + 1;
            byte b = bArr3[i5];
            i4 += b >> 3;
            i = (b & 7) << 21;
            byte[] bArr4 = this.f6299Q;
            int i6 = this.d;
            this.d = i6 + 1;
            i += bArr4[i6] << 14;
            bArr4 = this.f6299Q;
            i6 = this.d;
            this.d = i6 + 1;
            i += bArr4[i6] << 7;
            bArr4 = this.f6299Q;
            i6 = this.d;
            this.d = i6 + 1;
            i += bArr4[i6];
            i5 = i2 + 1;
            bArr[i2] = (byte) (i4 >> 24);
            i2 = i5 + 1;
            bArr[i5] = (byte) (i4 >> 16);
            i5 = i2 + 1;
            bArr[i2] = (byte) (i4 >> 8);
            i2 = i5 + 1;
            bArr[i5] = (byte) i4;
            i4 = i2 + 1;
            bArr[i2] = (byte) (i >> 16);
            i5 = i4 + 1;
            bArr[i4] = (byte) (i >> 8);
            i2 = i5 + 1;
            bArr[i5] = (byte) i;
        }
        i = ai - i2;
        if (i > 0) {
            if (this.e - this.d < i + 1) {
                m11955f(i + 1);
            }
            byte[] bArr5 = this.f6299Q;
            i3 = this.d;
            this.d = i3 + 1;
            i3 = bArr5[i3];
            ai = 1;
            while (ai < i) {
                i3 <<= 7;
                bArr2 = this.f6299Q;
                i5 = this.d;
                this.d = i5 + 1;
                i3 += bArr2[i5];
                i4 = i2 + 1;
                bArr[i2] = (byte) (i3 >> (7 - ai));
                ai++;
                i2 = i4;
            }
            ai = i3 << i;
            byte[] bArr6 = this.f6299Q;
            i4 = this.d;
            this.d = i4 + 1;
            bArr[i2] = (byte) (ai + bArr6[i4]);
        }
        return bArr;
    }

    private void m11962m(int i) {
        if (this.e - this.d < i) {
            m11955f(i);
        }
        char[] l = this.n.l();
        int i2 = 0;
        byte[] bArr = this.f6299Q;
        int i3 = this.d;
        int i4 = i3 + i;
        while (i3 < i4) {
            int i5 = i2 + 1;
            l[i2] = (char) bArr[i3];
            i3++;
            i2 = i5;
        }
        this.d = i3;
        this.n.j = i;
    }

    private void m11963n(int i) {
        if (this.e - this.d < i) {
            m11955f(i);
        }
        int i2 = 0;
        char[] l = this.n.l();
        int i3 = this.d;
        this.d = this.d + i;
        int[] iArr = SmileConstants.f6272a;
        byte[] bArr = this.f6299Q;
        int i4 = i3 + i;
        while (i3 < i4) {
            int i5 = i3 + 1;
            int i6 = bArr[i3] & 255;
            i3 = iArr[i6];
            if (i3 != 0) {
                switch (i3) {
                    case 1:
                        i3 = i5 + 1;
                        i6 = ((i6 & 31) << 6) | (bArr[i5] & 63);
                        i5 = i2;
                        continue;
                    case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                        int i7 = i5 + 1;
                        i3 = i7 + 1;
                        i6 = (((i6 & 15) << 12) | ((bArr[i5] & 63) << 6)) | (bArr[i7] & 63);
                        i5 = i2;
                        continue;
                    case 3:
                        i3 = i5 + 1;
                        i6 = ((i6 & 7) << 18) | ((bArr[i5] & 63) << 12);
                        i5 = i3 + 1;
                        i6 |= (bArr[i3] & 63) << 6;
                        i3 = i5 + 1;
                        i6 = (i6 | (bArr[i5] & 63)) - 65536;
                        i5 = i2 + 1;
                        l[i2] = (char) (55296 | (i6 >> 10));
                        i6 = (i6 & 1023) | 56320;
                        continue;
                    default:
                        e("Invalid byte " + Integer.toHexString(i6) + " in short Unicode text block");
                        break;
                }
            }
            i3 = i5;
            i5 = i2;
            i2 = i5 + 1;
            l[i5] = (char) i6;
        }
        this.n.j = i2;
    }

    private final void ak() {
        char[] l = this.n.l();
        int i = 0;
        while (true) {
            if (this.d >= this.e) {
                K();
            }
            int i2 = this.d;
            int i3 = this.e - i2;
            if (i >= l.length) {
                l = this.n.n();
                i = 0;
            }
            i3 = Math.min(i3, l.length - i);
            int i4 = i;
            i = i2;
            while (true) {
                i2 = i + 1;
                byte b = this.f6299Q[i];
                if (b == (byte) -4) {
                    this.d = i2;
                    this.n.j = i4;
                    return;
                }
                i = i4 + 1;
                l[i4] = (char) b;
                i3--;
                if (i3 <= 0) {
                    break;
                }
                i4 = i;
                i = i2;
            }
            this.d = i2;
        }
    }

    private final void al() {
        char[] l = this.n.l();
        int[] iArr = SmileConstants.f6272a;
        byte[] bArr = this.f6299Q;
        int i = 0;
        while (true) {
            int i2 = this.d;
            if (i2 >= this.e) {
                K();
                i2 = this.d;
            }
            if (i >= l.length) {
                l = this.n.n();
                i = 0;
            }
            int i3 = this.e;
            int length = (l.length - i) + i2;
            if (length >= i3) {
                length = i3;
            }
            while (i2 < length) {
                i3 = i2 + 1;
                i2 = bArr[i2] & 255;
                if (iArr[i2] != 0) {
                    this.d = i3;
                    if (i2 != 252) {
                        switch (iArr[i2]) {
                            case 1:
                                i2 = m11965p(i2);
                                break;
                            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                                if (this.e - this.d < 2) {
                                    i2 = m11966q(i2);
                                    break;
                                } else {
                                    i2 = m11967r(i2);
                                    break;
                                }
                            case 3:
                                length = m11968s(i2);
                                i2 = i + 1;
                                l[i] = (char) (55296 | (length >> 10));
                                if (i2 >= l.length) {
                                    l = this.n.n();
                                    i = 0;
                                } else {
                                    i = i2;
                                }
                                i2 = 56320 | (length & 1023);
                                break;
                            default:
                                m11971v(i2);
                                break;
                        }
                        if (i >= l.length) {
                            l = this.n.n();
                            length = 0;
                        } else {
                            length = i;
                        }
                        i = length + 1;
                        l[length] = (char) i2;
                    } else {
                        this.n.j = i;
                        return;
                    }
                }
                int i4 = i + 1;
                l[i] = (char) i2;
                i2 = i3;
                i = i4;
            }
            this.d = i2;
        }
    }

    private final void am() {
        int ai = ai();
        this.r = new byte[ai];
        if (this.d >= this.e) {
            K();
        }
        int i = 0;
        while (true) {
            int min = Math.min(ai, this.e - this.d);
            System.arraycopy(this.f6299Q, this.d, this.r, i, min);
            this.d = this.d + min;
            i += min;
            ai -= min;
            if (ai > 0) {
                K();
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void an() {
        /*
        r4 = this;
        r0 = 0;
        r4.f6301S = r0;
        r0 = r4.f6302T;
        r1 = r0 >> 5;
        r1 = r1 & 7;
        switch(r1) {
            case 1: goto L_0x0010;
            case 2: goto L_0x0056;
            case 3: goto L_0x0056;
            case 4: goto L_0x005e;
            case 5: goto L_0x005e;
            case 6: goto L_0x000c;
            case 7: goto L_0x0066;
            default: goto L_0x000c;
        };
    L_0x000c:
        com.fasterxml.jackson.core.util.VersionUtil.m10782b();
    L_0x000f:
        return;
    L_0x0010:
        r0 = r0 & 31;
        r1 = r0 >> 2;
        switch(r1) {
            case 1: goto L_0x0018;
            case 2: goto L_0x003e;
            default: goto L_0x0017;
        };
    L_0x0017:
        goto L_0x000c;
    L_0x0018:
        r0 = r0 & 3;
        switch(r0) {
            case 0: goto L_0x001e;
            case 1: goto L_0x0031;
            case 2: goto L_0x003a;
            default: goto L_0x001d;
        };
    L_0x001d:
        goto L_0x000c;
    L_0x001e:
        r0 = r4.e;
        r1 = r4.f6299Q;
    L_0x0022:
        r2 = r4.d;
        if (r2 >= r0) goto L_0x0036;
    L_0x0026:
        r2 = r4.d;
        r3 = r2 + 1;
        r4.d = r3;
        r2 = r1[r2];
        if (r2 >= 0) goto L_0x0022;
    L_0x0030:
        goto L_0x000f;
    L_0x0031:
        r0 = 4;
        r4.m11964o(r0);
        goto L_0x001e;
    L_0x0036:
        r4.K();
        goto L_0x001e;
    L_0x003a:
        r4.ao();
        goto L_0x000f;
    L_0x003e:
        r0 = r0 & 3;
        switch(r0) {
            case 0: goto L_0x0044;
            case 1: goto L_0x0049;
            case 2: goto L_0x004f;
            default: goto L_0x0043;
        };
    L_0x0043:
        goto L_0x000c;
    L_0x0044:
        r0 = 5;
        r4.m11964o(r0);
        goto L_0x000f;
    L_0x0049:
        r0 = 10;
        r4.m11964o(r0);
        goto L_0x000f;
    L_0x004f:
        r4.ai();
        r4.ao();
        goto L_0x000f;
    L_0x0056:
        r0 = r0 & 63;
        r0 = r0 + 1;
        r4.m11964o(r0);
        goto L_0x000f;
    L_0x005e:
        r0 = r0 & 63;
        r0 = r0 + 2;
        r4.m11964o(r0);
        goto L_0x000f;
    L_0x0066:
        r0 = r0 & 31;
        r0 = r0 >> 2;
        switch(r0) {
            case 0: goto L_0x006e;
            case 1: goto L_0x006e;
            case 2: goto L_0x0086;
            case 3: goto L_0x006d;
            case 4: goto L_0x006d;
            case 5: goto L_0x006d;
            case 6: goto L_0x006d;
            case 7: goto L_0x008a;
            default: goto L_0x006d;
        };
    L_0x006d:
        goto L_0x000c;
    L_0x006e:
        r0 = r4.e;
        r1 = r4.f6299Q;
    L_0x0072:
        r2 = r4.d;
        if (r2 >= r0) goto L_0x0082;
    L_0x0076:
        r2 = r4.d;
        r3 = r2 + 1;
        r4.d = r3;
        r2 = r1[r2];
        r3 = -4;
        if (r2 != r3) goto L_0x0072;
    L_0x0081:
        goto L_0x000f;
    L_0x0082:
        r4.K();
        goto L_0x006e;
    L_0x0086:
        r4.ao();
        goto L_0x000f;
    L_0x008a:
        r0 = r4.ai();
        r4.m11964o(r0);
        goto L_0x000f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.dataformat.smile.SmileParser.an():void");
    }

    private void m11964o(int i) {
        while (true) {
            int min = Math.min(i, this.e - this.d);
            this.d = this.d + min;
            i -= min;
            if (i > 0) {
                K();
            } else {
                return;
            }
        }
    }

    private void ao() {
        int ai = ai();
        int i = ai / 7;
        int i2 = i * 8;
        ai -= i * 7;
        if (ai > 0) {
            i2 += ai + 1;
        }
        m11964o(i2);
    }

    private final int m11965p(int i) {
        if (this.d >= this.e) {
            K();
        }
        byte[] bArr = this.f6299Q;
        int i2 = this.d;
        this.d = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            m11951a(b & 255, this.d);
        }
        return (b & 63) | ((i & 31) << 6);
    }

    private final int m11966q(int i) {
        if (this.d >= this.e) {
            K();
        }
        int i2 = i & 15;
        byte[] bArr = this.f6299Q;
        int i3 = this.d;
        this.d = i3 + 1;
        byte b = bArr[i3];
        if ((b & 192) != 128) {
            m11951a(b & 255, this.d);
        }
        i2 = (i2 << 6) | (b & 63);
        if (this.d >= this.e) {
            K();
        }
        bArr = this.f6299Q;
        i3 = this.d;
        this.d = i3 + 1;
        b = bArr[i3];
        if ((b & 192) != 128) {
            m11951a(b & 255, this.d);
        }
        return (i2 << 6) | (b & 63);
    }

    private final int m11967r(int i) {
        int i2 = i & 15;
        byte[] bArr = this.f6299Q;
        int i3 = this.d;
        this.d = i3 + 1;
        byte b = bArr[i3];
        if ((b & 192) != 128) {
            m11951a(b & 255, this.d);
        }
        i2 = (i2 << 6) | (b & 63);
        bArr = this.f6299Q;
        i3 = this.d;
        this.d = i3 + 1;
        b = bArr[i3];
        if ((b & 192) != 128) {
            m11951a(b & 255, this.d);
        }
        return (i2 << 6) | (b & 63);
    }

    private final int m11968s(int i) {
        if (this.d >= this.e) {
            K();
        }
        byte[] bArr = this.f6299Q;
        int i2 = this.d;
        this.d = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            m11951a(b & 255, this.d);
        }
        int i3 = (b & 63) | ((i & 7) << 6);
        if (this.d >= this.e) {
            K();
        }
        byte[] bArr2 = this.f6299Q;
        int i4 = this.d;
        this.d = i4 + 1;
        byte b2 = bArr2[i4];
        if ((b2 & 192) != 128) {
            m11951a(b2 & 255, this.d);
        }
        i3 = (i3 << 6) | (b2 & 63);
        if (this.d >= this.e) {
            K();
        }
        bArr2 = this.f6299Q;
        i4 = this.d;
        this.d = i4 + 1;
        b2 = bArr2[i4];
        if ((b2 & 192) != 128) {
            m11951a(b2 & 255, this.d);
        }
        return ((i3 << 6) | (b2 & 63)) - 65536;
    }

    private void m11969t(int i) {
        if (this.f6308Z == null) {
            e("Encountered shared name reference, even though document header explicitly declared no shared name references are included");
        }
        e("Invalid shared name reference " + i + "; only got " + this.aa + " names in buffer (invalid content)");
    }

    private void m11970u(int i) {
        if (this.ab == null) {
            e("Encountered shared text value reference, even though document header did not declared shared text value references may be included");
        }
        e("Invalid shared text value reference " + i + "; only got " + this.ac + " names in buffer (invalid content)");
    }

    private void m11971v(int i) {
        if (i < 32) {
            d(i);
        }
        m11972w(i);
    }

    private void m11972w(int i) {
        e("Invalid UTF-8 start byte 0x" + Integer.toHexString(i));
    }

    private void m11973x(int i) {
        e("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i));
    }

    private void m11951a(int i, int i2) {
        this.d = i2;
        m11973x(i);
    }
}

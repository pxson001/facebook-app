package com.fasterxml.jackson.core.json;

import com.facebook.proxygen.HTTPTransportCallback;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/* compiled from: pymk_imp */
public final class ReaderBasedJsonParser extends ParserBase {
    protected Reader f8573M;
    protected char[] f8574N;
    protected ObjectCodec f8575O;
    protected final CharsToNameCanonicalizer f8576P;
    protected final int f8577Q;
    protected boolean f8578R = false;

    public ReaderBasedJsonParser(IOContext iOContext, int i, Reader reader, ObjectCodec objectCodec, CharsToNameCanonicalizer charsToNameCanonicalizer) {
        super(iOContext, i);
        this.f8573M = reader;
        this.f8574N = iOContext.m11849g();
        this.f8575O = objectCodec;
        this.f8576P = charsToNameCanonicalizer;
        this.f8577Q = charsToNameCanonicalizer.f4100l;
    }

    public final ObjectCodec mo1761a() {
        return this.f8575O;
    }

    public final void mo1763a(ObjectCodec objectCodec) {
        this.f8575O = objectCodec;
    }

    public final int mo1760a(Writer writer) {
        int i = this.f8600e - this.f8599d;
        if (i <= 0) {
            return 0;
        }
        writer.write(this.f8574N, this.f8599d, i);
        return i;
    }

    public final Object mo1765b() {
        return this.f8573M;
    }

    protected final boolean mo1754L() {
        this.f = this.f8601f + ((long) this.f8600e);
        this.h = this.f8603h - this.f8600e;
        if (this.f8573M == null) {
            return false;
        }
        int read = this.f8573M.read(this.f8574N, 0, this.f8574N.length);
        if (read > 0) {
            this.d = 0;
            this.e = read;
            return true;
        }
        mo1756N();
        if (read != 0) {
            return false;
        }
        throw new IOException("Reader returned 0 characters when trying to read " + this.f8600e);
    }

    private char m13150f(String str) {
        if (this.f8599d >= this.f8600e && !mo1754L()) {
            m13235d(str);
        }
        char[] cArr = this.f8574N;
        int i = this.f8599d;
        this.d = i + 1;
        return cArr[i];
    }

    protected final void mo1756N() {
        if (this.f8573M != null) {
            if (this.f8597b.f7311c || m13262a(Feature.AUTO_CLOSE_SOURCE)) {
                this.f8573M.close();
            }
            this.f8573M = null;
        }
    }

    protected final void mo1757O() {
        super.mo1757O();
        char[] cArr = this.f8574N;
        if (cArr != null) {
            this.f8574N = null;
            this.f8597b.m11839a(cArr);
        }
    }

    public final String mo1769o() {
        JsonToken jsonToken = this.f8614K;
        if (jsonToken != JsonToken.VALUE_STRING) {
            return m13146a(jsonToken);
        }
        if (this.f8578R) {
            this.f8578R = false;
            mo1755M();
        }
        return this.f8609n.m13312g();
    }

    public final String mo1753I() {
        if (this.f8614K != JsonToken.VALUE_STRING) {
            return super.mo1762a(null);
        }
        if (this.f8578R) {
            this.f8578R = false;
            mo1755M();
        }
        return this.f8609n.m13312g();
    }

    public final String mo1762a(String str) {
        if (this.f8614K != JsonToken.VALUE_STRING) {
            return super.mo1762a(str);
        }
        if (this.f8578R) {
            this.f8578R = false;
            mo1755M();
        }
        return this.f8609n.m13312g();
    }

    private String m13146a(JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        switch (1.a[jsonToken.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return this.f8607l.mo1660h();
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return this.f8609n.m13312g();
            default:
                return jsonToken.asString();
        }
    }

    public final char[] mo1770p() {
        if (this.f8614K == null) {
            return null;
        }
        switch (1.a[this.f8614K.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                if (!this.f8611p) {
                    String h = this.f8607l.mo1660h();
                    int length = h.length();
                    if (this.f8610o == null) {
                        this.o = this.f8597b.m11840a(length);
                    } else if (this.f8610o.length < length) {
                        this.o = new char[length];
                    }
                    h.getChars(0, length, this.f8610o, 0);
                    this.p = true;
                }
                return this.f8610o;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                if (this.f8578R) {
                    this.f8578R = false;
                    mo1755M();
                    break;
                }
                break;
            case 3:
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                break;
            default:
                return this.f8614K.asCharArray();
        }
        return this.f8609n.m13311f();
    }

    public final int mo1771q() {
        if (this.f8614K == null) {
            return 0;
        }
        switch (1.a[this.f8614K.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return this.f8607l.mo1660h().length();
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                if (this.f8578R) {
                    this.f8578R = false;
                    mo1755M();
                    break;
                }
                break;
            case 3:
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                break;
            default:
                return this.f8614K.asCharArray().length;
        }
        return this.f8609n.m13307c();
    }

    public final int mo1772r() {
        if (this.f8614K == null) {
            return 0;
        }
        switch (1.a[this.f8614K.ordinal()]) {
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                if (this.f8578R) {
                    this.f8578R = false;
                    mo1755M();
                    break;
                }
                break;
            case 3:
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                break;
            default:
                return 0;
        }
        return this.f8609n.m13309d();
    }

    public final byte[] mo1764a(Base64Variant base64Variant) {
        if (this.f8614K != JsonToken.VALUE_STRING && (this.f8614K != JsonToken.VALUE_EMBEDDED_OBJECT || this.f8613r == null)) {
            m13236e("Current token (" + this.f8614K + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        if (this.f8578R) {
            try {
                this.r = m13149b(base64Variant);
                this.f8578R = false;
            } catch (IllegalArgumentException e) {
                throw m13266b("Failed to decode VALUE_STRING as base64 (" + base64Variant + "): " + e.getMessage());
            }
        } else if (this.f8613r == null) {
            ByteArrayBuilder Q = m13194Q();
            m13226a(mo1769o(), Q, base64Variant);
            this.r = Q.c();
        }
        return this.f8613r;
    }

    public final JsonToken mo1766c() {
        this.A = 0;
        if (this.f8614K == JsonToken.FIELD_NAME) {
            return m13138V();
        }
        if (this.f8578R) {
            aa();
        }
        int ae = ae();
        if (ae < 0) {
            close();
            this.K = null;
            return null;
        }
        this.i = (this.f8601f + ((long) this.f8599d)) - 1;
        this.j = this.f8602g;
        this.k = (this.f8599d - this.f8603h) - 1;
        this.r = null;
        JsonToken jsonToken;
        if (ae == 93) {
            if (!this.f8607l.m11958b()) {
                m13201a(ae, '}');
            }
            this.l = this.f8607l.f8629c;
            jsonToken = JsonToken.END_ARRAY;
            this.K = jsonToken;
            return jsonToken;
        } else if (ae == 125) {
            if (!this.f8607l.m11960d()) {
                m13201a(ae, ']');
            }
            this.l = this.f8607l.f8629c;
            jsonToken = JsonToken.END_OBJECT;
            this.K = jsonToken;
            return jsonToken;
        } else {
            if (this.f8607l.m13331k()) {
                if (ae != 44) {
                    m13230b(ae, "was expecting comma to separate " + this.f8607l.m11961e() + " entries");
                }
                ae = ad();
            }
            boolean d = this.f8607l.m11960d();
            if (d) {
                this.f8607l.f8632f = m13152g(ae);
                this.K = JsonToken.FIELD_NAME;
                ae = ad();
                if (ae != 58) {
                    m13230b(ae, "was expecting a colon to separate field name and value");
                }
                ae = ad();
            }
            switch (ae) {
                case 34:
                    this.f8578R = true;
                    jsonToken = JsonToken.VALUE_STRING;
                    break;
                case 45:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    jsonToken = m13151f(ae);
                    break;
                case 91:
                    if (!d) {
                        this.l = this.f8607l.m13327b(this.f8605j, this.f8606k);
                    }
                    jsonToken = JsonToken.START_ARRAY;
                    break;
                case 93:
                case 125:
                    m13230b(ae, "expected a value");
                    break;
                case 102:
                    m13147a("false", 1);
                    jsonToken = JsonToken.VALUE_FALSE;
                    break;
                case 110:
                    m13147a("null", 1);
                    jsonToken = JsonToken.VALUE_NULL;
                    break;
                case 116:
                    break;
                case 123:
                    if (!d) {
                        this.l = this.f8607l.m13328c(this.f8605j, this.f8606k);
                    }
                    jsonToken = JsonToken.START_OBJECT;
                    break;
                default:
                    jsonToken = m13156i(ae);
                    break;
            }
            m13147a("true", 1);
            jsonToken = JsonToken.VALUE_TRUE;
            if (d) {
                this.m = jsonToken;
                return this.f8614K;
            }
            this.K = jsonToken;
            return jsonToken;
        }
    }

    private JsonToken m13138V() {
        this.p = false;
        JsonToken jsonToken = this.f8608m;
        this.m = null;
        if (jsonToken == JsonToken.START_ARRAY) {
            this.l = this.f8607l.m13327b(this.f8605j, this.f8606k);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            this.l = this.f8607l.m13328c(this.f8605j, this.f8606k);
        }
        this.K = jsonToken;
        return jsonToken;
    }

    public final String mo1768e() {
        if (this.f8614K == JsonToken.FIELD_NAME) {
            this.p = false;
            JsonToken jsonToken = this.f8608m;
            this.m = null;
            this.K = jsonToken;
            if (jsonToken == JsonToken.VALUE_STRING) {
                if (this.f8578R) {
                    this.f8578R = false;
                    mo1755M();
                }
                return this.f8609n.m13312g();
            } else if (jsonToken == JsonToken.START_ARRAY) {
                this.l = this.f8607l.m13327b(this.f8605j, this.f8606k);
                return null;
            } else if (jsonToken != JsonToken.START_OBJECT) {
                return null;
            } else {
                this.l = this.f8607l.m13328c(this.f8605j, this.f8606k);
                return null;
            }
        } else if (mo1766c() == JsonToken.VALUE_STRING) {
            return mo1769o();
        } else {
            return null;
        }
    }

    public final int mo1759a(int i) {
        if (this.f8614K != JsonToken.FIELD_NAME) {
            return mo1766c() == JsonToken.VALUE_NUMBER_INT ? mo1785x() : i;
        } else {
            this.p = false;
            JsonToken jsonToken = this.f8608m;
            this.m = null;
            this.K = jsonToken;
            if (jsonToken == JsonToken.VALUE_NUMBER_INT) {
                return mo1785x();
            }
            if (jsonToken == JsonToken.START_ARRAY) {
                this.l = this.f8607l.m13327b(this.f8605j, this.f8606k);
                return i;
            } else if (jsonToken != JsonToken.START_OBJECT) {
                return i;
            } else {
                this.l = this.f8607l.m13328c(this.f8605j, this.f8606k);
                return i;
            }
        }
    }

    public final void close() {
        super.close();
        this.f8576P.m7190b();
    }

    private JsonToken m13151f(int i) {
        int i2 = 1;
        int i3 = 0;
        boolean z = i == 45;
        int i4 = this.f8599d;
        int i5 = i4 - 1;
        int i6 = this.f8600e;
        int i7;
        if (z) {
            if (i4 < this.f8600e) {
                i7 = i4 + 1;
                i = this.f8574N[i4];
                if (i > 57 || i < 48) {
                    this.d = i7;
                    return m13143a(i, true);
                }
            }
            if (z) {
                i2 = i5;
            } else {
                i2 = i5 + 1;
            }
            this.d = i2;
            return m13148b(z);
        }
        i7 = i4;
        if (i != 48) {
            while (i7 < this.f8600e) {
                i4 = i7 + 1;
                char c = this.f8574N[i7];
                if (c < '0' || c > '9') {
                    int i8;
                    int i9;
                    char c2;
                    if (c == '.') {
                        i7 = 0;
                        i8 = i4;
                        while (i8 < i6) {
                            i4 = i8 + 1;
                            i8 = this.f8574N[i8];
                            if (i8 < '0' || i8 > '9') {
                                if (i7 == 0) {
                                    m13202a(i8, "Decimal point not followed by a digit");
                                }
                                i9 = i7;
                                i7 = i4;
                                i4 = i8;
                                i8 = i9;
                            } else {
                                i7++;
                                i8 = i4;
                            }
                        }
                    } else {
                        i8 = 0;
                        i9 = i4;
                        c2 = c;
                        i7 = i9;
                    }
                    if (i4 == 101 || i4 == 69) {
                        if (i7 < i6) {
                            i4 = i7 + 1;
                            c = this.f8574N[i7];
                            if (c != '-' && c != '+') {
                                i9 = i4;
                                c2 = c;
                                i7 = i9;
                            } else if (i4 < i6) {
                                i7 = i4 + 1;
                                i4 = this.f8574N[i4];
                            }
                            while (i4 <= 57 && i4 >= 48) {
                                i3++;
                                if (i7 < i6) {
                                    i9 = i7 + 1;
                                    c2 = this.f8574N[i7];
                                    i7 = i9;
                                }
                            }
                            if (i3 == 0) {
                                m13202a(i4, "Exponent indicator not followed by a digit");
                            }
                        }
                    }
                    i7--;
                    this.d = i7;
                    this.f8609n.m13304a(this.f8574N, i5, i7 - i5);
                    return m13200a(z, i2, i8, i3);
                }
                i2++;
                i7 = i4;
            }
        }
        if (z) {
            i2 = i5;
        } else {
            i2 = i5 + 1;
        }
        this.d = i2;
        return m13148b(z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.fasterxml.jackson.core.JsonToken m13148b(boolean r15) {
        /*
        r14 = this;
        r10 = 45;
        r12 = 57;
        r11 = 48;
        r1 = 1;
        r2 = 0;
        r0 = r14.f8609n;
        r4 = r0.m13317l();
        if (r15 == 0) goto L_0x0197;
    L_0x0010:
        r4[r2] = r10;
        r0 = r1;
    L_0x0013:
        r3 = r14.f8599d;
        r5 = r14.f8600e;
        if (r3 >= r5) goto L_0x0120;
    L_0x0019:
        r3 = r14.f8574N;
        r5 = r14.f8599d;
        r6 = r5 + 1;
        r14.d = r6;
        r3 = r3[r5];
    L_0x0023:
        if (r3 != r11) goto L_0x0029;
    L_0x0025:
        r3 = r14.m13139W();
    L_0x0029:
        r5 = r2;
        r13 = r3;
        r3 = r4;
        r4 = r13;
    L_0x002d:
        if (r4 < r11) goto L_0x0190;
    L_0x002f:
        if (r4 > r12) goto L_0x0190;
    L_0x0031:
        r5 = r5 + 1;
        r6 = r3.length;
        if (r0 < r6) goto L_0x003e;
    L_0x0036:
        r0 = r14.f8609n;
        r0 = r0.m13319n();
        r3 = r0;
        r0 = r2;
    L_0x003e:
        r6 = r0 + 1;
        r3[r0] = r4;
        r0 = r14.f8599d;
        r4 = r14.f8600e;
        if (r0 < r4) goto L_0x0128;
    L_0x0048:
        r0 = r14.mo1754L();
        if (r0 != 0) goto L_0x0128;
    L_0x004e:
        r7 = r1;
        r0 = r2;
        r9 = r5;
        r4 = r3;
        r5 = r6;
    L_0x0053:
        if (r9 != 0) goto L_0x0071;
    L_0x0055:
        r3 = new java.lang.StringBuilder;
        r6 = "Missing integer part (next char ";
        r3.<init>(r6);
        r6 = com.fasterxml.jackson.core.base.ParserMinimalBase.m13218e(r0);
        r3 = r3.append(r6);
        r6 = ")";
        r3 = r3.append(r6);
        r3 = r3.toString();
        r14.m13205c(r3);
    L_0x0071:
        r3 = 46;
        if (r0 != r3) goto L_0x0188;
    L_0x0075:
        r3 = r5 + 1;
        r4[r5] = r0;
        r5 = r4;
        r4 = r3;
        r3 = r0;
        r0 = r2;
    L_0x007d:
        r6 = r14.f8599d;
        r8 = r14.f8600e;
        if (r6 < r8) goto L_0x0135;
    L_0x0083:
        r6 = r14.mo1754L();
        if (r6 != 0) goto L_0x0135;
    L_0x0089:
        r6 = r1;
    L_0x008a:
        if (r0 != 0) goto L_0x0091;
    L_0x008c:
        r7 = "Decimal point not followed by a digit";
        r14.m13202a(r3, r7);
    L_0x0091:
        r8 = r0;
        r0 = r4;
        r13 = r3;
        r3 = r5;
        r5 = r13;
    L_0x0096:
        r4 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r5 == r4) goto L_0x009e;
    L_0x009a:
        r4 = 69;
        if (r5 != r4) goto L_0x0180;
    L_0x009e:
        r4 = r3.length;
        if (r0 < r4) goto L_0x00a9;
    L_0x00a1:
        r0 = r14.f8609n;
        r0 = r0.m13319n();
        r3 = r0;
        r0 = r2;
    L_0x00a9:
        r4 = r0 + 1;
        r3[r0] = r5;
        r0 = r14.f8599d;
        r5 = r14.f8600e;
        if (r0 >= r5) goto L_0x0155;
    L_0x00b3:
        r0 = r14.f8574N;
        r5 = r14.f8599d;
        r7 = r5 + 1;
        r14.d = r7;
        r5 = r0[r5];
    L_0x00bd:
        if (r5 == r10) goto L_0x00c3;
    L_0x00bf:
        r0 = 43;
        if (r5 != r0) goto L_0x017a;
    L_0x00c3:
        r0 = r3.length;
        if (r4 < r0) goto L_0x0177;
    L_0x00c6:
        r0 = r14.f8609n;
        r3 = r0.m13319n();
        r0 = r2;
    L_0x00cd:
        r4 = r0 + 1;
        r3[r0] = r5;
        r0 = r14.f8599d;
        r5 = r14.f8600e;
        if (r0 >= r5) goto L_0x015d;
    L_0x00d7:
        r0 = r14.f8574N;
        r5 = r14.f8599d;
        r7 = r5 + 1;
        r14.d = r7;
        r0 = r0[r5];
        r5 = r3;
        r3 = r2;
    L_0x00e3:
        r7 = r0;
        r0 = r4;
    L_0x00e5:
        if (r7 > r12) goto L_0x0173;
    L_0x00e7:
        if (r7 < r11) goto L_0x0173;
    L_0x00e9:
        r3 = r3 + 1;
        r4 = r5.length;
        if (r0 < r4) goto L_0x00f5;
    L_0x00ee:
        r0 = r14.f8609n;
        r5 = r0.m13319n();
        r0 = r2;
    L_0x00f5:
        r4 = r0 + 1;
        r5[r0] = r7;
        r0 = r14.f8599d;
        r10 = r14.f8600e;
        if (r0 < r10) goto L_0x0167;
    L_0x00ff:
        r0 = r14.mo1754L();
        if (r0 != 0) goto L_0x0167;
    L_0x0105:
        r2 = r3;
        r0 = r1;
        r1 = r4;
    L_0x0108:
        if (r2 != 0) goto L_0x010f;
    L_0x010a:
        r3 = "Exponent indicator not followed by a digit";
        r14.m13202a(r7, r3);
    L_0x010f:
        if (r0 != 0) goto L_0x0117;
    L_0x0111:
        r0 = r14.f8599d;
        r0 = r0 + -1;
        r14.d = r0;
    L_0x0117:
        r0 = r14.f8609n;
        r0.f8626j = r1;
        r0 = r14.m13200a(r15, r9, r8, r2);
        return r0;
    L_0x0120:
        r3 = "No digit following minus sign";
        r3 = r14.m13150f(r3);
        goto L_0x0023;
    L_0x0128:
        r0 = r14.f8574N;
        r4 = r14.f8599d;
        r7 = r4 + 1;
        r14.d = r7;
        r4 = r0[r4];
        r0 = r6;
        goto L_0x002d;
    L_0x0135:
        r3 = r14.f8574N;
        r6 = r14.f8599d;
        r8 = r6 + 1;
        r14.d = r8;
        r3 = r3[r6];
        if (r3 < r11) goto L_0x0185;
    L_0x0141:
        if (r3 > r12) goto L_0x0185;
    L_0x0143:
        r0 = r0 + 1;
        r6 = r5.length;
        if (r4 < r6) goto L_0x0183;
    L_0x0148:
        r4 = r14.f8609n;
        r5 = r4.m13319n();
        r6 = r2;
    L_0x014f:
        r4 = r6 + 1;
        r5[r6] = r3;
        goto L_0x007d;
    L_0x0155:
        r0 = "expected a digit for number exponent";
        r5 = r14.m13150f(r0);
        goto L_0x00bd;
    L_0x015d:
        r0 = "expected a digit for number exponent";
        r0 = r14.m13150f(r0);
        r5 = r3;
        r3 = r2;
        goto L_0x00e3;
    L_0x0167:
        r0 = r14.f8574N;
        r7 = r14.f8599d;
        r10 = r7 + 1;
        r14.d = r10;
        r0 = r0[r7];
        goto L_0x00e3;
    L_0x0173:
        r2 = r3;
        r1 = r0;
        r0 = r6;
        goto L_0x0108;
    L_0x0177:
        r0 = r4;
        goto L_0x00cd;
    L_0x017a:
        r7 = r5;
        r0 = r4;
        r5 = r3;
        r3 = r2;
        goto L_0x00e5;
    L_0x0180:
        r1 = r0;
        r0 = r6;
        goto L_0x010f;
    L_0x0183:
        r6 = r4;
        goto L_0x014f;
    L_0x0185:
        r6 = r7;
        goto L_0x008a;
    L_0x0188:
        r8 = r2;
        r6 = r7;
        r3 = r4;
        r13 = r5;
        r5 = r0;
        r0 = r13;
        goto L_0x0096;
    L_0x0190:
        r7 = r2;
        r9 = r5;
        r5 = r0;
        r0 = r4;
        r4 = r3;
        goto L_0x0053;
    L_0x0197:
        r0 = r2;
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ReaderBasedJsonParser.b(boolean):com.fasterxml.jackson.core.JsonToken");
    }

    private char m13139W() {
        if (this.f8599d >= this.f8600e && !mo1754L()) {
            return '0';
        }
        char c = this.f8574N[this.f8599d];
        if (c < '0' || c > '9') {
            return '0';
        }
        if (!m13262a(Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
            m13205c("Leading zeroes not allowed");
        }
        this.d = this.f8599d + 1;
        if (c != '0') {
            return c;
        }
        do {
            if (this.f8599d >= this.f8600e && !mo1754L()) {
                return c;
            }
            c = this.f8574N[this.f8599d];
            if (c < '0' || c > '9') {
                return '0';
            }
            this.d = this.f8599d + 1;
        } while (c == '0');
        return c;
    }

    private JsonToken m13143a(int i, boolean z) {
        double d = Double.NEGATIVE_INFINITY;
        if (i == 73) {
            if (this.f8599d >= this.f8600e && !mo1754L()) {
                m13221T();
            }
            char[] cArr = this.f8574N;
            int i2 = this.f8599d;
            this.d = i2 + 1;
            i = cArr[i2];
            String str;
            if (i == 78) {
                str = z ? "-INF" : "+INF";
                m13147a(str, 3);
                if (m13262a(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    if (!z) {
                        d = Double.POSITIVE_INFINITY;
                    }
                    return m13198a(str, d);
                }
                m13236e("Non-standard token '" + str + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            } else if (i == 110) {
                str = z ? "-Infinity" : "+Infinity";
                m13147a(str, 3);
                if (m13262a(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    if (!z) {
                        d = Double.POSITIVE_INFINITY;
                    }
                    return m13198a(str, d);
                }
                m13236e("Non-standard token '" + str + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            }
        }
        m13202a(i, "expected digit (0-9) to follow minus sign, for valid numeric value");
        return null;
    }

    private String m13152g(int i) {
        if (i != 34) {
            return m13154h(i);
        }
        int i2 = this.f8599d;
        int i3 = this.f8577Q;
        int i4 = this.f8600e;
        if (i2 < i4) {
            int[] iArr = CharTypes.f7340a;
            char length = iArr.length;
            do {
                char c = this.f8574N[i2];
                if (c >= length || iArr[c] == 0) {
                    i3 = (i3 * 33) + c;
                    i2++;
                } else if (c == '\"') {
                    i4 = this.f8599d;
                    this.d = i2 + 1;
                    return this.f8576P.m7189a(this.f8574N, i4, i2 - i4, i3);
                }
            } while (i2 < i4);
        }
        i4 = this.f8599d;
        this.d = i2;
        return m13144a(i4, i3, 34);
    }

    private String m13144a(int i, int i2, int i3) {
        this.f8609n.m13304a(this.f8574N, i, this.f8599d - i);
        char[] k = this.f8609n.m13316k();
        int i4 = this.f8609n.f8626j;
        while (true) {
            char R;
            if (this.f8599d >= this.f8600e && !mo1754L()) {
                m13235d(": was expecting closing '" + ((char) i3) + "' for name");
            }
            char[] cArr = this.f8574N;
            int i5 = this.f8599d;
            this.d = i5 + 1;
            char c = cArr[i5];
            if (c <= '\\') {
                if (c == '\\') {
                    R = mo1758R();
                    i2 = (i2 * 33) + c;
                    i5 = i4 + 1;
                    k[i4] = R;
                    if (i5 < k.length) {
                        k = this.f8609n.m13319n();
                        i4 = 0;
                    } else {
                        i4 = i5;
                    }
                } else if (c <= i3) {
                    if (c == i3) {
                        this.f8609n.f8626j = i4;
                        TextBuffer textBuffer = this.f8609n;
                        return this.f8576P.m7189a(textBuffer.m13311f(), textBuffer.m13309d(), textBuffer.m13307c(), i2);
                    } else if (c < ' ') {
                        m13232c(c, "name");
                    }
                }
            }
            R = c;
            i2 = (i2 * 33) + c;
            i5 = i4 + 1;
            k[i4] = R;
            if (i5 < k.length) {
                i4 = i5;
            } else {
                k = this.f8609n.m13319n();
                i4 = 0;
            }
        }
    }

    private String m13154h(int i) {
        if (i == 39 && m13262a(Feature.ALLOW_SINGLE_QUOTES)) {
            return m13140X();
        }
        if (!m13262a(Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
            m13230b(i, "was expecting double-quote to start field name");
        }
        int[] iArr = CharTypes.f7342c;
        char length = iArr.length;
        boolean isJavaIdentifierPart = i < length ? iArr[i] == 0 && (i < 48 || i > 57) : Character.isJavaIdentifierPart((char) i);
        if (!isJavaIdentifierPart) {
            m13230b(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int i2 = this.f8599d;
        int i3 = this.f8577Q;
        int i4 = this.f8600e;
        if (i2 < i4) {
            do {
                char c = this.f8574N[i2];
                int i5;
                if (c < length) {
                    if (iArr[c] != 0) {
                        i5 = this.f8599d - 1;
                        this.d = i2;
                        return this.f8576P.m7189a(this.f8574N, i5, i2 - i5, i3);
                    }
                } else if (!Character.isJavaIdentifierPart((char) c)) {
                    i5 = this.f8599d - 1;
                    this.d = i2;
                    return this.f8576P.m7189a(this.f8574N, i5, i2 - i5, i3);
                }
                i3 = (i3 * 33) + c;
                i2++;
            } while (i2 < i4);
        }
        int i6 = this.f8599d - 1;
        this.d = i2;
        return m13145a(i6, i3, iArr);
    }

    private String m13140X() {
        int i = this.f8599d;
        int i2 = this.f8577Q;
        int i3 = this.f8600e;
        if (i < i3) {
            int[] iArr = CharTypes.f7340a;
            char length = iArr.length;
            do {
                char c = this.f8574N[i];
                if (c != '\'') {
                    if (c < length && iArr[c] != 0) {
                        break;
                    }
                    i2 = (i2 * 33) + c;
                    i++;
                } else {
                    i3 = this.f8599d;
                    this.d = i + 1;
                    return this.f8576P.m7189a(this.f8574N, i3, i - i3, i2);
                }
            } while (i < i3);
        }
        i3 = this.f8599d;
        this.d = i;
        return m13144a(i3, i2, 39);
    }

    private JsonToken m13156i(int i) {
        switch (i) {
            case 39:
                if (m13262a(Feature.ALLOW_SINGLE_QUOTES)) {
                    return m13141Y();
                }
                break;
            case 43:
                if (this.f8599d >= this.f8600e && !mo1754L()) {
                    m13221T();
                }
                char[] cArr = this.f8574N;
                int i2 = this.f8599d;
                this.d = i2 + 1;
                return m13143a(cArr[i2], false);
            case 73:
                m13147a("Infinity", 1);
                if (!m13262a(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    m13236e("Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                    break;
                }
                return m13198a("Infinity", Double.POSITIVE_INFINITY);
            case 78:
                m13147a("NaN", 1);
                if (!m13262a(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    m13236e("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                    break;
                }
                return m13198a("NaN", Double.NaN);
        }
        m13230b(i, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
    }

    private JsonToken m13141Y() {
        char[] l = this.f8609n.m13317l();
        int i = this.f8609n.f8626j;
        while (true) {
            if (this.f8599d >= this.f8600e && !mo1754L()) {
                m13235d(": was expecting closing quote for a string value");
            }
            char[] cArr = this.f8574N;
            int i2 = this.f8599d;
            this.d = i2 + 1;
            char c = cArr[i2];
            if (c <= '\\') {
                if (c == '\\') {
                    c = mo1758R();
                } else if (c <= '\'') {
                    if (c == '\'') {
                        this.f8609n.f8626j = i;
                        return JsonToken.VALUE_STRING;
                    } else if (c < ' ') {
                        m13232c(c, "string value");
                    }
                }
            }
            if (i >= l.length) {
                l = this.f8609n.m13319n();
                i2 = 0;
            } else {
                i2 = i;
            }
            i = i2 + 1;
            l[i2] = c;
        }
    }

    private String m13145a(int i, int i2, int[] iArr) {
        this.f8609n.m13304a(this.f8574N, i, this.f8599d - i);
        char[] k = this.f8609n.m13316k();
        int i3 = this.f8609n.f8626j;
        char length = iArr.length;
        while (true) {
            if (this.f8599d >= this.f8600e && !mo1754L()) {
                break;
            }
            char c = this.f8574N[this.f8599d];
            if (c > length) {
                if (!Character.isJavaIdentifierPart(c)) {
                    break;
                }
            } else if (iArr[c] != 0) {
                break;
            }
            this.d = this.f8599d + 1;
            i2 = (i2 * 33) + c;
            int i4 = i3 + 1;
            k[i3] = c;
            if (i4 >= k.length) {
                k = this.f8609n.m13319n();
                i3 = 0;
            } else {
                i3 = i4;
            }
        }
        this.f8609n.f8626j = i3;
        TextBuffer textBuffer = this.f8609n;
        return this.f8576P.m7189a(textBuffer.m13311f(), textBuffer.m13309d(), textBuffer.m13307c(), i2);
    }

    protected final void mo1755M() {
        int i = this.f8599d;
        int i2 = this.f8600e;
        if (i < i2) {
            int[] iArr = CharTypes.f7340a;
            char length = iArr.length;
            do {
                char c = this.f8574N[i];
                if (c >= length || iArr[c] == 0) {
                    i++;
                } else if (c == '\"') {
                    this.f8609n.m13304a(this.f8574N, this.f8599d, i - this.f8599d);
                    this.d = i + 1;
                    return;
                }
            } while (i < i2);
        }
        this.f8609n.m13306b(this.f8574N, this.f8599d, i - this.f8599d);
        this.d = i;
        m13142Z();
    }

    private void m13142Z() {
        char[] k = this.f8609n.m13316k();
        int i = this.f8609n.f8626j;
        while (true) {
            if (this.f8599d >= this.f8600e && !mo1754L()) {
                m13235d(": was expecting closing quote for a string value");
            }
            char[] cArr = this.f8574N;
            int i2 = this.f8599d;
            this.d = i2 + 1;
            char c = cArr[i2];
            if (c <= '\\') {
                if (c == '\\') {
                    c = mo1758R();
                } else if (c <= '\"') {
                    if (c == '\"') {
                        this.f8609n.f8626j = i;
                        return;
                    } else if (c < ' ') {
                        m13232c(c, "string value");
                    }
                }
            }
            if (i >= k.length) {
                k = this.f8609n.m13319n();
                i2 = 0;
            } else {
                i2 = i;
            }
            i = i2 + 1;
            k[i2] = c;
        }
    }

    private void aa() {
        this.f8578R = false;
        int i = this.f8599d;
        int i2 = this.f8600e;
        char[] cArr = this.f8574N;
        while (true) {
            if (i >= i2) {
                this.d = i;
                if (!mo1754L()) {
                    m13235d(": was expecting closing quote for a string value");
                }
                i = this.f8599d;
                i2 = this.f8600e;
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c <= '\\') {
                if (c == '\\') {
                    this.d = i3;
                    mo1758R();
                    i = this.f8599d;
                    i2 = this.f8600e;
                } else if (c <= '\"') {
                    if (c == '\"') {
                        this.d = i3;
                        return;
                    } else if (c < ' ') {
                        this.d = i3;
                        m13232c(c, "string value");
                    }
                }
            }
            i = i3;
        }
    }

    private void ab() {
        if ((this.f8599d < this.f8600e || mo1754L()) && this.f8574N[this.f8599d] == '\n') {
            this.d = this.f8599d + 1;
        }
        this.g = this.f8602g + 1;
        this.h = this.f8599d;
    }

    private void ac() {
        this.g = this.f8602g + 1;
        this.h = this.f8599d;
    }

    private int ad() {
        while (true) {
            if (this.f8599d < this.f8600e || mo1754L()) {
                char[] cArr = this.f8574N;
                int i = this.f8599d;
                this.d = i + 1;
                int i2 = cArr[i];
                if (i2 > ' ') {
                    if (i2 != '/') {
                        return i2;
                    }
                    af();
                } else if (i2 != ' ') {
                    if (i2 == '\n') {
                        ac();
                    } else if (i2 == '\r') {
                        ab();
                    } else if (i2 != '\t') {
                        m13234d(i2);
                    }
                }
            } else {
                throw m13266b("Unexpected end-of-input within/between " + this.f8607l.m11961e() + " entries");
            }
        }
    }

    private int ae() {
        while (true) {
            if (this.f8599d < this.f8600e || mo1754L()) {
                char[] cArr = this.f8574N;
                int i = this.f8599d;
                this.d = i + 1;
                int i2 = cArr[i];
                if (i2 > 32) {
                    if (i2 != 47) {
                        return i2;
                    }
                    af();
                } else if (i2 != 32) {
                    if (i2 == 10) {
                        ac();
                    } else if (i2 == 13) {
                        ab();
                    } else if (i2 != 9) {
                        m13234d(i2);
                    }
                }
            } else {
                mo1777P();
                return -1;
            }
        }
    }

    private void af() {
        if (!m13262a(Feature.ALLOW_COMMENTS)) {
            m13230b(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this.f8599d >= this.f8600e && !mo1754L()) {
            m13235d(" in a comment");
        }
        char[] cArr = this.f8574N;
        int i = this.f8599d;
        this.d = i + 1;
        int i2 = cArr[i];
        if (i2 == '/') {
            ah();
        } else if (i2 == '*') {
            ag();
        } else {
            m13230b(i2, "was expecting either '*' or '/' for a comment");
        }
    }

    private void ag() {
        while (true) {
            if (this.f8599d >= this.f8600e && !mo1754L()) {
                break;
            }
            char[] cArr = this.f8574N;
            int i = this.f8599d;
            this.d = i + 1;
            int i2 = cArr[i];
            if (i2 <= '*') {
                if (i2 == '*') {
                    if (this.f8599d >= this.f8600e && !mo1754L()) {
                        break;
                    } else if (this.f8574N[this.f8599d] == '/') {
                        this.d = this.f8599d + 1;
                        return;
                    }
                } else if (i2 < ' ') {
                    if (i2 == '\n') {
                        ac();
                    } else if (i2 == '\r') {
                        ab();
                    } else if (i2 != '\t') {
                        m13234d(i2);
                    }
                }
            }
        }
        m13235d(" in a comment");
    }

    private void ah() {
        while (true) {
            if (this.f8599d < this.f8600e || mo1754L()) {
                char[] cArr = this.f8574N;
                int i = this.f8599d;
                this.d = i + 1;
                int i2 = cArr[i];
                if (i2 < ' ') {
                    if (i2 == '\n') {
                        ac();
                        return;
                    } else if (i2 == '\r') {
                        ab();
                        return;
                    } else if (i2 != '\t') {
                        m13234d(i2);
                    }
                }
            } else {
                return;
            }
        }
    }

    protected final char mo1758R() {
        int i = 0;
        if (this.f8599d >= this.f8600e && !mo1754L()) {
            m13235d(" in character escape sequence");
        }
        char[] cArr = this.f8574N;
        int i2 = this.f8599d;
        this.d = i2 + 1;
        char c = cArr[i2];
        switch (c) {
            case '\"':
            case '/':
            case '\\':
                return c;
            case 'b':
                return '\b';
            case 'f':
                return '\f';
            case 'n':
                return '\n';
            case 'r':
                return '\r';
            case 't':
                return '\t';
            case 'u':
                for (int i3 = 0; i3 < 4; i3++) {
                    if (this.f8599d >= this.f8600e && !mo1754L()) {
                        m13235d(" in character escape sequence");
                    }
                    char[] cArr2 = this.f8574N;
                    int i4 = this.f8599d;
                    this.d = i4 + 1;
                    i2 = cArr2[i4];
                    i4 = CharTypes.m11931a(i2);
                    if (i4 < 0) {
                        m13230b(i2, "expected a hex-digit for character escape sequence");
                    }
                    i = (i << 4) | i4;
                }
                return (char) i;
            default:
                return m13222a(c);
        }
    }

    private void m13147a(String str, int i) {
        int length = str.length();
        do {
            if (this.f8599d >= this.f8600e && !mo1754L()) {
                m13155h(str.substring(0, i));
            }
            if (this.f8574N[this.f8599d] != str.charAt(i)) {
                m13155h(str.substring(0, i));
            }
            this.d = this.f8599d + 1;
            i++;
        } while (i < length);
        if (this.f8599d < this.f8600e || mo1754L()) {
            char c = this.f8574N[this.f8599d];
            if (c >= '0' && c != ']' && c != '}' && Character.isJavaIdentifierPart(c)) {
                m13155h(str.substring(0, i));
            }
        }
    }

    private byte[] m13149b(Base64Variant base64Variant) {
        ByteArrayBuilder Q = m13194Q();
        while (true) {
            if (this.f8599d >= this.f8600e) {
                m13188K();
            }
            char[] cArr = this.f8574N;
            int i = this.f8599d;
            this.d = i + 1;
            char c = cArr[i];
            if (c > ' ') {
                int b = base64Variant.m7146b(c);
                if (b < 0) {
                    if (c == '\"') {
                        return Q.c();
                    }
                    b = m13196a(base64Variant, c, 0);
                    if (b < 0) {
                        continue;
                    }
                }
                if (this.f8599d >= this.f8600e) {
                    m13188K();
                }
                char[] cArr2 = this.f8574N;
                int i2 = this.f8599d;
                this.d = i2 + 1;
                char c2 = cArr2[i2];
                i = base64Variant.m7146b(c2);
                if (i < 0) {
                    i = m13196a(base64Variant, c2, 1);
                }
                i |= b << 6;
                if (this.f8599d >= this.f8600e) {
                    m13188K();
                }
                cArr = this.f8574N;
                i2 = this.f8599d;
                this.d = i2 + 1;
                c2 = cArr[i2];
                b = base64Variant.m7146b(c2);
                if (b < 0) {
                    if (b != -2) {
                        if (c2 != '\"' || base64Variant.f4076a) {
                            b = m13196a(base64Variant, c2, 2);
                        } else {
                            Q.a(i >> 4);
                            return Q.c();
                        }
                    }
                    if (b == -2) {
                        if (this.f8599d >= this.f8600e) {
                            m13188K();
                        }
                        cArr = this.f8574N;
                        i2 = this.f8599d;
                        this.d = i2 + 1;
                        b = cArr[i2];
                        if (base64Variant.m7143a((char) b)) {
                            Q.a(i >> 4);
                        } else {
                            throw ParserBase.m13180a(base64Variant, b, 3, "expected padding character '" + base64Variant.f4077b + "'");
                        }
                    }
                }
                i = (i << 6) | b;
                if (this.f8599d >= this.f8600e) {
                    m13188K();
                }
                cArr = this.f8574N;
                i2 = this.f8599d;
                this.d = i2 + 1;
                c2 = cArr[i2];
                b = base64Variant.m7146b(c2);
                if (b < 0) {
                    if (b != -2) {
                        if (c2 != '\"' || base64Variant.f4076a) {
                            b = m13196a(base64Variant, c2, 3);
                        } else {
                            Q.b(i >> 2);
                            return Q.c();
                        }
                    }
                    if (b == -2) {
                        Q.b(i >> 2);
                    }
                }
                Q.c(b | (i << 6));
            }
        }
    }

    private void m13153g(String str) {
        m13155h(str);
    }

    private void m13155h(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        while (true) {
            if (this.f8599d >= this.f8600e && !mo1754L()) {
                break;
            }
            char c = this.f8574N[this.f8599d];
            if (!Character.isJavaIdentifierPart(c)) {
                break;
            }
            this.d = this.f8599d + 1;
            stringBuilder.append(c);
        }
        m13236e("Unrecognized token '" + stringBuilder.toString() + "': was expecting ");
    }
}

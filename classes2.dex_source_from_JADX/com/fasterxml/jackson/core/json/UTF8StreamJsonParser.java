package com.fasterxml.jackson.core.json;

import com.facebook.proxygen.HTTPTransportCallback;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer;
import com.fasterxml.jackson.core.sym.Name;
import com.fasterxml.jackson.core.sym.Name1;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: graphqlsubscriptions */
public final class UTF8StreamJsonParser extends ParserBase {
    private static final int[] f21867T = CharTypes.f7341b;
    private static final int[] f21868U = CharTypes.f7340a;
    protected ObjectCodec f21869M;
    protected final BytesToNameCanonicalizer f21870N;
    protected int[] f21871O = new int[16];
    protected boolean f21872P = false;
    protected InputStream f21873Q;
    protected byte[] f21874R;
    protected boolean f21875S;
    private int f21876V;

    public UTF8StreamJsonParser(IOContext iOContext, int i, InputStream inputStream, ObjectCodec objectCodec, BytesToNameCanonicalizer bytesToNameCanonicalizer, byte[] bArr, int i2, int i3, boolean z) {
        super(iOContext, i);
        this.f21873Q = inputStream;
        this.f21869M = objectCodec;
        this.f21870N = bytesToNameCanonicalizer;
        this.f21874R = bArr;
        this.d = i2;
        this.e = i3;
        this.f21875S = z;
    }

    public final ObjectCodec mo1761a() {
        return this.f21869M;
    }

    public final void mo1763a(ObjectCodec objectCodec) {
        this.f21869M = objectCodec;
    }

    public final int mo3207a(OutputStream outputStream) {
        int i = this.f8600e - this.f8599d;
        if (i <= 0) {
            return 0;
        }
        outputStream.write(this.f21874R, this.f8599d, i);
        return i;
    }

    public final Object mo1765b() {
        return this.f21873Q;
    }

    protected final boolean mo1754L() {
        this.f = this.f8601f + ((long) this.f8600e);
        this.h = this.f8603h - this.f8600e;
        if (this.f21873Q == null) {
            return false;
        }
        int read = this.f21873Q.read(this.f21874R, 0, this.f21874R.length);
        if (read > 0) {
            this.d = 0;
            this.e = read;
            return true;
        }
        mo1756N();
        if (read != 0) {
            return false;
        }
        throw new IOException("InputStream.read() returned 0 characters when trying to read " + this.f21874R.length + " bytes");
    }

    private void ae() {
        int[] iArr = CharTypes.f7344e;
        while (true) {
            if (this.f8599d < this.f8600e || mo1754L()) {
                byte[] bArr = this.f21874R;
                int i = this.f8599d;
                this.d = i + 1;
                int i2 = bArr[i] & 255;
                i = iArr[i2];
                if (i != 0) {
                    switch (i) {
                        case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                            ag();
                            continue;
                        case 3:
                            ah();
                            continue;
                        case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                            ai();
                            continue;
                        case 10:
                            ak();
                            continue;
                        case 13:
                            aj();
                            continue;
                        case 42:
                            if (this.f8599d >= this.f8600e && !mo1754L()) {
                                break;
                            } else if (this.f21874R[this.f8599d] == (byte) 47) {
                                this.d = this.f8599d + 1;
                                return;
                            } else {
                                continue;
                            }
                        default:
                            m29681q(i2);
                            continue;
                    }
                }
            }
            m13235d(" in a comment");
            return;
        }
    }

    private void af() {
        int[] iArr = CharTypes.f7344e;
        while (true) {
            if (this.f8599d < this.f8600e || mo1754L()) {
                byte[] bArr = this.f21874R;
                int i = this.f8599d;
                this.d = i + 1;
                int i2 = bArr[i] & 255;
                i = iArr[i2];
                if (i != 0) {
                    switch (i) {
                        case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                            ag();
                            break;
                        case 3:
                            ah();
                            break;
                        case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                            ai();
                            break;
                        case 10:
                            ak();
                            return;
                        case 13:
                            aj();
                            return;
                        case 42:
                            break;
                        default:
                            m29681q(i2);
                            break;
                    }
                }
            } else {
                return;
            }
        }
    }

    protected final void mo1756N() {
        if (this.f21873Q != null) {
            if (this.f8597b.f7311c || m13262a(Feature.AUTO_CLOSE_SOURCE)) {
                this.f21873Q.close();
            }
            this.f21873Q = null;
        }
    }

    protected final void mo1757O() {
        super.mo1757O();
        if (this.f21875S) {
            byte[] bArr = this.f21874R;
            if (bArr != null) {
                this.f21874R = null;
                this.f8597b.m11838a(bArr);
            }
        }
    }

    public final String mo1769o() {
        if (this.f8614K != JsonToken.VALUE_STRING) {
            return m29661a(this.f8614K);
        }
        if (this.f21872P) {
            this.f21872P = false;
            mo1755M();
        }
        return this.f8609n.m13312g();
    }

    public final String mo1753I() {
        if (this.f8614K != JsonToken.VALUE_STRING) {
            return super.mo1762a(null);
        }
        if (this.f21872P) {
            this.f21872P = false;
            mo1755M();
        }
        return this.f8609n.m13312g();
    }

    public final String mo1762a(String str) {
        if (this.f8614K != JsonToken.VALUE_STRING) {
            return super.mo1762a(str);
        }
        if (this.f21872P) {
            this.f21872P = false;
            mo1755M();
        }
        return this.f8609n.m13312g();
    }

    private String m29661a(JsonToken jsonToken) {
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
                if (this.f21872P) {
                    this.f21872P = false;
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
                if (this.f21872P) {
                    this.f21872P = false;
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
                if (this.f21872P) {
                    this.f21872P = false;
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
        if (this.f21872P) {
            try {
                this.r = m29668b(base64Variant);
                this.f21872P = false;
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
            return m29646V();
        }
        if (this.f21872P) {
            m29650Z();
        }
        int ac = ac();
        if (ac < 0) {
            close();
            this.K = null;
            return null;
        }
        this.i = (this.f8601f + ((long) this.f8599d)) - 1;
        this.j = this.f8602g;
        this.k = (this.f8599d - this.f8603h) - 1;
        this.r = null;
        JsonToken jsonToken;
        if (ac == 93) {
            if (!this.f8607l.m11958b()) {
                m13201a(ac, '}');
            }
            this.l = this.f8607l.f8629c;
            jsonToken = JsonToken.END_ARRAY;
            this.K = jsonToken;
            return jsonToken;
        } else if (ac == 125) {
            if (!this.f8607l.m11960d()) {
                m13201a(ac, ']');
            }
            this.l = this.f8607l.f8629c;
            jsonToken = JsonToken.END_OBJECT;
            this.K = jsonToken;
            return jsonToken;
        } else {
            if (this.f8607l.m13331k()) {
                if (ac != 44) {
                    m13230b(ac, "was expecting comma to separate " + this.f8607l.m11961e() + " entries");
                }
                ac = ab();
            }
            if (!this.f8607l.m11960d()) {
                return m29669f(ac);
            }
            Name h = m29672h(ac);
            this.f8607l.f8632f = h.f4128a;
            this.K = JsonToken.FIELD_NAME;
            ac = ab();
            if (ac != 58) {
                m13230b(ac, "was expecting a colon to separate field name and value");
            }
            ac = ab();
            if (ac == 34) {
                this.f21872P = true;
                this.m = JsonToken.VALUE_STRING;
                return this.f8614K;
            }
            switch (ac) {
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
                    jsonToken = m29671g(ac);
                    break;
                case 91:
                    jsonToken = JsonToken.START_ARRAY;
                    break;
                case 93:
                case 125:
                    m13230b(ac, "expected a value");
                    break;
                case 102:
                    m29662a("false", 1);
                    jsonToken = JsonToken.VALUE_FALSE;
                    break;
                case 110:
                    m29662a("null", 1);
                    jsonToken = JsonToken.VALUE_NULL;
                    break;
                case 116:
                    break;
                case 123:
                    jsonToken = JsonToken.START_OBJECT;
                    break;
                default:
                    jsonToken = m29675k(ac);
                    break;
            }
            m29662a("true", 1);
            jsonToken = JsonToken.VALUE_TRUE;
            this.m = jsonToken;
            return this.f8614K;
        }
    }

    private JsonToken m29669f(int i) {
        if (i == 34) {
            this.f21872P = true;
            JsonToken jsonToken = JsonToken.VALUE_STRING;
            this.K = jsonToken;
            return jsonToken;
        }
        switch (i) {
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
                jsonToken = m29671g(i);
                this.K = jsonToken;
                return jsonToken;
            case 91:
                this.l = this.f8607l.m13327b(this.f8605j, this.f8606k);
                jsonToken = JsonToken.START_ARRAY;
                this.K = jsonToken;
                return jsonToken;
            case 93:
            case 125:
                m13230b(i, "expected a value");
                break;
            case 102:
                m29662a("false", 1);
                jsonToken = JsonToken.VALUE_FALSE;
                this.K = jsonToken;
                return jsonToken;
            case 110:
                m29662a("null", 1);
                jsonToken = JsonToken.VALUE_NULL;
                this.K = jsonToken;
                return jsonToken;
            case 116:
                break;
            case 123:
                this.l = this.f8607l.m13328c(this.f8605j, this.f8606k);
                jsonToken = JsonToken.START_OBJECT;
                this.K = jsonToken;
                return jsonToken;
            default:
                jsonToken = m29675k(i);
                this.K = jsonToken;
                return jsonToken;
        }
        m29662a("true", 1);
        jsonToken = JsonToken.VALUE_TRUE;
        this.K = jsonToken;
        return jsonToken;
    }

    private JsonToken m29646V() {
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

    public final void close() {
        super.close();
        this.f21870N.m7222b();
    }

    public final String mo1768e() {
        if (this.f8614K == JsonToken.FIELD_NAME) {
            this.p = false;
            JsonToken jsonToken = this.f8608m;
            this.m = null;
            this.K = jsonToken;
            if (jsonToken == JsonToken.VALUE_STRING) {
                if (this.f21872P) {
                    this.f21872P = false;
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

    private JsonToken m29671g(int i) {
        int i2;
        int i3;
        int i4;
        int i5 = 1;
        char[] l = this.f8609n.m13317l();
        boolean z = i == 45;
        if (z) {
            l[0] = '-';
            if (this.f8599d >= this.f8600e) {
                m13188K();
            }
            byte[] bArr = this.f21874R;
            i2 = this.f8599d;
            this.d = i2 + 1;
            i3 = bArr[i2] & 255;
            if (i3 < 48 || i3 > 57) {
                return m29651a(i3, true);
            }
            i4 = 1;
        } else {
            i4 = 0;
            i3 = i;
        }
        if (i3 == 48) {
            i3 = m29647W();
        }
        i2 = i4 + 1;
        l[i4] = (char) i3;
        i3 = this.f8599d + l.length;
        if (i3 > this.f8600e) {
            i3 = this.f8600e;
        }
        while (this.f8599d < i3) {
            byte[] bArr2 = this.f21874R;
            int i6 = this.f8599d;
            this.d = i6 + 1;
            i4 = bArr2[i6] & 255;
            if (i4 >= 48 && i4 <= 57) {
                i5++;
                if (i2 >= l.length) {
                    l = this.f8609n.m13319n();
                    i6 = 0;
                } else {
                    i6 = i2;
                }
                i2 = i6 + 1;
                l[i6] = (char) i4;
            } else if (i4 == 46 || i4 == 101 || i4 == 69) {
                return m29652a(l, i2, i4, z, i5);
            } else {
                this.d = this.f8599d - 1;
                this.f8609n.f8626j = i2;
                return m13199a(z, i5);
            }
        }
        return m29653a(l, i2, z, i5);
    }

    private JsonToken m29653a(char[] cArr, int i, boolean z, int i2) {
        int i3;
        int i4 = i2;
        int i5 = i;
        char[] cArr2 = cArr;
        while (true) {
            if (this.f8599d < this.f8600e || mo1754L()) {
                byte[] bArr = this.f21874R;
                i3 = this.f8599d;
                this.d = i3 + 1;
                i3 = bArr[i3] & 255;
                if (i3 <= 57 && i3 >= 48) {
                    int i6;
                    if (i5 >= cArr2.length) {
                        cArr2 = this.f8609n.m13319n();
                        i6 = 0;
                    } else {
                        i6 = i5;
                    }
                    i5 = i6 + 1;
                    cArr2[i6] = (char) i3;
                    i4++;
                }
            } else {
                this.f8609n.f8626j = i5;
                return m13199a(z, i4);
            }
        }
        if (i3 == 46 || i3 == 101 || i3 == 69) {
            return m29652a(cArr2, i5, i3, z, i4);
        }
        this.d = this.f8599d - 1;
        this.f8609n.f8626j = i5;
        return m13199a(z, i4);
    }

    private int m29647W() {
        if (this.f8599d >= this.f8600e && !mo1754L()) {
            return 48;
        }
        int i = this.f21874R[this.f8599d] & 255;
        if (i < 48 || i > 57) {
            return 48;
        }
        if (!m13262a(Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
            m13205c("Leading zeroes not allowed");
        }
        this.d = this.f8599d + 1;
        if (i != 48) {
            return i;
        }
        do {
            if (this.f8599d >= this.f8600e && !mo1754L()) {
                return i;
            }
            i = this.f21874R[this.f8599d] & 255;
            if (i < 48 || i > 57) {
                return 48;
            }
            this.d = this.f8599d + 1;
        } while (i == 48);
        return i;
    }

    private JsonToken m29652a(char[] cArr, int i, int i2, boolean z, int i3) {
        int i4;
        int i5;
        char[] cArr2;
        Object obj;
        int i6 = 0;
        Object obj2 = null;
        if (i2 == 46) {
            int i7 = i + 1;
            cArr[i] = (char) i2;
            while (true) {
                if (this.f8599d >= this.f8600e && !mo1754L()) {
                    break;
                }
                byte[] bArr = this.f21874R;
                int i8 = this.f8599d;
                this.d = i8 + 1;
                i2 = bArr[i8] & 255;
                if (i2 < 48 || i2 > 57) {
                    break;
                }
                i6++;
                if (i7 >= cArr.length) {
                    cArr = this.f8609n.m13319n();
                    i4 = 0;
                } else {
                    i4 = i7;
                }
                i7 = i4 + 1;
                cArr[i4] = (char) i2;
            }
            obj2 = 1;
            if (i6 == 0) {
                m13202a(i2, "Decimal point not followed by a digit");
            }
            i5 = i6;
            i6 = i7;
            cArr2 = cArr;
        } else {
            i5 = 0;
            cArr2 = cArr;
            i6 = i;
        }
        if (i2 == 101 || i2 == 69) {
            if (i6 >= cArr2.length) {
                cArr2 = this.f8609n.m13319n();
                i6 = 0;
            }
            i4 = i6 + 1;
            cArr2[i6] = (char) i2;
            if (this.f8599d >= this.f8600e) {
                m13188K();
            }
            byte[] bArr2 = this.f21874R;
            int i9 = this.f8599d;
            this.d = i9 + 1;
            i9 = bArr2[i9] & 255;
            if (i9 == 45 || i9 == 43) {
                if (i4 >= cArr2.length) {
                    cArr2 = this.f8609n.m13319n();
                    i6 = 0;
                } else {
                    i6 = i4;
                }
                i4 = i6 + 1;
                cArr2[i6] = (char) i9;
                if (this.f8599d >= this.f8600e) {
                    m13188K();
                }
                bArr2 = this.f21874R;
                i9 = this.f8599d;
                this.d = i9 + 1;
                i9 = bArr2[i9] & 255;
                i6 = i4;
                i4 = 0;
            } else {
                i6 = i4;
                i4 = 0;
            }
            while (i9 <= 57 && i9 >= 48) {
                i4++;
                if (i6 >= cArr2.length) {
                    cArr2 = this.f8609n.m13319n();
                    i6 = 0;
                }
                i8 = i6 + 1;
                cArr2[i6] = (char) i9;
                if (this.f8599d >= this.f8600e && !mo1754L()) {
                    i6 = i4;
                    obj = 1;
                    i4 = i8;
                    break;
                }
                bArr2 = this.f21874R;
                i9 = this.f8599d;
                this.d = i9 + 1;
                i9 = bArr2[i9] & 255;
                i6 = i8;
            }
            obj = obj2;
            int i10 = i4;
            i4 = i6;
            i6 = i10;
            if (i6 == 0) {
                m13202a(i9, "Exponent indicator not followed by a digit");
            }
        } else {
            obj = obj2;
            i4 = i6;
            i6 = 0;
        }
        if (obj == null) {
            this.d = this.f8599d - 1;
        }
        this.f8609n.f8626j = i4;
        return m13203b(z, i3, i5, i6);
    }

    private Name m29672h(int i) {
        if (i != 34) {
            return m29674j(i);
        }
        if (this.f8599d + 9 > this.f8600e) {
            return m29648X();
        }
        byte[] bArr = this.f21874R;
        int[] iArr = f21868U;
        int i2 = this.f8599d;
        this.d = i2 + 1;
        i2 = bArr[i2] & 255;
        if (iArr[i2] == 0) {
            int i3 = this.f8599d;
            this.d = i3 + 1;
            i3 = bArr[i3] & 255;
            if (iArr[i3] == 0) {
                i2 = (i2 << 8) | i3;
                i3 = this.f8599d;
                this.d = i3 + 1;
                i3 = bArr[i3] & 255;
                if (iArr[i3] == 0) {
                    i2 = (i2 << 8) | i3;
                    i3 = this.f8599d;
                    this.d = i3 + 1;
                    i3 = bArr[i3] & 255;
                    if (iArr[i3] == 0) {
                        i2 = (i2 << 8) | i3;
                        i3 = this.f8599d;
                        this.d = i3 + 1;
                        int i4 = bArr[i3] & 255;
                        if (iArr[i4] == 0) {
                            this.f21876V = i2;
                            return m29657a(i4, iArr);
                        } else if (i4 == 34) {
                            return m29654a(i2, 4);
                        } else {
                            return m29655a(i2, i4, 4);
                        }
                    } else if (i3 == 34) {
                        return m29654a(i2, 3);
                    } else {
                        return m29655a(i2, i3, 3);
                    }
                } else if (i3 == 34) {
                    return m29654a(i2, 2);
                } else {
                    return m29655a(i2, i3, 2);
                }
            } else if (i3 == 34) {
                return m29654a(i2, 1);
            } else {
                return m29655a(i2, i3, 1);
            }
        } else if (i2 == 34) {
            return Name1.f21921c;
        } else {
            return m29655a(0, i2, 0);
        }
    }

    private Name m29657a(int i, int[] iArr) {
        byte[] bArr = this.f21874R;
        int i2 = this.f8599d;
        this.d = i2 + 1;
        int i3 = bArr[i2] & 255;
        if (iArr[i3] == 0) {
            i3 |= i << 8;
            byte[] bArr2 = this.f21874R;
            int i4 = this.f8599d;
            this.d = i4 + 1;
            i2 = bArr2[i4] & 255;
            if (iArr[i2] == 0) {
                i3 = (i3 << 8) | i2;
                bArr2 = this.f21874R;
                i4 = this.f8599d;
                this.d = i4 + 1;
                i2 = bArr2[i4] & 255;
                if (iArr[i2] == 0) {
                    i3 = (i3 << 8) | i2;
                    bArr2 = this.f21874R;
                    i4 = this.f8599d;
                    this.d = i4 + 1;
                    i2 = bArr2[i4] & 255;
                    if (iArr[i2] == 0) {
                        this.f21871O[0] = this.f21876V;
                        this.f21871O[1] = i3;
                        return m29673i(i2);
                    } else if (i2 == 34) {
                        return m29666b(this.f21876V, i3, 4);
                    } else {
                        return m29656a(this.f21876V, i3, i2, 4);
                    }
                } else if (i2 == 34) {
                    return m29666b(this.f21876V, i3, 3);
                } else {
                    return m29656a(this.f21876V, i3, i2, 3);
                }
            } else if (i2 == 34) {
                return m29666b(this.f21876V, i3, 2);
            } else {
                return m29656a(this.f21876V, i3, i2, 2);
            }
        } else if (i3 == 34) {
            return m29666b(this.f21876V, i, 1);
        } else {
            return m29656a(this.f21876V, i, i3, 1);
        }
    }

    private Name m29673i(int i) {
        int[] iArr = f21868U;
        int i2 = 2;
        int i3 = i;
        while (this.f8600e - this.f8599d >= 4) {
            byte[] bArr = this.f21874R;
            int i4 = this.f8599d;
            this.d = i4 + 1;
            int i5 = bArr[i4] & 255;
            if (iArr[i5] == 0) {
                i4 = (i3 << 8) | i5;
                bArr = this.f21874R;
                i3 = this.f8599d;
                this.d = i3 + 1;
                i3 = bArr[i3] & 255;
                if (iArr[i3] == 0) {
                    i4 = (i4 << 8) | i3;
                    bArr = this.f21874R;
                    i3 = this.f8599d;
                    this.d = i3 + 1;
                    i3 = bArr[i3] & 255;
                    if (iArr[i3] == 0) {
                        i4 = (i4 << 8) | i3;
                        bArr = this.f21874R;
                        i3 = this.f8599d;
                        this.d = i3 + 1;
                        i3 = bArr[i3] & 255;
                        if (iArr[i3] == 0) {
                            if (i2 >= this.f21871O.length) {
                                this.f21871O = m29665a(this.f21871O, i2);
                            }
                            int i6 = i2 + 1;
                            this.f21871O[i2] = i4;
                            i2 = i6;
                        } else if (i3 == 34) {
                            return m29659a(this.f21871O, i2, i4, 4);
                        } else {
                            return m29660a(this.f21871O, i2, i4, i3, 4);
                        }
                    } else if (i3 == 34) {
                        return m29659a(this.f21871O, i2, i4, 3);
                    } else {
                        return m29660a(this.f21871O, i2, i4, i3, 3);
                    }
                } else if (i3 == 34) {
                    return m29659a(this.f21871O, i2, i4, 2);
                } else {
                    return m29660a(this.f21871O, i2, i4, i3, 2);
                }
            } else if (i5 == 34) {
                return m29659a(this.f21871O, i2, i3, 1);
            } else {
                return m29660a(this.f21871O, i2, i3, i5, 1);
            }
        }
        return m29660a(this.f21871O, i2, 0, i3, 0);
    }

    private Name m29648X() {
        if (this.f8599d >= this.f8600e && !mo1754L()) {
            m13235d(": was expecting closing '\"' for name");
        }
        byte[] bArr = this.f21874R;
        int i = this.f8599d;
        this.d = i + 1;
        int i2 = bArr[i] & 255;
        if (i2 == 34) {
            return Name1.f21921c;
        }
        return m29660a(this.f21871O, 0, 0, i2, 0);
    }

    private Name m29655a(int i, int i2, int i3) {
        return m29660a(this.f21871O, 0, i, i2, i3);
    }

    private Name m29656a(int i, int i2, int i3, int i4) {
        this.f21871O[0] = i;
        return m29660a(this.f21871O, 1, i2, i3, i4);
    }

    private Name m29660a(int[] iArr, int i, int i2, int i3, int i4) {
        int[] iArr2 = f21868U;
        while (true) {
            int[] iArr3;
            int i5;
            int i6;
            int i7;
            byte[] bArr;
            if (iArr2[i3] != 0) {
                if (i3 == 34) {
                    break;
                }
                if (i3 != 92) {
                    m13232c(i3, "name");
                } else {
                    i3 = mo1758R();
                }
                if (i3 > 127) {
                    int i8;
                    int[] iArr4;
                    if (i4 >= 4) {
                        if (i >= iArr.length) {
                            iArr = m29665a(iArr, iArr.length);
                            this.f21871O = iArr;
                        }
                        i8 = i + 1;
                        iArr[i] = i2;
                        i4 = 0;
                        i2 = 0;
                        iArr3 = iArr;
                    } else {
                        i8 = i;
                        iArr3 = iArr;
                    }
                    if (i3 < 2048) {
                        i5 = ((i3 >> 6) | 192) | (i2 << 8);
                        iArr4 = iArr3;
                        i6 = i4 + 1;
                    } else {
                        int[] iArr5;
                        int i9;
                        i7 = ((i3 >> 12) | 224) | (i2 << 8);
                        i5 = i4 + 1;
                        if (i5 >= 4) {
                            if (i8 >= iArr3.length) {
                                iArr3 = m29665a(iArr3, iArr3.length);
                                this.f21871O = iArr3;
                            }
                            i5 = i8 + 1;
                            iArr3[i8] = i7;
                            i7 = i5;
                            iArr5 = iArr3;
                            i6 = 0;
                            i5 = 0;
                        } else {
                            i9 = i5;
                            i5 = i7;
                            i7 = i8;
                            iArr5 = iArr3;
                            i6 = i9;
                        }
                        i5 = (i5 << 8) | (((i3 >> 6) & 63) | HTTPTransportCallback.BODY_BYTES_RECEIVED);
                        i6++;
                        i9 = i7;
                        iArr4 = iArr5;
                        i8 = i9;
                    }
                    i2 = (i3 & 63) | HTTPTransportCallback.BODY_BYTES_RECEIVED;
                    i4 = i6;
                    i = i8;
                    iArr3 = iArr4;
                    i7 = i5;
                    if (i4 >= 4) {
                        i4++;
                        i2 |= i7 << 8;
                        iArr = iArr3;
                    } else {
                        if (i >= iArr3.length) {
                            iArr3 = m29665a(iArr3, iArr3.length);
                            this.f21871O = iArr3;
                        }
                        i5 = i + 1;
                        iArr3[i] = i7;
                        i4 = 1;
                        i = i5;
                        iArr = iArr3;
                    }
                    if (this.f8599d >= this.f8600e && !mo1754L()) {
                        m13235d(" in field name");
                    }
                    bArr = this.f21874R;
                    i5 = this.f8599d;
                    this.d = i5 + 1;
                    i3 = bArr[i5] & 255;
                }
            }
            i7 = i2;
            iArr3 = iArr;
            i2 = i3;
            if (i4 >= 4) {
                if (i >= iArr3.length) {
                    iArr3 = m29665a(iArr3, iArr3.length);
                    this.f21871O = iArr3;
                }
                i5 = i + 1;
                iArr3[i] = i7;
                i4 = 1;
                i = i5;
                iArr = iArr3;
            } else {
                i4++;
                i2 |= i7 << 8;
                iArr = iArr3;
            }
            m13235d(" in field name");
            bArr = this.f21874R;
            i5 = this.f8599d;
            this.d = i5 + 1;
            i3 = bArr[i5] & 255;
        }
        if (i4 > 0) {
            if (i >= iArr.length) {
                iArr = m29665a(iArr, iArr.length);
                this.f21871O = iArr;
            }
            i6 = i + 1;
            iArr[i] = i2;
            i = i6;
        }
        Name a = this.f21870N.m7221a(iArr, i);
        if (a == null) {
            return m29658a(iArr, i, i4);
        }
        return a;
    }

    private Name m29674j(int i) {
        if (i == 39 && m13262a(Feature.ALLOW_SINGLE_QUOTES)) {
            return m29649Y();
        }
        int[] iArr;
        int i2;
        if (!m13262a(Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
            m13230b(i, "was expecting double-quote to start field name");
        }
        int[] iArr2 = CharTypes.f7343d;
        if (iArr2[i] != 0) {
            m13230b(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = i;
        int i6 = 0;
        int[] iArr3 = this.f21871O;
        while (true) {
            if (i3 < 4) {
                int i7 = i3 + 1;
                i3 = i5 | (i4 << 8);
                i5 = i6;
                iArr = iArr3;
                i2 = i7;
            } else {
                if (i6 >= iArr3.length) {
                    iArr3 = m29665a(iArr3, iArr3.length);
                    this.f21871O = iArr3;
                }
                int i8 = i6 + 1;
                iArr3[i6] = i4;
                iArr = iArr3;
                i2 = 1;
                i3 = i5;
                i5 = i8;
            }
            if (this.f8599d >= this.f8600e && !mo1754L()) {
                m13235d(" in field name");
            }
            i = this.f21874R[this.f8599d] & 255;
            if (iArr2[i] != 0) {
                break;
            }
            this.d = this.f8599d + 1;
            i4 = i3;
            i3 = i2;
            iArr3 = iArr;
            i6 = i5;
            i5 = i;
        }
        if (i2 > 0) {
            if (i5 >= iArr.length) {
                iArr = m29665a(iArr, iArr.length);
                this.f21871O = iArr;
            }
            i8 = i5 + 1;
            iArr[i5] = i3;
            i5 = i8;
        }
        Name a = this.f21870N.m7221a(iArr, i5);
        return a == null ? m29658a(iArr, i5, i2) : a;
    }

    private Name m29649Y() {
        if (this.f8599d >= this.f8600e && !mo1754L()) {
            m13235d(": was expecting closing ''' for name");
        }
        byte[] bArr = this.f21874R;
        int i = this.f8599d;
        this.d = i + 1;
        int i2 = bArr[i] & 255;
        if (i2 == 39) {
            return Name1.f21921c;
        }
        int i3;
        int[] iArr;
        int[] iArr2 = this.f21871O;
        int[] iArr3 = f21868U;
        int i4 = 0;
        int i5 = 0;
        i = 0;
        while (i2 != 39) {
            int i6;
            int[] iArr4;
            int i7;
            byte[] bArr2;
            if (!(i2 == 34 || iArr3[i2] == 0)) {
                if (i2 != 92) {
                    m13232c(i2, "name");
                } else {
                    i2 = mo1758R();
                }
                if (i2 > 127) {
                    int[] iArr5;
                    if (i4 >= 4) {
                        if (i >= iArr2.length) {
                            iArr2 = m29665a(iArr2, iArr2.length);
                            this.f21871O = iArr2;
                        }
                        i4 = i + 1;
                        iArr2[i] = i5;
                        i = 0;
                        i5 = i4;
                        i4 = 0;
                    } else {
                        i6 = i4;
                        i4 = i5;
                        i5 = i;
                        i = i6;
                    }
                    if (i2 < 2048) {
                        i6 = i + 1;
                        i = (i4 << 8) | ((i2 >> 6) | 192);
                        iArr5 = iArr2;
                        i3 = i6;
                    } else {
                        i4 = (i4 << 8) | ((i2 >> 12) | 224);
                        i++;
                        if (i >= 4) {
                            if (i5 >= iArr2.length) {
                                iArr2 = m29665a(iArr2, iArr2.length);
                                this.f21871O = iArr2;
                            }
                            i = i5 + 1;
                            iArr2[i5] = i4;
                            i4 = i;
                            iArr4 = iArr2;
                            i3 = 0;
                            i = 0;
                        } else {
                            i6 = i;
                            i = i4;
                            i4 = i5;
                            iArr4 = iArr2;
                            i3 = i6;
                        }
                        i = (i << 8) | (((i2 >> 6) & 63) | HTTPTransportCallback.BODY_BYTES_RECEIVED);
                        i3++;
                        i6 = i4;
                        iArr5 = iArr4;
                        i5 = i6;
                    }
                    i7 = i;
                    i = i3;
                    iArr2 = iArr5;
                    i4 = (i2 & 63) | HTTPTransportCallback.BODY_BYTES_RECEIVED;
                    if (i >= 4) {
                        i6 = i + 1;
                        i = i4 | (i7 << 8);
                        i4 = i5;
                        iArr4 = iArr2;
                        i3 = i6;
                    } else {
                        if (i5 >= iArr2.length) {
                            iArr2 = m29665a(iArr2, iArr2.length);
                            this.f21871O = iArr2;
                        }
                        i2 = i5 + 1;
                        iArr2[i5] = i7;
                        iArr4 = iArr2;
                        i3 = 1;
                        i = i4;
                        i4 = i2;
                    }
                    if (this.f8599d >= this.f8600e && !mo1754L()) {
                        m13235d(" in field name");
                    }
                    bArr2 = this.f21874R;
                    i7 = this.f8599d;
                    this.d = i7 + 1;
                    i2 = bArr2[i7] & 255;
                    i6 = i3;
                    iArr2 = iArr4;
                    i5 = i;
                    i = i4;
                    i4 = i6;
                }
            }
            i7 = i5;
            i5 = i;
            i = i4;
            i4 = i2;
            if (i >= 4) {
                if (i5 >= iArr2.length) {
                    iArr2 = m29665a(iArr2, iArr2.length);
                    this.f21871O = iArr2;
                }
                i2 = i5 + 1;
                iArr2[i5] = i7;
                iArr4 = iArr2;
                i3 = 1;
                i = i4;
                i4 = i2;
            } else {
                i6 = i + 1;
                i = i4 | (i7 << 8);
                i4 = i5;
                iArr4 = iArr2;
                i3 = i6;
            }
            m13235d(" in field name");
            bArr2 = this.f21874R;
            i7 = this.f8599d;
            this.d = i7 + 1;
            i2 = bArr2[i7] & 255;
            i6 = i3;
            iArr2 = iArr4;
            i5 = i;
            i = i4;
            i4 = i6;
        }
        if (i4 > 0) {
            if (i >= iArr2.length) {
                iArr2 = m29665a(iArr2, iArr2.length);
                this.f21871O = iArr2;
            }
            int i8 = i + 1;
            iArr2[i] = i5;
            i6 = i8;
            iArr = iArr2;
            i3 = i6;
        } else {
            iArr = iArr2;
            i3 = i;
        }
        Name a = this.f21870N.m7221a(iArr, i3);
        return a == null ? m29658a(iArr, i3, i4) : a;
    }

    private Name m29654a(int i, int i2) {
        Name a = this.f21870N.m7217a(i);
        if (a != null) {
            return a;
        }
        this.f21871O[0] = i;
        return m29658a(this.f21871O, 1, i2);
    }

    private Name m29666b(int i, int i2, int i3) {
        Name a = this.f21870N.m7218a(i, i2);
        if (a != null) {
            return a;
        }
        this.f21871O[0] = i;
        this.f21871O[1] = i2;
        return m29658a(this.f21871O, 2, i3);
    }

    private Name m29659a(int[] iArr, int i, int i2, int i3) {
        if (i >= iArr.length) {
            iArr = m29665a(iArr, iArr.length);
            this.f21871O = iArr;
        }
        int i4 = i + 1;
        iArr[i] = i2;
        Name a = this.f21870N.m7221a(iArr, i4);
        if (a == null) {
            return m29658a(iArr, i4, i3);
        }
        return a;
    }

    private Name m29658a(int[] iArr, int i, int i2) {
        int i3;
        int i4 = ((i << 2) - 4) + i2;
        if (i2 < 4) {
            i3 = iArr[i - 1];
            iArr[i - 1] = i3 << ((4 - i2) << 3);
        } else {
            i3 = 0;
        }
        char[] l = this.f8609n.m13317l();
        int i5 = 0;
        int i6 = 0;
        while (i6 < i4) {
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
                    m29682r(i8);
                    i8 = 1;
                    i9 = 1;
                }
                if (i6 + i9 > i4) {
                    m13235d(" in field name");
                }
                int i10 = iArr[i6 >> 2] >> ((3 - (i6 & 3)) << 3);
                i6++;
                if ((i10 & 192) != HTTPTransportCallback.BODY_BYTES_RECEIVED) {
                    m29683s(i10);
                }
                i8 = (i8 << 6) | (i10 & 63);
                if (i9 > 1) {
                    i10 = iArr[i6 >> 2] >> ((3 - (i6 & 3)) << 3);
                    i6++;
                    if ((i10 & 192) != HTTPTransportCallback.BODY_BYTES_RECEIVED) {
                        m29683s(i10);
                    }
                    i8 = (i8 << 6) | (i10 & 63);
                    if (i9 > 2) {
                        i10 = iArr[i6 >> 2] >> ((3 - (i6 & 3)) << 3);
                        i6++;
                        if ((i10 & 192) != HTTPTransportCallback.BODY_BYTES_RECEIVED) {
                            m29683s(i10 & 255);
                        }
                        i8 = (i8 << 6) | (i10 & 63);
                    }
                }
                if (i9 > 2) {
                    i8 -= 65536;
                    if (i5 >= l.length) {
                        l = this.f8609n.m13320o();
                    }
                    i9 = i5 + 1;
                    l[i5] = (char) (55296 + (i8 >> 10));
                    int i11 = (i8 & 1023) | 56320;
                    i8 = i6;
                    i6 = i9;
                    cArr = l;
                    i7 = i11;
                    if (i6 >= cArr.length) {
                        cArr = this.f8609n.m13320o();
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
                cArr = this.f8609n.m13320o();
            }
            i5 = i6 + 1;
            cArr[i6] = (char) i7;
            i6 = i8;
            l = cArr;
        }
        String str = new String(l, 0, i5);
        if (i2 < 4) {
            iArr[i - 1] = i3;
        }
        return this.f21870N.m7220a(str, iArr, i);
    }

    protected final void mo1755M() {
        int i = this.f8599d;
        if (i >= this.f8600e) {
            m13188K();
            i = this.f8599d;
        }
        char[] l = this.f8609n.m13317l();
        int[] iArr = f21867T;
        int min = Math.min(this.f8600e, l.length + i);
        byte[] bArr = this.f21874R;
        int i2 = i;
        i = 0;
        while (i2 < min) {
            int i3 = bArr[i2] & 255;
            if (iArr[i3] != 0) {
                if (i3 == 34) {
                    this.d = i2 + 1;
                    this.f8609n.f8626j = i;
                    return;
                }
                this.d = i2;
                m29664a(l, i);
            }
            int i4 = i2 + 1;
            i2 = i + 1;
            l[i] = (char) i3;
            i = i2;
            i2 = i4;
        }
        this.d = i2;
        m29664a(l, i);
    }

    private void m29664a(char[] cArr, int i) {
        int[] iArr = f21867T;
        byte[] bArr = this.f21874R;
        while (true) {
            int i2 = this.f8599d;
            if (i2 >= this.f8600e) {
                m13188K();
                i2 = this.f8599d;
            }
            if (i >= cArr.length) {
                cArr = this.f8609n.m13319n();
                i = 0;
            }
            int min = Math.min(this.f8600e, (cArr.length - i) + i2);
            while (i2 < min) {
                int i3 = i2 + 1;
                i2 = bArr[i2] & 255;
                if (iArr[i2] != 0) {
                    this.d = i3;
                    if (i2 != 34) {
                        switch (iArr[i2]) {
                            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                                i2 = mo1758R();
                                break;
                            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                                i2 = m29677m(i2);
                                break;
                            case 3:
                                if (this.f8600e - this.f8599d < 2) {
                                    i2 = m29678n(i2);
                                    break;
                                } else {
                                    i2 = m29679o(i2);
                                    break;
                                }
                            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                                i3 = m29680p(i2);
                                i2 = i + 1;
                                cArr[i] = (char) (55296 | (i3 >> 10));
                                if (i2 >= cArr.length) {
                                    cArr = this.f8609n.m13319n();
                                    i2 = 0;
                                }
                                i = i2;
                                i2 = (i3 & 1023) | 56320;
                                break;
                            default:
                                if (i2 >= 32) {
                                    m29681q(i2);
                                    break;
                                } else {
                                    m13232c(i2, "string value");
                                    break;
                                }
                        }
                        if (i >= cArr.length) {
                            cArr = this.f8609n.m13319n();
                            i3 = 0;
                        } else {
                            i3 = i;
                        }
                        i = i3 + 1;
                        cArr[i3] = (char) i2;
                    } else {
                        this.f8609n.f8626j = i;
                        return;
                    }
                }
                int i4 = i + 1;
                cArr[i] = (char) i2;
                i2 = i3;
                i = i4;
            }
            this.d = i2;
        }
    }

    private void m29650Z() {
        this.f21872P = false;
        int[] iArr = f21867T;
        byte[] bArr = this.f21874R;
        while (true) {
            int i = this.f8599d;
            int i2 = this.f8600e;
            if (i >= i2) {
                m13188K();
                i = this.f8599d;
                i2 = this.f8600e;
            }
            while (i < i2) {
                int i3 = i + 1;
                i = bArr[i] & 255;
                if (iArr[i] != 0) {
                    this.d = i3;
                    if (i != 34) {
                        switch (iArr[i]) {
                            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                                mo1758R();
                                break;
                            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                                ag();
                                break;
                            case 3:
                                ah();
                                break;
                            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                                ai();
                                break;
                            default:
                                if (i >= 32) {
                                    m29681q(i);
                                    break;
                                } else {
                                    m13232c(i, "string value");
                                    break;
                                }
                        }
                    }
                    return;
                }
                i = i3;
            }
            this.d = i;
        }
    }

    private JsonToken m29675k(int i) {
        switch (i) {
            case 39:
                if (m13262a(Feature.ALLOW_SINGLE_QUOTES)) {
                    return aa();
                }
                break;
            case 43:
                if (this.f8599d >= this.f8600e && !mo1754L()) {
                    m13221T();
                }
                byte[] bArr = this.f21874R;
                int i2 = this.f8599d;
                this.d = i2 + 1;
                return m29651a(bArr[i2] & 255, false);
            case 73:
                m29662a("Infinity", 1);
                if (!m13262a(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    m13236e("Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                    break;
                }
                return m13198a("Infinity", Double.POSITIVE_INFINITY);
            case 78:
                m29662a("NaN", 1);
                if (!m13262a(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    m13236e("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                    break;
                }
                return m13198a("NaN", Double.NaN);
        }
        m13230b(i, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.fasterxml.jackson.core.JsonToken aa() {
        /*
        r10 = this;
        r9 = 39;
        r2 = 0;
        r0 = r10.f8609n;
        r0 = r0.m13317l();
        r6 = f21867T;
        r7 = r10.f21874R;
        r1 = r2;
    L_0x000e:
        r3 = r10.f8599d;
        r4 = r10.f8600e;
        if (r3 < r4) goto L_0x0017;
    L_0x0014:
        r10.m13188K();
    L_0x0017:
        r3 = r0.length;
        if (r1 < r3) goto L_0x0021;
    L_0x001a:
        r0 = r10.f8609n;
        r0 = r0.m13319n();
        r1 = r2;
    L_0x0021:
        r4 = r10.f8600e;
        r3 = r10.f8599d;
        r5 = r0.length;
        r5 = r5 - r1;
        r3 = r3 + r5;
        if (r3 >= r4) goto L_0x00b4;
    L_0x002a:
        r4 = r10.f8599d;
        if (r4 >= r3) goto L_0x000e;
    L_0x002e:
        r4 = r10.f8599d;
        r5 = r4 + 1;
        r10.d = r5;
        r4 = r7[r4];
        r5 = r4 & 255;
        if (r5 == r9) goto L_0x0045;
    L_0x003a:
        r4 = r6[r5];
        if (r4 != 0) goto L_0x0045;
    L_0x003e:
        r4 = r1 + 1;
        r5 = (char) r5;
        r0[r1] = r5;
        r1 = r4;
        goto L_0x002a;
    L_0x0045:
        if (r5 == r9) goto L_0x00a9;
    L_0x0047:
        r3 = r6[r5];
        switch(r3) {
            case 1: goto L_0x0069;
            case 2: goto L_0x0072;
            case 3: goto L_0x0077;
            case 4: goto L_0x0089;
            default: goto L_0x004c;
        };
    L_0x004c:
        r3 = 32;
        if (r5 >= r3) goto L_0x0055;
    L_0x0050:
        r3 = "string value";
        r10.m13232c(r5, r3);
    L_0x0055:
        r10.m29681q(r5);
    L_0x0058:
        r3 = r5;
    L_0x0059:
        r4 = r0.length;
        if (r1 < r4) goto L_0x00b0;
    L_0x005c:
        r0 = r10.f8609n;
        r0 = r0.m13319n();
        r4 = r2;
    L_0x0063:
        r1 = r4 + 1;
        r3 = (char) r3;
        r0[r4] = r3;
        goto L_0x000e;
    L_0x0069:
        r3 = 34;
        if (r5 == r3) goto L_0x0058;
    L_0x006d:
        r3 = r10.mo1758R();
        goto L_0x0059;
    L_0x0072:
        r3 = r10.m29677m(r5);
        goto L_0x0059;
    L_0x0077:
        r3 = r10.f8600e;
        r4 = r10.f8599d;
        r3 = r3 - r4;
        r4 = 2;
        if (r3 < r4) goto L_0x0084;
    L_0x007f:
        r3 = r10.m29679o(r5);
        goto L_0x0059;
    L_0x0084:
        r3 = r10.m29678n(r5);
        goto L_0x0059;
    L_0x0089:
        r4 = r10.m29680p(r5);
        r3 = r1 + 1;
        r5 = 55296; // 0xd800 float:7.7486E-41 double:2.732E-319;
        r8 = r4 >> 10;
        r5 = r5 | r8;
        r5 = (char) r5;
        r0[r1] = r5;
        r1 = r0.length;
        if (r3 < r1) goto L_0x00b2;
    L_0x009b:
        r0 = r10.f8609n;
        r0 = r0.m13319n();
        r1 = r2;
    L_0x00a2:
        r3 = 56320; // 0xdc00 float:7.8921E-41 double:2.7826E-319;
        r4 = r4 & 1023;
        r3 = r3 | r4;
        goto L_0x0059;
    L_0x00a9:
        r0 = r10.f8609n;
        r0.f8626j = r1;
        r0 = com.fasterxml.jackson.core.JsonToken.VALUE_STRING;
        return r0;
    L_0x00b0:
        r4 = r1;
        goto L_0x0063;
    L_0x00b2:
        r1 = r3;
        goto L_0x00a2;
    L_0x00b4:
        r3 = r4;
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser.aa():com.fasterxml.jackson.core.JsonToken");
    }

    private JsonToken m29651a(int i, boolean z) {
        int i2 = i;
        while (i2 == 73) {
            String str;
            if (this.f8599d >= this.f8600e && !mo1754L()) {
                m13221T();
            }
            byte[] bArr = this.f21874R;
            int i3 = this.f8599d;
            this.d = i3 + 1;
            byte b = bArr[i3];
            if (b != (byte) 78) {
                if (b != (byte) 110) {
                    i2 = b;
                    break;
                }
                str = z ? "-Infinity" : "+Infinity";
            } else {
                str = z ? "-INF" : "+INF";
            }
            m29662a(str, 3);
            if (m13262a(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                return m13198a(str, z ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
            }
            m13236e("Non-standard token '" + str + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            byte b2 = b;
        }
        m13202a(i2, "expected digit (0-9) to follow minus sign, for valid numeric value");
        return null;
    }

    private void m29662a(String str, int i) {
        int length = str.length();
        do {
            if ((this.f8599d >= this.f8600e && !mo1754L()) || this.f21874R[this.f8599d] != str.charAt(i)) {
                m29670f(str.substring(0, i));
            }
            this.d = this.f8599d + 1;
            i++;
        } while (i < length);
        if (this.f8599d < this.f8600e || mo1754L()) {
            length = this.f21874R[this.f8599d] & 255;
            if (length >= 48 && length != 93 && length != 125 && Character.isJavaIdentifierPart((char) m29676l(length))) {
                m29670f(str.substring(0, i));
            }
        }
    }

    private void m29670f(String str) {
        m29663a(str, "'null', 'true', 'false' or NaN");
    }

    private void m29663a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder(str);
        while (true) {
            if (this.f8599d >= this.f8600e && !mo1754L()) {
                break;
            }
            byte[] bArr = this.f21874R;
            int i = this.f8599d;
            this.d = i + 1;
            char l = (char) m29676l(bArr[i]);
            if (!Character.isJavaIdentifierPart(l)) {
                break;
            }
            stringBuilder.append(l);
        }
        m13236e("Unrecognized token '" + stringBuilder.toString() + "': was expecting " + str2);
    }

    private int ab() {
        while (true) {
            if (this.f8599d < this.f8600e || mo1754L()) {
                byte[] bArr = this.f21874R;
                int i = this.f8599d;
                this.d = i + 1;
                int i2 = bArr[i] & 255;
                if (i2 > 32) {
                    if (i2 != 47) {
                        return i2;
                    }
                    ad();
                } else if (i2 != 32) {
                    if (i2 == 10) {
                        ak();
                    } else if (i2 == 13) {
                        aj();
                    } else if (i2 != 9) {
                        m13234d(i2);
                    }
                }
            } else {
                throw m13266b("Unexpected end-of-input within/between " + this.f8607l.m11961e() + " entries");
            }
        }
    }

    private int ac() {
        while (true) {
            if (this.f8599d < this.f8600e || mo1754L()) {
                byte[] bArr = this.f21874R;
                int i = this.f8599d;
                this.d = i + 1;
                int i2 = bArr[i] & 255;
                if (i2 > 32) {
                    if (i2 != 47) {
                        return i2;
                    }
                    ad();
                } else if (i2 != 32) {
                    if (i2 == 10) {
                        ak();
                    } else if (i2 == 13) {
                        aj();
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

    private void ad() {
        if (!m13262a(Feature.ALLOW_COMMENTS)) {
            m13230b(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this.f8599d >= this.f8600e && !mo1754L()) {
            m13235d(" in a comment");
        }
        byte[] bArr = this.f21874R;
        int i = this.f8599d;
        this.d = i + 1;
        int i2 = bArr[i] & 255;
        if (i2 == 47) {
            af();
        } else if (i2 == 42) {
            ae();
        } else {
            m13230b(i2, "was expecting either '*' or '/' for a comment");
        }
    }

    protected final char mo1758R() {
        int i = 0;
        if (this.f8599d >= this.f8600e && !mo1754L()) {
            m13235d(" in character escape sequence");
        }
        byte[] bArr = this.f21874R;
        int i2 = this.f8599d;
        this.d = i2 + 1;
        byte b = bArr[i2];
        switch (b) {
            case (byte) 34:
            case (byte) 47:
            case (byte) 92:
                return (char) b;
            case (byte) 98:
                return '\b';
            case (byte) 102:
                return '\f';
            case (byte) 110:
                return '\n';
            case (byte) 114:
                return '\r';
            case (byte) 116:
                return '\t';
            case (byte) 117:
                int i3 = 0;
                while (i < 4) {
                    if (this.f8599d >= this.f8600e && !mo1754L()) {
                        m13235d(" in character escape sequence");
                    }
                    byte[] bArr2 = this.f21874R;
                    int i4 = this.f8599d;
                    this.d = i4 + 1;
                    i2 = bArr2[i4];
                    i4 = CharTypes.m11931a(i2);
                    if (i4 < 0) {
                        m13230b(i2, "expected a hex-digit for character escape sequence");
                    }
                    i3 = (i3 << 4) | i4;
                    i++;
                }
                return (char) i3;
            default:
                return m13222a((char) m29676l(b));
        }
    }

    private int m29676l(int i) {
        if (i >= 0) {
            return i;
        }
        Object obj;
        int i2;
        if ((i & 224) == 192) {
            i &= 31;
            obj = 1;
        } else if ((i & 240) == 224) {
            i &= 15;
            i2 = 2;
        } else if ((i & 248) == 240) {
            i &= 7;
            obj = 3;
        } else {
            m29682r(i & 255);
            i2 = 1;
        }
        int al = al();
        if ((al & 192) != HTTPTransportCallback.BODY_BYTES_RECEIVED) {
            m29683s(al & 255);
        }
        i = (i << 6) | (al & 63);
        if (obj <= 1) {
            return i;
        }
        int al2 = al();
        if ((al2 & 192) != HTTPTransportCallback.BODY_BYTES_RECEIVED) {
            m29683s(al2 & 255);
        }
        i = (i << 6) | (al2 & 63);
        if (obj <= 2) {
            return i;
        }
        i2 = al();
        if ((i2 & 192) != HTTPTransportCallback.BODY_BYTES_RECEIVED) {
            m29683s(i2 & 255);
        }
        return (i << 6) | (i2 & 63);
    }

    private int m29677m(int i) {
        if (this.f8599d >= this.f8600e) {
            m13188K();
        }
        byte[] bArr = this.f21874R;
        int i2 = this.f8599d;
        this.d = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != HTTPTransportCallback.BODY_BYTES_RECEIVED) {
            m29667b(b & 255, this.f8599d);
        }
        return (b & 63) | ((i & 31) << 6);
    }

    private int m29678n(int i) {
        if (this.f8599d >= this.f8600e) {
            m13188K();
        }
        int i2 = i & 15;
        byte[] bArr = this.f21874R;
        int i3 = this.f8599d;
        this.d = i3 + 1;
        byte b = bArr[i3];
        if ((b & 192) != HTTPTransportCallback.BODY_BYTES_RECEIVED) {
            m29667b(b & 255, this.f8599d);
        }
        i2 = (i2 << 6) | (b & 63);
        if (this.f8599d >= this.f8600e) {
            m13188K();
        }
        bArr = this.f21874R;
        i3 = this.f8599d;
        this.d = i3 + 1;
        b = bArr[i3];
        if ((b & 192) != HTTPTransportCallback.BODY_BYTES_RECEIVED) {
            m29667b(b & 255, this.f8599d);
        }
        return (i2 << 6) | (b & 63);
    }

    private int m29679o(int i) {
        int i2 = i & 15;
        byte[] bArr = this.f21874R;
        int i3 = this.f8599d;
        this.d = i3 + 1;
        byte b = bArr[i3];
        if ((b & 192) != HTTPTransportCallback.BODY_BYTES_RECEIVED) {
            m29667b(b & 255, this.f8599d);
        }
        i2 = (i2 << 6) | (b & 63);
        bArr = this.f21874R;
        i3 = this.f8599d;
        this.d = i3 + 1;
        b = bArr[i3];
        if ((b & 192) != HTTPTransportCallback.BODY_BYTES_RECEIVED) {
            m29667b(b & 255, this.f8599d);
        }
        return (i2 << 6) | (b & 63);
    }

    private int m29680p(int i) {
        if (this.f8599d >= this.f8600e) {
            m13188K();
        }
        byte[] bArr = this.f21874R;
        int i2 = this.f8599d;
        this.d = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != HTTPTransportCallback.BODY_BYTES_RECEIVED) {
            m29667b(b & 255, this.f8599d);
        }
        int i3 = (b & 63) | ((i & 7) << 6);
        if (this.f8599d >= this.f8600e) {
            m13188K();
        }
        byte[] bArr2 = this.f21874R;
        int i4 = this.f8599d;
        this.d = i4 + 1;
        byte b2 = bArr2[i4];
        if ((b2 & 192) != HTTPTransportCallback.BODY_BYTES_RECEIVED) {
            m29667b(b2 & 255, this.f8599d);
        }
        i3 = (i3 << 6) | (b2 & 63);
        if (this.f8599d >= this.f8600e) {
            m13188K();
        }
        bArr2 = this.f21874R;
        i4 = this.f8599d;
        this.d = i4 + 1;
        b2 = bArr2[i4];
        if ((b2 & 192) != HTTPTransportCallback.BODY_BYTES_RECEIVED) {
            m29667b(b2 & 255, this.f8599d);
        }
        return ((i3 << 6) | (b2 & 63)) - 65536;
    }

    private void ag() {
        if (this.f8599d >= this.f8600e) {
            m13188K();
        }
        byte[] bArr = this.f21874R;
        int i = this.f8599d;
        this.d = i + 1;
        byte b = bArr[i];
        if ((b & 192) != HTTPTransportCallback.BODY_BYTES_RECEIVED) {
            m29667b(b & 255, this.f8599d);
        }
    }

    private void ah() {
        if (this.f8599d >= this.f8600e) {
            m13188K();
        }
        byte[] bArr = this.f21874R;
        int i = this.f8599d;
        this.d = i + 1;
        byte b = bArr[i];
        if ((b & 192) != HTTPTransportCallback.BODY_BYTES_RECEIVED) {
            m29667b(b & 255, this.f8599d);
        }
        if (this.f8599d >= this.f8600e) {
            m13188K();
        }
        bArr = this.f21874R;
        i = this.f8599d;
        this.d = i + 1;
        b = bArr[i];
        if ((b & 192) != HTTPTransportCallback.BODY_BYTES_RECEIVED) {
            m29667b(b & 255, this.f8599d);
        }
    }

    private void ai() {
        if (this.f8599d >= this.f8600e) {
            m13188K();
        }
        byte[] bArr = this.f21874R;
        int i = this.f8599d;
        this.d = i + 1;
        byte b = bArr[i];
        if ((b & 192) != HTTPTransportCallback.BODY_BYTES_RECEIVED) {
            m29667b(b & 255, this.f8599d);
        }
        if (this.f8599d >= this.f8600e) {
            m13188K();
        }
        bArr = this.f21874R;
        i = this.f8599d;
        this.d = i + 1;
        b = bArr[i];
        if ((b & 192) != HTTPTransportCallback.BODY_BYTES_RECEIVED) {
            m29667b(b & 255, this.f8599d);
        }
        if (this.f8599d >= this.f8600e) {
            m13188K();
        }
        bArr = this.f21874R;
        i = this.f8599d;
        this.d = i + 1;
        b = bArr[i];
        if ((b & 192) != HTTPTransportCallback.BODY_BYTES_RECEIVED) {
            m29667b(b & 255, this.f8599d);
        }
    }

    private void aj() {
        if ((this.f8599d < this.f8600e || mo1754L()) && this.f21874R[this.f8599d] == (byte) 10) {
            this.d = this.f8599d + 1;
        }
        this.g = this.f8602g + 1;
        this.h = this.f8599d;
    }

    private void ak() {
        this.g = this.f8602g + 1;
        this.h = this.f8599d;
    }

    private int al() {
        if (this.f8599d >= this.f8600e) {
            m13188K();
        }
        byte[] bArr = this.f21874R;
        int i = this.f8599d;
        this.d = i + 1;
        return bArr[i] & 255;
    }

    private void m29681q(int i) {
        if (i < 32) {
            m13234d(i);
        }
        m29682r(i);
    }

    private void m29682r(int i) {
        m13236e("Invalid UTF-8 start byte 0x" + Integer.toHexString(i));
    }

    private void m29683s(int i) {
        m13236e("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i));
    }

    private void m29667b(int i, int i2) {
        this.d = i2;
        m29683s(i);
    }

    private static int[] m29665a(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length;
        int[] iArr2 = new int[(length + i)];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    private byte[] m29668b(Base64Variant base64Variant) {
        ByteArrayBuilder Q = m13194Q();
        while (true) {
            if (this.f8599d >= this.f8600e) {
                m13188K();
            }
            byte[] bArr = this.f21874R;
            int i = this.f8599d;
            this.d = i + 1;
            i = bArr[i] & 255;
            if (i > 32) {
                int b = base64Variant.m7147b(i);
                if (b < 0) {
                    if (i == 34) {
                        return Q.c();
                    }
                    b = m13197a(base64Variant, i, 0);
                    if (b < 0) {
                        continue;
                    }
                }
                if (this.f8599d >= this.f8600e) {
                    m13188K();
                }
                byte[] bArr2 = this.f21874R;
                int i2 = this.f8599d;
                this.d = i2 + 1;
                i2 = bArr2[i2] & 255;
                i = base64Variant.m7147b(i2);
                if (i < 0) {
                    i = m13197a(base64Variant, i2, 1);
                }
                i |= b << 6;
                if (this.f8599d >= this.f8600e) {
                    m13188K();
                }
                bArr = this.f21874R;
                i2 = this.f8599d;
                this.d = i2 + 1;
                i2 = bArr[i2] & 255;
                b = base64Variant.m7147b(i2);
                if (b < 0) {
                    if (b != -2) {
                        if (i2 != 34 || base64Variant.f4076a) {
                            b = m13197a(base64Variant, i2, 2);
                        } else {
                            Q.a(i >> 4);
                            return Q.c();
                        }
                    }
                    if (b == -2) {
                        if (this.f8599d >= this.f8600e) {
                            m13188K();
                        }
                        bArr = this.f21874R;
                        i2 = this.f8599d;
                        this.d = i2 + 1;
                        b = bArr[i2] & 255;
                        if (base64Variant.m7144a(b)) {
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
                bArr = this.f21874R;
                i2 = this.f8599d;
                this.d = i2 + 1;
                i2 = bArr[i2] & 255;
                b = base64Variant.m7147b(i2);
                if (b < 0) {
                    if (b != -2) {
                        if (i2 != 34 || base64Variant.f4076a) {
                            b = m13197a(base64Variant, i2, 3);
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
}

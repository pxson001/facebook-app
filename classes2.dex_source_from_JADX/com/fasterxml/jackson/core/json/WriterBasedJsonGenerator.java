package com.fasterxml.jackson.core.json;

import com.facebook.proxygen.HTTPTransportCallback;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;
import com.fasterxml.jackson.core.util.VersionUtil;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: request_header_compressed_size */
public final class WriterBasedJsonGenerator extends JsonGeneratorImpl {
    protected static final char[] f7321m = CharTypes.m11939g();
    protected final Writer f7322n;
    protected char[] f7323o;
    protected int f7324p = 0;
    protected int f7325q = 0;
    protected int f7326r;
    protected char[] f7327s;
    protected SerializableString f7328t;

    public WriterBasedJsonGenerator(IOContext iOContext, int i, ObjectCodec objectCodec, Writer writer) {
        super(iOContext, i, objectCodec);
        this.f7322n = writer;
        this.f7323o = iOContext.m11850h();
        this.f7326r = this.f7323o.length;
    }

    public final void mo1115a(String str) {
        boolean z = true;
        int a = this.f7338e.m11950a(str);
        if (a == 4) {
            GeneratorBase.m11917i("Can not write a field name, expecting a value");
        }
        if (a != 1) {
            z = false;
        }
        m11869b(str, z);
    }

    public final void mo1122b(SerializableString serializableString) {
        boolean z = true;
        int a = this.f7338e.m11950a(serializableString.mo1050a());
        if (a == 4) {
            GeneratorBase.m11917i("Can not write a field name, expecting a value");
        }
        if (a != 1) {
            z = false;
        }
        m11861a(serializableString, z);
    }

    public final void mo1129d() {
        mo1653h("start an array");
        this.e = this.f7338e.m11953j();
        if (this.f4184a != null) {
            this.f4184a.mo1045e(this);
            return;
        }
        if (this.f7325q >= this.f7326r) {
            m11885n();
        }
        char[] cArr = this.f7323o;
        int i = this.f7325q;
        this.f7325q = i + 1;
        cArr[i] = '[';
    }

    public final void mo1132e() {
        if (!this.f7338e.m11958b()) {
            GeneratorBase.m11917i("Current context not an ARRAY but " + this.f7338e.m11961e());
        }
        if (this.f4184a != null) {
            this.f4184a.mo1042b(this, this.f7338e.m11962f());
        } else {
            if (this.f7325q >= this.f7326r) {
                m11885n();
            }
            char[] cArr = this.f7323o;
            int i = this.f7325q;
            this.f7325q = i + 1;
            cArr[i] = ']';
        }
        this.e = this.f7338e.f7351c;
    }

    public final void mo1134f() {
        mo1653h("start an object");
        this.e = this.f7338e.m11954k();
        if (this.f4184a != null) {
            this.f4184a.mo1041b(this);
            return;
        }
        if (this.f7325q >= this.f7326r) {
            m11885n();
        }
        char[] cArr = this.f7323o;
        int i = this.f7325q;
        this.f7325q = i + 1;
        cArr[i] = '{';
    }

    public final void mo1136g() {
        if (!this.f7338e.m11960d()) {
            GeneratorBase.m11917i("Current context not an object but " + this.f7338e.m11961e());
        }
        if (this.f4184a != null) {
            this.f4184a.mo1040a(this, this.f7338e.m11962f());
        } else {
            if (this.f7325q >= this.f7326r) {
                m11885n();
            }
            char[] cArr = this.f7323o;
            int i = this.f7325q;
            this.f7325q = i + 1;
            cArr[i] = '}';
        }
        this.e = this.f7338e.f7351c;
    }

    private void m11869b(String str, boolean z) {
        if (this.f4184a != null) {
            m11872c(str, z);
            return;
        }
        if (this.f7325q + 1 >= this.f7326r) {
            m11885n();
        }
        if (z) {
            char[] cArr = this.f7323o;
            int i = this.f7325q;
            this.f7325q = i + 1;
            cArr[i] = ',';
        }
        if (m11923a(Feature.QUOTE_FIELD_NAMES)) {
            cArr = this.f7323o;
            i = this.f7325q;
            this.f7325q = i + 1;
            cArr[i] = '\"';
            m11881k(str);
            if (this.f7325q >= this.f7326r) {
                m11885n();
            }
            cArr = this.f7323o;
            i = this.f7325q;
            this.f7325q = i + 1;
            cArr[i] = '\"';
            return;
        }
        m11881k(str);
    }

    private void m11861a(SerializableString serializableString, boolean z) {
        if (this.f4184a != null) {
            m11867b(serializableString, z);
            return;
        }
        if (this.f7325q + 1 >= this.f7326r) {
            m11885n();
        }
        if (z) {
            char[] cArr = this.f7323o;
            int i = this.f7325q;
            this.f7325q = i + 1;
            cArr[i] = ',';
        }
        Object c = serializableString.mo1052c();
        if (m11923a(Feature.QUOTE_FIELD_NAMES)) {
            char[] cArr2 = this.f7323o;
            int i2 = this.f7325q;
            this.f7325q = i2 + 1;
            cArr2[i2] = '\"';
            i = c.length;
            if ((this.f7325q + i) + 1 >= this.f7326r) {
                mo1124b(c, 0, i);
                if (this.f7325q >= this.f7326r) {
                    m11885n();
                }
                cArr = this.f7323o;
                i = this.f7325q;
                this.f7325q = i + 1;
                cArr[i] = '\"';
                return;
            }
            System.arraycopy(c, 0, this.f7323o, this.f7325q, i);
            this.f7325q += i;
            cArr = this.f7323o;
            i = this.f7325q;
            this.f7325q = i + 1;
            cArr[i] = '\"';
            return;
        }
        mo1124b(c, 0, c.length);
    }

    private void m11872c(String str, boolean z) {
        if (z) {
            this.f4184a.mo1043c(this);
        } else {
            this.f4184a.mo1048h(this);
        }
        if (m11923a(Feature.QUOTE_FIELD_NAMES)) {
            if (this.f7325q >= this.f7326r) {
                m11885n();
            }
            char[] cArr = this.f7323o;
            int i = this.f7325q;
            this.f7325q = i + 1;
            cArr[i] = '\"';
            m11881k(str);
            if (this.f7325q >= this.f7326r) {
                m11885n();
            }
            cArr = this.f7323o;
            i = this.f7325q;
            this.f7325q = i + 1;
            cArr[i] = '\"';
            return;
        }
        m11881k(str);
    }

    private void m11867b(SerializableString serializableString, boolean z) {
        if (z) {
            this.f4184a.mo1043c(this);
        } else {
            this.f4184a.mo1048h(this);
        }
        char[] c = serializableString.mo1052c();
        if (m11923a(Feature.QUOTE_FIELD_NAMES)) {
            if (this.f7325q >= this.f7326r) {
                m11885n();
            }
            char[] cArr = this.f7323o;
            int i = this.f7325q;
            this.f7325q = i + 1;
            cArr[i] = '\"';
            mo1124b(c, 0, c.length);
            if (this.f7325q >= this.f7326r) {
                m11885n();
            }
            c = this.f7323o;
            int i2 = this.f7325q;
            this.f7325q = i2 + 1;
            c[i2] = '\"';
            return;
        }
        mo1124b(c, 0, c.length);
    }

    public final void mo1123b(String str) {
        mo1653h("write text value");
        if (str == null) {
            m11882l();
            return;
        }
        if (this.f7325q >= this.f7326r) {
            m11885n();
        }
        char[] cArr = this.f7323o;
        int i = this.f7325q;
        this.f7325q = i + 1;
        cArr[i] = '\"';
        m11881k(str);
        if (this.f7325q >= this.f7326r) {
            m11885n();
        }
        cArr = this.f7323o;
        i = this.f7325q;
        this.f7325q = i + 1;
        cArr[i] = '\"';
    }

    public final void mo1120a(char[] cArr, int i, int i2) {
        mo1653h("write text value");
        if (this.f7325q >= this.f7326r) {
            m11885n();
        }
        char[] cArr2 = this.f7323o;
        int i3 = this.f7325q;
        this.f7325q = i3 + 1;
        cArr2[i3] = '\"';
        m11873c(cArr, i, i2);
        if (this.f7325q >= this.f7326r) {
            m11885n();
        }
        cArr2 = this.f7323o;
        i3 = this.f7325q;
        this.f7325q = i3 + 1;
        cArr2[i3] = '\"';
    }

    public final void mo1126c(SerializableString serializableString) {
        mo1653h("write text value");
        if (this.f7325q >= this.f7326r) {
            m11885n();
        }
        char[] cArr = this.f7323o;
        int i = this.f7325q;
        this.f7325q = i + 1;
        cArr[i] = '\"';
        Object c = serializableString.mo1052c();
        i = c.length;
        if (i < 32) {
            if (i > this.f7326r - this.f7325q) {
                m11885n();
            }
            System.arraycopy(c, 0, this.f7323o, this.f7325q, i);
            this.f7325q += i;
        } else {
            m11885n();
            this.f7322n.write(c, 0, i);
        }
        if (this.f7325q >= this.f7326r) {
            m11885n();
        }
        cArr = this.f7323o;
        i = this.f7325q;
        this.f7325q = i + 1;
        cArr[i] = '\"';
    }

    public final void mo1127c(String str) {
        int length = str.length();
        int i = this.f7326r - this.f7325q;
        if (i == 0) {
            m11885n();
            i = this.f7326r - this.f7325q;
        }
        if (i >= length) {
            str.getChars(0, length, this.f7323o, this.f7325q);
            this.f7325q += length;
            return;
        }
        m11880j(str);
    }

    public final void mo1130d(SerializableString serializableString) {
        mo1127c(serializableString.mo1050a());
    }

    public final void mo1124b(char[] cArr, int i, int i2) {
        if (i2 < 32) {
            if (i2 > this.f7326r - this.f7325q) {
                m11885n();
            }
            System.arraycopy(cArr, i, this.f7323o, this.f7325q, i2);
            this.f7325q += i2;
            return;
        }
        m11885n();
        this.f7322n.write(cArr, i, i2);
    }

    public final void mo1108a(char c) {
        if (this.f7325q >= this.f7326r) {
            m11885n();
        }
        char[] cArr = this.f7323o;
        int i = this.f7325q;
        this.f7325q = i + 1;
        cArr[i] = c;
    }

    private void m11880j(String str) {
        int i = this.f7326r - this.f7325q;
        str.getChars(0, i, this.f7323o, this.f7325q);
        this.f7325q += i;
        m11885n();
        int length = str.length() - i;
        while (length > this.f7326r) {
            int i2 = this.f7326r;
            str.getChars(i, i + i2, this.f7323o, 0);
            this.f7324p = 0;
            this.f7325q = i2;
            m11885n();
            i += i2;
            length -= i2;
        }
        str.getChars(i, i + length, this.f7323o, 0);
        this.f7324p = 0;
        this.f7325q = length;
    }

    public final void mo1112a(Base64Variant base64Variant, byte[] bArr, int i, int i2) {
        mo1653h("write binary value");
        if (this.f7325q >= this.f7326r) {
            m11885n();
        }
        char[] cArr = this.f7323o;
        int i3 = this.f7325q;
        this.f7325q = i3 + 1;
        cArr[i3] = '\"';
        m11866b(base64Variant, bArr, i, i + i2);
        if (this.f7325q >= this.f7326r) {
            m11885n();
        }
        cArr = this.f7323o;
        i3 = this.f7325q;
        this.f7325q = i3 + 1;
        cArr[i3] = '\"';
    }

    public final void mo1118a(short s) {
        mo1653h("write number");
        if (this.f7337d) {
            m11870b(s);
            return;
        }
        if (this.f7325q + 6 >= this.f7326r) {
            m11885n();
        }
        this.f7325q = NumberOutput.m11997a((int) s, this.f7323o, this.f7325q);
    }

    private void m11870b(short s) {
        if (this.f7325q + 8 >= this.f7326r) {
            m11885n();
        }
        char[] cArr = this.f7323o;
        int i = this.f7325q;
        this.f7325q = i + 1;
        cArr[i] = '\"';
        this.f7325q = NumberOutput.m11997a((int) s, this.f7323o, this.f7325q);
        cArr = this.f7323o;
        i = this.f7325q;
        this.f7325q = i + 1;
        cArr[i] = '\"';
    }

    public final void mo1121b(int i) {
        mo1653h("write number");
        if (this.f7337d) {
            m11871c(i);
            return;
        }
        if (this.f7325q + 11 >= this.f7326r) {
            m11885n();
        }
        this.f7325q = NumberOutput.m11997a(i, this.f7323o, this.f7325q);
    }

    private void m11871c(int i) {
        if (this.f7325q + 13 >= this.f7326r) {
            m11885n();
        }
        char[] cArr = this.f7323o;
        int i2 = this.f7325q;
        this.f7325q = i2 + 1;
        cArr[i2] = '\"';
        this.f7325q = NumberOutput.m11997a(i, this.f7323o, this.f7325q);
        cArr = this.f7323o;
        i2 = this.f7325q;
        this.f7325q = i2 + 1;
        cArr[i2] = '\"';
    }

    public final void mo1111a(long j) {
        mo1653h("write number");
        if (this.f7337d) {
            m11865b(j);
            return;
        }
        if (this.f7325q + 21 >= this.f7326r) {
            m11885n();
        }
        this.f7325q = NumberOutput.m11999a(j, this.f7323o, this.f7325q);
    }

    private void m11865b(long j) {
        if (this.f7325q + 23 >= this.f7326r) {
            m11885n();
        }
        char[] cArr = this.f7323o;
        int i = this.f7325q;
        this.f7325q = i + 1;
        cArr[i] = '\"';
        this.f7325q = NumberOutput.m11999a(j, this.f7323o, this.f7325q);
        cArr = this.f7323o;
        i = this.f7325q;
        this.f7325q = i + 1;
        cArr[i] = '\"';
    }

    public final void mo1117a(BigInteger bigInteger) {
        mo1653h("write number");
        if (bigInteger == null) {
            m11882l();
        } else if (this.f7337d) {
            m11868b((Object) bigInteger);
        } else {
            mo1127c(bigInteger.toString());
        }
    }

    public final void mo1109a(double d) {
        if (this.f7337d || ((Double.isNaN(d) || Double.isInfinite(d)) && m11923a(Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            mo1123b(String.valueOf(d));
            return;
        }
        mo1653h("write number");
        mo1127c(String.valueOf(d));
    }

    public final void mo1110a(float f) {
        if (this.f7337d || ((Float.isNaN(f) || Float.isInfinite(f)) && m11923a(Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            mo1123b(String.valueOf(f));
            return;
        }
        mo1653h("write number");
        mo1127c(String.valueOf(f));
    }

    public final void mo1116a(BigDecimal bigDecimal) {
        mo1653h("write number");
        if (bigDecimal == null) {
            m11882l();
        } else if (this.f7337d) {
            m11868b((Object) bigDecimal);
        } else {
            mo1127c(bigDecimal.toString());
        }
    }

    public final void mo1133e(String str) {
        mo1653h("write number");
        if (this.f7337d) {
            m11868b((Object) str);
        } else {
            mo1127c(str);
        }
    }

    private void m11868b(Object obj) {
        if (this.f7325q >= this.f7326r) {
            m11885n();
        }
        char[] cArr = this.f7323o;
        int i = this.f7325q;
        this.f7325q = i + 1;
        cArr[i] = '\"';
        mo1127c(obj.toString());
        if (this.f7325q >= this.f7326r) {
            m11885n();
        }
        cArr = this.f7323o;
        i = this.f7325q;
        this.f7325q = i + 1;
        cArr[i] = '\"';
    }

    public final void mo1119a(boolean z) {
        mo1653h("write boolean value");
        if (this.f7325q + 5 >= this.f7326r) {
            m11885n();
        }
        int i = this.f7325q;
        char[] cArr = this.f7323o;
        if (z) {
            cArr[i] = 't';
            i++;
            cArr[i] = 'r';
            i++;
            cArr[i] = 'u';
            i++;
            cArr[i] = 'e';
        } else {
            cArr[i] = 'f';
            i++;
            cArr[i] = 'a';
            i++;
            cArr[i] = 'l';
            i++;
            cArr[i] = 's';
            i++;
            cArr[i] = 'e';
        }
        this.f7325q = i + 1;
    }

    public final void mo1137h() {
        mo1653h("write null value");
        m11882l();
    }

    protected final void mo1653h(String str) {
        int m = this.f7338e.m11956m();
        if (m == 5) {
            GeneratorBase.m11917i("Can not " + str + ", expecting field name");
        }
        if (this.f4184a == null) {
            char c;
            switch (m) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    c = ',';
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    c = ':';
                    break;
                case 3:
                    if (this.f7334l != null) {
                        mo1127c(this.f7334l.mo1050a());
                        return;
                    }
                    return;
                default:
                    return;
            }
            if (this.f7325q >= this.f7326r) {
                m11885n();
            }
            this.f7323o[this.f7325q] = c;
            this.f7325q++;
            return;
        }
        m11874d(m);
    }

    private void m11874d(int i) {
        switch (i) {
            case 0:
                if (this.f7338e.m11958b()) {
                    this.f4184a.mo1047g(this);
                    return;
                } else if (this.f7338e.m11960d()) {
                    this.f4184a.mo1048h(this);
                    return;
                } else {
                    return;
                }
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                this.f4184a.mo1046f(this);
                return;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                this.f4184a.mo1044d(this);
                return;
            case 3:
                this.f4184a.mo1039a(this);
                return;
            default:
                VersionUtil.b();
                return;
        }
    }

    public final void flush() {
        m11885n();
        if (this.f7322n != null && m11923a(Feature.FLUSH_PASSED_TO_STREAM)) {
            this.f7322n.flush();
        }
    }

    public final void close() {
        super.close();
        if (this.f7323o != null && m11923a(Feature.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                JsonStreamContext jsonStreamContext = this.f7338e;
                if (!jsonStreamContext.m11958b()) {
                    if (!jsonStreamContext.m11960d()) {
                        break;
                    }
                    mo1136g();
                } else {
                    mo1132e();
                }
            }
        }
        m11885n();
        if (this.f7322n != null) {
            if (this.f7330h.f7311c || m11923a(Feature.AUTO_CLOSE_TARGET)) {
                this.f7322n.close();
            } else if (m11923a(Feature.FLUSH_PASSED_TO_STREAM)) {
                this.f7322n.flush();
            }
        }
        mo1654j();
    }

    protected final void mo1654j() {
        char[] cArr = this.f7323o;
        if (cArr != null) {
            this.f7323o = null;
            this.f7330h.m11843b(cArr);
        }
    }

    private void m11881k(String str) {
        int length = str.length();
        if (length > this.f7326r) {
            m11883l(str);
            return;
        }
        if (this.f7325q + length > this.f7326r) {
            m11885n();
        }
        str.getChars(0, length, this.f7323o, this.f7325q);
        if (this.f7333k != null) {
            m11878g(length);
        } else if (this.f7332j != 0) {
            m11860a(length, this.f7332j);
        } else {
            m11876e(length);
        }
    }

    private void m11876e(int i) {
        int i2 = this.f7325q + i;
        int[] iArr = this.f7331i;
        char length = iArr.length;
        while (this.f7325q < i2) {
            char c;
            int i3;
            while (true) {
                c = this.f7323o[this.f7325q];
                if (c < length && iArr[c] != 0) {
                    break;
                }
                i3 = this.f7325q + 1;
                this.f7325q = i3;
                if (i3 >= i2) {
                    return;
                }
            }
            i3 = this.f7325q - this.f7324p;
            if (i3 > 0) {
                this.f7322n.write(this.f7323o, this.f7324p, i3);
            }
            char[] cArr = this.f7323o;
            int i4 = this.f7325q;
            this.f7325q = i4 + 1;
            c = cArr[i4];
            m11859a(c, iArr[c]);
        }
    }

    private void m11883l(String str) {
        m11885n();
        int length = str.length();
        int i = 0;
        do {
            int i2 = this.f7326r;
            if (i + i2 > length) {
                i2 = length - i;
            }
            str.getChars(i, i + i2, this.f7323o, 0);
            if (this.f7333k != null) {
                m11879h(i2);
            } else if (this.f7332j != 0) {
                m11864b(i2, this.f7332j);
            } else {
                m11877f(i2);
            }
            i += i2;
        } while (i < length);
    }

    private void m11877f(int i) {
        int i2 = 0;
        int[] iArr = this.f7331i;
        char length = iArr.length;
        int i3 = 0;
        while (i2 < i) {
            char c;
            do {
                c = this.f7323o[i2];
                if (c < length && iArr[c] != 0) {
                    break;
                }
                i2++;
            } while (i2 < i);
            int i4 = i2 - i3;
            if (i4 > 0) {
                this.f7322n.write(this.f7323o, i3, i4);
                if (i2 >= i) {
                    return;
                }
            }
            i4 = i2 + 1;
            i3 = m11858a(this.f7323o, i4, i, c, iArr[c]);
            i2 = i4;
        }
    }

    private void m11873c(char[] cArr, int i, int i2) {
        if (this.f7333k != null) {
            m11875d(cArr, i, i2);
        } else if (this.f7332j != 0) {
            m11862a(cArr, i, i2, this.f7332j);
        } else {
            int i3 = i2 + i;
            int[] iArr = this.f7331i;
            char length = iArr.length;
            int i4 = i;
            while (i4 < i3) {
                int i5 = i4;
                do {
                    char c = cArr[i5];
                    if (c < length && iArr[c] != 0) {
                        break;
                    }
                    i5++;
                } while (i5 < i3);
                int i6 = i5 - i4;
                if (i6 < 32) {
                    if (this.f7325q + i6 > this.f7326r) {
                        m11885n();
                    }
                    if (i6 > 0) {
                        System.arraycopy(cArr, i4, this.f7323o, this.f7325q, i6);
                        this.f7325q += i6;
                    }
                } else {
                    m11885n();
                    this.f7322n.write(cArr, i4, i6);
                }
                if (i5 < i3) {
                    i4 = i5 + 1;
                    char c2 = cArr[i5];
                    m11863b(c2, iArr[c2]);
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m11860a(int r10, int r11) {
        /*
        r9 = this;
        r0 = r9.f7325q;
        r1 = r0 + r10;
        r2 = r9.f7331i;
        r0 = r2.length;
        r3 = r11 + 1;
        r3 = java.lang.Math.min(r0, r3);
    L_0x000d:
        r0 = r9.f7325q;
        if (r0 >= r1) goto L_0x0043;
    L_0x0011:
        r0 = r9.f7323o;
        r4 = r9.f7325q;
        r4 = r0[r4];
        if (r4 >= r3) goto L_0x0037;
    L_0x0019:
        r0 = r2[r4];
        if (r0 == 0) goto L_0x003b;
    L_0x001d:
        r5 = r9.f7325q;
        r6 = r9.f7324p;
        r5 = r5 - r6;
        if (r5 <= 0) goto L_0x002d;
    L_0x0024:
        r6 = r9.f7322n;
        r7 = r9.f7323o;
        r8 = r9.f7324p;
        r6.write(r7, r8, r5);
    L_0x002d:
        r5 = r9.f7325q;
        r5 = r5 + 1;
        r9.f7325q = r5;
        r9.m11859a(r4, r0);
        goto L_0x000d;
    L_0x0037:
        if (r4 <= r11) goto L_0x003b;
    L_0x0039:
        r0 = -1;
        goto L_0x001d;
    L_0x003b:
        r0 = r9.f7325q;
        r0 = r0 + 1;
        r9.f7325q = r0;
        if (r0 < r1) goto L_0x0011;
    L_0x0043:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.WriterBasedJsonGenerator.a(int, int):void");
    }

    private void m11864b(int i, int i2) {
        int i3 = 0;
        int[] iArr = this.f7331i;
        char min = Math.min(iArr.length, i2 + 1);
        int i4 = 0;
        int i5 = 0;
        while (i5 < i) {
            char c;
            int i6;
            do {
                c = this.f7323o[i5];
                if (c < min) {
                    i6 = iArr[c];
                    if (i6 != 0) {
                        break;
                    }
                    i3 = i6;
                    i5++;
                } else {
                    if (c > i2) {
                        i6 = -1;
                        break;
                    }
                    i5++;
                }
            } while (i5 < i);
            i6 = i3;
            i3 = i5 - i4;
            if (i3 > 0) {
                this.f7322n.write(this.f7323o, i4, i3);
                if (i5 >= i) {
                    return;
                }
            }
            i4 = i5 + 1;
            i5 = i4;
            i4 = m11858a(this.f7323o, i4, i, c, i6);
            i3 = i6;
        }
    }

    private void m11862a(char[] cArr, int i, int i2, int i3) {
        int i4 = i2 + i;
        int[] iArr = this.f7331i;
        char min = Math.min(iArr.length, i3 + 1);
        int i5 = 0;
        int i6 = i;
        while (i6 < i4) {
            int i7 = i6;
            do {
                char c = cArr[i7];
                if (c < min) {
                    i5 = iArr[c];
                    if (i5 != 0) {
                        break;
                    }
                    i7++;
                } else {
                    if (c > i3) {
                        i5 = -1;
                        break;
                    }
                    i7++;
                }
            } while (i7 < i4);
            int i8 = i7 - i6;
            if (i8 < 32) {
                if (this.f7325q + i8 > this.f7326r) {
                    m11885n();
                }
                if (i8 > 0) {
                    System.arraycopy(cArr, i6, this.f7323o, this.f7325q, i8);
                    this.f7325q += i8;
                }
            } else {
                m11885n();
                this.f7322n.write(cArr, i6, i8);
            }
            if (i7 < i4) {
                i6 = i7 + 1;
                m11863b(c, i5);
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m11878g(int r12) {
        /*
        r11 = this;
        r0 = r11.f7325q;
        r2 = r0 + r12;
        r3 = r11.f7331i;
        r0 = r11.f7332j;
        if (r0 > 0) goto L_0x0040;
    L_0x000a:
        r0 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
    L_0x000d:
        r1 = r3.length;
        r4 = r0 + 1;
        r4 = java.lang.Math.min(r1, r4);
        r5 = r11.f7333k;
    L_0x0016:
        r1 = r11.f7325q;
        if (r1 >= r2) goto L_0x0059;
    L_0x001a:
        r1 = r11.f7323o;
        r6 = r11.f7325q;
        r6 = r1[r6];
        if (r6 >= r4) goto L_0x0043;
    L_0x0022:
        r1 = r3[r6];
        if (r1 == 0) goto L_0x0051;
    L_0x0026:
        r7 = r11.f7325q;
        r8 = r11.f7324p;
        r7 = r7 - r8;
        if (r7 <= 0) goto L_0x0036;
    L_0x002d:
        r8 = r11.f7322n;
        r9 = r11.f7323o;
        r10 = r11.f7324p;
        r8.write(r9, r10, r7);
    L_0x0036:
        r7 = r11.f7325q;
        r7 = r7 + 1;
        r11.f7325q = r7;
        r11.m11859a(r6, r1);
        goto L_0x0016;
    L_0x0040:
        r0 = r11.f7332j;
        goto L_0x000d;
    L_0x0043:
        if (r6 <= r0) goto L_0x0047;
    L_0x0045:
        r1 = -1;
        goto L_0x0026;
    L_0x0047:
        r1 = r5.b();
        r11.f7328t = r1;
        if (r1 == 0) goto L_0x0051;
    L_0x004f:
        r1 = -2;
        goto L_0x0026;
    L_0x0051:
        r1 = r11.f7325q;
        r1 = r1 + 1;
        r11.f7325q = r1;
        if (r1 < r2) goto L_0x001a;
    L_0x0059:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.WriterBasedJsonGenerator.g(int):void");
    }

    private void m11879h(int i) {
        int i2 = 0;
        int[] iArr = this.f7331i;
        char c = this.f7332j <= 0 ? '￿' : this.f7332j;
        char min = Math.min(iArr.length, c + 1);
        CharacterEscapes characterEscapes = this.f7333k;
        int i3 = 0;
        int i4 = 0;
        while (i2 < i) {
            char c2;
            int i5;
            do {
                c2 = this.f7323o[i2];
                if (c2 < min) {
                    i5 = iArr[c2];
                    if (i5 != 0) {
                        break;
                    }
                    i4 = i5;
                    i2++;
                } else if (c2 > c) {
                    i5 = -1;
                    break;
                } else {
                    SerializableString b = characterEscapes.b();
                    this.f7328t = b;
                    if (b != null) {
                        i5 = -2;
                        break;
                    }
                    i2++;
                }
            } while (i2 < i);
            i5 = i4;
            i4 = i2 - i3;
            if (i4 > 0) {
                this.f7322n.write(this.f7323o, i3, i4);
                if (i2 >= i) {
                    return;
                }
            }
            i3 = i2 + 1;
            i2 = i3;
            i3 = m11858a(this.f7323o, i3, i, c2, i5);
            i4 = i5;
        }
    }

    private void m11875d(char[] cArr, int i, int i2) {
        int i3 = i2 + i;
        int[] iArr = this.f7331i;
        char c = this.f7332j <= 0 ? '￿' : this.f7332j;
        char min = Math.min(iArr.length, c + 1);
        CharacterEscapes characterEscapes = this.f7333k;
        int i4 = 0;
        int i5 = i;
        while (i5 < i3) {
            int i6 = i5;
            do {
                char c2 = cArr[i6];
                if (c2 < min) {
                    i4 = iArr[c2];
                    if (i4 != 0) {
                        break;
                    }
                    i6++;
                } else if (c2 > c) {
                    i4 = -1;
                    break;
                } else {
                    SerializableString b = characterEscapes.b();
                    this.f7328t = b;
                    if (b != null) {
                        i4 = -2;
                        break;
                    }
                    i6++;
                }
            } while (i6 < i3);
            int i7 = i6 - i5;
            if (i7 < 32) {
                if (this.f7325q + i7 > this.f7326r) {
                    m11885n();
                }
                if (i7 > 0) {
                    System.arraycopy(cArr, i5, this.f7323o, this.f7325q, i7);
                    this.f7325q += i7;
                }
            } else {
                m11885n();
                this.f7322n.write(cArr, i5, i7);
            }
            if (i6 < i3) {
                i5 = i6 + 1;
                m11863b(c2, i4);
            } else {
                return;
            }
        }
    }

    private void m11866b(Base64Variant base64Variant, byte[] bArr, int i, int i2) {
        int i3 = i2 - 3;
        int i4 = this.f7326r - 6;
        int i5 = base64Variant.f4078c >> 2;
        while (i <= i3) {
            if (this.f7325q > i4) {
                m11885n();
            }
            int i6 = i + 1;
            int i7 = bArr[i] << 8;
            int i8 = i6 + 1;
            i = i8 + 1;
            this.f7325q = base64Variant.m7139a((((bArr[i6] & 255) | i7) << 8) | (bArr[i8] & 255), this.f7323o, this.f7325q);
            i5--;
            if (i5 <= 0) {
                char[] cArr = this.f7323o;
                i6 = this.f7325q;
                this.f7325q = i6 + 1;
                cArr[i6] = '\\';
                cArr = this.f7323o;
                i6 = this.f7325q;
                this.f7325q = i6 + 1;
                cArr[i6] = 'n';
                i5 = base64Variant.f4078c >> 2;
            }
        }
        i3 = i2 - i;
        if (i3 > 0) {
            if (this.f7325q > i4) {
                m11885n();
            }
            i4 = i + 1;
            i5 = bArr[i] << 16;
            if (i3 == 2) {
                i5 |= (bArr[i4] & 255) << 8;
            }
            this.f7325q = base64Variant.m7137a(i5, i3, this.f7323o, this.f7325q);
        }
    }

    private void m11882l() {
        if (this.f7325q + 4 >= this.f7326r) {
            m11885n();
        }
        int i = this.f7325q;
        char[] cArr = this.f7323o;
        cArr[i] = 'n';
        i++;
        cArr[i] = 'u';
        i++;
        cArr[i] = 'l';
        i++;
        cArr[i] = 'l';
        this.f7325q = i + 1;
    }

    private void m11859a(char c, int i) {
        int i2;
        int i3;
        char[] cArr;
        if (i >= 0) {
            if (this.f7325q >= 2) {
                i2 = this.f7325q - 2;
                this.f7324p = i2;
                i3 = i2 + 1;
                this.f7323o[i2] = '\\';
                this.f7323o[i3] = (char) i;
                return;
            }
            cArr = this.f7327s;
            if (cArr == null) {
                cArr = m11884m();
            }
            this.f7324p = this.f7325q;
            cArr[1] = (char) i;
            this.f7322n.write(cArr, 0, 2);
        } else if (i == -2) {
            String a;
            if (this.f7328t == null) {
                a = this.f7333k.b().mo1050a();
            } else {
                a = this.f7328t.mo1050a();
                this.f7328t = null;
            }
            r1 = a.length();
            if (this.f7325q >= r1) {
                i3 = this.f7325q - r1;
                this.f7324p = i3;
                a.getChars(0, r1, this.f7323o, i3);
                return;
            }
            this.f7324p = this.f7325q;
            this.f7322n.write(a);
        } else if (this.f7325q >= 6) {
            char[] cArr2 = this.f7323o;
            i2 = this.f7325q - 6;
            this.f7324p = i2;
            cArr2[i2] = '\\';
            i2++;
            cArr2[i2] = 'u';
            if (c > 'ÿ') {
                i3 = (c >> 8) & 255;
                i2++;
                cArr2[i2] = f7321m[i3 >> 4];
                i2++;
                cArr2[i2] = f7321m[i3 & 15];
                c = (char) (c & 255);
            } else {
                i2++;
                cArr2[i2] = '0';
                i2++;
                cArr2[i2] = '0';
            }
            i2++;
            cArr2[i2] = f7321m[c >> 4];
            cArr2[i2 + 1] = f7321m[c & 15];
        } else {
            cArr = this.f7327s;
            if (cArr == null) {
                cArr = m11884m();
            }
            this.f7324p = this.f7325q;
            if (c > 'ÿ') {
                r1 = (c >> 8) & 255;
                i3 = c & 255;
                cArr[10] = f7321m[r1 >> 4];
                cArr[11] = f7321m[r1 & 15];
                cArr[12] = f7321m[i3 >> 4];
                cArr[13] = f7321m[i3 & 15];
                this.f7322n.write(cArr, 8, 6);
                return;
            }
            cArr[6] = f7321m[c >> 4];
            cArr[7] = f7321m[c & 15];
            this.f7322n.write(cArr, 2, 6);
        }
    }

    private int m11858a(char[] cArr, int i, int i2, char c, int i3) {
        char[] cArr2;
        if (i3 >= 0) {
            if (i <= 1 || i >= i2) {
                cArr2 = this.f7327s;
                if (cArr2 == null) {
                    cArr2 = m11884m();
                }
                cArr2[1] = (char) i3;
                this.f7322n.write(cArr2, 0, 2);
                return i;
            }
            i -= 2;
            cArr[i] = '\\';
            cArr[i + 1] = (char) i3;
            return i;
        } else if (i3 == -2) {
            String a;
            if (this.f7328t == null) {
                a = this.f7333k.b().mo1050a();
            } else {
                a = this.f7328t.mo1050a();
                this.f7328t = null;
            }
            r1 = a.length();
            if (i < r1 || i >= i2) {
                this.f7322n.write(a);
                return i;
            }
            i -= r1;
            a.getChars(0, r1, cArr, i);
            return i;
        } else if (i <= 5 || i >= i2) {
            cArr2 = this.f7327s;
            if (cArr2 == null) {
                cArr2 = m11884m();
            }
            this.f7324p = this.f7325q;
            if (c > 'ÿ') {
                r1 = (c >> 8) & 255;
                r2 = c & 255;
                cArr2[10] = f7321m[r1 >> 4];
                cArr2[11] = f7321m[r1 & 15];
                cArr2[12] = f7321m[r2 >> 4];
                cArr2[13] = f7321m[r2 & 15];
                this.f7322n.write(cArr2, 8, 6);
                return i;
            }
            cArr2[6] = f7321m[c >> 4];
            cArr2[7] = f7321m[c & 15];
            this.f7322n.write(cArr2, 2, 6);
            return i;
        } else {
            int i4 = i - 6;
            r1 = i4 + 1;
            cArr[i4] = '\\';
            i4 = r1 + 1;
            cArr[r1] = 'u';
            if (c > 'ÿ') {
                r1 = (c >> 8) & 255;
                r2 = i4 + 1;
                cArr[i4] = f7321m[r1 >> 4];
                i4 = r2 + 1;
                cArr[r2] = f7321m[r1 & 15];
                c = (char) (c & 255);
            } else {
                r1 = i4 + 1;
                cArr[i4] = '0';
                i4 = r1 + 1;
                cArr[r1] = '0';
            }
            r1 = i4 + 1;
            cArr[i4] = f7321m[c >> 4];
            cArr[r1] = f7321m[c & 15];
            return r1 - 5;
        }
    }

    private void m11863b(char c, int i) {
        int i2;
        if (i >= 0) {
            if (this.f7325q + 2 > this.f7326r) {
                m11885n();
            }
            char[] cArr = this.f7323o;
            i2 = this.f7325q;
            this.f7325q = i2 + 1;
            cArr[i2] = '\\';
            cArr = this.f7323o;
            i2 = this.f7325q;
            this.f7325q = i2 + 1;
            cArr[i2] = (char) i;
        } else if (i != -2) {
            if (this.f7325q + 2 > this.f7326r) {
                m11885n();
            }
            int i3 = this.f7325q;
            char[] cArr2 = this.f7323o;
            int i4 = i3 + 1;
            cArr2[i3] = '\\';
            i3 = i4 + 1;
            cArr2[i4] = 'u';
            if (c > 'ÿ') {
                i4 = (c >> 8) & 255;
                int i5 = i3 + 1;
                cArr2[i3] = f7321m[i4 >> 4];
                i3 = i5 + 1;
                cArr2[i5] = f7321m[i4 & 15];
                c = (char) (c & 255);
            } else {
                i4 = i3 + 1;
                cArr2[i3] = '0';
                i3 = i4 + 1;
                cArr2[i4] = '0';
            }
            i4 = i3 + 1;
            cArr2[i3] = f7321m[c >> 4];
            cArr2[i4] = f7321m[c & 15];
            this.f7325q = i4;
        } else {
            String a;
            if (this.f7328t == null) {
                a = this.f7333k.b().mo1050a();
            } else {
                a = this.f7328t.mo1050a();
                this.f7328t = null;
            }
            i2 = a.length();
            if (this.f7325q + i2 > this.f7326r) {
                m11885n();
                if (i2 > this.f7326r) {
                    this.f7322n.write(a);
                    return;
                }
            }
            a.getChars(0, i2, this.f7323o, this.f7325q);
            this.f7325q += i2;
        }
    }

    private char[] m11884m() {
        char[] cArr = new char[14];
        cArr[0] = '\\';
        cArr[2] = '\\';
        cArr[3] = 'u';
        cArr[4] = '0';
        cArr[5] = '0';
        cArr[8] = '\\';
        cArr[9] = 'u';
        this.f7327s = cArr;
        return cArr;
    }

    private void m11885n() {
        int i = this.f7325q - this.f7324p;
        if (i > 0) {
            int i2 = this.f7324p;
            this.f7324p = 0;
            this.f7325q = 0;
            this.f7322n.write(this.f7323o, i2, i);
        }
    }
}

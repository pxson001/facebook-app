package com.fasterxml.jackson.core.json;

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
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: free_mem */
public class UTF8JsonGenerator extends JsonGeneratorImpl {
    static final byte[] f11419m = CharTypes.h();
    private static final byte[] f11420v = new byte[]{(byte) 110, (byte) 117, (byte) 108, (byte) 108};
    private static final byte[] f11421w = new byte[]{(byte) 116, (byte) 114, (byte) 117, (byte) 101};
    private static final byte[] f11422x = new byte[]{(byte) 102, (byte) 97, (byte) 108, (byte) 115, (byte) 101};
    protected final OutputStream f11423n;
    protected byte[] f11424o;
    protected int f11425p = 0;
    protected final int f11426q;
    protected final int f11427r;
    protected char[] f11428s;
    protected final int f11429t;
    protected boolean f11430u;

    public UTF8JsonGenerator(IOContext iOContext, int i, ObjectCodec objectCodec, OutputStream outputStream) {
        super(iOContext, i, objectCodec);
        this.f11423n = outputStream;
        this.f11430u = true;
        this.f11424o = iOContext.f();
        this.f11426q = this.f11424o.length;
        this.f11427r = this.f11426q >> 3;
        this.f11428s = iOContext.h();
        this.f11429t = this.f11428s.length;
        if (a(Feature.ESCAPE_NON_ASCII)) {
            a(127);
        }
    }

    public final void m11850a(String str) {
        boolean z = true;
        int a = this.e.a(str);
        if (a == 4) {
            GeneratorBase.i("Can not write a field name, expecting a value");
        }
        if (this.a != null) {
            if (a != 1) {
                z = false;
            }
            m11825b(str, z);
            return;
        }
        if (a == 1) {
            if (this.f11425p >= this.f11426q) {
                m11844m();
            }
            byte[] bArr = this.f11424o;
            a = this.f11425p;
            this.f11425p = a + 1;
            bArr[a] = (byte) 44;
        }
        m11840j(str);
    }

    public final void m11857b(SerializableString serializableString) {
        boolean z = true;
        int a = this.e.a(serializableString.a());
        if (a == 4) {
            GeneratorBase.i("Can not write a field name, expecting a value");
        }
        if (this.a != null) {
            if (a != 1) {
                z = false;
            }
            m11820a(serializableString, z);
            return;
        }
        if (a == 1) {
            if (this.f11425p >= this.f11426q) {
                m11844m();
            }
            byte[] bArr = this.f11424o;
            a = this.f11425p;
            this.f11425p = a + 1;
            bArr[a] = (byte) 44;
        }
        m11835e(serializableString);
    }

    public final void m11862d() {
        m11869h("start an array");
        this.e = this.e.j();
        if (this.a != null) {
            this.a.e(this);
            return;
        }
        if (this.f11425p >= this.f11426q) {
            m11844m();
        }
        byte[] bArr = this.f11424o;
        int i = this.f11425p;
        this.f11425p = i + 1;
        bArr[i] = (byte) 91;
    }

    public final void m11864e() {
        if (!this.e.b()) {
            GeneratorBase.i("Current context not an ARRAY but " + this.e.e());
        }
        if (this.a != null) {
            this.a.b(this, this.e.f());
        } else {
            if (this.f11425p >= this.f11426q) {
                m11844m();
            }
            byte[] bArr = this.f11424o;
            int i = this.f11425p;
            this.f11425p = i + 1;
            bArr[i] = (byte) 93;
        }
        this.e = this.e.c;
    }

    public final void m11866f() {
        m11869h("start an object");
        this.e = this.e.k();
        if (this.a != null) {
            this.a.b(this);
            return;
        }
        if (this.f11425p >= this.f11426q) {
            m11844m();
        }
        byte[] bArr = this.f11424o;
        int i = this.f11425p;
        this.f11425p = i + 1;
        bArr[i] = (byte) 123;
    }

    public final void m11867g() {
        if (!this.e.d()) {
            GeneratorBase.i("Current context not an object but " + this.e.e());
        }
        if (this.a != null) {
            this.a.a(this, this.e.f());
        } else {
            if (this.f11425p >= this.f11426q) {
                m11844m();
            }
            byte[] bArr = this.f11424o;
            int i = this.f11425p;
            this.f11425p = i + 1;
            bArr[i] = (byte) 125;
        }
        this.e = this.e.c;
    }

    private void m11840j(String str) {
        if (a(Feature.QUOTE_FIELD_NAMES)) {
            if (this.f11425p >= this.f11426q) {
                m11844m();
            }
            byte[] bArr = this.f11424o;
            int i = this.f11425p;
            this.f11425p = i + 1;
            bArr[i] = (byte) 34;
            int length = str.length();
            if (length <= this.f11429t) {
                str.getChars(0, length, this.f11428s, 0);
                if (length <= this.f11427r) {
                    if (this.f11425p + length > this.f11426q) {
                        m11844m();
                    }
                    m11836e(this.f11428s, 0, length);
                } else {
                    m11833d(this.f11428s, 0, length);
                }
            } else {
                m11843l(str);
            }
            if (this.f11425p >= this.f11426q) {
                m11844m();
            }
            bArr = this.f11424o;
            i = this.f11425p;
            this.f11425p = i + 1;
            bArr[i] = (byte) 34;
            return;
        }
        m11843l(str);
    }

    private void m11835e(SerializableString serializableString) {
        int a;
        if (a(Feature.QUOTE_FIELD_NAMES)) {
            if (this.f11425p >= this.f11426q) {
                m11844m();
            }
            byte[] bArr = this.f11424o;
            int i = this.f11425p;
            this.f11425p = i + 1;
            bArr[i] = (byte) 34;
            a = serializableString.a(this.f11424o, this.f11425p);
            if (a < 0) {
                m11827b(serializableString.e());
            } else {
                this.f11425p = a + this.f11425p;
            }
            if (this.f11425p >= this.f11426q) {
                m11844m();
            }
            bArr = this.f11424o;
            i = this.f11425p;
            this.f11425p = i + 1;
            bArr[i] = (byte) 34;
            return;
        }
        a = serializableString.a(this.f11424o, this.f11425p);
        if (a < 0) {
            m11827b(serializableString.e());
        } else {
            this.f11425p = a + this.f11425p;
        }
    }

    private void m11825b(String str, boolean z) {
        if (z) {
            this.a.c(this);
        } else {
            this.a.h(this);
        }
        if (a(Feature.QUOTE_FIELD_NAMES)) {
            if (this.f11425p >= this.f11426q) {
                m11844m();
            }
            byte[] bArr = this.f11424o;
            int i = this.f11425p;
            this.f11425p = i + 1;
            bArr[i] = (byte) 34;
            int length = str.length();
            if (length <= this.f11429t) {
                str.getChars(0, length, this.f11428s, 0);
                if (length <= this.f11427r) {
                    if (this.f11425p + length > this.f11426q) {
                        m11844m();
                    }
                    m11836e(this.f11428s, 0, length);
                } else {
                    m11833d(this.f11428s, 0, length);
                }
            } else {
                m11843l(str);
            }
            if (this.f11425p >= this.f11426q) {
                m11844m();
            }
            bArr = this.f11424o;
            i = this.f11425p;
            this.f11425p = i + 1;
            bArr[i] = (byte) 34;
            return;
        }
        m11843l(str);
    }

    private void m11820a(SerializableString serializableString, boolean z) {
        if (z) {
            this.a.c(this);
        } else {
            this.a.h(this);
        }
        boolean a = a(Feature.QUOTE_FIELD_NAMES);
        if (a) {
            if (this.f11425p >= this.f11426q) {
                m11844m();
            }
            byte[] bArr = this.f11424o;
            int i = this.f11425p;
            this.f11425p = i + 1;
            bArr[i] = (byte) 34;
        }
        m11827b(serializableString.e());
        if (a) {
            if (this.f11425p >= this.f11426q) {
                m11844m();
            }
            byte[] bArr2 = this.f11424o;
            int i2 = this.f11425p;
            this.f11425p = i2 + 1;
            bArr2[i2] = (byte) 34;
        }
    }

    public final void m11858b(String str) {
        m11869h("write text value");
        if (str == null) {
            m11842l();
            return;
        }
        int length = str.length();
        if (length > this.f11429t) {
            m11841k(str);
            return;
        }
        str.getChars(0, length, this.f11428s, 0);
        if (length > this.f11427r) {
            m11829c(length);
            return;
        }
        if (this.f11425p + length >= this.f11426q) {
            m11844m();
        }
        byte[] bArr = this.f11424o;
        int i = this.f11425p;
        this.f11425p = i + 1;
        bArr[i] = (byte) 34;
        m11836e(this.f11428s, 0, length);
        if (this.f11425p >= this.f11426q) {
            m11844m();
        }
        byte[] bArr2 = this.f11424o;
        int i2 = this.f11425p;
        this.f11425p = i2 + 1;
        bArr2[i2] = (byte) 34;
    }

    private void m11841k(String str) {
        if (this.f11425p >= this.f11426q) {
            m11844m();
        }
        byte[] bArr = this.f11424o;
        int i = this.f11425p;
        this.f11425p = i + 1;
        bArr[i] = (byte) 34;
        m11843l(str);
        if (this.f11425p >= this.f11426q) {
            m11844m();
        }
        bArr = this.f11424o;
        i = this.f11425p;
        this.f11425p = i + 1;
        bArr[i] = (byte) 34;
    }

    private void m11829c(int i) {
        if (this.f11425p >= this.f11426q) {
            m11844m();
        }
        byte[] bArr = this.f11424o;
        int i2 = this.f11425p;
        this.f11425p = i2 + 1;
        bArr[i2] = (byte) 34;
        m11833d(this.f11428s, 0, i);
        if (this.f11425p >= this.f11426q) {
            m11844m();
        }
        bArr = this.f11424o;
        i2 = this.f11425p;
        this.f11425p = i2 + 1;
        bArr[i2] = (byte) 34;
    }

    public final void m11855a(char[] cArr, int i, int i2) {
        m11869h("write text value");
        if (this.f11425p >= this.f11426q) {
            m11844m();
        }
        byte[] bArr = this.f11424o;
        int i3 = this.f11425p;
        this.f11425p = i3 + 1;
        bArr[i3] = (byte) 34;
        if (i2 <= this.f11427r) {
            if (this.f11425p + i2 > this.f11426q) {
                m11844m();
            }
            m11836e(cArr, i, i2);
        } else {
            m11833d(cArr, i, i2);
        }
        if (this.f11425p >= this.f11426q) {
            m11844m();
        }
        bArr = this.f11424o;
        i3 = this.f11425p;
        this.f11425p = i3 + 1;
        bArr[i3] = (byte) 34;
    }

    public final void m11860c(SerializableString serializableString) {
        m11869h("write text value");
        if (this.f11425p >= this.f11426q) {
            m11844m();
        }
        byte[] bArr = this.f11424o;
        int i = this.f11425p;
        this.f11425p = i + 1;
        bArr[i] = (byte) 34;
        int a = serializableString.a(this.f11424o, this.f11425p);
        if (a < 0) {
            m11827b(serializableString.e());
        } else {
            this.f11425p = a + this.f11425p;
        }
        if (this.f11425p >= this.f11426q) {
            m11844m();
        }
        bArr = this.f11424o;
        i = this.f11425p;
        this.f11425p = i + 1;
        bArr[i] = (byte) 34;
    }

    public final void m11861c(String str) {
        int length = str.length();
        int i = 0;
        while (length > 0) {
            char[] cArr = this.f11428s;
            int length2 = cArr.length;
            if (length < length2) {
                length2 = length;
            }
            str.getChars(i, i + length2, cArr, 0);
            b(cArr, 0, length2);
            i += length2;
            length -= length2;
        }
    }

    public final void m11863d(SerializableString serializableString) {
        byte[] d = serializableString.d();
        if (d.length > 0) {
            m11827b(d);
        }
    }

    public final void m11859b(char[] cArr, int i, int i2) {
        int i3 = (i2 + i2) + i2;
        if (this.f11425p + i3 > this.f11426q) {
            if (this.f11426q < i3) {
                m11830c(cArr, i, i2);
                return;
            }
            m11844m();
        }
        int i4 = i2 + i;
        i3 = i;
        while (i3 < i4) {
            while (true) {
                char c = cArr[i3];
                if (c > '') {
                    break;
                }
                byte[] bArr = this.f11424o;
                int i5 = this.f11425p;
                this.f11425p = i5 + 1;
                bArr[i5] = (byte) c;
                i3++;
                if (i3 >= i4) {
                    return;
                }
            }
            i = i3 + 1;
            i3 = cArr[i3];
            if (i3 < 'ࠀ') {
                byte[] bArr2 = this.f11424o;
                int i6 = this.f11425p;
                this.f11425p = i6 + 1;
                bArr2[i6] = (byte) ((i3 >> 6) | 192);
                bArr2 = this.f11424o;
                i6 = this.f11425p;
                this.f11425p = i6 + 1;
                bArr2[i6] = (byte) ((i3 & 63) | 128);
                i3 = i;
            } else {
                m11816a(i3, cArr, i, i4);
                i3 = i;
            }
        }
    }

    public final void m11845a(char c) {
        if (this.f11425p + 3 >= this.f11426q) {
            m11844m();
        }
        byte[] bArr = this.f11424o;
        int i;
        if (c <= '') {
            i = this.f11425p;
            this.f11425p = i + 1;
            bArr[i] = (byte) c;
        } else if (c < 'ࠀ') {
            i = this.f11425p;
            this.f11425p = i + 1;
            bArr[i] = (byte) ((c >> 6) | 192);
            i = this.f11425p;
            this.f11425p = i + 1;
            bArr[i] = (byte) ((c & 63) | 128);
        } else {
            m11816a((int) c, null, 0, 0);
        }
    }

    private final void m11830c(char[] cArr, int i, int i2) {
        int i3 = this.f11426q;
        byte[] bArr = this.f11424o;
        int i4 = i;
        while (i4 < i2) {
            while (true) {
                char c = cArr[i4];
                if (c >= '') {
                    break;
                }
                if (this.f11425p >= i3) {
                    m11844m();
                }
                int i5 = this.f11425p;
                this.f11425p = i5 + 1;
                bArr[i5] = (byte) c;
                i4++;
                if (i4 >= i2) {
                    return;
                }
            }
            if (this.f11425p + 3 >= this.f11426q) {
                m11844m();
            }
            i = i4 + 1;
            i4 = cArr[i4];
            if (i4 < 'ࠀ') {
                int i6 = this.f11425p;
                this.f11425p = i6 + 1;
                bArr[i6] = (byte) ((i4 >> 6) | 192);
                i6 = this.f11425p;
                this.f11425p = i6 + 1;
                bArr[i6] = (byte) ((i4 & 63) | 128);
                i4 = i;
            } else {
                m11816a(i4, cArr, i, i2);
                i4 = i;
            }
        }
    }

    public final void m11849a(Base64Variant base64Variant, byte[] bArr, int i, int i2) {
        m11869h("write binary value");
        if (this.f11425p >= this.f11426q) {
            m11844m();
        }
        byte[] bArr2 = this.f11424o;
        int i3 = this.f11425p;
        this.f11425p = i3 + 1;
        bArr2[i3] = (byte) 34;
        m11823b(base64Variant, bArr, i, i + i2);
        if (this.f11425p >= this.f11426q) {
            m11844m();
        }
        bArr2 = this.f11424o;
        i3 = this.f11425p;
        this.f11425p = i3 + 1;
        bArr2[i3] = (byte) 34;
    }

    public final void m11853a(short s) {
        m11869h("write number");
        if (this.f11425p + 6 >= this.f11426q) {
            m11844m();
        }
        if (this.d) {
            m11826b(s);
        } else {
            this.f11425p = NumberOutput.a(s, this.f11424o, this.f11425p);
        }
    }

    private void m11826b(short s) {
        if (this.f11425p + 8 >= this.f11426q) {
            m11844m();
        }
        byte[] bArr = this.f11424o;
        int i = this.f11425p;
        this.f11425p = i + 1;
        bArr[i] = (byte) 34;
        this.f11425p = NumberOutput.a(s, this.f11424o, this.f11425p);
        bArr = this.f11424o;
        i = this.f11425p;
        this.f11425p = i + 1;
        bArr[i] = (byte) 34;
    }

    public final void m11856b(int i) {
        m11869h("write number");
        if (this.f11425p + 11 >= this.f11426q) {
            m11844m();
        }
        if (this.d) {
            m11832d(i);
        } else {
            this.f11425p = NumberOutput.a(i, this.f11424o, this.f11425p);
        }
    }

    private void m11832d(int i) {
        if (this.f11425p + 13 >= this.f11426q) {
            m11844m();
        }
        byte[] bArr = this.f11424o;
        int i2 = this.f11425p;
        this.f11425p = i2 + 1;
        bArr[i2] = (byte) 34;
        this.f11425p = NumberOutput.a(i, this.f11424o, this.f11425p);
        bArr = this.f11424o;
        i2 = this.f11425p;
        this.f11425p = i2 + 1;
        bArr[i2] = (byte) 34;
    }

    public final void m11848a(long j) {
        m11869h("write number");
        if (this.d) {
            m11822b(j);
            return;
        }
        if (this.f11425p + 21 >= this.f11426q) {
            m11844m();
        }
        this.f11425p = NumberOutput.a(j, this.f11424o, this.f11425p);
    }

    private void m11822b(long j) {
        if (this.f11425p + 23 >= this.f11426q) {
            m11844m();
        }
        byte[] bArr = this.f11424o;
        int i = this.f11425p;
        this.f11425p = i + 1;
        bArr[i] = (byte) 34;
        this.f11425p = NumberOutput.a(j, this.f11424o, this.f11425p);
        bArr = this.f11424o;
        i = this.f11425p;
        this.f11425p = i + 1;
        bArr[i] = (byte) 34;
    }

    public final void m11852a(BigInteger bigInteger) {
        m11869h("write number");
        if (bigInteger == null) {
            m11842l();
        } else if (this.d) {
            m11824b((Object) bigInteger);
        } else {
            c(bigInteger.toString());
        }
    }

    public final void m11846a(double d) {
        if (this.d || ((Double.isNaN(d) || Double.isInfinite(d)) && a(Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            b(String.valueOf(d));
            return;
        }
        m11869h("write number");
        c(String.valueOf(d));
    }

    public final void m11847a(float f) {
        if (this.d || ((Float.isNaN(f) || Float.isInfinite(f)) && a(Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            b(String.valueOf(f));
            return;
        }
        m11869h("write number");
        c(String.valueOf(f));
    }

    public final void m11851a(BigDecimal bigDecimal) {
        m11869h("write number");
        if (bigDecimal == null) {
            m11842l();
        } else if (this.d) {
            m11824b((Object) bigDecimal);
        } else {
            c(bigDecimal.toString());
        }
    }

    public final void m11865e(String str) {
        m11869h("write number");
        if (this.d) {
            m11824b((Object) str);
        } else {
            c(str);
        }
    }

    private void m11824b(Object obj) {
        if (this.f11425p >= this.f11426q) {
            m11844m();
        }
        byte[] bArr = this.f11424o;
        int i = this.f11425p;
        this.f11425p = i + 1;
        bArr[i] = (byte) 34;
        c(obj.toString());
        if (this.f11425p >= this.f11426q) {
            m11844m();
        }
        bArr = this.f11424o;
        i = this.f11425p;
        this.f11425p = i + 1;
        bArr[i] = (byte) 34;
    }

    public final void m11854a(boolean z) {
        m11869h("write boolean value");
        if (this.f11425p + 5 >= this.f11426q) {
            m11844m();
        }
        Object obj = z ? f11421w : f11422x;
        int length = obj.length;
        System.arraycopy(obj, 0, this.f11424o, this.f11425p, length);
        this.f11425p += length;
    }

    public final void m11868h() {
        m11869h("write null value");
        m11842l();
    }

    protected final void m11869h(String str) {
        int m = this.e.m();
        if (m == 5) {
            GeneratorBase.i("Can not " + str + ", expecting field name");
        }
        if (this.a == null) {
            byte b;
            switch (m) {
                case 1:
                    b = (byte) 44;
                    break;
                case 2:
                    b = (byte) 58;
                    break;
                case 3:
                    if (this.l != null) {
                        byte[] d = this.l.d();
                        if (d.length > 0) {
                            m11827b(d);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
            if (this.f11425p >= this.f11426q) {
                m11844m();
            }
            this.f11424o[this.f11425p] = b;
            this.f11425p++;
            return;
        }
        m11834e(m);
    }

    private void m11834e(int i) {
        switch (i) {
            case 0:
                if (this.e.b()) {
                    this.a.g(this);
                    return;
                } else if (this.e.d()) {
                    this.a.h(this);
                    return;
                } else {
                    return;
                }
            case 1:
                this.a.f(this);
                return;
            case 2:
                this.a.d(this);
                return;
            case 3:
                this.a.a(this);
                return;
            default:
                VersionUtil.b();
                return;
        }
    }

    public final void flush() {
        m11844m();
        if (this.f11423n != null && a(Feature.FLUSH_PASSED_TO_STREAM)) {
            this.f11423n.flush();
        }
    }

    public void close() {
        super.close();
        if (this.f11424o != null && a(Feature.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                JsonStreamContext jsonStreamContext = this.e;
                if (!jsonStreamContext.b()) {
                    if (!jsonStreamContext.d()) {
                        break;
                    }
                    g();
                } else {
                    e();
                }
            }
        }
        m11844m();
        if (this.f11423n != null) {
            if (this.h.c || a(Feature.AUTO_CLOSE_TARGET)) {
                this.f11423n.close();
            } else if (a(Feature.FLUSH_PASSED_TO_STREAM)) {
                this.f11423n.flush();
            }
        }
        m11870j();
    }

    protected final void m11870j() {
        byte[] bArr = this.f11424o;
        if (bArr != null && this.f11430u) {
            this.f11424o = null;
            this.h.b(bArr);
        }
        char[] cArr = this.f11428s;
        if (cArr != null) {
            this.f11428s = null;
            this.h.b(cArr);
        }
    }

    private final void m11827b(byte[] bArr) {
        int length = bArr.length;
        if (this.f11425p + length > this.f11426q) {
            m11844m();
            if (length > 512) {
                this.f11423n.write(bArr, 0, length);
                return;
            }
        }
        System.arraycopy(bArr, 0, this.f11424o, this.f11425p, length);
        this.f11425p = length + this.f11425p;
    }

    private final void m11843l(String str) {
        int length = str.length();
        char[] cArr = this.f11428s;
        int i = length;
        length = 0;
        while (i > 0) {
            int min = Math.min(this.f11427r, i);
            str.getChars(length, length + min, cArr, 0);
            if (this.f11425p + min > this.f11426q) {
                m11844m();
            }
            m11836e(cArr, 0, min);
            length += min;
            i -= min;
        }
    }

    private final void m11833d(char[] cArr, int i, int i2) {
        do {
            int min = Math.min(this.f11427r, i2);
            if (this.f11425p + min > this.f11426q) {
                m11844m();
            }
            m11836e(cArr, i, min);
            i += min;
            i2 -= min;
        } while (i2 > 0);
    }

    private final void m11836e(char[] cArr, int i, int i2) {
        int i3 = i2 + i;
        int i4 = this.f11425p;
        byte[] bArr = this.f11424o;
        int[] iArr = this.i;
        while (i < i3) {
            char c = cArr[i];
            if (c > '' || iArr[c] != 0) {
                break;
            }
            int i5 = i4 + 1;
            bArr[i4] = (byte) c;
            i++;
            i4 = i5;
        }
        this.f11425p = i4;
        if (i >= i3) {
            return;
        }
        if (this.k != null) {
            m11839h(cArr, i, i3);
        } else if (this.j == 0) {
            m11837f(cArr, i, i3);
        } else {
            m11838g(cArr, i, i3);
        }
    }

    private final void m11837f(char[] cArr, int i, int i2) {
        if (this.f11425p + ((i2 - i) * 6) > this.f11426q) {
            m11844m();
        }
        int i3 = this.f11425p;
        byte[] bArr = this.f11424o;
        int[] iArr = this.i;
        while (i < i2) {
            int i4 = i + 1;
            int i5 = cArr[i];
            int i6;
            if (i5 <= '') {
                if (iArr[i5] == 0) {
                    i6 = i3 + 1;
                    bArr[i3] = (byte) i5;
                    i3 = i6;
                    i = i4;
                } else {
                    i6 = iArr[i5];
                    if (i6 > 0) {
                        i5 = i3 + 1;
                        bArr[i3] = (byte) 92;
                        i3 = i5 + 1;
                        bArr[i5] = (byte) i6;
                        i = i4;
                    } else {
                        i3 = m11831d(i5, i3);
                        i = i4;
                    }
                }
            } else if (i5 <= '߿') {
                i6 = i3 + 1;
                bArr[i3] = (byte) ((i5 >> 6) | 192);
                i3 = i6 + 1;
                bArr[i6] = (byte) ((i5 & 63) | 128);
                i = i4;
            } else {
                i3 = m11821b(i5, i3);
                i = i4;
            }
        }
        this.f11425p = i3;
    }

    private final void m11838g(char[] cArr, int i, int i2) {
        if (this.f11425p + ((i2 - i) * 6) > this.f11426q) {
            m11844m();
        }
        int i3 = this.f11425p;
        byte[] bArr = this.f11424o;
        int[] iArr = this.i;
        char c = this.j;
        while (i < i2) {
            int i4 = i + 1;
            int i5 = cArr[i];
            int i6;
            if (i5 <= '') {
                if (iArr[i5] == 0) {
                    i6 = i3 + 1;
                    bArr[i3] = (byte) i5;
                    i3 = i6;
                    i = i4;
                } else {
                    i6 = iArr[i5];
                    if (i6 > 0) {
                        i5 = i3 + 1;
                        bArr[i3] = (byte) 92;
                        i3 = i5 + 1;
                        bArr[i5] = (byte) i6;
                        i = i4;
                    } else {
                        i3 = m11831d(i5, i3);
                        i = i4;
                    }
                }
            } else if (i5 > c) {
                i3 = m11831d(i5, i3);
                i = i4;
            } else if (i5 <= '߿') {
                i6 = i3 + 1;
                bArr[i3] = (byte) ((i5 >> 6) | 192);
                i3 = i6 + 1;
                bArr[i6] = (byte) ((i5 & 63) | 128);
                i = i4;
            } else {
                i3 = m11821b(i5, i3);
                i = i4;
            }
        }
        this.f11425p = i3;
    }

    private void m11839h(char[] cArr, int i, int i2) {
        if (this.f11425p + ((i2 - i) * 6) > this.f11426q) {
            m11844m();
        }
        int i3 = this.f11425p;
        byte[] bArr = this.f11424o;
        int[] iArr = this.i;
        char c = this.j <= 0 ? '￿' : this.j;
        CharacterEscapes characterEscapes = this.k;
        while (i < i2) {
            int i4 = i + 1;
            int i5 = cArr[i];
            int i6;
            SerializableString b;
            if (i5 <= '') {
                if (iArr[i5] == 0) {
                    i6 = i3 + 1;
                    bArr[i3] = (byte) i5;
                    i3 = i6;
                    i = i4;
                } else {
                    i6 = iArr[i5];
                    if (i6 > 0) {
                        i5 = i3 + 1;
                        bArr[i3] = (byte) 92;
                        i3 = i5 + 1;
                        bArr[i5] = (byte) i6;
                        i = i4;
                    } else if (i6 == -2) {
                        b = characterEscapes.b();
                        if (b == null) {
                            GeneratorBase.i("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(i5) + ", although was supposed to have one");
                        }
                        i3 = m11818a(bArr, i3, b, i2 - i4);
                        i = i4;
                    } else {
                        i3 = m11831d(i5, i3);
                        i = i4;
                    }
                }
            } else if (i5 > c) {
                i3 = m11831d(i5, i3);
                i = i4;
            } else {
                b = characterEscapes.b();
                if (b != null) {
                    i3 = m11818a(bArr, i3, b, i2 - i4);
                    i = i4;
                } else if (i5 <= '߿') {
                    i6 = i3 + 1;
                    bArr[i3] = (byte) ((i5 >> 6) | 192);
                    i3 = i6 + 1;
                    bArr[i6] = (byte) ((i5 & 63) | 128);
                    i = i4;
                } else {
                    i3 = m11821b(i5, i3);
                    i = i4;
                }
            }
        }
        this.f11425p = i3;
    }

    private int m11818a(byte[] bArr, int i, SerializableString serializableString, int i2) {
        Object d = serializableString.d();
        int length = d.length;
        if (length > 6) {
            return m11817a(bArr, i, this.f11426q, d, i2);
        }
        System.arraycopy(d, 0, bArr, i, length);
        return length + i;
    }

    private int m11817a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4;
        int length = bArr2.length;
        if (i + length > i2) {
            this.f11425p = i;
            m11844m();
            i4 = this.f11425p;
            if (length > bArr.length) {
                this.f11423n.write(bArr2, 0, length);
                return i4;
            }
            System.arraycopy(bArr2, 0, bArr, i4, length);
            i4 += length;
        } else {
            i4 = i;
        }
        if ((i3 * 6) + i4 <= i2) {
            return i4;
        }
        m11844m();
        return this.f11425p;
    }

    private void m11823b(Base64Variant base64Variant, byte[] bArr, int i, int i2) {
        int i3 = i2 - 3;
        int i4 = this.f11426q - 6;
        int i5 = base64Variant.c >> 2;
        while (i <= i3) {
            if (this.f11425p > i4) {
                m11844m();
            }
            int i6 = i + 1;
            int i7 = bArr[i] << 8;
            int i8 = i6 + 1;
            i = i8 + 1;
            this.f11425p = base64Variant.a((((bArr[i6] & 255) | i7) << 8) | (bArr[i8] & 255), this.f11424o, this.f11425p);
            i5--;
            if (i5 <= 0) {
                byte[] bArr2 = this.f11424o;
                i6 = this.f11425p;
                this.f11425p = i6 + 1;
                bArr2[i6] = (byte) 92;
                bArr2 = this.f11424o;
                i6 = this.f11425p;
                this.f11425p = i6 + 1;
                bArr2[i6] = (byte) 110;
                i5 = base64Variant.c >> 2;
            }
        }
        i3 = i2 - i;
        if (i3 > 0) {
            if (this.f11425p > i4) {
                m11844m();
            }
            i4 = i + 1;
            i5 = bArr[i] << 16;
            if (i3 == 2) {
                i5 |= (bArr[i4] & 255) << 8;
            }
            this.f11425p = base64Variant.a(i5, i3, this.f11424o, this.f11425p);
        }
    }

    private int m11816a(int i, char[] cArr, int i2, int i3) {
        if (i < 55296 || i > 57343) {
            byte[] bArr = this.f11424o;
            int i4 = this.f11425p;
            this.f11425p = i4 + 1;
            bArr[i4] = (byte) ((i >> 12) | 224);
            i4 = this.f11425p;
            this.f11425p = i4 + 1;
            bArr[i4] = (byte) (((i >> 6) & 63) | 128);
            i4 = this.f11425p;
            this.f11425p = i4 + 1;
            bArr[i4] = (byte) ((i & 63) | 128);
            return i2;
        }
        if (i2 >= i3) {
            GeneratorBase.i("Split surrogate on writeRaw() input (last character)");
        }
        m11819a(i, cArr[i2]);
        return i2 + 1;
    }

    private void m11819a(int i, int i2) {
        int c = m11828c(i, i2);
        if (this.f11425p + 4 > this.f11426q) {
            m11844m();
        }
        byte[] bArr = this.f11424o;
        int i3 = this.f11425p;
        this.f11425p = i3 + 1;
        bArr[i3] = (byte) ((c >> 18) | 240);
        i3 = this.f11425p;
        this.f11425p = i3 + 1;
        bArr[i3] = (byte) (((c >> 12) & 63) | 128);
        i3 = this.f11425p;
        this.f11425p = i3 + 1;
        bArr[i3] = (byte) (((c >> 6) & 63) | 128);
        i3 = this.f11425p;
        this.f11425p = i3 + 1;
        bArr[i3] = (byte) ((c & 63) | 128);
    }

    private int m11821b(int i, int i2) {
        byte[] bArr = this.f11424o;
        if (i < 55296 || i > 57343) {
            int i3 = i2 + 1;
            bArr[i2] = (byte) ((i >> 12) | 224);
            int i4 = i3 + 1;
            bArr[i3] = (byte) (((i >> 6) & 63) | 128);
            i3 = i4 + 1;
            bArr[i4] = (byte) ((i & 63) | 128);
            return i3;
        }
        i3 = i2 + 1;
        bArr[i2] = (byte) 92;
        i4 = i3 + 1;
        bArr[i3] = (byte) 117;
        i3 = i4 + 1;
        bArr[i4] = f11419m[(i >> 12) & 15];
        i4 = i3 + 1;
        bArr[i3] = f11419m[(i >> 8) & 15];
        int i5 = i4 + 1;
        bArr[i4] = f11419m[(i >> 4) & 15];
        i3 = i5 + 1;
        bArr[i5] = f11419m[i & 15];
        return i3;
    }

    private int m11828c(int i, int i2) {
        if (i2 < 56320 || i2 > 57343) {
            GeneratorBase.i("Incomplete surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(i2));
        }
        return (65536 + ((i - 55296) << 10)) + (i2 - 56320);
    }

    private void m11842l() {
        if (this.f11425p + 4 >= this.f11426q) {
            m11844m();
        }
        System.arraycopy(f11420v, 0, this.f11424o, this.f11425p, 4);
        this.f11425p += 4;
    }

    private int m11831d(int i, int i2) {
        byte[] bArr = this.f11424o;
        int i3 = i2 + 1;
        bArr[i2] = (byte) 92;
        int i4 = i3 + 1;
        bArr[i3] = (byte) 117;
        int i5;
        if (i > 255) {
            i5 = (i >> 8) & 255;
            int i6 = i4 + 1;
            bArr[i4] = f11419m[i5 >> 4];
            i3 = i6 + 1;
            bArr[i6] = f11419m[i5 & 15];
            i &= 255;
        } else {
            i5 = i4 + 1;
            bArr[i4] = (byte) 48;
            i3 = i5 + 1;
            bArr[i5] = (byte) 48;
        }
        i4 = i3 + 1;
        bArr[i3] = f11419m[i >> 4];
        i3 = i4 + 1;
        bArr[i4] = f11419m[i & 15];
        return i3;
    }

    private void m11844m() {
        int i = this.f11425p;
        if (i > 0) {
            this.f11425p = 0;
            this.f11423n.write(this.f11424o, 0, i);
        }
    }
}

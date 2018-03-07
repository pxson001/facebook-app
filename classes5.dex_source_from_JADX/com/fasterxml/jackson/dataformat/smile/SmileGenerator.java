package com.fasterxml.jackson.dataformat.smile;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.IOContext;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/* compiled from: can_viewer_decline */
public class SmileGenerator extends GeneratorBase {
    protected static final ThreadLocal<SoftReference<SmileBufferRecycler<SharedStringNode>>> f6278v = new ThreadLocal();
    protected final IOContext f6279g;
    protected final OutputStream f6280h;
    protected int f6281i;
    protected final SmileBufferRecycler<SharedStringNode> f6282j;
    protected byte[] f6283k;
    protected int f6284l = 0;
    protected final int f6285m;
    protected char[] f6286n;
    protected final int f6287o;
    protected int f6288p;
    protected SharedStringNode[] f6289q;
    protected int f6290r;
    protected SharedStringNode[] f6291s;
    protected int f6292t;
    protected boolean f6293u;

    /* compiled from: can_viewer_decline */
    public enum Feature {
        WRITE_HEADER(true),
        WRITE_END_MARKER(false),
        ENCODE_BINARY_AS_7BIT(true),
        CHECK_SHARED_NAMES(true),
        CHECK_SHARED_STRING_VALUES(false);
        
        protected final boolean _defaultState;
        protected final int _mask;

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

    /* compiled from: can_viewer_decline */
    public final class SharedStringNode {
        public final String f6275a;
        public final int f6276b;
        public SharedStringNode f6277c;

        public SharedStringNode(String str, int i, SharedStringNode sharedStringNode) {
            this.f6275a = str;
            this.f6276b = i;
            this.f6277c = sharedStringNode;
        }
    }

    public SmileGenerator(IOContext iOContext, int i, int i2, ObjectCodec objectCodec, OutputStream outputStream) {
        super(i, objectCodec);
        this.f6281i = i2;
        this.f6279g = iOContext;
        this.f6282j = m11910m();
        this.f6280h = outputStream;
        this.f6293u = true;
        this.f6283k = iOContext.f();
        this.f6285m = this.f6283k.length;
        this.f6286n = iOContext.h();
        this.f6287o = this.f6286n.length;
        if (this.f6285m < 770) {
            throw new IllegalStateException("Internal encoding buffer length (" + this.f6285m + ") too short, must be at least 770");
        }
        if ((Feature.CHECK_SHARED_NAMES.getMask() & i2) == 0) {
            this.f6289q = null;
            this.f6290r = -1;
        } else {
            this.f6289q = (SharedStringNode[]) this.f6282j.m11864a();
            if (this.f6289q == null) {
                this.f6289q = new SharedStringNode[64];
            }
            this.f6290r = 0;
        }
        if ((Feature.CHECK_SHARED_STRING_VALUES.getMask() & i2) == 0) {
            this.f6291s = null;
            this.f6292t = -1;
            return;
        }
        this.f6291s = (SharedStringNode[]) this.f6282j.m11866b();
        if (this.f6291s == null) {
            this.f6291s = new SharedStringNode[64];
        }
        this.f6292t = 0;
    }

    public final void m11944l() {
        int i = 0;
        if ((this.f6281i & Feature.CHECK_SHARED_NAMES.getMask()) != 0) {
            i = 1;
        }
        if ((this.f6281i & Feature.CHECK_SHARED_STRING_VALUES.getMask()) != 0) {
            i |= 2;
        }
        if ((this.f6281i & Feature.ENCODE_BINARY_AS_7BIT.getMask()) == 0) {
            i |= 4;
        }
        m11887a((byte) 58, (byte) 41, (byte) 10, (byte) i);
    }

    private static SmileBufferRecycler<SharedStringNode> m11910m() {
        SoftReference softReference = (SoftReference) f6278v.get();
        SmileBufferRecycler<SharedStringNode> smileBufferRecycler = softReference == null ? null : (SmileBufferRecycler) softReference.get();
        if (smileBufferRecycler != null) {
            return smileBufferRecycler;
        }
        smileBufferRecycler = new SmileBufferRecycler();
        f6278v.set(new SoftReference(smileBufferRecycler));
        return smileBufferRecycler;
    }

    public Version version() {
        return PackageVersion.VERSION;
    }

    public final JsonGenerator m11932c() {
        return this;
    }

    public final JsonGenerator m11916a(PrettyPrinter prettyPrinter) {
        return this;
    }

    public final void m11922a(String str) {
        if (this.e.a(str) == 4) {
            GeneratorBase.i("Can not write a field name, expecting a value");
        }
        m11907j(str);
    }

    public final void m11929b(SerializableString serializableString) {
        if (this.e.a(serializableString.a()) == 4) {
            GeneratorBase.i("Can not write a field name, expecting a value");
        }
        m11903e(serializableString);
    }

    public final void m11923a(String str, String str2) {
        if (this.e.a(str) == 4) {
            GeneratorBase.i("Can not write a field name, expecting a value");
        }
        m11907j(str);
        b(str2);
    }

    private boolean m11892a(Feature feature) {
        return (this.f6281i & feature.getMask()) != 0;
    }

    public final void m11935d() {
        m11942h("start an array");
        this.e = this.e.j();
        m11884a((byte) -8);
    }

    public final void m11937e() {
        if (!this.e.b()) {
            GeneratorBase.i("Current context not an ARRAY but " + this.e.e());
        }
        m11884a((byte) -7);
        this.e = this.e.c;
    }

    public final void m11939f() {
        m11942h("start an object");
        this.e = this.e.k();
        m11884a((byte) -6);
    }

    public final void m11940g() {
        if (!this.e.d()) {
            GeneratorBase.i("Current context not an object but " + this.e.e());
        }
        this.e = this.e.c;
        m11884a((byte) -5);
    }

    private final void m11907j(String str) {
        byte b = (byte) 52;
        int length = str.length();
        if (length == 0) {
            m11884a((byte) 32);
            return;
        }
        int l;
        if (this.f6290r >= 0) {
            l = m11909l(str);
            if (l >= 0) {
                m11897c(l);
                return;
            }
        }
        if (length > 56) {
            m11893b(str, length);
            return;
        }
        if (this.f6284l + 196 >= this.f6285m) {
            m11913n();
        }
        str.getChars(0, length, this.f6286n, 0);
        l = this.f6284l;
        this.f6284l++;
        int c = m11896c(this.f6286n, 0, length);
        byte[] bArr;
        if (c == length) {
            if (c <= 64) {
                b = (byte) (c + 127);
            } else {
                bArr = this.f6283k;
                c = this.f6284l;
                this.f6284l = c + 1;
                bArr[c] = (byte) -4;
            }
        } else if (c <= 56) {
            b = (byte) (c + 190);
        } else {
            bArr = this.f6283k;
            c = this.f6284l;
            this.f6284l = c + 1;
            bArr[c] = (byte) -4;
        }
        this.f6283k[l] = b;
        if (this.f6290r >= 0) {
            m11911m(str);
        }
    }

    private final void m11893b(String str, int i) {
        m11884a((byte) 52);
        if (i > this.f6287o) {
            m11908k(str);
        } else {
            str.getChars(0, i, this.f6286n, 0);
            int i2 = (i + i) + i;
            if (i2 <= this.f6283k.length) {
                if (i2 + this.f6284l >= this.f6285m) {
                    m11913n();
                }
                m11896c(this.f6286n, 0, i);
            } else {
                m11901d(this.f6286n, 0, i);
            }
        }
        if (this.f6290r >= 0) {
            m11911m(str);
        }
        if (this.f6284l >= this.f6285m) {
            m11913n();
        }
        byte[] bArr = this.f6283k;
        int i3 = this.f6284l;
        this.f6284l = i3 + 1;
        bArr[i3] = (byte) -4;
    }

    private void m11903e(SerializableString serializableString) {
        int b = serializableString.b();
        if (b == 0) {
            m11884a((byte) 32);
            return;
        }
        if (this.f6290r >= 0) {
            int l = m11909l(serializableString.a());
            if (l >= 0) {
                m11897c(l);
                return;
            }
        }
        byte[] d = serializableString.d();
        int length = d.length;
        if (length != b) {
            m11890a(serializableString, d);
            return;
        }
        if (length <= 64) {
            if (this.f6284l + length >= this.f6285m) {
                m11913n();
            }
            byte[] bArr = this.f6283k;
            int i = this.f6284l;
            this.f6284l = i + 1;
            bArr[i] = (byte) (length + 127);
            System.arraycopy(d, 0, this.f6283k, this.f6284l, length);
            this.f6284l += length;
        } else {
            m11894b(d);
        }
        if (this.f6290r >= 0) {
            m11911m(serializableString.a());
        }
    }

    private final void m11894b(byte[] bArr) {
        int length = bArr.length;
        if (this.f6284l >= this.f6285m) {
            m11913n();
        }
        byte[] bArr2 = this.f6283k;
        int i = this.f6284l;
        this.f6284l = i + 1;
        bArr2[i] = (byte) 52;
        if ((this.f6284l + length) + 1 < this.f6285m) {
            System.arraycopy(bArr, 0, this.f6283k, this.f6284l, length);
            this.f6284l = length + this.f6284l;
        } else {
            m11913n();
            if (length < 770) {
                System.arraycopy(bArr, 0, this.f6283k, this.f6284l, length);
                this.f6284l = length + this.f6284l;
            } else {
                if (this.f6284l > 0) {
                    m11913n();
                }
                this.f6280h.write(bArr, 0, length);
            }
        }
        byte[] bArr3 = this.f6283k;
        int i2 = this.f6284l;
        this.f6284l = i2 + 1;
        bArr3[i2] = (byte) -4;
    }

    private void m11890a(SerializableString serializableString, byte[] bArr) {
        int length = bArr.length;
        if (length <= 56) {
            if (this.f6284l + length >= this.f6285m) {
                m11913n();
            }
            byte[] bArr2 = this.f6283k;
            int i = this.f6284l;
            this.f6284l = i + 1;
            bArr2[i] = (byte) (length + 190);
            System.arraycopy(bArr, 0, this.f6283k, this.f6284l, length);
            this.f6284l = length + this.f6284l;
            if (this.f6290r >= 0) {
                m11911m(serializableString.a());
                return;
            }
            return;
        }
        if (this.f6284l >= this.f6285m) {
            m11913n();
        }
        bArr2 = this.f6283k;
        i = this.f6284l;
        this.f6284l = i + 1;
        bArr2[i] = (byte) 52;
        if ((this.f6284l + length) + 1 < this.f6285m) {
            System.arraycopy(bArr, 0, this.f6283k, this.f6284l, length);
            this.f6284l = length + this.f6284l;
        } else {
            m11913n();
            if (length < 770) {
                System.arraycopy(bArr, 0, this.f6283k, this.f6284l, length);
                this.f6284l = length + this.f6284l;
            } else {
                if (this.f6284l > 0) {
                    m11913n();
                }
                this.f6280h.write(bArr, 0, length);
            }
        }
        byte[] bArr3 = this.f6283k;
        int i2 = this.f6284l;
        this.f6284l = i2 + 1;
        bArr3[i2] = (byte) -4;
        if (this.f6290r >= 0) {
            m11911m(serializableString.a());
        }
    }

    private final void m11897c(int i) {
        if (i >= this.f6290r) {
            throw new IllegalArgumentException("Internal error: trying to write shared name with index " + i + "; but have only seen " + this.f6290r + " so far!");
        } else if (i < 64) {
            m11884a((byte) (i + 64));
        } else {
            m11885a((byte) ((i >> 8) + 48), (byte) i);
        }
    }

    public final void m11930b(String str) {
        if (str == null) {
            h();
            return;
        }
        m11942h("write String value");
        int length = str.length();
        if (length == 0) {
            m11884a((byte) 32);
        } else if (length > 65) {
            m11898c(str, length);
        } else {
            int n;
            if (this.f6292t >= 0) {
                n = m11912n(str);
                if (n >= 0) {
                    m11900d(n);
                    return;
                }
            }
            if (this.f6284l + 196 >= this.f6285m) {
                m11913n();
            }
            str.getChars(0, length, this.f6286n, 0);
            n = this.f6284l;
            this.f6284l++;
            int c = m11896c(this.f6286n, 0, length);
            if (c <= 64) {
                if (this.f6292t >= 0) {
                    m11915o(str);
                }
                if (c == length) {
                    this.f6283k[n] = (byte) (c + 63);
                    return;
                } else {
                    this.f6283k[n] = (byte) (c + 126);
                    return;
                }
            }
            this.f6283k[n] = c == length ? (byte) -32 : (byte) -28;
            byte[] bArr = this.f6283k;
            n = this.f6284l;
            this.f6284l = n + 1;
            bArr[n] = (byte) -4;
        }
    }

    private final void m11900d(int i) {
        if (i >= this.f6292t) {
            throw new IllegalArgumentException("Internal error: trying to write shared String value with index " + i + "; but have only seen " + this.f6292t + " so far!");
        } else if (i < 31) {
            m11884a((byte) (i + 1));
        } else {
            m11885a((byte) ((i >> 8) + 236), (byte) i);
        }
    }

    private final void m11898c(String str, int i) {
        if (i > this.f6287o) {
            m11884a((byte) -28);
            m11908k(str);
            m11884a((byte) -4);
            return;
        }
        str.getChars(0, i, this.f6286n, 0);
        int i2 = ((i + i) + i) + 2;
        if (i2 > this.f6283k.length) {
            m11884a((byte) -28);
            m11901d(this.f6286n, 0, i);
            m11884a((byte) -4);
            return;
        }
        if (i2 + this.f6284l >= this.f6285m) {
            m11913n();
        }
        i2 = this.f6284l;
        m11884a((byte) -32);
        if (m11896c(this.f6286n, 0, i) > i) {
            this.f6283k[i2] = (byte) -28;
        }
        byte[] bArr = this.f6283k;
        int i3 = this.f6284l;
        this.f6284l = i3 + 1;
        bArr[i3] = (byte) -4;
    }

    public final void m11927a(char[] cArr, int i, int i2) {
        byte b = (byte) -28;
        if (i2 > 65 || this.f6292t < 0 || i2 <= 0) {
            m11942h("write String value");
            if (i2 == 0) {
                m11884a((byte) 32);
                return;
            } else if (i2 <= 64) {
                if (this.f6284l + 196 >= this.f6285m) {
                    m11913n();
                }
                r1 = this.f6284l;
                this.f6284l++;
                int c = m11896c(cArr, i, i + i2);
                if (c > 64) {
                    byte[] bArr = this.f6283k;
                    int i3 = this.f6284l;
                    this.f6284l = i3 + 1;
                    bArr[i3] = (byte) -4;
                } else if (c == i2) {
                    b = (byte) (c + 63);
                } else {
                    b = (byte) (c + 126);
                }
                this.f6283k[r1] = b;
                return;
            } else {
                r1 = ((i2 + i2) + i2) + 2;
                if (r1 <= this.f6283k.length) {
                    if (r1 + this.f6284l >= this.f6285m) {
                        m11913n();
                    }
                    r1 = this.f6284l;
                    m11884a((byte) -28);
                    if (m11896c(cArr, i, i + i2) == i2) {
                        this.f6283k[r1] = (byte) -32;
                    }
                    byte[] bArr2 = this.f6283k;
                    r1 = this.f6284l;
                    this.f6284l = r1 + 1;
                    bArr2[r1] = (byte) -4;
                    return;
                }
                m11884a((byte) -28);
                m11901d(cArr, i, i + i2);
                m11884a((byte) -4);
                return;
            }
        }
        b(new String(cArr, i, i2));
    }

    public final void m11933c(SerializableString serializableString) {
        m11942h("write String value");
        String a = serializableString.a();
        int length = a.length();
        if (length == 0) {
            m11884a((byte) 32);
            return;
        }
        int n;
        if (length <= 65 && this.f6292t >= 0) {
            n = m11912n(a);
            if (n >= 0) {
                m11900d(n);
                return;
            }
        }
        byte[] d = serializableString.d();
        int length2 = d.length;
        if (length2 <= 64) {
            if ((this.f6284l + length2) + 1 >= this.f6285m) {
                m11913n();
            }
            n = length2 == length ? length2 + 63 : length2 + 126;
            byte[] bArr = this.f6283k;
            int i = this.f6284l;
            this.f6284l = i + 1;
            bArr[i] = (byte) n;
            System.arraycopy(d, 0, this.f6283k, this.f6284l, length2);
            this.f6284l += length2;
            if (this.f6292t >= 0) {
                m11915o(serializableString.a());
                return;
            }
            return;
        }
        m11884a(length2 == length ? (byte) -32 : (byte) -28);
        m11891a(d, 0, d.length);
        m11884a((byte) -4);
    }

    public final void m11934c(String str) {
        throw m11914o();
    }

    public final void m11931b(char[] cArr, int i, int i2) {
        throw m11914o();
    }

    public final void m11917a(char c) {
        throw m11914o();
    }

    public final void m11936d(String str) {
        throw m11914o();
    }

    public final void m11921a(Base64Variant base64Variant, byte[] bArr, int i, int i2) {
        if (bArr == null) {
            h();
            return;
        }
        m11942h("write Binary value");
        if (m11892a(Feature.ENCODE_BINARY_AS_7BIT)) {
            m11884a((byte) -24);
            m11899c(bArr, i, i2);
            return;
        }
        m11884a((byte) -3);
        m11905g(i2);
        m11891a(bArr, i, i2);
    }

    public final void m11926a(boolean z) {
        m11942h("write boolean value");
        if (z) {
            m11884a((byte) 35);
        } else {
            m11884a((byte) 34);
        }
    }

    public final void m11941h() {
        m11942h("write null value");
        m11884a((byte) 33);
    }

    public final void m11928b(int i) {
        m11942h("write number");
        int a = SmileUtil.m12001a(i);
        if (a > 63 || a < 0) {
            byte b = (byte) ((a & 63) + 128);
            a >>>= 6;
            if (a <= 127) {
                m11886a((byte) 36, (byte) a, b);
                return;
            }
            byte b2 = (byte) (a & 127);
            a >>= 7;
            if (a <= 127) {
                m11887a((byte) 36, (byte) a, b2, b);
                return;
            }
            byte b3 = (byte) (a & 127);
            a >>= 7;
            if (a <= 127) {
                m11888a((byte) 36, (byte) a, b3, b2, b);
                return;
            }
            byte b4 = (byte) 36;
            m11889a(b4, (byte) (a >> 7), (byte) (a & 127), b3, b2, b);
        } else if (a <= 31) {
            m11884a((byte) (a + 192));
        } else {
            m11885a((byte) 36, (byte) (a + 128));
        }
    }

    public final void m11920a(long j) {
        if (j > 2147483647L || j < -2147483648L) {
            m11942h("write number");
            long a = SmileUtil.m12002a(j);
            int i = (int) a;
            byte b = (byte) ((i & 63) + 128);
            byte b2 = (byte) ((i >> 6) & 127);
            byte b3 = (byte) ((i >> 13) & 127);
            byte b4 = (byte) ((i >> 20) & 127);
            a >>>= 27;
            byte b5 = (byte) (((int) a) & 127);
            int i2 = (int) (a >> 7);
            if (i2 == 0) {
                m11889a((byte) 37, b5, b4, b3, b2, b);
                return;
            } else if (i2 <= 127) {
                m11885a((byte) 37, (byte) i2);
                m11888a(b5, b4, b3, b2, b);
                return;
            } else {
                byte b6 = (byte) (i2 & 127);
                i2 >>= 7;
                if (i2 <= 127) {
                    m11885a((byte) 37, (byte) i2);
                    m11889a(b6, b5, b4, b3, b2, b);
                    return;
                }
                byte b7 = (byte) (i2 & 127);
                i2 >>= 7;
                if (i2 <= 127) {
                    m11886a((byte) 37, (byte) i2, b7);
                    m11889a(b6, b5, b4, b3, b2, b);
                    return;
                }
                byte b8 = (byte) (i2 & 127);
                i2 >>= 7;
                if (i2 <= 127) {
                    m11887a((byte) 37, (byte) i2, b8, b7);
                    m11889a(b6, b5, b4, b3, b2, b);
                    return;
                }
                m11888a((byte) 37, (byte) (i2 >> 7), (byte) (i2 & 127), b8, b7);
                m11889a(b6, b5, b4, b3, b2, b);
                return;
            }
        }
        b((int) j);
    }

    public final void m11925a(BigInteger bigInteger) {
        if (bigInteger == null) {
            h();
            return;
        }
        m11942h("write number");
        m11884a((byte) 38);
        byte[] toByteArray = bigInteger.toByteArray();
        m11899c(toByteArray, 0, toByteArray.length);
    }

    public final void m11918a(double d) {
        m11904f(11);
        m11942h("write number");
        long doubleToRawLongBits = Double.doubleToRawLongBits(d);
        byte[] bArr = this.f6283k;
        int i = this.f6284l;
        this.f6284l = i + 1;
        bArr[i] = (byte) 41;
        int i2 = (int) (doubleToRawLongBits >>> 35);
        this.f6283k[this.f6284l + 4] = (byte) (i2 & 127);
        i2 >>= 7;
        this.f6283k[this.f6284l + 3] = (byte) (i2 & 127);
        i2 >>= 7;
        this.f6283k[this.f6284l + 2] = (byte) (i2 & 127);
        i2 >>= 7;
        this.f6283k[this.f6284l + 1] = (byte) (i2 & 127);
        this.f6283k[this.f6284l] = (byte) (i2 >> 7);
        this.f6284l += 5;
        i2 = (int) (doubleToRawLongBits >> 28);
        byte[] bArr2 = this.f6283k;
        int i3 = this.f6284l;
        this.f6284l = i3 + 1;
        bArr2[i3] = (byte) (i2 & 127);
        int i4 = (int) doubleToRawLongBits;
        this.f6283k[this.f6284l + 3] = (byte) (i4 & 127);
        i4 >>= 7;
        this.f6283k[this.f6284l + 2] = (byte) (i4 & 127);
        i4 >>= 7;
        this.f6283k[this.f6284l + 1] = (byte) (i4 & 127);
        this.f6283k[this.f6284l] = (byte) ((i4 >> 7) & 127);
        this.f6284l += 4;
    }

    public final void m11919a(float f) {
        m11904f(6);
        m11942h("write number");
        int floatToRawIntBits = Float.floatToRawIntBits(f);
        byte[] bArr = this.f6283k;
        int i = this.f6284l;
        this.f6284l = i + 1;
        bArr[i] = (byte) 40;
        this.f6283k[this.f6284l + 4] = (byte) (floatToRawIntBits & 127);
        floatToRawIntBits >>= 7;
        this.f6283k[this.f6284l + 3] = (byte) (floatToRawIntBits & 127);
        floatToRawIntBits >>= 7;
        this.f6283k[this.f6284l + 2] = (byte) (floatToRawIntBits & 127);
        floatToRawIntBits >>= 7;
        this.f6283k[this.f6284l + 1] = (byte) (floatToRawIntBits & 127);
        this.f6283k[this.f6284l] = (byte) ((floatToRawIntBits >> 7) & 127);
        this.f6284l += 5;
    }

    public final void m11924a(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            h();
            return;
        }
        m11942h("write number");
        m11884a((byte) 42);
        m11906h(bigDecimal.scale());
        byte[] toByteArray = bigDecimal.unscaledValue().toByteArray();
        m11899c(toByteArray, 0, toByteArray.length);
    }

    public final void m11938e(String str) {
        throw m11914o();
    }

    protected final void m11942h(String str) {
        if (this.e.m() == 5) {
            GeneratorBase.i("Can not " + str + ", expecting field name");
        }
    }

    public final void flush() {
        m11913n();
        if (a(com.fasterxml.jackson.core.JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
            this.f6280h.flush();
        }
    }

    public void close() {
        if (this.f6283k != null && a(com.fasterxml.jackson.core.JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)) {
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
        boolean z = this.f;
        super.close();
        if (!z && m11892a(Feature.WRITE_END_MARKER)) {
            m11884a((byte) -1);
        }
        m11913n();
        if (this.f6279g.c || a(com.fasterxml.jackson.core.JsonGenerator.Feature.AUTO_CLOSE_TARGET)) {
            this.f6280h.close();
        } else {
            this.f6280h.flush();
        }
        m11943j();
    }

    private final int m11896c(char[] cArr, int i, int i2) {
        int i3 = this.f6284l;
        byte[] bArr = this.f6283k;
        while (true) {
            char c = cArr[i];
            if (c > '') {
                return m11883a(cArr, i, i2, i3);
            }
            int i4 = i3 + 1;
            bArr[i3] = (byte) c;
            i++;
            if (i >= i2) {
                i3 = i4 - this.f6284l;
                this.f6284l = i4;
                return i3;
            }
            i3 = i4;
        }
    }

    private final int m11883a(char[] cArr, int i, int i2, int i3) {
        int i4;
        byte[] bArr = this.f6283k;
        while (i < i2) {
            int i5 = i + 1;
            int i6 = cArr[i];
            if (i6 <= '') {
                i4 = i3 + 1;
                bArr[i3] = (byte) i6;
                i3 = i4;
                i = i5;
            } else if (i6 < 'ࠀ') {
                i4 = i3 + 1;
                bArr[i3] = (byte) ((i6 >> 6) | 192);
                i3 = i4 + 1;
                bArr[i4] = (byte) ((i6 & 63) | 128);
                i = i5;
            } else if (i6 < '?' || i6 > '?') {
                i4 = i3 + 1;
                bArr[i3] = (byte) ((i6 >> 12) | 224);
                int i7 = i4 + 1;
                bArr[i4] = (byte) (((i6 >> 6) & 63) | 128);
                i3 = i7 + 1;
                bArr[i7] = (byte) ((i6 & 63) | 128);
                i = i5;
            } else {
                if (i6 > '?') {
                    m11902e(i6);
                }
                if (i5 >= i2) {
                    m11902e(i6);
                }
                i = i5 + 1;
                i4 = m11882a(i6, cArr[i5]);
                if (i4 > 1114111) {
                    m11902e(i4);
                }
                i5 = i3 + 1;
                bArr[i3] = (byte) ((i4 >> 18) | 240);
                i6 = i5 + 1;
                bArr[i5] = (byte) (((i4 >> 12) & 63) | 128);
                i5 = i6 + 1;
                bArr[i6] = (byte) (((i4 >> 6) & 63) | 128);
                i3 = i5 + 1;
                bArr[i5] = (byte) ((i4 & 63) | 128);
            }
        }
        i4 = i3 - this.f6284l;
        this.f6284l = i3;
        return i4;
    }

    private void m11908k(String str) {
        int length = str.length();
        int i = 0;
        int i2 = this.f6285m - 4;
        while (i < length) {
            int i3;
            if (this.f6284l >= i2) {
                m11913n();
            }
            int i4 = i + 1;
            int charAt = str.charAt(i);
            if (charAt <= 127) {
                byte[] bArr = this.f6283k;
                i3 = this.f6284l;
                this.f6284l = i3 + 1;
                bArr[i3] = (byte) charAt;
                i = length - i4;
                charAt = i2 - this.f6284l;
                if (i <= charAt) {
                    charAt = i;
                }
                i3 = charAt + i4;
                while (i4 < i3) {
                    i = i4 + 1;
                    charAt = str.charAt(i4);
                    if (charAt <= 127) {
                        byte[] bArr2 = this.f6283k;
                        int i5 = this.f6284l;
                        this.f6284l = i5 + 1;
                        bArr2[i5] = (byte) charAt;
                        i4 = i;
                    }
                }
                i = i4;
            } else {
                i = i4;
            }
            if (charAt < 2048) {
                bArr2 = this.f6283k;
                i3 = this.f6284l;
                this.f6284l = i3 + 1;
                bArr2[i3] = (byte) ((charAt >> 6) | 192);
                bArr2 = this.f6283k;
                i3 = this.f6284l;
                this.f6284l = i3 + 1;
                bArr2[i3] = (byte) ((charAt & 63) | 128);
            } else if (charAt < 55296 || charAt > 57343) {
                bArr2 = this.f6283k;
                i3 = this.f6284l;
                this.f6284l = i3 + 1;
                bArr2[i3] = (byte) ((charAt >> 12) | 224);
                bArr2 = this.f6283k;
                i3 = this.f6284l;
                this.f6284l = i3 + 1;
                bArr2[i3] = (byte) (((charAt >> 6) & 63) | 128);
                bArr2 = this.f6283k;
                i3 = this.f6284l;
                this.f6284l = i3 + 1;
                bArr2[i3] = (byte) ((charAt & 63) | 128);
            } else {
                if (charAt > 56319) {
                    m11902e(charAt);
                }
                if (i >= length) {
                    m11902e(charAt);
                }
                i4 = i + 1;
                charAt = m11882a(charAt, str.charAt(i));
                if (charAt > 1114111) {
                    m11902e(charAt);
                }
                bArr = this.f6283k;
                i3 = this.f6284l;
                this.f6284l = i3 + 1;
                bArr[i3] = (byte) ((charAt >> 18) | 240);
                bArr = this.f6283k;
                i3 = this.f6284l;
                this.f6284l = i3 + 1;
                bArr[i3] = (byte) (((charAt >> 12) & 63) | 128);
                bArr = this.f6283k;
                i3 = this.f6284l;
                this.f6284l = i3 + 1;
                bArr[i3] = (byte) (((charAt >> 6) & 63) | 128);
                bArr = this.f6283k;
                i3 = this.f6284l;
                this.f6284l = i3 + 1;
                bArr[i3] = (byte) ((charAt & 63) | 128);
                i = i4;
            }
        }
    }

    private void m11901d(char[] cArr, int i, int i2) {
        int i3 = this.f6285m - 4;
        int i4 = i;
        while (i4 < i2) {
            int i5;
            if (this.f6284l >= i3) {
                m11913n();
            }
            int i6 = i4 + 1;
            int i7 = cArr[i4];
            if (i7 <= 127) {
                byte[] bArr = this.f6283k;
                i5 = this.f6284l;
                this.f6284l = i5 + 1;
                bArr[i5] = (byte) i7;
                i4 = i2 - i6;
                i7 = i3 - this.f6284l;
                if (i4 <= i7) {
                    i7 = i4;
                }
                i5 = i7 + i6;
                while (i6 < i5) {
                    i4 = i6 + 1;
                    i7 = cArr[i6];
                    if (i7 <= 127) {
                        byte[] bArr2 = this.f6283k;
                        int i8 = this.f6284l;
                        this.f6284l = i8 + 1;
                        bArr2[i8] = (byte) i7;
                        i6 = i4;
                    }
                }
                i4 = i6;
            } else {
                i4 = i6;
            }
            if (i7 < 2048) {
                bArr2 = this.f6283k;
                i5 = this.f6284l;
                this.f6284l = i5 + 1;
                bArr2[i5] = (byte) ((i7 >> 6) | 192);
                bArr2 = this.f6283k;
                i5 = this.f6284l;
                this.f6284l = i5 + 1;
                bArr2[i5] = (byte) ((i7 & 63) | 128);
            } else if (i7 < 55296 || i7 > 57343) {
                bArr2 = this.f6283k;
                i5 = this.f6284l;
                this.f6284l = i5 + 1;
                bArr2[i5] = (byte) ((i7 >> 12) | 224);
                bArr2 = this.f6283k;
                i5 = this.f6284l;
                this.f6284l = i5 + 1;
                bArr2[i5] = (byte) (((i7 >> 6) & 63) | 128);
                bArr2 = this.f6283k;
                i5 = this.f6284l;
                this.f6284l = i5 + 1;
                bArr2[i5] = (byte) ((i7 & 63) | 128);
            } else {
                if (i7 > 56319) {
                    m11902e(i7);
                }
                if (i4 >= i2) {
                    m11902e(i7);
                }
                i = i4 + 1;
                i7 = m11882a(i7, cArr[i4]);
                if (i7 > 1114111) {
                    m11902e(i7);
                }
                bArr = this.f6283k;
                i6 = this.f6284l;
                this.f6284l = i6 + 1;
                bArr[i6] = (byte) ((i7 >> 18) | 240);
                bArr = this.f6283k;
                i6 = this.f6284l;
                this.f6284l = i6 + 1;
                bArr[i6] = (byte) (((i7 >> 12) & 63) | 128);
                bArr = this.f6283k;
                i6 = this.f6284l;
                this.f6284l = i6 + 1;
                bArr[i6] = (byte) (((i7 >> 6) & 63) | 128);
                bArr = this.f6283k;
                i6 = this.f6284l;
                this.f6284l = i6 + 1;
                bArr[i6] = (byte) ((i7 & 63) | 128);
                i4 = i;
            }
        }
    }

    private static int m11882a(int i, int i2) {
        if (i2 >= 56320 && i2 <= 57343) {
            return (65536 + ((i - 55296) << 10)) + (i2 - 56320);
        }
        throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(i2) + "; illegal combination");
    }

    private static void m11902e(int i) {
        if (i > 1114111) {
            throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(i) + ") to output; max is 0x10FFFF as per RFC 4627");
        } else if (i < 55296) {
            throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(i) + ") to output");
        } else if (i <= 56319) {
            throw new IllegalArgumentException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(i) + ")");
        } else {
            throw new IllegalArgumentException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(i) + ")");
        }
    }

    private final void m11904f(int i) {
        if (this.f6284l + i >= this.f6285m) {
            m11913n();
        }
    }

    private final void m11884a(byte b) {
        if (this.f6284l >= this.f6285m) {
            m11913n();
        }
        byte[] bArr = this.f6283k;
        int i = this.f6284l;
        this.f6284l = i + 1;
        bArr[i] = b;
    }

    private final void m11885a(byte b, byte b2) {
        if (this.f6284l + 1 >= this.f6285m) {
            m11913n();
        }
        byte[] bArr = this.f6283k;
        int i = this.f6284l;
        this.f6284l = i + 1;
        bArr[i] = b;
        bArr = this.f6283k;
        i = this.f6284l;
        this.f6284l = i + 1;
        bArr[i] = b2;
    }

    private final void m11886a(byte b, byte b2, byte b3) {
        if (this.f6284l + 2 >= this.f6285m) {
            m11913n();
        }
        byte[] bArr = this.f6283k;
        int i = this.f6284l;
        this.f6284l = i + 1;
        bArr[i] = b;
        bArr = this.f6283k;
        i = this.f6284l;
        this.f6284l = i + 1;
        bArr[i] = b2;
        bArr = this.f6283k;
        i = this.f6284l;
        this.f6284l = i + 1;
        bArr[i] = b3;
    }

    private final void m11887a(byte b, byte b2, byte b3, byte b4) {
        if (this.f6284l + 3 >= this.f6285m) {
            m11913n();
        }
        byte[] bArr = this.f6283k;
        int i = this.f6284l;
        this.f6284l = i + 1;
        bArr[i] = b;
        bArr = this.f6283k;
        i = this.f6284l;
        this.f6284l = i + 1;
        bArr[i] = b2;
        bArr = this.f6283k;
        i = this.f6284l;
        this.f6284l = i + 1;
        bArr[i] = b3;
        bArr = this.f6283k;
        i = this.f6284l;
        this.f6284l = i + 1;
        bArr[i] = b4;
    }

    private final void m11888a(byte b, byte b2, byte b3, byte b4, byte b5) {
        if (this.f6284l + 4 >= this.f6285m) {
            m11913n();
        }
        byte[] bArr = this.f6283k;
        int i = this.f6284l;
        this.f6284l = i + 1;
        bArr[i] = b;
        bArr = this.f6283k;
        i = this.f6284l;
        this.f6284l = i + 1;
        bArr[i] = b2;
        bArr = this.f6283k;
        i = this.f6284l;
        this.f6284l = i + 1;
        bArr[i] = b3;
        bArr = this.f6283k;
        i = this.f6284l;
        this.f6284l = i + 1;
        bArr[i] = b4;
        bArr = this.f6283k;
        i = this.f6284l;
        this.f6284l = i + 1;
        bArr[i] = b5;
    }

    private final void m11889a(byte b, byte b2, byte b3, byte b4, byte b5, byte b6) {
        if (this.f6284l + 5 >= this.f6285m) {
            m11913n();
        }
        byte[] bArr = this.f6283k;
        int i = this.f6284l;
        this.f6284l = i + 1;
        bArr[i] = b;
        bArr = this.f6283k;
        i = this.f6284l;
        this.f6284l = i + 1;
        bArr[i] = b2;
        bArr = this.f6283k;
        i = this.f6284l;
        this.f6284l = i + 1;
        bArr[i] = b3;
        bArr = this.f6283k;
        i = this.f6284l;
        this.f6284l = i + 1;
        bArr[i] = b4;
        bArr = this.f6283k;
        i = this.f6284l;
        this.f6284l = i + 1;
        bArr[i] = b5;
        bArr = this.f6283k;
        i = this.f6284l;
        this.f6284l = i + 1;
        bArr[i] = b6;
    }

    private final void m11891a(byte[] bArr, int i, int i2) {
        if (i2 != 0) {
            if (this.f6284l + i2 >= this.f6285m) {
                m11895b(bArr, i, i2);
                return;
            }
            System.arraycopy(bArr, i, this.f6283k, this.f6284l, i2);
            this.f6284l += i2;
        }
    }

    private final void m11895b(byte[] bArr, int i, int i2) {
        if (this.f6284l >= this.f6285m) {
            m11913n();
        }
        while (true) {
            int min = Math.min(i2, this.f6285m - this.f6284l);
            System.arraycopy(bArr, i, this.f6283k, this.f6284l, min);
            this.f6284l += min;
            i2 -= min;
            if (i2 != 0) {
                i += min;
                m11913n();
            } else {
                return;
            }
        }
    }

    private void m11905g(int i) {
        m11904f(5);
        byte b = (byte) ((i & 63) + 128);
        int i2 = i >> 6;
        if (i2 <= 127) {
            if (i2 > 0) {
                byte[] bArr = this.f6283k;
                int i3 = this.f6284l;
                this.f6284l = i3 + 1;
                bArr[i3] = (byte) i2;
            }
            byte[] bArr2 = this.f6283k;
            int i4 = this.f6284l;
            this.f6284l = i4 + 1;
            bArr2[i4] = b;
            return;
        }
        byte b2 = (byte) (i2 & 127);
        i2 >>= 7;
        if (i2 <= 127) {
            byte[] bArr3 = this.f6283k;
            int i5 = this.f6284l;
            this.f6284l = i5 + 1;
            bArr3[i5] = (byte) i2;
            bArr2 = this.f6283k;
            i3 = this.f6284l;
            this.f6284l = i3 + 1;
            bArr2[i3] = b2;
            bArr2 = this.f6283k;
            i4 = this.f6284l;
            this.f6284l = i4 + 1;
            bArr2[i4] = b;
            return;
        }
        byte b3 = (byte) (i2 & 127);
        i2 >>= 7;
        if (i2 <= 127) {
            byte[] bArr4 = this.f6283k;
            int i6 = this.f6284l;
            this.f6284l = i6 + 1;
            bArr4[i6] = (byte) i2;
            bArr2 = this.f6283k;
            i5 = this.f6284l;
            this.f6284l = i5 + 1;
            bArr2[i5] = b3;
            bArr2 = this.f6283k;
            i3 = this.f6284l;
            this.f6284l = i3 + 1;
            bArr2[i3] = b2;
            bArr2 = this.f6283k;
            i4 = this.f6284l;
            this.f6284l = i4 + 1;
            bArr2[i4] = b;
            return;
        }
        byte b4 = (byte) (i2 & 127);
        byte[] bArr5 = this.f6283k;
        int i7 = this.f6284l;
        this.f6284l = i7 + 1;
        bArr5[i7] = (byte) (i2 >> 7);
        bArr2 = this.f6283k;
        i6 = this.f6284l;
        this.f6284l = i6 + 1;
        bArr2[i6] = b4;
        bArr2 = this.f6283k;
        i5 = this.f6284l;
        this.f6284l = i5 + 1;
        bArr2[i5] = b3;
        bArr2 = this.f6283k;
        i3 = this.f6284l;
        this.f6284l = i3 + 1;
        bArr2[i3] = b2;
        bArr2 = this.f6283k;
        i4 = this.f6284l;
        this.f6284l = i4 + 1;
        bArr2[i4] = b;
    }

    private void m11906h(int i) {
        m11905g(SmileUtil.m12001a(i));
    }

    private void m11899c(byte[] bArr, int i, int i2) {
        m11905g(i2);
        while (i2 >= 7) {
            if (this.f6284l + 8 >= this.f6285m) {
                m11913n();
            }
            int i3 = i + 1;
            byte b = bArr[i];
            byte[] bArr2 = this.f6283k;
            int i4 = this.f6284l;
            this.f6284l = i4 + 1;
            bArr2[i4] = (byte) ((b >> 1) & 127);
            int i5 = i3 + 1;
            i3 = (bArr[i3] & 255) | (b << 8);
            byte[] bArr3 = this.f6283k;
            i4 = this.f6284l;
            this.f6284l = i4 + 1;
            bArr3[i4] = (byte) ((i3 >> 2) & 127);
            int i6 = i5 + 1;
            i3 = (i3 << 8) | (bArr[i5] & 255);
            bArr2 = this.f6283k;
            i4 = this.f6284l;
            this.f6284l = i4 + 1;
            bArr2[i4] = (byte) ((i3 >> 3) & 127);
            i5 = i6 + 1;
            i3 = (i3 << 8) | (bArr[i6] & 255);
            bArr3 = this.f6283k;
            i4 = this.f6284l;
            this.f6284l = i4 + 1;
            bArr3[i4] = (byte) ((i3 >> 4) & 127);
            i6 = i5 + 1;
            i3 = (i3 << 8) | (bArr[i5] & 255);
            bArr2 = this.f6283k;
            i4 = this.f6284l;
            this.f6284l = i4 + 1;
            bArr2[i4] = (byte) ((i3 >> 5) & 127);
            i5 = i6 + 1;
            i3 = (i3 << 8) | (bArr[i6] & 255);
            bArr3 = this.f6283k;
            i4 = this.f6284l;
            this.f6284l = i4 + 1;
            bArr3[i4] = (byte) ((i3 >> 6) & 127);
            i = i5 + 1;
            i3 = (i3 << 8) | (bArr[i5] & 255);
            bArr3 = this.f6283k;
            i5 = this.f6284l;
            this.f6284l = i5 + 1;
            bArr3[i5] = (byte) ((i3 >> 7) & 127);
            bArr3 = this.f6283k;
            i5 = this.f6284l;
            this.f6284l = i5 + 1;
            bArr3[i5] = (byte) (i3 & 127);
            i2 -= 7;
        }
        if (i2 > 0) {
            if (this.f6284l + 7 >= this.f6285m) {
                m11913n();
            }
            i3 = i + 1;
            b = bArr[i];
            bArr2 = this.f6283k;
            i4 = this.f6284l;
            this.f6284l = i4 + 1;
            bArr2[i4] = (byte) ((b >> 1) & 127);
            if (i2 > 1) {
                i5 = i3 + 1;
                i3 = (bArr[i3] & 255) | ((b & 1) << 8);
                bArr3 = this.f6283k;
                i4 = this.f6284l;
                this.f6284l = i4 + 1;
                bArr3[i4] = (byte) ((i3 >> 2) & 127);
                if (i2 > 2) {
                    i6 = i5 + 1;
                    i3 = ((i3 & 3) << 8) | (bArr[i5] & 255);
                    bArr2 = this.f6283k;
                    i4 = this.f6284l;
                    this.f6284l = i4 + 1;
                    bArr2[i4] = (byte) ((i3 >> 3) & 127);
                    if (i2 > 3) {
                        i5 = i6 + 1;
                        i3 = ((i3 & 7) << 8) | (bArr[i6] & 255);
                        bArr3 = this.f6283k;
                        i4 = this.f6284l;
                        this.f6284l = i4 + 1;
                        bArr3[i4] = (byte) ((i3 >> 4) & 127);
                        if (i2 > 4) {
                            i6 = i5 + 1;
                            i3 = ((i3 & 15) << 8) | (bArr[i5] & 255);
                            bArr2 = this.f6283k;
                            i4 = this.f6284l;
                            this.f6284l = i4 + 1;
                            bArr2[i4] = (byte) ((i3 >> 5) & 127);
                            if (i2 > 5) {
                                i3 = ((i3 & 31) << 8) | (bArr[i6] & 255);
                                bArr3 = this.f6283k;
                                i5 = this.f6284l;
                                this.f6284l = i5 + 1;
                                bArr3[i5] = (byte) ((i3 >> 6) & 127);
                                bArr3 = this.f6283k;
                                i5 = this.f6284l;
                                this.f6284l = i5 + 1;
                                bArr3[i5] = (byte) (i3 & 63);
                                return;
                            }
                            bArr3 = this.f6283k;
                            i5 = this.f6284l;
                            this.f6284l = i5 + 1;
                            bArr3[i5] = (byte) (i3 & 31);
                            return;
                        }
                        bArr3 = this.f6283k;
                        i5 = this.f6284l;
                        this.f6284l = i5 + 1;
                        bArr3[i5] = (byte) (i3 & 15);
                        return;
                    }
                    bArr3 = this.f6283k;
                    i5 = this.f6284l;
                    this.f6284l = i5 + 1;
                    bArr3[i5] = (byte) (i3 & 7);
                    return;
                }
                bArr3 = this.f6283k;
                i5 = this.f6284l;
                this.f6284l = i5 + 1;
                bArr3[i5] = (byte) (i3 & 3);
                return;
            }
            byte[] bArr4 = this.f6283k;
            i5 = this.f6284l;
            this.f6284l = i5 + 1;
            bArr4[i5] = (byte) (b & 1);
        }
    }

    protected final void m11943j() {
        byte[] bArr = this.f6283k;
        if (bArr != null && this.f6293u) {
            this.f6283k = null;
            this.f6279g.b(bArr);
        }
        char[] cArr = this.f6286n;
        if (cArr != null) {
            this.f6286n = null;
            this.f6279g.b(cArr);
        }
        SharedStringNode[] sharedStringNodeArr = this.f6289q;
        if (sharedStringNodeArr != null && sharedStringNodeArr.length == 64) {
            this.f6289q = null;
            if (this.f6290r > 0) {
                Arrays.fill(sharedStringNodeArr, null);
            }
            this.f6282j.f6270a = sharedStringNodeArr;
        }
        sharedStringNodeArr = this.f6291s;
        if (sharedStringNodeArr != null && sharedStringNodeArr.length == 64) {
            this.f6291s = null;
            if (this.f6292t > 0) {
                Arrays.fill(sharedStringNodeArr, null);
            }
            this.f6282j.f6271b = sharedStringNodeArr;
        }
    }

    private void m11913n() {
        if (this.f6284l > 0) {
            this.f6288p += this.f6284l;
            this.f6280h.write(this.f6283k, 0, this.f6284l);
            this.f6284l = 0;
        }
    }

    private final int m11909l(String str) {
        int hashCode = str.hashCode();
        SharedStringNode sharedStringNode = this.f6289q[(this.f6289q.length - 1) & hashCode];
        if (sharedStringNode == null) {
            return -1;
        }
        if (sharedStringNode.f6275a == str) {
            return sharedStringNode.f6276b;
        }
        SharedStringNode sharedStringNode2 = sharedStringNode;
        do {
            sharedStringNode2 = sharedStringNode2.f6277c;
            if (sharedStringNode2 == null) {
                do {
                    String str2 = sharedStringNode.f6275a;
                    if (str2.hashCode() == hashCode && str2.equals(str)) {
                        return sharedStringNode.f6276b;
                    }
                    sharedStringNode = sharedStringNode.f6277c;
                } while (sharedStringNode != null);
                return -1;
            }
        } while (sharedStringNode2.f6275a != str);
        return sharedStringNode2.f6276b;
    }

    private final void m11911m(String str) {
        if (this.f6290r == this.f6289q.length) {
            if (this.f6290r == 1024) {
                Arrays.fill(this.f6289q, null);
                this.f6290r = 0;
            } else {
                SharedStringNode[] sharedStringNodeArr = this.f6289q;
                this.f6289q = new SharedStringNode[1024];
                for (SharedStringNode sharedStringNode : sharedStringNodeArr) {
                    SharedStringNode sharedStringNode2;
                    while (sharedStringNode2 != null) {
                        int hashCode = sharedStringNode2.f6275a.hashCode() & 1023;
                        SharedStringNode sharedStringNode3 = sharedStringNode2.f6277c;
                        sharedStringNode2.f6277c = this.f6289q[hashCode];
                        this.f6289q[hashCode] = sharedStringNode2;
                        sharedStringNode2 = sharedStringNode3;
                    }
                }
            }
        }
        int hashCode2 = str.hashCode() & (this.f6289q.length - 1);
        this.f6289q[hashCode2] = new SharedStringNode(str, this.f6290r, this.f6289q[hashCode2]);
        this.f6290r++;
    }

    private final int m11912n(String str) {
        int hashCode = str.hashCode();
        SharedStringNode sharedStringNode = this.f6291s[(this.f6291s.length - 1) & hashCode];
        if (sharedStringNode != null) {
            SharedStringNode sharedStringNode2 = sharedStringNode;
            while (sharedStringNode2.f6275a != str) {
                sharedStringNode2 = sharedStringNode2.f6277c;
                if (sharedStringNode2 == null) {
                    do {
                        String str2 = sharedStringNode.f6275a;
                        if (str2.hashCode() == hashCode && str2.equals(str)) {
                            return sharedStringNode.f6276b;
                        }
                        sharedStringNode = sharedStringNode.f6277c;
                    } while (sharedStringNode != null);
                }
            }
            return sharedStringNode2.f6276b;
        }
        return -1;
    }

    private final void m11915o(String str) {
        if (this.f6292t == this.f6291s.length) {
            if (this.f6292t == 1024) {
                Arrays.fill(this.f6291s, null);
                this.f6292t = 0;
            } else {
                SharedStringNode[] sharedStringNodeArr = this.f6291s;
                this.f6291s = new SharedStringNode[1024];
                for (SharedStringNode sharedStringNode : sharedStringNodeArr) {
                    SharedStringNode sharedStringNode2;
                    while (sharedStringNode2 != null) {
                        int hashCode = sharedStringNode2.f6275a.hashCode() & 1023;
                        SharedStringNode sharedStringNode3 = sharedStringNode2.f6277c;
                        sharedStringNode2.f6277c = this.f6291s[hashCode];
                        this.f6291s[hashCode] = sharedStringNode2;
                        sharedStringNode2 = sharedStringNode3;
                    }
                }
            }
        }
        int hashCode2 = str.hashCode() & (this.f6291s.length - 1);
        this.f6291s[hashCode2] = new SharedStringNode(str, this.f6292t, this.f6291s[hashCode2]);
        this.f6292t++;
    }

    private static UnsupportedOperationException m11914o() {
        return new UnsupportedOperationException();
    }
}

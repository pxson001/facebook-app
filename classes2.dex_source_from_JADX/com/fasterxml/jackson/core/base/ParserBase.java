package com.fasterxml.jackson.core.base;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.json.JsonReadContext;
import com.fasterxml.jackson.core.json.PackageVersion;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.fasterxml.jackson.core.util.VersionUtil;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: pymi_imp */
public abstract class ParserBase extends ParserMinimalBase {
    static final BigInteger f8579s = BigInteger.valueOf(-2147483648L);
    static final BigInteger f8580t = BigInteger.valueOf(2147483647L);
    static final BigInteger f8581u = BigInteger.valueOf(Long.MIN_VALUE);
    static final BigInteger f8582v = BigInteger.valueOf(Long.MAX_VALUE);
    static final BigDecimal f8583w = new BigDecimal(f8581u);
    static final BigDecimal f8584x = new BigDecimal(f8582v);
    static final BigDecimal f8585y = new BigDecimal(f8579s);
    static final BigDecimal f8586z = new BigDecimal(f8580t);
    protected int f8587A = 0;
    protected int f8588B;
    protected long f8589C;
    protected double f8590D;
    protected BigInteger f8591E;
    protected BigDecimal f8592F;
    protected boolean f8593G;
    protected int f8594H;
    protected int f8595I;
    protected int f8596J;
    protected final IOContext f8597b;
    protected boolean f8598c;
    protected int f8599d = 0;
    protected int f8600e = 0;
    protected long f8601f = 0;
    protected int f8602g = 1;
    protected int f8603h = 0;
    public long f8604i = 0;
    public int f8605j = 1;
    protected int f8606k = 0;
    protected JsonReadContext f8607l;
    protected JsonToken f8608m;
    protected final TextBuffer f8609n;
    protected char[] f8610o = null;
    protected boolean f8611p = false;
    protected ByteArrayBuilder f8612q = null;
    protected byte[] f8613r;

    protected abstract boolean mo1754L();

    protected abstract void mo1755M();

    protected abstract void mo1756N();

    protected ParserBase(IOContext iOContext, int i) {
        this.a = i;
        this.f8597b = iOContext;
        this.f8609n = iOContext.m11846d();
        this.f8607l = JsonReadContext.m13323i();
    }

    public Version version() {
        return PackageVersion.VERSION;
    }

    public final String mo1778i() {
        if (this.f8614K == JsonToken.START_OBJECT || this.f8614K == JsonToken.START_ARRAY) {
            return this.f8607l.f8629c.mo1660h();
        }
        return this.f8607l.mo1660h();
    }

    public void close() {
        if (!this.f8598c) {
            this.f8598c = true;
            try {
                mo1756N();
            } finally {
                mo1757O();
            }
        }
    }

    public final JsonStreamContext mo1779j() {
        return this.f8607l;
    }

    public JsonLocation mo1780k() {
        return new JsonLocation(this.f8597b.f7309a, this.f8604i, this.f8605j, m13178Y());
    }

    public JsonLocation mo1781l() {
        return new JsonLocation(this.f8597b.f7309a, (this.f8601f + ((long) this.f8599d)) - 1, this.f8602g, (this.f8599d - this.f8603h) + 1);
    }

    public boolean mo1782s() {
        if (this.f8614K == JsonToken.VALUE_STRING) {
            return true;
        }
        if (this.f8614K == JsonToken.FIELD_NAME) {
            return this.f8611p;
        }
        return false;
    }

    public Object mo1776D() {
        return null;
    }

    private long m13176W() {
        return this.f8604i;
    }

    private int m13177X() {
        return this.f8605j;
    }

    private int m13178Y() {
        int i = this.f8606k;
        return i < 0 ? i : i + 1;
    }

    protected final void m13188K() {
        if (!mo1754L()) {
            m13220S();
        }
    }

    protected void mo1757O() {
        this.f8609n.m13299a();
        char[] cArr = this.f8610o;
        if (cArr != null) {
            this.f8610o = null;
            this.f8597b.m11844c(cArr);
        }
    }

    protected final void mo1777P() {
        if (!this.f8607l.m11959c()) {
            m13235d(": expected close marker for " + this.f8607l.m11961e() + " (from " + this.f8607l.m13324a(this.f8597b.f7309a) + ")");
        }
    }

    protected final void m13201a(int i, char c) {
        m13236e("Unexpected close marker '" + ((char) i) + "': expected '" + c + "' (for " + this.f8607l.m11961e() + " starting at " + (this.f8607l.m13324a(this.f8597b.f7309a)) + ")");
    }

    public final ByteArrayBuilder m13194Q() {
        if (this.f8612q == null) {
            this.f8612q = new ByteArrayBuilder();
        } else {
            this.f8612q.a();
        }
        return this.f8612q;
    }

    protected final JsonToken m13200a(boolean z, int i, int i2, int i3) {
        if (i2 > 0 || i3 > 0) {
            return m13203b(z, i, i2, i3);
        }
        return m13199a(z, i);
    }

    protected final JsonToken m13199a(boolean z, int i) {
        this.f8593G = z;
        this.f8594H = i;
        this.f8595I = 0;
        this.f8596J = 0;
        this.f8587A = 0;
        return JsonToken.VALUE_NUMBER_INT;
    }

    protected final JsonToken m13203b(boolean z, int i, int i2, int i3) {
        this.f8593G = z;
        this.f8594H = i;
        this.f8595I = i2;
        this.f8596J = i3;
        this.f8587A = 0;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    protected final JsonToken m13198a(String str, double d) {
        this.f8609n.m13302a(str);
        this.f8590D = d;
        this.f8587A = 8;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    public final Number mo1783t() {
        if (this.f8587A == 0) {
            m13204c(0);
        }
        if (this.f8614K == JsonToken.VALUE_NUMBER_INT) {
            if ((this.f8587A & 1) != 0) {
                return Integer.valueOf(this.f8588B);
            }
            if ((this.f8587A & 2) != 0) {
                return Long.valueOf(this.f8589C);
            }
            if ((this.f8587A & 4) != 0) {
                return this.f8591E;
            }
            return this.f8592F;
        } else if ((this.f8587A & 16) != 0) {
            return this.f8592F;
        } else {
            if ((this.f8587A & 8) == 0) {
                VersionUtil.b();
            }
            return Double.valueOf(this.f8590D);
        }
    }

    public NumberType mo1784u() {
        if (this.f8587A == 0) {
            m13204c(0);
        }
        if (this.f8614K == JsonToken.VALUE_NUMBER_INT) {
            if ((this.f8587A & 1) != 0) {
                return NumberType.INT;
            }
            if ((this.f8587A & 2) != 0) {
                return NumberType.LONG;
            }
            return NumberType.BIG_INTEGER;
        } else if ((this.f8587A & 16) != 0) {
            return NumberType.BIG_DECIMAL;
        } else {
            return NumberType.DOUBLE;
        }
    }

    public final int mo1785x() {
        if ((this.f8587A & 1) == 0) {
            if (this.f8587A == 0) {
                m13204c(1);
            }
            if ((this.f8587A & 1) == 0) {
                m13179Z();
            }
        }
        return this.f8588B;
    }

    public final long mo1786y() {
        if ((this.f8587A & 2) == 0) {
            if (this.f8587A == 0) {
                m13204c(2);
            }
            if ((this.f8587A & 2) == 0) {
                aa();
            }
        }
        return this.f8589C;
    }

    public final BigInteger mo1787z() {
        if ((this.f8587A & 4) == 0) {
            if (this.f8587A == 0) {
                m13204c(4);
            }
            if ((this.f8587A & 4) == 0) {
                ab();
            }
        }
        return this.f8591E;
    }

    public final float mo1773A() {
        return (float) mo1774B();
    }

    public final double mo1774B() {
        if ((this.f8587A & 8) == 0) {
            if (this.f8587A == 0) {
                m13204c(8);
            }
            if ((this.f8587A & 8) == 0) {
                ac();
            }
        }
        return this.f8590D;
    }

    public final BigDecimal mo1775C() {
        if ((this.f8587A & 16) == 0) {
            if (this.f8587A == 0) {
                m13204c(16);
            }
            if ((this.f8587A & 16) == 0) {
                ad();
            }
        }
        return this.f8592F;
    }

    protected void m13204c(int i) {
        if (this.f8614K == JsonToken.VALUE_NUMBER_INT) {
            char[] f = this.f8609n.m13311f();
            int d = this.f8609n.m13309d();
            int i2 = this.f8594H;
            if (this.f8593G) {
                d++;
            }
            if (i2 <= 9) {
                d = NumberInput.m13440a(f, d, i2);
                if (this.f8593G) {
                    d = -d;
                }
                this.f8588B = d;
                this.f8587A = 1;
            } else if (i2 <= 18) {
                long b = NumberInput.m13445b(f, d, i2);
                if (this.f8593G) {
                    b = -b;
                }
                if (i2 == 10) {
                    if (this.f8593G) {
                        if (b >= -2147483648L) {
                            this.f8588B = (int) b;
                            this.f8587A = 1;
                            return;
                        }
                    } else if (b <= 2147483647L) {
                        this.f8588B = (int) b;
                        this.f8587A = 1;
                        return;
                    }
                }
                this.f8589C = b;
                this.f8587A = 2;
            } else {
                m13181a(f, d, i2);
            }
        } else if (this.f8614K == JsonToken.VALUE_NUMBER_FLOAT) {
            m13183f(i);
        } else {
            m13236e("Current token (" + this.f8614K + ") not numeric, can not use numeric value accessors");
        }
    }

    private void m13183f(int i) {
        if (i == 16) {
            try {
                this.f8592F = this.f8609n.m13314i();
                this.f8587A = 16;
                return;
            } catch (Throwable e) {
                m13227a("Malformed numeric value '" + this.f8609n.m13312g() + "'", e);
                return;
            }
        }
        this.f8590D = this.f8609n.m13315j();
        this.f8587A = 8;
    }

    private void m13181a(char[] cArr, int i, int i2) {
        String g = this.f8609n.m13312g();
        try {
            if (NumberInput.m13443a(cArr, i, i2, this.f8593G)) {
                this.f8589C = Long.parseLong(g);
                this.f8587A = 2;
                return;
            }
            this.f8591E = new BigInteger(g);
            this.f8587A = 4;
        } catch (Throwable e) {
            m13227a("Malformed numeric value '" + g + "'", e);
        }
    }

    private void m13179Z() {
        if ((this.f8587A & 2) != 0) {
            int i = (int) this.f8589C;
            if (((long) i) != this.f8589C) {
                m13236e("Numeric value (" + mo1769o() + ") out of range of int");
            }
            this.f8588B = i;
        } else if ((this.f8587A & 4) != 0) {
            if (f8579s.compareTo(this.f8591E) > 0 || f8580t.compareTo(this.f8591E) < 0) {
                ae();
            }
            this.f8588B = this.f8591E.intValue();
        } else if ((this.f8587A & 8) != 0) {
            if (this.f8590D < -2.147483648E9d || this.f8590D > 2.147483647E9d) {
                ae();
            }
            this.f8588B = (int) this.f8590D;
        } else if ((this.f8587A & 16) != 0) {
            if (f8585y.compareTo(this.f8592F) > 0 || f8586z.compareTo(this.f8592F) < 0) {
                ae();
            }
            this.f8588B = this.f8592F.intValue();
        } else {
            VersionUtil.b();
        }
        this.f8587A |= 1;
    }

    private void aa() {
        if ((this.f8587A & 1) != 0) {
            this.f8589C = (long) this.f8588B;
        } else if ((this.f8587A & 4) != 0) {
            if (f8581u.compareTo(this.f8591E) > 0 || f8582v.compareTo(this.f8591E) < 0) {
                af();
            }
            this.f8589C = this.f8591E.longValue();
        } else if ((this.f8587A & 8) != 0) {
            if (this.f8590D < -9.223372036854776E18d || this.f8590D > 9.223372036854776E18d) {
                af();
            }
            this.f8589C = (long) this.f8590D;
        } else if ((this.f8587A & 16) != 0) {
            if (f8583w.compareTo(this.f8592F) > 0 || f8584x.compareTo(this.f8592F) < 0) {
                af();
            }
            this.f8589C = this.f8592F.longValue();
        } else {
            VersionUtil.b();
        }
        this.f8587A |= 2;
    }

    private void ab() {
        if ((this.f8587A & 16) != 0) {
            this.f8591E = this.f8592F.toBigInteger();
        } else if ((this.f8587A & 2) != 0) {
            this.f8591E = BigInteger.valueOf(this.f8589C);
        } else if ((this.f8587A & 1) != 0) {
            this.f8591E = BigInteger.valueOf((long) this.f8588B);
        } else if ((this.f8587A & 8) != 0) {
            this.f8591E = BigDecimal.valueOf(this.f8590D).toBigInteger();
        } else {
            VersionUtil.b();
        }
        this.f8587A |= 4;
    }

    private void ac() {
        if ((this.f8587A & 16) != 0) {
            this.f8590D = this.f8592F.doubleValue();
        } else if ((this.f8587A & 4) != 0) {
            this.f8590D = this.f8591E.doubleValue();
        } else if ((this.f8587A & 2) != 0) {
            this.f8590D = (double) this.f8589C;
        } else if ((this.f8587A & 1) != 0) {
            this.f8590D = (double) this.f8588B;
        } else {
            VersionUtil.b();
        }
        this.f8587A |= 8;
    }

    private void ad() {
        if ((this.f8587A & 8) != 0) {
            this.f8592F = new BigDecimal(mo1769o());
        } else if ((this.f8587A & 4) != 0) {
            this.f8592F = new BigDecimal(this.f8591E);
        } else if ((this.f8587A & 2) != 0) {
            this.f8592F = BigDecimal.valueOf(this.f8589C);
        } else if ((this.f8587A & 1) != 0) {
            this.f8592F = BigDecimal.valueOf((long) this.f8588B);
        } else {
            VersionUtil.b();
        }
        this.f8587A |= 16;
    }

    protected final void m13202a(int i, String str) {
        String str2 = "Unexpected character (" + ParserMinimalBase.m13218e(i) + ") in numeric value";
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        m13236e(str2);
    }

    protected final void m13205c(String str) {
        m13236e("Invalid numeric value: " + str);
    }

    private void ae() {
        m13236e("Numeric value (" + mo1769o() + ") out of range of int (-2147483648" + " - 2147483647" + ")");
    }

    private void af() {
        m13236e("Numeric value (" + mo1769o() + ") out of range of long (-9223372036854775808" + " - 9223372036854775807" + ")");
    }

    protected char mo1758R() {
        throw new UnsupportedOperationException();
    }

    protected final int m13197a(Base64Variant base64Variant, int i, int i2) {
        if (i != 92) {
            throw m13182b(base64Variant, i, i2);
        }
        int R = mo1758R();
        if (R <= ' ' && i2 == 0) {
            return -1;
        }
        int b = base64Variant.m7147b(R);
        if (b >= 0) {
            return b;
        }
        throw m13182b(base64Variant, R, i2);
    }

    protected final int m13196a(Base64Variant base64Variant, char c, int i) {
        if (c != '\\') {
            throw m13182b(base64Variant, c, i);
        }
        char R = mo1758R();
        if (R <= ' ' && i == 0) {
            return -1;
        }
        int b = base64Variant.m7146b(R);
        if (b >= 0) {
            return b;
        }
        throw m13182b(base64Variant, R, i);
    }

    private IllegalArgumentException m13182b(Base64Variant base64Variant, int i, int i2) {
        return m13180a(base64Variant, i, i2, null);
    }

    protected static IllegalArgumentException m13180a(Base64Variant base64Variant, int i, int i2, String str) {
        String str2;
        if (i <= 32) {
            str2 = "Illegal white space character (code 0x" + Integer.toHexString(i) + ") as character #" + (i2 + 1) + " of 4-char base64 unit: can only used between units";
        } else if (base64Variant.m7144a(i)) {
            str2 = "Unexpected padding character ('" + base64Variant.f4077b + "') as character #" + (i2 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(i) || Character.isISOControl(i)) {
            str2 = "Illegal character (code 0x" + Integer.toHexString(i) + ") in base64 content";
        } else {
            str2 = "Illegal character '" + ((char) i) + "' (code 0x" + Integer.toHexString(i) + ") in base64 content";
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        return new IllegalArgumentException(str2);
    }
}

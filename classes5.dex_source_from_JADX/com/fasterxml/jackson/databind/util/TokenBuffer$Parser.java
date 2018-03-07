package com.fasterxml.jackson.databind.util;

import android.support.v7.widget.LinearLayoutCompat;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.fasterxml.jackson.core.json.JsonReadContext;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.cfg.PackageVersion;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: can_viewer_edit_post_media */
public final class TokenBuffer$Parser extends ParserMinimalBase {
    protected ObjectCodec f6258b;
    protected TokenBuffer$Segment f6259c;
    protected int f6260d;
    protected JsonReadContext f6261e;
    protected boolean f6262f;
    protected transient ByteArrayBuilder f6263g;
    public JsonLocation f6264h = null;

    public TokenBuffer$Parser(TokenBuffer$Segment tokenBuffer$Segment, ObjectCodec objectCodec) {
        super(0);
        this.f6259c = tokenBuffer$Segment;
        this.f6260d = -1;
        this.f6258b = objectCodec;
        this.f6261e = JsonReadContext.a(-1, -1);
    }

    public final void m11833a(JsonLocation jsonLocation) {
        this.f6264h = jsonLocation;
    }

    public final ObjectCodec m11832a() {
        return this.f6258b;
    }

    public final void m11834a(ObjectCodec objectCodec) {
        this.f6258b = objectCodec;
    }

    public final Version version() {
        return PackageVersion.VERSION;
    }

    public final void close() {
        if (!this.f6262f) {
            this.f6262f = true;
        }
    }

    public final JsonToken m11836c() {
        if (this.f6262f || this.f6259c == null) {
            return null;
        }
        int i = this.f6260d + 1;
        this.f6260d = i;
        if (i >= 16) {
            this.f6260d = 0;
            this.f6259c = this.f6259c.f6266a;
            if (this.f6259c == null) {
                return null;
            }
        }
        this.K = this.f6259c.m11853a(this.f6260d);
        if (this.K == JsonToken.FIELD_NAME) {
            Object K = m11825K();
            this.f6261e.f = K instanceof String ? (String) K : K.toString();
        } else if (this.K == JsonToken.START_OBJECT) {
            this.f6261e = this.f6261e.c(-1, -1);
        } else if (this.K == JsonToken.START_ARRAY) {
            this.f6261e = this.f6261e.b(-1, -1);
        } else if (this.K == JsonToken.END_OBJECT || this.K == JsonToken.END_ARRAY) {
            this.f6261e = this.f6261e.c;
            if (this.f6261e == null) {
                this.f6261e = JsonReadContext.a(-1, -1);
            }
        }
        return this.K;
    }

    public final JsonStreamContext m11838j() {
        return this.f6261e;
    }

    public final JsonLocation m11839k() {
        return l();
    }

    public final JsonLocation m11840l() {
        return this.f6264h == null ? JsonLocation.a : this.f6264h;
    }

    public final String m11837i() {
        return this.f6261e.h();
    }

    public final String m11841o() {
        Object K;
        if (this.K == JsonToken.VALUE_STRING || this.K == JsonToken.FIELD_NAME) {
            K = m11825K();
            if (K instanceof String) {
                return (String) K;
            }
            return K == null ? null : K.toString();
        } else if (this.K == null) {
            return null;
        } else {
            switch (TokenBuffer$1.f6256a[this.K.ordinal()]) {
                case 7:
                case 8:
                    K = m11825K();
                    return K == null ? null : K.toString();
                default:
                    return this.K.asString();
            }
        }
    }

    public final char[] m11842p() {
        String o = o();
        return o == null ? null : o.toCharArray();
    }

    public final int m11843q() {
        String o = o();
        return o == null ? 0 : o.length();
    }

    public final int m11844r() {
        return 0;
    }

    public final boolean m11845s() {
        return false;
    }

    public final BigInteger m11850z() {
        Number t = t();
        if (t instanceof BigInteger) {
            return (BigInteger) t;
        }
        if (u() == NumberType.BIG_DECIMAL) {
            return ((BigDecimal) t).toBigInteger();
        }
        return BigInteger.valueOf(t.longValue());
    }

    public final BigDecimal m11829C() {
        Number t = t();
        if (t instanceof BigDecimal) {
            return (BigDecimal) t;
        }
        switch (TokenBuffer$1.f6257b[u().ordinal()]) {
            case 1:
            case 5:
                return BigDecimal.valueOf(t.longValue());
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return new BigDecimal((BigInteger) t);
            default:
                return BigDecimal.valueOf(t.doubleValue());
        }
    }

    public final double m11828B() {
        return t().doubleValue();
    }

    public final float m11827A() {
        return t().floatValue();
    }

    public final int m11848x() {
        if (this.K == JsonToken.VALUE_NUMBER_INT) {
            return ((Number) m11825K()).intValue();
        }
        return t().intValue();
    }

    public final long m11849y() {
        return t().longValue();
    }

    public final NumberType m11847u() {
        Number t = t();
        if (t instanceof Integer) {
            return NumberType.INT;
        }
        if (t instanceof Long) {
            return NumberType.LONG;
        }
        if (t instanceof Double) {
            return NumberType.DOUBLE;
        }
        if (t instanceof BigDecimal) {
            return NumberType.BIG_DECIMAL;
        }
        if (t instanceof BigInteger) {
            return NumberType.BIG_INTEGER;
        }
        if (t instanceof Float) {
            return NumberType.FLOAT;
        }
        if (t instanceof Short) {
            return NumberType.INT;
        }
        return null;
    }

    public final Number m11846t() {
        m11826L();
        Object K = m11825K();
        if (K instanceof Number) {
            return (Number) K;
        }
        if (K instanceof String) {
            String str = (String) K;
            if (str.indexOf(46) >= 0) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return Long.valueOf(Long.parseLong(str));
        } else if (K == null) {
            return null;
        } else {
            throw new IllegalStateException("Internal error: entry should be a Number, but is of type " + K.getClass().getName());
        }
    }

    public final Object m11830D() {
        if (this.K == JsonToken.VALUE_EMBEDDED_OBJECT) {
            return m11825K();
        }
        return null;
    }

    public final byte[] m11835a(Base64Variant base64Variant) {
        if (this.K == JsonToken.VALUE_EMBEDDED_OBJECT) {
            Object K = m11825K();
            if (K instanceof byte[]) {
                return (byte[]) K;
            }
        }
        if (this.K != JsonToken.VALUE_STRING) {
            throw b("Current token (" + this.K + ") not VALUE_STRING (or VALUE_EMBEDDED_OBJECT with byte[]), can not access as binary");
        }
        String o = o();
        if (o == null) {
            return null;
        }
        ByteArrayBuilder byteArrayBuilder = this.f6263g;
        if (byteArrayBuilder == null) {
            byteArrayBuilder = new ByteArrayBuilder(100);
            this.f6263g = byteArrayBuilder;
        } else {
            this.f6263g.a();
        }
        a(o, byteArrayBuilder, base64Variant);
        return byteArrayBuilder.c();
    }

    private Object m11825K() {
        return this.f6259c.m11857b(this.f6260d);
    }

    private void m11826L() {
        if (this.K == null || !this.K.isNumeric()) {
            throw b("Current token (" + this.K + ") not numeric, can not use numeric value accessors");
        }
    }

    protected final void m11831P() {
        VersionUtil.m10782b();
    }
}

package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: caption */
public final class DecimalNode extends NumericNode {
    public static final DecimalNode f6144a = new DecimalNode(BigDecimal.ZERO);
    private static final BigDecimal f6145c = BigDecimal.valueOf(-2147483648L);
    private static final BigDecimal f6146d = BigDecimal.valueOf(2147483647L);
    private static final BigDecimal f6147e = BigDecimal.valueOf(Long.MIN_VALUE);
    private static final BigDecimal f6148f = BigDecimal.valueOf(Long.MAX_VALUE);
    protected final BigDecimal f6149b;

    private DecimalNode(BigDecimal bigDecimal) {
        this.f6149b = bigDecimal;
    }

    public static DecimalNode m11527a(BigDecimal bigDecimal) {
        return new DecimalNode(bigDecimal);
    }

    public final JsonToken m11530a() {
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    public final NumberType m11531b() {
        return NumberType.BIG_DECIMAL;
    }

    public final Number m11532v() {
        return this.f6149b;
    }

    public final int m11533w() {
        return this.f6149b.intValue();
    }

    public final long m11534x() {
        return this.f6149b.longValue();
    }

    public final BigInteger m11528A() {
        return this.f6149b.toBigInteger();
    }

    public final double m11535y() {
        return this.f6149b.doubleValue();
    }

    public final BigDecimal m11536z() {
        return this.f6149b;
    }

    public final String m11529B() {
        return this.f6149b.toString();
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (!serializerProvider.a(SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN) || (jsonGenerator instanceof TokenBuffer)) {
            jsonGenerator.a(this.f6149b);
        } else {
            jsonGenerator.e(this.f6149b.toPlainString());
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        if (((DecimalNode) obj).f6149b.compareTo(this.f6149b) != 0) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Double.valueOf(this.f6149b.doubleValue()).hashCode();
    }
}

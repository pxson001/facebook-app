package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: capture/setParameters failed */
public final class BigIntegerNode extends NumericNode {
    private static final BigInteger f6137b = BigInteger.valueOf(-2147483648L);
    private static final BigInteger f6138c = BigInteger.valueOf(2147483647L);
    private static final BigInteger f6139d = BigInteger.valueOf(Long.MIN_VALUE);
    private static final BigInteger f6140e = BigInteger.valueOf(Long.MAX_VALUE);
    protected final BigInteger f6141a;

    private BigIntegerNode(BigInteger bigInteger) {
        this.f6141a = bigInteger;
    }

    public static BigIntegerNode m11511a(BigInteger bigInteger) {
        return new BigIntegerNode(bigInteger);
    }

    public final JsonToken m11514a() {
        return JsonToken.VALUE_NUMBER_INT;
    }

    public final NumberType m11516b() {
        return NumberType.BIG_INTEGER;
    }

    public final Number m11517v() {
        return this.f6141a;
    }

    public final int m11518w() {
        return this.f6141a.intValue();
    }

    public final long m11519x() {
        return this.f6141a.longValue();
    }

    public final BigInteger m11512A() {
        return this.f6141a;
    }

    public final double m11520y() {
        return this.f6141a.doubleValue();
    }

    public final BigDecimal m11521z() {
        return new BigDecimal(this.f6141a);
    }

    public final String m11513B() {
        return this.f6141a.toString();
    }

    public final boolean m11515a(boolean z) {
        return !BigInteger.ZERO.equals(this.f6141a);
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.a(this.f6141a);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return ((BigIntegerNode) obj).f6141a.equals(this.f6141a);
    }

    public final int hashCode() {
        return this.f6141a.hashCode();
    }
}

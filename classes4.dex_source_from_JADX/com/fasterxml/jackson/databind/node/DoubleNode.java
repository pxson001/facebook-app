package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.NumberOutput;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: has_recent_message */
public final class DoubleNode extends NumericNode {
    protected final double f10832a;

    private DoubleNode(double d) {
        this.f10832a = d;
    }

    public static DoubleNode m11284b(double d) {
        return new DoubleNode(d);
    }

    public final JsonToken m11287a() {
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    public final NumberType m11288b() {
        return NumberType.DOUBLE;
    }

    public final Number m11289v() {
        return Double.valueOf(this.f10832a);
    }

    public final int m11290w() {
        return (int) this.f10832a;
    }

    public final long m11291x() {
        return (long) this.f10832a;
    }

    public final double m11292y() {
        return this.f10832a;
    }

    public final BigDecimal m11293z() {
        return BigDecimal.valueOf(this.f10832a);
    }

    public final BigInteger m11285A() {
        return z().toBigInteger();
    }

    public final String m11286B() {
        return NumberOutput.a(this.f10832a);
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.a(this.f10832a);
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
        if (Double.compare(this.f10832a, ((DoubleNode) obj).f10832a) != 0) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f10832a);
        return ((int) (doubleToLongBits >> 32)) ^ ((int) doubleToLongBits);
    }
}

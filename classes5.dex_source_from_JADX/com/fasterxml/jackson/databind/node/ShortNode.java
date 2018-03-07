package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.NumberOutput;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: canvas_url */
public final class ShortNode extends NumericNode {
    final short f6155a;

    private ShortNode(short s) {
        this.f6155a = s;
    }

    public static ShortNode m11556a(short s) {
        return new ShortNode(s);
    }

    public final JsonToken m11559a() {
        return JsonToken.VALUE_NUMBER_INT;
    }

    public final NumberType m11561b() {
        return NumberType.INT;
    }

    public final Number m11562v() {
        return Short.valueOf(this.f6155a);
    }

    public final int m11563w() {
        return this.f6155a;
    }

    public final long m11564x() {
        return (long) this.f6155a;
    }

    public final double m11565y() {
        return (double) this.f6155a;
    }

    public final BigDecimal m11566z() {
        return BigDecimal.valueOf((long) this.f6155a);
    }

    public final BigInteger m11557A() {
        return BigInteger.valueOf((long) this.f6155a);
    }

    public final String m11558B() {
        return NumberOutput.a(this.f6155a);
    }

    public final boolean m11560a(boolean z) {
        return this.f6155a != (short) 0;
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.a(this.f6155a);
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
        if (((ShortNode) obj).f6155a != this.f6155a) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f6155a;
    }
}

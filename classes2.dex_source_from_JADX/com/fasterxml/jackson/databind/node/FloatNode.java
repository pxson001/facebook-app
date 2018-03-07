package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.NumberOutput;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: liger_engine_enabled */
public final class FloatNode extends NumericNode {
    protected final float f17611a;

    private FloatNode(float f) {
        this.f17611a = f;
    }

    public static FloatNode m24779a(float f) {
        return new FloatNode(f);
    }

    public final JsonToken mo706a() {
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    public final NumberType mo721b() {
        return NumberType.FLOAT;
    }

    public final Number mo1282v() {
        return Float.valueOf(this.f17611a);
    }

    public final int mo1283w() {
        return (int) this.f17611a;
    }

    public final long mo1284x() {
        return (long) this.f17611a;
    }

    public final double mo1285y() {
        return (double) this.f17611a;
    }

    public final BigDecimal mo1286z() {
        return BigDecimal.valueOf((double) this.f17611a);
    }

    public final BigInteger mo1281A() {
        return mo1286z().toBigInteger();
    }

    public final String mo719B() {
        return NumberOutput.m12000a((double) this.f17611a);
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.mo1110a(this.f17611a);
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
        if (Float.compare(this.f17611a, ((FloatNode) obj).f17611a) != 0) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f17611a);
    }
}

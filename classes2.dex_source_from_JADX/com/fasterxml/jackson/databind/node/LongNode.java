package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.NumberOutput;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: share_clicked */
public final class LongNode extends NumericNode {
    final long f4992a;

    public LongNode(long j) {
        this.f4992a = j;
    }

    public static LongNode m8911b(long j) {
        return new LongNode(j);
    }

    public final JsonToken mo706a() {
        return JsonToken.VALUE_NUMBER_INT;
    }

    public final NumberType mo721b() {
        return NumberType.LONG;
    }

    public final Number mo1282v() {
        return Long.valueOf(this.f4992a);
    }

    public final int mo1283w() {
        return (int) this.f4992a;
    }

    public final long mo1284x() {
        return this.f4992a;
    }

    public final double mo1285y() {
        return (double) this.f4992a;
    }

    public final BigDecimal mo1286z() {
        return BigDecimal.valueOf(this.f4992a);
    }

    public final BigInteger mo1281A() {
        return BigInteger.valueOf(this.f4992a);
    }

    public final String mo719B() {
        return NumberOutput.m12002a(this.f4992a);
    }

    public final boolean mo726a(boolean z) {
        return this.f4992a != 0;
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.mo1111a(this.f4992a);
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
        if (((LongNode) obj).f4992a != this.f4992a) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return ((int) this.f4992a) ^ ((int) (this.f4992a >> 32));
    }
}

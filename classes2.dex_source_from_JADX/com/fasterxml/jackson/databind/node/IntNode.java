package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.NumberOutput;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: rowid */
public final class IntNode extends NumericNode {
    private static final IntNode[] f6521b = new IntNode[12];
    final int f6522a;

    static {
        for (int i = 0; i < 12; i++) {
            f6521b[i] = new IntNode(i - 1);
        }
    }

    private IntNode(int i) {
        this.f6522a = i;
    }

    public static IntNode m11286c(int i) {
        if (i > 10 || i < -1) {
            return new IntNode(i);
        }
        return f6521b[i + 1];
    }

    public final JsonToken mo706a() {
        return JsonToken.VALUE_NUMBER_INT;
    }

    public final NumberType mo721b() {
        return NumberType.INT;
    }

    public final boolean mo1604n() {
        return true;
    }

    public final Number mo1282v() {
        return Integer.valueOf(this.f6522a);
    }

    public final int mo1283w() {
        return this.f6522a;
    }

    public final long mo1284x() {
        return (long) this.f6522a;
    }

    public final double mo1285y() {
        return (double) this.f6522a;
    }

    public final BigDecimal mo1286z() {
        return BigDecimal.valueOf((long) this.f6522a);
    }

    public final BigInteger mo1281A() {
        return BigInteger.valueOf((long) this.f6522a);
    }

    public final String mo719B() {
        return NumberOutput.m12001a(this.f6522a);
    }

    public final boolean mo726a(boolean z) {
        return this.f6522a != 0;
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.mo1121b(this.f6522a);
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
        if (((IntNode) obj).f6522a != this.f6522a) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f6522a;
    }
}

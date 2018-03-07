package com.fasterxml.jackson.databind.node;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: temporary_parameters */
public class JsonNodeFactory implements Serializable {
    public static final JsonNodeFactory f3121a = f3122b;
    private static final JsonNodeFactory f3122b = new JsonNodeFactory(false);
    private static final JsonNodeFactory f3123c = new JsonNodeFactory(true);
    private static final long serialVersionUID = -3271940633258788634L;
    private final boolean _cfgBigDecimalExact;

    public static NullNode m5222a() {
        return NullNode.a;
    }

    public JsonNodeFactory(boolean z) {
        this._cfgBigDecimalExact = z;
    }

    protected JsonNodeFactory() {
        this(false);
    }

    public static BooleanNode m5221a(boolean z) {
        if (z) {
            return BooleanNode.f7218a;
        }
        return BooleanNode.f7219b;
    }

    public static NumericNode m5228a(short s) {
        return ShortNode.a(s);
    }

    public static NumericNode m5225a(int i) {
        return IntNode.m11286c(i);
    }

    public static NumericNode m5226a(long j) {
        return LongNode.m8911b(j);
    }

    public static NumericNode m5227a(BigInteger bigInteger) {
        return BigIntegerNode.a(bigInteger);
    }

    public static NumericNode m5224a(float f) {
        return FloatNode.m24779a(f);
    }

    public static NumericNode m5223a(double d) {
        return DoubleNode.b(d);
    }

    public final NumericNode m5231a(BigDecimal bigDecimal) {
        if (this._cfgBigDecimalExact) {
            return DecimalNode.a(bigDecimal);
        }
        if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
            return DecimalNode.a;
        }
        return DecimalNode.a(bigDecimal.stripTrailingZeros());
    }

    public static TextNode m5229a(String str) {
        return TextNode.m5239h(str);
    }

    public static BinaryNode m5220a(byte[] bArr) {
        return BinaryNode.a(bArr);
    }

    public final ArrayNode m5232b() {
        return new ArrayNode(this);
    }

    public final ObjectNode m5233c() {
        return new ObjectNode(this);
    }

    public static ValueNode m5230a(Object obj) {
        return new POJONode(obj);
    }
}

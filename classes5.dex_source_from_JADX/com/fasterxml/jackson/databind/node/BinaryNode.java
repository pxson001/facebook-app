package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.util.Arrays;

/* compiled from: captions_url */
public final class BinaryNode extends ValueNode {
    static final BinaryNode f6142a = new BinaryNode(new byte[0]);
    final byte[] f6143b;

    private BinaryNode(byte[] bArr) {
        this.f6143b = bArr;
    }

    public static BinaryNode m11522a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return f6142a;
        }
        return new BinaryNode(bArr);
    }

    public final JsonNodeType m11525k() {
        return JsonNodeType.BINARY;
    }

    public final JsonToken m11524a() {
        return JsonToken.VALUE_EMBEDDED_OBJECT;
    }

    public final byte[] m11526t() {
        return this.f6143b;
    }

    public final String m11523B() {
        return Base64Variants.b.a(this.f6143b, false);
    }

    public final String toString() {
        return Base64Variants.b.a(this.f6143b, true);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return Arrays.equals(((BinaryNode) obj).f6143b, this.f6143b);
    }

    public final int hashCode() {
        return this.f6143b == null ? -1 : this.f6143b.length;
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.a(serializerProvider._config.r(), this.f6143b, 0, this.f6143b.length);
    }
}

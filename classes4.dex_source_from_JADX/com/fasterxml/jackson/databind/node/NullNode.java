package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: identifier must not be null */
public final class NullNode extends ValueNode {
    public static final NullNode f10527a = new NullNode();

    private NullNode() {
    }

    public static NullNode m11057I() {
        return f10527a;
    }

    public final JsonNodeType m11060k() {
        return JsonNodeType.NULL;
    }

    public final JsonToken m11059a() {
        return JsonToken.VALUE_NULL;
    }

    public final String m11058B() {
        return "null";
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        serializerProvider.a(jsonGenerator);
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }
}

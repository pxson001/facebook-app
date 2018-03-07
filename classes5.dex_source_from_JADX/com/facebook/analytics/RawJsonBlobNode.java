package com.facebook.analytics;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ValueNode;

/* compiled from: timeline_unit */
public class RawJsonBlobNode extends ValueNode {
    private final String f1873a;

    public RawJsonBlobNode(String str) {
        this.f1873a = str;
    }

    public final JsonNodeType m2561k() {
        return JsonNodeType.STRING;
    }

    public final String m2559B() {
        return this.f1873a;
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.d(this.f1873a);
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public final JsonToken m2560a() {
        return JsonToken.START_OBJECT;
    }
}

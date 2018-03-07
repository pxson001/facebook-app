package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: inline_privacy_survey_deserialization */
public final class MissingNode extends ValueNode {
    public static final MissingNode f10325a = new MissingNode();

    private MissingNode() {
    }

    public final <T extends JsonNode> T m10849d() {
        return this;
    }

    public static MissingNode m10846I() {
        return f10325a;
    }

    public final JsonNodeType m10850k() {
        return JsonNodeType.MISSING;
    }

    public final JsonToken m10848a() {
        return JsonToken.NOT_AVAILABLE;
    }

    public final String m10847B() {
        return "";
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.h();
    }

    public final void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        jsonGenerator.h();
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    public final String toString() {
        return "";
    }
}

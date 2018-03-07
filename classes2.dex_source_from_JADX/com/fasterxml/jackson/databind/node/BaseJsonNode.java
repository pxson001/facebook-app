package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: textPostFromThirdParty */
public abstract class BaseJsonNode extends JsonNode implements JsonSerializable {
    public abstract void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider);

    protected BaseJsonNode() {
    }

    public final JsonNode mo723g(String str) {
        JsonNode f = mo713f(str);
        if (f == null) {
            return MissingNode.a;
        }
        return f;
    }

    public final JsonParser mo722c() {
        return new TreeTraversingParser(this);
    }

    public final JsonParser mo720a(ObjectCodec objectCodec) {
        return new TreeTraversingParser(this, objectCodec);
    }

    public NumberType mo721b() {
        return null;
    }
}

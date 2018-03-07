package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.node.ObjectNode;

/* compiled from: checkin_story */
public final class JsonNodeDeserializer$ObjectDeserializer extends BaseNodeDeserializer {
    public static final JsonNodeDeserializer$ObjectDeserializer f6083a = new JsonNodeDeserializer$ObjectDeserializer();
    private static final long serialVersionUID = 1;

    public final /* synthetic */ Object m11213a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m11214b(jsonParser, deserializationContext);
    }

    protected JsonNodeDeserializer$ObjectDeserializer() {
    }

    public static JsonNodeDeserializer$ObjectDeserializer m11212f() {
        return f6083a;
    }

    public final ObjectNode m11214b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (jsonParser.g() == JsonToken.START_OBJECT) {
            jsonParser.c();
            return a(jsonParser, deserializationContext, deserializationContext.i());
        } else if (jsonParser.g() == JsonToken.FIELD_NAME) {
            return a(jsonParser, deserializationContext, deserializationContext.i());
        } else {
            throw deserializationContext.b(ObjectNode.class);
        }
    }
}

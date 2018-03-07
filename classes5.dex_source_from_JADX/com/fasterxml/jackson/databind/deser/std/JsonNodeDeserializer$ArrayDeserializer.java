package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.node.ArrayNode;

/* compiled from: checkin_story */
public final class JsonNodeDeserializer$ArrayDeserializer extends BaseNodeDeserializer {
    public static final JsonNodeDeserializer$ArrayDeserializer f6082a = new JsonNodeDeserializer$ArrayDeserializer();
    private static final long serialVersionUID = 1;

    public final /* synthetic */ Object m11210a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m11211b(jsonParser, deserializationContext);
    }

    protected JsonNodeDeserializer$ArrayDeserializer() {
    }

    public static JsonNodeDeserializer$ArrayDeserializer m11209f() {
        return f6082a;
    }

    public final ArrayNode m11211b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (jsonParser.m()) {
            return b(jsonParser, deserializationContext, deserializationContext.i());
        }
        throw deserializationContext.b(ArrayNode.class);
    }
}

package com.fasterxml.jackson.databind.deser.std;

import com.facebook.proxygen.HTTPTransportCallback;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/* compiled from: push_orphaned */
public class JsonNodeDeserializer extends BaseNodeDeserializer {
    private static final JsonNodeDeserializer f8634a = new JsonNodeDeserializer();

    /* compiled from: push_orphaned */
    /* synthetic */ class C03761 {
        static final /* synthetic */ int[] f8651a = new int[JsonToken.values().length];

        static {
            try {
                f8651a[JsonToken.START_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8651a[JsonToken.START_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public /* synthetic */ Object mo1797a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m13334b(jsonParser, deserializationContext);
    }

    protected JsonNodeDeserializer() {
    }

    public static JsonDeserializer<? extends JsonNode> m13332a(Class<?> cls) {
        if (cls == ObjectNode.class) {
            return ObjectDeserializer.a;
        }
        if (cls == ArrayNode.class) {
            return ArrayDeserializer.a;
        }
        return f8634a;
    }

    public JsonNode m13334b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        switch (C03761.f8651a[jsonParser.mo1794g().ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return m13335a(jsonParser, deserializationContext, deserializationContext.m7410i());
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return m13338b(jsonParser, deserializationContext, deserializationContext.m7410i());
            default:
                return m13339c(jsonParser, deserializationContext, deserializationContext.m7410i());
        }
    }
}

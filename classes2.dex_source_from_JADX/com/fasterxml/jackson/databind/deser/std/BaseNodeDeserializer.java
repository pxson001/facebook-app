package com.fasterxml.jackson.databind.deser.std;

import com.facebook.proxygen.HTTPTransportCallback;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

/* compiled from: push_orphaned */
public abstract class BaseNodeDeserializer extends StdDeserializer<JsonNode> {

    /* compiled from: push_orphaned */
    /* synthetic */ class C03771 {
        static final /* synthetic */ int[] f8653a = new int[JsonToken.values().length];

        static {
            try {
                f8653a[JsonToken.START_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8653a[JsonToken.START_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8653a[JsonToken.VALUE_STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f8653a[JsonToken.END_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f8653a[JsonToken.FIELD_NAME.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f8653a[JsonToken.VALUE_EMBEDDED_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f8653a[JsonToken.VALUE_NUMBER_INT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f8653a[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f8653a[JsonToken.VALUE_TRUE.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f8653a[JsonToken.VALUE_FALSE.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f8653a[JsonToken.VALUE_NULL.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    public JsonNode m13340e() {
        return NullNode.a;
    }

    public final /* synthetic */ Object mo1798a() {
        return m13340e();
    }

    public BaseNodeDeserializer() {
        super(JsonNode.class);
    }

    public Object mo1799a(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return typeDeserializer.d(jsonParser, deserializationContext);
    }

    protected final ObjectNode m13335a(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) {
        ObjectNode c = jsonNodeFactory.m5233c();
        JsonToken g = jsonParser.mo1794g();
        if (g == JsonToken.START_OBJECT) {
            g = jsonParser.mo1766c();
        }
        while (g == JsonToken.FIELD_NAME) {
            JsonNode a;
            String i = jsonParser.mo1778i();
            switch (C03771.f8653a[jsonParser.mo1766c().ordinal()]) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    a = m13335a(jsonParser, deserializationContext, jsonNodeFactory);
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    a = m13338b(jsonParser, deserializationContext, jsonNodeFactory);
                    break;
                case 3:
                    a = TextNode.m5239h(jsonParser.mo1769o());
                    break;
                default:
                    a = m13339c(jsonParser, deserializationContext, jsonNodeFactory);
                    break;
            }
            c.m5141b(i, a);
            g = jsonParser.mo1766c();
        }
        return c;
    }

    protected final ArrayNode m13338b(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) {
        ArrayNode b = jsonNodeFactory.m5232b();
        while (true) {
            JsonToken c = jsonParser.mo1766c();
            if (c != null) {
                switch (C03771.f8653a[c.ordinal()]) {
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        b.m13381a(m13335a(jsonParser, deserializationContext, jsonNodeFactory));
                        break;
                    case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                        b.m13381a(m13338b(jsonParser, deserializationContext, jsonNodeFactory));
                        break;
                    case 3:
                        b.m13381a(TextNode.m5239h(jsonParser.mo1769o()));
                        break;
                    case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                        return b;
                    default:
                        b.m13381a(m13339c(jsonParser, deserializationContext, jsonNodeFactory));
                        break;
                }
            }
            throw deserializationContext.m7402c("Unexpected end-of-input when binding data into ArrayNode");
        }
    }

    protected final JsonNode m13339c(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) {
        switch (C03771.f8653a[jsonParser.mo1794g().ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return m13335a(jsonParser, deserializationContext, jsonNodeFactory);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return m13338b(jsonParser, deserializationContext, jsonNodeFactory);
            case 3:
                return TextNode.m5239h(jsonParser.mo1769o());
            case 5:
                return m13335a(jsonParser, deserializationContext, jsonNodeFactory);
            case 6:
                Object D = jsonParser.mo1776D();
                if (D == null) {
                    return NullNode.a;
                }
                if (D.getClass() == byte[].class) {
                    return BinaryNode.a((byte[]) D);
                }
                return JsonNodeFactory.m5230a(D);
            case 7:
                NumberType u = jsonParser.mo1784u();
                if (u == NumberType.BIG_INTEGER || deserializationContext.m7395a(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)) {
                    return BigIntegerNode.a(jsonParser.mo1787z());
                }
                if (u == NumberType.INT) {
                    return IntNode.m11286c(jsonParser.mo1785x());
                }
                return LongNode.m8911b(jsonParser.mo1786y());
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                if (jsonParser.mo1784u() == NumberType.BIG_DECIMAL || deserializationContext.m7395a(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                    return jsonNodeFactory.m5231a(jsonParser.mo1775C());
                }
                return DoubleNode.b(jsonParser.mo1774B());
            case 9:
                return JsonNodeFactory.m5221a(true);
            case 10:
                return JsonNodeFactory.m5221a(false);
            case 11:
                return NullNode.a;
            default:
                throw deserializationContext.m7397b(this._valueClass);
        }
    }
}

package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo$As;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.util.JsonParserSequence;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.Serializable;

/* compiled from: category */
public class AsWrapperTypeDeserializer extends TypeDeserializerBase implements Serializable {
    private static final long serialVersionUID = 5345570420394408290L;

    public AsWrapperTypeDeserializer(JavaType javaType, TypeIdResolver typeIdResolver, String str, boolean z) {
        super(javaType, typeIdResolver, str, z, null);
    }

    private AsWrapperTypeDeserializer(AsWrapperTypeDeserializer asWrapperTypeDeserializer, BeanProperty beanProperty) {
        super(asWrapperTypeDeserializer, beanProperty);
    }

    public final TypeDeserializer mo698a(BeanProperty beanProperty) {
        return beanProperty == this._property ? this : new AsWrapperTypeDeserializer(this, beanProperty);
    }

    public final JsonTypeInfo$As mo697a() {
        return JsonTypeInfo$As.WRAPPER_OBJECT;
    }

    public final Object mo699a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m11470e(jsonParser, deserializationContext);
    }

    public final Object mo700b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m11470e(jsonParser, deserializationContext);
    }

    public final Object mo701c(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m11470e(jsonParser, deserializationContext);
    }

    public final Object mo702d(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m11470e(jsonParser, deserializationContext);
    }

    private final Object m11470e(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            throw DeserializationContext.a(jsonParser, JsonToken.START_OBJECT, "need JSON Object to contain As.WRAPPER_OBJECT type information for class " + m11418e());
        } else if (jsonParser.c() != JsonToken.FIELD_NAME) {
            throw DeserializationContext.a(jsonParser, JsonToken.FIELD_NAME, "need JSON String that contains type id (for subtype of " + m11418e() + ")");
        } else {
            String o = jsonParser.o();
            JsonDeserializer a = m11414a(deserializationContext, o);
            jsonParser.c();
            if (this._typeIdVisible && jsonParser.g() == JsonToken.START_OBJECT) {
                TokenBuffer tokenBuffer = new TokenBuffer(null);
                tokenBuffer.f();
                tokenBuffer.a(this._typePropertyName);
                tokenBuffer.b(o);
                jsonParser = JsonParserSequence.m10764a(tokenBuffer.a(jsonParser), jsonParser);
                jsonParser.c();
            }
            Object a2 = a.a(jsonParser, deserializationContext);
            if (jsonParser.c() == JsonToken.END_OBJECT) {
                return a2;
            }
            throw DeserializationContext.a(jsonParser, JsonToken.END_OBJECT, "expected closing END_OBJECT after type information and deserialized value");
        }
    }
}

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

/* compiled from: category_id */
public class AsArrayTypeDeserializer extends TypeDeserializerBase implements Serializable {
    private static final long serialVersionUID = 5345570420394408290L;

    public AsArrayTypeDeserializer(JavaType javaType, TypeIdResolver typeIdResolver, String str, boolean z, Class<?> cls) {
        super(javaType, typeIdResolver, str, z, cls);
    }

    public AsArrayTypeDeserializer(AsArrayTypeDeserializer asArrayTypeDeserializer, BeanProperty beanProperty) {
        super(asArrayTypeDeserializer, beanProperty);
    }

    public TypeDeserializer mo698a(BeanProperty beanProperty) {
        return beanProperty == this._property ? this : new AsArrayTypeDeserializer(this, beanProperty);
    }

    public JsonTypeInfo$As mo697a() {
        return JsonTypeInfo$As.WRAPPER_ARRAY;
    }

    public final Object mo700b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m11419e(jsonParser, deserializationContext);
    }

    public Object mo699a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m11419e(jsonParser, deserializationContext);
    }

    public final Object mo701c(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m11419e(jsonParser, deserializationContext);
    }

    public Object mo702d(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m11419e(jsonParser, deserializationContext);
    }

    private final Object m11419e(JsonParser jsonParser, DeserializationContext deserializationContext) {
        boolean m = jsonParser.m();
        String f = m11420f(jsonParser, deserializationContext);
        JsonDeserializer a = m11414a(deserializationContext, f);
        if (this._typeIdVisible && jsonParser.g() == JsonToken.START_OBJECT) {
            TokenBuffer tokenBuffer = new TokenBuffer(null);
            tokenBuffer.f();
            tokenBuffer.a(this._typePropertyName);
            tokenBuffer.b(f);
            jsonParser = JsonParserSequence.m10764a(tokenBuffer.a(jsonParser), jsonParser);
            jsonParser.c();
        }
        Object a2 = a.a(jsonParser, deserializationContext);
        if (!m || jsonParser.c() == JsonToken.END_ARRAY) {
            return a2;
        }
        throw DeserializationContext.a(jsonParser, JsonToken.END_ARRAY, "expected closing END_ARRAY after type information and deserialized value");
    }

    private String m11420f(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (jsonParser.m()) {
            if (jsonParser.c() == JsonToken.VALUE_STRING) {
                String o = jsonParser.o();
                jsonParser.c();
                return o;
            } else if (this._defaultImpl != null) {
                return this._idResolver.mo714a();
            } else {
                throw DeserializationContext.a(jsonParser, JsonToken.VALUE_STRING, "need JSON String that contains type id (for subtype of " + m11418e() + ")");
            }
        } else if (this._defaultImpl != null) {
            return this._idResolver.mo714a();
        } else {
            throw DeserializationContext.a(jsonParser, JsonToken.START_ARRAY, "need JSON Array to contain As.WRAPPER_ARRAY type information for class " + m11418e());
        }
    }
}

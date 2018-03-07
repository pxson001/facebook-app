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

/* compiled from: categoryList */
public class AsPropertyTypeDeserializer extends AsArrayTypeDeserializer {
    private static final long serialVersionUID = 1;

    public AsPropertyTypeDeserializer(JavaType javaType, TypeIdResolver typeIdResolver, String str, boolean z, Class<?> cls) {
        super(javaType, typeIdResolver, str, z, cls);
    }

    private AsPropertyTypeDeserializer(AsPropertyTypeDeserializer asPropertyTypeDeserializer, BeanProperty beanProperty) {
        super(asPropertyTypeDeserializer, beanProperty);
    }

    public final TypeDeserializer mo698a(BeanProperty beanProperty) {
        return beanProperty == this._property ? this : new AsPropertyTypeDeserializer(this, beanProperty);
    }

    public final JsonTypeInfo$As mo697a() {
        return JsonTypeInfo$As.PROPERTY;
    }

    public final Object mo699a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken g = jsonParser.g();
        if (g == JsonToken.START_OBJECT) {
            g = jsonParser.c();
        } else if (g == JsonToken.START_ARRAY) {
            return m11458b(jsonParser, deserializationContext, null);
        } else {
            if (g != JsonToken.FIELD_NAME) {
                return m11458b(jsonParser, deserializationContext, null);
            }
        }
        JsonToken jsonToken = g;
        TokenBuffer tokenBuffer = null;
        while (jsonToken == JsonToken.FIELD_NAME) {
            String i = jsonParser.i();
            jsonParser.c();
            if (this._typePropertyName.equals(i)) {
                return m11457a(jsonParser, deserializationContext, tokenBuffer);
            }
            if (tokenBuffer == null) {
                tokenBuffer = new TokenBuffer(null);
            }
            tokenBuffer.a(i);
            tokenBuffer.b(jsonParser);
            jsonToken = jsonParser.c();
        }
        return m11458b(jsonParser, deserializationContext, tokenBuffer);
    }

    private Object m11457a(JsonParser jsonParser, DeserializationContext deserializationContext, TokenBuffer tokenBuffer) {
        String o = jsonParser.o();
        JsonDeserializer a = m11414a(deserializationContext, o);
        if (this._typeIdVisible) {
            if (tokenBuffer == null) {
                tokenBuffer = new TokenBuffer(null);
            }
            tokenBuffer.a(jsonParser.i());
            tokenBuffer.b(o);
        }
        if (tokenBuffer != null) {
            jsonParser = JsonParserSequence.m10764a(tokenBuffer.a(jsonParser), jsonParser);
        }
        jsonParser.c();
        return a.a(jsonParser, deserializationContext);
    }

    private Object m11458b(JsonParser jsonParser, DeserializationContext deserializationContext, TokenBuffer tokenBuffer) {
        JsonDeserializer a = m11413a(deserializationContext);
        if (a != null) {
            if (tokenBuffer != null) {
                tokenBuffer.g();
                jsonParser = tokenBuffer.a(jsonParser);
                jsonParser.c();
            }
            return a.a(jsonParser, deserializationContext);
        }
        Object a2 = TypeDeserializer.m11380a(jsonParser, deserializationContext, this._baseType);
        if (a2 != null) {
            return a2;
        }
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            return super.mo702d(jsonParser, deserializationContext);
        }
        throw DeserializationContext.a(jsonParser, JsonToken.FIELD_NAME, "missing property '" + this._typePropertyName + "' that is to contain type id  (for class " + m11418e() + ")");
    }

    public final Object mo702d(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            return super.mo700b(jsonParser, deserializationContext);
        }
        return mo699a(jsonParser, deserializationContext);
    }
}

package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;

@JacksonStdImpl
/* compiled from: push */
public final class StringDeserializer extends StdScalarDeserializer<String> {
    public static final StringDeserializer f8636a = new StringDeserializer();
    private static final long serialVersionUID = 1;

    public final /* synthetic */ Object mo1797a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m13398b(jsonParser, deserializationContext);
    }

    public StringDeserializer() {
        super(String.class);
    }

    public final String m13398b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        String I = jsonParser.mo1753I();
        if (I != null) {
            return I;
        }
        JsonToken g = jsonParser.mo1794g();
        if (g == JsonToken.VALUE_EMBEDDED_OBJECT) {
            Object D = jsonParser.mo1776D();
            if (D == null) {
                return null;
            }
            return D instanceof byte[] ? Base64Variants.f4073b.m7140a((byte[]) D, false) : D.toString();
        } else {
            throw deserializationContext.m7383a(this._valueClass, g);
        }
    }

    public final Object mo1799a(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return m13398b(jsonParser, deserializationContext);
    }
}

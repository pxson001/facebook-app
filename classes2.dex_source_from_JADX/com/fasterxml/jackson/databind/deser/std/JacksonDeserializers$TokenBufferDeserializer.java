package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.util.TokenBuffer;

@JacksonStdImpl
/* compiled from: pull_to_refresh_slow */
public class JacksonDeserializers$TokenBufferDeserializer extends StdScalarDeserializer<TokenBuffer> {
    public static final JacksonDeserializers$TokenBufferDeserializer f8648a = new JacksonDeserializers$TokenBufferDeserializer();

    public /* synthetic */ Object mo1797a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m13430b(jsonParser, deserializationContext);
    }

    public JacksonDeserializers$TokenBufferDeserializer() {
        super(TokenBuffer.class);
    }

    public TokenBuffer m13430b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        TokenBuffer tokenBuffer = new TokenBuffer(jsonParser.mo1761a());
        tokenBuffer.m7653b(jsonParser);
        return tokenBuffer;
    }
}

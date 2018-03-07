package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.util.TokenBuffer;

@JacksonStdImpl
/* compiled from: stack_frame  */
public class TokenBufferSerializer extends StdSerializer<TokenBuffer> {
    public final /* bridge */ /* synthetic */ void mo1072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ((TokenBuffer) obj).m7643a(jsonGenerator);
    }

    public final void mo1074a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        TokenBuffer tokenBuffer = (TokenBuffer) obj;
        typeSerializer.a(tokenBuffer, jsonGenerator);
        tokenBuffer.m7643a(jsonGenerator);
        typeSerializer.d(tokenBuffer, jsonGenerator);
    }

    public TokenBufferSerializer() {
        super(TokenBuffer.class);
    }

    private static void m7716a(TokenBuffer tokenBuffer, JsonGenerator jsonGenerator) {
        tokenBuffer.m7643a(jsonGenerator);
    }
}

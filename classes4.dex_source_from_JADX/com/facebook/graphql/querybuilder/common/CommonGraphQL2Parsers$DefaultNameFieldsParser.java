package com.facebook.graphql.querybuilder.common;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: soft error */
public final class CommonGraphQL2Parsers$DefaultNameFieldsParser {
    public static int m2043a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[3];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("locale")) {
                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("parts")) {
                    iArr[1] = CommonGraphQL2Parsers$DefaultNamePartFieldsParser.m2045a(jsonParser, flatBufferBuilder);
                } else if (i.equals("text")) {
                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        return flatBufferBuilder.d();
    }

    public static void m2044a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("locale");
            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
        }
        int g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("parts");
            CommonGraphQL2Parsers$DefaultNamePartFieldsParser.m2047a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
        }
        jsonGenerator.g();
    }
}

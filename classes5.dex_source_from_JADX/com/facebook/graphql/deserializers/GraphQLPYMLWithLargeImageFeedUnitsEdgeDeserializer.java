package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: object */
public class GraphQLPYMLWithLargeImageFeedUnitsEdgeDeserializer {
    public static int m5489a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("node")) {
                    iArr[0] = GraphQLPYMLWithLargeImageFeedUnitItemDeserializer.m5482a(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, iArr[0]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5490a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5489a(jsonParser, flatBufferBuilder);
        if (1 != 0) {
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, s, 0);
            flatBufferBuilder.b(1, a);
            a = flatBufferBuilder.d();
        }
        flatBufferBuilder.d(a);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        return mutableFlatBuffer;
    }

    public static void m5491b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("node");
            GraphQLPYMLWithLargeImageFeedUnitItemDeserializer.m5485b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }
}

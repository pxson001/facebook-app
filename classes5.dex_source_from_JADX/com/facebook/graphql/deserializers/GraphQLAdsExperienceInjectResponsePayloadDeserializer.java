package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: place_open_status_formats */
public class GraphQLAdsExperienceInjectResponsePayloadDeserializer {
    public static int m4537a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[2];
        boolean[] zArr = new boolean[1];
        boolean[] zArr2 = new boolean[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("inject_status")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("viewer")) {
                    iArr[1] = GraphQLViewerDeserializer.m6199a(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(2);
        if (zArr[0]) {
            flatBufferBuilder.a(0, zArr2[0]);
        }
        flatBufferBuilder.b(1, iArr[1]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4538a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4537a(jsonParser, flatBufferBuilder);
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

    public static void m4539a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        boolean a = mutableFlatBuffer.a(i, 0);
        if (a) {
            jsonGenerator.a("inject_status");
            jsonGenerator.a(a);
        }
        int g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("viewer");
            GraphQLViewerDeserializer.m6201a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }
}

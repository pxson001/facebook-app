package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: mobile_ios_composer_edit */
public class GraphQLSubstoriesConnectionDeserializer {
    public static int m6014a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[5];
        boolean[] zArr = new boolean[2];
        int[] iArr2 = new int[2];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("count")) {
                    zArr[0] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("nodes")) {
                    iArr[2] = GraphQLStoryDeserializer.m5965b(jsonParser, flatBufferBuilder);
                } else if (i.equals("page_info")) {
                    iArr[3] = GraphQLPageInfoDeserializer.m5506a(jsonParser, flatBufferBuilder);
                } else if (i.equals("remaining_count")) {
                    zArr[1] = true;
                    iArr2[1] = jsonParser.E();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(5);
        if (zArr[0]) {
            flatBufferBuilder.a(0, iArr2[0], 0);
        }
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        if (zArr[1]) {
            flatBufferBuilder.a(4, iArr2[1], 0);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m6015a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m6014a(jsonParser, flatBufferBuilder);
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

    public static void m6016a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int a = mutableFlatBuffer.a(i, 0, 0);
        if (a != 0) {
            jsonGenerator.a("count");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.g(i, 2);
        if (a != 0) {
            jsonGenerator.a("nodes");
            GraphQLStoryDeserializer.m5964a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.g(i, 3);
        if (a != 0) {
            jsonGenerator.a("page_info");
            GraphQLPageInfoDeserializer.m5508a(mutableFlatBuffer, a, jsonGenerator);
        }
        a = mutableFlatBuffer.a(i, 4, 0);
        if (a != 0) {
            jsonGenerator.a("remaining_count");
            jsonGenerator.b(a);
        }
        jsonGenerator.g();
    }
}

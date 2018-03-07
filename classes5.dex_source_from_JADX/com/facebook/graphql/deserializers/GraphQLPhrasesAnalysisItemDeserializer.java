package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: next_page */
public class GraphQLPhrasesAnalysisItemDeserializer {
    public static int m5629a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[10];
        boolean[] zArr = new boolean[3];
        int[] iArr2 = new int[3];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("count")) {
                    zArr[0] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("id")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("more_posts_query")) {
                    iArr[2] = GraphQLGraphSearchQueryDeserializer.m5083a(jsonParser, flatBufferBuilder);
                } else if (i.equals("phrase")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("phrase_length")) {
                    zArr[1] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("phrase_offset")) {
                    zArr[2] = true;
                    iArr2[2] = jsonParser.E();
                } else if (i.equals("phrase_owner")) {
                    iArr[6] = GraphQLProfileDeserializer.m5717a(jsonParser, flatBufferBuilder);
                } else if (i.equals("sample_text")) {
                    iArr[7] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("sentence")) {
                    iArr[8] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("url")) {
                    iArr[9] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(10);
        if (zArr[0]) {
            flatBufferBuilder.a(0, iArr2[0], 0);
        }
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        if (zArr[1]) {
            flatBufferBuilder.a(4, iArr2[1], 0);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(5, iArr2[2], 0);
        }
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5630a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5629a(jsonParser, flatBufferBuilder);
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

    public static void m5631a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int a = mutableFlatBuffer.a(i, 0, 0);
        if (a != 0) {
            jsonGenerator.a("count");
            jsonGenerator.b(a);
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        a = mutableFlatBuffer.g(i, 2);
        if (a != 0) {
            jsonGenerator.a("more_posts_query");
            GraphQLGraphSearchQueryDeserializer.m5085a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("phrase");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        a = mutableFlatBuffer.a(i, 4, 0);
        if (a != 0) {
            jsonGenerator.a("phrase_length");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.a(i, 5, 0);
        if (a != 0) {
            jsonGenerator.a("phrase_offset");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.g(i, 6);
        if (a != 0) {
            jsonGenerator.a("phrase_owner");
            GraphQLProfileDeserializer.m5721b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 7) != 0) {
            jsonGenerator.a("sample_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 7));
        }
        if (mutableFlatBuffer.g(i, 8) != 0) {
            jsonGenerator.a("sentence");
            jsonGenerator.b(mutableFlatBuffer.c(i, 8));
        }
        if (mutableFlatBuffer.g(i, 9) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 9));
        }
        jsonGenerator.g();
    }
}

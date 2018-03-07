package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: place_list_items */
public class GraphQLAggregatedEntitiesAtRangeDeserializer {
    public static int m4546a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[4];
        boolean[] zArr = new boolean[3];
        int[] iArr2 = new int[3];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("count")) {
                    zArr[0] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("length")) {
                    zArr[1] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("offset")) {
                    zArr[2] = true;
                    iArr2[2] = jsonParser.E();
                } else if (i.equals("sample_entities")) {
                    iArr[3] = GraphQLEntityDeserializer.m4765b(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(4);
        if (zArr[0]) {
            flatBufferBuilder.a(0, iArr2[0], 0);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(1, iArr2[1], 0);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(2, iArr2[2], 0);
        }
        flatBufferBuilder.b(3, iArr[3]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4547a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4546a(jsonParser, flatBufferBuilder);
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

    public static void m4548b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int a = mutableFlatBuffer.a(i, 0, 0);
        if (a != 0) {
            jsonGenerator.a("count");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.a(i, 1, 0);
        if (a != 0) {
            jsonGenerator.a("length");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.a(i, 2, 0);
        if (a != 0) {
            jsonGenerator.a("offset");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.g(i, 3);
        if (a != 0) {
            jsonGenerator.a("sample_entities");
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(a); i2++) {
                GraphQLEntityDeserializer.m4766b(mutableFlatBuffer, mutableFlatBuffer.m(a, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }
        jsonGenerator.g();
    }
}

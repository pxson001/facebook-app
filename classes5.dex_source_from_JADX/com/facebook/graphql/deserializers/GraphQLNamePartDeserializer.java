package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLStructuredNamePart;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: og_music */
public class GraphQLNamePartDeserializer {
    public static int m5388a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        boolean[] zArr = new boolean[3];
        int[] iArr = new int[2];
        Enum[] enumArr = new Enum[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("length")) {
                    zArr[0] = true;
                    iArr[0] = jsonParser.E();
                } else if (i.equals("offset")) {
                    zArr[1] = true;
                    iArr[1] = jsonParser.E();
                } else if (i.equals("part")) {
                    zArr[2] = true;
                    enumArr[0] = GraphQLStructuredNamePart.fromString(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(3);
        if (zArr[0]) {
            flatBufferBuilder.a(0, iArr[0], 0);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(1, iArr[1], 0);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(2, enumArr[0]);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5389a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5388a(jsonParser, flatBufferBuilder);
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

    public static void m5390a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        int a = mutableFlatBuffer.a(i, 0, 0);
        if (a != 0) {
            jsonGenerator.a("length");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.a(i, 1, 0);
        if (a != 0) {
            jsonGenerator.a("offset");
            jsonGenerator.b(a);
        }
        if (mutableFlatBuffer.a(i, 2, (short) 0) != (short) 0) {
            jsonGenerator.a("part");
            jsonGenerator.b(((GraphQLStructuredNamePart) mutableFlatBuffer.a(i, 2, GraphQLStructuredNamePart.class)).name());
        }
        jsonGenerator.g();
    }
}

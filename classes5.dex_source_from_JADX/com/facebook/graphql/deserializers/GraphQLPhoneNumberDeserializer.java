package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLBlockStatus;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: noConnectivity */
public class GraphQLPhoneNumberDeserializer {
    public static int m5598a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[6];
        boolean[] zArr = new boolean[1];
        Enum[] enumArr = new Enum[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("block_status")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLBlockStatus.fromString(jsonParser.o());
                } else if (i.equals("country_code")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("display_number")) {
                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("national_number")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("universal_number")) {
                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("__typename")) {
                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(6);
        if (zArr[0]) {
            flatBufferBuilder.a(0, enumArr[0]);
        }
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5599a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5598a(jsonParser, flatBufferBuilder);
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

    public static void m5600a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        if (mutableFlatBuffer.a(i, 0, (short) 0) != (short) 0) {
            jsonGenerator.a("block_status");
            jsonGenerator.b(((GraphQLBlockStatus) mutableFlatBuffer.a(i, 0, GraphQLBlockStatus.class)).name());
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("country_code");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("display_number");
            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("national_number");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        if (mutableFlatBuffer.g(i, 4) != 0) {
            jsonGenerator.a("universal_number");
            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("__typename");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        jsonGenerator.g();
    }
}

package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLDateGranularity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: pickupDeliveryInfo */
public class GraphQLBackdatedTimeDeserializer {
    public static int m4605a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        boolean[] zArr = new boolean[2];
        long[] jArr = new long[1];
        Enum[] enumArr = new Enum[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("granularity")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLDateGranularity.fromString(jsonParser.o());
                } else if (i.equals("time")) {
                    zArr[1] = true;
                    jArr[0] = jsonParser.F();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(2);
        if (zArr[0]) {
            flatBufferBuilder.a(0, enumArr[0]);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(1, jArr[0], 0);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4606a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4605a(jsonParser, flatBufferBuilder);
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

    public static void m4607a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        if (mutableFlatBuffer.a(i, 0, (short) 0) != (short) 0) {
            jsonGenerator.a("granularity");
            jsonGenerator.b(((GraphQLDateGranularity) mutableFlatBuffer.a(i, 0, GraphQLDateGranularity.class)).name());
        }
        long a = mutableFlatBuffer.a(i, 1, 0);
        if (a != 0) {
            jsonGenerator.a("time");
            jsonGenerator.a(a);
        }
        jsonGenerator.g();
    }
}

package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: message_summary */
public class GraphQLVideoGuidedTourKeyframeDeserializer {
    public static int m6190a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        boolean[] zArr = new boolean[3];
        int[] iArr = new int[2];
        long[] jArr = new long[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("pitch")) {
                    zArr[0] = true;
                    iArr[0] = jsonParser.E();
                } else if (i.equals("timestamp")) {
                    zArr[1] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("yaw")) {
                    zArr[2] = true;
                    iArr[1] = jsonParser.E();
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
            flatBufferBuilder.a(1, jArr[0], 0);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(2, iArr[1], 0);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m6191a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m6190a(jsonParser, flatBufferBuilder);
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

    public static void m6192a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        int a = mutableFlatBuffer.a(i, 0, 0);
        if (a != 0) {
            jsonGenerator.a("pitch");
            jsonGenerator.b(a);
        }
        long a2 = mutableFlatBuffer.a(i, 1, 0);
        if (a2 != 0) {
            jsonGenerator.a("timestamp");
            jsonGenerator.a(a2);
        }
        a = mutableFlatBuffer.a(i, 2, 0);
        if (a != 0) {
            jsonGenerator.a("yaw");
            jsonGenerator.b(a);
        }
        jsonGenerator.g();
    }
}

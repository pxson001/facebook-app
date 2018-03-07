package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: originalRun */
public class GraphQLHoldoutAdFeedUnitDeserializer {
    public static int m5216a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[9];
        boolean[] zArr = new boolean[2];
        int[] iArr2 = new int[1];
        long[] jArr = new long[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("cache_id")) {
                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("debug_info")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("fetchTimeMs")) {
                    zArr[0] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("short_term_cache_key")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("sponsored_data")) {
                    iArr[4] = GraphQLSponsoredDataDeserializer.m5921a(jsonParser, flatBufferBuilder);
                } else if (i.equals("tracking")) {
                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("local_last_negative_feedback_action_type")) {
                    iArr[6] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("local_story_visibility")) {
                    iArr[7] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("local_story_visible_height")) {
                    zArr[1] = true;
                    iArr2[0] = jsonParser.E();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(9);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        if (zArr[0]) {
            flatBufferBuilder.a(2, jArr[0], 0);
        }
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        if (zArr[1]) {
            flatBufferBuilder.a(8, iArr2[0], 0);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5217a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5216a(jsonParser, flatBufferBuilder);
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

    public static void m5218a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("cache_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("debug_info");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        long a = mutableFlatBuffer.a(i, 2, 0);
        if (a != 0) {
            jsonGenerator.a("fetchTimeMs");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("short_term_cache_key");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        int g = mutableFlatBuffer.g(i, 4);
        if (g != 0) {
            jsonGenerator.a("sponsored_data");
            GraphQLSponsoredDataDeserializer.m5923a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("tracking");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        if (mutableFlatBuffer.g(i, 6) != 0) {
            jsonGenerator.a("local_last_negative_feedback_action_type");
            jsonGenerator.b(mutableFlatBuffer.c(i, 6));
        }
        if (mutableFlatBuffer.g(i, 7) != 0) {
            jsonGenerator.a("local_story_visibility");
            jsonGenerator.b(mutableFlatBuffer.c(i, 7));
        }
        g = mutableFlatBuffer.a(i, 8, 0);
        if (g != 0) {
            jsonGenerator.a("local_story_visible_height");
            jsonGenerator.b(g);
        }
        jsonGenerator.g();
    }
}

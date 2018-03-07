package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: photo_stories */
public class GraphQLClientBumpingPlaceHolderFeedUnitDeserializer {
    public static int m4651a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[6];
        boolean[] zArr = new boolean[1];
        long[] jArr = new long[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("bump_story_deduplication_key")) {
                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("cache_id")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("debug_info")) {
                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("fetchTimeMs")) {
                    zArr[0] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("short_term_cache_key")) {
                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("tracking")) {
                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(6);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        if (zArr[0]) {
            flatBufferBuilder.a(3, jArr[0], 0);
        }
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4652a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4651a(jsonParser, flatBufferBuilder);
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

    public static void m4653a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("bump_story_deduplication_key");
            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("cache_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("debug_info");
            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
        }
        long a = mutableFlatBuffer.a(i, 3, 0);
        if (a != 0) {
            jsonGenerator.a("fetchTimeMs");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 4) != 0) {
            jsonGenerator.a("short_term_cache_key");
            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("tracking");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        jsonGenerator.g();
    }
}

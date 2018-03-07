package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLFriendsLocationsFeedType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: page_post_like_story */
public class GraphQLFriendsLocationsFeedUnitDeserializer {
    public static int m4956a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[12];
        boolean[] zArr = new boolean[3];
        long[] jArr = new long[2];
        Enum[] enumArr = new Enum[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("cache_id")) {
                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("creation_time")) {
                    zArr[0] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("debug_info")) {
                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("description")) {
                    iArr[3] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("fetchTimeMs")) {
                    zArr[1] = true;
                    jArr[1] = jsonParser.F();
                } else if (i.equals("footer")) {
                    iArr[5] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friendsLocationsItems")) {
                    iArr[6] = GraphQLFriendLocationFeedUnitItemDeserializer.m4937b(jsonParser, flatBufferBuilder);
                } else if (i.equals("items")) {
                    iArr[7] = GraphQLFriendLocationFeedUnitItemDeserializer.m4937b(jsonParser, flatBufferBuilder);
                } else if (i.equals("short_term_cache_key")) {
                    iArr[8] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("title")) {
                    iArr[9] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("tracking")) {
                    iArr[10] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("feed_type")) {
                    zArr[2] = true;
                    enumArr[0] = GraphQLFriendsLocationsFeedType.fromString(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(12);
        flatBufferBuilder.b(0, iArr[0]);
        if (zArr[0]) {
            flatBufferBuilder.a(1, jArr[0], 0);
        }
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        if (zArr[1]) {
            flatBufferBuilder.a(4, jArr[1], 0);
        }
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        if (zArr[2]) {
            flatBufferBuilder.a(11, enumArr[0]);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4957a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4956a(jsonParser, flatBufferBuilder);
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

    public static void m4958a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("cache_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
        }
        long a = mutableFlatBuffer.a(i, 1, 0);
        if (a != 0) {
            jsonGenerator.a("creation_time");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("debug_info");
            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
        }
        int g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("description");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 4, 0);
        if (a != 0) {
            jsonGenerator.a("fetchTimeMs");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 5);
        if (g != 0) {
            jsonGenerator.a("footer");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 6);
        if (g != 0) {
            jsonGenerator.a("friendsLocationsItems");
            GraphQLFriendLocationFeedUnitItemDeserializer.m4936a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 7);
        if (g != 0) {
            jsonGenerator.a("items");
            GraphQLFriendLocationFeedUnitItemDeserializer.m4936a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 8) != 0) {
            jsonGenerator.a("short_term_cache_key");
            jsonGenerator.b(mutableFlatBuffer.c(i, 8));
        }
        g = mutableFlatBuffer.g(i, 9);
        if (g != 0) {
            jsonGenerator.a("title");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 10) != 0) {
            jsonGenerator.a("tracking");
            jsonGenerator.b(mutableFlatBuffer.c(i, 10));
        }
        if (mutableFlatBuffer.a(i, 11, (short) 0) != (short) 0) {
            jsonGenerator.a("feed_type");
            jsonGenerator.b(((GraphQLFriendsLocationsFeedType) mutableFlatBuffer.a(i, 11, GraphQLFriendsLocationsFeedType.class)).name());
        }
        jsonGenerator.g();
    }
}

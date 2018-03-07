package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: page_like_invite_card */
public class GraphQLGoodwillAnniversaryCampaignFeedUnitDeserializer {
    public static int m4999a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[12];
        boolean[] zArr = new boolean[2];
        int[] iArr2 = new int[1];
        long[] jArr = new long[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("anniversary_campaign")) {
                    iArr[0] = GraphQLGoodwillAnniversaryCampaignDeserializer.m4996a(jsonParser, flatBufferBuilder);
                } else if (i.equals("cache_id")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("debug_info")) {
                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("fetchTimeMs")) {
                    zArr[0] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("hideable_token")) {
                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("negative_feedback_actions")) {
                    iArr[5] = GraphQLNegativeFeedbackActionsConnectionDeserializer.m5415a(jsonParser, flatBufferBuilder);
                } else if (i.equals("render_style")) {
                    iArr[6] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("short_term_cache_key")) {
                    iArr[7] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("tracking")) {
                    iArr[8] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("local_last_negative_feedback_action_type")) {
                    iArr[9] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("local_story_visibility")) {
                    iArr[10] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("local_story_visible_height")) {
                    zArr[1] = true;
                    iArr2[0] = jsonParser.E();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(12);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        if (zArr[0]) {
            flatBufferBuilder.a(3, jArr[0], 0);
        }
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        if (zArr[1]) {
            flatBufferBuilder.a(11, iArr2[0], 0);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5000a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4999a(jsonParser, flatBufferBuilder);
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

    public static void m5001a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("anniversary_campaign");
            GraphQLGoodwillAnniversaryCampaignDeserializer.m4998a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
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
            jsonGenerator.a("hideable_token");
            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
        }
        g = mutableFlatBuffer.g(i, 5);
        if (g != 0) {
            jsonGenerator.a("negative_feedback_actions");
            GraphQLNegativeFeedbackActionsConnectionDeserializer.m5417a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 6) != 0) {
            jsonGenerator.a("render_style");
            jsonGenerator.b(mutableFlatBuffer.c(i, 6));
        }
        if (mutableFlatBuffer.g(i, 7) != 0) {
            jsonGenerator.a("short_term_cache_key");
            jsonGenerator.b(mutableFlatBuffer.c(i, 7));
        }
        if (mutableFlatBuffer.g(i, 8) != 0) {
            jsonGenerator.a("tracking");
            jsonGenerator.b(mutableFlatBuffer.c(i, 8));
        }
        if (mutableFlatBuffer.g(i, 9) != 0) {
            jsonGenerator.a("local_last_negative_feedback_action_type");
            jsonGenerator.b(mutableFlatBuffer.c(i, 9));
        }
        if (mutableFlatBuffer.g(i, 10) != 0) {
            jsonGenerator.a("local_story_visibility");
            jsonGenerator.b(mutableFlatBuffer.c(i, 10));
        }
        g = mutableFlatBuffer.a(i, 11, 0);
        if (g != 0) {
            jsonGenerator.a("local_story_visible_height");
            jsonGenerator.b(g);
        }
        jsonGenerator.g();
    }
}

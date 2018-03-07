package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: mobile_groups_dash */
public class GraphQLSurveyFeedUnitDeserializer {
    public static int m6023a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[18];
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
                } else if (i.equals("hideable_token")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("short_term_cache_key")) {
                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("sponsored_data")) {
                    iArr[5] = GraphQLSponsoredDataDeserializer.m5921a(jsonParser, flatBufferBuilder);
                } else if (i.equals("surveyActor")) {
                    iArr[6] = GraphQLActorDeserializer.m4517a(jsonParser, flatBufferBuilder);
                } else if (i.equals("surveyContent")) {
                    iArr[7] = GraphQLStructuredSurveyDeserializer.m6000a(jsonParser, flatBufferBuilder);
                } else if (i.equals("surveyHideableToken")) {
                    iArr[8] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("surveyResponse")) {
                    iArr[9] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("surveySponsoredData")) {
                    iArr[10] = GraphQLSponsoredDataDeserializer.m5921a(jsonParser, flatBufferBuilder);
                } else if (i.equals("surveyTitle")) {
                    iArr[11] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("surveyTracking")) {
                    iArr[12] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("title")) {
                    iArr[13] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("tracking")) {
                    iArr[14] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("local_last_negative_feedback_action_type")) {
                    iArr[15] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("local_story_visibility")) {
                    iArr[16] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("local_story_visible_height")) {
                    zArr[1] = true;
                    iArr2[0] = jsonParser.E();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(18);
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
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        flatBufferBuilder.b(12, iArr[12]);
        flatBufferBuilder.b(13, iArr[13]);
        flatBufferBuilder.b(14, iArr[14]);
        flatBufferBuilder.b(15, iArr[15]);
        flatBufferBuilder.b(16, iArr[16]);
        if (zArr[1]) {
            flatBufferBuilder.a(17, iArr2[0], 0);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m6024a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m6023a(jsonParser, flatBufferBuilder);
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

    public static void m6025a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
            jsonGenerator.a("hideable_token");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        if (mutableFlatBuffer.g(i, 4) != 0) {
            jsonGenerator.a("short_term_cache_key");
            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
        }
        int g = mutableFlatBuffer.g(i, 5);
        if (g != 0) {
            jsonGenerator.a("sponsored_data");
            GraphQLSponsoredDataDeserializer.m5923a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 6);
        if (g != 0) {
            jsonGenerator.a("surveyActor");
            GraphQLActorDeserializer.m4521b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 7);
        if (g != 0) {
            jsonGenerator.a("surveyContent");
            GraphQLStructuredSurveyDeserializer.m6002a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 8) != 0) {
            jsonGenerator.a("surveyHideableToken");
            jsonGenerator.b(mutableFlatBuffer.c(i, 8));
        }
        if (mutableFlatBuffer.g(i, 9) != 0) {
            jsonGenerator.a("surveyResponse");
            jsonGenerator.b(mutableFlatBuffer.c(i, 9));
        }
        g = mutableFlatBuffer.g(i, 10);
        if (g != 0) {
            jsonGenerator.a("surveySponsoredData");
            GraphQLSponsoredDataDeserializer.m5923a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 11);
        if (g != 0) {
            jsonGenerator.a("surveyTitle");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 12) != 0) {
            jsonGenerator.a("surveyTracking");
            jsonGenerator.b(mutableFlatBuffer.c(i, 12));
        }
        g = mutableFlatBuffer.g(i, 13);
        if (g != 0) {
            jsonGenerator.a("title");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 14) != 0) {
            jsonGenerator.a("tracking");
            jsonGenerator.b(mutableFlatBuffer.c(i, 14));
        }
        if (mutableFlatBuffer.g(i, 15) != 0) {
            jsonGenerator.a("local_last_negative_feedback_action_type");
            jsonGenerator.b(mutableFlatBuffer.c(i, 15));
        }
        if (mutableFlatBuffer.g(i, 16) != 0) {
            jsonGenerator.a("local_story_visibility");
            jsonGenerator.b(mutableFlatBuffer.c(i, 16));
        }
        g = mutableFlatBuffer.a(i, 17, 0);
        if (g != 0) {
            jsonGenerator.a("local_story_visible_height");
            jsonGenerator.b(g);
        }
        jsonGenerator.g();
    }
}

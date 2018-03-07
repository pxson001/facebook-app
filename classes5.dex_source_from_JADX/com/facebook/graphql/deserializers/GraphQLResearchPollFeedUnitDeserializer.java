package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: national_number */
public class GraphQLResearchPollFeedUnitDeserializer {
    public static int m5810a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[27];
        boolean[] zArr = new boolean[4];
        boolean[] zArr2 = new boolean[2];
        int[] iArr2 = new int[1];
        long[] jArr = new long[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("ad_impression")) {
                    iArr[0] = GraphQLSponsoredDataDeserializer.m5921a(jsonParser, flatBufferBuilder);
                } else if (i.equals("cache_id")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("checkbox_question_prompt")) {
                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("confirmation_text")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("debug_info")) {
                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("fetchTimeMs")) {
                    zArr[0] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("hideable_token")) {
                    iArr[6] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("id")) {
                    iArr[7] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("initial_card_prompt")) {
                    iArr[8] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("negative_feedback_actions")) {
                    iArr[9] = GraphQLNegativeFeedbackActionsConnectionDeserializer.m5415a(jsonParser, flatBufferBuilder);
                } else if (i.equals("privacy_disclaimer")) {
                    iArr[10] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("radio_question_prompt")) {
                    iArr[11] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("research_poll")) {
                    iArr[12] = GraphQLResearchPollSurveyDeserializer.m5830a(jsonParser, flatBufferBuilder);
                } else if (i.equals("see_results_prompt")) {
                    iArr[13] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("short_term_cache_key")) {
                    iArr[15] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("should_auto_open")) {
                    zArr[1] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("should_auto_submit")) {
                    zArr[2] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("sponsored_label")) {
                    iArr[18] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("submit_answer_prompt")) {
                    iArr[19] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("title")) {
                    iArr[20] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("titleForSummary")) {
                    iArr[21] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("tracking")) {
                    iArr[22] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("url")) {
                    iArr[23] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("local_last_negative_feedback_action_type")) {
                    iArr[24] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("local_story_visibility")) {
                    iArr[25] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("local_story_visible_height")) {
                    zArr[3] = true;
                    iArr2[0] = jsonParser.E();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(27);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(4, iArr[4]);
        if (zArr[0]) {
            flatBufferBuilder.a(5, jArr[0], 0);
        }
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        flatBufferBuilder.b(12, iArr[12]);
        flatBufferBuilder.b(13, iArr[13]);
        flatBufferBuilder.b(15, iArr[15]);
        if (zArr[1]) {
            flatBufferBuilder.a(16, zArr2[0]);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(17, zArr2[1]);
        }
        flatBufferBuilder.b(18, iArr[18]);
        flatBufferBuilder.b(19, iArr[19]);
        flatBufferBuilder.b(20, iArr[20]);
        flatBufferBuilder.b(21, iArr[21]);
        flatBufferBuilder.b(22, iArr[22]);
        flatBufferBuilder.b(23, iArr[23]);
        flatBufferBuilder.b(24, iArr[24]);
        flatBufferBuilder.b(25, iArr[25]);
        if (zArr[3]) {
            flatBufferBuilder.a(26, iArr2[0], 0);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5811a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5810a(jsonParser, flatBufferBuilder);
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

    public static void m5812a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("ad_impression");
            GraphQLSponsoredDataDeserializer.m5923a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("cache_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("checkbox_question_prompt");
            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("confirmation_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        if (mutableFlatBuffer.g(i, 4) != 0) {
            jsonGenerator.a("debug_info");
            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
        }
        long a = mutableFlatBuffer.a(i, 5, 0);
        if (a != 0) {
            jsonGenerator.a("fetchTimeMs");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 6) != 0) {
            jsonGenerator.a("hideable_token");
            jsonGenerator.b(mutableFlatBuffer.c(i, 6));
        }
        if (mutableFlatBuffer.g(i, 7) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 7));
        }
        if (mutableFlatBuffer.g(i, 8) != 0) {
            jsonGenerator.a("initial_card_prompt");
            jsonGenerator.b(mutableFlatBuffer.c(i, 8));
        }
        g = mutableFlatBuffer.g(i, 9);
        if (g != 0) {
            jsonGenerator.a("negative_feedback_actions");
            GraphQLNegativeFeedbackActionsConnectionDeserializer.m5417a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 10) != 0) {
            jsonGenerator.a("privacy_disclaimer");
            jsonGenerator.b(mutableFlatBuffer.c(i, 10));
        }
        if (mutableFlatBuffer.g(i, 11) != 0) {
            jsonGenerator.a("radio_question_prompt");
            jsonGenerator.b(mutableFlatBuffer.c(i, 11));
        }
        g = mutableFlatBuffer.g(i, 12);
        if (g != 0) {
            jsonGenerator.a("research_poll");
            GraphQLResearchPollSurveyDeserializer.m5832a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 13) != 0) {
            jsonGenerator.a("see_results_prompt");
            jsonGenerator.b(mutableFlatBuffer.c(i, 13));
        }
        if (mutableFlatBuffer.g(i, 15) != 0) {
            jsonGenerator.a("short_term_cache_key");
            jsonGenerator.b(mutableFlatBuffer.c(i, 15));
        }
        boolean a2 = mutableFlatBuffer.a(i, 16);
        if (a2) {
            jsonGenerator.a("should_auto_open");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 17);
        if (a2) {
            jsonGenerator.a("should_auto_submit");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.g(i, 18) != 0) {
            jsonGenerator.a("sponsored_label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 18));
        }
        if (mutableFlatBuffer.g(i, 19) != 0) {
            jsonGenerator.a("submit_answer_prompt");
            jsonGenerator.b(mutableFlatBuffer.c(i, 19));
        }
        g = mutableFlatBuffer.g(i, 20);
        if (g != 0) {
            jsonGenerator.a("title");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 21);
        if (g != 0) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 22) != 0) {
            jsonGenerator.a("tracking");
            jsonGenerator.b(mutableFlatBuffer.c(i, 22));
        }
        if (mutableFlatBuffer.g(i, 23) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 23));
        }
        if (mutableFlatBuffer.g(i, 24) != 0) {
            jsonGenerator.a("local_last_negative_feedback_action_type");
            jsonGenerator.b(mutableFlatBuffer.c(i, 24));
        }
        if (mutableFlatBuffer.g(i, 25) != 0) {
            jsonGenerator.a("local_story_visibility");
            jsonGenerator.b(mutableFlatBuffer.c(i, 25));
        }
        g = mutableFlatBuffer.a(i, 26, 0);
        if (g != 0) {
            jsonGenerator.a("local_story_visible_height");
            jsonGenerator.b(g);
        }
        jsonGenerator.g();
    }
}

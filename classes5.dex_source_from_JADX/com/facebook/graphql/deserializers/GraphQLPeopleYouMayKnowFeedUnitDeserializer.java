package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.enums.GraphQLSubstoriesGroupingReason;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: no_link */
public class GraphQLPeopleYouMayKnowFeedUnitDeserializer {
    public static int m5584a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[28];
        boolean[] zArr = new boolean[4];
        int[] iArr2 = new int[1];
        long[] jArr = new long[2];
        Enum[] enumArr = new Enum[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("action_links")) {
                    iArr[0] = GraphQLStoryActionLinkDeserializer.m5951b(jsonParser, flatBufferBuilder);
                } else if (i.equals("actors")) {
                    iArr[1] = GraphQLActorDeserializer.m4520b(jsonParser, flatBufferBuilder);
                } else if (i.equals("attachments")) {
                    iArr[2] = GraphQLStoryAttachmentDeserializer.m5956b(jsonParser, flatBufferBuilder);
                } else if (i.equals("cache_id")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("creation_time")) {
                    zArr[0] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("debug_info")) {
                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("feedback")) {
                    iArr[6] = GraphQLFeedbackDeserializer.m4892a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feedback_context")) {
                    iArr[7] = GraphQLFeedbackContextDeserializer.m4889a(jsonParser, flatBufferBuilder);
                } else if (i.equals("fetchTimeMs")) {
                    zArr[1] = true;
                    jArr[1] = jsonParser.F();
                } else if (i.equals("hideable_token")) {
                    iArr[9] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("items")) {
                    iArr[10] = GraphQLPeopleYouMayKnowFeedUnitItemDeserializer.m5590b(jsonParser, flatBufferBuilder);
                } else if (i.equals("message")) {
                    iArr[11] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("multiShareAttachmentWithImageFields")) {
                    iArr[12] = GraphQLStoryAttachmentDeserializer.m5956b(jsonParser, flatBufferBuilder);
                } else if (i.equals("negative_feedback_actions")) {
                    iArr[13] = GraphQLNegativeFeedbackActionsConnectionDeserializer.m5415a(jsonParser, flatBufferBuilder);
                } else if (i.equals("privacy_scope")) {
                    iArr[14] = GraphQLPrivacyScopeDeserializer.m5705a(jsonParser, flatBufferBuilder);
                } else if (i.equals("pymkItems")) {
                    iArr[15] = GraphQLPeopleYouMayKnowFeedUnitItemDeserializer.m5590b(jsonParser, flatBufferBuilder);
                } else if (i.equals("seen_state")) {
                    zArr[2] = true;
                    enumArr[0] = GraphQLStorySeenState.fromString(jsonParser.o());
                } else if (i.equals("shareable")) {
                    iArr[17] = GraphQLEntityDeserializer.m4763a(jsonParser, flatBufferBuilder);
                } else if (i.equals("short_term_cache_key")) {
                    iArr[18] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("story_header")) {
                    iArr[20] = GraphQLStoryHeaderDeserializer.m5970a(jsonParser, flatBufferBuilder);
                } else if (i.equals("substories_grouping_reasons")) {
                    iArr[21] = DeserializerHelpers.a(jsonParser, flatBufferBuilder, GraphQLSubstoriesGroupingReason.class);
                } else if (i.equals("title")) {
                    iArr[23] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("tracking")) {
                    iArr[24] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("local_last_negative_feedback_action_type")) {
                    iArr[25] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("local_story_visibility")) {
                    iArr[26] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("local_story_visible_height")) {
                    zArr[3] = true;
                    iArr2[0] = jsonParser.E();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(28);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        if (zArr[0]) {
            flatBufferBuilder.a(4, jArr[0], 0);
        }
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        if (zArr[1]) {
            flatBufferBuilder.a(8, jArr[1], 0);
        }
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        flatBufferBuilder.b(12, iArr[12]);
        flatBufferBuilder.b(13, iArr[13]);
        flatBufferBuilder.b(14, iArr[14]);
        flatBufferBuilder.b(15, iArr[15]);
        if (zArr[2]) {
            flatBufferBuilder.a(16, enumArr[0]);
        }
        flatBufferBuilder.b(17, iArr[17]);
        flatBufferBuilder.b(18, iArr[18]);
        flatBufferBuilder.b(20, iArr[20]);
        flatBufferBuilder.b(21, iArr[21]);
        flatBufferBuilder.b(23, iArr[23]);
        flatBufferBuilder.b(24, iArr[24]);
        flatBufferBuilder.b(25, iArr[25]);
        flatBufferBuilder.b(26, iArr[26]);
        if (zArr[3]) {
            flatBufferBuilder.a(27, iArr2[0], 0);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5585a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5584a(jsonParser, flatBufferBuilder);
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

    public static void m5586a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("action_links");
            GraphQLStoryActionLinkDeserializer.m5950a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("actors");
            GraphQLActorDeserializer.m4519a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("attachments");
            GraphQLStoryAttachmentDeserializer.m5955a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("cache_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        long a = mutableFlatBuffer.a(i, 4, 0);
        if (a != 0) {
            jsonGenerator.a("creation_time");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("debug_info");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        g = mutableFlatBuffer.g(i, 6);
        if (g != 0) {
            jsonGenerator.a("feedback");
            GraphQLFeedbackDeserializer.m4895b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 7);
        if (g != 0) {
            jsonGenerator.a("feedback_context");
            GraphQLFeedbackContextDeserializer.m4891a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 8, 0);
        if (a != 0) {
            jsonGenerator.a("fetchTimeMs");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 9) != 0) {
            jsonGenerator.a("hideable_token");
            jsonGenerator.b(mutableFlatBuffer.c(i, 9));
        }
        g = mutableFlatBuffer.g(i, 10);
        if (g != 0) {
            jsonGenerator.a("items");
            GraphQLPeopleYouMayKnowFeedUnitItemDeserializer.m5589a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 11);
        if (g != 0) {
            jsonGenerator.a("message");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 12);
        if (g != 0) {
            jsonGenerator.a("multiShareAttachmentWithImageFields");
            GraphQLStoryAttachmentDeserializer.m5955a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 13);
        if (g != 0) {
            jsonGenerator.a("negative_feedback_actions");
            GraphQLNegativeFeedbackActionsConnectionDeserializer.m5417a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 14);
        if (g != 0) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScopeDeserializer.m5707a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 15);
        if (g != 0) {
            jsonGenerator.a("pymkItems");
            GraphQLPeopleYouMayKnowFeedUnitItemDeserializer.m5589a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 16, (short) 0) != (short) 0) {
            jsonGenerator.a("seen_state");
            jsonGenerator.b(((GraphQLStorySeenState) mutableFlatBuffer.a(i, 16, GraphQLStorySeenState.class)).name());
        }
        g = mutableFlatBuffer.g(i, 17);
        if (g != 0) {
            jsonGenerator.a("shareable");
            GraphQLEntityDeserializer.m4766b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 18) != 0) {
            jsonGenerator.a("short_term_cache_key");
            jsonGenerator.b(mutableFlatBuffer.c(i, 18));
        }
        g = mutableFlatBuffer.g(i, 20);
        if (g != 0) {
            jsonGenerator.a("story_header");
            GraphQLStoryHeaderDeserializer.m5972a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 21) != 0) {
            jsonGenerator.a("substories_grouping_reasons");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 21), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 23);
        if (g != 0) {
            jsonGenerator.a("title");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 24) != 0) {
            jsonGenerator.a("tracking");
            jsonGenerator.b(mutableFlatBuffer.c(i, 24));
        }
        if (mutableFlatBuffer.g(i, 25) != 0) {
            jsonGenerator.a("local_last_negative_feedback_action_type");
            jsonGenerator.b(mutableFlatBuffer.c(i, 25));
        }
        if (mutableFlatBuffer.g(i, 26) != 0) {
            jsonGenerator.a("local_story_visibility");
            jsonGenerator.b(mutableFlatBuffer.c(i, 26));
        }
        g = mutableFlatBuffer.a(i, 27, 0);
        if (g != 0) {
            jsonGenerator.a("local_story_visible_height");
            jsonGenerator.b(g);
        }
        jsonGenerator.g();
    }
}

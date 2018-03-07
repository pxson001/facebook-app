package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: page_timeline_liked_pages */
public class GraphQLFeedbackDeserializer {
    public static int m4892a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[48];
        boolean[] zArr = new boolean[17];
        boolean[] zArr2 = new boolean[15];
        int[] iArr2 = new int[1];
        long[] jArr = new long[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("can_see_voice_switcher")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("can_viewer_comment")) {
                    zArr[1] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("can_viewer_comment_with_photo")) {
                    zArr[2] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("can_viewer_comment_with_sticker")) {
                    zArr[3] = true;
                    zArr2[3] = jsonParser.H();
                } else if (i.equals("can_viewer_comment_with_video")) {
                    zArr[4] = true;
                    zArr2[4] = jsonParser.H();
                } else if (i.equals("can_viewer_like")) {
                    zArr[5] = true;
                    zArr2[5] = jsonParser.H();
                } else if (i.equals("can_viewer_react")) {
                    zArr[6] = true;
                    zArr2[6] = jsonParser.H();
                } else if (i.equals("can_viewer_subscribe")) {
                    zArr[7] = true;
                    zArr2[7] = jsonParser.H();
                } else if (i.equals("comments")) {
                    iArr[9] = GraphQLCommentsConnectionDeserializer.m4665a(jsonParser, flatBufferBuilder);
                } else if (i.equals("comments_disabled_notice")) {
                    iArr[10] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("comments_mirroring_domain")) {
                    iArr[11] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("default_comment_ordering")) {
                    iArr[12] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("display_reactions")) {
                    zArr[8] = true;
                    zArr2[8] = jsonParser.H();
                } else if (i.equals("does_viewer_like")) {
                    zArr[9] = true;
                    zArr2[9] = jsonParser.H();
                } else if (i.equals("dont_append_here")) {
                    zArr[10] = true;
                    zArr2[10] = jsonParser.H();
                } else if (i.equals("fetchTimeMs")) {
                    zArr[11] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("has_viewer_commented_recently")) {
                    zArr[12] = true;
                    zArr2[11] = jsonParser.H();
                } else if (i.equals("have_comments_been_disabled")) {
                    zArr[13] = true;
                    zArr2[12] = jsonParser.H();
                } else if (i.equals("id")) {
                    iArr[19] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("interactors_friend")) {
                    iArr[20] = GraphQLInteractorsConnectionDeserializer.m5271a(jsonParser, flatBufferBuilder);
                } else if (i.equals("interactors_not_friend")) {
                    iArr[21] = GraphQLInteractorsConnectionDeserializer.m5271a(jsonParser, flatBufferBuilder);
                } else if (i.equals("is_viewer_subscribed")) {
                    zArr[14] = true;
                    zArr2[13] = jsonParser.H();
                } else if (i.equals("legacy_api_post_id")) {
                    iArr[23] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("like_sentence")) {
                    iArr[24] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("likers")) {
                    iArr[25] = GraphQLLikersOfContentConnectionDeserializer.m5318a(jsonParser, flatBufferBuilder);
                } else if (i.equals("mostRecentTopLevelComments")) {
                    iArr[26] = GraphQLTopLevelCommentsConnectionDeserializer.m6101a(jsonParser, flatBufferBuilder);
                } else if (i.equals("reactors")) {
                    iArr[27] = GraphQLReactorsOfContentConnectionDeserializer.m5787a(jsonParser, flatBufferBuilder);
                } else if (i.equals("real_time_activity_info")) {
                    iArr[28] = GraphQLFeedbackRealTimeActivityInfoDeserializer.m4907a(jsonParser, flatBufferBuilder);
                } else if (i.equals("remixable_photo_uri")) {
                    iArr[30] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("reshares")) {
                    iArr[31] = GraphQLResharesOfContentConnectionDeserializer.m5839a(jsonParser, flatBufferBuilder);
                } else if (i.equals("seen_by")) {
                    iArr[32] = GraphQLSeenByConnectionDeserializer.m5877a(jsonParser, flatBufferBuilder);
                } else if (i.equals("should_use_likers_sentence")) {
                    zArr[15] = true;
                    zArr2[14] = jsonParser.H();
                } else if (i.equals("supported_reactions")) {
                    iArr[34] = GraphQLFeedbackReactionDeserializer.m4900b(jsonParser, flatBufferBuilder);
                } else if (i.equals("top_level_comments")) {
                    iArr[35] = GraphQLTopLevelCommentsConnectionDeserializer.m6101a(jsonParser, flatBufferBuilder);
                } else if (i.equals("top_reactions")) {
                    iArr[36] = GraphQLTopReactionsConnectionDeserializer.m6104a(jsonParser, flatBufferBuilder);
                } else if (i.equals("url")) {
                    iArr[37] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("viewer_acts_as_page")) {
                    iArr[38] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_does_not_like_reaction_sentence_as_string")) {
                    iArr[39] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("viewer_does_not_like_sentence")) {
                    iArr[40] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_feedback_reaction")) {
                    iArr[41] = GraphQLFeedbackReactionDeserializer.m4896a(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_feedback_reaction_key")) {
                    zArr[16] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("viewer_likes_reaction_sentence_as_string")) {
                    iArr[43] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("viewer_likes_sentence")) {
                    iArr[44] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_timestamped_comments")) {
                    iArr[45] = GraphQLVideoTimestampedCommentsConnectionDeserializer.m6193a(jsonParser, flatBufferBuilder);
                } else if (i.equals("important_reactors")) {
                    iArr[46] = GraphQLImportantReactorsConnectionDeserializer.m5231a(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_acts_as_person")) {
                    iArr[47] = GraphQLUserDeserializer.m6148a(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(48);
        if (zArr[0]) {
            flatBufferBuilder.a(1, zArr2[0]);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(2, zArr2[1]);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(3, zArr2[2]);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(4, zArr2[3]);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(5, zArr2[4]);
        }
        if (zArr[5]) {
            flatBufferBuilder.a(6, zArr2[5]);
        }
        if (zArr[6]) {
            flatBufferBuilder.a(7, zArr2[6]);
        }
        if (zArr[7]) {
            flatBufferBuilder.a(8, zArr2[7]);
        }
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        flatBufferBuilder.b(12, iArr[12]);
        if (zArr[8]) {
            flatBufferBuilder.a(13, zArr2[8]);
        }
        if (zArr[9]) {
            flatBufferBuilder.a(14, zArr2[9]);
        }
        if (zArr[10]) {
            flatBufferBuilder.a(15, zArr2[10]);
        }
        if (zArr[11]) {
            flatBufferBuilder.a(16, jArr[0], 0);
        }
        if (zArr[12]) {
            flatBufferBuilder.a(17, zArr2[11]);
        }
        if (zArr[13]) {
            flatBufferBuilder.a(18, zArr2[12]);
        }
        flatBufferBuilder.b(19, iArr[19]);
        flatBufferBuilder.b(20, iArr[20]);
        flatBufferBuilder.b(21, iArr[21]);
        if (zArr[14]) {
            flatBufferBuilder.a(22, zArr2[13]);
        }
        flatBufferBuilder.b(23, iArr[23]);
        flatBufferBuilder.b(24, iArr[24]);
        flatBufferBuilder.b(25, iArr[25]);
        flatBufferBuilder.b(26, iArr[26]);
        flatBufferBuilder.b(27, iArr[27]);
        flatBufferBuilder.b(28, iArr[28]);
        flatBufferBuilder.b(30, iArr[30]);
        flatBufferBuilder.b(31, iArr[31]);
        flatBufferBuilder.b(32, iArr[32]);
        if (zArr[15]) {
            flatBufferBuilder.a(33, zArr2[14]);
        }
        flatBufferBuilder.b(34, iArr[34]);
        flatBufferBuilder.b(35, iArr[35]);
        flatBufferBuilder.b(36, iArr[36]);
        flatBufferBuilder.b(37, iArr[37]);
        flatBufferBuilder.b(38, iArr[38]);
        flatBufferBuilder.b(39, iArr[39]);
        flatBufferBuilder.b(40, iArr[40]);
        flatBufferBuilder.b(41, iArr[41]);
        if (zArr[16]) {
            flatBufferBuilder.a(42, iArr2[0], 0);
        }
        flatBufferBuilder.b(43, iArr[43]);
        flatBufferBuilder.b(44, iArr[44]);
        flatBufferBuilder.b(45, iArr[45]);
        flatBufferBuilder.b(46, iArr[46]);
        flatBufferBuilder.b(47, iArr[47]);
        return flatBufferBuilder.d();
    }

    public static int m4894b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        ArrayList arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(m4892a(jsonParser, flatBufferBuilder)));
            }
        }
        if (arrayList.isEmpty()) {
            return 0;
        }
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        return flatBufferBuilder.a(iArr, true);
    }

    public static MutableFlatBuffer m4893a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4892a(jsonParser, flatBufferBuilder);
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

    public static void m4895b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        boolean a = mutableFlatBuffer.a(i, 1);
        if (a) {
            jsonGenerator.a("can_see_voice_switcher");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 2);
        if (a) {
            jsonGenerator.a("can_viewer_comment");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 3);
        if (a) {
            jsonGenerator.a("can_viewer_comment_with_photo");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 4);
        if (a) {
            jsonGenerator.a("can_viewer_comment_with_sticker");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 5);
        if (a) {
            jsonGenerator.a("can_viewer_comment_with_video");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 6);
        if (a) {
            jsonGenerator.a("can_viewer_like");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 7);
        if (a) {
            jsonGenerator.a("can_viewer_react");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 8);
        if (a) {
            jsonGenerator.a("can_viewer_subscribe");
            jsonGenerator.a(a);
        }
        int g = mutableFlatBuffer.g(i, 9);
        if (g != 0) {
            jsonGenerator.a("comments");
            GraphQLCommentsConnectionDeserializer.m4667a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 10);
        if (g != 0) {
            jsonGenerator.a("comments_disabled_notice");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 11) != 0) {
            jsonGenerator.a("comments_mirroring_domain");
            jsonGenerator.b(mutableFlatBuffer.c(i, 11));
        }
        if (mutableFlatBuffer.g(i, 12) != 0) {
            jsonGenerator.a("default_comment_ordering");
            jsonGenerator.b(mutableFlatBuffer.c(i, 12));
        }
        a = mutableFlatBuffer.a(i, 13);
        if (a) {
            jsonGenerator.a("display_reactions");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 14);
        if (a) {
            jsonGenerator.a("does_viewer_like");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 15);
        if (a) {
            jsonGenerator.a("dont_append_here");
            jsonGenerator.a(a);
        }
        long a2 = mutableFlatBuffer.a(i, 16, 0);
        if (a2 != 0) {
            jsonGenerator.a("fetchTimeMs");
            jsonGenerator.a(a2);
        }
        a = mutableFlatBuffer.a(i, 17);
        if (a) {
            jsonGenerator.a("has_viewer_commented_recently");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 18);
        if (a) {
            jsonGenerator.a("have_comments_been_disabled");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 19) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 19));
        }
        g = mutableFlatBuffer.g(i, 20);
        if (g != 0) {
            jsonGenerator.a("interactors_friend");
            GraphQLInteractorsConnectionDeserializer.m5273a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 21);
        if (g != 0) {
            jsonGenerator.a("interactors_not_friend");
            GraphQLInteractorsConnectionDeserializer.m5273a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 22);
        if (a) {
            jsonGenerator.a("is_viewer_subscribed");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 23) != 0) {
            jsonGenerator.a("legacy_api_post_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 23));
        }
        g = mutableFlatBuffer.g(i, 24);
        if (g != 0) {
            jsonGenerator.a("like_sentence");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 25);
        if (g != 0) {
            jsonGenerator.a("likers");
            GraphQLLikersOfContentConnectionDeserializer.m5320a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 26);
        if (g != 0) {
            jsonGenerator.a("mostRecentTopLevelComments");
            GraphQLTopLevelCommentsConnectionDeserializer.m6103a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 27);
        if (g != 0) {
            jsonGenerator.a("reactors");
            GraphQLReactorsOfContentConnectionDeserializer.m5789a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 28);
        if (g != 0) {
            jsonGenerator.a("real_time_activity_info");
            GraphQLFeedbackRealTimeActivityInfoDeserializer.m4909a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 30) != 0) {
            jsonGenerator.a("remixable_photo_uri");
            jsonGenerator.b(mutableFlatBuffer.c(i, 30));
        }
        g = mutableFlatBuffer.g(i, 31);
        if (g != 0) {
            jsonGenerator.a("reshares");
            GraphQLResharesOfContentConnectionDeserializer.m5841a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 32);
        if (g != 0) {
            jsonGenerator.a("seen_by");
            GraphQLSeenByConnectionDeserializer.m5879a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 33);
        if (a) {
            jsonGenerator.a("should_use_likers_sentence");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 34);
        if (g != 0) {
            jsonGenerator.a("supported_reactions");
            GraphQLFeedbackReactionDeserializer.m4899a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 35);
        if (g != 0) {
            jsonGenerator.a("top_level_comments");
            GraphQLTopLevelCommentsConnectionDeserializer.m6103a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 36);
        if (g != 0) {
            jsonGenerator.a("top_reactions");
            GraphQLTopReactionsConnectionDeserializer.m6106a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 37) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 37));
        }
        g = mutableFlatBuffer.g(i, 38);
        if (g != 0) {
            jsonGenerator.a("viewer_acts_as_page");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 39) != 0) {
            jsonGenerator.a("viewer_does_not_like_reaction_sentence_as_string");
            jsonGenerator.b(mutableFlatBuffer.c(i, 39));
        }
        g = mutableFlatBuffer.g(i, 40);
        if (g != 0) {
            jsonGenerator.a("viewer_does_not_like_sentence");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 41);
        if (g != 0) {
            jsonGenerator.a("viewer_feedback_reaction");
            GraphQLFeedbackReactionDeserializer.m4898a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.a(i, 42, 0);
        if (g != 0) {
            jsonGenerator.a("viewer_feedback_reaction_key");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 43) != 0) {
            jsonGenerator.a("viewer_likes_reaction_sentence_as_string");
            jsonGenerator.b(mutableFlatBuffer.c(i, 43));
        }
        g = mutableFlatBuffer.g(i, 44);
        if (g != 0) {
            jsonGenerator.a("viewer_likes_sentence");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 45);
        if (g != 0) {
            jsonGenerator.a("video_timestamped_comments");
            GraphQLVideoTimestampedCommentsConnectionDeserializer.m6195a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 46);
        if (g != 0) {
            jsonGenerator.a("important_reactors");
            GraphQLImportantReactorsConnectionDeserializer.m5233a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 47);
        if (g != 0) {
            jsonGenerator.a("viewer_acts_as_person");
            GraphQLUserDeserializer.m6152b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }
}

package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: photo_remix_source */
public class GraphQLCommentDeserializer {
    public static int m4657a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[29];
        boolean[] zArr = new boolean[10];
        boolean[] zArr2 = new boolean[6];
        int[] iArr2 = new int[3];
        long[] jArr = new long[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("approximate_position")) {
                    zArr[0] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("attached_story")) {
                    iArr[1] = GraphQLStoryDeserializer.m5962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("attachments")) {
                    iArr[2] = GraphQLStoryAttachmentDeserializer.m5956b(jsonParser, flatBufferBuilder);
                } else if (i.equals("author")) {
                    iArr[3] = GraphQLActorDeserializer.m4517a(jsonParser, flatBufferBuilder);
                } else if (i.equals("body")) {
                    iArr[4] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("can_viewer_delete")) {
                    zArr[1] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("can_viewer_edit")) {
                    zArr[2] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("comment_parent")) {
                    iArr[7] = m4657a(jsonParser, flatBufferBuilder);
                } else if (i.equals("created_time")) {
                    zArr[3] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("edit_history")) {
                    iArr[9] = GraphQLEditHistoryConnectionDeserializer.m4721a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feedback")) {
                    iArr[10] = GraphQLFeedbackDeserializer.m4892a(jsonParser, flatBufferBuilder);
                } else if (i.equals("id")) {
                    iArr[11] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("interesting_replies")) {
                    iArr[12] = GraphQLInterestingRepliesConnectionDeserializer.m5274a(jsonParser, flatBufferBuilder);
                } else if (i.equals("is_featured")) {
                    zArr[4] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("is_marked_as_spam")) {
                    zArr[5] = true;
                    zArr2[3] = jsonParser.H();
                } else if (i.equals("is_pinned")) {
                    zArr[6] = true;
                    zArr2[4] = jsonParser.H();
                } else if (i.equals("multiShareAttachmentWithImageFields")) {
                    iArr[16] = GraphQLStoryAttachmentDeserializer.m5956b(jsonParser, flatBufferBuilder);
                } else if (i.equals("permalink_title")) {
                    iArr[17] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("privacy_scope")) {
                    iArr[18] = GraphQLPrivacyScopeDeserializer.m5705a(jsonParser, flatBufferBuilder);
                } else if (i.equals("private_reply_context")) {
                    iArr[19] = GraphQLPrivateReplyContextDeserializer.m5708a(jsonParser, flatBufferBuilder);
                } else if (i.equals("request_id")) {
                    iArr[20] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("sort_key")) {
                    zArr[7] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("translatability_for_viewer")) {
                    iArr[22] = GraphQLPostTranslatabilityDeserializer.m5682a(jsonParser, flatBufferBuilder);
                } else if (i.equals("translated_body_for_viewer")) {
                    iArr[23] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("url")) {
                    iArr[24] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("timestamp_in_video")) {
                    zArr[8] = true;
                    iArr2[2] = jsonParser.E();
                } else if (i.equals("written_while_video_was_live")) {
                    zArr[9] = true;
                    zArr2[5] = jsonParser.H();
                } else if (i.equals("parent_feedback")) {
                    iArr[27] = GraphQLFeedbackDeserializer.m4892a(jsonParser, flatBufferBuilder);
                } else if (i.equals("body_markdown_html")) {
                    iArr[28] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(29);
        if (zArr[0]) {
            flatBufferBuilder.a(0, iArr2[0], 0);
        }
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(4, iArr[4]);
        if (zArr[1]) {
            flatBufferBuilder.a(5, zArr2[0]);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(6, zArr2[1]);
        }
        flatBufferBuilder.b(7, iArr[7]);
        if (zArr[3]) {
            flatBufferBuilder.a(8, jArr[0], 0);
        }
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        flatBufferBuilder.b(12, iArr[12]);
        if (zArr[4]) {
            flatBufferBuilder.a(13, zArr2[2]);
        }
        if (zArr[5]) {
            flatBufferBuilder.a(14, zArr2[3]);
        }
        if (zArr[6]) {
            flatBufferBuilder.a(15, zArr2[4]);
        }
        flatBufferBuilder.b(16, iArr[16]);
        flatBufferBuilder.b(17, iArr[17]);
        flatBufferBuilder.b(18, iArr[18]);
        flatBufferBuilder.b(19, iArr[19]);
        flatBufferBuilder.b(20, iArr[20]);
        if (zArr[7]) {
            flatBufferBuilder.a(21, iArr2[1], 0);
        }
        flatBufferBuilder.b(22, iArr[22]);
        flatBufferBuilder.b(23, iArr[23]);
        flatBufferBuilder.b(24, iArr[24]);
        if (zArr[8]) {
            flatBufferBuilder.a(25, iArr2[2], 0);
        }
        if (zArr[9]) {
            flatBufferBuilder.a(26, zArr2[5]);
        }
        flatBufferBuilder.b(27, iArr[27]);
        flatBufferBuilder.b(28, iArr[28]);
        return flatBufferBuilder.d();
    }

    public static int m4660b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        ArrayList arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(m4657a(jsonParser, flatBufferBuilder)));
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

    public static MutableFlatBuffer m4658a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4657a(jsonParser, flatBufferBuilder);
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

    public static void m4659a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.d();
        for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
            m4661b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
        }
        jsonGenerator.e();
    }

    public static void m4661b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int a = mutableFlatBuffer.a(i, 0, 0);
        if (a != 0) {
            jsonGenerator.a("approximate_position");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.g(i, 1);
        if (a != 0) {
            jsonGenerator.a("attached_story");
            GraphQLStoryDeserializer.m5966b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.g(i, 2);
        if (a != 0) {
            jsonGenerator.a("attachments");
            GraphQLStoryAttachmentDeserializer.m5955a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.g(i, 3);
        if (a != 0) {
            jsonGenerator.a("author");
            GraphQLActorDeserializer.m4521b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.g(i, 4);
        if (a != 0) {
            jsonGenerator.a("body");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        boolean a2 = mutableFlatBuffer.a(i, 5);
        if (a2) {
            jsonGenerator.a("can_viewer_delete");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 6);
        if (a2) {
            jsonGenerator.a("can_viewer_edit");
            jsonGenerator.a(a2);
        }
        a = mutableFlatBuffer.g(i, 7);
        if (a != 0) {
            jsonGenerator.a("comment_parent");
            m4661b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        long a3 = mutableFlatBuffer.a(i, 8, 0);
        if (a3 != 0) {
            jsonGenerator.a("created_time");
            jsonGenerator.a(a3);
        }
        a = mutableFlatBuffer.g(i, 9);
        if (a != 0) {
            jsonGenerator.a("edit_history");
            GraphQLEditHistoryConnectionDeserializer.m4723a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.g(i, 10);
        if (a != 0) {
            jsonGenerator.a("feedback");
            GraphQLFeedbackDeserializer.m4895b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 11) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 11));
        }
        a = mutableFlatBuffer.g(i, 12);
        if (a != 0) {
            jsonGenerator.a("interesting_replies");
            GraphQLInterestingRepliesConnectionDeserializer.m5276a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a2 = mutableFlatBuffer.a(i, 13);
        if (a2) {
            jsonGenerator.a("is_featured");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 14);
        if (a2) {
            jsonGenerator.a("is_marked_as_spam");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 15);
        if (a2) {
            jsonGenerator.a("is_pinned");
            jsonGenerator.a(a2);
        }
        a = mutableFlatBuffer.g(i, 16);
        if (a != 0) {
            jsonGenerator.a("multiShareAttachmentWithImageFields");
            GraphQLStoryAttachmentDeserializer.m5955a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.g(i, 17);
        if (a != 0) {
            jsonGenerator.a("permalink_title");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.g(i, 18);
        if (a != 0) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScopeDeserializer.m5707a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.g(i, 19);
        if (a != 0) {
            jsonGenerator.a("private_reply_context");
            GraphQLPrivateReplyContextDeserializer.m5710a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 20) != 0) {
            jsonGenerator.a("request_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 20));
        }
        a = mutableFlatBuffer.a(i, 21, 0);
        if (a != 0) {
            jsonGenerator.a("sort_key");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.g(i, 22);
        if (a != 0) {
            jsonGenerator.a("translatability_for_viewer");
            GraphQLPostTranslatabilityDeserializer.m5684a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.g(i, 23);
        if (a != 0) {
            jsonGenerator.a("translated_body_for_viewer");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 24) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 24));
        }
        a = mutableFlatBuffer.a(i, 25, 0);
        if (a != 0) {
            jsonGenerator.a("timestamp_in_video");
            jsonGenerator.b(a);
        }
        a2 = mutableFlatBuffer.a(i, 26);
        if (a2) {
            jsonGenerator.a("written_while_video_was_live");
            jsonGenerator.a(a2);
        }
        a = mutableFlatBuffer.g(i, 27);
        if (a != 0) {
            jsonGenerator.a("parent_feedback");
            GraphQLFeedbackDeserializer.m4895b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.g(i, 28);
        if (a != 0) {
            jsonGenerator.a("body_markdown_html");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }
}

package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: offsetX */
public class GraphQLNoteDeserializer {
    public static int m5441a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[26];
        boolean[] zArr = new boolean[3];
        boolean[] zArr2 = new boolean[1];
        long[] jArr = new long[1];
        Enum[] enumArr = new Enum[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("blurredCoverPhoto")) {
                    iArr[0] = GraphQLFocusedPhotoDeserializer.m4919a(jsonParser, flatBufferBuilder);
                } else if (i.equals("cover_photo")) {
                    iArr[1] = GraphQLFocusedPhotoDeserializer.m4919a(jsonParser, flatBufferBuilder);
                } else if (i.equals("created_time")) {
                    zArr[0] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("feedback")) {
                    iArr[3] = GraphQLFeedbackDeserializer.m4892a(jsonParser, flatBufferBuilder);
                } else if (i.equals("id")) {
                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("plain_body")) {
                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("privacy_scope")) {
                    iArr[6] = GraphQLPrivacyScopeDeserializer.m5705a(jsonParser, flatBufferBuilder);
                } else if (i.equals("published_document")) {
                    iArr[7] = GraphQLComposedDocumentDeserializer.m4668a(jsonParser, flatBufferBuilder);
                } else if (i.equals("subject")) {
                    iArr[8] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("url")) {
                    iArr[9] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("from")) {
                    iArr[10] = GraphQLActorDeserializer.m4517a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feedAwesomizerProfilePicture")) {
                    iArr[11] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageHighOrig")) {
                    iArr[12] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("inline_activities")) {
                    iArr[13] = GraphQLInlineActivitiesConnectionDeserializer.m5244a(jsonParser, flatBufferBuilder);
                } else if (i.equals("name")) {
                    iArr[14] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("profileImageLarge")) {
                    iArr[15] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profileImageSmall")) {
                    iArr[16] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePicture50")) {
                    iArr[17] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePictureHighRes")) {
                    iArr[18] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePictureLarge")) {
                    iArr[19] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_photo")) {
                    iArr[20] = GraphQLPhotoDeserializer.m5601a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture")) {
                    iArr[21] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture_is_silhouette")) {
                    zArr[1] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("streaming_profile_picture")) {
                    iArr[23] = GraphQLStreamingImageDeserializer.m5991a(jsonParser, flatBufferBuilder);
                } else if (i.equals("taggable_object_profile_picture")) {
                    iArr[24] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_saved_state")) {
                    zArr[2] = true;
                    enumArr[0] = GraphQLSavedState.fromString(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(26);
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
        flatBufferBuilder.b(17, iArr[17]);
        flatBufferBuilder.b(18, iArr[18]);
        flatBufferBuilder.b(19, iArr[19]);
        flatBufferBuilder.b(20, iArr[20]);
        flatBufferBuilder.b(21, iArr[21]);
        if (zArr[1]) {
            flatBufferBuilder.a(22, zArr2[0]);
        }
        flatBufferBuilder.b(23, iArr[23]);
        flatBufferBuilder.b(24, iArr[24]);
        if (zArr[2]) {
            flatBufferBuilder.a(25, enumArr[0]);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5442a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5441a(jsonParser, flatBufferBuilder);
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

    public static void m5443a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("blurredCoverPhoto");
            GraphQLFocusedPhotoDeserializer.m4921a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("cover_photo");
            GraphQLFocusedPhotoDeserializer.m4921a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        long a = mutableFlatBuffer.a(i, 2, 0);
        if (a != 0) {
            jsonGenerator.a("created_time");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("feedback");
            GraphQLFeedbackDeserializer.m4895b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 4) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("plain_body");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        g = mutableFlatBuffer.g(i, 6);
        if (g != 0) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScopeDeserializer.m5707a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 7);
        if (g != 0) {
            jsonGenerator.a("published_document");
            GraphQLComposedDocumentDeserializer.m4670a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 8) != 0) {
            jsonGenerator.a("subject");
            jsonGenerator.b(mutableFlatBuffer.c(i, 8));
        }
        if (mutableFlatBuffer.g(i, 9) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 9));
        }
        g = mutableFlatBuffer.g(i, 10);
        if (g != 0) {
            jsonGenerator.a("from");
            GraphQLActorDeserializer.m4521b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 11);
        if (g != 0) {
            jsonGenerator.a("feedAwesomizerProfilePicture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 12);
        if (g != 0) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 13);
        if (g != 0) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnectionDeserializer.m5246a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 14) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 14));
        }
        g = mutableFlatBuffer.g(i, 15);
        if (g != 0) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 16);
        if (g != 0) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 17);
        if (g != 0) {
            jsonGenerator.a("profilePicture50");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 18);
        if (g != 0) {
            jsonGenerator.a("profilePictureHighRes");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 19);
        if (g != 0) {
            jsonGenerator.a("profilePictureLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 20);
        if (g != 0) {
            jsonGenerator.a("profile_photo");
            GraphQLPhotoDeserializer.m5605b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 21);
        if (g != 0) {
            jsonGenerator.a("profile_picture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        boolean a2 = mutableFlatBuffer.a(i, 22);
        if (a2) {
            jsonGenerator.a("profile_picture_is_silhouette");
            jsonGenerator.a(a2);
        }
        g = mutableFlatBuffer.g(i, 23);
        if (g != 0) {
            jsonGenerator.a("streaming_profile_picture");
            GraphQLStreamingImageDeserializer.m5993a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 24);
        if (g != 0) {
            jsonGenerator.a("taggable_object_profile_picture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 25, (short) 0) != (short) 0) {
            jsonGenerator.a("viewer_saved_state");
            jsonGenerator.b(((GraphQLSavedState) mutableFlatBuffer.a(i, 25, GraphQLSavedState.class)).name());
        }
        jsonGenerator.g();
    }
}

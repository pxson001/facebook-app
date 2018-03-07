package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: photos_grid */
public class GraphQLCarrierUpsellPromotionDeserializer {
    public static int m4637a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[23];
        boolean[] zArr = new boolean[3];
        boolean[] zArr2 = new boolean[2];
        double[] dArr = new double[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("action_text")) {
                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("code")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("feedAwesomizerProfilePicture")) {
                    iArr[2] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("full_price")) {
                    zArr[0] = true;
                    dArr[0] = jsonParser.G();
                } else if (i.equals("id")) {
                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("imageHighOrig")) {
                    iArr[5] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("inline_activities")) {
                    iArr[6] = GraphQLInlineActivitiesConnectionDeserializer.m5244a(jsonParser, flatBufferBuilder);
                } else if (i.equals("is_loan")) {
                    zArr[1] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("name")) {
                    iArr[8] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("profileImageLarge")) {
                    iArr[9] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profileImageSmall")) {
                    iArr[10] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePicture50")) {
                    iArr[11] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePictureHighRes")) {
                    iArr[12] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePictureLarge")) {
                    iArr[13] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_photo")) {
                    iArr[14] = GraphQLPhotoDeserializer.m5601a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture")) {
                    iArr[15] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture_is_silhouette")) {
                    zArr[2] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("streaming_profile_picture")) {
                    iArr[18] = GraphQLStreamingImageDeserializer.m5991a(jsonParser, flatBufferBuilder);
                } else if (i.equals("taggable_object_profile_picture")) {
                    iArr[19] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("title")) {
                    iArr[20] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("titleForSummary")) {
                    iArr[21] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("url")) {
                    iArr[22] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(23);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        if (zArr[0]) {
            flatBufferBuilder.a(3, dArr[0], 0.0d);
        }
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        if (zArr[1]) {
            flatBufferBuilder.a(7, zArr2[0]);
        }
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        flatBufferBuilder.b(12, iArr[12]);
        flatBufferBuilder.b(13, iArr[13]);
        flatBufferBuilder.b(14, iArr[14]);
        flatBufferBuilder.b(15, iArr[15]);
        if (zArr[2]) {
            flatBufferBuilder.a(16, zArr2[1]);
        }
        flatBufferBuilder.b(18, iArr[18]);
        flatBufferBuilder.b(19, iArr[19]);
        flatBufferBuilder.b(20, iArr[20]);
        flatBufferBuilder.b(21, iArr[21]);
        flatBufferBuilder.b(22, iArr[22]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4638a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4637a(jsonParser, flatBufferBuilder);
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

    public static void m4639a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("action_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("code");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        int g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("feedAwesomizerProfilePicture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        double a = mutableFlatBuffer.a(i, 3, 0.0d);
        if (a != 0.0d) {
            jsonGenerator.a("full_price");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 4) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
        }
        g = mutableFlatBuffer.g(i, 5);
        if (g != 0) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 6);
        if (g != 0) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnectionDeserializer.m5246a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        boolean a2 = mutableFlatBuffer.a(i, 7);
        if (a2) {
            jsonGenerator.a("is_loan");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.g(i, 8) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 8));
        }
        g = mutableFlatBuffer.g(i, 9);
        if (g != 0) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 10);
        if (g != 0) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 11);
        if (g != 0) {
            jsonGenerator.a("profilePicture50");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 12);
        if (g != 0) {
            jsonGenerator.a("profilePictureHighRes");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 13);
        if (g != 0) {
            jsonGenerator.a("profilePictureLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 14);
        if (g != 0) {
            jsonGenerator.a("profile_photo");
            GraphQLPhotoDeserializer.m5605b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 15);
        if (g != 0) {
            jsonGenerator.a("profile_picture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        a2 = mutableFlatBuffer.a(i, 16);
        if (a2) {
            jsonGenerator.a("profile_picture_is_silhouette");
            jsonGenerator.a(a2);
        }
        g = mutableFlatBuffer.g(i, 18);
        if (g != 0) {
            jsonGenerator.a("streaming_profile_picture");
            GraphQLStreamingImageDeserializer.m5993a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 19);
        if (g != 0) {
            jsonGenerator.a("taggable_object_profile_picture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
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
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 22));
        }
        jsonGenerator.g();
    }
}

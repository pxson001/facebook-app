package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: pair_search */
public class GraphQLExploreFeedDeserializer {
    public static int m4861a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[25];
        boolean[] zArr = new boolean[13];
        boolean[] zArr2 = new boolean[10];
        int[] iArr2 = new int[3];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("customizable")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("disabled_favorite_icon")) {
                    iArr[1] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("enabled_favorite_icon")) {
                    iArr[2] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("header_image")) {
                    iArr[3] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("id")) {
                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("is_favorited")) {
                    zArr[1] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("live_video_count")) {
                    zArr[2] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("name")) {
                    iArr[8] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("searchable")) {
                    zArr[3] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("square_header_image")) {
                    iArr[10] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("url")) {
                    iArr[11] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("video_channel_can_viewer_follow")) {
                    zArr[4] = true;
                    zArr2[3] = jsonParser.H();
                } else if (i.equals("video_channel_can_viewer_pin")) {
                    zArr[5] = true;
                    zArr2[4] = jsonParser.H();
                } else if (i.equals("video_channel_can_viewer_subscribe")) {
                    zArr[6] = true;
                    zArr2[5] = jsonParser.H();
                } else if (i.equals("video_channel_curator_profile")) {
                    iArr[15] = GraphQLProfileDeserializer.m5717a(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_channel_has_new")) {
                    zArr[7] = true;
                    zArr2[6] = jsonParser.H();
                } else if (i.equals("video_channel_has_viewer_subscribed")) {
                    zArr[8] = true;
                    zArr2[7] = jsonParser.H();
                } else if (i.equals("video_channel_is_viewer_following")) {
                    zArr[9] = true;
                    zArr2[8] = jsonParser.H();
                } else if (i.equals("video_channel_is_viewer_pinned")) {
                    zArr[10] = true;
                    zArr2[9] = jsonParser.H();
                } else if (i.equals("video_channel_max_new_count")) {
                    zArr[11] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("video_channel_new_count")) {
                    zArr[12] = true;
                    iArr2[2] = jsonParser.E();
                } else if (i.equals("video_channel_subtitle")) {
                    iArr[22] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_channel_title")) {
                    iArr[23] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("composer_placeholder_text")) {
                    iArr[24] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(25);
        if (zArr[0]) {
            flatBufferBuilder.a(0, zArr2[0]);
        }
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(5, iArr[5]);
        if (zArr[1]) {
            flatBufferBuilder.a(6, zArr2[1]);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(7, iArr2[0], 0);
        }
        flatBufferBuilder.b(8, iArr[8]);
        if (zArr[3]) {
            flatBufferBuilder.a(9, zArr2[2]);
        }
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        if (zArr[4]) {
            flatBufferBuilder.a(12, zArr2[3]);
        }
        if (zArr[5]) {
            flatBufferBuilder.a(13, zArr2[4]);
        }
        if (zArr[6]) {
            flatBufferBuilder.a(14, zArr2[5]);
        }
        flatBufferBuilder.b(15, iArr[15]);
        if (zArr[7]) {
            flatBufferBuilder.a(16, zArr2[6]);
        }
        if (zArr[8]) {
            flatBufferBuilder.a(17, zArr2[7]);
        }
        if (zArr[9]) {
            flatBufferBuilder.a(18, zArr2[8]);
        }
        if (zArr[10]) {
            flatBufferBuilder.a(19, zArr2[9]);
        }
        if (zArr[11]) {
            flatBufferBuilder.a(20, iArr2[1], 0);
        }
        if (zArr[12]) {
            flatBufferBuilder.a(21, iArr2[2], 0);
        }
        flatBufferBuilder.b(22, iArr[22]);
        flatBufferBuilder.b(23, iArr[23]);
        flatBufferBuilder.b(24, iArr[24]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4862a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4861a(jsonParser, flatBufferBuilder);
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

    public static void m4863b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        boolean a = mutableFlatBuffer.a(i, 0);
        if (a) {
            jsonGenerator.a("customizable");
            jsonGenerator.a(a);
        }
        int g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("disabled_favorite_icon");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("enabled_favorite_icon");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("header_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        a = mutableFlatBuffer.a(i, 6);
        if (a) {
            jsonGenerator.a("is_favorited");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.a(i, 7, 0);
        if (g != 0) {
            jsonGenerator.a("live_video_count");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 8) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 8));
        }
        a = mutableFlatBuffer.a(i, 9);
        if (a) {
            jsonGenerator.a("searchable");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 10);
        if (g != 0) {
            jsonGenerator.a("square_header_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 11) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 11));
        }
        a = mutableFlatBuffer.a(i, 12);
        if (a) {
            jsonGenerator.a("video_channel_can_viewer_follow");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 13);
        if (a) {
            jsonGenerator.a("video_channel_can_viewer_pin");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 14);
        if (a) {
            jsonGenerator.a("video_channel_can_viewer_subscribe");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 15);
        if (g != 0) {
            jsonGenerator.a("video_channel_curator_profile");
            GraphQLProfileDeserializer.m5721b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 16);
        if (a) {
            jsonGenerator.a("video_channel_has_new");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 17);
        if (a) {
            jsonGenerator.a("video_channel_has_viewer_subscribed");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 18);
        if (a) {
            jsonGenerator.a("video_channel_is_viewer_following");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 19);
        if (a) {
            jsonGenerator.a("video_channel_is_viewer_pinned");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.a(i, 20, 0);
        if (g != 0) {
            jsonGenerator.a("video_channel_max_new_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 21, 0);
        if (g != 0) {
            jsonGenerator.a("video_channel_new_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 22);
        if (g != 0) {
            jsonGenerator.a("video_channel_subtitle");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 23);
        if (g != 0) {
            jsonGenerator.a("video_channel_title");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 24) != 0) {
            jsonGenerator.a("composer_placeholder_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 24));
        }
        jsonGenerator.g();
    }
}

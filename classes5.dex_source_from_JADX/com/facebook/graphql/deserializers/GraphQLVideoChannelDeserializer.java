package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: messenger_entry_chat_head */
public class GraphQLVideoChannelDeserializer {
    public static int m6176a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[18];
        boolean[] zArr = new boolean[11];
        boolean[] zArr2 = new boolean[7];
        int[] iArr2 = new int[3];
        Enum[] enumArr = new Enum[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("__type__")) {
                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser).e());
                } else if (i.equals("id")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("live_video_count")) {
                    zArr[0] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("square_header_image")) {
                    iArr[3] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_channel_can_viewer_follow")) {
                    zArr[1] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("video_channel_can_viewer_pin")) {
                    zArr[2] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("video_channel_can_viewer_subscribe")) {
                    zArr[3] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("video_channel_curator_profile")) {
                    iArr[7] = GraphQLProfileDeserializer.m5717a(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_channel_has_new")) {
                    zArr[4] = true;
                    zArr2[3] = jsonParser.H();
                } else if (i.equals("video_channel_has_viewer_subscribed")) {
                    zArr[5] = true;
                    zArr2[4] = jsonParser.H();
                } else if (i.equals("video_channel_is_viewer_following")) {
                    zArr[6] = true;
                    zArr2[5] = jsonParser.H();
                } else if (i.equals("video_channel_is_viewer_pinned")) {
                    zArr[7] = true;
                    zArr2[6] = jsonParser.H();
                } else if (i.equals("video_channel_max_new_count")) {
                    zArr[8] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("video_channel_new_count")) {
                    zArr[9] = true;
                    iArr2[2] = jsonParser.E();
                } else if (i.equals("video_channel_subtitle")) {
                    iArr[14] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_channel_title")) {
                    iArr[15] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("page_likers")) {
                    iArr[16] = GraphQLPageLikersConnectionDeserializer.m5509a(jsonParser, flatBufferBuilder);
                } else if (i.equals("subscribe_status")) {
                    zArr[10] = true;
                    enumArr[0] = GraphQLSubscribeStatus.fromString(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(18);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        if (zArr[0]) {
            flatBufferBuilder.a(2, iArr2[0], 0);
        }
        flatBufferBuilder.b(3, iArr[3]);
        if (zArr[1]) {
            flatBufferBuilder.a(4, zArr2[0]);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(5, zArr2[1]);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(6, zArr2[2]);
        }
        flatBufferBuilder.b(7, iArr[7]);
        if (zArr[4]) {
            flatBufferBuilder.a(8, zArr2[3]);
        }
        if (zArr[5]) {
            flatBufferBuilder.a(9, zArr2[4]);
        }
        if (zArr[6]) {
            flatBufferBuilder.a(10, zArr2[5]);
        }
        if (zArr[7]) {
            flatBufferBuilder.a(11, zArr2[6]);
        }
        if (zArr[8]) {
            flatBufferBuilder.a(12, iArr2[1], 0);
        }
        if (zArr[9]) {
            flatBufferBuilder.a(13, iArr2[2], 0);
        }
        flatBufferBuilder.b(14, iArr[14]);
        flatBufferBuilder.b(15, iArr[15]);
        flatBufferBuilder.b(16, iArr[16]);
        if (zArr[10]) {
            flatBufferBuilder.a(17, enumArr[0]);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m6177a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m6176a(jsonParser, flatBufferBuilder);
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

    public static void m6178a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("__type__");
            SerializerHelpers.a(mutableFlatBuffer, i, 0, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        int a = mutableFlatBuffer.a(i, 2, 0);
        if (a != 0) {
            jsonGenerator.a("live_video_count");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.g(i, 3);
        if (a != 0) {
            jsonGenerator.a("square_header_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, a, jsonGenerator);
        }
        boolean a2 = mutableFlatBuffer.a(i, 4);
        if (a2) {
            jsonGenerator.a("video_channel_can_viewer_follow");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 5);
        if (a2) {
            jsonGenerator.a("video_channel_can_viewer_pin");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 6);
        if (a2) {
            jsonGenerator.a("video_channel_can_viewer_subscribe");
            jsonGenerator.a(a2);
        }
        a = mutableFlatBuffer.g(i, 7);
        if (a != 0) {
            jsonGenerator.a("video_channel_curator_profile");
            GraphQLProfileDeserializer.m5721b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a2 = mutableFlatBuffer.a(i, 8);
        if (a2) {
            jsonGenerator.a("video_channel_has_new");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 9);
        if (a2) {
            jsonGenerator.a("video_channel_has_viewer_subscribed");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 10);
        if (a2) {
            jsonGenerator.a("video_channel_is_viewer_following");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 11);
        if (a2) {
            jsonGenerator.a("video_channel_is_viewer_pinned");
            jsonGenerator.a(a2);
        }
        a = mutableFlatBuffer.a(i, 12, 0);
        if (a != 0) {
            jsonGenerator.a("video_channel_max_new_count");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.a(i, 13, 0);
        if (a != 0) {
            jsonGenerator.a("video_channel_new_count");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.g(i, 14);
        if (a != 0) {
            jsonGenerator.a("video_channel_subtitle");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.g(i, 15);
        if (a != 0) {
            jsonGenerator.a("video_channel_title");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.g(i, 16);
        if (a != 0) {
            jsonGenerator.a("page_likers");
            GraphQLPageLikersConnectionDeserializer.m5511a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 17, (short) 0) != (short) 0) {
            jsonGenerator.a("subscribe_status");
            jsonGenerator.b(((GraphQLSubscribeStatus) mutableFlatBuffer.a(i, 17, GraphQLSubscribeStatus.class)).name());
        }
        jsonGenerator.g();
    }
}
